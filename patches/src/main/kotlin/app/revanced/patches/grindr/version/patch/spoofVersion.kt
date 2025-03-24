package app.revanced.patches.grindr.version.patch

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patches.grindr.deviceinfo.fingerprints.deviceInfoFingerprint
import app.revanced.patches.grindr.version.fingerprints.*
import app.revanced.patcher.patch.bytecodePatch

fun genUserAgent(grindrVersion: String, grindrVersionIdentifier: String): String {
    return "grindr3/$grindrVersion.$grindrVersionIdentifier;$grindrVersionIdentifier;Free;Android 14;pixel_9_pro_xl;Google"
}

@Suppress("unused")
val spoofVersionPatch = bytecodePatch(
    name = "Spoof versions"
) {
    val grindrVersion = "24.19.0"
    val grindrVersionIdentifier = "132462"
    execute {
        val userAgentPatch = String.format("const-string v0, \"%s\"", genUserAgent(grindrVersion, grindrVersionIdentifier))
        println(userAgentPatch)

        appConfigurationFingerprint.method.replaceInstructions(11, """const-string v9, "$grindrVersion"""")
        appConfigurationFingerprint.method.replaceInstructions(88, """const-string v1, "$grindrVersion.$grindrVersionIdentifier"""")
        deviceInfoFingerprint.method.addInstructions(112, userAgentPatch)
    }
}