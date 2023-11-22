package com.ta.audid.f;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.audid.g.l;
import com.ta.audid.g.m;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {
    private static final String i;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".UTSystemConfig");
        sb.append(File.separator);
        sb.append("Global");
        i = sb.toString();
    }

    private static String I() {
        if (com.ta.audid.d.d.h(com.ta.audid.a.a().getContext())) {
            StringBuilder sb = new StringBuilder();
            sb.append(T());
            sb.append(File.separator);
            sb.append("cec06585501c9775");
            return sb.toString();
        }
        return null;
    }

    public static String J() {
        try {
            String I = I();
            if (!TextUtils.isEmpty(I)) {
                String f = com.ta.audid.g.c.f(I);
                if (TextUtils.isEmpty(f) || f.length() == 32 || f.length() == 36) {
                    return f;
                }
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(f.length());
                hashMap.put("len", sb.toString());
                hashMap.put("type", "read");
                l.a("audid", hashMap);
                return null;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void d(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("audid:");
            sb.append(str);
            m.m249a("", sb.toString());
            String I = I();
            if (TextUtils.isEmpty(I)) {
                return;
            }
            if (!TextUtils.isEmpty(str) && str.length() != 32 && str.length() != 36) {
                HashMap hashMap = new HashMap();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str.length());
                hashMap.put("len", sb2.toString());
                hashMap.put("type", "write");
                l.a("audid", hashMap);
                return;
            }
            com.ta.audid.g.c.b(I, str);
        } catch (Exception unused) {
        }
    }

    private static String K() {
        if (com.ta.audid.d.d.h(com.ta.audid.a.a().getContext())) {
            StringBuilder sb = new StringBuilder();
            sb.append(T());
            sb.append(File.separator);
            sb.append("7934039a7252be16");
            return sb.toString();
        }
        return null;
    }

    public static String L() {
        try {
            String K = K();
            if (TextUtils.isEmpty(K)) {
                return null;
            }
            return com.ta.audid.g.c.f(K);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void e(String str) {
        try {
            String K = K();
            if (TextUtils.isEmpty(K)) {
                return;
            }
            com.ta.audid.g.c.b(K, str);
        } catch (Exception unused) {
        }
    }

    private static String M() {
        if (com.ta.audid.d.d.h(com.ta.audid.a.a().getContext())) {
            StringBuilder sb = new StringBuilder();
            sb.append(T());
            sb.append(File.separator);
            sb.append("322a309482c4dae6");
            return sb.toString();
        }
        return null;
    }

    public static String N() {
        try {
            String M = M();
            if (TextUtils.isEmpty(M)) {
                return null;
            }
            return com.ta.audid.g.c.f(M);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void f(String str) {
        try {
            String M = M();
            if (TextUtils.isEmpty(M)) {
                return;
            }
            com.ta.audid.g.c.b(M, str);
        } catch (Exception unused) {
        }
    }

    private static String O() {
        Context context = com.ta.audid.a.a().getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(q(context));
        sb.append(File.separator);
        sb.append("4635b664f789000d");
        String obj = sb.toString();
        m.m249a("", obj);
        return obj;
    }

    public static String P() {
        Context context = com.ta.audid.a.a().getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(q(context));
        sb.append(File.separator);
        sb.append("9983c160aa044115");
        return sb.toString();
    }

    public static String Q() {
        Context context = com.ta.audid.a.a().getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(q(context));
        sb.append(File.separator);
        sb.append("a325712a39bd320a");
        return sb.toString();
    }

    public static String R() {
        Context context = com.ta.audid.a.a().getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(q(context));
        sb.append(File.separator);
        sb.append("719893c6fa359335");
        return sb.toString();
    }

    public static String S() {
        try {
            return com.ta.audid.g.c.f(O());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void g(String str) {
        try {
            m.d();
            com.ta.audid.g.c.b(O(), str);
        } catch (Throwable unused) {
        }
    }

    private static String T() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(i);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SdcardRoot dir:");
        sb2.append(obj);
        m.m249a("", sb2.toString());
        com.ta.audid.g.c.h(obj);
        return obj;
    }

    private static String q(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(".7934039a7252be16");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UtdidAppRoot dir:");
        sb2.append(obj);
        m.m249a("", sb2.toString());
        com.ta.audid.g.c.h(obj);
        return obj;
    }

    public static void a(Context context, String str) {
        String str2;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), "7934039a7252be16");
        } catch (Exception unused) {
            str2 = null;
        }
        if (str.equals(str2)) {
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), "7934039a7252be16", str);
        } catch (Exception unused2) {
        }
    }

    public static String r(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "7934039a7252be16");
        } catch (Exception unused) {
            return null;
        }
    }
}
