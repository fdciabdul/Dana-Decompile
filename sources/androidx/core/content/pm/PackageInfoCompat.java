package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;

/* loaded from: classes.dex */
public final class PackageInfoCompat {
    public static long getAuthRequestContext(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.PlaceComponentResult(packageInfo);
        }
        return packageInfo.versionCode;
    }

    private PackageInfoCompat() {
    }

    /* loaded from: classes.dex */
    static class Api28Impl {
        private Api28Impl() {
        }

        static long PlaceComponentResult(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }
}
