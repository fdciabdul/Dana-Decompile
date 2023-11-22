package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGlobalSendOnboardingBottomSheetBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final ViewContentOnboardingBinding PlaceComponentResult;
    private final CoordinatorLayout getAuthRequestContext;

    private ViewGlobalSendOnboardingBottomSheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, TextView textView, ViewContentOnboardingBinding viewContentOnboardingBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.MyBillsEntityDataFactory = textView;
        this.PlaceComponentResult = viewContentOnboardingBinding;
    }

    public static ViewGlobalSendOnboardingBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.view_global_send_onboarding_bottom_sheet, viewGroup, false);
        int i = R.id.res_0x7f0a0156_networkuserentitydata_externalsyntheticlambda0;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0730_otpregistrationpresenter_input_2;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.GifDrawableTransformation_res_0x7f0a15ac;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a1a79_quickbuybillsadapter_onquickbuyitemclicklistener_1))) != null) {
                    return new ViewGlobalSendOnboardingBottomSheetBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, textView, ViewContentOnboardingBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
