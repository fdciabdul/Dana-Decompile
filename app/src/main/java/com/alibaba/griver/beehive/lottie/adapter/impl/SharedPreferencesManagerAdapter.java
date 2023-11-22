package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;

/* loaded from: classes6.dex */
public class SharedPreferencesManagerAdapter {
    private static LruCache<String, APSharedPreferencesAdapter> spList = new LruCache<>(30);

    public static APSharedPreferencesAdapter getInstance(Context context, String str) {
        return getInstance(context, str, 0);
    }

    public static APSharedPreferencesAdapter getInstance(Context context, String str, int i) {
        APSharedPreferencesAdapter aPSharedPreferencesAdapter;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        APSharedPreferencesAdapter aPSharedPreferencesAdapter2 = spList.get(str);
        if (aPSharedPreferencesAdapter2 == null) {
            synchronized (APSharedPreferencesAdapter.class) {
                aPSharedPreferencesAdapter = spList.get(str);
                if (aPSharedPreferencesAdapter == null) {
                    aPSharedPreferencesAdapter = new APSharedPreferencesAdapter(context, str, i);
                    spList.put(str, aPSharedPreferencesAdapter);
                }
            }
            return aPSharedPreferencesAdapter;
        }
        return aPSharedPreferencesAdapter2;
    }
}
