package kotlin.reflect.jvm.internal.impl.storage;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
class SingleThreadValue<T> {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {4, -41, 37, 5, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 14;
    private final Thread thread;
    private final T value;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 12
            int r9 = 16 - r9
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1d:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r8]
            r6 = r10
            r10 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r8 = -r8
            int r9 = r9 + r8
            int r9 = r9 + 2
            int r8 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleThreadValue(T t) {
        this.value = t;
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            this.thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public boolean hasValue() {
        Thread thread = this.thread;
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            return thread == cls.getMethod((String) objArr2[0], null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public T getValue() {
        if (!hasValue()) {
            throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
        }
        return this.value;
    }
}
