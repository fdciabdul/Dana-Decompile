package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;

/* loaded from: classes5.dex */
public final class ActivityGroupSendLandingBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final EmptyStateView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ViewStickyBottomSheetLandingBinding lookAheadTest;
    public final ViewToolbarBinding moveToNextValue;

    private ActivityGroupSendLandingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EmptyStateView emptyStateView, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, ViewStickyBottomSheetLandingBinding viewStickyBottomSheetLandingBinding, ViewToolbarBinding viewToolbarBinding) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = emptyStateView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.lookAheadTest = viewStickyBottomSheetLandingBinding;
        this.moveToNextValue = viewToolbarBinding;
    }

    public static ActivityGroupSendLandingBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_group_send_landing, (ViewGroup) null, false);
        int i = R.id.getOnBoardingScenario_res_0x7f0a0356;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.errorStateView;
            EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (emptyStateView != null) {
                i = R.id.ivEmptyStateLanding;
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (imageView != null) {
                    i = R.id.createJavaMethod_res_0x7f0a0d39;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (linearLayout != null) {
                        i = R.id.rvGroupSendLanding;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (recyclerView != null) {
                            i = R.id.res_0x7f0a148e_mappagecontract_presenter;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.viewStickyLanding))) != null) {
                                ViewStickyBottomSheetLandingBinding authRequestContext = ViewStickyBottomSheetLandingBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                                i = R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e;
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    return new ActivityGroupSendLandingBinding((ConstraintLayout) inflate, constraintLayout, emptyStateView, imageView, linearLayout, recyclerView, textView, authRequestContext, ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2));
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
        return this.getErrorConfigVersion;
    }
}
