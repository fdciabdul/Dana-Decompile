package com.huawei.hms.hatool;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewConfiguration;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class d {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final Charset KClassImpl$Data$declaredNonStaticMembers$2;
    private static char[] MyBillsEntityDataFactory;
    private static int PlaceComponentResult;
    private static long getAuthRequestContext;

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(View.MeasureSpec.getSize(0), 5 - TextUtils.getOffsetBefore("", 0), (char) (29135 - (ViewConfiguration.getPressedStateDuration() >> 16)), objArr);
        KClassImpl$Data$declaredNonStaticMembers$2 = Charset.forName(((String) objArr[0]).intern());
        int i = BuiltInFictitiousFunctionClassFactory + 27;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if (r1 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        if (r5.length != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:
    
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        r1 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        if (r1 == 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r6 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        if (r6.length >= 16) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        r5 = com.huawei.hms.hatool.d.PlaceComponentResult + 19;
        com.huawei.hms.hatool.d.BuiltInFictitiousFunctionClassFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if ((r5 % 2) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(com.huawei.secure.android.common.encrypt.aes.AesCbc.BuiltInFictitiousFunctionClassFactory(r5, r6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(byte[] r5, java.lang.String r6) {
        /*
            r0 = 1
            if (r5 == 0) goto L5
            r1 = 1
            goto L6
        L5:
            r1 = 0
        L6:
            java.lang.String r2 = "key length is not right"
            if (r1 == r0) goto Lb
            goto L4e
        Lb:
            int r1 = com.huawei.hms.hatool.d.PlaceComponentResult
            int r1 = r1 + 97
            int r3 = r1 % 128
            com.huawei.hms.hatool.d.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % 2
            r3 = 0
            if (r1 != 0) goto L1f
            int r1 = r5.length
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L4e
            goto L22
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            int r1 = r5.length
            if (r1 == 0) goto L4e
        L22:
            if (r6 == 0) goto L27
            r1 = 14
            goto L28
        L27:
            r1 = 1
        L28:
            if (r1 == r0) goto L4e
            byte[] r6 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r6)
            int r0 = r6.length
            r1 = 16
            if (r0 >= r1) goto L45
            int r5 = com.huawei.hms.hatool.d.PlaceComponentResult
            int r5 = r5 + 19
            int r6 = r5 % 128
            com.huawei.hms.hatool.d.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L50
            r3.hashCode()     // Catch: java.lang.Throwable -> L43
            goto L50
        L43:
            r5 = move-exception
            throw r5
        L45:
            byte[] r5 = com.huawei.secure.android.common.encrypt.aes.AesCbc.BuiltInFictitiousFunctionClassFactory(r5, r6)
            java.lang.String r5 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r5)
            return r5
        L4e:
            java.lang.String r2 = "cbc encrypt(byte) param is not right"
        L50:
            java.lang.String r5 = "AesCipher"
            com.huawei.hms.hatool.y.getAuthRequestContext(r5, r2)
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.d.BuiltInFictitiousFunctionClassFactory(byte[], java.lang.String):java.lang.String");
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = new char[]{33492, 63287, 26883, 58122, 21809};
        getAuthRequestContext = 5057898684519646892L;
    }

    private static Pair<byte[], String> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if ((str != null ? '@' : 'Z') != 'Z') {
            int i = BuiltInFictitiousFunctionClassFactory + 111;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0) ? str.length() >= 32 : str.length() >= 22) {
                try {
                    return new Pair<>(HexUtil.getAuthRequestContext(str.substring(0, 32)), str.substring(32));
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        Pair<byte[], String> pair = new Pair<>(new byte[0], str);
        int i2 = BuiltInFictitiousFunctionClassFactory + 7;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return pair;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        int i = PlaceComponentResult + 119;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '!' : 'U') != '!') {
            return HexUtil.getAuthRequestContext(AesCbc.BuiltInFictitiousFunctionClassFactory(str.getBytes(KClassImpl$Data$declaredNonStaticMembers$2), HexUtil.getAuthRequestContext(str2)));
        }
        String authRequestContext = HexUtil.getAuthRequestContext(AesCbc.BuiltInFictitiousFunctionClassFactory(str.getBytes(KClassImpl$Data$declaredNonStaticMembers$2), HexUtil.getAuthRequestContext(str2)));
        int i2 = 96 / 0;
        return authRequestContext;
    }

    public static String PlaceComponentResult(String str, String str2) {
        Pair<byte[], String> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        String str3 = new String(AesCbc.getAuthRequestContext(HexUtil.getAuthRequestContext((String) KClassImpl$Data$declaredNonStaticMembers$22.second), HexUtil.getAuthRequestContext(str2), (byte[]) KClassImpl$Data$declaredNonStaticMembers$22.first), KClassImpl$Data$declaredNonStaticMembers$2);
        int i = PlaceComponentResult + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return str3;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $11 + 97;
        $10 = i3 % 128;
        while (true) {
            try {
                int i4 = i3 % 2;
                if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                    break;
                }
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
                i3 = $10 + 63;
                $11 = i3 % 128;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        String str = new String(cArr);
        int i5 = $10 + 31;
        $11 = i5 % 128;
        if ((i5 % 2 == 0 ? (char) 2 : (char) 14) != 2) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
