package fsimpl;

/* renamed from: fsimpl.cr  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C0294cr extends fn {
    public static int a(fi fiVar) {
        return fiVar.d();
    }

    public static int a(fi fiVar, int i, int i2, int i3) {
        fiVar.f(3);
        c(fiVar, i3);
        b(fiVar, i2);
        a(fiVar, i);
        return a(fiVar);
    }

    public static int a(fi fiVar, float[] fArr) {
        fiVar.a(4, fArr.length, 4);
        for (int length = fArr.length - 1; length >= 0; length--) {
            fiVar.b(fArr[length]);
        }
        return fiVar.b();
    }

    public static void a(fi fiVar, int i) {
        fiVar.b(0, i, 0);
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(1, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.c(2, i, 0);
    }
}
