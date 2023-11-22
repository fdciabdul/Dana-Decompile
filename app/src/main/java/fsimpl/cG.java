package fsimpl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes8.dex */
public final class cG extends fn {
    public static int a(fi fiVar, float[] fArr) {
        fiVar.a(4, fArr.length, 4);
        for (int length = fArr.length - 1; length >= 0; length--) {
            fiVar.b(fArr[length]);
        }
        return fiVar.b();
    }

    public static int a(fi fiVar, int[] iArr) {
        fiVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            fiVar.c(iArr[length]);
        }
        return fiVar.b();
    }

    public static void a(fi fiVar) {
        fiVar.f(7);
    }

    public static void a(fi fiVar, byte b) {
        fiVar.a(0, b, 0);
    }

    public static void a(fi fiVar, float f) {
        fiVar.a(3, f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static void a(fi fiVar, int i) {
        fiVar.d(1, i, 0);
    }

    public static int b(fi fiVar) {
        return fiVar.d();
    }

    public static void b(fi fiVar, byte b) {
        fiVar.a(6, b, 0);
    }

    public static void b(fi fiVar, int i) {
        fiVar.d(2, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.c(4, i, 0);
    }

    public static void d(fi fiVar, int i) {
        fiVar.a(4, i, 4);
    }

    public static void e(fi fiVar, int i) {
        fiVar.c(5, i, 0);
    }
}
