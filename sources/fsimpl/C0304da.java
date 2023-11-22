package fsimpl;

/* renamed from: fsimpl.da  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0304da {

    /* renamed from: a  reason: collision with root package name */
    public C0306dc f7930a;

    C0304da(C0306dc c0306dc) {
        this.f7930a = c0306dc;
    }

    public static C0304da a(bY bYVar) {
        C0306dc b = b(bYVar);
        if (b == null) {
            return null;
        }
        return new C0304da(b);
    }

    private static C0306dc b(bY bYVar) {
        if (bYVar == null) {
            return null;
        }
        C0306dc c0306dc = new C0306dc(b(bYVar.a()), bYVar.b());
        String c = bYVar.c();
        if (c != null) {
            c = c.toLowerCase();
        }
        c0306dc.c = c;
        c0306dc.d = bYVar.d();
        int e = bYVar.e();
        for (int i = 0; i < e; i++) {
            c0306dc.e.put(bYVar.a(i), Boolean.TRUE);
        }
        int f = bYVar.f();
        for (int i2 = 0; i2 < f; i2++) {
            bV b = bYVar.b(i2);
            String a2 = b.a();
            String c2 = b.c();
            byte b2 = b.b();
            String lowerCase = a2.toLowerCase();
            c0306dc.g.put(lowerCase, c2);
            c0306dc.f.put(lowerCase, Byte.valueOf(b2));
        }
        return c0306dc;
    }

    public String a() {
        String str = null;
        for (C0306dc c0306dc = this.f7930a; c0306dc != null; c0306dc = c0306dc.f7931a) {
            if (str == null) {
                str = c0306dc.a();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c0306dc.a());
                sb.append(str);
                str = sb.toString();
            }
        }
        return str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Selector rules=");
        sb.append(this.f7930a);
        sb.append("]");
        return sb.toString();
    }
}
