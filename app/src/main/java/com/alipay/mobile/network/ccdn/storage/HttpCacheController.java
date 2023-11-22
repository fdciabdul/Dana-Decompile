package com.alipay.mobile.network.ccdn.storage;

import android.view.View;
import android.view.ViewConfiguration;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class HttpCacheController {
    private static int $10 = 0;
    private static int $11 = 1;
    static Charset CS_UTF8 = null;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static long MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    static void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{62235, 24140, 43428, 64353, 17966};
        MyBillsEntityDataFactory = 7678118028494396952L;
    }

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a(View.MeasureSpec.getMode(0), 5 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr);
        CS_UTF8 = Charset.forName(((String) objArr[0]).intern());
        int i = getAuthRequestContext + 109;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static Map<String, String> deserializeHttpHeader(byte[] bArr, int i, int i2) throws IOException {
        HashMap hashMap = new HashMap();
        if (bArr != null) {
            int i3 = PlaceComponentResult + 113;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            if (bArr.length > 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i, i2), CS_UTF8));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        try {
                            int i5 = PlaceComponentResult + 55;
                            getAuthRequestContext = i5 % 128;
                            int i6 = i5 % 2;
                            int indexOf = readLine.indexOf(58);
                            if ((indexOf > 0 ? '\'' : '4') == '\'') {
                                hashMap.put(readLine.substring(0, indexOf).trim(), readLine.substring(indexOf + 1).trim());
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                        throw e;
                    } finally {
                        bufferedReader.close();
                    }
                }
                try {
                    int i7 = PlaceComponentResult + 37;
                    getAuthRequestContext = i7 % 128;
                    int i8 = i7 % 2;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return hashMap;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '5' : 'a') != '5') {
                break;
            }
            int i3 = $11 + 89;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            try {
                int i5 = $10 + 1;
                $11 = i5 % 128;
                while (true) {
                    int i6 = i5 % 2;
                    if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                        objArr[0] = new String(cArr);
                        return;
                    }
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                    i5 = $10 + 29;
                    $11 = i5 % 128;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
