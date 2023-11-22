package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentBottomSheetOtpBinding implements ViewBinding {
    public final LayoutOtpVerifyBinding BuiltInFictitiousFunctionClassFactory;
    public final ViewToolbarBottomSheetBinding MyBillsEntityDataFactory;
    public final CoordinatorLayout PlaceComponentResult;
    public final CoordinatorLayout getAuthRequestContext;

    private FragmentBottomSheetOtpBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding, LayoutOtpVerifyBinding layoutOtpVerifyBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.PlaceComponentResult = coordinatorLayout2;
        this.MyBillsEntityDataFactory = viewToolbarBottomSheetBinding;
        this.BuiltInFictitiousFunctionClassFactory = layoutOtpVerifyBinding;
    }

    public static FragmentBottomSheetOtpBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_sheet_otp, viewGroup, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        int i = R.id.E;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewToolbarBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewToolbarBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            int i2 = R.id.res_0x7f0a1baf_summaryvoucherview_externalsyntheticlambda2;
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i2);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                return new FragmentBottomSheetOtpBinding(coordinatorLayout, coordinatorLayout, KClassImpl$Data$declaredNonStaticMembers$2, LayoutOtpVerifyBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
