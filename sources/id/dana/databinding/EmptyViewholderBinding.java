package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class EmptyViewholderBinding implements ViewBinding {
    private final FrameLayout BuiltInFictitiousFunctionClassFactory;

    private EmptyViewholderBinding(FrameLayout frameLayout) {
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
    }

    public static EmptyViewholderBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new EmptyViewholderBinding((FrameLayout) view);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
