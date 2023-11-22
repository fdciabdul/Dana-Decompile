package com.alibaba.griver.base.resource.utils;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ErrorPageUtils {
    public static final int APPX_LOAD_FAILED = 10006;
    public static final int APP_LOAD_FAILED = 10006;
    public static final int APP_REMOVED_CODE = 1001;
    public static final int APP_SUSPEND_CODE = 1002;
    public static final String ERROR_TYPE_H5 = "H5";
    public static final String ERROR_TYPE_MINI = "MINI_PROGRAM";
    public static final String STATUS_APPX_FAILED = "APPX_LOAD_FAILED";
    public static final String STATUS_LOAD_FAILED = "LOAD_FAILED";
    public static final String STATUS_WEB_VIEW_INTERCEPTED = "WEB_VIEW_INTERCEPTED";
    public static final int WEB_VIEW_HTTP_FORBIDDEN = 10009;
    public static final int WEB_VIEW_INTERCEPTED = 10007;
    public static final int WEB_VIEW_SCHEME_ERROR = 10008;

    /* renamed from: a  reason: collision with root package name */
    private static String f6377a = "";
    private static String b = "";
    private static String c = "GriverErrorPage/griver_page_error.html";

    public static String getErrorStatusPageUrl() {
        if (TextUtils.isEmpty(b)) {
            return "file:///android_asset/GriverErrorPage/mini-program-native-error.html?appId=%s&errorCode=%s&type=%s";
        }
        if (b.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append("&appId=%s&errorCode=%s&type=%s");
            b = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append("?appId=%s&errorCode=%s&type=%s");
            b = sb2.toString();
        }
        return b;
    }

    public static String getErrorUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(f6377a)) {
            f6377a = getErrorStatusPageUrl();
        }
        return TextUtils.equals(str2, "SUSPENDED") ? String.format(f6377a, str, 1002, str3) : TextUtils.equals(str2, "REMOVED") ? String.format(f6377a, str, 1001, str3) : (TextUtils.equals(str2, STATUS_LOAD_FAILED) || TextUtils.equals(str2, STATUS_APPX_FAILED)) ? String.format(f6377a, str, 10006, str3) : "";
    }

    public static String getH5ErrorPage() {
        return c;
    }

    public static void setH5ErrorPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c = str;
    }

    public static void setStatusErrorPage(String str) {
        b = str;
    }
}
