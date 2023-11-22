package okhttp3.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;
    public static final byte[] PlaceComponentResult = {107, -40, -73, 40, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 83;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = okhttp3.internal.NamedRunnable.PlaceComponentResult
            int r6 = r6 * 12
            int r6 = 16 - r6
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r5 = r5 * 3
            int r5 = 16 - r5
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L17
            r3 = r7
            r7 = r6
            goto L2c
        L17:
            r4 = r7
            r7 = r6
            r6 = r4
        L1a:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            if (r2 != r5) goto L2a
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2a:
            r3 = r0[r7]
        L2c:
            int r3 = -r3
            int r6 = r6 + r3
            int r7 = r7 + 1
            int r6 = r6 + 2
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.NamedRunnable.a(int, byte, byte, java.lang.Object[]):void");
    }

    protected abstract void execute();

    public NamedRunnable(String str, Object... objArr) {
        this.name = Util.format(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
            try {
                byte b5 = (byte) (PlaceComponentResult[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-PlaceComponentResult[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).setName(this.name);
                try {
                    execute();
                    try {
                        byte b9 = (byte) (PlaceComponentResult[15] + 1);
                        byte b10 = b9;
                        Object[] objArr5 = new Object[1];
                        a(b9, b10, b10, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        byte b11 = (byte) (-PlaceComponentResult[15]);
                        byte b12 = b11;
                        Object[] objArr6 = new Object[1];
                        a(b11, b12, b12, objArr6);
                        ((Thread) cls3.getMethod((String) objArr6[0], null).invoke(null, null)).setName(name);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    try {
                        byte b13 = (byte) (PlaceComponentResult[15] + 1);
                        byte b14 = b13;
                        Object[] objArr7 = new Object[1];
                        a(b13, b14, b14, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        byte b15 = (byte) (-PlaceComponentResult[15]);
                        byte b16 = b15;
                        Object[] objArr8 = new Object[1];
                        a(b15, b16, b16, objArr8);
                        ((Thread) cls4.getMethod((String) objArr8[0], null).invoke(null, null)).setName(name);
                        throw th2;
                    } catch (Throwable th3) {
                        Throwable cause2 = th3.getCause();
                        if (cause2 == null) {
                            throw th3;
                        }
                        throw cause2;
                    }
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        } catch (Throwable th5) {
            Throwable cause4 = th5.getCause();
            if (cause4 == null) {
                throw th5;
            }
            throw cause4;
        }
    }
}
