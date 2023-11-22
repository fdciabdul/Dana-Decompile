package com.alipay.iap.android.f2fpay.cipher;

import android.graphics.Color;
import android.os.SystemClock;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.util.Base64Utils;
import com.alipay.iap.android.f2fpay.util.CipherUtils;
import o.E;

/* loaded from: classes3.dex */
public class AesCipher {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 4360990799332652212L;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -956812108;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult = 0;
    private static char getAuthRequestContext = 7315;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f6947a;
    private byte[] b;
    private String c;

    private AesCipher(byte[] bArr, String str, byte[] bArr2) {
        try {
            this.f6947a = bArr2;
            this.b = bArr;
            this.c = str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static AesCipher create(byte[] bArr, String str, byte[] bArr2) {
        AesCipher aesCipher = new AesCipher(bArr, str, bArr2);
        try {
            int i = MyBillsEntityDataFactory + 73;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? (char) 17 : 'B') != 'B') {
                int i2 = 6 / 0;
                return aesCipher;
            }
            return aesCipher;
        } catch (Exception e) {
            throw e;
        }
    }

    public static AesCipher createRandom(String str, byte[] bArr) {
        int i = MyBillsEntityDataFactory + 75;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            AesCipher create = create(CipherUtils.generateAesKey(), str, bArr);
            int i3 = MyBillsEntityDataFactory + 69;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return create;
        } catch (Exception e) {
            throw e;
        }
    }

    public String decrypt(String str) {
        try {
            int i = PlaceComponentResult + 57;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            try {
                byte[] decryptBytes = decryptBytes(str);
                String str2 = decryptBytes != null ? new String(decryptBytes) : null;
                int i3 = PlaceComponentResult + 73;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return str2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public byte[] decryptBytes(String str) {
        int i = PlaceComponentResult + 35;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object obj = null;
        try {
            byte[] decryptAes = CipherUtils.decryptAes(this.b, Base64Utils.decode(str), this.f6947a);
            try {
                int i3 = PlaceComponentResult + 5;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 == 0 ? 'M' : 'Y') != 'Y') {
                    obj.hashCode();
                    return decryptAes;
                }
                return decryptAes;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            LoggerWrapper.e("AesCipher", "", e2);
            return null;
        }
    }

    public String encrypted() {
        int i = PlaceComponentResult + 43;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            String encodeToString = Base64Utils.encodeToString(this.b);
            Object[] objArr = new Object[1];
            d(new char[]{25125, 41843, 4593, 30346, 17480}, new char[]{23640, 31987, 39456, 26705}, (char) (20891 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), new char[]{0, 0, 0, 0}, Color.blue(0) + 545059676, objArr);
            String encodeToString2 = Base64Utils.encodeToString(CipherUtils.encryptData(encodeToString.getBytes(((String) objArr[0]).intern()), this.c));
            int i3 = PlaceComponentResult + 37;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return encodeToString2;
        } catch (Exception e) {
            LoggerWrapper.e("AesCipher", "", e);
            return null;
        }
    }

    private static void d(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
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
        int i2 = $11 + 59;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 < length3)) {
                String str = new String(cArr6);
                int i4 = $11 + 89;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                objArr[0] = str;
                return;
            }
            int i6 = $11 + 115;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i9 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i8]) % 65535);
            cArr5[i9] = (char) (((cArr4[i9] * 32718) + cArr5[i8]) / 65535);
            cArr4[i9] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i9] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
    }
}
