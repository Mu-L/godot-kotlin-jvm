// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot

import godot.`annotation`.GodotBaseType
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

/**
 * This is the default [MultiplayerAPI.multiplayerPeer] for the [Node.multiplayer]. It mimics the
 * behavior of a server with no peers connected.
 * This means that the [SceneTree] will act as the multiplayer authority by default. Calls to
 * [MultiplayerAPI.isServer] will return `true`, and calls to [MultiplayerAPI.getUniqueId] will return
 * [MultiplayerPeer.TARGET_PEER_SERVER].
 */
@GodotBaseType
public open class OfflineMultiplayerPeer : MultiplayerPeer() {
  public override fun new(scriptIndex: Int): Boolean {
    callConstructor(ENGINECLASS_OFFLINEMULTIPLAYERPEER, scriptIndex)
    return true
  }

  public companion object

  internal object MethodBindings
}
