package fsimpl;

import android.util.SparseArray;
import android.view.View;
import com.fullstory.instrumentation.Bootstrap;
import java.lang.reflect.Field;

/* renamed from: fsimpl.bg  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0256bg {
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static boolean j;
    private static boolean k;
    private static boolean l;
    private static boolean m;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7888a = new Object();
    private static Object n = null;

    /* renamed from: o  reason: collision with root package name */
    private static SparseArray f7889o = null;
    private static final Class b = eV.a("com.airbnb.lottie.LottieAnimationView");
    private static final Class c = eV.a("com.horcrux.svg.SvgView");
    private static final Class d = eV.a("com.facebook.react.views.modal.ReactModalHostView");
    private static final Class e = eV.a("com.facebook.react.uimanager.NativeViewHierarchyManager");

    public static View a(int i2) {
        Object obj;
        SparseArray sparseArray;
        View view;
        if (i2 != -1) {
            synchronized (f7888a) {
                obj = n;
                sparseArray = f7889o;
            }
            if (obj == null || sparseArray == null) {
                return null;
            }
            synchronized (obj) {
                view = (View) sparseArray.get(i2);
            }
            return view;
        }
        return null;
    }

    public static void a(Object obj) {
        synchronized (f7888a) {
            Object obj2 = n;
            if (obj2 == null || obj2 != obj) {
                SparseArray sparseArray = null;
                if (e != null && e.isInstance(obj)) {
                    try {
                        Field declaredField = e.getDeclaredField("mTagsToViews");
                        declaredField.setAccessible(true);
                        sparseArray = (SparseArray) declaredField.get(obj);
                    } catch (Throwable unused) {
                    }
                }
                n = obj;
                f7889o = sparseArray;
            }
        }
    }

    public static void a(boolean z) {
        f = z;
    }

    public static boolean a() {
        return g;
    }

    public static boolean a(View view) {
        return a(b, view);
    }

    private static boolean a(Class cls, View view) {
        if (cls == null) {
            return false;
        }
        return cls.isInstance(view);
    }

    public static void b(boolean z) {
        g = z;
    }

    public static boolean b() {
        return h;
    }

    public static boolean b(View view) {
        return a(c, view);
    }

    public static void c(boolean z) {
        h = z;
    }

    public static boolean c() {
        return i;
    }

    public static boolean c(View view) {
        return a(d, view);
    }

    public static void d(boolean z) {
        i = z;
    }

    public static boolean d() {
        C0230ah currentSessionKnobs = Bootstrap.getCurrentSessionKnobs();
        return currentSessionKnobs != null && currentSessionKnobs.q();
    }

    public static boolean d(View view) {
        Object obj;
        SparseArray sparseArray;
        boolean z;
        int id2 = view.getId();
        if (id2 != -1) {
            synchronized (f7888a) {
                obj = n;
                sparseArray = f7889o;
            }
            if (obj != null && sparseArray != null) {
                synchronized (obj) {
                    z = view == ((View) sparseArray.get(id2));
                }
                return z;
            }
        }
        return false;
    }

    public static void e(boolean z) {
        j = z;
    }

    public static boolean e() {
        return j;
    }

    public static void f(boolean z) {
        k = z;
    }

    public static boolean f() {
        return k;
    }

    public static void g(boolean z) {
        l = z;
    }

    public static boolean g() {
        return l;
    }

    public static void h(boolean z) {
        m = z;
    }

    public static boolean h() {
        return m;
    }
}
