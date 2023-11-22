package com.iap.ac.android.container.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.iap.ac.android.common.log.ACLog;
import id.dana.data.here.HereOauthManager;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes8.dex */
public class UrlUtils {
    private static final String TAG = "UrlUtils";
    private static LruCache<String, Uri> sCachedUriMap = new LruCache<>(20);
    private static LruCache<String, String> sCachedPurifyUrlMap = new LruCache<>(20);

    public static String purifyUrl(String str) {
        String str2;
        String str3 = sCachedPurifyUrlMap.get(str);
        if (str3 != null) {
            return str3;
        }
        try {
            int indexOf = str.indexOf("#");
            str2 = indexOf != -1 ? str.substring(0, indexOf) : str;
            try {
                if (str2.contains("??")) {
                    sCachedPurifyUrlMap.put(str, str2);
                    return str2;
                }
                int indexOf2 = str2.indexOf("?");
                if (indexOf2 != -1) {
                    str2 = str2.substring(0, indexOf2);
                }
                sCachedPurifyUrlMap.put(str, str2);
                return str2;
            } catch (Throwable unused) {
                sCachedPurifyUrlMap.put(str, str2);
                return str2;
            }
        } catch (Throwable unused2) {
            str2 = str;
        }
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = sCachedUriMap.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            sCachedUriMap.put(str, uri);
            return uri;
        } catch (Exception e) {
            ACLog.e(TAG, "parse url exception.", e);
            return uri;
        }
    }

    public static String getHost(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getHost();
        }
        return null;
    }

    public static String getPath(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getPath();
        }
        return null;
    }

    public static String getParam(Uri uri, String str, String str2) {
        String str3;
        if (uri == null) {
            return str2;
        }
        try {
            str3 = uri.getQueryParameter(str);
        } catch (Exception e) {
            ACLog.e(TAG, "Exception", e);
            str3 = null;
        }
        return !TextUtils.isEmpty(str3) ? str3 : str2;
    }

    public static final String encode(String str) {
        try {
            return URLEncoder.encode(str, HereOauthManager.ENC);
        } catch (Exception e) {
            ACLog.e(TAG, "Exception", e);
            return null;
        }
    }

    public static final String decode(String str) {
        try {
            return URLDecoder.decode(str, HereOauthManager.ENC);
        } catch (Exception e) {
            ACLog.e(TAG, "Exception", e);
            return null;
        }
    }

    public static String getOnlineHost(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("file:///") || str.startsWith("data:")) {
            return null;
        }
        return getHost(str);
    }

    public static boolean isUrlInDomainArray(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        Uri parseUrl = parseUrl(str);
        if (parseUrl == null) {
            ACLog.d(TAG, "parse auto url failed!");
            return false;
        }
        String host = parseUrl.getHost();
        if (TextUtils.isEmpty(host)) {
            ACLog.d(TAG, "can't get url host");
            return false;
        }
        String lowerCase = host.toLowerCase();
        try {
            for (String str2 : strArr) {
                if (!str2.equalsIgnoreCase(lowerCase)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(".");
                    sb.append(str2);
                    if (!lowerCase.endsWith(sb.toString())) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            ACLog.e(TAG, "match auto login exception.", e);
            return false;
        }
    }

    public static boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String domain = getDomain(str2);
        if (TextUtils.isEmpty(domain)) {
            return false;
        }
        if (domain.equals(str)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(str);
        return domain.endsWith(sb.toString());
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception e) {
            ACLog.e(TAG, "getDomain error!", e);
            return null;
        }
    }
}
