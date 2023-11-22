package com.alipay.mobile.apmap.util;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class AdapterUtil {
    public static final String CLASS_MAP_2D_INITIALIZER = "com.amap.api.maps2d.MapsInitializer";
    public static final String CLASS_MAP_INITIALIZER = "com.amap.api.maps.MapsInitializer";
    public static final String MAP_BUNDLE_NAME = "android-phone-thirdparty-amap3dmap";
    public static final String PACKAGE_WALLET = "com.eg.android.AlipayGphone";
    public static final String TAG = "AdapterUtil";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7116a = false;
    private static boolean b = true;
    private static volatile boolean c = false;
    private static volatile boolean d = false;
    private static volatile int e = -1;
    private static volatile int f = -1;
    private static boolean g = true;
    private static volatile boolean h;

    static boolean isMap3DEnabledFor64Bit() {
        return false;
    }

    static boolean isRunning64Bit() {
        return false;
    }

    public static boolean prepareMap3DBundle() {
        return true;
    }

    private static void a() {
        if (h) {
            return;
        }
        h = true;
        Runnable runnable = new Runnable() { // from class: com.alipay.mobile.apmap.util.AdapterUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    int unused = AdapterUtil.e;
                } catch (Throwable th) {
                    RVLogger.e(AdapterUtil.TAG, th);
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean is2dMapSdk() {
        boolean z = e == -1;
        if (z && isRunning64Bit() && !isMap3DEnabledFor64Bit()) {
            a();
            RVLogger.d(TAG, "map 3d is not enabled for 64 bit");
            return true;
        }
        e = 0;
        if (z) {
            a();
            if (e == 0 && b) {
                try {
                    prepareMap3DBundle();
                } catch (Exception e2) {
                    RVLogger.e(TAG, e2);
                }
            }
        }
        return e == 0;
    }

    public static boolean isGoogleMapSdk() {
        return g;
    }

    public static void setGoogleMapSdkFlag(boolean z) {
        g = z;
    }

    public static boolean isMarkerAnimAvailable() {
        if (g) {
            return true;
        }
        return !is2dMapSdk();
    }
}
