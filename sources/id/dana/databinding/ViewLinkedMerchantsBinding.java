package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewLinkedMerchantsBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView PlaceComponentResult;
    public final ViewArrowSeeMoreBinding getAuthRequestContext;

    private ViewLinkedMerchantsBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ViewArrowSeeMoreBinding viewArrowSeeMoreBinding) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = viewArrowSeeMoreBinding;
    }

    public static ViewLinkedMerchantsBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.rvMerchant;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvMerchant);
        if (recyclerView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vSeeMore);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                return new ViewLinkedMerchantsBinding((ConstraintLayout) view, recyclerView, ViewArrowSeeMoreBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
            }
            i = R.id.vSeeMore;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
