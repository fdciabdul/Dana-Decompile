package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewMerchantSkeletonBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View getAuthRequestContext;

    private ViewMerchantSkeletonBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.getAuthRequestContext = view;
    }

    public static ViewMerchantSkeletonBinding getAuthRequestContext(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewSkeleton);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new ViewMerchantSkeletonBinding(constraintLayout, constraintLayout, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.viewSkeleton)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
