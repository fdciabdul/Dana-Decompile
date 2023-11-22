package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class SharedPreferencesUtils {
    private SharedPreferencesUtils() {
    }

    @Deprecated
    public static void publishWorldReadableSharedPreferences(Context context, SharedPreferences.Editor editor, String str) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
