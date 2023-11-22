package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemInstallmentSimulationBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ItemInstallmentSimulationBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
        this.PlaceComponentResult = appCompatTextView3;
    }

    public static ItemInstallmentSimulationBinding PlaceComponentResult(View view) {
        int i = R.id.ll_installment_simulation_content;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_installment_simulation_content);
        if (linearLayout != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_bill_amount);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_due_date);
                if (appCompatTextView2 != null) {
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4462tv_period);
                    if (appCompatTextView3 != null) {
                        return new ItemInstallmentSimulationBinding((ConstraintLayout) view, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                    }
                    i = R.id.f4462tv_period;
                } else {
                    i = R.id.tv_due_date;
                }
            } else {
                i = R.id.tv_bill_amount;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
