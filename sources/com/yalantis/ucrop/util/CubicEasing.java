package com.yalantis.ucrop.util;

/* loaded from: classes8.dex */
public final class CubicEasing {
    public static float MyBillsEntityDataFactory(float f, float f2, float f3) {
        float f4;
        float f5 = f / (f3 / 2.0f);
        float f6 = f2 / 2.0f;
        if (f5 < 1.0f) {
            f4 = f6 * f5 * f5 * f5;
        } else {
            float f7 = f5 - 2.0f;
            f4 = f6 * ((f7 * f7 * f7) + 2.0f);
        }
        return f4 + 0.0f;
    }

    public static float getAuthRequestContext(float f, float f2, float f3) {
        float f4 = (f / f3) - 1.0f;
        return (f2 * ((f4 * f4 * f4) + 1.0f)) + 0.0f;
    }
}
