package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewPaylaterInstallmentSimulationBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView moveToNextValue;

    private ViewPaylaterInstallmentSimulationBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout2;
        this.getAuthRequestContext = recyclerView;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.getErrorConfigVersion = appCompatTextView4;
    }

    public static ViewPaylaterInstallmentSimulationBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.ll_installment_simulation;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_installment_simulation);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_installment_simulation_title);
            if (linearLayout2 != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_installment_simulation);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_bill_amount_title);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_due_date_title);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_installment_simulation_title);
                            if (appCompatTextView3 != null) {
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_period_title);
                                if (appCompatTextView4 != null) {
                                    return new ViewPaylaterInstallmentSimulationBinding((ConstraintLayout) view, linearLayout, linearLayout2, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                }
                                i = R.id.tv_period_title;
                            } else {
                                i = R.id.tv_installment_simulation_title;
                            }
                        } else {
                            i = R.id.tv_due_date_title;
                        }
                    } else {
                        i = R.id.tv_bill_amount_title;
                    }
                } else {
                    i = R.id.rv_installment_simulation;
                }
            } else {
                i = R.id.ll_installment_simulation_title;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
