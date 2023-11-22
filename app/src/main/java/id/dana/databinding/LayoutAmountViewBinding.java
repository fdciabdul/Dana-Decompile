package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.sendmoney_v2.landing.view.RecipientRibbonView;

/* loaded from: classes4.dex */
public final class LayoutAmountViewBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CurrencyEditText MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final RecipientRibbonView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;
    public final TextView scheduleImpl;

    private LayoutAmountViewBinding(ConstraintLayout constraintLayout, CurrencyEditText currencyEditText, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, FrameLayout frameLayout, AppCompatTextView appCompatTextView2, RecipientRibbonView recipientRibbonView, TextView textView) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = currencyEditText;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.PlaceComponentResult = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
        this.getErrorConfigVersion = recipientRibbonView;
        this.scheduleImpl = textView;
    }

    public static LayoutAmountViewBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.f3562res_0x7f0a02e2_basesocialfeedcontract_presenter;
        CurrencyEditText currencyEditText = (CurrencyEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3562res_0x7f0a02e2_basesocialfeedcontract_presenter);
        if (currencyEditText != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.evError);
            if (appCompatTextView != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.flAmount);
                if (frameLayout != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivAmountTitle);
                    if (appCompatTextView2 != null) {
                        RecipientRibbonView recipientRibbonView = (RecipientRibbonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ribbonView);
                        if (recipientRibbonView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvLimitBadge);
                            if (textView != null) {
                                return new LayoutAmountViewBinding(constraintLayout, currencyEditText, constraintLayout, appCompatTextView, frameLayout, appCompatTextView2, recipientRibbonView, textView);
                            }
                            i = R.id.tvLimitBadge;
                        } else {
                            i = R.id.ribbonView;
                        }
                    } else {
                        i = R.id.ivAmountTitle;
                    }
                } else {
                    i = R.id.flAmount;
                }
            } else {
                i = R.id.evError;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
