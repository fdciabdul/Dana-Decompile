package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.CurrencyEditText;

/* loaded from: classes4.dex */
public final class ViewSetMemberLimitInputAmountBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final CurrencyEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewSetMemberLimitInputAmountBinding(ConstraintLayout constraintLayout, CurrencyEditText currencyEditText, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currencyEditText;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = textView2;
        this.MyBillsEntityDataFactory = textView3;
    }

    public static ViewSetMemberLimitInputAmountBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_set_member_limit_input_amount, (ViewGroup) null, false);
        int i = R.id.etAmount;
        CurrencyEditText currencyEditText = (CurrencyEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etAmount);
        if (currencyEditText != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivCurrencyBorder);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_card_dana_goal_balance);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCurrency);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHelper);
                        if (textView3 != null) {
                            return new ViewSetMemberLimitInputAmountBinding((ConstraintLayout) inflate, currencyEditText, appCompatImageView, textView, textView2, textView3);
                        }
                        i = R.id.tvHelper;
                    } else {
                        i = R.id.tvCurrency;
                    }
                } else {
                    i = R.id.cl_card_dana_goal_balance;
                }
            } else {
                i = R.id.ivCurrencyBorder;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
