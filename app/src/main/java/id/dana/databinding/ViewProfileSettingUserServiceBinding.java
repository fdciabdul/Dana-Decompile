package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewProfileSettingUserServiceBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    private final ConstraintLayout scheduleImpl;

    private ViewProfileSettingUserServiceBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ConstraintLayout constraintLayout3) {
        this.scheduleImpl = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.PlaceComponentResult = appCompatImageView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.getErrorConfigVersion = constraintLayout3;
    }

    public static ViewProfileSettingUserServiceBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.CustomPopMenuExtension;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_profile_user_service);
            if (appCompatImageView2 != null) {
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_view_profile_user_service_red_dot);
                if (appCompatImageView3 != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_detail_profile_user_service);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_detail_profile_user_service_non_dynamic);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_profile_user_service);
                            if (appCompatTextView3 != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vg_profile_setting_user_service_container);
                                if (constraintLayout2 != null) {
                                    return new ViewProfileSettingUserServiceBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatTextView, appCompatTextView2, appCompatTextView3, constraintLayout2);
                                }
                                i = R.id.vg_profile_setting_user_service_container;
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
                    i = R.id.iv_view_profile_user_service_red_dot;
                }
            } else {
                i = R.id.iv_profile_user_service;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
