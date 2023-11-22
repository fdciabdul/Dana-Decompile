package com.iap.ac.config.lite.utils;

import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.text.Typography;
import o.B;

/* loaded from: classes3.dex */
public class RsaUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1257195657;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult = 28944509;
    public static final String TRANSFORMATION = "RSA/None/PKCS1Padding";
    private static short[] getAuthRequestContext;
    private static int scheduleImpl;
    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {-79, -107, -118, -67, -97};
    private static int BuiltInFictitiousFunctionClassFactory = -980447165;

    public static String decrypt(String str, String str2) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 0)));
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, generatePrivate);
        byte[] doFinal = cipher.doFinal(Base64.decode(str, 0));
        Object[] objArr = new Object[1];
        a(1889478436 - ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getScrollBarSize() >> 8) - 17, (short) (KeyEvent.getDeadChar(0, 0) - 35), (-1263984782) - Process.getGidForName(""), (byte) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), objArr);
        String str3 = new String(doFinal, ((String) objArr[0]).intern());
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '*' : '\t') != '\t') {
            Object obj = null;
            obj.hashCode();
            return str3;
        }
        return str3;
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int i4;
        boolean z2;
        char c;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i5 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        if (i5 == -1) {
            int i6 = $10 + 61;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            z = true;
        } else {
            z = false;
        }
        if (!(!z)) {
            byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i8 = 0; i8 < length; i8++) {
                    bArr2[i8] = (byte) (bArr[i8] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                int i9 = $11 + 33;
                $10 = i9 % 128;
                i5 = (byte) (i9 % 2 != 0 ? ((byte) (KClassImpl$Data$declaredNonStaticMembers$2[i * ((int) (BuiltInFictitiousFunctionClassFactory - 3097486228508854431L))] & 3097486228508854431L)) % ((int) (MyBillsEntityDataFactory / 3097486228508854431L)) : ((byte) (KClassImpl$Data$declaredNonStaticMembers$2[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            } else {
                i5 = (short) (((short) (getAuthRequestContext[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            }
        }
        if (i5 > 0) {
            int i10 = ((i + i5) - 2) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
            if (z) {
                int i11 = $10 + 43;
                $11 = i11 % 128;
                if (i11 % 2 == 0) {
                }
                i4 = 1;
            } else {
                i4 = 0;
            }
            b2.getAuthRequestContext = i10 + i4;
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (bArr3 != null) {
                int i12 = $11 + 69;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i14 = 0; i14 < length2; i14++) {
                    bArr4[i14] = (byte) (bArr3[i14] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            if ((bArr3 != null ? Typography.amp : 'C') != '&') {
                z2 = false;
            } else {
                try {
                    int i15 = $10 + 17;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    z2 = true;
                } catch (Exception e) {
                    throw e;
                }
            }
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (true) {
                if (!(b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5)) {
                    break;
                }
                int i17 = $11 + 61;
                $10 = i17 % 128;
                int i18 = i17 % 2;
                if (z2) {
                    int i19 = $10 + 123;
                    $11 = i19 % 128;
                    if (i19 % 2 == 0) {
                        try {
                            byte[] bArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
                            b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                            c = (char) (b2.PlaceComponentResult >> (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) | b));
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        byte[] bArr6 = KClassImpl$Data$declaredNonStaticMembers$2;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        c = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr6[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    b2.MyBillsEntityDataFactory = c;
                } else {
                    short[] sArr = getAuthRequestContext;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
