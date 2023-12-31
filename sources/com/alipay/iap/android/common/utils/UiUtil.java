package com.alipay.iap.android.common.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes6.dex */
public class UiUtil {
    private static final long CLICK_TIME = 500;
    private static long lastClickTime;

    private UiUtil() {
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

    public static int dp2px(Resources resources, float f) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
