package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityMyBillsBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutBillsQuickBuyBinding MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final FrameLayout getErrorConfigVersion;
    public final ViewMyBillsMonthlyBinding lookAheadTest;
    public final ViewMyBillsOnboardingBinding moveToNextValue;
    public final ViewMyBillsHeaderSectionErrorBinding scheduleImpl;

    private ActivityMyBillsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, LayoutBillsQuickBuyBinding layoutBillsQuickBuyBinding, LayoutToolbarBinding layoutToolbarBinding, ConstraintLayout constraintLayout3, RecyclerView recyclerView, FrameLayout frameLayout, ViewMyBillsHeaderSectionErrorBinding viewMyBillsHeaderSectionErrorBinding, ViewMyBillsMonthlyBinding viewMyBillsMonthlyBinding, ViewMyBillsOnboardingBinding viewMyBillsOnboardingBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = layoutBillsQuickBuyBinding;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.getErrorConfigVersion = frameLayout;
        this.scheduleImpl = viewMyBillsHeaderSectionErrorBinding;
        this.lookAheadTest = viewMyBillsMonthlyBinding;
        this.moveToNextValue = viewMyBillsOnboardingBinding;
    }

    public static ActivityMyBillsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_bills, (ViewGroup) null, false);
        int i = R.id.cl_my_bills_top_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_my_bills_top_container);
        if (constraintLayout != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBlueBackground);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layout_quick_buy);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    LayoutBillsQuickBuyBinding PlaceComponentResult = LayoutBillsQuickBuyBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ll_home_widget_service_list);
                        if (constraintLayout2 != null) {
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4041res_0x7f0a0e9d_default_currentthreadtimemillis);
                            if (recyclerView != null) {
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.skeleton_view);
                                if (frameLayout != null) {
                                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_header_my_bills_error);
                                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                        ViewMyBillsHeaderSectionErrorBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewMyBillsHeaderSectionErrorBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory4);
                                        View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_monthly);
                                        if (BuiltInFictitiousFunctionClassFactory5 != null) {
                                            ViewMyBillsMonthlyBinding KClassImpl$Data$declaredNonStaticMembers$22 = ViewMyBillsMonthlyBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory5);
                                            View BuiltInFictitiousFunctionClassFactory6 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_onboarding);
                                            if (BuiltInFictitiousFunctionClassFactory6 != null) {
                                                return new ActivityMyBillsBinding((ConstraintLayout) inflate, constraintLayout, BuiltInFictitiousFunctionClassFactory, PlaceComponentResult, MyBillsEntityDataFactory, constraintLayout2, recyclerView, frameLayout, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, ViewMyBillsOnboardingBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory6));
                                            }
                                            i = R.id.view_onboarding;
                                        } else {
                                            i = R.id.view_monthly;
                                        }
                                    } else {
                                        i = R.id.view_header_my_bills_error;
                                    }
                                } else {
                                    i = R.id.skeleton_view;
                                }
                            } else {
                                i = R.id.f4041res_0x7f0a0e9d_default_currentthreadtimemillis;
                            }
                        } else {
                            i = R.id.ll_home_widget_service_list;
                        }
                    } else {
                        i = R.id.layoutToolbar;
                    }
                } else {
                    i = R.id.layout_quick_buy;
                }
            } else {
                i = R.id.ivBlueBackground;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
