package com.ta.audid.g;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {35519, 35536, 35580, 35575, 35525};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;

    public static String V() {
        String string;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Context context = com.ta.audid.a.a().getContext();
        Object[] objArr = null;
        if ((context == null ? '[' : 'P') != '[') {
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
            if ((sharedPreferences != null ? 'V' : (char) 3) != 'V') {
                return "";
            }
            int i3 = MyBillsEntityDataFactory + 15;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                string = sharedPreferences.getString("_lun", "");
                boolean isEmpty = com.ta.utdid2.a.a.e.isEmpty(string);
                objArr.hashCode();
                if (isEmpty) {
                    return "";
                }
            } else {
                string = sharedPreferences.getString("_lun", "");
                if (com.ta.utdid2.a.a.e.isEmpty(string)) {
                    return "";
                }
            }
            try {
                byte[] decode = com.ta.utdid2.a.a.b.decode(string.getBytes(), 2);
                Object[] objArr2 = new Object[1];
                b(new int[]{0, 5, 21, 4}, true, new byte[]{0, 1, 0, 1, 1}, objArr2);
                return new String(decode, ((String) objArr2[0]).intern());
            } catch (Exception e) {
                m.d("", e);
                return "";
            }
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        MyBillsEntityDataFactory = i4 % 128;
        if ((i4 % 2 == 0 ? '-' : 'X') == '-') {
            int length = objArr.length;
        }
        return "";
    }

    public static String W() {
        int i = MyBillsEntityDataFactory + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Context context = com.ta.audid.a.a().getContext();
        if ((context == null ? '\r' : (char) 1) != '\r') {
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
            if (sharedPreferences != null) {
                int i3 = MyBillsEntityDataFactory + 79;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                String string = sharedPreferences.getString("_luid", "");
                if (com.ta.utdid2.a.a.e.isEmpty(string)) {
                    return "";
                }
                try {
                    byte[] decode = com.ta.utdid2.a.a.b.decode(string.getBytes(), 2);
                    Object[] objArr = new Object[1];
                    b(new int[]{0, 5, 21, 4}, true, new byte[]{0, 1, 0, 1, 1}, objArr);
                    return new String(decode, ((String) objArr[0]).intern());
                } catch (UnsupportedEncodingException e) {
                    m.d("", e);
                    return "";
                }
            }
            return "";
        }
        int i5 = MyBillsEntityDataFactory + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
        return "";
    }

    public static void a(String str, Map<String, String> map) {
        try {
            AppMonitor.Counter.commit("UtdidMonitor", str, new JSONObject(map).toString(), 1.0d);
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 == 0 ? '\n' : '\f') != '\n') {
                    return;
                }
                int i2 = 63 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            m.d("", th);
        }
    }

    private static void b(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        char[] cArr;
        char c;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr3[i5] = (char) (cArr2[i5] ^ 5097613533456403102L);
            }
            try {
                int i6 = $10 + 19;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr2 = cArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr4 = new char[i2];
        System.arraycopy(cArr2, i, cArr4, 0, i2);
        if ((bArr != null ? 'G' : 'K') != 'K') {
            int i8 = $10 + 31;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                cArr = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                c = 1;
            } else {
                cArr = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                c = 0;
            }
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? 'V' : '[') == '[') {
                    break;
                }
                int i9 = $10 + 7;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                try {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        int i11 = $10 + 45;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                    } else {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr4 = cArr;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr4, 0, cArr5, 0, i2);
            int i13 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr4, i13, i4);
            System.arraycopy(cArr5, i4, cArr4, 0, i13);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr4 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr4);
    }
}
