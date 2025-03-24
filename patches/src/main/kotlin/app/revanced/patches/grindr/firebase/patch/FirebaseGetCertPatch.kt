package app.revanced.patches.grindr.firebase.patch

import app.revanced.patches.grindr.firebase.fingerprints.getMessagingCertFingerprint
import app.revanced.patches.grindr.firebase.fingerprints.getRegistrationCertFingerprint
import app.revanced.patches.grindr.Constants.SPOOFED_PACKAGE_SIGNATURE
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

val firebaseGetCertPatchGrindr = bytecodePatch(
    name = "Patch firebase cert"
) {
    execute {
        val spoofedInstruction =
        """
            const-string v0, "$SPOOFED_PACKAGE_SIGNATURE"
            return-object v0
        """

        getMessagingCertFingerprint.method.addInstructions(
            0,
            spoofedInstruction
        )
        getRegistrationCertFingerprint.method.addInstructions(
            0,
            spoofedInstruction
        )
    }
}