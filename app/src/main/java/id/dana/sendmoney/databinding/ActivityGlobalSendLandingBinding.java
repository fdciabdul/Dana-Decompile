package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;

/* loaded from: classes5.dex */
public final class ActivityGlobalSendLandingBinding implements ViewBinding {
    public final ViewGlobalSendLandingFirstTimerBinding BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewToolbarBinding MyBillsEntityDataFactory;
    public final ViewGlobalSendLandingFilledStateBinding PlaceComponentResult;
    public final EmptyStateView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ActivityGlobalSendLandingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EmptyStateView emptyStateView, ViewGlobalSendLandingFilledStateBinding viewGlobalSendLandingFilledStateBinding, ViewGlobalSendLandingFirstTimerBinding viewGlobalSendLandingFirstTimerBinding, ViewToolbarBinding viewToolbarBinding) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = emptyStateView;
        this.PlaceComponentResult = viewGlobalSendLandingFilledStateBinding;
        this.BuiltInFictitiousFunctionClassFactory = viewGlobalSendLandingFirstTimerBinding;
        this.MyBillsEntityDataFactory = viewToolbarBinding;
    }

    public static ActivityGlobalSendLandingBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_global_send_landing, (ViewGroup) null, false);
        int i = R.id.clGlobalSendLanding;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.errorStateView;
            EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (emptyStateView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.setRightEdgeEffectColor_res_0x7f0a1ab8))) != null) {
                ViewGlobalSendLandingFilledStateBinding PlaceComponentResult = ViewGlobalSendLandingFilledStateBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                i = R.id.viewLandingFirstTimer;
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    ViewGlobalSendLandingFirstTimerBinding BuiltInFictitiousFunctionClassFactory3 = ViewGlobalSendLandingFirstTimerBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
                    i = R.id.res_0x7f0a1aef_abstractmapbasedmultimap_asmap;
                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                        return new ActivityGlobalSendLandingBinding((ConstraintLayout) inflate, constraintLayout, emptyStateView, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory3, ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
