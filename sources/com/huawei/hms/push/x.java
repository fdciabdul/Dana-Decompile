package com.huawei.hms.push;

import android.widget.ExpandableListView;
import java.nio.charset.Charset;
import o.getOnBoardingScenario;

/* loaded from: classes8.dex */
public class x {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static long MyBillsEntityDataFactory;
    public static final Charset PlaceComponentResult;

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a(54906 - ExpandableListView.getPackedPositionChild(0L), new char[]{61729, 10075, 24004, 29224, 43168}, objArr);
        PlaceComponentResult = Charset.forName(((String) objArr[0]).intern());
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int i2 = 36 / 0;
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 749751698729214007L;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                break;
            }
            try {
                int i2 = $11 + 39;
                $10 = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext | getonboardingscenario.MyBillsEntityDataFactory)) | (MyBillsEntityDataFactory + 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext -= 0;
                } else {
                    jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ MyBillsEntityDataFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                    getonboardingscenario.getAuthRequestContext++;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i3 = $11 + 27;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
