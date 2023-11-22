package com.akamai.botman;

import android.util.Pair;

/* loaded from: classes3.dex */
public final class ad {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a4  */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.String, java.lang.Long> getAuthRequestContext(float[] r18, float r19) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.ad.getAuthRequestContext(float[], float):android.util.Pair");
    }

    private static Pair<Float, Float> getAuthRequestContext(float[] fArr) {
        float f = fArr[0];
        float f2 = f;
        for (float f3 : fArr) {
            if (f3 < f) {
                f = f3;
            } else if (f3 > f2) {
                f2 = f3;
            }
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }
}
