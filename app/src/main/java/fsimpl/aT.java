package fsimpl;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class aT {
    private int b;
    private int c;

    /* renamed from: a  reason: collision with root package name */
    protected eK f7834a = new eK(10000, 0.75f);
    private List d = new ArrayList(50);
    private aJ e = new aJ();

    public int a(String str) {
        if (str == null) {
            return 0;
        }
        int a2 = this.f7834a.a(str.hashCode());
        if (a2 != 0) {
            return a2;
        }
        this.b = this.e.a();
        this.f7834a.b(str.hashCode(), this.b);
        this.d.add(str);
        return this.b;
    }

    public List a() {
        this.c = this.b;
        if (this.d.isEmpty()) {
            return null;
        }
        List list = this.d;
        this.d = new ArrayList(50);
        return list;
    }

    public int b() {
        return this.c;
    }
}
