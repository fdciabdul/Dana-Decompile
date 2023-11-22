package id.co.bri.brizzi;

import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.PrintStream;

/* loaded from: classes8.dex */
public class Utility {

    /* renamed from: a  reason: collision with root package name */
    public static String f8016a;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {82, -89, -124, -60, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int BuiltInFictitiousFunctionClassFactory = 64;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 68 - r8
            int r7 = r7 + 99
            byte[] r0 = id.co.bri.brizzi.Utility.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 12
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r9) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.co.bri.brizzi.Utility.d(byte, short, int, java.lang.Object[]):void");
    }

    public static String getLog() {
        return f8016a;
    }

    public static void setLog(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(f8016a);
        sb.append(str);
        sb.append("\n");
        f8016a = sb.toString();
    }

    public String a(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
            str2 = sb.toString();
        }
        return str2;
    }

    public String b(String str) {
        return (str.equalsIgnoreCase("6161") || str.equalsIgnoreCase("4141")) ? "Aktif" : (str.equalsIgnoreCase("636c") || str.equalsIgnoreCase("434c")) ? "Tidak Aktif" : "lain-lain";
    }

    public String c(String str) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" - ");
        sb.append(str.length());
        printStream.println(sb.toString());
        String str2 = "";
        for (int i = 0; i < str.length(); i += 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str.substring((str.length() - i) - 2, str.length() - i));
            str2 = sb2.toString();
        }
        return str2.toUpperCase();
    }

    public void writeAdvanceDebuggingLog(String str) {
        try {
            Object[] objArr = new Object[1];
            d(KClassImpl$Data$declaredNonStaticMembers$2[8], (short) 41, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[21];
            Object[] objArr2 = new Object[1];
            d(b, (byte) (b | 65), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[8], (short) 41, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[9], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr4);
                Object obj = ((Object[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null))[3];
                try {
                    Object[] objArr5 = new Object[1];
                    d(KClassImpl$Data$declaredNonStaticMembers$2[8], (short) 26, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[7]), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[9];
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[21];
                    Object[] objArr6 = new Object[1];
                    d(b2, b3, b3, objArr6);
                    String str2 = (String) cls3.getMethod((String) objArr6[0], null).invoke(obj, null);
                    try {
                        Object[] objArr7 = new Object[1];
                        d(KClassImpl$Data$declaredNonStaticMembers$2[8], (short) 41, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[21];
                        Object[] objArr8 = new Object[1];
                        d(b4, (byte) (b4 | 65), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr8);
                        Object invoke2 = cls4.getMethod((String) objArr8[0], null).invoke(null, null);
                        try {
                            Object[] objArr9 = new Object[1];
                            d(KClassImpl$Data$declaredNonStaticMembers$2[8], (short) 41, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            d(KClassImpl$Data$declaredNonStaticMembers$2[9], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr10);
                            String methodName = ((StackTraceElement[]) cls5.getMethod((String) objArr10[0], null).invoke(invoke2, null))[3].getMethodName();
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(" | ");
                            sb.append(methodName);
                            InstrumentInjector.log_d(sb.toString(), str);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        } catch (Throwable th5) {
            Throwable cause5 = th5.getCause();
            if (cause5 == null) {
                throw th5;
            }
            throw cause5;
        }
    }

    public void writeDebuggingLog(String str, String str2) {
        InstrumentInjector.log_d(str, str2);
    }
}
