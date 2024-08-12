// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.core.TypeManager
import godot.core.VariantType.NIL
import godot.core.VariantType.VECTOR2
import godot.core.Vector2
import godot.core.memory.TransferContext
import godot.util.VoidPtr
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit

/**
 * A ParallaxLayer must be the child of a [ParallaxBackground] node. Each ParallaxLayer can be set
 * to move at different speeds relative to the camera movement or the [ParallaxBackground.scrollOffset]
 * value.
 * This node's children will be affected by its scroll offset.
 * **Note:** Any changes to this node's position and scale made after it enters the scene will be
 * ignored.
 */
@GodotBaseType
public open class ParallaxLayer : Node2D() {
  /**
   * Multiplies the ParallaxLayer's motion. If an axis is set to `0`, it will not scroll.
   */
  @CoreTypeLocalCopy
  public var motionScale: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getMotionScalePtr, VECTOR2)
      return (TransferContext.readReturnValue(VECTOR2, false) as Vector2)
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, MethodBindings.setMotionScalePtr, NIL)
    }

  /**
   * The ParallaxLayer's offset relative to the parent ParallaxBackground's
   * [ParallaxBackground.scrollOffset].
   */
  @CoreTypeLocalCopy
  public var motionOffset: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getMotionOffsetPtr, VECTOR2)
      return (TransferContext.readReturnValue(VECTOR2, false) as Vector2)
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, MethodBindings.setMotionOffsetPtr, NIL)
    }

  /**
   * The interval, in pixels, at which the [ParallaxLayer] is drawn repeatedly. Useful for creating
   * an infinitely scrolling background. If an axis is set to `0`, the [ParallaxLayer] will be drawn
   * only once along that direction.
   * **Note:** If you want the repetition to pixel-perfect match a [Texture2D] displayed by a child
   * node, you should account for any scale applied to the texture when defining this interval. For
   * example, if you use a child [Sprite2D] scaled to `0.5` to display a 600x600 texture, and want this
   * sprite to be repeated continuously horizontally, you should set the mirroring to `Vector2(300,
   * 0)`.
   * **Note:** If the length of the viewport axis is bigger than twice the repeated axis size, it
   * will not repeat infinitely, as the parallax layer only draws 2 instances of the layer at any given
   * time. The visibility window is calculated from the parent [ParallaxBackground]'s position, not the
   * layer's own position. So, if you use mirroring, **do not** change the [ParallaxLayer] position
   * relative to its parent. Instead, if you need to adjust the background's position, set the
   * [CanvasLayer.offset] property in the parent [ParallaxBackground].
   * **Note:** Despite the name, the layer will not be mirrored, it will only be repeated.
   */
  @CoreTypeLocalCopy
  public var motionMirroring: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getMirroringPtr, VECTOR2)
      return (TransferContext.readReturnValue(VECTOR2, false) as Vector2)
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, MethodBindings.setMirroringPtr, NIL)
    }

  public override fun new(scriptIndex: Int): Boolean {
    callConstructor(ENGINECLASS_PARALLAXLAYER, scriptIndex)
    return true
  }

  /**
   * Multiplies the ParallaxLayer's motion. If an axis is set to `0`, it will not scroll.
   *
   * This is a helper function to make dealing with local copies easier. 
   *
   * For more information, see our
   * [documentation](https://godot-kotl.in/en/stable/user-guide/api-differences/#core-types).
   *
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionScale
   * //Your changes
   * parallaxlayer.motionScale = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public open fun motionScaleMutate(block: Vector2.() -> Unit): Vector2 = motionScale.apply{
      block(this)
      motionScale = this
  }


  /**
   * The ParallaxLayer's offset relative to the parent ParallaxBackground's
   * [ParallaxBackground.scrollOffset].
   *
   * This is a helper function to make dealing with local copies easier. 
   *
   * For more information, see our
   * [documentation](https://godot-kotl.in/en/stable/user-guide/api-differences/#core-types).
   *
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionOffset
   * //Your changes
   * parallaxlayer.motionOffset = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public open fun motionOffsetMutate(block: Vector2.() -> Unit): Vector2 = motionOffset.apply{
      block(this)
      motionOffset = this
  }


  /**
   * The interval, in pixels, at which the [ParallaxLayer] is drawn repeatedly. Useful for creating
   * an infinitely scrolling background. If an axis is set to `0`, the [ParallaxLayer] will be drawn
   * only once along that direction.
   * **Note:** If you want the repetition to pixel-perfect match a [Texture2D] displayed by a child
   * node, you should account for any scale applied to the texture when defining this interval. For
   * example, if you use a child [Sprite2D] scaled to `0.5` to display a 600x600 texture, and want this
   * sprite to be repeated continuously horizontally, you should set the mirroring to `Vector2(300,
   * 0)`.
   * **Note:** If the length of the viewport axis is bigger than twice the repeated axis size, it
   * will not repeat infinitely, as the parallax layer only draws 2 instances of the layer at any given
   * time. The visibility window is calculated from the parent [ParallaxBackground]'s position, not the
   * layer's own position. So, if you use mirroring, **do not** change the [ParallaxLayer] position
   * relative to its parent. Instead, if you need to adjust the background's position, set the
   * [CanvasLayer.offset] property in the parent [ParallaxBackground].
   * **Note:** Despite the name, the layer will not be mirrored, it will only be repeated.
   *
   * This is a helper function to make dealing with local copies easier. 
   *
   * For more information, see our
   * [documentation](https://godot-kotl.in/en/stable/user-guide/api-differences/#core-types).
   *
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionMirroring
   * //Your changes
   * parallaxlayer.motionMirroring = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public open fun motionMirroringMutate(block: Vector2.() -> Unit): Vector2 = motionMirroring.apply{
      block(this)
      motionMirroring = this
  }


  public companion object

  internal object MethodBindings {
    public val setMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_motion_scale")

    public val getMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_motion_scale")

    public val setMotionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_motion_offset")

    public val getMotionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_motion_offset")

    public val setMirroringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_mirroring")

    public val getMirroringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_mirroring")
  }
}
