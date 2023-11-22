package com.alibaba.griver.h5.utils;

import android.net.Uri;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class H5AppInfoUtils {
    public static String getVhost(String str) {
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getScheme());
            sb.append("://");
            sb.append(parse.getHost());
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("vhost = ");
            sb2.append(obj);
            GriverLogger.d("H5AppInfoUtils", sb2.toString());
            return obj;
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getVhost");
            sb3.append(e.getMessage());
            GriverLogger.w("H5AppInfoUtils", sb3.toString());
            return null;
        }
    }
}
