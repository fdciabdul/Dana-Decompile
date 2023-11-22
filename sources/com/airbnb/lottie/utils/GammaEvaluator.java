package com.airbnb.lottie.utils;

/* loaded from: classes3.dex */
public class GammaEvaluator {
    private static float KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float MyBillsEntityDataFactory(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int PlaceComponentResult(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float MyBillsEntityDataFactory = MyBillsEntityDataFactory(((i >> 16) & 255) / 255.0f);
        float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(((i >> 8) & 255) / 255.0f);
        float MyBillsEntityDataFactory3 = MyBillsEntityDataFactory((i & 255) / 255.0f);
        float MyBillsEntityDataFactory4 = MyBillsEntityDataFactory(((i2 >> 16) & 255) / 255.0f);
        float MyBillsEntityDataFactory5 = MyBillsEntityDataFactory(((i2 >> 8) & 255) / 255.0f);
        float MyBillsEntityDataFactory6 = MyBillsEntityDataFactory((i2 & 255) / 255.0f);
        return (Math.round((f2 + ((f3 - f2) * f)) * 255.0f) << 24) | (Math.round(KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory + ((MyBillsEntityDataFactory4 - MyBillsEntityDataFactory) * f)) * 255.0f) << 16) | (Math.round(KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2 + ((MyBillsEntityDataFactory5 - MyBillsEntityDataFactory2) * f)) * 255.0f) << 8) | Math.round(KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory3 + ((MyBillsEntityDataFactory6 - MyBillsEntityDataFactory3) * f)) * 255.0f);
    }
}
