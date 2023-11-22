package com.iap.ac.android.region.cdp.util;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class CdpUtils {
    public static final String TAG_PREFIX = "WalletCdp-";

    public static double dp2px(Context context, double d) {
        double d2 = getMetrics(context).density;
        Double.isNaN(d2);
        return (d * d2) + 0.5d;
    }

    public static String getAppLanguage() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locale.getDefault().getLanguage());
        sb.append("-");
        sb.append(Locale.getDefault().getCountry());
        return sb.toString();
    }

    public static DisplayMetrics getMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        return sb.toString();
    }

    public static double px2dp(Context context, double d) {
        double d2 = getMetrics(context).density;
        Double.isNaN(d2);
        return (d / d2) + 0.5d;
    }

    public static void removeChildWithClass(ViewGroup viewGroup, Class<? extends View> cls) {
        if (viewGroup == null || cls == null) {
            return;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null && childAt.getClass() == cls) {
                viewGroup.removeView(childAt);
            }
        }
    }

    public static Uri removeQueryParameterFromUri(Uri uri, String str) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str2 : queryParameterNames) {
            if (!str2.equals(str)) {
                clearQuery.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        return clearQuery.build();
    }

    public static int strColorToInt(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
