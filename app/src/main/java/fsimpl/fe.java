package fsimpl;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes4.dex */
public class fe {

    /* renamed from: a  reason: collision with root package name */
    static final Method f7985a = eV.a(28, 30, ViewGroup.class, "buildOrderedChildList", new Class[0]);
    static final Method b = eV.a(28, 30, ViewGroup.class, "isChildrenDrawingOrderEnabled", new Class[0]);
    static final Method c = eV.a(28, 30, ViewGroup.class, "getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
    private static boolean d = true;
    private static boolean e = true;

    public static int a(ViewGroup viewGroup, int i, int i2) {
        if (C0350eu.f7977a) {
            C0350eu.a("The getChildDrawingOrder method should always be called from the UI thread", new Object[0]);
        }
        Method method = c;
        if (method == null || !e) {
            return i2;
        }
        try {
            return ((Integer) method.invoke(viewGroup, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
        } catch (Throwable unused) {
            e = false;
            return i2;
        }
    }

    public static List a(ViewGroup viewGroup) {
        if (f7985a != null && d) {
            if (C0350eu.f7977a) {
                C0350eu.a("The buildOrderedChildList method call should always be on the UI thread", new Object[0]);
            }
            try {
                Object invoke = f7985a.invoke(viewGroup, new Object[0]);
                if (invoke instanceof List) {
                    List list = (List) invoke;
                    if (!list.isEmpty() && (list.get(0) instanceof View)) {
                        return list;
                    }
                    list.clear();
                }
                return null;
            } catch (Throwable unused) {
                d = false;
                return null;
            }
        }
        return null;
    }

    public static boolean b(ViewGroup viewGroup) {
        if (C0350eu.f7977a) {
            C0350eu.a("The isChildrenDrawingOrderEnabled method should always be called from the UI thread", new Object[0]);
        }
        Method method = b;
        if (method == null || !e) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(viewGroup, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            e = false;
            return false;
        }
    }
}
