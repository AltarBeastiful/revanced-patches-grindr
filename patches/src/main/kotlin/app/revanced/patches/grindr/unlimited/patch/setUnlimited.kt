package app.revanced.patches.grindr.unlimited.patch

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patches.grindr.unlimited.fingerprints.*


@Suppress("unused")
val unlockUnlimitedPatch = bytecodePatch(
    name = "Unlock unlimited features"
) {
    execute {
        val trueBytecode = """
            const/4 v0, 0x1
            return v0
        """
        val falseBytecode = """
            const/4 v0, 0x0
            return v0
        """
        val patches = arrayOf(
            Pair(hasFeatureFingerprint, trueBytecode),
            Pair(isFreeFingerprint, falseBytecode),
            Pair(isNoPlusUpsellFingerprint, trueBytecode),
            Pair(isNoXtraUpsellFingerprint, trueBytecode),
            Pair(innaccessibleProfileManagerbFingerprint, trueBytecode),
            Pair(innaccessibleProfileManagerdFingerprint, falseBytecode)
        )
        for ((fingerprint, bytecode) in patches) {
            fingerprint.method.replaceInstructions(0, bytecode)
        }
    }
}