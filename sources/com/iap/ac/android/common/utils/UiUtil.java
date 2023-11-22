package com.iap.ac.android.common.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes8.dex */
public class UiUtil {
    public static final long CLICK_TIME = 500;
    public static long lastClickTime;

    public static int dp2px(Resources resources, float f) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static boolean isFastClick() {
        synchronized (UiUtil.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < 500) {
                return true;
            }
            lastClickTime = currentTimeMillis;
            return false;
        }
    }
}
