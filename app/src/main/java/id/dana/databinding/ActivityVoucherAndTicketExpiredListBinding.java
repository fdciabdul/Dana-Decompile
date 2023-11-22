package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityVoucherAndTicketExpiredListBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final LayoutToolbarBinding moveToNextValue;

    private ActivityVoucherAndTicketExpiredListBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, LayoutToolbarBinding layoutToolbarBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = linearLayout;
        this.MyBillsEntityDataFactory = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
        this.moveToNextValue = layoutToolbarBinding;
    }

    public static ActivityVoucherAndTicketExpiredListBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_voucher_and_ticket_expired_list, (ViewGroup) null, false);
        int i = R.id.iv_illustration_empty_state;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_illustration_empty_state);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4011ll_empty_state);
            if (linearLayout != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_card_vouchers_and_tickets);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_desc_empty_state);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4519xde312118);
                        if (appCompatTextView2 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new ActivityVoucherAndTicketExpiredListBinding((ConstraintLayout) inflate, appCompatImageView, linearLayout, recyclerView, appCompatTextView, appCompatTextView2, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                            }
                            i = R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e;
                        } else {
                            i = R.id.f4519xde312118;
                        }
                    } else {
                        i = R.id.tv_desc_empty_state;
                    }
                } else {
                    i = R.id.rv_card_vouchers_and_tickets;
                }
            } else {
                i = R.id.f4011ll_empty_state;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
