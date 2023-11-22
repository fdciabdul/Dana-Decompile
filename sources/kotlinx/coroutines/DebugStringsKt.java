package kotlinx.coroutines;

import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "toDebugString", "(Lkotlin/coroutines/Continuation;)Ljava/lang/String;", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "classSimpleName", "getHexAddress", "hexAddress"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DebugStringsKt {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, -23, 102, -23, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 245;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r8, byte r9, byte r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = kotlinx.coroutines.DebugStringsKt.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 * 2
            int r10 = r10 + 16
            int r9 = 106 - r9
            int r8 = r8 + 4
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L33
        L16:
            r3 = 0
        L17:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r10) goto L28
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L33:
            int r8 = r8 + r10
            int r8 = r8 + 2
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugStringsKt.a(int, byte, byte, java.lang.Object[]):void");
    }

    @JvmName(name = "getHexAddress")
    public static final String getHexAddress(Object obj) {
        try {
            Object[] objArr = {obj};
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr2 = new Object[1];
            a(14, b, b, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            byte b3 = (byte) (-b2);
            Object[] objArr3 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr3);
            return Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static final String toDebugString(Continuation<?> continuation) {
        String m3179constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append(continuation);
            sb.append('@');
            sb.append(getHexAddress(continuation));
            m3179constructorimpl = Result.m3179constructorimpl(sb.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3182exceptionOrNullimpl(m3179constructorimpl) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(continuation.getClass().getName());
            sb2.append('@');
            sb2.append(getHexAddress(continuation));
            m3179constructorimpl = sb2.toString();
        }
        return (String) m3179constructorimpl;
    }

    @JvmName(name = "getClassSimpleName")
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
