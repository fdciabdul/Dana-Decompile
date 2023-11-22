package com.alipay.mobile.rome.syncsdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7266a = "d";
    private static Map<String, String> b = new HashMap();

    private static Map<String, String> h(Context context) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open("mpaas.properties");
            Properties properties = new Properties();
            properties.load(open);
            if (properties.size() <= 0) {
                Map<String, String> emptyMap = Collections.emptyMap();
                try {
                    open.close();
                } catch (IOException e) {
                    String str = f7266a;
                    StringBuilder sb = new StringBuilder("doGetMpaasProperties IOException:");
                    sb.append(e);
                    c.d(str, sb.toString());
                }
                return emptyMap;
            }
            HashMap hashMap = new HashMap(properties.size());
            for (Map.Entry entry : properties.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            try {
                open.close();
            } catch (IOException e2) {
                String str2 = f7266a;
                StringBuilder sb2 = new StringBuilder("doGetMpaasProperties IOException:");
                sb2.append(e2);
                c.d(str2, sb2.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            try {
                String str3 = f7266a;
                StringBuilder sb3 = new StringBuilder("doGetMpaasProperties exception:");
                sb3.append(th);
                c.d(str3, sb3.toString());
                return Collections.emptyMap();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    String str4 = f7266a;
                    StringBuilder sb4 = new StringBuilder("doGetMpaasProperties IOException:");
                    sb4.append(e3);
                    c.d(str4, sb4.toString());
                }
            }
        }
    }

    public static String a(Context context) {
        return a(context, "appkey");
    }

    public static String b(Context context) {
        return a(context, "AppId");
    }

    private static String a(Context context, String str) {
        if (b.containsKey(str)) {
            return b.get(str);
        }
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                str2 = applicationInfo.metaData.getString(str);
                if (!TextUtils.isEmpty(str2)) {
                    b.put(str, str2);
                    return str2;
                }
            }
        } catch (Throwable th) {
            String str3 = f7266a;
            StringBuilder sb = new StringBuilder("getKeyFromManifest exception:");
            sb.append(th);
            c.d(str3, sb.toString());
        }
        return TextUtils.isEmpty(str2) ? b(context, str) : str2;
    }

    public static String c(Context context) {
        return b(context, "WorkspaceId");
    }

    public static String d(Context context) {
        return b(context, "syncserver");
    }

    public static String e(Context context) {
        return b(context, "syncport");
    }

    public static String f(Context context) {
        return b(context, "syncauthcode");
    }

    private static String b(Context context, String str) {
        if (b.containsKey(str)) {
            return b.get(str);
        }
        try {
            Map<String, String> h = h(context);
            b.putAll(h);
            r0 = h != null ? h.get(str) : null;
            if (r0 != null) {
                b.put(str, r0);
            }
        } catch (Throwable th) {
            String str2 = f7266a;
            StringBuilder sb = new StringBuilder("getKeyFromMpaasProperties exception:");
            sb.append(th);
            c.d(str2, sb.toString());
        }
        return r0;
    }

    public static String g(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context, "appkey"));
        sb.append("-");
        sb.append(b(context, "WorkspaceId"));
        return sb.toString();
    }
}
