package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.LogoProgressView;
import id.dana.social.onboarding.FeedOnboardingView;

/* loaded from: classes4.dex */
public final class FragmentFriendFeedBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final LogoProgressView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final FeedOnboardingView getErrorConfigVersion;
    public final ViewSocialFriendsFeedBinding lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private FragmentFriendFeedBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, LinearLayout linearLayout, LogoProgressView logoProgressView, FeedOnboardingView feedOnboardingView, ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding) {
        this.scheduleImpl = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = constraintLayout3;
        this.MyBillsEntityDataFactory = imageView;
        this.getAuthRequestContext = linearLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = logoProgressView;
        this.getErrorConfigVersion = feedOnboardingView;
        this.lookAheadTest = viewSocialFriendsFeedBinding;
    }

    public static FragmentFriendFeedBinding getAuthRequestContext(View view) {
        int i = R.id.f3534res_0x7f0a023f_apistatus_availablesince;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3534res_0x7f0a023f_apistatus_availablesince);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_loading);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3694cl_try_again);
                if (constraintLayout2 != null) {
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_try_again);
                    if (imageView != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_content);
                        if (linearLayout != null) {
                            LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.loading_progress_view);
                            if (logoProgressView != null) {
                                FeedOnboardingView feedOnboardingView = (FeedOnboardingView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_feed_onboarding);
                                if (feedOnboardingView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_social_feed);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        return new FragmentFriendFeedBinding((ConstraintLayout) view, danaButtonPrimaryView, constraintLayout, constraintLayout2, imageView, linearLayout, logoProgressView, feedOnboardingView, ViewSocialFriendsFeedBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
                                    }
                                    i = R.id.view_social_feed;
                                } else {
                                    i = R.id.view_feed_onboarding;
                                }
                            } else {
                                i = R.id.loading_progress_view;
                            }
                        } else {
                            i = R.id.ll_content;
                        }
                    } else {
                        i = R.id.iv_try_again;
                    }
                } else {
                    i = R.id.f3694cl_try_again;
                }
            } else {
                i = R.id.cl_loading;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
