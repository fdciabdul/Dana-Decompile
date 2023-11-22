package id.dana.data.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/data/util/NetworkUtils;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "isNetworkAvailable", "(Landroid/content/Context;)Z", "isWifiEnable", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();

    private NetworkUtils() {
    }

    @JvmStatic
    public static final boolean isNetworkAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT > 22) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                    return false;
                }
                return networkCapabilities.hasCapability(12);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean isWifiEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        try {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            if (systemService != null) {
                WifiManager wifiManager = (WifiManager) systemService;
                return wifiManager.isWifiEnabled() && wifiManager.getConnectionInfo().getNetworkId() != -1;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
        } catch (Exception unused) {
            return false;
        }
    }
}
