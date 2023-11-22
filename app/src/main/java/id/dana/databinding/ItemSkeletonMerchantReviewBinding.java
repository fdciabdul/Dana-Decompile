package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemSkeletonMerchantReviewBinding implements ViewBinding {
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final View PlaceComponentResult;

    private ItemSkeletonMerchantReviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = view;
    }

    public static ItemSkeletonMerchantReviewBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vShimmer);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new ItemSkeletonMerchantReviewBinding(constraintLayout, constraintLayout, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.vShimmer)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
