package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentPasskeyVerificationBinding implements ViewBinding {
    public final ViewBaseToolbarBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final LottieAnimationView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private FragmentPasskeyVerificationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = lottieAnimationView;
        this.BuiltInFictitiousFunctionClassFactory = viewBaseToolbarBinding;
        this.getAuthRequestContext = textView;
    }

    public static FragmentPasskeyVerificationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_passkey_verification, (ViewGroup) null, false);
        int i = R.id.clContentPasskey;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.getSupportButtonTintMode_res_0x7f0a0e11;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (lottieAnimationView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.getValueOfTouchPositionAbsolute_res_0x7f0a135e))) != null) {
                ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                i = R.id.tv_title_passkey_authentication;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    return new FragmentPasskeyVerificationBinding((ConstraintLayout) inflate, constraintLayout, lottieAnimationView, MyBillsEntityDataFactory, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
