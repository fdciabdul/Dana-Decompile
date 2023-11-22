package com.iap.ac.android.common.utils.security;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.cashier.view.InputCardNumberView;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.text.Typography;
import o.getCallingPid;

/* loaded from: classes2.dex */
public class RSAHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 42070;
    public static final String DEFAULT_ALGORITHM = "RSA";
    public static final String DEFAULT_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {37367, 37366, 37360, 37274, 37361, 37257, 37275, 37346, 37363};
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    public static final String TAG = "RSAHelper";

    public static byte[] decrypt(String str, PrivateKey privateKey) {
        Object[] objArr = null;
        if (str != null) {
            if (!str.equals("")) {
                int i = MyBillsEntityDataFactory + 75;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                Object[] objArr2 = new Object[1];
                a(new char[]{6, 0, 4, '\b', 13848}, (byte) (118 - TextUtils.getOffsetAfter("", 0)), 6 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr2);
                byte[] decryptBytes = decryptBytes(str.getBytes(Charset.forName(((String) objArr2[0]).intern())), privateKey);
                int i3 = PlaceComponentResult + 17;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    int length = objArr.length;
                    return decryptBytes;
                }
                return decryptBytes;
            }
        }
        int i4 = PlaceComponentResult + 63;
        MyBillsEntityDataFactory = i4 % 128;
        if (!(i4 % 2 != 0)) {
            return null;
        }
        int length2 = objArr.length;
        return null;
    }

    public static PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
                int i = PlaceComponentResult + 71;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return generatePublic;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static byte[] decryptBytes(byte[] bArr, PrivateKey privateKey) {
        int i = PlaceComponentResult + 105;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        if (!(bArr != null)) {
            int i3 = PlaceComponentResult + 95;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            int i5 = PlaceComponentResult + 69;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            return null;
        } else if (privateKey != null) {
            try {
                Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORMATION);
                cipher.init(2, privateKey);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                InstrumentInjector.log_e(TAG, "", e);
                return null;
            }
        } else {
            int i7 = MyBillsEntityDataFactory + 65;
            PlaceComponentResult = i7 % 128;
            if (!(i7 % 2 != 0)) {
                int length = objArr.length;
                return null;
            }
            return null;
        }
    }

    public static byte[] encryptBytes(byte[] bArr, PublicKey publicKey) {
        int i = PlaceComponentResult + 107;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((bArr == null ? 'b' : '%') != '%') {
            return null;
        }
        if (publicKey == null) {
            int i3 = PlaceComponentResult + 53;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORMATION);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            InstrumentInjector.log_e(TAG, "", e);
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        int i = PlaceComponentResult + 79;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            byte[] encrypt = encrypt(str, getPublicKey(str2));
            if ((encrypt == null ? 'C' : Typography.less) == 'C') {
                InstrumentInjector.log_e(TAG, "encrypt with empty input");
                return null;
            }
            try {
                String str3 = new String(Base64.encode(encrypt, 2));
                int i3 = PlaceComponentResult + 103;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return str3;
            } catch (Exception e) {
                throw e;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            try {
                InstrumentInjector.log_e(TAG, "", e2);
                return null;
            } catch (Exception e3) {
                throw e3;
            }
        }
    }

    public static byte[] encrypt(String str, PublicKey publicKey) {
        if ((str != null ? ':' : '^') != ':' || str.equals("")) {
            int i = MyBillsEntityDataFactory + 75;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                int i2 = 53 / 0;
                return null;
            }
            return null;
        }
        int i3 = MyBillsEntityDataFactory + 111;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        Object[] objArr = new Object[1];
        a(new char[]{6, 0, 4, '\b', 13848}, (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 118), 5 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr);
        byte[] encryptBytes = encryptBytes(str.getBytes(Charset.forName(((String) objArr[0]).intern())), publicKey);
        int i5 = PlaceComponentResult + 29;
        MyBillsEntityDataFactory = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 71 / 0;
            return encryptBytes;
        }
        return encryptBytes;
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ BuiltInFictitiousFunctionClassFactory);
        char[] cArr4 = new char[i];
        if ((i % 2 != 0 ? 'E' : 'b') != 'E') {
            i2 = i;
        } else {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        }
        if ((i2 > 1 ? 'a' : InputCardNumberView.DIVIDER) == 'a') {
            int i4 = $11 + 17;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if ((getcallingpid.getAuthRequestContext < i2 ? '\f' : 'a') == 'a') {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    int i6 = $11 + 39;
                    $10 = i6 % 128;
                    if (i6 % 2 != 0) {
                        try {
                            cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory / b);
                            cArr4[getcallingpid.getAuthRequestContext * 1] = (char) (getcallingpid.PlaceComponentResult >>> b);
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    }
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        int i7 = $11 + 109;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                    } else {
                        int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i15 = 0; i15 < i; i15++) {
            cArr4[i15] = (char) (cArr4[i15] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
