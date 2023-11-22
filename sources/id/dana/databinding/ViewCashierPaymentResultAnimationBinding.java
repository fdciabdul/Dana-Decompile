package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierPaymentResultAnimationBinding implements ViewBinding {
    public final LottieAnimationView BuiltInFictitiousFunctionClassFactory;
    public final LottieAnimationView MyBillsEntityDataFactory;
    private final ConstraintLayout getAuthRequestContext;

    private ViewCashierPaymentResultAnimationBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = lottieAnimationView;
        this.MyBillsEntityDataFactory = lottieAnimationView2;
    }

    public static ViewCashierPaymentResultAnimationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_cashier_payment_result_animation, (ViewGroup) null, false);
        int i = R.id.lavResult;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lavResult);
        if (lottieAnimationView != null) {
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3971lavResultSuccessDecor);
            if (lottieAnimationView2 != null) {
                return new ViewCashierPaymentResultAnimationBinding((ConstraintLayout) inflate, lottieAnimationView, lottieAnimationView2);
            }
            i = R.id.f3971lavResultSuccessDecor;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
