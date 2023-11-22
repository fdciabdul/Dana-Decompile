package fsimpl;

/* renamed from: fsimpl.cg  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0283cg extends fn {
    public static int a(fi fiVar) {
        return fiVar.d();
    }

    public static int a(fi fiVar, int i) {
        fiVar.f(1);
        b(fiVar, i);
        return a(fiVar);
    }

    public static int a(fi fiVar, int[] iArr) {
        fiVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            fiVar.d(iArr[length]);
        }
        return fiVar.b();
    }

    public static void b(fi fiVar, int i) {
        fiVar.c(0, i, 0);
    }
}
