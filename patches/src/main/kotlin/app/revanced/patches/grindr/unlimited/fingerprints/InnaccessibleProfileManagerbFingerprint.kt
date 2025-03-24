package app.revanced.patches.grindr.unlimited.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode


internal val innaccessibleProfileManagerbFingerprint = fingerprint {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    opcodes(
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.SGET_OBJECT,
        Opcode.IF_EQ,
        Opcode.CONST_4,
        Opcode.GOTO,
        Opcode.CONST_4,
        Opcode.RETURN
    )
}