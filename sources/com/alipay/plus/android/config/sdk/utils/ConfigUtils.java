package com.alipay.plus.android.config.sdk.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.config.ConfigProxy;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.AmcsConfigProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ConfigUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7392a = e.a("ConfigUtils");

    public static Map<String, String> convertToStringMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            hashMap.put(entry.getKey(), value instanceof String ? (String) value : String.valueOf(value));
        }
        return hashMap;
    }

    public static String formatConfigVersionWithTime(long j) {
        return String.format("%s [ %s ]", Long.valueOf(j), e.a(j));
    }

    public static int getBase64Percent(String str) {
        if (TextUtils.isEmpty(str)) {
            return 100;
        }
        try {
            int length = str.length();
            if (length >= 2) {
                int i = length - 1;
                char charAt = str.subSequence(length - 2, i).charAt(0);
                char charAt2 = str.subSequence(i, length).charAt(0);
                return ((("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".indexOf(charAt) >= 0 ? "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".indexOf(charAt) : 0) * 64) + ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".indexOf(charAt2) >= 0 ? "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".indexOf(charAt2) : 0)) % 100;
            }
        } catch (Throwable th) {
            String str2 = f7392a;
            StringBuilder sb = new StringBuilder();
            sb.append("getBase64Percent error: ");
            sb.append(th.getMessage());
            LoggerWrapper.e(str2, sb.toString());
        }
        return 100;
    }

    public static JSONArray getJSONArraySafe(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (Throwable unused) {
            String str2 = f7392a;
            StringBuilder sb = new StringBuilder();
            sb.append("Take it easy, can not get JSONArray of key: ");
            sb.append(str);
            LoggerWrapper.w(str2, sb.toString());
            return null;
        }
    }

    public static JSONObject getJSONObjectSafe(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (Throwable unused) {
            String str2 = f7392a;
            StringBuilder sb = new StringBuilder();
            sb.append("Take it easy, can not get JSONObject of key: ");
            sb.append(str);
            LoggerWrapper.w(str2, sb.toString());
            return null;
        }
    }

    public static boolean isDeviceHitRate(Integer num, ConfigCenterContext configCenterContext) {
        if (configCenterContext != null && num != null) {
            int base64Percent = getBase64Percent(configCenterContext.getIdentifierProvider().getUtdId(configCenterContext.getContext()));
            LoggerWrapper.d(f7392a, String.format("Calc percent = %s, node.rate = %s", Integer.valueOf(base64Percent), num));
            if (base64Percent < num.intValue()) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject kv(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        return jSONObject;
    }

    public static double parseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            LoggerWrapper.w(f7392a, String.format("Cannot parse %s to double!", str));
            return d;
        }
    }

    public static long parseLong(String str, long j) {
        try {
            return (long) Double.parseDouble(str);
        } catch (Throwable unused) {
            LoggerWrapper.w(f7392a, String.format("Cannot parse %s to long!", str));
            return j;
        }
    }

    public static void setupToConfigProxy() {
        ConfigProxy.getInstance().setConfigProvider(new AmcsConfigProvider());
    }

    public static String toJSONString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JSON.toJSONString(obj);
        } catch (Throwable th) {
            String str = f7392a;
            StringBuilder sb = new StringBuilder();
            sb.append("toJSONString failed. error = ");
            sb.append(th.getMessage());
            LoggerWrapper.e(str, sb.toString());
            return null;
        }
    }
}
