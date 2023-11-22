package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityKybCpmLoadingBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;

    private ActivityKybCpmLoadingBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, LayoutToolbarBinding layoutToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = lottieAnimationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ActivityKybCpmLoadingBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_kyb_cpm_loading, (ViewGroup) null, false);
        int i = R.id.lottieKybCpmLoading;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lottieKybCpmLoading);
        if (lottieAnimationView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a135c_basesocialfeedcontract_presenter);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvBodyKybCpmLoading);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleKybCpmLoading);
                    if (appCompatTextView2 != null) {
                        return new ActivityKybCpmLoadingBinding((ConstraintLayout) inflate, lottieAnimationView, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tvTitleKybCpmLoading;
                } else {
                    i = R.id.tvBodyKybCpmLoading;
                }
            } else {
                i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
