package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.PaylaterInstallmentSimulationView;

/* loaded from: classes4.dex */
public final class ViewPaylaterInstallmentBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final RecyclerView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    public final PaylaterInstallmentSimulationView moveToNextValue;

    private ViewPaylaterInstallmentBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, PaylaterInstallmentSimulationView paylaterInstallmentSimulationView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
        this.moveToNextValue = paylaterInstallmentSimulationView;
    }

    public static ViewPaylaterInstallmentBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.ic_info;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_info);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_billing_info);
            if (linearLayout != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_installment_options);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_billing_info);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_installment_title);
                        if (appCompatTextView2 != null) {
                            PaylaterInstallmentSimulationView paylaterInstallmentSimulationView = (PaylaterInstallmentSimulationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_installment_simulation);
                            if (paylaterInstallmentSimulationView != null) {
                                return new ViewPaylaterInstallmentBinding((ConstraintLayout) view, appCompatImageView, linearLayout, recyclerView, appCompatTextView, appCompatTextView2, paylaterInstallmentSimulationView);
                            }
                            i = R.id.view_installment_simulation;
                        } else {
                            i = R.id.tv_installment_title;
                        }
                    } else {
                        i = R.id.tv_billing_info;
                    }
                } else {
                    i = R.id.rv_installment_options;
                }
            } else {
                i = R.id.ll_billing_info;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
