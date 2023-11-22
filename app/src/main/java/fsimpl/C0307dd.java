package fsimpl;

/* renamed from: fsimpl.dd  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0307dd {

    /* renamed from: a  reason: collision with root package name */
    private final C0304da[] f7932a;
    private final C0304da[] b;
    private final C0304da[] c;

    private C0307dd(C0304da[] c0304daArr, C0304da[] c0304daArr2, C0304da[] c0304daArr3) {
        this.f7932a = c0304daArr;
        this.b = c0304daArr2;
        this.c = c0304daArr3;
    }

    public C0304da a(C0311dh c0311dh, Object obj, C0248az c0248az, boolean z) {
        C0304da a2 = C0305db.a(c0311dh, obj, c0248az, a());
        if (a2 != null) {
            return a2;
        }
        return C0305db.a(c0311dh, obj, c0248az, z ? this.b : this.c);
    }

    public C0304da[] a() {
        return this.f7932a;
    }

    public C0304da[] b() {
        return this.b;
    }

    public C0304da[] c() {
        return this.c;
    }
}
