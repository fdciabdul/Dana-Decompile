package com.huawei.hms.framework.network.grs.h;

import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.E;

/* loaded from: classes8.dex */
public class b {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final Pattern MyBillsEntityDataFactory;
    private static int PlaceComponentResult = 0;
    private static final String getAuthRequestContext = "b";
    private static int lookAheadTest = 0;
    private static int scheduleImpl = 1;

    static {
        BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
        int i = scheduleImpl + 83;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 13492;
        KClassImpl$Data$declaredNonStaticMembers$2 = 6270329442987411462L;
        PlaceComponentResult = -956812108;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = scheduleImpl + 105;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            return str;
        }
        int i3 = 0;
        int i4 = 1;
        if (!(str.length() != 1)) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i3 < str.length()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(i3));
                String obj = sb.toString();
                if ((MyBillsEntityDataFactory.matcher(obj).matches() ? '\\' : Typography.amp) != '&') {
                    int i5 = lookAheadTest + 43;
                    scheduleImpl = i5 % 128;
                    int i6 = i5 % 2;
                    if ((i4 % 2 == 0 ? '[' : ':') == '[') {
                        obj = "*";
                    }
                    i4++;
                }
                stringBuffer.append(obj);
                i3++;
                int i7 = lookAheadTest + 57;
                scheduleImpl = i7 % 128;
                int i8 = i7 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        String obj2 = stringBuffer.toString();
        int i9 = scheduleImpl + 9;
        lookAheadTest = i9 % 128;
        int i10 = i9 % 2;
        return obj2;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        try {
            int i = lookAheadTest + 5;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            int i3 = 0;
            while (true) {
                if (i3 >= bArr.length) {
                    return sb.toString();
                }
                String hexString = Integer.toHexString(bArr[i3] & 255);
                if (!(hexString.length() != 1)) {
                    sb.append("0");
                }
                sb.append(hexString);
                i3++;
                int i4 = lookAheadTest + 83;
                scheduleImpl = i4 % 128;
                int i5 = i4 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getAuthRequestContext(String str) {
        String authRequestContext;
        try {
            int i = lookAheadTest + 69;
            scheduleImpl = i % 128;
            if (!(i % 2 != 0)) {
                authRequestContext = getAuthRequestContext(str, "SHA-256");
                int i2 = 16 / 0;
            } else {
                authRequestContext = getAuthRequestContext(str, "SHA-256");
            }
            int i3 = scheduleImpl + 93;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String getAuthRequestContext(String str, String str2) {
        String str3;
        String str4;
        String KClassImpl$Data$declaredNonStaticMembers$22;
        int i = lookAheadTest + 43;
        scheduleImpl = i % 128;
        Object obj = null;
        try {
            try {
                if ((i % 2 == 0 ? 'Z' : '\t') != 'Z') {
                    Object[] objArr = new Object[1];
                    a(new char[]{5499, 59252, 64800, 25990, 45772}, new char[]{43323, 51685, 1627, 52048}, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 20486), new char[]{15538, 59144, 62830, 27521}, 1539958184 - Process.getGidForName(""), objArr);
                    KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(MessageDigest.getInstance(str2).digest(str.getBytes(((String) objArr[0]).intern())));
                } else {
                    Object[] objArr2 = new Object[1];
                    a(new char[]{5499, 59252, 64800, 25990, 45772}, new char[]{43323, 51685, 1627, 52048}, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(1) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(1) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) * 30013), new char[]{15538, 59144, 62830, 27521}, 1539958184 >>> Process.getGidForName(""), objArr2);
                    KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(MessageDigest.getInstance(str2).digest(str.getBytes(((String) objArr2[0]).intern())));
                }
                int i2 = lookAheadTest + 95;
                scheduleImpl = i2 % 128;
                if ((i2 % 2 == 0 ? '=' : '8') != '=') {
                    return KClassImpl$Data$declaredNonStaticMembers$22;
                }
                obj.hashCode();
                return KClassImpl$Data$declaredNonStaticMembers$22;
            } catch (UnsupportedEncodingException unused) {
                str3 = getAuthRequestContext;
                str4 = "encrypt UnsupportedEncodingException";
                Logger.w(str3, str4);
                return null;
            }
        } catch (NoSuchAlgorithmException unused2) {
            str3 = getAuthRequestContext;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.w(str3, str4);
            return null;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 89;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i4 = $11 + 107;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
