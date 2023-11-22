package com.alipay.plus.android.ab.sdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.a.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class AbTestingStorage {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7345a = e.a("AbTestingStorage");
    private Context b;
    private SharedPreferences c;

    public AbTestingStorage(Context context, String str) {
        this.b = context;
        this.c = this.b.getSharedPreferences(String.format("aplus_ab_testing_%s.prefs", TextUtils.isEmpty(str) ? "default" : str), 0);
    }

    public Map<String, Set<String>> loadAbVariation() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            LoggerWrapper.e(f7345a, "mSharedPreferences is null, cannot load AB variation!");
            return null;
        }
        Set<String> stringSet = sharedPreferences.getStringSet("sourceKey", null);
        if (stringSet == null) {
            LoggerWrapper.w(f7345a, "ABVariation don't have any sources!");
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : stringSet) {
            hashMap.put(str, this.c.getStringSet(str, new HashSet()));
        }
        return hashMap;
    }

    public void updateAbvariation(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            LoggerWrapper.e(f7345a, "mSharedPreferences is null, cannot update AB variation!");
            return;
        }
        Set<String> stringSet = sharedPreferences.getStringSet("sourceKey", new HashSet());
        HashSet hashSet = new HashSet(stringSet);
        hashSet.add(str);
        Set<String> stringSet2 = this.c.getStringSet(str, new HashSet());
        HashSet hashSet2 = new HashSet(stringSet2);
        hashSet2.add(str2);
        SharedPreferences.Editor edit = this.c.edit();
        if (!hashSet.equals(stringSet)) {
            edit.putStringSet("sourceKey", hashSet);
        }
        if (!hashSet2.equals(stringSet2)) {
            edit.putStringSet(str, hashSet2);
        }
        edit.apply();
    }
}
