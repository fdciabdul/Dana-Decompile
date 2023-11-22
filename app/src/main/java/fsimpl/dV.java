package fsimpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class dV {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f7927a = eV.a(C0355ez.f, "mViews");
    private static final Object b;
    private static final Object c;
    private static final boolean d;
    private static boolean e = false;

    static {
        Object obj;
        boolean z = false;
        Method a2 = eV.a(C0355ez.f, "getInstance", new Class[0]);
        Field a3 = eV.a(C0355ez.f, "mLock");
        Object obj2 = null;
        if (a3 != null && a2 != null) {
            try {
                Object invoke = a2.invoke(null, new Object[0]);
                try {
                    obj2 = a3.get(invoke);
                } catch (Throwable unused) {
                }
                Object obj3 = obj2;
                obj2 = invoke;
                obj = obj3;
            } catch (Throwable unused2) {
            }
            c = obj2;
            b = obj;
            if (f7927a != null && obj2 != null && obj != null) {
                z = true;
            }
            d = z;
        }
        obj = null;
        c = obj2;
        b = obj;
        if (f7927a != null) {
            z = true;
        }
        d = z;
    }

    public static boolean a() {
        return d;
    }

    public static List b() {
        ArrayList arrayList;
        if (a()) {
            try {
                synchronized (b) {
                    arrayList = new ArrayList((List) f7927a.get(c));
                }
                return arrayList;
            } catch (Throwable th) {
                if (!e) {
                    e = true;
                    cS.a("Failed to list views", th);
                }
                return new ArrayList();
            }
        }
        return new ArrayList();
    }
}
