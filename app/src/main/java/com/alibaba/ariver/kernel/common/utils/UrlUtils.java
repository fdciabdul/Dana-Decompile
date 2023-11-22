package com.alibaba.ariver.kernel.common.utils;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.collection.LruCache;
import androidx.core.util.Pair;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import id.dana.data.here.HereOauthManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class UrlUtils {
    public static final String TAG = "AriverKernel:UrlUtils";

    /* renamed from: a  reason: collision with root package name */
    private static LruCache<String, Uri> f6167a = new LruCache<>(20);
    private static LruCache<String, String> b = new LruCache<>(20);

    public static String matchAppIdRaw(String str) {
        String str2;
        String host = getHost(str);
        if (host != null) {
            if (host.contains("h5app") || host.contains("hybrid")) {
                if (host.contains("h5app")) {
                    str2 = "\\d+\\.h5app\\.(alipay|m\\.taobao|m\\.taopiaopiao)\\.(net|com)";
                } else {
                    str2 = host.contains("hybrid") ? "^\\d+[.]hybrid[.]alipay-eco[.](com|net)$" : "";
                }
                Pattern compile = PatternUtils.compile(str2);
                if (compile == null || TextUtils.isEmpty(host)) {
                    return null;
                }
                Matcher matcher = compile.matcher(host);
                if (matcher.find()) {
                    String group = matcher.group();
                    if (TextUtils.isEmpty(group)) {
                        return null;
                    }
                    return group.substring(0, group.indexOf("."));
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static Pair<String, Bundle> parseAriverCodeUrl(String str) {
        return parseAriverCodeUrl(parseUrl(str));
    }

    public static Pair<String, Bundle> parseAriverCodeUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            String queryParameter = (rVEnvironmentService == null || !"AP".equals(rVEnvironmentService.defaultPlatform())) ? null : uri.getQueryParameter("_ap_ariver_appid");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getQueryParameter("_ariver_appid");
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            Bundle bundle = new Bundle();
            for (String str : uri.getQueryParameterNames()) {
                if (!"_ariver_appid".equals(str) && !"_ap_ariver_appid".equals(str)) {
                    bundle.putString(str, uri.getQueryParameter(str));
                }
            }
            return new Pair<>(queryParameter, bundle);
        } catch (Throwable th) {
            RVLogger.e(TAG, "parseAriverCodeUrl exception!", th);
            return null;
        }
    }

    public static String getCORSUrl(String str) {
        try {
            Uri parseUrl = parseUrl(str);
            if (parseUrl == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(parseUrl.getScheme());
            sb.append("://");
            sb.append(parseUrl.getHost());
            String obj = sb.toString();
            if (parseUrl.getPort() != -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(":");
                sb2.append(parseUrl.getPort());
                return sb2.toString();
            }
            return obj;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String mergeUrl(String str, String str2) {
        String purifyUrl;
        int lastIndexOf;
        Uri parseUrl = parseUrl(str2);
        if (parseUrl != null && TextUtils.isEmpty(parseUrl.getScheme())) {
            String str3 = null;
            if (str2.startsWith("//")) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                Uri parseUrl2 = parseUrl(str);
                if (parseUrl2 != null && !TextUtils.isEmpty(parseUrl2.getScheme())) {
                    String scheme = parseUrl2.getScheme();
                    StringBuilder sb = new StringBuilder();
                    sb.append(scheme);
                    sb.append(":");
                    sb.append(str2);
                    str3 = sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getAbsoluteUrl // ");
                sb2.append(str3);
                RVLogger.d(TAG, sb2.toString());
                return str3;
            } else if (str2.startsWith("/")) {
                Uri parseUrl3 = parseUrl(str);
                if (parseUrl3 == null) {
                    return null;
                }
                String scheme2 = parseUrl3.getScheme();
                String authority = parseUrl3.getAuthority();
                if (!TextUtils.isEmpty(scheme2) && !TextUtils.isEmpty(authority)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(scheme2);
                    sb3.append("://");
                    sb3.append(authority);
                    sb3.append(str2);
                    str3 = sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("getAbsoluteUrl / ");
                sb4.append(str3);
                RVLogger.d(TAG, sb4.toString());
                return str3;
            } else if (TextUtils.isEmpty(str2) || (lastIndexOf = (purifyUrl = purifyUrl(str)).lastIndexOf("/")) == -1) {
                return null;
            } else {
                String substring = purifyUrl.substring(0, lastIndexOf);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(substring);
                sb5.append("/");
                sb5.append(str2);
                String obj = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getAbsoluteUrl else ");
                sb6.append(obj);
                RVLogger.d(TAG, sb6.toString());
                return obj;
            }
        }
        return str2;
    }

    public static String purifyUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
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
        Uri uri = f6167a.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            f6167a.put(str, uri);
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

    public static String getPath(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getPath();
        }
        return null;
    }

    public static String getHash(String str) {
        int indexOf;
        Uri parseUrl = parseUrl(str);
        String fragment = parseUrl != null ? parseUrl.getFragment() : null;
        if (fragment != null && (indexOf = fragment.indexOf("?")) > 0) {
            fragment = fragment.substring(0, indexOf);
        }
        return (fragment == null || !fragment.startsWith("/")) ? fragment : fragment.substring(1);
    }

    public static String getPathAndHash(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPath(str));
        sb.append("#");
        sb.append(getHash(str));
        return sb.toString();
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

    public static final String encodeOffilineUrlForAuth(String str) {
        String str2;
        Exception e;
        try {
            Uri parseUrl = parseUrl(str);
            String str3 = null;
            if (parseUrl != null) {
                str3 = parseUrl.getFragment();
                if (!str.contains(str3)) {
                    str3 = parseUrl.getEncodedFragment();
                }
            }
            if (str3 != null) {
                str2 = URLEncoder.encode(str3, HereOauthManager.ENC);
                try {
                    return str.replace(str3, str2);
                } catch (Exception e2) {
                    e = e2;
                    RVLogger.e(TAG, "Exception", e);
                    return str2;
                }
            }
            return str;
        } catch (Exception e3) {
            str2 = str;
            e = e3;
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

    public static String getAbsoluteUrlWithURLLib(String str, String str2) {
        Uri parseUrl = parseUrl(str2);
        if (parseUrl != null && TextUtils.isEmpty(parseUrl.getScheme())) {
            try {
                return new URL(new URL(str), str2).toString();
            } catch (MalformedURLException e) {
                RVLogger.e(TAG, "getAbsoluteUrlWithURLLib fatal error ", e);
                return null;
            }
        }
        return str2;
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

    public static boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
    }
}
