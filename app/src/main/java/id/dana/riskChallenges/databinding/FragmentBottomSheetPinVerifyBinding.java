package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentBottomSheetPinVerifyBinding implements ViewBinding {
    public final CoordinatorLayout BuiltInFictitiousFunctionClassFactory;
    public final LayoutPinVerifyBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewToolbarBottomSheetBinding MyBillsEntityDataFactory;
    public final CoordinatorLayout PlaceComponentResult;

    private FragmentBottomSheetPinVerifyBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding, LayoutPinVerifyBinding layoutPinVerifyBinding) {
        this.BuiltInFictitiousFunctionClassFactory = coordinatorLayout;
        this.PlaceComponentResult = coordinatorLayout2;
        this.MyBillsEntityDataFactory = viewToolbarBottomSheetBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutPinVerifyBinding;
    }

    public static FragmentBottomSheetPinVerifyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_sheet_pin_verify, viewGroup, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        int i = R.id.E;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewToolbarBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewToolbarBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            int i2 = R.id.res_0x7f0a1bb0_summaryvoucherview_externalsyntheticlambda1;
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i2);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                return new FragmentBottomSheetPinVerifyBinding(coordinatorLayout, coordinatorLayout, KClassImpl$Data$declaredNonStaticMembers$2, LayoutPinVerifyBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
