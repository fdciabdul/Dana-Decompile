package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSEngine;
import com.ap.zoloz.hummer.biz.HummerConstants;

/* loaded from: classes6.dex */
public class EngineScope {
    private JSEngine mEngine;
    public static final byte[] getAuthRequestContext = {113, 46, 115, -60, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 91;
    private long mNativeLocker = 0;
    private Thread mLockThread = null;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r0 = com.alibaba.jsi.standard.js.EngineScope.getAuthRequestContext
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r9 = r9 * 12
            int r9 = r9 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + 1
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.js.EngineScope.a(int, byte, byte, java.lang.Object[]):void");
    }

    public EngineScope(JSEngine jSEngine) {
        this.mEngine = jSEngine;
        enter();
    }

    public boolean enter() {
        synchronized (this) {
            if (this.mNativeLocker != 0) {
                Thread thread = this.mLockThread;
                try {
                    byte b = getAuthRequestContext[15];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (getAuthRequestContext[15] - 1);
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    if (thread == cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                        return true;
                    }
                    throwException("enter");
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            if (this.mEngine.isDisposed()) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSEngine '");
                sb.append(this.mEngine.getEmbedderName());
                sb.append("' has been disposed!");
                throw new Error(sb.toString());
            }
            Object engineCmd = Bridge.engineCmd(this.mEngine, 1, 0L);
            if (engineCmd instanceof Long) {
                this.mNativeLocker = ((Long) engineCmd).longValue();
                try {
                    byte b5 = getAuthRequestContext[15];
                    byte b6 = b5;
                    Object[] objArr3 = new Object[1];
                    a(b5, b6, b6, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b7 = (byte) (getAuthRequestContext[15] - 1);
                    byte b8 = b7;
                    Object[] objArr4 = new Object[1];
                    a(b7, b8, b8, objArr4);
                    this.mLockThread = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            return this.mNativeLocker != 0;
        }
    }

    public void exit() {
        synchronized (this) {
            if (this.mNativeLocker == 0) {
                return;
            }
            Thread thread = this.mLockThread;
            try {
                byte b = getAuthRequestContext[15];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (getAuthRequestContext[15] - 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                if (thread != cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                    throwException(HummerConstants.EXIT_H5_PAGE);
                }
                if (this.mEngine.isDisposed()) {
                    return;
                }
                Bridge.engineCmd(this.mEngine, 2, this.mNativeLocker);
                this.mNativeLocker = 0L;
                this.mLockThread = null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private void throwException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Can not call EngineScope.");
        sb.append(str);
        sb.append(" across thread: current is");
        try {
            byte b = getAuthRequestContext[15];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[15] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(cls.getMethod((String) objArr2[0], null).invoke(null, null));
            sb.append(", while the scope has thread ");
            sb.append(this.mLockThread);
            throw new Error(sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
