package com.alibaba.ariver.app.api.ui.darkmode;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class ThemeUtils {
    public static final String COLOR_SCHEME_DARK = "dark";
    public static final String COLOR_SCHEME_LIGHT = "light";
    public static final String KEY_COLOR_SCHEME = "colorSchemes";

    /* renamed from: a  reason: collision with root package name */
    private static String f5974a = "";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ColorScheme {
    }

    public static boolean isSupportDarkTheme(App app) {
        JSONArray jSONArray;
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel == null || (jSONArray = JSONUtils.getJSONArray(appConfigModel.getAppLaunchParams(), RVStartParams.KEY_SUPPORT_COLOR_SCHEME, null)) == null) {
            return false;
        }
        return jSONArray.contains("dark");
    }

    public static String getColorScheme(Configuration configuration) {
        return isDarkMode(configuration) ? "dark" : "light";
    }

    public static void setAppConfigColorScheme(String str) {
        f5974a = str;
    }

    public static boolean isDarkMode(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return (uiModeManager != null ? uiModeManager.getNightMode() : 1) == 2 || isDarkMode(context.getResources().getConfiguration()) || a();
    }

    public static boolean isDarkMode(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    private static boolean a() {
        return TextUtils.equals(f5974a, "dark");
    }
}
