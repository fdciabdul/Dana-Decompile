package com.alipay.multimedia.adjuster.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.alipay.multimedia.adjuster.config.ConfigMgr;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes7.dex */
public class AliCdnUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Random f7335a = new Random();
    private static ExecutorService b = null;

    public static int getMaxTextureSize() {
        return 2048;
    }

    public static boolean checkUrlWithFuzzy(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkUrlHostWithExact(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getScreenScale() {
        return ConfigMgr.getInc().getCdnConfigItem().mScreenScale;
    }

    public static boolean checkUrl(String str) {
        return Patterns.WEB_URL.matcher(str).matches();
    }

    public static String getUrlDecoderString(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static boolean isHttp(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        return ("https".equalsIgnoreCase(scheme) || SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(scheme)) && hasHost(uri);
    }

    public static boolean hasHost(Uri uri) {
        String host = uri.getHost();
        return (host == null || "".equals(host)) ? false : true;
    }

    public static int generateRandom(int i, int i2) {
        return (f7335a.nextInt(i2) % ((i2 - i) + 1)) + i;
    }

    public static ExecutorService getSingleExecutor() {
        ExecutorService executorService;
        synchronized (AliCdnUtils.class) {
            if (b == null) {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                b = newSingleThreadExecutor;
                a(newSingleThreadExecutor);
            }
            executorService = b;
        }
        return executorService;
    }

    private static void a(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor) {
            try {
                ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("allTimeout exp=");
                sb.append(th.toString());
                Log.D("AliCdnUtils", sb.toString(), new Object[0]);
            }
        }
    }
}
