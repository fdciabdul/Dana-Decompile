package fsimpl;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class aL {

    /* renamed from: a  reason: collision with root package name */
    protected fg f7829a;
    private Map b;
    private aJ c;

    public aL() {
        this(new aJ());
    }

    public aL(aJ aJVar) {
        this.f7829a = new fg();
        this.b = new HashMap();
        this.c = aJVar;
    }

    public int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        int b = this.f7829a.b(obj);
        if (b != 0) {
            return b;
        }
        int a2 = this.c.a();
        this.f7829a.a(obj, a2);
        this.b.put(Integer.valueOf(a2), obj);
        return a2;
    }

    public Map a() {
        if (this.b.isEmpty()) {
            return null;
        }
        Map map = this.b;
        this.b = new HashMap();
        return map;
    }
}
