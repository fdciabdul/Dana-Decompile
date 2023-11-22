package fsimpl;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class cZ {

    /* renamed from: a  reason: collision with root package name */
    private static PackageInfo f7906a;

    public static int a(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    public static PackageInfo a() {
        PackageInfo packageInfo;
        synchronized (cZ.class) {
            packageInfo = f7906a;
        }
        return packageInfo;
    }

    public static PackageInfo a(Context context) {
        PackageInfo packageInfo;
        synchronized (cZ.class) {
            if (f7906a != null) {
                Log.e("Package info already initialized");
                throw new RuntimeException("Package info already initialized");
            }
            try {
                f7906a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable th) {
                Log.e("Unable to initialize package info", th);
            }
            packageInfo = f7906a;
        }
        return packageInfo;
    }
}
