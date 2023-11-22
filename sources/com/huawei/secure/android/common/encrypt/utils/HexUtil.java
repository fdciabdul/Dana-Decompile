package com.huawei.secure.android.common.encrypt.utils;

import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes8.dex */
public final class HexUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int[] getAuthRequestContext = {1943620587, 1299464004, 1594125934, -1732623821, 101521510, 1428588943, -1122138741, -995338673, 1297742909, 912479861, 218209143, 1076192575, 1576526535, 635685993, 1171100483, -1497601795, -748244377, 2007745692};

    private HexUtil() {
    }

    public static String getAuthRequestContext(byte[] bArr) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            if (bArr == null) {
                return "";
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            if (bArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            while (true) {
                if ((i5 < bArr.length ? (char) 7 : 'T') != 'T') {
                    String hexString = Integer.toHexString(bArr[i5] & 255);
                    if ((hexString.length() == 1 ? '\r' : 'N') == '\r') {
                        sb.append('0');
                        int i6 = BuiltInFictitiousFunctionClassFactory + 47;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                    sb.append(hexString);
                    i5++;
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static byte[] getAuthRequestContext(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 121;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = 1;
        if (TextUtils.isEmpty(str)) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            return new byte[0];
        }
        try {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                int i6 = 4;
                int i7 = 866551476;
                int i8 = -247893212;
                Object[] objArr = new Object[1];
                a(TextUtils.indexOf("", "", 0) + 5, new int[]{866551476, -247893212, -1305383951, 1884834039}, objArr);
                byte[] bytes = upperCase.getBytes(((String) objArr[0]).intern());
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                BuiltInFictitiousFunctionClassFactory = i9 % 128;
                int i10 = i9 % 2;
                int i11 = 0;
                while (i11 < length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0x");
                    byte[] bArr2 = new byte[i3];
                    int i12 = i11 * 2;
                    bArr2[0] = bytes[i12];
                    int i13 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 5;
                    int[] iArr = new int[i6];
                    iArr[0] = i7;
                    iArr[1] = i8;
                    iArr[2] = -1305383951;
                    iArr[3] = 1884834039;
                    Object[] objArr2 = new Object[1];
                    a(i13, iArr, objArr2);
                    sb.append(new String(bArr2, ((String) objArr2[0]).intern()));
                    byte byteValue = (byte) (Byte.decode(sb.toString()).byteValue() << i6);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    byte[] bArr3 = {bytes[i12 + 1]};
                    int indexOf = 4 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    int[] iArr2 = new int[i6];
                    iArr2[0] = 866551476;
                    iArr2[1] = -247893212;
                    iArr2[2] = -1305383951;
                    iArr2[3] = 1884834039;
                    Object[] objArr3 = new Object[1];
                    a(indexOf, iArr2, objArr3);
                    sb2.append(new String(bArr3, ((String) objArr3[0]).intern()));
                    bArr[i11] = (byte) (byteValue ^ Byte.decode(sb2.toString()).byteValue());
                    i11++;
                    i3 = 1;
                    i6 = 4;
                    i7 = 866551476;
                    i8 = -247893212;
                }
                return bArr;
            } catch (UnsupportedEncodingException | NumberFormatException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("hex string 2 byte array exception : ");
                sb3.append(e.getMessage());
                b.PlaceComponentResult("HexUtil", sb3.toString());
                return new byte[0];
            }
        } catch (Throwable th) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("hex string toUpperCase exception : ");
            sb4.append(th.getMessage());
            b.PlaceComponentResult("HexUtil", sb4.toString());
            return new byte[0];
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int length;
        int[] iArr2;
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = getAuthRequestContext;
        boolean z = true;
        if (iArr3 != null) {
            try {
                int i3 = $11 + 17;
                $10 = i3 % 128;
                if (i3 % 2 != 0) {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i2 = 1;
                } else {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i2 = 0;
                }
                while (i2 < length) {
                    iArr2[i2] = (int) (iArr3[i2] ^ (-3152031022165484798L));
                    i2++;
                }
                iArr3 = iArr2;
            } catch (Exception e) {
                throw e;
            }
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getAuthRequestContext;
        if ((iArr5 != null ? Typography.greater : 'A') == '>') {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i4 = 0;
            while (true) {
                if ((i4 >= length3) == z) {
                    try {
                        break;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                iArr6[i4] = (int) (iArr5[i4] ^ (-3152031022165484798L));
                i4++;
                z = true;
            }
            int i5 = $10 + 21;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            int i7 = $10 + 51;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i9 = 0; i9 < 16; i9++) {
                int i10 = $11 + 49;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
            }
            int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
