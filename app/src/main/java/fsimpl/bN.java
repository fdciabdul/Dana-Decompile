package fsimpl;

import android.view.View;
import android.widget.PopupMenu;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class bN {

    /* renamed from: a  reason: collision with root package name */
    private final aA f7879a;

    public bN(aA aAVar) {
        this.f7879a = aAVar;
    }

    private View a(PopupMenu popupMenu, String str, boolean z) {
        Object a2 = bM.a(popupMenu);
        if (a2 == null) {
            a(str, z);
            return null;
        }
        Object a3 = bM.a(a2);
        if (a3 == null) {
            b(str, z);
            return null;
        }
        View b = bM.b(a3);
        if (b == null) {
            a(str, z);
            return null;
        }
        return b;
    }

    private View a(Object obj, String str, boolean z) {
        if (obj == null) {
            a((Class) null, str, z);
            return null;
        }
        Class<?> cls = obj.getClass();
        if (PopupMenu.class.isAssignableFrom(cls)) {
            return a((PopupMenu) obj, str, z);
        }
        if (C0355ez.k == null || !C0355ez.k.isAssignableFrom(cls)) {
            a((Class) cls, str, z);
            return null;
        }
        return b(obj, str, z);
    }

    private static void a(Class cls, String str, boolean z) {
        Log.e(String.format("Expected a PopupMenu but received %s when attempting to %s class %s. Supported classes are android.widget.PopupMenu and androidx.appcompat.widget.PopupMenu.", cls == null ? "null" : cls.getName(), z ? ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD : "remove", str));
    }

    private static void a(String str, boolean z) {
        Log.e(String.format("Unknown issue encountered while trying to access PopupMenu view. Class %s will not be %s PopupMenu.", str, z ? "added to" : "removed from"));
    }

    private View b(Object obj, String str, boolean z) {
        Object a2 = bL.a(obj);
        if (a2 == null) {
            a(str, z);
            return null;
        }
        Object b = bL.b(a2);
        if (b == null) {
            b(str, z);
            return null;
        }
        View c = bL.c(b);
        if (c == null) {
            a(str, z);
            return null;
        }
        return c;
    }

    private static void b(String str, boolean z) {
        Log.e(String.format("PopupMenu is not currently showing. Class %s will not be %s.", str, z ? "added" : "removed"));
    }

    public void a(Object obj, String str) {
        View a2 = a(obj, str, true);
        if (a2 != null) {
            this.f7879a.c(a2, str);
        }
    }

    public void b(Object obj, String str) {
        View a2 = a(obj, str, false);
        if (a2 != null) {
            this.f7879a.d(a2, str);
        }
    }
}
