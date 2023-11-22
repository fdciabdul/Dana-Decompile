package com.alibaba.griver.core.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5UrlHelper;

/* loaded from: classes2.dex */
public class H5CookieUtil {
    public static String getCookie(String str) {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                Uri parseUrl = H5UrlHelper.parseUrl(str);
                String host = parseUrl != null ? parseUrl.getHost() : null;
                return (parseUrl == null || TextUtils.isEmpty(host)) ? cookie : cookieManager.getCookie(host);
            }
            return cookie;
        } catch (Throwable th) {
            GriverLogger.e("H5CookieUtil", "get cookie failed", th);
            return null;
        }
    }

    public static void setCookie(String str, String str2) {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(str, str2);
            CookieSyncManager.createInstance(GriverEnv.getApplicationContext()).sync();
        } catch (Throwable th) {
            GriverLogger.e("H5CookieUtil", "set cookie failed", th);
        }
    }
}
