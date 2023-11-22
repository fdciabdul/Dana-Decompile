package com.rd.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes8.dex */
public class DensityUtils {
    public static int PlaceComponentResult(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }
}
