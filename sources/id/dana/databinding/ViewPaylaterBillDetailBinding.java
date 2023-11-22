package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.PaylaterAgreementView;

/* loaded from: classes4.dex */
public final class ViewPaylaterBillDetailBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final PaylaterAgreementView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ViewPaylaterBillDetailBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, PaylaterAgreementView paylaterAgreementView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.scheduleImpl = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = paylaterAgreementView;
        this.getAuthRequestContext = recyclerView;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView3;
    }

    public static ViewPaylaterBillDetailBinding getAuthRequestContext(View view) {
        int i = R.id.ll_paylater_bill_detail;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_paylater_bill_detail);
        if (linearLayout != null) {
            PaylaterAgreementView paylaterAgreementView = (PaylaterAgreementView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4062res_0x7f0a0f94_userpocketassetsdao_impl_1);
            if (paylaterAgreementView != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_paylater_bill_detail);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_paylater_bill_detail_subtitle);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_paylater_bill_detail_title);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_paylater_promo);
                            if (appCompatTextView3 != null) {
                                return new ViewPaylaterBillDetailBinding((ConstraintLayout) view, linearLayout, paylaterAgreementView, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                            }
                            i = R.id.tv_paylater_promo;
                        } else {
                            i = R.id.tv_paylater_bill_detail_title;
                        }
                    } else {
                        i = R.id.tv_paylater_bill_detail_subtitle;
                    }
                } else {
                    i = R.id.rv_paylater_bill_detail;
                }
            } else {
                i = R.id.f4062res_0x7f0a0f94_userpocketassetsdao_impl_1;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
