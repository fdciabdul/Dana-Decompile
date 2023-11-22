package fsimpl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes8.dex */
public final class bP extends fn {
    public static void a(fi fiVar) {
        fiVar.f(5);
    }

    public static void a(fi fiVar, float f) {
        fiVar.a(0, f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static void a(fi fiVar, int i) {
        fiVar.b(1, i, 0);
    }

    public static int b(fi fiVar) {
        return fiVar.d();
    }

    public static void b(fi fiVar, float f) {
        fiVar.a(3, f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static void b(fi fiVar, int i) {
        fiVar.d(2, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.d(4, i, 0);
    }
}
