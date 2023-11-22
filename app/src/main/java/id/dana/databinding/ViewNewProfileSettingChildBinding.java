package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewNewProfileSettingChildBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final View GetContactSyncConfig;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final LottieAnimationView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ViewNewProfileSettingChildBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView3;
        this.scheduleImpl = appCompatImageView4;
        this.moveToNextValue = lottieAnimationView;
        this.getErrorConfigVersion = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
        this.GetContactSyncConfig = view;
    }

    public static ViewNewProfileSettingChildBinding MyBillsEntityDataFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.fl_red_dot;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_red_dot);
        if (frameLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_profile_new_badge);
                if (appCompatImageView2 != null) {
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_profile_user_service);
                    if (appCompatImageView3 != null) {
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_view_profile_user_service_red_dot);
                        if (appCompatImageView4 != null) {
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lv_profile_user_service);
                            if (lottieAnimationView != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_detail_profile_user_service);
                                if (appCompatTextView != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_detail_profile_user_service_non_dynamic);
                                    if (appCompatTextView2 != null) {
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_profile_user_service);
                                        if (appCompatTextView3 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                return new ViewNewProfileSettingChildBinding(constraintLayout, constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, lottieAnimationView, appCompatTextView, appCompatTextView2, appCompatTextView3, BuiltInFictitiousFunctionClassFactory);
                                            }
                                            i = R.id.view_divider;
                                        } else {
                                            i = R.id.tv_profile_user_service;
                                        }
                                    } else {
                                        i = R.id.tv_detail_profile_user_service_non_dynamic;
                                    }
                                } else {
                                    i = R.id.tv_detail_profile_user_service;
                                }
                            } else {
                                i = R.id.lv_profile_user_service;
                            }
                        } else {
                            i = R.id.iv_view_profile_user_service_red_dot;
                        }
                    } else {
                        i = R.id.iv_profile_user_service;
                    }
                } else {
                    i = R.id.iv_profile_new_badge;
                }
            } else {
                i = R.id.CustomPopMenuExtension;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
