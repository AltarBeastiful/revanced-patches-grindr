package app.revanced.patches.grindr.unlimited.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode


internal val isNoPlusUpsellFingerprint = fingerprint {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    opcodes(Opcode.INVOKE_VIRTUAL, 
    Opcode.MOVE_RESULT,
    Opcode.IF_NEZ,
    Opcode.INVOKE_VIRTUAL,
    Opcode.MOVE_RESULT,
    Opcode.IF_NEZ,
    Opcode.INVOKE_VIRTUAL,
    Opcode.MOVE_RESULT,
    Opcode.IF_EQZ,
    Opcode.GOTO,
    Opcode.CONST_4,
    Opcode.GOTO,
    Opcode.CONST_4,
    Opcode.RETURN)
    custom { methodDef, _ ->
        methodDef.definingClass.contains("grindrapp")
    }
}