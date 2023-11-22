package fsimpl;

/* renamed from: fsimpl.cf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0282cf extends fn {
    public static int a(fi fiVar) {
        return fiVar.d();
    }

    public static int a(fi fiVar, int i, int i2, boolean z, int i3) {
        fiVar.f(4);
        c(fiVar, i3);
        b(fiVar, i2);
        a(fiVar, i);
        a(fiVar, z);
        return a(fiVar);
    }

    public static void a(fi fiVar, int i) {
        fiVar.c(0, i, 0);
    }

    public static void a(fi fiVar, boolean z) {
        fiVar.a(2, z, false);
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(1, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.c(3, i, 0);
    }
}
