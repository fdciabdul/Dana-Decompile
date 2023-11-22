package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.CurrencyEditText;

/* loaded from: classes4.dex */
public final class ViewDailyLimitCashierBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final CurrencyEditText getAuthRequestContext;

    private ViewDailyLimitCashierBinding(LinearLayout linearLayout, CurrencyEditText currencyEditText, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getAuthRequestContext = currencyEditText;
        this.MyBillsEntityDataFactory = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewDailyLimitCashierBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_daily_limit_cashier, (ViewGroup) null, false);
        int i = R.id.etAmountDaily;
        CurrencyEditText currencyEditText = (CurrencyEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etAmountDaily);
        if (currencyEditText != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorHelper);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                if (textView2 != null) {
                    return new ViewDailyLimitCashierBinding((LinearLayout) inflate, currencyEditText, textView, textView2);
                }
                i = R.id.tvTitle;
            } else {
                i = R.id.tvErrorHelper;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
