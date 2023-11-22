package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.richview.LogoProgressView;
import id.dana.richview.WebProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierRisk3dsBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;
    public final LogoProgressView getErrorConfigVersion;
    public final WebProgressView lookAheadTest;
    public final ViewCashierToolbarBinding moveToNextValue;
    private final ConstraintLayout scheduleImpl;

    private FragmentCashierRisk3dsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, FrameLayout frameLayout, LottieAnimationView lottieAnimationView, LogoProgressView logoProgressView, ViewCashierToolbarBinding viewCashierToolbarBinding, WebProgressView webProgressView) {
        this.scheduleImpl = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.PlaceComponentResult = textView2;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.getAuthRequestContext = lottieAnimationView;
        this.getErrorConfigVersion = logoProgressView;
        this.moveToNextValue = viewCashierToolbarBinding;
        this.lookAheadTest = webProgressView;
    }

    public static FragmentCashierRisk3dsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_risk3ds, (ViewGroup) null, false);
        int i = R.id.clLottieLoading;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clLottieLoading);
        if (constraintLayout != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etLoadingDesc);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etLoadingTitle);
                if (textView2 != null) {
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading3ds);
                    if (frameLayout != null) {
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lottieLoadingView);
                        if (lottieAnimationView != null) {
                            LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                            if (logoProgressView != null) {
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a1aef_abstractmapbasedmultimap_asmap);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                                    WebProgressView webProgressView = (WebProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.webView);
                                    if (webProgressView != null) {
                                        return new FragmentCashierRisk3dsBinding((ConstraintLayout) inflate, constraintLayout, textView, textView2, frameLayout, lottieAnimationView, logoProgressView, authRequestContext, webProgressView);
                                    }
                                    i = R.id.webView;
                                } else {
                                    i = R.id.res_0x7f0a1aef_abstractmapbasedmultimap_asmap;
                                }
                            } else {
                                i = R.id.f4033lpvLoading;
                            }
                        } else {
                            i = R.id.lottieLoadingView;
                        }
                    } else {
                        i = R.id.flDanaLoading3ds;
                    }
                } else {
                    i = R.id.etLoadingTitle;
                }
            } else {
                i = R.id.etLoadingDesc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
