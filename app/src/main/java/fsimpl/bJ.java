package fsimpl;

import android.view.View;
import android.view.ViewGroup;
import com.fullstory.util.Log;

/* loaded from: classes8.dex */
class bJ {

    /* renamed from: a  reason: collision with root package name */
    static final Class f7876a;

    static {
        if (C0355ez.e == null) {
            Log.e("Unable to find PopupDecorView class instance");
        }
        Class a2 = eV.a("android.widget.Editor$SelectionHandleView");
        f7876a = a2;
        if (a2 == null) {
            Log.e("Unable to find SelectionHandleView class instance");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        if ((view instanceof ViewGroup) && bK.a(view.getClass(), C0355ez.e, "android.widget.PopupWindow$PopupDecorView")) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (bK.a(viewGroup.getChildAt(i).getClass(), f7876a, "android.widget.Editor$SelectionHandleView")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
