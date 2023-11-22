package androidx.core.os;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public class BuildCompat {

    /* loaded from: classes.dex */
    public @interface PrereleaseSdkCheck {
    }

    private BuildCompat() {
    }

    protected static boolean getAuthRequestContext(String str, String str2) {
        return !"REL".equals(str2) && str2.toUpperCase(Locale.ROOT).compareTo(str.toUpperCase(Locale.ROOT)) >= 0;
    }

    @Deprecated
    public static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Deprecated
    public static boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT >= 31 || (Build.VERSION.SDK_INT >= 30 && getAuthRequestContext("S", Build.VERSION.CODENAME));
    }

    public static boolean PlaceComponentResult() {
        return Build.VERSION.SDK_INT >= 33 || (Build.VERSION.SDK_INT >= 32 && getAuthRequestContext("Tiramisu", Build.VERSION.CODENAME));
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT >= 33 && getAuthRequestContext("UpsideDownCake", Build.VERSION.CODENAME);
    }
}
