package app.revanced.patches.grindr.deviceinfo.patch

import app.revanced.patches.grindr.deviceinfo.fingerprints.deviceInfoFingerprint
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patcher.patch.bytecodePatch

import java.util.UUID

import kotlin.random.Random

fun genLDevInfo(): String {
    val identifier = UUID.randomUUID()
    val hexIdentifier = identifier.toString().replace("-", "").lowercase()
    val randomInteger = Random.nextLong(1000000000, 9999999999 + 1)
    return "$hexIdentifier;GLOBAL;2;$randomInteger;2277x1080;${identifier.toString().lowercase()}"
}

fun genLDevInfoAnon(): String {
    val identifier = UUID.randomUUID()
    val hexIdentifier = identifier.toString().lowercase()
    return "anon-$hexIdentifier;*;*;*;*;*"
}


@Suppress("unused")
val unclockUnlimitedPatch = bytecodePatch(
    name = "Random device info"
) {
    execute {
        val bytecode_patch = String.format("const-string v0, \"%s\"", genLDevInfo())
        val bytecode_patch_anon = String.format("const-string v0, \"%s\"", genLDevInfoAnon())
    
        deviceInfoFingerprint.method.replaceInstructions(83, bytecode_patch)
        deviceInfoFingerprint.method.replaceInstructions(99, bytecode_patch_anon)
        deviceInfoFingerprint.method.replaceInstructions(104, bytecode_patch_anon)
    }
}