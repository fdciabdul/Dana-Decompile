package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivityTransferAccountStatusBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView scheduleImpl;

    private ActivityTransferAccountStatusBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.scheduleImpl = appCompatTextView;
        this.getErrorConfigVersion = appCompatTextView2;
    }

    public static ActivityTransferAccountStatusBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_transfer_account_status, (ViewGroup) null, false);
        int i = R.id.action_bar;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.action_bar);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_call_cs);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_icon);
                if (appCompatImageView != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lottie_icon);
                    if (lottieAnimationView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_subtitle);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                            if (appCompatTextView2 != null) {
                                return new ActivityTransferAccountStatusBinding(constraintLayout, MyBillsEntityDataFactory, danaButtonPrimaryView, constraintLayout, appCompatImageView, lottieAnimationView, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.tv_subtitle;
                        }
                    } else {
                        i = R.id.lottie_icon;
                    }
                } else {
                    i = R.id.iv_icon;
                }
            } else {
                i = R.id.btn_call_cs;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
