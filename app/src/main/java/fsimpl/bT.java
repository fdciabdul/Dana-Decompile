package fsimpl;

/* loaded from: classes8.dex */
public final class bT extends fn {
    public static int a(fi fiVar, byte[] bArr) {
        return fiVar.a(bArr);
    }

    public static int a(fi fiVar, int[] iArr) {
        fiVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            fiVar.d(iArr[length]);
        }
        return fiVar.b();
    }

    public static void a(fi fiVar) {
        fiVar.f(10);
    }

    public static void a(fi fiVar, byte b) {
        fiVar.a(9, b, 0);
    }

    public static void a(fi fiVar, int i) {
        fiVar.c(0, i, 0);
    }

    public static int b(fi fiVar) {
        return fiVar.d();
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(1, i, 0);
    }

    public static void c(fi fiVar, int i) {
        fiVar.c(2, i, 0);
    }

    public static void d(fi fiVar, int i) {
        fiVar.c(3, i, 0);
    }

    public static void e(fi fiVar, int i) {
        fiVar.c(4, i, 0);
    }

    public static void f(fi fiVar, int i) {
        fiVar.c(5, i, 0);
    }

    public static void g(fi fiVar, int i) {
        fiVar.c(6, i, 0);
    }

    public static void h(fi fiVar, int i) {
        fiVar.c(7, i, 0);
    }

    public static void i(fi fiVar, int i) {
        fiVar.c(8, i, 0);
    }
}
