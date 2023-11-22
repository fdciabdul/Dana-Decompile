package fsimpl;

/* loaded from: classes8.dex */
public abstract class Z {

    /* renamed from: a  reason: collision with root package name */
    private final int f7817a;
    private int b = 0;
    private eK c = new eK(10, 0.75f);

    public Z(int i) {
        this.f7817a = i;
    }

    public int a(int i) {
        int a2;
        if (this.b == 0 || (a2 = this.c.a(i)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a() {
        int i = this.b + 1;
        this.b = i;
        if (i >= this.f7817a) {
            this.b = 0;
        }
    }

    public void a(int i, int i2) {
        this.c.b(i, i2);
    }

    public void a(boolean z) {
        if (z) {
            if (this.c.a() > 0) {
                this.c = new eK(10, 0.75f);
            }
            this.b = 0;
        }
    }
}
