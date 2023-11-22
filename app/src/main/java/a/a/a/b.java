package a.a.a;

/* loaded from: classes3.dex */
public final class b extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f5936a;

    public b(String str) {
        super(str);
    }

    public b(Throwable th) {
        super(th.getMessage());
        this.f5936a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f5936a;
    }
}
