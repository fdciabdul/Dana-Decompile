package fsimpl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: fsimpl.cl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288cl extends fn {
    public static void a(fi fiVar) {
        fiVar.f(9);
    }

    public static void a(fi fiVar, double d) {
        fiVar.a(7, d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static void a(fi fiVar, float f) {
        fiVar.a(1, f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static void a(fi fiVar, int i) {
        fiVar.c(0, i, 0);
    }

    public static void a(fi fiVar, long j) {
        fiVar.a(6, j, 0L);
    }

    public static void a(fi fiVar, boolean z) {
        fiVar.a(3, z, false);
    }

    public static int b(fi fiVar) {
        return fiVar.d();
    }

    public static void b(fi fiVar, int i) {
        fiVar.b(2, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.c(8, i, 0);
    }
}
