package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ItemReviewListSpaceBinding implements ViewBinding {
    private final View BuiltInFictitiousFunctionClassFactory;

    private ItemReviewListSpaceBinding(View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public static ItemReviewListSpaceBinding PlaceComponentResult(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemReviewListSpaceBinding(view);
    }
}
