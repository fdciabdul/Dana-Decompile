package com.xiaomi.push;

import android.graphics.PointF;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes8.dex */
public class ab {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 269894672;
    private static int PlaceComponentResult = 1;

    private static String MyBillsEntityDataFactory(String str) {
        int i = PlaceComponentResult + 11;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            Object[] objArr = new Object[1];
            a(new char[]{17, 65524, 65513, 2, 16}, ExpandableListView.getPackedPositionGroup(0L) + 121, 5 - TextUtils.indexOf("", "", 0), true, 1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr);
            String valueOf = String.valueOf(aa.MyBillsEntityDataFactory(messageDigest.digest(str.getBytes(((String) objArr[0]).intern()))));
            int i3 = BuiltInFictitiousFunctionClassFactory + 31;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return valueOf;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | Exception e) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("CloudCoder.hash4SHA1 ", e);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String getAuthRequestContext(String str, Map<String, String> map, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory + 67;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (TextUtils.isEmpty(str2)) {
            throw new InvalidParameterException("security is not nullable");
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            int i3 = PlaceComponentResult + 89;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            arrayList.add(str.toUpperCase());
        }
        if (!map.isEmpty()) {
            Iterator it = new TreeMap(map).entrySet().iterator();
            while (true) {
                if (!(it.hasNext())) {
                    break;
                }
                try {
                    Map.Entry entry = (Map.Entry) it.next();
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                    int i5 = PlaceComponentResult + 19;
                    BuiltInFictitiousFunctionClassFactory = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        arrayList.add(str2);
        StringBuilder sb = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        boolean z = true;
        while (true) {
            if (!(it2.hasNext())) {
                return MyBillsEntityDataFactory(sb.toString());
            }
            String str3 = (String) it2.next();
            if (!z) {
                sb.append(Typography.amp);
            }
            sb.append(str3);
            z = false;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            int i4 = $11 + 5;
            $10 = i4 % 128;
            while (true) {
                int i5 = i4 % 2;
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                int i6 = $11 + 123;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                try {
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i8 = a2.MyBillsEntityDataFactory;
                    cArr2[i8] = (char) (cArr2[i8] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                    i4 = $11 + 51;
                    $10 = i4 % 128;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (i3 > 0) {
                int i9 = $10 + 53;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (!(!z)) {
                int i11 = $10 + 15;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    int i13 = $11 + 107;
                    $10 = i13 % 128;
                    int i14 = i13 % 2;
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
