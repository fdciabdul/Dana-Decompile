package fsimpl;

/* renamed from: fsimpl.ab  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0224ab {

    /* renamed from: a  reason: collision with root package name */
    private final bG f7843a;
    private final C0275bz b;
    private final aD c;
    private final C0232aj d;
    private final aO e;
    private final cQ f;
    private final bA g;
    private final boolean h;

    public C0224ab(bG bGVar, C0275bz c0275bz, aD aDVar, C0232aj c0232aj, aO aOVar, cQ cQVar, bA bAVar, boolean z) {
        this.f7843a = bGVar;
        this.b = c0275bz;
        this.c = aDVar;
        this.d = c0232aj;
        this.e = aOVar;
        this.f = cQVar;
        this.g = bAVar;
        this.h = z;
    }

    public C0223aa a(aP aPVar, C0230ah c0230ah) {
        return new C0223aa(this.f7843a, this.b.a().a("canvas", false), this.f, aPVar, this.c, this.d, this.e, this.g, this.h, c0230ah == null || c0230ah.r());
    }

    public void a(C0223aa c0223aa) {
        this.b.a().a(c0223aa.d());
    }
}
