package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import o.D;

/* loaded from: classes8.dex */
public abstract class ao {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long MyBillsEntityDataFactory = 6982799287186471231L;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    /* loaded from: classes8.dex */
    public static class a extends an {
        @Override // com.xiaomi.push.an
        public final String MyBillsEntityDataFactory(Context context, String str, List<x> list) {
            return y.getAuthRequestContext(context, new URL(str));
        }
    }

    private static int BuiltInFictitiousFunctionClassFactory(String str) {
        int i = PlaceComponentResult + 19;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(str) ? 'C' : (char) 4) != 'C') {
            try {
                Object[] objArr = new Object[1];
                a(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{11736, 51468, 29922, 11661, 64612, 15759, 40202, 8908, 65212}, objArr);
                int length = str.getBytes(((String) objArr[0]).intern()).length;
                int i3 = PlaceComponentResult + 69;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? '\f' : 'Y') != '\f') {
                    return length;
                }
                Object obj = null;
                obj.hashCode();
                return length;
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return 0;
    }

    public static String MyBillsEntityDataFactory(Context context, String str) {
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context, str, new a());
        int i = getAuthRequestContext + 49;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return MyBillsEntityDataFactory2;
    }

    private static int PlaceComponentResult(int i, int i2) {
        int i3 = PlaceComponentResult + 57;
        getAuthRequestContext = i3 % 128;
        int i4 = (i3 % 2 == 0 ? '?' : (char) 3) != 3 ? (((((i2 % 25390) >> 28106) * 27515) * 11325) - i) * i2 : (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
        int i5 = getAuthRequestContext + 81;
        PlaceComponentResult = i5 % 128;
        int i6 = i5 % 2;
        return i4;
    }

    private static int PlaceComponentResult(int i, int i2, int i3) {
        int i4 = getAuthRequestContext + 79;
        PlaceComponentResult = i4 % 128;
        int i5 = (i4 % 2 != 0 ? '\t' : (char) 1) != '\t' ? (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3 : ((((((i2 - 23358) >> 18588) >>> 23934) >> 292) * i2) + i) << i3;
        int i6 = PlaceComponentResult + 39;
        getAuthRequestContext = i6 % 128;
        if ((i6 % 2 == 0 ? (char) 25 : 'a') != 25) {
            return i5;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i5;
    }

    private static int PlaceComponentResult(List<x> list) {
        int i = PlaceComponentResult + 1;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        for (x xVar : list) {
            if (!TextUtils.isEmpty(xVar.KClassImpl$Data$declaredNonStaticMembers$2())) {
                int i4 = PlaceComponentResult + 51;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                try {
                    i3 += xVar.KClassImpl$Data$declaredNonStaticMembers$2().length();
                    int i6 = getAuthRequestContext + 125;
                    PlaceComponentResult = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            if ((!TextUtils.isEmpty(xVar.PlaceComponentResult()) ? 'N' : 'F') == 'N') {
                int i8 = getAuthRequestContext + 71;
                PlaceComponentResult = i8 % 128;
                int i9 = i8 % 2;
                i3 += xVar.PlaceComponentResult().length();
            }
        }
        return i3 * 2;
    }

    private static int getAuthRequestContext(an anVar, String str, List<x> list, String str2) {
        int i = PlaceComponentResult + 43;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            if (!(anVar.PlaceComponentResult == 1)) {
                if ((anVar.PlaceComponentResult == 2 ? (char) 16 : 'Q') != 'Q') {
                    return PlaceComponentResult(str.length(), PlaceComponentResult(null), BuiltInFictitiousFunctionClassFactory(str2));
                }
                return -1;
            }
            try {
                int i3 = PlaceComponentResult + 15;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 == 0) {
                    int PlaceComponentResult2 = PlaceComponentResult(str.length(), BuiltInFictitiousFunctionClassFactory(str2));
                    int i4 = 27 / 0;
                    return PlaceComponentResult2;
                }
                return PlaceComponentResult(str.length(), BuiltInFictitiousFunctionClassFactory(str2));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String MyBillsEntityDataFactory(android.content.Context r23, java.lang.String r24, com.xiaomi.push.an r25) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ao.MyBillsEntityDataFactory(android.content.Context, java.lang.String, com.xiaomi.push.an):java.lang.String");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                try {
                    int i2 = $10 + 115;
                    try {
                        $11 = i2 % 128;
                        int i3 = i2 % 2;
                        d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                        KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                        d.MyBillsEntityDataFactory++;
                        int i4 = $10 + 15;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
        }
    }
}
