package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.HomeWidgetLinearBase;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class NewViewFeedsEntryPointBinding implements ViewBinding {
    public final HomeWidgetLinearBase BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final LinearLayout GetContactSyncConfig;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final LogoProgressView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final AppCompatImageView lookAheadTest;
    public final HomeWidgetLinearBase moveToNextValue;
    public final LinearLayout scheduleImpl;

    private NewViewFeedsEntryPointBinding(HomeWidgetLinearBase homeWidgetLinearBase, LinearLayout linearLayout, DanaButtonPrimaryView danaButtonPrimaryView, HomeWidgetLinearBase homeWidgetLinearBase2, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView, LogoProgressView logoProgressView, LinearLayout linearLayout2, RecyclerView recyclerView, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.moveToNextValue = homeWidgetLinearBase;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = homeWidgetLinearBase2;
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.lookAheadTest = appCompatImageView;
        this.getErrorConfigVersion = logoProgressView;
        this.scheduleImpl = linearLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.GetContactSyncConfig = linearLayout3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView2;
        this.DatabaseTableConfigUtil = textView3;
        this.initRecordTimeStamp = textView4;
    }

    public static NewViewFeedsEntryPointBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.active_state_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.active_state_layout);
        if (linearLayout != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3534res_0x7f0a023f_apistatus_availablesince);
            if (danaButtonPrimaryView != null) {
                HomeWidgetLinearBase homeWidgetLinearBase = (HomeWidgetLinearBase) view;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.empty_state_layout);
                if (constraintLayout != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.inactive_state_animation);
                    if (lottieAnimationView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_empty_state_icon);
                        if (appCompatImageView != null) {
                            LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.loading_progress_view);
                            if (logoProgressView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.loading_state_layout);
                                if (linearLayout2 != null) {
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_real_time_feed);
                                    if (recyclerView != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.try_again_layout);
                                        if (linearLayout3 != null) {
                                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_description);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_no_more_feed);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_try_again_desc);
                                                        if (textView4 != null) {
                                                            return new NewViewFeedsEntryPointBinding(homeWidgetLinearBase, linearLayout, danaButtonPrimaryView, homeWidgetLinearBase, constraintLayout, lottieAnimationView, appCompatImageView, logoProgressView, linearLayout2, recyclerView, linearLayout3, textView, textView2, textView3, textView4);
                                                        }
                                                        i = R.id.tv_try_again_desc;
                                                    } else {
                                                        i = R.id.tv_title;
                                                    }
                                                } else {
                                                    i = R.id.tv_no_more_feed;
                                                }
                                            } else {
                                                i = R.id.tv_description;
                                            }
                                        } else {
                                            i = R.id.try_again_layout;
                                        }
                                    } else {
                                        i = R.id.rv_real_time_feed;
                                    }
                                } else {
                                    i = R.id.loading_state_layout;
                                }
                            } else {
                                i = R.id.loading_progress_view;
                            }
                        } else {
                            i = R.id.iv_empty_state_icon;
                        }
                    } else {
                        i = R.id.inactive_state_animation;
                    }
                } else {
                    i = R.id.empty_state_layout;
                }
            } else {
                i = R.id.f3534res_0x7f0a023f_apistatus_availablesince;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
