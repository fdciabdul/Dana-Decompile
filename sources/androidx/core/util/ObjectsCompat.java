package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class ObjectsCompat {
    public static <T> T BuiltInFictitiousFunctionClassFactory(T t) {
        return t;
    }

    private ObjectsCompat() {
    }

    public static boolean MyBillsEntityDataFactory(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.PlaceComponentResult(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int PlaceComponentResult(Object... objArr) {
        if (Build.VERSION.SDK_INT < 19) {
            return Arrays.hashCode(objArr);
        }
        return Objects.hash(objArr);
    }

    public static String BuiltInFictitiousFunctionClassFactory(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T getAuthRequestContext(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean PlaceComponentResult(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }
}
