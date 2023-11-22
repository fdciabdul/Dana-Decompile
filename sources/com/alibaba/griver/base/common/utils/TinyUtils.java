package com.alibaba.griver.base.common.utils;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes6.dex */
public class TinyUtils {

    /* renamed from: a  reason: collision with root package name */
    private static LruCache<String, Uri> f6317a = new LruCache<>(20);

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return exists(new File(str));
    }

    public static boolean exists(File file) {
        return file != null && file.exists();
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = f6317a.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            f6317a.put(str, uri);
            return uri;
        } catch (Exception e) {
            RVLogger.e("TinyUtils", "parse url exception.", e);
            return uri;
        }
    }

    public static String getAbsoluteUrlWithURLLib(String str, String str2) {
        Uri parseUrl = parseUrl(str2);
        if (parseUrl != null && TextUtils.isEmpty(parseUrl.getScheme())) {
            try {
                return new URL(new URL(str), str2).toString();
            } catch (MalformedURLException e) {
                RVLogger.e("TinyUtils", "getAbsoluteUrlWithURLLib fatal error ", e);
                return null;
            }
        }
        return str2;
    }

    public static String getAbsoluteUrlV2(String str, String str2, Bundle bundle) {
        String obj;
        Uri parseUrl = parseUrl(str2);
        if (parseUrl != null && TextUtils.isEmpty(parseUrl.getScheme())) {
            String str3 = null;
            if (str2.startsWith("./")) {
                Uri parseUrl2 = parseUrl(str);
                if (parseUrl2 == null) {
                    return null;
                }
                String scheme = parseUrl2.getScheme();
                String authority = parseUrl2.getAuthority();
                String encodedPath = parseUrl2.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    int lastIndexOf = encodedPath.lastIndexOf("/");
                    StringBuilder sb = new StringBuilder();
                    sb.append(scheme);
                    sb.append("://");
                    sb.append(authority);
                    sb.append(encodedPath.substring(0, lastIndexOf));
                    sb.append(str2.substring(1));
                    obj = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(scheme);
                    sb2.append("://");
                    sb2.append(authority);
                    sb2.append(str2.substring(1));
                    obj = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getAbsoluteUrlV2 ./ ");
                sb3.append(obj);
                GriverLogger.d("TinyUtils", sb3.toString());
                return obj;
            }
            Uri parseUrl3 = parseUrl(str);
            if (parseUrl3 == null) {
                return null;
            }
            String scheme2 = parseUrl3.getScheme();
            String authority2 = parseUrl3.getAuthority();
            if (!TextUtils.isEmpty(scheme2) && !TextUtils.isEmpty(authority2)) {
                if (str2.startsWith("/")) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(scheme2);
                    sb4.append("://");
                    sb4.append(authority2);
                    sb4.append(str2);
                    str3 = sb4.toString();
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(scheme2);
                    sb5.append("://");
                    sb5.append(authority2);
                    sb5.append("/");
                    sb5.append(str2);
                    str3 = sb5.toString();
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getAbsoluteUrlV2 / or else ");
            sb6.append(str3);
            GriverLogger.d("TinyUtils", sb6.toString());
            return str3;
        }
        return str2;
    }

    public static boolean isMain() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
