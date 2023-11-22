package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.component.edittextcomponent.DanaTextBoxView;

/* loaded from: classes4.dex */
public final class ViewSendmoneySummaryBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final LayoutSenderViewBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaTextBoxView MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final LayoutAmountViewBinding getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    private final MaterialCardView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewSendmoneySummaryBinding(MaterialCardView materialCardView, LayoutAmountViewBinding layoutAmountViewBinding, ConstraintLayout constraintLayout, LayoutSenderViewBinding layoutSenderViewBinding, DanaTextBoxView danaTextBoxView, LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, AppCompatTextView appCompatTextView, TextView textView2) {
        this.moveToNextValue = materialCardView;
        this.getAuthRequestContext = layoutAmountViewBinding;
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutSenderViewBinding;
        this.MyBillsEntityDataFactory = danaTextBoxView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.getErrorConfigVersion = textView;
        this.lookAheadTest = appCompatTextView;
        this.scheduleImpl = textView2;
    }

    public static ViewSendmoneySummaryBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_sendmoney_summary, (ViewGroup) null, false);
        int i = R.id.amountView;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.amountView);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutAmountViewBinding KClassImpl$Data$declaredNonStaticMembers$2 = LayoutAmountViewBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3608clLastTransferInfo);
            if (constraintLayout != null) {
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3623SplitReferralConfigEntityData_Factory_res_0x7f0a03ce);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    LayoutSenderViewBinding authRequestContext = LayoutSenderViewBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                    DanaTextBoxView danaTextBoxView = (DanaTextBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3749res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc);
                    if (danaTextBoxView != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llWarningSmartFriction);
                        if (linearLayout != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.separator);
                            if (appCompatImageView != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4279tvLastTransferInfo);
                                if (textView != null) {
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSmartFrictionInfo);
                                    if (appCompatTextView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvWarningSmartFriction);
                                        if (textView2 != null) {
                                            return new ViewSendmoneySummaryBinding((MaterialCardView) inflate, KClassImpl$Data$declaredNonStaticMembers$2, constraintLayout, authRequestContext, danaTextBoxView, linearLayout, appCompatImageView, textView, appCompatTextView, textView2);
                                        }
                                        i = R.id.tvWarningSmartFriction;
                                    } else {
                                        i = R.id.tvSmartFrictionInfo;
                                    }
                                } else {
                                    i = R.id.f4279tvLastTransferInfo;
                                }
                            } else {
                                i = R.id.separator;
                            }
                        } else {
                            i = R.id.llWarningSmartFriction;
                        }
                    } else {
                        i = R.id.f3749res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc;
                    }
                } else {
                    i = R.id.f3623SplitReferralConfigEntityData_Factory_res_0x7f0a03ce;
                }
            } else {
                i = R.id.f3608clLastTransferInfo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
