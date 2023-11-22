package fsimpl;

/* renamed from: fsimpl.em  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0342em extends AbstractC0340ek {

    /* renamed from: a  reason: collision with root package name */
    private final String f7972a;
    private final String b;
    private final long c;
    private final int d;
    private final long e;
    private final long f;
    private final int g;

    public C0342em(String str, String str2, long j, int i, long j2, long j3, int i2) {
        this.f7972a = str;
        this.b = str2;
        this.c = j;
        this.d = i;
        this.e = j2;
        this.f = j3;
        this.g = i2;
    }

    @Override // fsimpl.InterfaceC0339ej
    public void a(fi fiVar, eJ eJVar) {
        int a2 = fiVar.a(this.f7972a);
        int a3 = fiVar.a(this.b);
        bZ.a(fiVar);
        bZ.a(fiVar, a2);
        bZ.b(fiVar, a3);
        bZ.a(fiVar, this.c);
        bZ.b(fiVar, this.d);
        bZ.c(fiVar, this.e);
        bZ.d(fiVar, this.f);
        bZ.c(fiVar, this.g);
        eJVar.a(a(fiVar, (byte) 22, bZ.b(fiVar)));
    }
}
