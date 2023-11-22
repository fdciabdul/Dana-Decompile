package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "createEventLoop", "()Lkotlinx/coroutines/EventLoop;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EventLoopKt {
    public static final byte[] MyBillsEntityDataFactory = {103, 121, -60, -41, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 10;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = kotlinx.coroutines.EventLoopKt.MyBillsEntityDataFactory
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 12
            int r7 = r7 + 4
            int r9 = r9 * 7
            int r9 = r9 + 99
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1f:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r9 = -r9
            int r7 = r7 + r9
            int r8 = r8 + 1
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopKt.a(byte, short, int, java.lang.Object[]):void");
    }

    public static final EventLoop createEventLoop() {
        try {
            byte b = (byte) (-MyBillsEntityDataFactory[15]);
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), (byte) (-MyBillsEntityDataFactory[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (MyBillsEntityDataFactory[15] + 1);
            byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            return new BlockingEventLoop((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
