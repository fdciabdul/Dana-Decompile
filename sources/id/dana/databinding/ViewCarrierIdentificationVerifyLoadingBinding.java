package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCarrierIdentificationVerifyLoadingBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final LottieAnimationView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final CarrierIdentificationToolbarBinding getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewCarrierIdentificationVerifyLoadingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView, CarrierIdentificationToolbarBinding carrierIdentificationToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieAnimationView;
        this.getAuthRequestContext = carrierIdentificationToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ViewCarrierIdentificationVerifyLoadingBinding MyBillsEntityDataFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.lv_avatar_user;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lv_avatar_user);
        if (lottieAnimationView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.toolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                CarrierIdentificationToolbarBinding MyBillsEntityDataFactory = CarrierIdentificationToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc_verify);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_verify);
                    if (appCompatTextView2 != null) {
                        return new ViewCarrierIdentificationVerifyLoadingBinding(constraintLayout, constraintLayout, lottieAnimationView, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tv_title_verify;
                } else {
                    i = R.id.tv_desc_verify;
                }
            } else {
                i = R.id.toolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
