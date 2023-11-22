package com.iap.ac.android.common.json.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.iap.ac.android.common.json.IJson;
import com.iap.ac.android.common.log.ACLog;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class FastJson implements IJson {
    public static final String TAG = "FastJson";

    public FastJson() {
        FastJsonAdapter.adapterToFastjson();
    }

    @Override // com.iap.ac.android.common.json.IJson
    public <T> T fromJson(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) JSON.parseObject(str, cls);
    }

    @Override // com.iap.ac.android.common.json.IJson
    public String getJsonObjectFieldAsString(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return JSON.parseObject(str).getString(str2);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getJsonObjectFieldAsString: ");
            sb.append(th);
            ACLog.w(TAG, sb.toString());
            return null;
        }
    }

    @Override // com.iap.ac.android.common.json.IJson
    public String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj);
    }

    @Override // com.iap.ac.android.common.json.IJson
    public <T> T fromJson(String str, Type type) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) JSON.parseObject(str, type, new Feature[0]);
    }

    @Override // com.iap.ac.android.common.json.IJson
    public <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
        if (jSONObject == null) {
            return null;
        }
        return (T) fromJson(jSONObject.toString(), (Class) cls);
    }
}
