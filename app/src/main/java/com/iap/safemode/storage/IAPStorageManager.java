package com.iap.safemode.storage;

import android.app.Application;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class IAPStorageManager {
    Application PlaceComponentResult;

    public IAPStorageManager(Application application) {
        this.PlaceComponentResult = application;
    }

    public static void getAuthRequestContext(Application application, String str, String str2) {
        SharedPreferences.Editor edit = application.getSharedPreferences(str, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static String getAuthRequestContext(Application application, String str) {
        return application.getSharedPreferences(str, 0).getString(str, "");
    }
}
