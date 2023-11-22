package com.alipay.imobile.network.quake.transport.strategy;

import android.os.Build;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f7075a = a();

    private static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(Build.MODEL);
        return sb.toString();
    }

    public static String b() {
        return f7075a;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f7075a = str;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.contains("mobilegw") && str.contains("alipay");
    }

    public static boolean b(String str) throws MalformedURLException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new URL(str).getHost());
    }
}
