package app.revanced.patches.grindr.firebase.fingerprints

import app.revanced.patcher.fingerprint


internal val getRegistrationCertFingerprint = fingerprint {
    returns("Ljava/lang/String;")
    strings("FirebaseRemoteConfig",
    "Could not get fingerprint hash for package: ",
    "No such package: ")
}