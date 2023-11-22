package com.huawei.secure.android.common.encrypt.rsa;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import o.E;

/* loaded from: classes8.dex */
public abstract class RSAEncrypt {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 0;
    private static long PlaceComponentResult = 0;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(new char[]{13649, 41658, 33520, 48673, 65369}, new char[]{49560, 12086, 35784, 42997}, (char) (AndroidCharacter.getMirror('0') + 62811), new char[]{0, 0, 0, 0}, (-936429887) - TextUtils.indexOf("", "", 0, 0), objArr);
        KClassImpl$Data$declaredNonStaticMembers$2 = ((String) objArr[0]).intern();
        int i = lookAheadTest + 121;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = (char) 42170;
        PlaceComponentResult = 4360990799332652212L;
        MyBillsEntityDataFactory = -956812108;
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
        int i2 = $10 + 57;
        $11 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 22 : '_') != '_') {
                int i4 = $11 + 11;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                i2 = $11 + 103;
                $10 = i2 % 128;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
