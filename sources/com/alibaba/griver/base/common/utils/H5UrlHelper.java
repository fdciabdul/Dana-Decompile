package com.alibaba.griver.base.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import id.dana.data.here.HereOauthManager;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public class H5UrlHelper {
    public static final String TAG = "H5UrlHelper";

    /* renamed from: a  reason: collision with root package name */
    private static LruCache<String, Uri> f6310a = new LruCache<>(20);
    private static LruCache<String, String> b = new LruCache<>(20);

    public static String purifyUrl(String str) {
        String str2;
        String str3 = b.get(str);
        if (str3 != null) {
            return str3;
        }
        try {
            int indexOf = str.indexOf("#");
            str2 = indexOf != -1 ? str.substring(0, indexOf) : str;
            try {
                if (str2.contains("??")) {
                    b.put(str, str2);
                    return str2;
                }
                int indexOf2 = str2.indexOf("?");
                if (indexOf2 != -1) {
                    str2 = str2.substring(0, indexOf2);
                }
                b.put(str, str2);
                return str2;
            } catch (Throwable unused) {
                b.put(str, str2);
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
        Uri uri = f6310a.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            f6310a.put(str, uri);
            return uri;
        } catch (Exception e) {
            RVLogger.e(TAG, "parse url exception.", e);
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

    public static String getScheme(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getScheme();
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
            RVLogger.e(TAG, "Exception", e);
            str3 = null;
        }
        return !TextUtils.isEmpty(str3) ? str3 : str2;
    }

    public static final String encode(String str) {
        try {
            return URLEncoder.encode(str, HereOauthManager.ENC);
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
            return null;
        }
    }

    public static final String decode(String str) {
        try {
            return URLDecoder.decode(str, HereOauthManager.ENC);
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
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
            RVLogger.d(TAG, "parse auto url failed!");
            return false;
        }
        String host = parseUrl.getHost();
        if (TextUtils.isEmpty(host)) {
            RVLogger.d(TAG, "can't get url host");
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
            RVLogger.e(TAG, "match auto login exception.", e);
            return false;
        }
    }

    public static String stripAnchor(String str) {
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            StringBuilder sb = new StringBuilder();
            sb.append("stripAnchor url:");
            sb.append(str);
            sb.append(" afterUrl:");
            sb.append(substring);
            RVLogger.d(TAG, sb.toString());
            return substring;
        }
        return str;
    }

    public static boolean equalsUrl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str == null && str2 == null;
        }
        if (!str.endsWith("/")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            str = sb.toString();
        }
        if (!str2.endsWith("/")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("/");
            str2 = sb2.toString();
        }
        return str.equals(str2);
    }
}
