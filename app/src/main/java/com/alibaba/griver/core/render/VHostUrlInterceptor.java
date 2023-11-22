package com.alibaba.griver.core.render;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class VHostUrlInterceptor {
    public static final String PRERENDER_INDEX_HTML_VHOST = "https://miniprogram.alipay-eco.com";

    public static String wipeOffVhost(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.toLowerCase().indexOf("/index.html");
        return indexOf > 0 ? str.replace(str.substring(0, indexOf), PRERENDER_INDEX_HTML_VHOST) : str;
    }

    public static String mergeVHost(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.startsWith(PRERENDER_INDEX_HTML_VHOST) || TextUtils.isEmpty(str2)) ? str : str.replace(PRERENDER_INDEX_HTML_VHOST, str2);
    }
}
