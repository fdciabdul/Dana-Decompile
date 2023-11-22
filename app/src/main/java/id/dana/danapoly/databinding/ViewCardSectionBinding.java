package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewCardSectionBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final Space NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LottieAnimationView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final Space lookAheadTest;
    public final MotionLayout moveToNextValue;
    private final MotionLayout scheduleImpl;

    private ViewCardSectionBinding(MotionLayout motionLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, AppCompatImageView appCompatImageView, LottieAnimationView lottieAnimationView, MotionLayout motionLayout2, Space space, Space space2) {
        this.scheduleImpl = motionLayout;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout3;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = lottieAnimationView;
        this.moveToNextValue = motionLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = space;
        this.lookAheadTest = space2;
    }

    public static ViewCardSectionBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_card_section, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0287_bottomsheetcardbindingview_watchercardnumberview_1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (linearLayout != null) {
            i = R.id.cardView2;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (linearLayout2 != null) {
                i = R.id.res_0x7f0a0289_verifypinstatemanager_executeriskchallenge_2_2;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (linearLayout3 != null) {
                    i = R.id.r;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.res_0x7f0a0cae_access_setshowcaseshowing_p;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (lottieAnimationView != null) {
                            MotionLayout motionLayout = (MotionLayout) inflate;
                            i = R.id.res_0x7f0a1249_arraytable_3;
                            Space space = (Space) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (space != null) {
                                i = R.id.res_0x7f0a124a_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_1;
                                Space space2 = (Space) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (space2 != null) {
                                    return new ViewCardSectionBinding(motionLayout, linearLayout, linearLayout2, linearLayout3, appCompatImageView, lottieAnimationView, motionLayout, space, space2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
