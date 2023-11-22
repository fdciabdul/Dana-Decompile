package com.alipay.mobile.verifyidentity.uitools;

import android.graphics.Color;

/* loaded from: classes7.dex */
public class ColorUtils {
    public static boolean isColorInvalid(int i) {
        return i == Integer.MAX_VALUE;
    }

    public static int parseColor(String str) {
        if (str != null) {
            if (str.length() != 0) {
                try {
                    if (!str.startsWith("#")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("#");
                        sb.append(str);
                        str = sb.toString();
                    }
                } catch (Throwable unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Color.parseColor(str);
        }
        return Integer.MAX_VALUE;
    }
}
