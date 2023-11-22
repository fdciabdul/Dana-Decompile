package fsimpl;

import android.os.Looper;

/* renamed from: fsimpl.eu  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0350eu {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7977a = false;

    private static void a(String str, String str2, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(c(str2, objArr));
        throw new RuntimeException(sb.toString());
    }

    public static void a(String str, Object... objArr) {
        if (f7977a && Looper.myLooper() != Looper.getMainLooper()) {
            a("This thread should be the UI thread.", str, objArr);
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        a(true, z, str, objArr);
    }

    public static void a(boolean z, boolean z2, String str, Object... objArr) {
        if (f7977a && z != z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("The boolean value should have been '");
            sb.append(z);
            sb.append("' but was '");
            sb.append(z2);
            sb.append("'.");
            a(sb.toString(), str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f7977a && Looper.myLooper() == Looper.getMainLooper()) {
            a("This thread should not be the UI thread.", str, objArr);
        }
    }

    private static String c(String str, Object... objArr) {
        if (fa.b(str)) {
            return "";
        }
        String format = String.format(str, objArr);
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(format);
        return sb.toString();
    }
}
