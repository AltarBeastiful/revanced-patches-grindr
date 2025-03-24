package app.revanced.patches.grindr.unlimited.fingerprints

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode


internal val innaccessibleProfileManagerdFingerprint = fingerprint {
    returns("Z")
    opcodes(
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.XOR_INT_LIT8,
        Opcode.RETURN
    )
    custom { methodDef, _ ->
        methodDef.definingClass.contains("grindrapp")
    }
}