package com.alipay.multigateway.sdk.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class ParseUtil {
    private static final String TAG = "ParseUtil";

    public static float parseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseFloat: ");
            sb.append(e);
            InstrumentInjector.log_e(TAG, sb.toString());
            return 0.0f;
        }
    }

    public static float[] parseFloatArray(String str) {
        String[] split = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        float[] fArr = new float[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                fArr[i] = Float.parseFloat(split[i]);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return fArr;
    }
}
