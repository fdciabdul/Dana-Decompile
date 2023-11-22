package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class FragmentOnboardingPermissionLocationBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final Button KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final ImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final LinearLayoutCompat PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final FrameLayout getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final LottieAnimationView lookAheadTest;
    public final ImageView moveToNextValue;
    public final TextView scheduleImpl;

    private FragmentOnboardingPermissionLocationBinding(FrameLayout frameLayout, Button button, DanaButtonPrimaryView danaButtonPrimaryView, LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.getErrorConfigVersion = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = button;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.PlaceComponentResult = linearLayoutCompat;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.MyBillsEntityDataFactory = imageView;
        this.moveToNextValue = imageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageView3;
        this.lookAheadTest = lottieAnimationView;
        this.scheduleImpl = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView2;
        this.DatabaseTableConfigUtil = textView3;
        this.initRecordTimeStamp = textView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView5;
    }

    public static FragmentOnboardingPermissionLocationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_location, viewGroup, false);
        int i = R.id.f3507btn_allow;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3507btn_allow);
        if (button != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3518btn_later);
            if (danaButtonPrimaryView != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback);
                if (linearLayoutCompat != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_merchant);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_padlock);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_promo);
                            if (imageView3 != null) {
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lottie_intro_animation);
                                if (lottieAnimationView != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_first);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_second);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_subtitle);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_third);
                                                if (textView4 != null) {
                                                    TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                                                    if (textView5 != null) {
                                                        return new FragmentOnboardingPermissionLocationBinding(frameLayout, button, danaButtonPrimaryView, linearLayoutCompat, frameLayout, imageView, imageView2, imageView3, lottieAnimationView, textView, textView2, textView3, textView4, textView5);
                                                    }
                                                    i = R.id.tv_title;
                                                } else {
                                                    i = R.id.tv_third;
                                                }
                                            } else {
                                                i = R.id.tv_subtitle;
                                            }
                                        } else {
                                            i = R.id.tv_second;
                                        }
                                    } else {
                                        i = R.id.tv_first;
                                    }
                                } else {
                                    i = R.id.lottie_intro_animation;
                                }
                            } else {
                                i = R.id.iv_promo;
                            }
                        } else {
                            i = R.id.iv_padlock;
                        }
                    } else {
                        i = R.id.iv_merchant;
                    }
                } else {
                    i = R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback;
                }
            } else {
                i = R.id.f3518btn_later;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
