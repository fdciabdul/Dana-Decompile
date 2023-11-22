package com.apiguard3.internal;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.apiguard3.internal.setPressed;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
final class setContextClickable implements setPressed.AGState {
    public static final byte[] AGState = null;
    private static byte[] APIGuard;
    public static final int getSharedInstance;
    private static int parseResponseHeaders;
    private static int valueOf;
    public static final int values = 0;

    static {
        values();
        valueOf = 0;
        parseResponseHeaders = 1;
        APIGuard = new byte[]{Ascii.FS, -1, 119, -124, -2, -19, -2, -29, Ascii.CAN, -12, 11, -22, 12, 2, -8, -12, -6, -19, -30, 6, -14, 16, -26, -56, 66, -6, -16, -2, -67, 71, -22, 2, -71, 22, 32, -13, 1, -16, 14, -20, 8, -46, 32, -3, 0, -6, -38, Ascii.FS, -7, -18, -9, 7, -12, 4, -12, 8, -17, -14, 12, -61, 39, -2, -2, -12, -48, SignedBytes.MAX_POWER_OF_TWO, -9, -3, -24, 12, -4, -7, -14, 0, -12, -16, 13, -4, -48, 32, -15, -4, 14, -46, 18, 7, -6, 1, -24, 3, 0, 0, -7, 10, -39, Ascii.RS, -12, 1, -16, -1, -13, -14, 16, -26, -56, TarHeader.LF_FIFO, 1, -70, 22, 32, -3, 0, -6, -38, Ascii.FS, -7, -18, -9, 7};
        getSharedInstance = 117;
    }

    private static String valueOf(int i, byte b, int i2) {
        int i3 = (i2 * 3) + 11;
        int i4 = (i * 4) + 4;
        int i5 = 102 - (b * 4);
        byte[] bArr = AGState;
        byte[] bArr2 = new byte[i3];
        int i6 = i3 - 1;
        int i7 = -1;
        if (bArr == null) {
            i5 = i6 + i5 + 2;
            i4++;
            i6 = i6;
            bArr = bArr;
            bArr2 = bArr2;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i5;
            if (i8 == i6) {
                return new String(bArr2, 0);
            }
            int i9 = i6;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i5 = i5 + bArr[i4] + 2;
            i4++;
            i6 = i9;
            bArr = bArr4;
            bArr2 = bArr3;
            i7 = i8;
        }
    }

