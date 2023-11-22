package com.alipay.imobile.network.quake.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import j$.util.DesugarTimeZone;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f7080a = DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("GMT");

    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7081a;

        a(String str) {
            this.f7081a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f7081a);
            thread.setDaemon(true);
            return thread;
        }
    }

    public static int a(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int b(String str, int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return i;
            }
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2 + 1;
            }
        }
    }

    public static String c(String str, int i, int i2) {
        int a2 = a(str, i, i2);
        return str.substring(a2, b(str, a2, i2));
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            LoggerWrapper.w(Quake.TAG, "handler.getConfig().getUrl() is null");
            return false;
        }
        try {
            URL url = new URL(str);
            if (url.getHost().contains("mobilegw") && url.getHost().contains("alipay")) {
                return url.getHost().lastIndexOf("alipay.com") != -1;
            }
        } catch (MalformedURLException e) {
            LoggerWrapper.e(Quake.TAG, "", e);
        }
        return false;
    }

    public static int a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 16384);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            LoggerWrapper.e(Quake.TAG, "", e);
            return false;
        }
    }

    public static int a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static boolean a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String c(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (a(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException e) {
            LoggerWrapper.e(Quake.TAG, "", e);
            return null;
        }
    }

    public static ThreadFactory b(String str) {
        return new a(str);
    }

    public static String a(Context context) {
        Locale locale;
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e) {
            LoggerWrapper.e(Quake.TAG, "", e);
            locale = null;
        }
        if (locale != null) {
            if (Locale.CHINA.equals(locale)) {
                return "zh-Hans";
            }
            if (Locale.TAIWAN.equals(locale)) {
                return "zh-Hant";
            }
            if (locale.equals(new Locale("zh", "HK"))) {
                return "zh-HK";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage());
            sb.append("-");
            sb.append(locale.getCountry());
            return sb.toString();
        }
        return "";
    }

    public static boolean a() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }
}
