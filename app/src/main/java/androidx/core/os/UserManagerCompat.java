package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes.dex */
public class UserManagerCompat {
    private UserManagerCompat() {
    }

    public static boolean PlaceComponentResult(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.PlaceComponentResult(context);
        }
        return true;
    }

    /* loaded from: classes3.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean PlaceComponentResult(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }
}
