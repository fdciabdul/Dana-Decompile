package fsimpl;

/* renamed from: fsimpl.cc  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0279cc extends fn {
    public static int a(fi fiVar) {
        return fiVar.d();
    }

    public static int a(fi fiVar, int i, byte b, int i2, int i3, boolean z) {
        fiVar.f(5);
        c(fiVar, i3);
        b(fiVar, i2);
        a(fiVar, i);
        a(fiVar, z);
        a(fiVar, b);
        return a(fiVar);
    }

    public static void a(fi fiVar, byte b) {
        fiVar.a(1, b, 0);
    }

    public static void a(fi fiVar, int i) {
        fiVar.b(0, i, 0);
    }

    public static void a(fi fiVar, boolean z) {
        fiVar.a(4, z, false);
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(2, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.b(3, i, 0);
    }
}
