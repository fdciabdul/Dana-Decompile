package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Preconditions {
    public static <T> T KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        return t;
    }

    public static void getAuthRequestContext(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void MyBillsEntityDataFactory(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T extends CharSequence> T BuiltInFictitiousFunctionClassFactory(T t, Object obj) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t;
    }

    public static <T> T KClassImpl$Data$declaredNonStaticMembers$2(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void getAuthRequestContext(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i) {
        if ((i & 1) == i) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested flags 0x");
        sb.append(Integer.toHexString(i));
        sb.append(", but only 0x");
        sb.append(Integer.toHexString(1));
        sb.append(" are allowed");
        throw new IllegalArgumentException(sb.toString());
    }

    public static int MyBillsEntityDataFactory(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static int PlaceComponentResult(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i, String str) {
        if (i >= 0) {
            if (i <= 5) {
                return i;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, 0, 5));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, 0, 5));
    }

    private Preconditions() {
    }
}
