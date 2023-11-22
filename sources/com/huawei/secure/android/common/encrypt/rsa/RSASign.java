package com.huawei.secure.android.common.encrypt.rsa;

import android.view.MotionEvent;
import id.dana.cashier.view.InputCardNumberView;
import o.getOnBoardingScenario;

/* loaded from: classes8.dex */
public abstract class RSASign {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private static long MyBillsEntityDataFactory = 8945898079746013949L;
    private static int getAuthRequestContext = 1;

    static {
        Object[] objArr = new Object[1];
        a(MotionEvent.axisFromString("") + 7458, new char[]{60395, 63179, 53690, 48368, 40706}, objArr);
        KClassImpl$Data$declaredNonStaticMembers$2 = ((String) objArr[0]).intern();
        int i = getAuthRequestContext + 17;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '#' : '%') != '%') {
            int i2 = 84 / 0;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                int i3 = $11 + 73;
                $10 = i3 % 128;
                if ((i3 % 2 != 0 ? '#' : InputCardNumberView.DIVIDER) != '#') {
                    jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ MyBillsEntityDataFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                    i2 = getonboardingscenario.getAuthRequestContext + 1;
                } else {
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] / (getonboardingscenario.getAuthRequestContext % getonboardingscenario.MyBillsEntityDataFactory)) / (MyBillsEntityDataFactory + 4796183387843776835L);
                    i2 = getonboardingscenario.getAuthRequestContext / 0;
                }
                getonboardingscenario.getAuthRequestContext = i2;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '#' : (char) 16) != '#') {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $10 + 71;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
