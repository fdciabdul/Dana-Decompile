package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.richview.HomeWidgetBase;
import id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView;

/* loaded from: classes4.dex */
public final class ViewServiceCardV2Binding implements ViewBinding {
    public final LottieAnimationView BuiltInFictitiousFunctionClassFactory;
    public final ServiceShimmerRecycleView KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final HomeWidgetBase getAuthRequestContext;
    private final FrameLayout scheduleImpl;

    private ViewServiceCardV2Binding(FrameLayout frameLayout, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ServiceShimmerRecycleView serviceShimmerRecycleView, HomeWidgetBase homeWidgetBase, View view) {
        this.scheduleImpl = frameLayout;
        this.PlaceComponentResult = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = lottieAnimationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = serviceShimmerRecycleView;
        this.getAuthRequestContext = homeWidgetBase;
        this.MyBillsEntityDataFactory = view;
    }

    public static ViewServiceCardV2Binding MyBillsEntityDataFactory(View view) {
        int i = R.id.cl_banner_service;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_banner_service);
        if (constraintLayout != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lav_banner_service);
            if (lottieAnimationView != null) {
                ServiceShimmerRecycleView serviceShimmerRecycleView = (ServiceShimmerRecycleView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4041res_0x7f0a0e9d_default_currentthreadtimemillis);
                if (serviceShimmerRecycleView != null) {
                    HomeWidgetBase homeWidgetBase = (HomeWidgetBase) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.shadow_container_service_card);
                    if (homeWidgetBase != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_header_background);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ViewServiceCardV2Binding((FrameLayout) view, constraintLayout, lottieAnimationView, serviceShimmerRecycleView, homeWidgetBase, BuiltInFictitiousFunctionClassFactory);
                        }
                        i = R.id.v_header_background;
                    } else {
                        i = R.id.shadow_container_service_card;
                    }
                } else {
                    i = R.id.f4041res_0x7f0a0e9d_default_currentthreadtimemillis;
                }
            } else {
                i = R.id.lav_banner_service;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
