package com.alibaba.griver.base.common.utils;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class MD5Util {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String ALGORIGTHM_MD5 = "MD5";
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static char[] PlaceComponentResult;

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f6313a;
    private static int getAuthRequestContext;

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 42070;
        PlaceComponentResult = new char[]{42068, 42065, 37367, 42071, 37274, 37275, 42070, 37346, 37257};
    }

    static {
        MyBillsEntityDataFactory();
        f6313a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int i = getAuthRequestContext + 67;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (char) 23 : '(') != 23) {
            return;
        }
        int i2 = 2 / 0;
    }

    public static MessageDigest getMD5Digest() {
        try {
            int i = getAuthRequestContext + 71;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(ALGORIGTHM_MD5);
                int i3 = getAuthRequestContext + 49;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return messageDigest;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static byte[] getMD5Byte(byte[] bArr) {
        int i = MyBillsEntityDataFactory + 81;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr);
        byte[] digest = mD5Digest.digest();
        int i3 = getAuthRequestContext + 55;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 89 / 0;
            return digest;
        }
        return digest;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if ((android.text.TextUtils.isEmpty(r6) ? '`' : 'O') != '`') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getMD5Byte(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.MD5Util.MyBillsEntityDataFactory
            int r0 = r0 + 71
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.MD5Util.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L17
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            int r2 = r1.length     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L26
            goto L75
        L15:
            r6 = move-exception
            throw r6
        L17:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r2 = 96
            if (r0 == 0) goto L22
            r0 = 96
            goto L24
        L22:
            r0 = 79
        L24:
            if (r0 == r2) goto L75
        L26:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L30
            r0 = 0
            goto L31
        L30:
            r0 = 1
        L31:
            if (r0 == 0) goto L34
            goto L58
        L34:
            r7 = 5
            char[] r7 = new char[r7]
            r7 = {x0076: FILL_ARRAY_DATA , data: [5, 3, 6, 8, 13842} // fill-array
            java.lang.String r0 = ""
            int r4 = android.view.MotionEvent.axisFromString(r0)
            int r4 = r4 + 113
            byte r4 = (byte) r4
            r5 = 48
            int r0 = android.text.TextUtils.lastIndexOf(r0, r5, r3)
            int r0 = 4 - r0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            b(r7, r4, r0, r2)
            r7 = r2[r3]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r7.intern()
        L58:
            byte[] r6 = r6.getBytes(r7)     // Catch: java.lang.Throwable -> L6b
            byte[] r6 = getMD5Byte(r6)     // Catch: java.lang.Throwable -> L6b
            int r7 = com.alibaba.griver.base.common.utils.MD5Util.getAuthRequestContext
            int r7 = r7 + 85
            int r0 = r7 % 128
            com.alibaba.griver.base.common.utils.MD5Util.MyBillsEntityDataFactory = r0
            int r7 = r7 % 2
            return r6
        L6b:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            java.lang.String r0 = "MD5Util"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r7, r6)
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.MD5Util.getMD5Byte(java.lang.String, java.lang.String):byte[]");
    }

    public static byte[] getMD5Byte(String str) {
        Object obj;
        int i = MyBillsEntityDataFactory + 113;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = new Object[1];
            b(new char[]{5, 3, 6, '\b', 13842}, (byte) ((ViewConfiguration.getMinimumFlingVelocity() << 76) * 89), 2 % (ViewConfiguration.getMinimumFlingVelocity() / 84), objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            b(new char[]{5, 3, 6, '\b', 13842}, (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 112), 5 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr2);
            obj = objArr2[0];
        }
        return getMD5Byte(str, ((String) obj).intern());
    }

    public static String getMD5Base64(String str) {
        int i = getAuthRequestContext + 21;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            b(new char[]{5, 3, 6, '\b', 13842}, (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 113), View.combineMeasuredStates(0, 0) + 5, objArr);
            String encodeToString = Base64.encodeToString(getMD5Byte(str.getBytes(((String) objArr[0]).intern())), 2);
            int i3 = MyBillsEntityDataFactory + 83;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return encodeToString;
        } catch (Throwable th) {
            RVLogger.e(com.alibaba.griver.beehive.lottie.util.MD5Util.TAG, th.getMessage(), th);
            return null;
        }
    }

    public static String getMD5String(String str) {
        int i = getAuthRequestContext + 89;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            b(new char[]{5, 3, 6, '\b', 13842}, (byte) (112 - Color.alpha(0)), 5 - TextUtils.indexOf("", ""), objArr);
            String bytesToHexString = HexStringUtil.bytesToHexString(getMD5Byte(str.getBytes(((String) objArr[0]).intern())));
            int i3 = getAuthRequestContext + 99;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return bytesToHexString;
        } catch (Throwable th) {
            RVLogger.e(com.alibaba.griver.beehive.lottie.util.MD5Util.TAG, th.getMessage(), th);
            return null;
        }
    }

    public static String getMD5String(byte[] bArr) {
        try {
            int i = MyBillsEntityDataFactory + 25;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                try {
                    String bytesToHexString = HexStringUtil.bytesToHexString(getMD5Byte(bArr));
                    int i3 = MyBillsEntityDataFactory + 79;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return bytesToHexString;
                } catch (Throwable th) {
                    RVLogger.e(com.alibaba.griver.beehive.lottie.util.MD5Util.TAG, th.getMessage(), th);
                    return null;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String getFileMD5String(File file) {
        MessageDigest messageDigest;
        try {
            messageDigest = getMD5Digest();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[4194304];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    int i = MyBillsEntityDataFactory + 69;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    messageDigest.update(bArr, 0, read);
                    int i3 = getAuthRequestContext + 125;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                }
                fileInputStream.close();
                int i5 = MyBillsEntityDataFactory + 33;
                getAuthRequestContext = i5 % 128;
                int i6 = i5 % 2;
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            messageDigest = null;
        }
        return a(messageDigest.digest());
    }

    private static String a(byte[] bArr) {
        int i = MyBillsEntityDataFactory + 25;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
        }
        String a2 = a(bArr, 0, bArr.length);
        int i2 = getAuthRequestContext + 99;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? 'H' : 'G') != 'H') {
            return a2;
        }
        Object obj = null;
        obj.hashCode();
        return a2;
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = getAuthRequestContext + 57;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i;
        while (true) {
            if ((i5 < i2 + i ? 'b' : '%') != 'b') {
                return stringBuffer.toString();
            }
            try {
                int i6 = MyBillsEntityDataFactory + 79;
                getAuthRequestContext = i6 % 128;
                if ((i6 % 2 != 0 ? 'I' : (char) 29) != 29) {
                    a(bArr[i5], stringBuffer);
                    i5 += 123;
                } else {
                    a(bArr[i5], stringBuffer);
                    i5++;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char c;
        char c2;
        int i = getAuthRequestContext + 35;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            char[] cArr = f6313a;
            c = cArr[(b & 240) >> 4];
            c2 = cArr[b & 15];
        } else {
            char[] cArr2 = f6313a;
            c = cArr2[(b & 30046) >> 4];
            c2 = cArr2[b ^ Byte.MAX_VALUE];
        }
        stringBuffer.append(c);
        stringBuffer.append(c2);
        int i2 = MyBillsEntityDataFactory + 9;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        r7 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ef, code lost:
    
        r7 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f1, code lost:
    
        if (r7 == 'Y') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f9, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fb, code lost:
    
        r7 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fe, code lost:
    
        r7 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
    
        if (r7 == ':') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0102, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011e, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0171, code lost:
    
        r7 = com.alibaba.griver.base.common.utils.MD5Util.$11 + 1;
        com.alibaba.griver.base.common.utils.MD5Util.$10 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0182, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0183, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.MD5Util.b(char[], byte, int, java.lang.Object[]):void");
    }
}
