package com.alipay.iap.android.common.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alipay.iap.android.common.log.LoggerWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
public class LanguageManager {
    public static final String IAP_MYWALLETWIDGET_PRESENTATION_INTENT_ACTION_LANGUAGE_CHANGE = "IAP_MYWALLETWIDGET_PRESENTATION_INTENT_ACTION_LANGUAGE_CHANGE";
    private static final String IAP_MYWALLETWIDGET_PRESENTATION_KEY_COUNTRY = "IAP_MYWALLETWIDGET_PRESENTATION_KEY_COUNTRY";
    private static final String IAP_MYWALLETWIDGET_PRESENTATION_KEY_LANGUAGE = "IAP_MYWALLETWIDGET_PRESENTATION_KEY_LANGUAGE";
    private static final String IAP_MYWALLETWIDGET_PRESENTATION_SHARE_LANGUAGE_NAME = "IAP_MYWALLETWIDGET_PRESENTATION_SHARE_LANGUAGE_NAME";
    private static final String TAG = "LanguageManager";
    private static LocaleInfo currentLocaleInfo;
    private static final List<LocaleInfo> multiLanguageList;

    static {
        ArrayList arrayList = new ArrayList();
        multiLanguageList = arrayList;
        arrayList.add(new LocaleInfo("English", "en", "US"));
        arrayList.add(new LocaleInfo("中文简体", "zh", "CN"));
        currentLocaleInfo = new LocaleInfo("", getMultiLanguageList().get(0).language, getMultiLanguageList().get(0).country);
    }

    /* loaded from: classes6.dex */
    public static class LocaleInfo {
        public String country;
        public String language;
        public String name;

        public LocaleInfo(String str, String str2, String str3) {
            this.name = str;
            this.language = str2;
            this.country = str3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocaleInfo{name='");
            sb.append(this.name);
            sb.append('\'');
            sb.append(", language='");
            sb.append(this.language);
            sb.append('\'');
            sb.append(", country='");
            sb.append(this.country);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static List<LocaleInfo> getMultiLanguageList() {
        return multiLanguageList;
    }

    private static void saveLanguage(Context context, LocaleInfo localeInfo) {
        if (context == null || localeInfo == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(IAP_MYWALLETWIDGET_PRESENTATION_SHARE_LANGUAGE_NAME, 0).edit();
        edit.putString(IAP_MYWALLETWIDGET_PRESENTATION_KEY_LANGUAGE, localeInfo.language);
        edit.putString(IAP_MYWALLETWIDGET_PRESENTATION_KEY_COUNTRY, localeInfo.country);
        edit.apply();
    }

    public static LocaleInfo getCurrentLanguage() {
        return currentLocaleInfo;
    }

    public static void switchLanguage(Context context, LocaleInfo localeInfo) {
        synchronized (LanguageManager.class) {
            if (context == null || localeInfo == null) {
                return;
            }
            currentLocaleInfo = localeInfo;
            updateLanguageConfiguration(context, localeInfo);
            saveLanguage(context, localeInfo);
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(IAP_MYWALLETWIDGET_PRESENTATION_INTENT_ACTION_LANGUAGE_CHANGE));
        }
    }

    public static void setLanguageWithLastSetting(Context context) {
        synchronized (LanguageManager.class) {
            if (context == null) {
                return;
            }
            LocaleInfo currentLanguage = getCurrentLanguage();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("lastLanguage=");
            sb.append(currentLanguage.language);
            LoggerWrapper.i(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lastCountry=");
            sb2.append(currentLanguage.country);
            LoggerWrapper.i(str, sb2.toString());
            updateLanguageConfiguration(context, currentLanguage);
        }
    }

    private static void updateLanguageConfiguration(Context context, LocaleInfo localeInfo) {
        synchronized (LanguageManager.class) {
            if (Build.VERSION.SDK_INT < 24) {
                Resources resources = context.getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = new Locale(localeInfo.language, localeInfo.country);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
    }

    private static void setLocaleToResource(Application application, Locale locale) {
        try {
            Method declaredMethod = application.getClass().getDeclaredMethod("setLocaleToApplicationResources", Locale.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(application, locale);
            Method declaredMethod2 = application.getClass().getDeclaredMethod("clearCachedBundleResources", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(application, new Object[0]);
        } catch (Exception e) {
            LoggerWrapper.w(TAG, "setLocaleToResource", e);
        }
    }
}
