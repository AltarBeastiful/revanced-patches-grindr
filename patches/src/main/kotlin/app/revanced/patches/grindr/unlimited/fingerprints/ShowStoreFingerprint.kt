package app.revanced.patches.grindr.unlimited.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

//A

internal val showStoreFingerprint = fingerprint {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC)
    opcodes(
        Opcode.SGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ,
        Opcode.SGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_NEZ,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_NEZ,
        Opcode.GOTO,
        Opcode.CONST_4,
        Opcode.GOTO,
        Opcode.CONST_4,
        Opcode.RETURN
    )
}