package com.huawei.hms.hatool;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.primitives.SignedBytes;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes8.dex */
public class e {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static short[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static byte[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private static int moveToNextValue;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(1512966525 - Color.blue(0), View.MeasureSpec.makeMeasureSpec(0, 0) - 16, (short) (KeyEvent.getMaxKeyCode() >> 16), ImageFormat.getBitsPerPixel(0) - 1239757757, (byte) (KeyEvent.getDeadChar(0, 0) - 44), objArr);
        Charset.forName(((String) objArr[0]).intern());
        int i = getErrorConfigVersion + 23;
        moveToNextValue = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    private static PublicKey BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        PublicKey generatePublic = KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr));
        int i = getErrorConfigVersion + 117;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return generatePublic;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        int i = moveToNextValue + 103;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(1512966525 - (ViewConfiguration.getFadingEdgeLength() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) - 16, (short) Color.red(0), ((byte) KeyEvent.getModifierMetaStateMask()) - 1239757757, (byte) ((-44) - TextUtils.getOffsetAfter("", 0)), objArr);
            String PlaceComponentResult2 = PlaceComponentResult(str, str2.getBytes(((String) objArr[0]).intern()));
            int i3 = moveToNextValue + 39;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return PlaceComponentResult2;
        } catch (UnsupportedEncodingException unused) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = 1257195664;
        BuiltInFictitiousFunctionClassFactory = 51018892;
        MyBillsEntityDataFactory = new byte[]{105, SignedBytes.MAX_POWER_OF_TWO, -84, -71, -76};
        getAuthRequestContext = -281100772;
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, PublicKey publicKey) {
        String str;
        int i = moveToNextValue + 65;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            if (!(publicKey == null)) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                cipher.init(1, publicKey);
                byte[] doFinal = cipher.doFinal(bArr);
                int i3 = getErrorConfigVersion + 81;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
                return doFinal;
            }
            throw new UnsupportedEncodingException("The loaded public key is null");
        } catch (UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr2 = new byte[0];
            try {
                int i5 = getErrorConfigVersion + 35;
                moveToNextValue = i5 % 128;
                int i6 = i5 % 2;
                return bArr2;
            } catch (Exception e) {
                throw e;
            }
        } catch (InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr22 = new byte[0];
            int i52 = getErrorConfigVersion + 35;
            moveToNextValue = i52 % 128;
            int i62 = i52 % 2;
            return bArr22;
        } catch (NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr222 = new byte[0];
            int i522 = getErrorConfigVersion + 35;
            moveToNextValue = i522 % 128;
            int i622 = i522 % 2;
            return bArr222;
        } catch (BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr2222 = new byte[0];
            int i5222 = getErrorConfigVersion + 35;
            moveToNextValue = i5222 % 128;
            int i6222 = i5222 % 2;
            return bArr2222;
        } catch (IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr22222 = new byte[0];
            int i52222 = getErrorConfigVersion + 35;
            moveToNextValue = i52222 % 128;
            int i62222 = i52222 % 2;
            return bArr22222;
        } catch (NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            y.moveToNextValue("hmsSdk", str);
            byte[] bArr222222 = new byte[0];
            int i522222 = getErrorConfigVersion + 35;
            moveToNextValue = i522222 % 128;
            int i622222 = i522222 % 2;
            return bArr222222;
        }
    }

    private static String PlaceComponentResult(String str, byte[] bArr) {
        String str2;
        if ((bArr != null ? (char) 18 : '^') != '^') {
            int i = moveToNextValue + 121;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            if (bArr.length != 0) {
                try {
                    return HexUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(bArr, BuiltInFictitiousFunctionClassFactory(HexUtil.getAuthRequestContext(str))));
                } catch (NoSuchAlgorithmException unused) {
                    str2 = "encrypt(): getInstance - No such algorithm,transformation";
                    y.moveToNextValue("hmsSdk", str2);
                    int i3 = getErrorConfigVersion + 89;
                    moveToNextValue = i3 % 128;
                    int i4 = i3 % 2;
                    return "";
                } catch (InvalidKeySpecException unused2) {
                    str2 = "encrypt(): Invalid key specification";
                    y.moveToNextValue("hmsSdk", str2);
                    int i32 = getErrorConfigVersion + 89;
                    moveToNextValue = i32 % 128;
                    int i42 = i32 % 2;
                    return "";
                }
            }
        }
        y.moveToNextValue("hmsSdk", "encrypt: content is empty or null");
        try {
            int i5 = moveToNextValue + 71;
            try {
                getErrorConfigVersion = i5 % 128;
                if ((i5 % 2 == 0 ? (char) 24 : (char) 29) != 29) {
                    Object obj = null;
                    obj.hashCode();
                    return "";
                }
                return "";
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if ((r2 != null ? 24 : 'M') != 'M') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        r9 = r2.length;
        r10 = new byte[r9];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r2 >= r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        r12 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        r12 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        if (r12 == '\f') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        r10[r2] = (byte) (r8[r2] ^ 3097486228508854431L);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        r2 = com.huawei.hms.hatool.e.$10 + 13;
        com.huawei.hms.hatool.e.$11 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        if ((r2 % 2) != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        r2 = ((byte) (com.huawei.hms.hatool.e.MyBillsEntityDataFactory[r13 / ((int) (com.huawei.hms.hatool.e.getAuthRequestContext + 3097486228508854431L))] * 3097486228508854431L)) % ((int) (com.huawei.hms.hatool.e.PlaceComponentResult | 3097486228508854431L));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        r2 = ((byte) (com.huawei.hms.hatool.e.MyBillsEntityDataFactory[r13 + ((int) (com.huawei.hms.hatool.e.getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (com.huawei.hms.hatool.e.PlaceComponentResult ^ 3097486228508854431L));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        r2 = (byte) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r2 = (short) (((short) (com.huawei.hms.hatool.e.KClassImpl$Data$declaredNonStaticMembers$2[r13 + ((int) (com.huawei.hms.hatool.e.getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (com.huawei.hms.hatool.e.PlaceComponentResult ^ 3097486228508854431L)));
        r8 = com.huawei.hms.hatool.e.$11 + 25;
        com.huawei.hms.hatool.e.$10 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
    
        if (r3 != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
    
        if (r3 != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f2, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.e.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
