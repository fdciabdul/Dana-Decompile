package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewRetryAndTimerBinding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;
    public final TextView getErrorConfigVersion;

    private ViewRetryAndTimerBinding(LinearLayout linearLayout, Button button, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = linearLayout2;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.getAuthRequestContext = lottieAnimationView2;
        this.getErrorConfigVersion = textView;
    }

    public static ViewRetryAndTimerBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_retry_and_timer, (ViewGroup) null, false);
        int i = R.id.PlaceComponentResult_res_0x7f0a021e;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (button != null) {
            i = R.id.scheduleImpl;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout != null) {
                i = R.id.ll_resend_btn;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (linearLayout != null) {
                    i = R.id.loading_animation;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (lottieAnimationView != null) {
                        i = R.id.res_0x7f0a1062_verifypinstatemanager_executeriskchallenge_2_2;
                        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (lottieAnimationView2 != null) {
                            i = R.id.res_0x7f0a190e_summaryvoucherview_externalsyntheticlambda0;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null) {
                                return new ViewRetryAndTimerBinding((LinearLayout) inflate, button, constraintLayout, linearLayout, lottieAnimationView, lottieAnimationView2, textView);
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
