package com.ta.audid.g;

import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes.dex */
public class m {
    private static String TAG = "Utdid";
    private static boolean i;
    private static boolean isDebug;
    public static final byte[] getAuthRequestContext = {56, -13, -61, 104, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int MyBillsEntityDataFactory = 107;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 12
            byte[] r0 = com.ta.audid.g.m.getAuthRequestContext
            int r8 = 69 - r8
            int r9 = 106 - r9
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r9 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r7
            goto L30
        L14:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r9]
            r6 = r10
            r10 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L30:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            int r9 = r9 + 1
            r8 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.audid.g.m.b(int, int, short, java.lang.Object[]):void");
    }

    public static void setDebug(boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("setDebug:");
        sb.append(z);
        InstrumentInjector.log_i(str, sb.toString());
        isDebug = z;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void d() {
        if (isDebug) {
            InstrumentInjector.log_d(X(), a((String) null, new Object[0]));
        }
    }

    public static void d(String str, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_d(X(), a(str, objArr));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m249a(String str, Object... objArr) {
        if (i) {
            InstrumentInjector.log_d(X(), a(str, objArr));
        }
    }

    public static void i(String str, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_i(X(), a(str, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_w(X(), a(str, objArr));
        }
    }

    public static void w(String str, Throwable th, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_w(X(), a(str, objArr), th);
        }
    }

    public static void e(String str, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_e(X(), a(str, objArr));
        }
    }

    public static void e(String str, Throwable th, Object... objArr) {
        if (isDebug) {
            InstrumentInjector.log_e(X(), a(str, objArr), th);
        }
    }

    private static String a(Object obj, Object obj2) {
        if (isDebug) {
            Object[] objArr = new Object[2];
            if (obj == null) {
                obj = "";
            }
            objArr[0] = obj;
            if (obj2 == null) {
                obj2 = "";
            }
            objArr[1] = obj2;
            return String.format("%s:%s", objArr);
        }
        return "";
    }

    private static String X() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(":");
        return i(sb.toString());
    }

    private static String i(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            str = TAG;
        }
        StackTraceElement a2 = a();
        if (a2 != null) {
            try {
                Object[] objArr = new Object[1];
                b(getAuthRequestContext[7], (byte) (MyBillsEntityDataFactory >>> 2), getAuthRequestContext[21], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = getAuthRequestContext[21];
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                b(b, b2, (byte) (b2 + 3), objArr2);
                String str2 = (String) cls.getMethod((String) objArr2[0], null).invoke(a2, null);
                if (!TextUtils.isEmpty(str2)) {
                    substring = str2.substring(str2.lastIndexOf(46) + 1);
                    int myPid = Process.myPid();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(substring);
                    sb.append(".");
                    sb.append(String.valueOf(myPid));
                    return sb.toString();
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        substring = "";
        int myPid2 = Process.myPid();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(substring);
        sb2.append(".");
        sb2.append(String.valueOf(myPid2));
        return sb2.toString();
    }

    static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StackTraceElement a2 = a();
        int i2 = 0;
        sb.append(String.format("[%s]", a2 != null ? a2.getMethodName() : ""));
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append("\n\t");
                sb.append(a(objArr[i2], objArr[i3]));
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append("\n\t");
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static StackTraceElement a() {
        try {
            Object[] objArr = new Object[1];
            b(getAuthRequestContext[16], (byte) (MyBillsEntityDataFactory & WSContextConstant.HANDSHAKE_SEND_SIZE), getAuthRequestContext[21], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-getAuthRequestContext[15]);
            Object[] objArr2 = new Object[1];
            b(b, (byte) (b | SignedBytes.MAX_POWER_OF_TWO), (byte) (-getAuthRequestContext[8]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[16], (byte) (MyBillsEntityDataFactory & WSContextConstant.HANDSHAKE_SEND_SIZE), getAuthRequestContext[21], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b((byte) (-getAuthRequestContext[15]), getAuthRequestContext[31], (byte) (MyBillsEntityDataFactory & 7), objArr4);
                for (StackTraceElement stackTraceElement : (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null)) {
                    if (!stackTraceElement.isNativeMethod()) {
                        try {
                            Object[] objArr5 = new Object[1];
                            b(getAuthRequestContext[7], (byte) (MyBillsEntityDataFactory >>> 2), getAuthRequestContext[21], objArr5);
                            Class<?> cls3 = Class.forName((String) objArr5[0]);
                            byte b2 = getAuthRequestContext[21];
                            byte b3 = b2;
                            Object[] objArr6 = new Object[1];
                            b(b2, b3, (byte) (b3 + 3), objArr6);
                            String str = (String) cls3.getMethod((String) objArr6[0], null).invoke(stackTraceElement, null);
                            byte[] bArr = getAuthRequestContext;
                            Object[] objArr7 = new Object[1];
                            b(bArr[16], (byte) (MyBillsEntityDataFactory & WSContextConstant.HANDSHAKE_SEND_SIZE), bArr[21], objArr7);
                            if (str.equals(Class.forName((String) objArr7[0]).getName())) {
                                continue;
                            } else {
                                try {
                                    Object[] objArr8 = new Object[1];
                                    b(getAuthRequestContext[7], (byte) (MyBillsEntityDataFactory >>> 2), getAuthRequestContext[21], objArr8);
                                    Class<?> cls4 = Class.forName((String) objArr8[0]);
                                    byte b4 = getAuthRequestContext[21];
                                    byte b5 = b4;
                                    Object[] objArr9 = new Object[1];
                                    b(b4, b5, (byte) (b5 + 3), objArr9);
                                    if (!((String) cls4.getMethod((String) objArr9[0], null).invoke(stackTraceElement, null)).equals(m.class.getName())) {
                                        return stackTraceElement;
                                    }
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        throw cause;
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 != null) {
                                throw cause2;
                            }
                            throw th2;
                        }
                    }
                }
                return null;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 != null) {
                throw cause4;
            }
            throw th4;
        }
    }
}
