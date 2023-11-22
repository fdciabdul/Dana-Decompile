package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGroupSendInputAmountBinding implements ViewBinding {
    public final CurrencyEditText BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;

    private ViewGroupSendInputAmountBinding(ConstraintLayout constraintLayout, CurrencyEditText currencyEditText, TextView textView, TextView textView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = currencyEditText;
        this.MyBillsEntityDataFactory = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewGroupSendInputAmountBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d055c_summaryvoucherview_externalsyntheticlambda1, (ViewGroup) null, false);
        int i = R.id.etAmount;
        CurrencyEditText currencyEditText = (CurrencyEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (currencyEditText != null) {
            i = R.id.ContentDeliveryCacheEntityDataFactory;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.ServiceStarter;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    return new ViewGroupSendInputAmountBinding((ConstraintLayout) inflate, currencyEditText, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
