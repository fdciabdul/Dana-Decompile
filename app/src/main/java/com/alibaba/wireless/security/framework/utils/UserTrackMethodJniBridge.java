package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
import o.E;

/* loaded from: classes.dex */
public class UserTrackMethodJniBridge {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static long MyBillsEntityDataFactory = 0;
    public static final int PlaceComponentResult;

    /* renamed from: a  reason: collision with root package name */
    private static Context f6798a = null;
    private static String b = null;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    private static Class g = null;
    public static final byte[] getAuthRequestContext;
    private static Class h = null;
    private static Class i = null;
    private static Constructor j = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static int moveToNextValue = 0;
    private static Method n = null;

    /* renamed from: o  reason: collision with root package name */
    private static final char[] f6799o;
    private static int scheduleImpl = 1;

    static {
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext = new byte[]{38, -105, 32, Ascii.RS, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
        PlaceComponentResult = 211;
        f6799o = "0123456789abcdef".toCharArray();
        int i2 = moveToNextValue + 89;
        scheduleImpl = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 15 / 0;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 38293;
        MyBillsEntityDataFactory = 4360990799332652212L;
        BuiltInFictitiousFunctionClassFactory = -956812108;
    }

    private static String a() {
        String substring;
        synchronized (UserTrackMethodJniBridge.class) {
            String str = b;
            if (str == null || str.length() == 0) {
                b = b();
            }
            String str2 = b;
            substring = str2.substring(0, str2.length() / 8);
        }
        return substring;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if ((r23 != null ? 'a' : 'B') != 'a') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r23 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r0 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r13.length() != 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int addUtRecord(java.lang.String r13, int r14, int r15, java.lang.String r16, long r17, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.addUtRecord(java.lang.String, int, int, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):int");
    }

    private static String b() {
        String str = "";
        try {
            String obj = UUID.randomUUID().toString();
            long nanoTime = System.nanoTime();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            sb.append(String.valueOf(nanoTime));
            String obj2 = sb.toString();
            Object[] objArr = new Object[1];
            p(new char[]{940, 58915, 47501, 1213, 56964}, new char[]{47815, 17733, 38354, 22680}, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 39061), new char[]{0, 0, 0, 0}, (-767212102) - TextUtils.indexOf("", "", 0, 0), objArr);
            str = bytesToHex(messageDigest.digest(obj2.getBytes(((String) objArr[0]).intern())));
        } catch (Exception unused) {
        }
        int i2 = scheduleImpl + 45;
        moveToNextValue = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    public static String bytesToHex(byte[] bArr) {
        int i2 = moveToNextValue + 93;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        while (true) {
            if ((i4 < bArr.length ? (char) 24 : (char) 1) == 1) {
                return new String(cArr);
            }
            try {
                int i5 = moveToNextValue + 123;
                scheduleImpl = i5 % 128;
                if (i5 % 2 != 0) {
                    int i6 = bArr[i4] & 255;
                    int i7 = i4 * 2;
                    char[] cArr2 = f6799o;
                    cArr[i7] = cArr2[i6 >>> 4];
                    cArr[i7 + 1] = cArr2[i6 & 15];
                    i4++;
                } else {
                    int i8 = bArr[i4] ^ 16337;
                    int i9 = i4 / 4;
                    char[] cArr3 = f6799o;
                    cArr[i9] = cArr3[i8 >> 2];
                    cArr[i9 / 0] = cArr3[i8 ^ 28];
                    i4 += 37;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r0.length > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if ((r0.length > 0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r14 <= 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r3 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl + 19;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r15 <= 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        r3 = new java.lang.StringBuilder();
        r5 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r5 >= r0.length) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        r7 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl + 105;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if (r6 >= r15) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        if (r3.length() >= r14) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        if (r5 <= 1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        r6 = r6 + 1;
        r7 = r0[r5];
        r8 = new java.lang.StringBuilder();
        r9 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue + 17;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        r13 = new java.lang.Object[1];
        q((byte) (com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext[45] + 1), com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext[43], com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext[7], r13);
        r9 = java.lang.Class.forName((java.lang.String) r13[0]);
        r10 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext[43];
        r13 = new java.lang.Object[1];
        q(r10, (byte) (r10 + 3), com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext[43], r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        r8.append((java.lang.String) r9.getMethod((java.lang.String) r13[0], null).invoke(r7, null));
        r8.append(".");
        r8.append(r7.getMethodName());
        r3.append(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
    
        if (r5 >= (r0.length - 1)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cc, code lost:
    
        r7 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl + 59;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r7 % 128;
        r7 = r7 % 2;
        r3.append("#");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00db, code lost:
    
        if (r7 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
    
        r7 = 11 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
    
        r15 = r14.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e8, code lost:
    
        if (r15 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
    
        throw r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ec, code lost:
    
        r5 = r5 + 1;
        r7 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl + 69;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fa, code lost:
    
        r14 = r3.toString();
        r15 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl + 109;
        com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r15 % 128;
        r15 = r15 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getStackTrace(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getStackTrace(int, int):java.lang.String");
    }

    public static void init(Context context) {
        try {
            int i2 = moveToNextValue + 23;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            if ((context != null ? '^' : 'X') != '^') {
                return;
            }
            f6798a = context;
            int i4 = scheduleImpl + 1;
            moveToNextValue = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:24:0x0054). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void q(short r8, int r9, byte r10, java.lang.Object[] r11) {
        /*
            int r0 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue = r1
            int r0 = r0 % 2
            int r9 = 106 - r9
            int r8 = 57 - r8
            int r10 = r10 + 12
            byte[] r0 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.getAuthRequestContext
            byte[] r1 = new byte[r10]
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L1a
            r4 = 1
            goto L1b
        L1a:
            r4 = 0
        L1b:
            if (r4 == 0) goto L3a
            int r9 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.moveToNextValue
            int r9 = r9 + 21
            int r4 = r9 % 128
            com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.scheduleImpl = r4
            int r9 = r9 % 2
            if (r9 != 0) goto L2b
            r9 = 1
            goto L2c
        L2b:
            r9 = 0
        L2c:
            if (r9 == r2) goto L2f
            goto L31
        L2f:
            r9 = 0
            int r9 = r9.length     // Catch: java.lang.Throwable -> L38
        L31:
            r9 = r8
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L54
        L38:
            r8 = move-exception
            throw r8
        L3a:
            r4 = 0
        L3b:
            int r5 = r4 + 1
            byte r6 = (byte) r9
            r1[r4] = r6
            if (r5 != r10) goto L4a
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r3)
            r11[r3] = r8
            return
        L4a:
            r4 = r0[r8]
            r7 = r9
            r9 = r8
            r8 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r7
        L54:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + 2
            int r9 = r9 + r2
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            r7 = r9
            r9 = r8
            r8 = r7
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.q(short, int, byte, java.lang.Object[]):void");
    }

    public static int utAvaiable() {
        if (f == 0) {
            synchronized (UserTrackMethodJniBridge.class) {
                if (f == 0) {
                    try {
                        g = Class.forName("com.ut.mini.internal.UTOriginalCustomHitBuilder");
                        h = Class.forName("com.ut.mini.UTAnalytics");
                        i = Class.forName("com.ut.mini.UTTracker");
                        j = g.getConstructor(String.class, Integer.TYPE, String.class, String.class, String.class, Map.class);
                        k = g.getMethod("build", new Class[0]);
                        l = h.getMethod("getInstance", new Class[0]);
                        m = h.getMethod("getDefaultTracker", new Class[0]);
                        n = i.getMethod(DataflowMonitorModel.METHOD_NAME_SEND, Map.class);
                        e = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                    f = 1;
                }
            }
        }
        return e;
    }

    private static void p(char[] cArr, char[] cArr2, char c2, char[] cArr3, int i2, Object[] objArr) {
        E e2 = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c2);
        cArr5[2] = (char) (cArr5[2] + ((char) i2));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e2.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e2.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'J' : Typography.dollar) != '$') {
                int i3 = $11 + 1;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = (e2.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i6 = (e2.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e2.MyBillsEntityDataFactory = (char) (((cArr4[e2.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i5]) % 65535);
                cArr5[i6] = (char) (((cArr4[i6] * 32718) + cArr5[i5]) / 65535);
                cArr4[i6] = e2.MyBillsEntityDataFactory;
                cArr6[e2.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i6] ^ cArr[e2.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (MyBillsEntityDataFactory ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)));
                e2.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i7 = $11 + 95;
                $10 = i7 % 128;
                int i8 = i7 % 2;
            } else {
                String str = new String(cArr6);
                int i9 = $10 + 59;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
