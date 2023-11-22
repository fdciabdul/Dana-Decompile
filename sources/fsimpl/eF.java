package fsimpl;

import com.fullstory.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Date;

/* loaded from: classes4.dex */
class eF {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7952a = false;

    private static int a(fi fiVar, double d) {
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.a(fiVar, d);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    private static int a(fi fiVar, float f) {
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.a(fiVar, f);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    private static int a(fi fiVar, int i) {
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.b(fiVar, i);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    private static int a(fi fiVar, long j) {
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.a(fiVar, j);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(fi fiVar, eB eBVar, Object obj) {
        switch (eG.f7953a[eBVar.ordinal()]) {
            case 1:
                return a(fiVar, obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
            case 2:
                return a(fiVar, obj instanceof Number ? ((Number) obj).intValue() : 0);
            case 3:
                return a(fiVar, obj instanceof Number ? ((Number) obj).longValue() : 0L);
            case 4:
                return a(fiVar, obj instanceof Number ? ((Number) obj).floatValue() : 0.0f);
            case 5:
                return a(fiVar, obj instanceof Number ? ((Number) obj).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            case 6:
                return a(fiVar, (Date) obj);
            case 7:
                return a(fiVar, fa.c((CharSequence) obj));
            default:
                a(obj.getClass());
                return 0;
        }
    }

    private static int a(fi fiVar, String str) {
        int a2 = fiVar.a(str);
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.a(fiVar, a2);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    private static int a(fi fiVar, Date date) {
        int a2 = fiVar.a(eC.a(date));
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.c(fiVar, a2);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    private static int a(fi fiVar, boolean z) {
        a(fiVar);
        try {
            fiVar.c(true);
            C0288cl.a(fiVar, z);
            fiVar.c(false);
            return b(fiVar);
        } catch (Throwable th) {
            fiVar.c(false);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(eB eBVar, Object obj) {
        switch (eG.f7953a[eBVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
            case 2:
                return Integer.valueOf(obj instanceof Number ? ((Number) obj).intValue() : 0);
            case 3:
                return Long.valueOf(obj instanceof Number ? ((Number) obj).longValue() : 0L);
            case 4:
                return Float.valueOf(obj instanceof Number ? ((Number) obj).floatValue() : 0.0f);
            case 5:
                return Double.valueOf(obj instanceof Number ? ((Number) obj).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            case 6:
                return obj != null ? ((Date) obj).clone() : new Date(0L);
            case 7:
                return obj != null ? ((CharSequence) obj).toString() : "";
            default:
                a(obj.getClass());
                return null;
        }
    }

    private static void a(fi fiVar) {
        C0288cl.a(fiVar);
    }

    public static void a(Class cls) {
        String format = String.format("Encountered unsupported property type: %s", cls.getName());
        if (!f7952a) {
            format = String.format("%s\n%s", format, "Supported value types for properties are: boolean, int, long, float, double, CharSequence, and Date.\nAdditional supported types are: Collection<V> and V[] where V is a supported value type and Map<String, T> where T is any supported type including nested maps. Collection<? super V> and Map<String, ? super T> are accepted, but only elements with supported value types will be handled.");
            f7952a = true;
        }
        Log.e(format);
    }

    private static int b(fi fiVar) {
        return C0285ci.a(fiVar, (byte) 3, C0288cl.b(fiVar));
    }
}
