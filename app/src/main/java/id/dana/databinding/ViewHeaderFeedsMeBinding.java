package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewHeaderFeedsMeBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView DatabaseTableConfigUtil;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ConstraintLayout PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final LinearLayout scheduleImpl;

    private ViewHeaderFeedsMeBinding(LinearLayout linearLayout, CircleImageView circleImageView, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = linearLayout;
        this.getAuthRequestContext = circleImageView;
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getErrorConfigVersion = appCompatImageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView3;
        this.moveToNextValue = appCompatImageView4;
        this.scheduleImpl = linearLayout2;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView2;
        this.DatabaseTableConfigUtil = appCompatTextView;
    }

    public static ViewHeaderFeedsMeBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.f3577civ_profile_avatar;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3577civ_profile_avatar);
        if (circleImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_profile_name_section);
            if (constraintLayout != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_feed_notification);
                if (frameLayout != null) {
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_setting_button_section);
                    if (frameLayout2 != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_feed_notification);
                        if (appCompatImageView != null) {
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_kyc_verified);
                            if (appCompatImageView2 != null) {
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_setting);
                                if (appCompatImageView3 != null) {
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_share_privacy);
                                    if (appCompatImageView4 != null) {
                                        LinearLayout linearLayout = (LinearLayout) view;
                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_profile_name);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_share_privacy);
                                            if (textView2 != null) {
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getSecondaryProgressTintMode);
                                                if (appCompatTextView != null) {
                                                    return new ViewHeaderFeedsMeBinding(linearLayout, circleImageView, constraintLayout, frameLayout, frameLayout2, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, linearLayout, textView, textView2, appCompatTextView);
                                                }
                                                i = R.id.getSecondaryProgressTintMode;
                                            } else {
                                                i = R.id.tv_share_privacy;
                                            }
                                        } else {
                                            i = R.id.tv_profile_name;
                                        }
                                    } else {
                                        i = R.id.iv_share_privacy;
                                    }
                                } else {
                                    i = R.id.iv_setting;
                                }
                            } else {
                                i = R.id.iv_kyc_verified;
                            }
                        } else {
                            i = R.id.iv_feed_notification;
                        }
                    } else {
                        i = R.id.fl_setting_button_section;
                    }
                } else {
                    i = R.id.fl_feed_notification;
                }
            } else {
                i = R.id.cl_profile_name_section;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
