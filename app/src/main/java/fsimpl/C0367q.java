package fsimpl;

import android.view.SurfaceView;
import android.view.View;
import java.util.WeakHashMap;

/* renamed from: fsimpl.q  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0367q {

    /* renamed from: a  reason: collision with root package name */
    private final WeakHashMap f7999a = new WeakHashMap();
    private final WeakHashMap b = new WeakHashMap();
    private final WeakHashMap c = new WeakHashMap();
    private final WeakHashMap d = new WeakHashMap();
    private final C0230ah e;
    private final C0311dh f;
    private final bG g;
    private final U h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0367q(bG bGVar, C0230ah c0230ah, C0311dh c0311dh) {
        this.g = bGVar;
        this.e = c0230ah;
        this.f = c0311dh;
        this.h = U.a(bGVar);
    }

    private C0304da a(Object obj, C0248az c0248az, C0307dd c0307dd, boolean z) {
        if (c0307dd != null) {
            return c0307dd.a(this.f, obj, c0248az, z);
        }
        return null;
    }

    private C0370t a(Object obj, C0248az c0248az, C0370t c0370t, C0304da c0304da) {
        this.h.a(obj, c0248az, c0370t, c0304da);
        return a(obj, c0370t);
    }

    private C0370t a(Object obj, C0248az c0248az, C0370t c0370t, Object obj2) {
        this.h.a(obj, c0248az, c0370t, obj2);
        return a(obj, c0370t);
    }

    private C0370t a(Object obj, C0248az c0248az, C0370t c0370t, String str) {
        this.h.a(obj, c0248az, c0370t, str);
        return a(obj, c0370t);
    }

    private C0370t a(Object obj, C0370t c0370t) {
        this.b.put(obj, c0370t);
        return c0370t;
    }

    private void a() {
        if (this.f.b()) {
            this.f7999a.clear();
            this.b.clear();
            this.c.clear();
            this.d.clear();
        }
    }

    private boolean a(C0230ah c0230ah, Object obj, C0248az c0248az) {
        C0304da a2 = a(obj, c0248az, c0230ah.f(), c0230ah.d());
        boolean z = a2 != null;
        if (z) {
            this.h.a(obj, c0248az, Y.Omitted, a2);
        }
        return z;
    }

    private boolean b(C0230ah c0230ah, Object obj, C0248az c0248az) {
        C0304da a2 = a(obj, c0248az, c0230ah.j(), c0230ah.d());
        boolean z = a2 != null;
        if (z) {
            this.h.a(obj, c0248az, Y.Watched, a2);
        }
        return z;
    }

    private boolean c(C0230ah c0230ah, Object obj, C0248az c0248az) {
        C0304da a2 = a(obj, c0248az, c0230ah.k(), c0230ah.d());
        boolean z = a2 != null;
        if (z) {
            this.h.a(obj, c0248az, Y.Kept, a2);
        }
        return z;
    }

    private boolean d(C0230ah c0230ah, Object obj, C0248az c0248az) {
        if (c0248az.g == 4) {
            this.h.a(obj, c0248az, Y.Blocked, "Password");
            return true;
        }
        if (obj instanceof View) {
            if (obj instanceof SurfaceView) {
                this.h.a(obj, c0248az, Y.Blocked, "SurfaceView");
                return true;
            }
            View view = (View) obj;
            if (C0256bg.a(view)) {
                this.h.a(obj, c0248az, Y.Blocked, "Lottie");
                return true;
            } else if (C0256bg.b(view)) {
                this.h.a(obj, c0248az, Y.Blocked, "ReactNativeSvg");
                return true;
            }
        }
        C0304da a2 = a(obj, c0248az, c0230ah.g(), c0230ah.d());
        if (a2 != null) {
            this.h.a(obj, c0248az, Y.Blocked, a2);
            return true;
        }
        return false;
    }

    private EnumC0369s f(Object obj) {
        EnumC0369s enumC0369s = (EnumC0369s) this.f7999a.get(obj);
        if (enumC0369s != null) {
            return enumC0369s;
        }
        ff.b(obj);
        C0248az a2 = this.f.a(obj);
        EnumC0369s enumC0369s2 = EnumC0369s.Unblocked;
        if (a(this.e, obj, a2)) {
            enumC0369s2 = EnumC0369s.Omitted;
        } else if (d(this.e, obj, a2)) {
            enumC0369s2 = EnumC0369s.Blocked;
        } else {
            Object a3 = ff.a(obj);
            if (a3 != null) {
                enumC0369s2 = f(a3);
            }
        }
        this.f7999a.put(obj, enumC0369s2);
        return enumC0369s2;
    }

    private C0370t g(Object obj) {
        C0370t b;
        C0370t e;
        C0370t f;
        C0370t f2;
        C0307dd g;
        C0304da a2;
        C0370t f3;
        C0370t e2;
        C0370t f4;
        C0370t e3;
        C0370t e4;
        C0370t c0370t = (C0370t) this.b.get(obj);
        if (c0370t != null) {
            return c0370t;
        }
        ff.b(obj);
        C0248az a3 = this.f.a(obj);
        if (!C0256bg.a() && C0368r.a(obj)) {
            e4 = C0370t.e();
            return a(obj, a3, e4, "Compose with no enhanced Compose support");
        }
        boolean d = this.e.d();
        C0307dd h = this.e.h();
        if (h != null) {
            C0304da a4 = a(obj, a3, h, d);
            if (a4 != null) {
                e3 = C0370t.e();
                return a(obj, a3, e3, a4);
            }
            C0304da a5 = C0305db.a(this.f, obj, a3, h.c());
            if (a5 != null) {
                if (d) {
                    f4 = C0370t.f();
                    return a(obj, a3, f4, a5);
                }
                e2 = C0370t.e();
                return a(obj, a3, e2, a5);
            }
        }
        if (d && (g = this.e.g()) != null && (a2 = C0305db.a(this.f, obj, a3, g.c())) != null) {
            f3 = C0370t.f();
            return a(obj, a3, f3, a2);
        }
        C0307dd i = this.e.i();
        if (i != null) {
            C0304da a6 = a(obj, a3, i, d);
            if (a6 != null) {
                f2 = C0370t.f();
                return a(obj, a3, f2, a6);
            }
            C0304da a7 = C0305db.a(this.f, obj, a3, i.b());
            if (a7 != null) {
                if (d) {
                    f = C0370t.f();
                    return a(obj, a3, f, a7);
                }
                e = C0370t.e();
                return a(obj, a3, e, a7);
            }
        }
        b = C0370t.b(this.g);
        Object a8 = ff.a(obj);
        if (a8 != null) {
            b = g(a8);
        }
        return a(obj, a3, b, a8);
    }

    private boolean h(Object obj) {
        Boolean bool = (Boolean) this.c.get(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(b(this.e, obj, this.f.a(obj)));
        this.c.put(obj, valueOf);
        return valueOf.booleanValue();
    }

    private boolean i(Object obj) {
        Object a2;
        Boolean bool = (Boolean) this.d.get(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(c(this.e, obj, this.f.a(obj)));
        if (!valueOf.booleanValue() && (a2 = ff.a(obj)) != null) {
            valueOf = Boolean.valueOf(i(a2));
        }
        this.d.put(obj, valueOf);
        return valueOf.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Object obj) {
        a();
        return f(obj) == EnumC0369s.Omitted;
    }

    public boolean b(Object obj) {
        C0350eu.a("BlockView#isBlocked must be run on UI thread", new Object[0]);
        a();
        EnumC0369s f = f(obj);
        return f == EnumC0369s.Blocked || f == EnumC0369s.Omitted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Object obj) {
        a();
        return i(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Object obj) {
        a();
        return h(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0370t e(Object obj) {
        a();
        return g(obj);
    }
}
