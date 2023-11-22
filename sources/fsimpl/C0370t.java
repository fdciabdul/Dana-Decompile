package fsimpl;

/* renamed from: fsimpl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0370t {

    /* renamed from: a  reason: collision with root package name */
    private static final C0370t f8002a = new C0370t();
    private static final C0370t b = new C0370t();

    private C0370t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0370t b(bG bGVar) {
        return bGVar == null || bGVar.c() ? f8002a : b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0370t e() {
        return f8002a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0370t f() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this == f8002a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this == b;
    }
}
