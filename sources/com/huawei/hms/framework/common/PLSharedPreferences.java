package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PLSharedPreferences {
    private final SharedPreferences BuiltInFictitiousFunctionClassFactory;

    public PLSharedPreferences(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            Logger.e("PLSharedPreferences", "context is null, must call init method to set context");
            sharedPreferences = null;
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences2 = createDeviceProtectedStorageContext.getSharedPreferences("grs_move2DE_records", 0);
                if (!sharedPreferences2.getBoolean(str, false)) {
                    if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences2.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = createDeviceProtectedStorageContext;
            }
            sharedPreferences = context.getSharedPreferences(str, 0);
        }
        this.BuiltInFictitiousFunctionClassFactory = sharedPreferences;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public Map<String, String> getHashMap(String str) {
        HashMap hashMap = new HashMap();
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return hashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i2 = 0; i2 < names.length(); i2++) {
                        String string = names.getString(i2);
                        hashMap.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (JSONException e) {
            Logger.w("PLSharedPreferences", "getHashMap parse Json to map error: %s", StringUtils.anonymizeMessage(e.getMessage()));
        }
        return hashMap;
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putHashMap(String str, Map<String, String> map) {
        if (this.BuiltInFictitiousFunctionClassFactory == null || map == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                Logger.w("PLSharedPreferences", "putHashMap one object error: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
        jSONArray.put(jSONObject);
        this.BuiltInFictitiousFunctionClassFactory.edit().putString(str, jSONArray.toString()).apply();
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public void removeKeyValue(String str) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory;
        if (sharedPreferences == null) {
            return null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        StringBuilder sb = new StringBuilder();
        sb.append("sp size ");
        sb.append(all == null ? 0 : all.size());
        Logger.i("PLSharedPreferences", sb.toString());
        return all;
    }
}
