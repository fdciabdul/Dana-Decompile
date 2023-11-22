package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.CashierInputAmountView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.NumpadView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentInputAmountBinding implements ViewBinding {
    public final ViewCashierHeaderBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final NumpadView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final CashierInputAmountView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final ViewCashierToolbarBinding getErrorConfigVersion;
    public final LogoProgressView lookAheadTest;
    public final ScrollView moveToNextValue;
    public final View scheduleImpl;

    private FragmentInputAmountBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, CashierInputAmountView cashierInputAmountView, ViewCashierHeaderBinding viewCashierHeaderBinding, LinearLayout linearLayout, LogoProgressView logoProgressView, NumpadView numpadView, ScrollView scrollView, ViewCashierToolbarBinding viewCashierToolbarBinding, View view, View view2) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = frameLayout;
        this.PlaceComponentResult = cashierInputAmountView;
        this.BuiltInFictitiousFunctionClassFactory = viewCashierHeaderBinding;
        this.getAuthRequestContext = linearLayout;
        this.lookAheadTest = logoProgressView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = numpadView;
        this.moveToNextValue = scrollView;
        this.getErrorConfigVersion = viewCashierToolbarBinding;
        this.scheduleImpl = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view2;
    }

    public static FragmentInputAmountBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_input_amount, (ViewGroup) null, false);
        int i = R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1);
        if (danaButtonPrimaryView != null) {
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
            if (frameLayout != null) {
                CashierInputAmountView cashierInputAmountView = (CashierInputAmountView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.inputAmountView);
                if (cashierInputAmountView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cancelEventDelivery);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        ViewCashierHeaderBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCashierHeaderBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llConfirmBtn);
                        if (linearLayout != null) {
                            LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                            if (logoProgressView != null) {
                                NumpadView numpadView = (NumpadView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.numpadView);
                                if (numpadView != null) {
                                    ScrollView scrollView = (ScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.scrollView);
                                    if (scrollView != null) {
                                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
                                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                            ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                                            View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vShimmerBtn);
                                            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vShimmerInputAmount);
                                                if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                    return new FragmentInputAmountBinding((ConstraintLayout) inflate, danaButtonPrimaryView, frameLayout, cashierInputAmountView, KClassImpl$Data$declaredNonStaticMembers$2, linearLayout, logoProgressView, numpadView, scrollView, authRequestContext, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4);
                                                }
                                                i = R.id.vShimmerInputAmount;
                                            } else {
                                                i = R.id.vShimmerBtn;
                                            }
                                        } else {
                                            i = R.id.toolbar;
                                        }
                                    } else {
                                        i = R.id.scrollView;
                                    }
                                } else {
                                    i = R.id.numpadView;
                                }
                            } else {
                                i = R.id.f4033lpvLoading;
                            }
                        } else {
                            i = R.id.llConfirmBtn;
                        }
                    } else {
                        i = R.id.cancelEventDelivery;
                    }
                } else {
                    i = R.id.inputAmountView;
                }
            } else {
                i = R.id.flDanaLoading;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
