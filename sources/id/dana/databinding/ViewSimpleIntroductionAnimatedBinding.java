package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSimpleIntroductionAnimatedBinding implements ViewBinding {
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewSimpleIntroductionAnimatedBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewSimpleIntroductionAnimatedBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_simple_introduction_animated, (ViewGroup) null, false);
        int i = R.id.lottie_intro_animation;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lottie_intro_animation);
        if (lottieAnimationView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_intro_description);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_intro_title);
                if (textView2 != null) {
                    return new ViewSimpleIntroductionAnimatedBinding((ConstraintLayout) inflate, lottieAnimationView, textView, textView2);
                }
                i = R.id.tv_intro_title;
            } else {
                i = R.id.tv_intro_description;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
