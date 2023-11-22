package com.alipay.mobile.map;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class MapCompat {
    public static final double MAX_LATITUDE = 89.99999d;
    public static final double MIN_LATITUDE = -89.99999d;

    public static double wrapCompatLatitude(double d) {
        if (d <= -89.99999d || d >= 89.99999d) {
            double max = Math.max(-89.99999d, Math.min(89.99999d, d));
            StringBuilder sb = new StringBuilder();
            sb.append("wrapCompatLatitude：");
            sb.append(d);
            sb.append(" -> ");
            sb.append(max);
            RVLogger.w("MapCompat", sb.toString());
            return max;
        }
        return d;
    }

    public static double wrapCompatLongitude(double d) {
        if (d < -180.0d || d > 180.0d) {
            double d2 = ((((d - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
            StringBuilder sb = new StringBuilder();
            sb.append("wrapCompatLongitude：");
            sb.append(d);
            sb.append(" -> ");
            sb.append(d2);
            RVLogger.w("MapCompat", sb.toString());
            return d2;
        }
        return d;
    }
}
