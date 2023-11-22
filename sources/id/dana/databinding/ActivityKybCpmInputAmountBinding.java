package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivityKybCpmInputAmountBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final ViewBottomsheetCustomKeyboardX2xBinding PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final ViewKybCpmInputAmountBinding lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private ActivityKybCpmInputAmountBinding(ConstraintLayout constraintLayout, ViewBottomsheetCustomKeyboardX2xBinding viewBottomsheetCustomKeyboardX2xBinding, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, View view, LayoutToolbarBinding layoutToolbarBinding, ViewKybCpmInputAmountBinding viewKybCpmInputAmountBinding, View view2) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = viewBottomsheetCustomKeyboardX2xBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.lookAheadTest = viewKybCpmInputAmountBinding;
        this.getErrorConfigVersion = view2;
    }

    public static ActivityKybCpmInputAmountBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_kyb_cpm_input_amount, (ViewGroup) null, false);
        int i = R.id.bsCustomKeyboard;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.bsCustomKeyboard);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewBottomsheetCustomKeyboardX2xBinding authRequestContext = ViewBottomsheetCustomKeyboardX2xBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnScanQr);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0345_bottomsheetcardbindingview_watchercardnumberview_1);
                if (constraintLayout != null) {
                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.separator);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a135c_basesocialfeedcontract_presenter);
                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3);
                            View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewKybCpmInputAmount);
                            if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                ViewKybCpmInputAmountBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewKybCpmInputAmountBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory4);
                                View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewTopBackground);
                                if (BuiltInFictitiousFunctionClassFactory5 != null) {
                                    return new ActivityKybCpmInputAmountBinding((ConstraintLayout) inflate, authRequestContext, danaButtonPrimaryView, constraintLayout, BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory5);
                                }
                                i = R.id.viewTopBackground;
                            } else {
                                i = R.id.viewKybCpmInputAmount;
                            }
                        } else {
                            i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter;
                        }
                    } else {
                        i = R.id.separator;
                    }
                } else {
                    i = R.id.res_0x7f0a0345_bottomsheetcardbindingview_watchercardnumberview_1;
                }
            } else {
                i = R.id.btnScanQr;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
