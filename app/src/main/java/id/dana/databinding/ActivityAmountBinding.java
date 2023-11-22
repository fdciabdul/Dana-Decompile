package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.CurrencyTextView;
import id.dana.richview.calculator.CalculatorView;

/* loaded from: classes4.dex */
public final class ActivityAmountBinding implements ViewBinding {
    public final CurrencyTextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutToolbarBinding MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CalculatorView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final RelativeLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final RelativeLayout scheduleImpl;

    private ActivityAmountBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, CurrencyTextView currencyTextView, CalculatorView calculatorView, LayoutToolbarBinding layoutToolbarBinding, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = currencyTextView;
        this.PlaceComponentResult = calculatorView;
        this.MyBillsEntityDataFactory = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getErrorConfigVersion = relativeLayout;
        this.scheduleImpl = relativeLayout2;
        this.lookAheadTest = textView;
        this.moveToNextValue = textView2;
    }

    public static ActivityAmountBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_amount, (ViewGroup) null, false);
        int i = R.id.btn_action;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_action);
        if (danaButtonPrimaryView != null) {
            CurrencyTextView currencyTextView = (CurrencyTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.crv_amount_value);
            if (currencyTextView != null) {
                CalculatorView calculatorView = (CalculatorView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cv_sendmoney_pad);
                if (calculatorView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layout_value);
                        if (constraintLayout != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_sendmoney_container);
                            if (relativeLayout != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_shimmer_container);
                                if (relativeLayout2 != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_enter_amount);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_error_msg);
                                        if (textView2 != null) {
                                            return new ActivityAmountBinding((ConstraintLayout) inflate, danaButtonPrimaryView, currencyTextView, calculatorView, MyBillsEntityDataFactory, constraintLayout, relativeLayout, relativeLayout2, textView, textView2);
                                        }
                                        i = R.id.tv_error_msg;
                                    } else {
                                        i = R.id.tv_enter_amount;
                                    }
                                } else {
                                    i = R.id.rl_shimmer_container;
                                }
                            } else {
                                i = R.id.rl_sendmoney_container;
                            }
                        } else {
                            i = R.id.layout_value;
                        }
                    } else {
                        i = R.id.layoutToolbar;
                    }
                } else {
                    i = R.id.cv_sendmoney_pad;
                }
            } else {
                i = R.id.crv_amount_value;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
