package app.revanced.patches.grindr.deviceinfo.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val deviceInfoFingerprint = fingerprint {
    returns("L-Device-Info;")
    opcodes(
        Opcode.CONST_STRING,
        Opcode.INVOKE_STATIC,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT,
        Opcode.INVOKE_VIRTUAL,
    )
}