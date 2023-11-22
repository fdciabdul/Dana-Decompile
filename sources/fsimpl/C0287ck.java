package fsimpl;

/* renamed from: fsimpl.ck  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0287ck extends fn {
    public static int a(fi fiVar) {
        return fiVar.d();
    }

    public static int a(fi fiVar, int i, int i2) {
        fiVar.f(2);
        b(fiVar, i2);
        a(fiVar, i);
        return a(fiVar);
    }

    public static int a(fi fiVar, int[] iArr) {
        fiVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            fiVar.d(iArr[length]);
        }
        return fiVar.b();
    }

    public static void a(fi fiVar, int i) {
        fiVar.c(0, i, 0);
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(1, i, 0);
    }
}
