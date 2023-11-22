package fsimpl;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class bL {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f7877a = eV.a(C0355ez.k, "mPopup");
    private static final Field b = eV.a(C0355ez.l, "mPopup");
    private static final Method c = eV.a(C0355ez.m, "getListView", new Class[0]);

    public static Object a(Object obj) {
        return eV.a(f7877a, obj);
    }

    public static Object b(Object obj) {
        return eV.a(b, obj);
    }

    public static View c(Object obj) {
        return (View) eV.a(c, obj, new Object[0]);
    }
}
