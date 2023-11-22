package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.riskChallenges.databinding.ViewToolbarBinding;

/* loaded from: classes4.dex */
public final class ActivityCashierRisk3dsBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final ViewToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final FragmentContainerView MyBillsEntityDataFactory;

    private ActivityCashierRisk3dsBinding(LinearLayout linearLayout, FragmentContainerView fragmentContainerView, ViewToolbarBinding viewToolbarBinding) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = fragmentContainerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewToolbarBinding;
    }

    public static ActivityCashierRisk3dsBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_cashier_risk_3ds, (ViewGroup) null, false);
        int i = R.id.f3792res_0x7f0a0796_access_getargumentsdepth;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3792res_0x7f0a0796_access_getargumentsdepth);
        if (fragmentContainerView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                return new ActivityCashierRisk3dsBinding((LinearLayout) inflate, fragmentContainerView, ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
            }
            i = R.id.toolbar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
