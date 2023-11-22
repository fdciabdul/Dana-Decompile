package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.animation.view.GridMenuView;

/* loaded from: classes4.dex */
public final class ViewFourKingsBinding implements ViewBinding {
    public final GridMenuView BuiltInFictitiousFunctionClassFactory;
    public final GridMenuView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final GridMenuView PlaceComponentResult;
    public final GridMenuView getAuthRequestContext;
    public final ConstraintLayout moveToNextValue;

    private ViewFourKingsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, GridMenuView gridMenuView, GridMenuView gridMenuView2, GridMenuView gridMenuView3, GridMenuView gridMenuView4) {
        this.moveToNextValue = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = gridMenuView;
        this.getAuthRequestContext = gridMenuView2;
        this.PlaceComponentResult = gridMenuView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gridMenuView4;
    }

    public static ViewFourKingsBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.f3794x733cb84d;
        GridMenuView gridMenuView = (GridMenuView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3794x733cb84d);
        if (gridMenuView != null) {
            GridMenuView gridMenuView2 = (GridMenuView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3795grid_scan);
            if (gridMenuView2 != null) {
                GridMenuView gridMenuView3 = (GridMenuView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3796res_0x7f0a07c0_access_getselectopsequencenumber_p);
                if (gridMenuView3 != null) {
                    GridMenuView gridMenuView4 = (GridMenuView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3797res_0x7f0a07c1_r8_lambda_lnslh7bn2mzxi8tfxssb_vyvfg);
                    if (gridMenuView4 != null) {
                        return new ViewFourKingsBinding(constraintLayout, constraintLayout, gridMenuView, gridMenuView2, gridMenuView3, gridMenuView4);
                    }
                    i = R.id.f3797res_0x7f0a07c1_r8_lambda_lnslh7bn2mzxi8tfxssb_vyvfg;
                } else {
                    i = R.id.f3796res_0x7f0a07c0_access_getselectopsequencenumber_p;
                }
            } else {
                i = R.id.f3795grid_scan;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
