package fsimpl;

import android.os.Build;
import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* renamed from: fsimpl.ey  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0354ey {

    /* renamed from: a  reason: collision with root package name */
    private static C0348es f7979a;
    public static final byte[] MyBillsEntityDataFactory = {37, 81, 122, 15, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 198;

    public static void a(C0230ah c0230ah, bG bGVar) {
        if (bGVar.s() && c0230ah.p()) {
            f7979a = new C0348es(c0230ah.n(), String.format("%s %s %s", Build.MANUFACTURER, Build.MODEL, Build.PRODUCT), "Android", Integer.toString(Build.VERSION.SDK_INT), "fs_runtime", "1.41.0", bGVar.j(), c0230ah.u(), false);
        }
    }

    public static void a(final Throwable th) {
        if (f7979a != null) {
            Thread thread = Looper.getMainLooper().getThread();
            try {
                byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
                byte b2 = (byte) (-MyBillsEntityDataFactory[15]);
                Object[] objArr = new Object[1];
                c(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                byte b4 = (byte) (b3 - 1);
                Object[] objArr2 = new Object[1];
                c(b3, b4, b4, objArr2);
                if (thread == cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                    C0351ev.a(new Runnable() { // from class: fsimpl.-$$Lambda$ey$79VjZlfZ61n7S9_3BNZD3GV5Knw
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0354ey.b(th);
                        }
                    });
                } else {
                    f7979a.a(th);
                }
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Throwable th) {
        f7979a.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r0 = fsimpl.C0354ey.MyBillsEntityDataFactory
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r7 = r7 * 3
            int r7 = r7 + 13
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            int r6 = r6 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0354ey.c(byte, byte, short, java.lang.Object[]):void");
    }
}
