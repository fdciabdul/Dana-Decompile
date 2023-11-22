package com.iap.ac.android.acs.multilanguage.utils;

import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.URLUtil;
import com.alibaba.griver.h5.permission.GriverJSAPIPermission;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.common.log.ACLog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LanguagePackageUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7535a = "LanguagePackageUtil";

    protected static JSONObject a(JSONObject jSONObject, String str) {
        Iterator<String> keys = jSONObject.keys();
        String convertConnectSymbol = convertConnectSymbol(str);
        String formatWithPattern = LanguageFormatter.formatWithPattern(convertConnectSymbol);
        JSONObject jSONObject2 = null;
        JSONObject jSONObject3 = null;
        while (keys.hasNext()) {
            String next = keys.next();
            String convertConnectSymbol2 = convertConnectSymbol(next);
            if (convertConnectSymbol.equalsIgnoreCase(convertConnectSymbol2)) {
                jSONObject2 = jSONObject.getJSONObject(next);
            }
            if (formatWithPattern != null && !formatWithPattern.equalsIgnoreCase(convertConnectSymbol) && formatWithPattern.equalsIgnoreCase(convertConnectSymbol2)) {
                jSONObject3 = jSONObject.getJSONObject(next);
            }
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        if (jSONObject3 == null) {
            return jSONObject2;
        }
        JSONObject jSONObject4 = new JSONObject(jSONObject3.toString());
        Iterator<String> keys2 = jSONObject2.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            jSONObject4.put(next2, jSONObject2.getString(next2));
        }
        return jSONObject4;
    }

    public static String convertConnectSymbol(String str) {
        return str.replace("_", "-");
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static Map<String, String> convertToMap(String str, String str2) {
        String str3 = f7535a;
        String logTag = logTag(str3);
        StringBuilder sb = new StringBuilder();
        sb.append("take languageCode :");
        sb.append(str2);
        ACLog.d(logTag, sb.toString());
        HashMap hashMap = new HashMap();
        JSONObject a2 = a(new JSONObject(str), str2);
        if (a2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("convertToMap skipped, for get empty value with the languageCode \"");
            sb2.append(str2);
            sb2.append("\" in cacheInLocal: ");
            sb2.append(str);
            String obj = sb2.toString();
            MultiLanguageLogger.newLogger("ac_lang_fetch_from_local").addParams("errorMessage", obj).event();
            ACLog.w(logTag(str3), obj);
            return hashMap;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a2.optString(next));
        }
        return hashMap;
    }

    public static String formatLanguagePackageUrl(String str) {
        if (URLUtil.isNetworkUrl(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GriverJSAPIPermission.PROTOCOL_HTTPS);
        sb.append(str);
        return sb.toString();
    }

    public static String getCurrentLanguage() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language);
        sb.append("-");
        sb.append(country);
        return sb.toString();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static String logPrefix(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[language-package-id = ");
        sb.append(str);
        sb.append("] ");
        return sb.toString();
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("LanguagePackage_");
        sb.append(str);
        return sb.toString();
    }

    public static String mapToJsonString(Map<?, ?> map) {
        return new JSONObject(map).toString();
    }

    public static boolean needsCheckUpdate(String str, int i) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            j = 0;
        }
        return System.currentTimeMillis() - j > TimeUnit.HOURS.toMillis((long) i);
    }

    public static JSONObject requestFromServer(String str) {
        return new JSONObject(convertStreamToString(FirebasePerfUrlConnection.openStream(new URL(str))));
    }

    public static LruCache<String, Map<String, String>> resizeCache(LruCache<String, Map<String, String>> lruCache, int i) {
        if (lruCache.maxSize() == i || i <= 0) {
            return lruCache;
        }
        Map<String, Map<String, String>> snapshot = lruCache.snapshot();
        LruCache<String, Map<String, String>> lruCache2 = new LruCache<>(i);
        for (Map.Entry<String, Map<String, String>> entry : snapshot.entrySet()) {
            lruCache2.put(entry.getKey(), entry.getValue());
        }
        return lruCache2;
    }

    public static String splitPrefix(String str) {
        String[] split = str.split("-");
        return split.length > 1 ? split[0] : str;
    }
}
