package com.alibaba.griver.core.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;

/* loaded from: classes3.dex */
public class H5StatusBarUtils {

    /* renamed from: a  reason: collision with root package name */
    private static int f6478a;

    public static boolean isSupport() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void setTransparentColor(Activity activity, int i) {
        if (!isSupport() || activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(APEncodeOptions.DEFAULT_MAX_LEN);
        window.setStatusBarColor(i);
    }

    public static int getStatusBarHeight(Context context) {
        if (f6478a == 0) {
            f6478a = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        }
        return f6478a;
    }

    public static boolean isConfigSupport() {
        if (TextUtils.equals(GriverConfig.getConfig("TSBS"), "0")) {
            return false;
        }
        String config = GriverConfig.getConfig("TSBSOFF");
        return TextUtils.isEmpty(config) || !config.contains(Build.MODEL);
    }
}
