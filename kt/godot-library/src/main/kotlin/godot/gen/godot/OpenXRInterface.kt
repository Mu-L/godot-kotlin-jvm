// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.Quaternion
import godot.core.TypeManager
import godot.core.VariantArray
import godot.core.VariantType.ARRAY
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.QUATERNION
import godot.core.VariantType.STRING
import godot.core.VariantType.VECTOR3
import godot.core.Vector3
import godot.core.memory.TransferContext
import godot.signals.Signal0
import godot.signals.signal
import godot.util.VoidPtr
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

/**
 * The OpenXR interface allows Godot to interact with OpenXR runtimes and make it possible to create
 * XR experiences and games.
 * Due to the needs of OpenXR this interface works slightly different than other plugin based XR
 * interfaces. It needs to be initialized when Godot starts. You need to enable OpenXR, settings for
 * this can be found in your games project settings under the XR heading. You do need to mark a
 * viewport for use with XR in order for Godot to know which render result should be output to the
 * headset.
 */
@GodotBaseType
public open class OpenXRInterface : XRInterface() {
  /**
   * Informs our OpenXR session has been started.
   */
  public val sessionBegun: Signal0 by signal()

  /**
   * Informs our OpenXR session is stopping.
   */
  public val sessionStopping: Signal0 by signal()

  /**
   * Informs our OpenXR session now has focus.
   */
  public val sessionFocussed: Signal0 by signal()

  /**
   * Informs our OpenXR session is now visible (output is being sent to the HMD).
   */
  public val sessionVisible: Signal0 by signal()

  /**
   * Informs the user queued a recenter of the player position.
   */
  public val poseRecentered: Signal0 by signal()

