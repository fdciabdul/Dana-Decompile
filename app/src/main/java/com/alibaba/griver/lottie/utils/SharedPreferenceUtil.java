package com.alibaba.griver.lottie.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes6.dex */
public class SharedPreferenceUtil {
    private static SharedPreferenceUtil sInstance;
    private SharedPreferences mDefaultSharedPreferences;

    public static SharedPreferenceUtil getInstance() {
        if (sInstance == null) {
            synchronized (SharedPreferenceUtil.class) {
                if (sInstance == null) {
                    sInstance = new SharedPreferenceUtil();
                }
            }
        }
        return sInstance;
    }

    public SharedPreferences getDefaultSharedPreference(Context context) {
        if (this.mDefaultSharedPreferences == null) {
            this.mDefaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return this.mDefaultSharedPreferences;
    }
}