    private static void valueOf(String str) {
        byte[] bArr = APIGuard;
        byte b = bArr[95];
        byte b2 = bArr[53];
        Object[] objArr = new Object[1];
        values(b, b2, (byte) (b2 | 81), objArr);
        String str2 = (String) objArr[0];
        ClassLoader classLoader = setContextClickable.class.getClassLoader();
        try {
            byte b3 = (byte) (AGState[4] - 1);
            byte b4 = b3;
            Method declaredMethod = ClassLoader.class.getDeclaredMethod(valueOf(b3, b4, b4), String.class);
            declaredMethod.setAccessible(true);
            String str3 = (String) declaredMethod.invoke(classLoader, str);
            if (str3 == null) {
                try {
                    byte[] bArr2 = APIGuard;
                    byte b5 = bArr2[12];
                    byte b6 = (byte) (-bArr2[50]);
                    Object[] objArr2 = new Object[1];
                    values(b5, b6, b6, objArr2);
                    Object invoke = Runtime.class.getMethod((String) objArr2[0], null).invoke(null, null);
                    try {
                        byte[] bArr3 = APIGuard;
                        Object[] objArr3 = new Object[1];
                        values(bArr3[51], bArr3[93], (byte) (getSharedInstance & 491), objArr3);
                        Runtime.class.getMethod((String) objArr3[0], String.class).invoke(invoke, str);
                        return;
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
            }
            InputStream resourceAsStream = setContextClickable.class.getClassLoader().getResourceAsStream(str3);
            if (resourceAsStream == null) {
                byte b7 = APIGuard[44];
                Object[] objArr4 = new Object[1];
                values(82, b7, (byte) (b7 | 97), objArr4);
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    byte b8 = APIGuard[21];
                    Object[] objArr6 = new Object[1];
                    values(b8, r1[51], b8, objArr6);
                    if (((Boolean) String.class.getMethod((String) objArr6[0], CharSequence.class).invoke(str3, objArr5)).booleanValue()) {
                        StringBuilder sb = new StringBuilder();
                        byte[] bArr4 = APIGuard;
                        byte b9 = (byte) (-bArr4[50]);
                        byte b10 = bArr4[40];
                        Object[] objArr7 = new Object[1];
                        values(b9, b10, (byte) (b10 | 36), objArr7);
                        sb.append((String) objArr7[0]);
                        sb.append(str3);
                        resourceAsStream = ((JarURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(sb.toString()).openConnection())))).getInputStream();
                    } else {
                        try {
                            resourceAsStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str3);
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
            try {
                InputStream inputStream = (InputStream) ((Class) setLayerPaint.values((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1, (Process.myTid() >> 22) + 53, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("AGState", InputStream.class).invoke(null, bufferedInputStream);
                if (bufferedInputStream != inputStream) {
                    Object[] objArr8 = new Object[1];
                    values((byte) (-APIGuard[50]), r6[34], (byte) (getSharedInstance & 475), objArr8);
                    Class<?> cls = Class.forName((String) objArr8[0]);
                    byte[] bArr5 = APIGuard;
                    byte b11 = (byte) (-bArr5[50]);
                    byte b12 = bArr5[84];
                    byte b13 = bArr5[44];
                    Object[] objArr9 = new Object[1];
                    values(b11, b12, b13, objArr9);
                    inputStream = new BufferedInputStream((InputStream) cls.getConstructor(Class.forName((String) objArr9[0])).newInstance(inputStream));
                }
                byte[] bArr6 = new byte[1881080];
                inputStream.read(bArr6);
                inputStream.close();
                a.e(str3, bArr6);
                byte[] bArr7 = APIGuard;
                byte b14 = bArr7[95];
                byte b15 = bArr7[53];
                Object[] objArr10 = new Object[1];
                values(b14, b15, (byte) (b15 | 81), objArr10);
                setDrawingCacheEnabled.AGState(setDrawingCacheEnabled.values(str.getBytes((String) objArr10[0])), str3);
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 == null) {
                    throw th5;
                }
                throw cause5;
            }
        } catch (Throwable th6) {
            Throwable cause6 = th6.getCause();
            if (cause6 == null) {
                throw th6;
            }
            throw cause6;
        }
    }

    static void values() {
        AGState = new byte[]{6, -35, -123, 41, 1, 3, -12, -26, Ascii.ESC, -9, 14, -19, 15, 5};
        values = 249;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 1
            byte[] r0 = com.apiguard3.internal.setContextClickable.APIGuard
            int r9 = 100 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r9
            r3 = r1
            r4 = 0
            r9 = r8
            r1 = r0
            r0 = r10
            r10 = r7
            goto L33
        L13:
            int r7 = 115 - r7
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            int r7 = r7 + 1
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r10 = r10 + r8
            int r8 = r10 + 5
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setContextClickable.values(int, byte, short, java.lang.Object[]):void");
    }

    private static void values(String str) {
        byte[] bArr = APIGuard;
        byte b = bArr[95];
        byte b2 = bArr[53];
        Object[] objArr = new Object[1];
        values(b, b2, (byte) (b2 | 81), objArr);
        String str2 = (String) objArr[0];
        if (str == null) {
            try {
                byte[] bArr2 = APIGuard;
                byte b3 = bArr2[12];
                byte b4 = (byte) (-bArr2[50]);
                Object[] objArr2 = new Object[1];
                values(b3, b4, b4, objArr2);
                Object invoke = Runtime.class.getMethod((String) objArr2[0], null).invoke(null, null);
                try {
                    byte[] bArr3 = APIGuard;
                    Object[] objArr3 = new Object[1];
                    values(bArr3[51], bArr3[93], (byte) (getSharedInstance & 491), objArr3);
                    Runtime.class.getMethod((String) objArr3[0], String.class).invoke(invoke, str);
                    return;
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
        }
        InputStream resourceAsStream = setContextClickable.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            byte b5 = APIGuard[44];
            Object[] objArr4 = new Object[1];
            values(82, b5, (byte) (b5 | 97), objArr4);
            try {
                Object[] objArr5 = {(String) objArr4[0]};
                byte b6 = APIGuard[21];
                Object[] objArr6 = new Object[1];
                values(b6, r9[51], b6, objArr6);
                if (((Boolean) String.class.getMethod((String) objArr6[0], CharSequence.class).invoke(str, objArr5)).booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr4 = APIGuard;
                    byte b7 = (byte) (-bArr4[50]);
                    byte b8 = bArr4[40];
                    Object[] objArr7 = new Object[1];
                    values(b7, b8, (byte) (b8 | 36), objArr7);
                    sb.append((String) objArr7[0]);
                    sb.append(str);
                    resourceAsStream = ((JarURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(sb.toString()).openConnection())))).getInputStream();
                } else {
                    try {
                        resourceAsStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str);
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
        try {
            InputStream inputStream = (InputStream) ((Class) setLayerPaint.values(View.MeasureSpec.makeMeasureSpec(0, 0), (-16777163) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("AGState", InputStream.class).invoke(null, bufferedInputStream);
            if (bufferedInputStream != inputStream) {
                Object[] objArr8 = new Object[1];
                values((byte) (-APIGuard[50]), r12[34], (byte) (getSharedInstance & 475), objArr8);
                Class<?> cls = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                values((byte) (-APIGuard[50]), r14[84], r14[44], objArr9);
                inputStream = new BufferedInputStream((InputStream) cls.getConstructor(Class.forName((String) objArr9[0])).newInstance(inputStream));
            }
            byte[] bArr5 = new byte[1881080];
            inputStream.read(bArr5);
            inputStream.close();
            a.e(str, bArr5);
            try {
                Object[] objArr10 = new Object[1];
                values(r4[51], r4[93], (byte) (-APIGuard[22]), objArr10);
                int intValue = ((Integer) String.class.getMethod((String) objArr10[0], Integer.TYPE).invoke(str, 47)).intValue();
                try {
                    byte b9 = APIGuard[51];
                    values(b9, (byte) (b9 - 2), (byte) (getSharedInstance & 187), new Object[1]);
                    try {
                        Object[] objArr11 = {Integer.valueOf(intValue + 4), Integer.valueOf(((Integer) String.class.getMethod((String) r7[0], null).invoke(str, null)).intValue() - 3)};
                        byte[] bArr6 = APIGuard;
                        Object[] objArr12 = new Object[1];
                        values(bArr6[44], bArr6[40], (short) 34, objArr12);
                        String str3 = (String) String.class.getMethod((String) objArr12[0], Integer.TYPE, Integer.TYPE).invoke(str, objArr11);
                        byte[] bArr7 = APIGuard;
                        byte b10 = bArr7[95];
                        byte b11 = bArr7[53];
                        Object[] objArr13 = new Object[1];
                        values(b10, b11, (byte) (b11 | 81), objArr13);
                        setDrawingCacheEnabled.AGState(setDrawingCacheEnabled.values(str3.getBytes((String) objArr13[0])), str);
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                } catch (Throwable th6) {
                    Throwable cause6 = th6.getCause();
                    if (cause6 == null) {
                        throw th6;
                    }
                    throw cause6;
                }
            } catch (Throwable th7) {
                Throwable cause7 = th7.getCause();
                if (cause7 == null) {
                    throw th7;
                }
                throw cause7;
            }
        } catch (Throwable th8) {
            Throwable cause8 = th8.getCause();
            if (cause8 == null) {
                throw th8;
            }
            throw cause8;
        }
    }

    @Override // com.apiguard3.internal.setPressed.AGState
    public final void getSharedInstance(String str) {
        int i = valueOf + 103;
        parseResponseHeaders = i % 128;
        boolean z = i % 2 != 0;
        valueOf(str);
        if (!z) {
            throw new ArithmeticException();
        }
        int i2 = parseResponseHeaders + 83;
        valueOf = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.dollar : 'L') == 'L') {
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.setPressed.AGState
    public final void AGState(String str) {
        int i = valueOf + 41;
        parseResponseHeaders = i % 128;
        boolean z = i % 2 != 0;
        values(str);
        if (z) {
            return;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.setPressed.AGState
    public final String APIGuard(String str) {
        byte[] bArr = APIGuard;
        byte b = bArr[51];
        byte b2 = bArr[13];
        values(b, b2, (byte) (b2 | 85), new Object[1]);
        if ((!str.startsWith((String) r5[0])) != true) {
            int i = getSharedInstance;
            values((byte) (i & 463), APIGuard[13], (byte) (i & 174), new Object[1]);
            if ((!str.endsWith((String) r5[0])) != true) {
                valueOf = (parseResponseHeaders + 25) % 128;
                return str;
            }
        }
        String mapLibraryName = System.mapLibraryName(str);
        parseResponseHeaders = (valueOf + 109) % 128;
        return mapLibraryName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 21) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (android.os.Build.SUPPORTED_ABIS.length <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        r0 = android.os.Build.SUPPORTED_ABIS;
        com.apiguard3.internal.setContextClickable.parseResponseHeaders = (com.apiguard3.internal.setContextClickable.valueOf + 5) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if (com.apiguard3.internal.setPressed.values(android.os.Build.CPU_ABI2) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r0 = com.apiguard3.internal.setContextClickable.valueOf + 71;
        com.apiguard3.internal.setContextClickable.parseResponseHeaders = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if ((r0 % 2) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r0 = new java.lang.String[3];
        r0[1] = android.os.Build.CPU_ABI;
        r0[0] = android.os.Build.CPU_ABI2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        return new java.lang.String[]{android.os.Build.CPU_ABI, android.os.Build.CPU_ABI2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        return new java.lang.String[]{android.os.Build.CPU_ABI};
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT >= 26 ? 'N' : 21) != 'N') goto L18;
     */
    @Override // com.apiguard3.internal.setPressed.AGState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] getSharedInstance() {
        /*
            r7 = this;
            int r0 = com.apiguard3.internal.setContextClickable.valueOf
            int r0 = r0 + 85
            int r1 = r0 % 128
            com.apiguard3.internal.setContextClickable.parseResponseHeaders = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 21
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L1d
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            r6 = 78
            if (r0 < r5) goto L1a
            r2 = 78
        L1a:
            if (r2 == r6) goto L26
            goto L36
        L1d:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L23
            r0 = 0
            goto L24
        L23:
            r0 = 1
        L24:
            if (r0 != 0) goto L36
        L26:
            java.lang.String[] r0 = android.os.Build.SUPPORTED_ABIS
            int r0 = r0.length
            if (r0 <= 0) goto L36
            java.lang.String[] r0 = android.os.Build.SUPPORTED_ABIS
            int r1 = com.apiguard3.internal.setContextClickable.valueOf
            int r1 = r1 + 5
            int r1 = r1 % 128
            com.apiguard3.internal.setContextClickable.parseResponseHeaders = r1
            return r0
        L36:
            java.lang.String r0 = android.os.Build.CPU_ABI2
            boolean r0 = com.apiguard3.internal.setPressed.values(r0)
            if (r0 != 0) goto L60
            int r0 = com.apiguard3.internal.setContextClickable.valueOf
            int r0 = r0 + 71
            int r2 = r0 % 128
            com.apiguard3.internal.setContextClickable.parseResponseHeaders = r2
            int r0 = r0 % r1
            if (r0 != 0) goto L55
            r0 = 3
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = android.os.Build.CPU_ABI
            r0[r4] = r1
            java.lang.String r1 = android.os.Build.CPU_ABI2
            r0[r3] = r1
            return r0
        L55:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.String r1 = android.os.Build.CPU_ABI
            r0[r3] = r1
            java.lang.String r1 = android.os.Build.CPU_ABI2
            r0[r4] = r1
            return r0
        L60:
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.String r1 = android.os.Build.CPU_ABI
            r0[r3] = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setContextClickable.getSharedInstance():java.lang.String[]");
    }
}
