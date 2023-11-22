package com.ta.audid.e;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f7675a;

    public static String F() {
        try {
            return a("imei");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String G() {
        try {
            return a("imsi");
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, String str2) {
        synchronized (a.class) {
            Context context = com.ta.audid.a.a().getContext();
            if (context == null) {
                return;
            }
            try {
                if (b()) {
                    if (!TextUtils.isEmpty(str)) {
                        f7675a.put("imei", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        f7675a.put("imsi", str2);
                    }
                } else {
                    f7675a = new HashMap();
                    if (!TextUtils.isEmpty(str)) {
                        f7675a.put("imei", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        f7675a.put("imsi", str2);
                    }
                    String e = com.ta.audid.a.c.e(context);
                    if (!TextUtils.isEmpty(e)) {
                        f7675a.put("gsid", e);
                    }
                    com.ta.audid.f.e.f(e.e(new JSONObject(f7675a).toString()));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static String a(String str) {
        synchronized (a.class) {
            if (com.ta.audid.a.a().getContext() == null) {
                return "";
            }
            Map<String, String> map = f7675a;
            if (map != null) {
                return map.get(str);
            } else if (b()) {
                return f7675a.get(str);
            } else {
                c();
                return "";
            }
        }
    }

    private static void c() {
        try {
            f7675a.clear();
            f7675a = null;
            com.ta.audid.f.e.f("");
        } catch (Exception unused) {
        }
    }

    private static boolean b() {
        if (com.ta.audid.a.a().getContext() == null) {
            return false;
        }
        try {
            Map<String, String> a2 = com.ta.audid.g.d.a(e.d(com.ta.audid.f.e.N()));
            f7675a = a2;
            if (com.ta.audid.a.c.e(com.ta.audid.a.a().getContext()).equals(a2.get("gsid"))) {
                return true;
            }
            c();
            return false;
        } catch (Exception unused) {
            c();
            return false;
        }
    }
}
