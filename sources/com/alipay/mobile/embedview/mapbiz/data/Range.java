package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class Range implements Serializable {
    public float from = -1.0f;
    public float to = -1.0f;

    public static boolean canDisplay(float f, List<Range> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        for (Range range : list) {
            if (range != null && f >= range.from && f <= range.to) {
                return true;
            }
        }
        return false;
    }
}
