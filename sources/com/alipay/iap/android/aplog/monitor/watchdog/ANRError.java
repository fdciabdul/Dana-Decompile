package com.alipay.iap.android.aplog.monitor.watchdog;

import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ANRError extends Error {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {97, -108, 86, -98, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
    public static final int PlaceComponentResult = 171;
    private static final long serialVersionUID = 1;
    private final Map<Thread, StackTraceElement[]> _stackTraces;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r6 = 27 - r6
            byte[] r0 = com.alipay.iap.android.aplog.monitor.watchdog.ANRError.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 3
            int r8 = r8 + 103
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2f
        L17:
            r3 = 0
        L18:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L2f:
            int r7 = r7 + 1
            int r4 = -r4
            int r8 = r8 + r4
            int r8 = r8 + 2
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.monitor.watchdog.ANRError.a(short, int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f6939a;
        private final StackTraceElement[] b;

        /* renamed from: com.alipay.iap.android.aplog.monitor.watchdog.ANRError$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0055a extends Throwable {
            private C0055a(C0055a c0055a) {
                super(a.this.f6939a, c0055a);
            }

            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                setStackTrace(a.this.b);
                return this;
            }
        }

        private a(String str, StackTraceElement[] stackTraceElementArr) {
            this.f6939a = str;
            this.b = stackTraceElementArr;
        }
    }

    private ANRError(a.C0055a c0055a, Map<Thread, StackTraceElement[]> map) {
        super("Application Not Responding", c0055a);
        this._stackTraces = map;
    }

    public Map<Thread, StackTraceElement[]> getStackTraces() {
        return this._stackTraces;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        Object[] objArr = new Object[1];
        a(r0[9], r0[23], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), objArr);
        setStackTrace((StackTraceElement[]) Array.newInstance(Class.forName((String) objArr[0]), 0));
        return this;
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.alipay.iap.android.aplog.monitor.watchdog.ANRError$a$a, com.alipay.iap.android.aplog.monitor.watchdog.ANRError$1] */
    public static ANRError NewMainOnly() {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            Object[] objArr = new Object[1];
            a(BuiltInFictitiousFunctionClassFactory[16], BuiltInFictitiousFunctionClassFactory[4], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[28] - 1);
            byte b2 = BuiltInFictitiousFunctionClassFactory[9];
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            ?? r3 = 0;
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls.getMethod((String) objArr2[0], null).invoke(thread, null);
            HashMap hashMap = new HashMap(1);
            hashMap.put(thread, stackTraceElementArr);
            return new ANRError(new a.C0055a(r3), hashMap);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
