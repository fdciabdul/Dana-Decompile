package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierGeneralProcessingBinding implements ViewBinding {
    public final LottieAnimationView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LogoProgressView PlaceComponentResult;
    public final ViewCashierToolbarBinding getAuthRequestContext;

    private FragmentCashierGeneralProcessingBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, LottieAnimationView lottieAnimationView, LogoProgressView logoProgressView, ViewCashierToolbarBinding viewCashierToolbarBinding, AppCompatTextView appCompatTextView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.MyBillsEntityDataFactory = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = lottieAnimationView;
        this.PlaceComponentResult = logoProgressView;
        this.getAuthRequestContext = viewCashierToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
    }

    public static FragmentCashierGeneralProcessingBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_general_processing, (ViewGroup) null, false);
        int i = R.id.flDanaLoading;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
        if (frameLayout != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivProcessing);
            if (lottieAnimationView != null) {
                LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                if (logoProgressView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvProcessing);
                        if (appCompatTextView != null) {
                            return new FragmentCashierGeneralProcessingBinding((ConstraintLayout) inflate, frameLayout, lottieAnimationView, logoProgressView, authRequestContext, appCompatTextView);
                        }
                        i = R.id.tvProcessing;
                    } else {
                        i = R.id.toolbar;
                    }
                } else {
                    i = R.id.f4033lpvLoading;
                }
            } else {
                i = R.id.ivProcessing;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
