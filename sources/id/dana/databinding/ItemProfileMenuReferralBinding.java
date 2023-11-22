package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemProfileMenuReferralBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;
    public final AppCompatTextView moveToNextValue;

    private ItemProfileMenuReferralBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LottieAnimationView lottieAnimationView, View view, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.lookAheadTest = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.getAuthRequestContext = lottieAnimationView;
        this.MyBillsEntityDataFactory = view;
        this.moveToNextValue = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
    }

    public static ItemProfileMenuReferralBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.cl_referral_banner;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_referral_banner);
        if (constraintLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_profile_referral);
                if (appCompatImageView2 != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lv_referral_banner_gift);
                    if (lottieAnimationView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.menu_divider);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_profile_referral);
                            if (appCompatTextView != null) {
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_referral_banner_subtitle);
                                if (appCompatTextView2 != null) {
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_referral_banner_title);
                                    if (appCompatTextView3 != null) {
                                        return new ItemProfileMenuReferralBinding((ConstraintLayout) view, constraintLayout, appCompatImageView, appCompatImageView2, lottieAnimationView, BuiltInFictitiousFunctionClassFactory, appCompatTextView, appCompatTextView2, appCompatTextView3);
                                    }
                                    i = R.id.tv_referral_banner_title;
                                } else {
                                    i = R.id.tv_referral_banner_subtitle;
                                }
                            } else {
                                i = R.id.tv_profile_referral;
                            }
                        } else {
                            i = R.id.menu_divider;
                        }
                    } else {
                        i = R.id.lv_referral_banner_gift;
                    }
                } else {
                    i = R.id.iv_profile_referral;
                }
            } else {
                i = R.id.CustomPopMenuExtension;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
