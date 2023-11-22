package fsimpl;

import android.view.View;
import android.widget.PopupMenu;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class bM {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7878a = eV.a(PopupMenu.class, "mPopup");
    static final Field b = eV.a(28, 29, C0355ez.i, "mPopup");
    static final Method c = eV.a(28, 29, C0355ez.j, "getListView", new Class[0]);

    public static Object a(PopupMenu popupMenu) {
        return eV.a(f7878a, popupMenu);
    }

    public static Object a(Object obj) {
        return eV.a(b, obj);
    }

    public static View b(Object obj) {
        return (View) eV.a(c, obj, new Object[0]);
    }
}
