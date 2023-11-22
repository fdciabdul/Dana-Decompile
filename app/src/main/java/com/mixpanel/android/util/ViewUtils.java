package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Color;

/* loaded from: classes.dex */
public class ViewUtils {
    public static float KClassImpl$Data$declaredNonStaticMembers$2(float f, Context context) {
        return f * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static int getAuthRequestContext(int i) {
        return Color.rgb((Color.red(i) / 2) + (Color.red(864454278) / 2), (Color.green(i) / 2) + (Color.green(864454278) / 2), (Color.blue(i) / 2) + (Color.blue(864454278) / 2));
    }
}
