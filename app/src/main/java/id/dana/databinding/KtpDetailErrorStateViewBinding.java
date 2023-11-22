package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class KtpDetailErrorStateViewBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;

    private KtpDetailErrorStateViewBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
        this.getErrorConfigVersion = appCompatTextView2;
    }

    public static KtpDetailErrorStateViewBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.f3534res_0x7f0a023f_apistatus_availablesince;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3534res_0x7f0a023f_apistatus_availablesince);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_ktp_detail_failed_state_content);
            if (constraintLayout2 != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_ktp_detail_failed_state);
                if (appCompatImageView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_ktp_detail_failed_state_desc);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_ktp_detail_failed_state_title);
                        if (appCompatTextView2 != null) {
                            return new KtpDetailErrorStateViewBinding(constraintLayout, danaButtonPrimaryView, constraintLayout, constraintLayout2, appCompatImageView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tv_ktp_detail_failed_state_title;
                    } else {
                        i = R.id.tv_ktp_detail_failed_state_desc;
                    }
                } else {
                    i = R.id.iv_ktp_detail_failed_state;
                }
            } else {
                i = R.id.cl_ktp_detail_failed_state_content;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
