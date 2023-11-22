package com.alipay.multimedia.adjuster.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/* loaded from: classes7.dex */
public class ZURLEncodedUtil {
    public static final String TAG = "ZURLEncodedUtil";

    /* renamed from: a  reason: collision with root package name */
    private static final Log f7339a = Log.getLogger(TAG);

    public static String urlEncode(String str) {
        try {
            URL a2 = a(str);
            try {
                return UrlFixer.fixUrl(a2.toString());
            } catch (Throwable th) {
                if (a2 != null) {
                    str = a2.toString();
                }
                Log log = f7339a;
                StringBuilder sb = new StringBuilder();
                sb.append("New URI(");
                sb.append(str);
                sb.append(") exception ");
                sb.append(th.toString());
                log.i(sb.toString(), new Object[0]);
                return a2.toString();
            }
        } catch (MalformedURLException e) {
            Log log2 = f7339a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkURL exception ");
            sb2.append(e.toString());
            log2.w(sb2.toString(), new Object[0]);
            return str;
        }
    }

    private static URL a(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (Exception e) {
            Log log = f7339a;
            StringBuilder sb = new StringBuilder();
            sb.append("new URL(");
            sb.append(str);
            sb.append(")  exception ");
            sb.append(e.toString());
            log.w(sb.toString(), new Object[0]);
            try {
                str = URLDecoder.decode(str);
            } catch (Throwable th) {
                Log log2 = f7339a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("decode uri=");
                sb2.append(str);
                sb2.append(", exception ");
                sb2.append(th.toString());
                log2.w(sb2.toString(), new Object[0]);
            }
            return new URL(str);
        }
    }
}
