package fsimpl;

import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import com.fullstory.instrumentation.FSOuterThis;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: fsimpl.w  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0373w {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f8004a;
    private static final Field b;
    private static final Class c;

    static {
        Class a2 = eV.a("com.google.android.material.tabs.TabLayout");
        f8004a = a2;
        b = eV.a(a2, "selectedListeners");
        c = eV.a("com.google.android.material.tabs.TabLayout$TabView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        if (view.hasOnClickListeners() || b(view)) {
            return true;
        }
        ViewParent parent = view.getParent();
        return a(parent) || a(parent, view);
    }

    private static boolean a(ViewParent viewParent) {
        return (viewParent instanceof AdapterView) && ((AdapterView) viewParent).getOnItemClickListener() != null;
    }

    private static boolean a(ViewParent viewParent, View view) {
        Class cls;
        if (f8004a == null || (cls = c) == null || b == null || !(view instanceof FSOuterThis) || !cls.isInstance(view)) {
            return false;
        }
        Object _fsGetOuterThis = ((FSOuterThis) view)._fsGetOuterThis();
        if (f8004a.isInstance(_fsGetOuterThis)) {
            try {
                Object obj = b.get(_fsGetOuterThis);
                if ((obj instanceof List ? (List) obj : null) == null) {
                    return false;
                }
                return !r3.isEmpty();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(View view) {
        return (view instanceof CompoundButton) && AbstractC0358h.b((CompoundButton) view) != null;
    }
}
