package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ActivityTransferAccountSuccessBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;

    private ActivityTransferAccountSuccessBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
    }

    public static ActivityTransferAccountSuccessBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_transfer_account_success, (ViewGroup) null, false);
        int i = R.id.action_bar;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.action_bar);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2);
            if (danaButtonSecondaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_icon);
                if (appCompatImageView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_subtitle);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                        if (appCompatTextView2 != null) {
                            return new ActivityTransferAccountSuccessBinding(constraintLayout, MyBillsEntityDataFactory, danaButtonSecondaryView, constraintLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tv_title;
                    } else {
                        i = R.id.tv_subtitle;
                    }
                } else {
                    i = R.id.iv_icon;
                }
            } else {
                i = R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
