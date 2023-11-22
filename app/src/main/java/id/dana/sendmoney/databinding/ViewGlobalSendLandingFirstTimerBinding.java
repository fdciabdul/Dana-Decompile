package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGlobalSendLandingFirstTimerBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final ViewContentOnboardingBinding scheduleImpl;

    private ViewGlobalSendLandingFirstTimerBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, View view, ViewContentOnboardingBinding viewContentOnboardingBinding, View view2) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = textView;
        this.moveToNextValue = textView2;
        this.getErrorConfigVersion = view;
        this.scheduleImpl = viewContentOnboardingBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view2;
    }

    public static ViewGlobalSendLandingFirstTimerBinding BuiltInFictitiousFunctionClassFactory(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        int i = R.id.PlaceComponentResult;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatImageView != null) {
            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda8;
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (danaButtonPrimaryView != null) {
                i = R.id.res_0x7f0a0283_networkuserentitydata_externalsyntheticlambda7;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (constraintLayout != null) {
                    i = R.id.getNrCsiRsrq;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (textView != null) {
                        i = R.id.GifDrawableTransformation_res_0x7f0a15ac;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.viewBackground))) != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.res_0x7f0a1a79_quickbuybillsadapter_onquickbuyitemclicklistener_1))) != null) {
                            ViewContentOnboardingBinding MyBillsEntityDataFactory = ViewContentOnboardingBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                            i = R.id.clearName;
                            View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                return new ViewGlobalSendLandingFirstTimerBinding((ConstraintLayout) view, appCompatImageView, danaButtonPrimaryView, constraintLayout, textView, textView2, BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
