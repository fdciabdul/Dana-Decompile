package androidx.view;

import android.view.View;
import android.view.ViewParent;
import androidx.view.runtime.R;

/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static void getAuthRequestContext(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R.id.BuiltInFictitiousFunctionClassFactory, lifecycleOwner);
    }

    public static LifecycleOwner KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(R.id.BuiltInFictitiousFunctionClassFactory);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        ViewParent parent = view.getParent();
        while (lifecycleOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            lifecycleOwner = (LifecycleOwner) view2.getTag(R.id.BuiltInFictitiousFunctionClassFactory);
            parent = view2.getParent();
        }
        return lifecycleOwner;
    }
}
