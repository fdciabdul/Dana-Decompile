package fsimpl;

import android.os.Build;

/* renamed from: fsimpl.ez  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0355ez {
    public static final Class g;
    public static final Class h;
    public static final Class c = eV.a("com.android.internal.policy.DecorView");
    public static final Class d = eV.a("android.widget.PopupWindow");
    public static final Class e = eV.a("android.widget.PopupWindow$PopupDecorView");

    /* renamed from: a  reason: collision with root package name */
    public static final Class f7980a = eV.a("android.graphics.drawable.AnimatedVectorDrawable$VectorDrawableAnimatorRT");
    public static final Class b = eV.a("android.graphics.drawable.AnimatedVectorDrawable$AnimatedVectorDrawableState");
    public static final Class f = eV.a("android.view.WindowManagerGlobal");
    public static final Class i = eV.a("com.android.internal.view.menu.MenuPopupHelper");
    public static final Class j = eV.a("com.android.internal.view.menu.ShowableListMenu");
    public static final Class k = eV.a("androidx.appcompat.widget.PopupMenu");
    public static final Class l = eV.a("androidx.appcompat.view.menu.MenuPopupHelper");
    public static final Class m = eV.a("androidx.appcompat.view.menu.ShowableListMenu");

    static {
        Class cls = null;
        if (Build.VERSION.SDK_INT >= 29) {
            g = eV.a("android.graphics.BlendModeColorFilter");
            cls = eV.a("android.graphics.BlendMode");
        } else {
            g = null;
        }
        h = cls;
    }
}
