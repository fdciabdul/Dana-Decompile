package com.iap.ac.android.acs.operation.biz.region.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class CookieUtils {
    public static void clearCookies(Context context, String str, String str2) {
        if (shouldUseCookieSyncManager()) {
            CookieSyncManager.createInstance(context);
        }
        String[] cookieParts = getCookieParts(str);
        if (!TextUtils.isEmpty(str2) && cookieParts != null && cookieParts.length > 0) {
            int length = cookieParts.length;
            for (int i = 0; i < length; i++) {
                String str3 = cookieParts[i];
                String[] split = str3 == null ? null : str3.split("=");
                if (split != null && split.length > 0 && TextUtils.equals(str2.trim(), split[0].trim())) {
                    CookieManager cookieManager = CookieManager.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0].trim());
                    sb.append("=; Expires=Wed, 05 JAN 2000 23:59:59 GMT");
                    cookieManager.setCookie(str, sb.toString());
                }
            }
            if (shouldUseCookieSyncManager()) {
                CookieSyncManager.getInstance().sync();
                return;
            }
            try {
                CookieManager.getInstance().flush();
                return;
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clearCookie exception: ");
                sb2.append(e);
                ACLog.e("IAPConnectPlugin", sb2.toString());
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("clearCookie error, key: ");
        sb3.append(str2);
        sb3.append(", cookie: ");
        sb3.append(cookieParts);
        ACLog.e("IAPConnectPlugin", sb3.toString());
    }

    public static String getCookie(String str, String str2) {
        String[] cookieParts;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (cookieParts = getCookieParts(str)) != null && cookieParts.length > 0) {
            int length = cookieParts.length;
            for (int i = 0; i < length; i++) {
                String str3 = cookieParts[i];
                String[] split = str3 == null ? null : str3.split("=");
                if (split != null && split.length == 2 && TextUtils.equals(split[0].trim(), str2.trim())) {
                    return split[1];
                }
            }
        }
        return null;
    }

    public static void setCookieParts(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            CookieManager.getInstance().setCookie(str, sb.toString());
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CookieUtils#getCookieParts, domaim=");
            sb2.append(str);
            sb2.append("error=");
            sb2.append(th);
            ACLog.e("IAPConnectPlugin", sb2.toString());
        }
    }

    public static boolean shouldUseCookieSyncManager() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static String[] getCookieParts(String str) {
        String cookie;
        String[] strArr = new String[0];
        try {
            if (TextUtils.isEmpty(str) || (cookie = CookieManager.getInstance().getCookie(str)) == null) {
                return null;
            }
            return cookie.split(";");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("CookieUtils#getCookieParts, domaim=");
            sb.append(str);
            sb.append("error=");
            sb.append(th);
            ACLog.e("IAPConnectPlugin", sb.toString());
            return strArr;
        }
    }
}
