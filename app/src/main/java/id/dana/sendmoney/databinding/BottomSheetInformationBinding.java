package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class BottomSheetInformationBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final CoordinatorLayout getErrorConfigVersion;

    private BottomSheetInformationBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = coordinatorLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
    }

    public static BottomSheetInformationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0107_networkuserentitydata_externalsyntheticlambda2, viewGroup, false);
        int i = R.id.getAuthRequestContext;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0729_access_throwillegalargumenttype;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.FlowableConcatMapEagerPublisher;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.TrustRiskLogin$Params;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatTextView != null) {
                        i = R.id.setValue;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatTextView2 != null) {
                            return new BottomSheetInformationBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
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
