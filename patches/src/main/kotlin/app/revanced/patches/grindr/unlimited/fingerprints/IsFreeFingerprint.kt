package app.revanced.patches.grindr.unlimited.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode


internal val isFreeFingerprint = fingerprint {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    opcodes(Opcode.IGET_OBJECT,
    Opcode.INVOKE_INTERFACE,
    Opcode.MOVE_RESULT,
    Opcode.RETURN)
    custom { methodDef, _ ->
        methodDef.definingClass.contains("grindrapp")
    }
}