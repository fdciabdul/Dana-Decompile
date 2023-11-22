package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierRiskBindingPayBinding implements ViewBinding {
    public final Group BuiltInFictitiousFunctionClassFactory;
    public final ViewCashierToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final ViewCashierHeaderBinding getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ConstraintLayout lookAheadTest;
    public final AppCompatTextView scheduleImpl;

    private ViewCashierRiskBindingPayBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, Group group, ViewCashierHeaderBinding viewCashierHeaderBinding, ViewCashierToolbarBinding viewCashierToolbarBinding, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout3) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = group;
        this.getAuthRequestContext = viewCashierHeaderBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewCashierToolbarBinding;
        this.scheduleImpl = appCompatTextView2;
        this.lookAheadTest = constraintLayout3;
    }

    public static ViewCashierRiskBindingPayBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.appCompatTextView;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.appCompatTextView);
        if (appCompatTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clTotalAmount);
            if (constraintLayout != null) {
                Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.groupRiskTotalAmountView);
                if (group != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cancelEventDelivery);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        ViewCashierHeaderBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCashierHeaderBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.toolbar);
                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                            ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAmount);
                            if (appCompatTextView2 != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                return new ViewCashierRiskBindingPayBinding(constraintLayout2, appCompatTextView, constraintLayout, group, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, appCompatTextView2, constraintLayout2);
                            }
                            i = R.id.tvAmount;
                        } else {
                            i = R.id.toolbar;
                        }
                    } else {
                        i = R.id.cancelEventDelivery;
                    }
                } else {
                    i = R.id.groupRiskTotalAmountView;
                }
            } else {
                i = R.id.clTotalAmount;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
