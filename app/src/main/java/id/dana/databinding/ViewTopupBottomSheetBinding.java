package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;

/* loaded from: classes4.dex */
public final class ViewTopupBottomSheetBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final NumpadView MyBillsEntityDataFactory;
    public final CurrencyEditText PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView scheduleImpl;

    private ViewTopupBottomSheetBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, CurrencyEditText currencyEditText, AppCompatImageView appCompatImageView, NumpadView numpadView, TextView textView, TextView textView2) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = currencyEditText;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = numpadView;
        this.getErrorConfigVersion = textView;
        this.scheduleImpl = textView2;
    }

    public static ViewTopupBottomSheetBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.btnTopUpContinue;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnTopUpContinue);
        if (danaButtonPrimaryView != null) {
            CurrencyEditText currencyEditText = (CurrencyEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.detTopup);
            if (currencyEditText != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.secondaryHash_res_0x7f0a08d3);
                if (appCompatImageView != null) {
                    NumpadView numpadView = (NumpadView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.nvFamilyAccountTopUp);
                    if (numpadView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDescError);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                            if (textView2 != null) {
                                return new ViewTopupBottomSheetBinding((ConstraintLayout) view, danaButtonPrimaryView, currencyEditText, appCompatImageView, numpadView, textView, textView2);
                            }
                            i = R.id.tvTitle;
                        } else {
                            i = R.id.tvDescError;
                        }
                    } else {
                        i = R.id.nvFamilyAccountTopUp;
                    }
                } else {
                    i = R.id.secondaryHash_res_0x7f0a08d3;
                }
            } else {
                i = R.id.detTopup;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