  /**
   * The display refresh rate for the current HMD. Only functional if this feature is supported by
   * the OpenXR runtime and after the interface has been initialized.
   */
  public var displayRefreshRate: Float
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getDisplayRefreshRatePtr, DOUBLE)
      return (TransferContext.readReturnValue(DOUBLE, false) as Double).toFloat()
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value.toDouble())
      TransferContext.callMethod(rawPtr, MethodBindings.setDisplayRefreshRatePtr, NIL)
    }

  /**
   * The render size multiplier for the current HMD. Must be set before the interface has been
   * initialized.
   */
  public var renderTargetSizeMultiplier: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getRenderTargetSizeMultiplierPtr, DOUBLE)
      return (TransferContext.readReturnValue(DOUBLE, false) as Double)
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, MethodBindings.setRenderTargetSizeMultiplierPtr, NIL)
    }

  /**
   * Set foveation level from 0 (off) to 3 (high), the interface must be initialized before this is
   * accessible.
   */
  public var foveationLevel: Int
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getFoveationLevelPtr, LONG)
      return (TransferContext.readReturnValue(LONG, false) as Long).toInt()
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value.toLong())
      TransferContext.callMethod(rawPtr, MethodBindings.setFoveationLevelPtr, NIL)
    }

  /**
   * Enable dynamic foveation adjustment, the interface must be initialized before this is
   * accessible. If enabled foveation will automatically adjusted between low and [foveationLevel].
   */
  public var foveationDynamic: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, MethodBindings.getFoveationDynamicPtr, BOOL)
      return (TransferContext.readReturnValue(BOOL, false) as Boolean)
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, MethodBindings.setFoveationDynamicPtr, NIL)
    }

  public override fun new(scriptIndex: Int): Boolean {
    callConstructor(ENGINECLASS_OPENXRINTERFACE, scriptIndex)
    return true
  }

  /**
   * Returns `true` if OpenXR's foveation extension is supported, the interface must be initialized
   * before this returns a valid value.
   * **Note:** This feature is only available on the compatibility renderer and currently only
   * available on some stand alone headsets. For Vulkan set [Viewport.vrsMode] to `VRS_XR` on desktop.
   */
  public fun isFoveationSupported(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, MethodBindings.isFoveationSupportedPtr, BOOL)
    return (TransferContext.readReturnValue(BOOL, false) as Boolean)
  }

  /**
   * Returns `true` if the given action set is active.
   */
  public fun isActionSetActive(name: String): Boolean {
    TransferContext.writeArguments(STRING to name)
    TransferContext.callMethod(rawPtr, MethodBindings.isActionSetActivePtr, BOOL)
    return (TransferContext.readReturnValue(BOOL, false) as Boolean)
  }

  /**
   * Sets the given action set as active or inactive.
   */
  public fun setActionSetActive(name: String, active: Boolean): Unit {
    TransferContext.writeArguments(STRING to name, BOOL to active)
    TransferContext.callMethod(rawPtr, MethodBindings.setActionSetActivePtr, NIL)
  }

  /**
   * Returns a list of action sets registered with Godot (loaded from the action map at runtime).
   */
  public fun getActionSets(): VariantArray<Any?> {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, MethodBindings.getActionSetsPtr, ARRAY)
    return (TransferContext.readReturnValue(ARRAY, false) as VariantArray<Any?>)
  }

  /**
   * Returns display refresh rates supported by the current HMD. Only returned if this feature is
   * supported by the OpenXR runtime and after the interface has been initialized.
   */
  public fun getAvailableDisplayRefreshRates(): VariantArray<Any?> {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, MethodBindings.getAvailableDisplayRefreshRatesPtr, ARRAY)
    return (TransferContext.readReturnValue(ARRAY, false) as VariantArray<Any?>)
  }

  /**
   * If handtracking is enabled and motion range is supported, sets the currently configured motion
   * range for [hand] to [motionRange].
   */
  public fun setMotionRange(hand: Hand, motionRange: HandMotionRange): Unit {
    TransferContext.writeArguments(LONG to hand.id, LONG to motionRange.id)
    TransferContext.callMethod(rawPtr, MethodBindings.setMotionRangePtr, NIL)
  }

  /**
   * If handtracking is enabled and motion range is supported, gets the currently configured motion
   * range for [hand].
   */
  public fun getMotionRange(hand: Hand): HandMotionRange {
    TransferContext.writeArguments(LONG to hand.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getMotionRangePtr, LONG)
    return OpenXRInterface.HandMotionRange.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If handtracking is enabled, returns flags that inform us of the validity of the tracking data.
   */
  public fun getHandJointFlags(hand: Hand, joint: HandJoints): HandJointFlags {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointFlagsPtr, LONG)
    return HandJointFlagsValue(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If handtracking is enabled, returns the rotation of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR.
   */
  public fun getHandJointRotation(hand: Hand, joint: HandJoints): Quaternion {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointRotationPtr, QUATERNION)
    return (TransferContext.readReturnValue(QUATERNION, false) as Quaternion)
  }

  /**
   * If handtracking is enabled, returns the position of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR. This is relative to [XROrigin3D] without worldscale applied!
   */
  public fun getHandJointPosition(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointPositionPtr, VECTOR3)
    return (TransferContext.readReturnValue(VECTOR3, false) as Vector3)
  }

  /**
   * If handtracking is enabled, returns the radius of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR. This is without worldscale applied!
   */
  public fun getHandJointRadius(hand: Hand, joint: HandJoints): Float {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointRadiusPtr, DOUBLE)
    return (TransferContext.readReturnValue(DOUBLE, false) as Double).toFloat()
  }

  /**
   * If handtracking is enabled, returns the linear velocity of a joint ([joint]) of a hand ([hand])
   * as provided by OpenXR. This is relative to [XROrigin3D] without worldscale applied!
   */
  public fun getHandJointLinearVelocity(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointLinearVelocityPtr, VECTOR3)
    return (TransferContext.readReturnValue(VECTOR3, false) as Vector3)
  }

  /**
   * If handtracking is enabled, returns the angular velocity of a joint ([joint]) of a hand
   * ([hand]) as provided by OpenXR. This is relative to [XROrigin3D]!
   */
  public fun getHandJointAngularVelocity(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeArguments(LONG to hand.id, LONG to joint.id)
    TransferContext.callMethod(rawPtr, MethodBindings.getHandJointAngularVelocityPtr, VECTOR3)
    return (TransferContext.readReturnValue(VECTOR3, false) as Vector3)
  }

  /**
   * Returns `true` if OpenXR's hand tracking is supported and enabled.
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public fun isHandTrackingSupported(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, MethodBindings.isHandTrackingSupportedPtr, BOOL)
    return (TransferContext.readReturnValue(BOOL, false) as Boolean)
  }

  /**
   * Returns the capabilities of the eye gaze interaction extension.
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public fun isEyeGazeInteractionSupported(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, MethodBindings.isEyeGazeInteractionSupportedPtr, BOOL)
    return (TransferContext.readReturnValue(BOOL, false) as Boolean)
  }

  public enum class Hand(
    id: Long,
  ) {
    /**
     * Left hand.
     */
    HAND_LEFT(0),
    /**
     * Right hand.
     */
    HAND_RIGHT(1),
    /**
     * Maximum value for the hand enum.
     */
    HAND_MAX(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = entries.single { it.id == `value` }
    }
  }

  public enum class HandMotionRange(
    id: Long,
  ) {
    HAND_MOTION_RANGE_UNOBSTRUCTED(0),
    HAND_MOTION_RANGE_CONFORM_TO_CONTROLLER(1),
    HAND_MOTION_RANGE_MAX(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = entries.single { it.id == `value` }
    }
  }

  public enum class HandJoints(
    id: Long,
  ) {
    /**
     * Palm joint.
     */
    HAND_JOINT_PALM(0),
    /**
     * Wrist joint.
     */
    HAND_JOINT_WRIST(1),
    /**
     * Thumb metacarpal joint.
     */
    HAND_JOINT_THUMB_METACARPAL(2),
    /**
     * Thumb proximal joint.
     */
    HAND_JOINT_THUMB_PROXIMAL(3),
    /**
     * Thumb distal joint.
     */
    HAND_JOINT_THUMB_DISTAL(4),
    /**
     * Thumb tip joint.
     */
    HAND_JOINT_THUMB_TIP(5),
    /**
     * Index metacarpal joint.
     */
    HAND_JOINT_INDEX_METACARPAL(6),
    /**
     * Index proximal joint.
     */
    HAND_JOINT_INDEX_PROXIMAL(7),
    /**
     * Index intermediate joint.
     */
    HAND_JOINT_INDEX_INTERMEDIATE(8),
    /**
     * Index distal joint.
     */
    HAND_JOINT_INDEX_DISTAL(9),
    /**
     * Index tip joint.
     */
    HAND_JOINT_INDEX_TIP(10),
    /**
     * Middle metacarpal joint.
     */
    HAND_JOINT_MIDDLE_METACARPAL(11),
    /**
     * Middle proximal joint.
     */
    HAND_JOINT_MIDDLE_PROXIMAL(12),
    /**
     * Middle intermediate joint.
     */
    HAND_JOINT_MIDDLE_INTERMEDIATE(13),
    /**
     * Middle distal joint.
     */
    HAND_JOINT_MIDDLE_DISTAL(14),
    /**
     * Middle tip joint.
     */
    HAND_JOINT_MIDDLE_TIP(15),
    /**
     * Ring metacarpal joint.
     */
    HAND_JOINT_RING_METACARPAL(16),
    /**
     * Ring proximal joint.
     */
    HAND_JOINT_RING_PROXIMAL(17),
    /**
     * Ring intermediate joint.
     */
    HAND_JOINT_RING_INTERMEDIATE(18),
    /**
     * Ring distal joint.
     */
    HAND_JOINT_RING_DISTAL(19),
    /**
     * Ring tip joint.
     */
    HAND_JOINT_RING_TIP(20),
    /**
     * Little metacarpal joint.
     */
    HAND_JOINT_LITTLE_METACARPAL(21),
    /**
     * Little proximal joint.
     */
    HAND_JOINT_LITTLE_PROXIMAL(22),
    /**
     * Little intermediate joint.
     */
    HAND_JOINT_LITTLE_INTERMEDIATE(23),
    /**
     * Little distal joint.
     */
    HAND_JOINT_LITTLE_DISTAL(24),
    /**
     * Little tip joint.
     */
    HAND_JOINT_LITTLE_TIP(25),
    /**
     * Maximum value for the hand joint enum.
     */
    HAND_JOINT_MAX(26),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = entries.single { it.id == `value` }
    }
  }

  public sealed interface HandJointFlags {
    public val flag: Long

    public infix fun or(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.or(other.flag))

    public infix fun or(other: Long): HandJointFlags = HandJointFlagsValue(flag.or(other))

    public infix fun xor(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.xor(other.flag))

    public infix fun xor(other: Long): HandJointFlags = HandJointFlagsValue(flag.xor(other))

    public infix fun and(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.and(other.flag))

    public infix fun and(other: Long): HandJointFlags = HandJointFlagsValue(flag.and(other))

    public operator fun plus(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.plus(other.flag))

    public operator fun plus(other: Long): HandJointFlags = HandJointFlagsValue(flag.plus(other))

    public operator fun minus(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.minus(other.flag))

    public operator fun minus(other: Long): HandJointFlags = HandJointFlagsValue(flag.minus(other))

    public operator fun times(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.times(other.flag))

    public operator fun times(other: Long): HandJointFlags = HandJointFlagsValue(flag.times(other))

    public operator fun div(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.div(other.flag))

    public operator fun div(other: Long): HandJointFlags = HandJointFlagsValue(flag.div(other))

    public operator fun rem(other: HandJointFlags): HandJointFlags =
        HandJointFlagsValue(flag.rem(other.flag))

    public operator fun rem(other: Long): HandJointFlags = HandJointFlagsValue(flag.rem(other))

    public fun unaryPlus(): HandJointFlags = HandJointFlagsValue(flag.unaryPlus())

    public fun unaryMinus(): HandJointFlags = HandJointFlagsValue(flag.unaryMinus())

    public fun inv(): HandJointFlags = HandJointFlagsValue(flag.inv())

    public infix fun shl(bits: Int): HandJointFlags = HandJointFlagsValue(flag shl bits)

    public infix fun shr(bits: Int): HandJointFlags = HandJointFlagsValue(flag shr bits)

    public infix fun ushr(bits: Int): HandJointFlags = HandJointFlagsValue(flag ushr bits)

    public companion object {
      public val HAND_JOINT_NONE: HandJointFlags = HandJointFlagsValue(0)

      public val HAND_JOINT_ORIENTATION_VALID: HandJointFlags = HandJointFlagsValue(1)

      public val HAND_JOINT_ORIENTATION_TRACKED: HandJointFlags = HandJointFlagsValue(2)

      public val HAND_JOINT_POSITION_VALID: HandJointFlags = HandJointFlagsValue(4)

      public val HAND_JOINT_POSITION_TRACKED: HandJointFlags = HandJointFlagsValue(8)

      public val HAND_JOINT_LINEAR_VELOCITY_VALID: HandJointFlags = HandJointFlagsValue(16)

      public val HAND_JOINT_ANGULAR_VELOCITY_VALID: HandJointFlags = HandJointFlagsValue(32)
    }
  }

  @JvmInline
  internal value class HandJointFlagsValue internal constructor(
    public override val flag: Long,
  ) : HandJointFlags

  public companion object

  internal object MethodBindings {
    public val getDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_display_refresh_rate")

    public val setDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_display_refresh_rate")

    public val getRenderTargetSizeMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_render_target_size_multiplier")

    public val setRenderTargetSizeMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_render_target_size_multiplier")

    public val isFoveationSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_foveation_supported")

    public val getFoveationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_foveation_level")

    public val setFoveationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_foveation_level")

    public val getFoveationDynamicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_foveation_dynamic")

    public val setFoveationDynamicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_foveation_dynamic")

    public val isActionSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_action_set_active")

    public val setActionSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_action_set_active")

    public val getActionSetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_action_sets")

    public val getAvailableDisplayRefreshRatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_available_display_refresh_rates")

    public val setMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_motion_range")

    public val getMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_motion_range")

    public val getHandJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_flags")

    public val getHandJointRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_rotation")

    public val getHandJointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_position")

    public val getHandJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_radius")

    public val getHandJointLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_linear_velocity")

    public val getHandJointAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_angular_velocity")

    public val isHandTrackingSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_hand_tracking_supported")

    public val isEyeGazeInteractionSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_eye_gaze_interaction_supported")
  }
}

public infix fun Long.or(other: godot.OpenXRInterface.HandJointFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: godot.OpenXRInterface.HandJointFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: godot.OpenXRInterface.HandJointFlags): Long = this.and(other.flag)

public operator fun Long.plus(other: godot.OpenXRInterface.HandJointFlags): Long =
    this.plus(other.flag)

public operator fun Long.minus(other: godot.OpenXRInterface.HandJointFlags): Long =
    this.minus(other.flag)

public operator fun Long.times(other: godot.OpenXRInterface.HandJointFlags): Long =
    this.times(other.flag)

public operator fun Long.div(other: godot.OpenXRInterface.HandJointFlags): Long =
    this.div(other.flag)

public operator fun Long.rem(other: godot.OpenXRInterface.HandJointFlags): Long =
    this.rem(other.flag)
