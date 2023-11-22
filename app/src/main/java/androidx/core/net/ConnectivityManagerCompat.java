package androidx.core.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class ConnectivityManagerCompat {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RestrictBackgroundStatus {
    }

    public static boolean MyBillsEntityDataFactory(ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.PlaceComponentResult(connectivityManager);
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        int type = activeNetworkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    private ConnectivityManagerCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean PlaceComponentResult(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    /* loaded from: classes6.dex */
    static class Api24Impl {
        private Api24Impl() {
        }
    }
}
