package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewStickyBottomSheetLandingBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ViewStickyBottomSheetLandingBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView, View view) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public static ViewStickyBottomSheetLandingBinding getAuthRequestContext(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        int i = R.id.newProxyInstance_res_0x7f0a0192;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0d32_unicastprocessor_unicastqueuesubscription;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.tvMaxGroupNotes;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.res_0x7f0a1add_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider))) != null) {
                    return new ViewStickyBottomSheetLandingBinding(constraintLayout, danaButtonPrimaryView, linearLayout, constraintLayout, textView, BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
