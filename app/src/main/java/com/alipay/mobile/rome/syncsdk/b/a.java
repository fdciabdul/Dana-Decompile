package com.alipay.mobile.rome.syncsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.util.c;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7215a = "a";
    private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
    private static a c;

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void a(Context context, String str, String str2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                b(context, str, str2);
            }
        }
    }

    public final String a(Context context, String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return c(context, str);
        }
    }

    private String c(Context context, String str) {
        synchronized (this) {
            ConcurrentHashMap<String, String> concurrentHashMap = b;
            String str2 = concurrentHashMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                try {
                    str2 = context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 0).getString(str, null);
                    if (str2 != null) {
                        concurrentHashMap.put(str, str2);
                    }
                } catch (Exception e) {
                    String str3 = f7215a;
                    StringBuilder sb = new StringBuilder("getString: [ Exception ");
                    sb.append(e);
                    sb.append(" ]");
                    c.d(str3, sb.toString());
                }
                return str2;
            }
            return str2;
        }
    }

    private boolean b(Context context, String str, String str2) {
        synchronized (this) {
            try {
                context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 0).edit().putString(str, str2).commit();
                b.put(str, str2);
            } catch (Exception e) {
                String str3 = f7215a;
                StringBuilder sb = new StringBuilder("putString: [ Exception ");
                sb.append(e);
                sb.append(" ]");
                c.d(str3, sb.toString());
                return false;
            }
        }
        return true;
    }

    public final void b(Context context, String str) {
        synchronized (this) {
            b.remove(str);
            try {
                context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 4).edit().remove(str).commit();
            } catch (Exception e) {
                String str2 = f7215a;
                StringBuilder sb = new StringBuilder("putString: [ Exception ");
                sb.append(e);
                sb.append(" ]");
                c.d(str2, sb.toString());
            }
        }
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            a(com.alipay.mobile.rome.syncservice.d.a.f7279a, str, str2);
        }
    }

    public final String a(String str) {
        String a2;
        synchronized (this) {
            a2 = a(com.alipay.mobile.rome.syncservice.d.a.f7279a, str);
        }
        return a2;
    }
}
