package com.iap.ac.android.acs.plugin.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.iap.ac.android.common.log.ACLog;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class UIUtils {
    public static int dp2px(Context context, int i) {
        double d = i * getMetrics(context).density;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    public static String encryptPhoneNumber(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 7) ? str : str.replaceAll("(?<=\\d{3})\\d(?=\\d{4})", "*");
    }

    public static String getLocale(Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            ACLog.e("IAPConnectPlugin", "UIUtils#getLocale, resources is null");
            return "";
        }
        Configuration configuration = resources.getConfiguration();
        if (configuration == null) {
            ACLog.e("IAPConnectPlugin", "UIUtils#getLocale, configuration is null");
            return "";
        }
        Locale locale = null;
        if (Build.VERSION.SDK_INT >= 24) {
            if (!configuration.getLocales().isEmpty()) {
                locale = configuration.getLocales().get(0);
            }
        } else {
            locale = configuration.locale;
        }
        if (locale == null) {
            ACLog.e("IAPConnectPlugin", "UIUtils#getLocale, locale is null");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UIUtils#getLocale, locale: ");
        sb.append(locale);
        ACLog.d("IAPConnectPlugin", sb.toString());
        return locale.toString();
    }

    public static DisplayMetrics getMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int getScreenHeight(Context context) {
        return getMetrics(context).heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return getMetrics(context).widthPixels;
    }

    public static void hideSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            } catch (Throwable th) {
                ACLog.e("IAPConnectPlugin", "hide soft input error", th);
            }
        }
    }

    public static boolean isActivityDisabled(Activity activity) {
        if (activity == null) {
            ACLog.e("IAPConnectPlugin", "UIUtils#isActivityDisabled, activity is null");
            return true;
        } else if (activity.isFinishing()) {
            ACLog.e("IAPConnectPlugin", "UIUtils#isActivityDisabled, activity is finishing");
            return true;
        } else if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return false;
        } else {
            ACLog.e("IAPConnectPlugin", "UIUtils#isActivityDisabled, activity is destroyed");
            return true;
        }
    }

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static int px2dp(Context context, int i) {
        double d = i / getMetrics(context).density;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    public static void showSoftInput(final Context context, final View view) {
        view.postDelayed(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.utils.UIUtils.1
            @Override // java.lang.Runnable
            public final void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null) {
                    try {
                        inputMethodManager.showSoftInput(view, 0);
                    } catch (Throwable th) {
                        ACLog.e("IAPConnectPlugin", "show soft input error", th);
                    }
                }
            }
        }, 300L);
    }
}
