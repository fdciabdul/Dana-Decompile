package com.alipay.mobile.rome.syncsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import org.apache.http.HttpHost;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7267a = "e";

    public static String a(Context context) {
        String extraInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                if (typeName == null || typeName.length() <= 0) {
                    return "unknown";
                }
                if ("wifi".equalsIgnoreCase(typeName)) {
                    return "wifi";
                }
                if ("internet".equalsIgnoreCase(typeName)) {
                    return "internet";
                }
                if (UploadTaskStatusCallback.NETWORK_MOBILE.equalsIgnoreCase(typeName) && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                    if (extraInfo.length() > 0) {
                        return extraInfo;
                    }
                }
            }
        } catch (Exception e) {
            String str = f7267a;
            StringBuilder sb = new StringBuilder("getActiveNetType: [ Exception ");
            sb.append(e);
            sb.append(" ]");
            c.d(str, sb.toString());
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            String str = f7267a;
            StringBuilder sb = new StringBuilder("isNetAvailable: [ Exception ");
            sb.append(e);
            sb.append(" ]");
            c.d(str, sb.toString());
            return false;
        }
    }

    public static HttpHost a() {
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
                return null;
            }
            return new HttpHost(defaultHost, defaultPort);
        } catch (Exception e) {
            String str = f7267a;
            StringBuilder sb = new StringBuilder("getProxy: [ Exception ");
            sb.append(e);
            sb.append(" ]");
            c.d(str, sb.toString());
            return null;
        }
    }

    public static int c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
            return -1;
        } catch (Exception e) {
            String str = f7267a;
            StringBuilder sb = new StringBuilder("getNetworkType: [ Exception ");
            sb.append(e);
            sb.append(" ]");
            c.d(str, sb.toString());
            return -1;
        }
    }
}
