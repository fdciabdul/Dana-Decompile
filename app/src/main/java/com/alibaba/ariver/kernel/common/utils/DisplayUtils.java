package com.alibaba.ariver.kernel.common.utils;

import android.app.Activity;
import android.graphics.Rect;

/* loaded from: classes2.dex */
public class DisplayUtils {
    public static int getTitleAndStatusBarHeight(Activity activity) {
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return DimensionUtil.dip2px(activity, 48.0f) + rect.top;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getTitleAndStatusBarHeight...e=");
            sb.append(th);
            RVLogger.e("DisplayUtils", sb.toString());
            return DimensionUtil.dip2px(activity, 1.0f) * 73;
        }
    }
}
