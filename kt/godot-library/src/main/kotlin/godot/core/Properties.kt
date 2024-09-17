package godot.core

import godot.PropertyHint
import godot.PropertyUsageFlags
import godot.core.memory.TransferContext
import godot.global.GD
import kotlin.reflect.KMutableProperty1

data class KtPropertyInfo(
    val _type: VariantConverter,
    val name: String,
    val className: String,
    val _hint: PropertyHint,
    val hintString: String,
    val usage: Long = if (_type === VariantCaster.ANY) {
        PropertyUsageFlags.PROPERTY_USAGE_NIL_IS_VARIANT.flag
    } else {
        PropertyUsageFlags.PROPERTY_USAGE_NONE.flag
    }
) {
    val type: Int
        get() = _type.id

    val hint: Int
        get() = _hint.id.toInt()
}

open class KtProperty<T : KtObject, P : Any?>(
    val ktPropertyInfo: KtPropertyInfo,
    protected val kProperty: KMutableProperty1<T, P>,
    protected val variantConverter: VariantConverter,
) {
    open fun callGet(instance: T) {
        try {
            TransferContext.writeReturnValue(kProperty.get(instance), variantConverter)
        } catch (t: Throwable) {
            GD.printErr("Error calling a JVM getter from Godot:", t.stackTraceToString())
            TransferContext.writeReturnValue(null, VariantType.NIL)
        }
    }

    open fun callSet(instance: T) {
        val arg = extractSetterArgument<P>()
        try {
            kProperty.set(instance, arg)
        } catch (t: Throwable) {
            GD.printErr("Error calling a JVM setter from Godot:", t.stackTraceToString())
        }
    }

    protected fun <P> extractSetterArgument(): P {
        //TODO: manage nullable argument of enum setter (only for objects)
        val arg = TransferContext.readSingleArgument(variantConverter)
        @Suppress("UNCHECKED_CAST")
        return arg as P
    }
}

class KtEnumProperty<T : KtObject, P : Any>(
    ktPropertyInfo: KtPropertyInfo,
    kProperty: KMutableProperty1<T, P>,
    val getValueConverter: (P?) -> Int,
    val setValueConverter: (Int) -> P
) : KtProperty<T, P>(
    ktPropertyInfo,
    kProperty,
    VariantCaster.INT
) {
    override fun callGet(instance: T) {
        TransferContext.writeReturnValue(getValueConverter(kProperty.get(instance)), VariantCaster.INT)
    }

    override fun callSet(instance: T) {
        val arg = extractSetterArgument<Int>()
        kProperty.set(instance, setValueConverter(arg))
    }
}

class KtEnumListProperty<T : KtObject, P : Enum<P>, L : Collection<P>>(
    ktPropertyInfo: KtPropertyInfo,
    kProperty: KMutableProperty1<T, L>,
    val getValueConverter: (L?) -> VariantArray<Int>,
    val setValueConverter: (VariantArray<Int>) -> L
) : KtProperty<T, L>(
    ktPropertyInfo,
    kProperty,
    VariantType.ARRAY
) {
    override fun callGet(instance: T) {
        TransferContext.writeReturnValue(getValueConverter(kProperty.get(instance)), VariantType.ARRAY)
    }

    override fun callSet(instance: T) {
        val arg = extractSetterArgument<VariantArray<Int>>()
        kProperty.set(instance, setValueConverter(arg))
    }
}

