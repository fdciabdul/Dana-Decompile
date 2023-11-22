package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.NumpadView;

/* loaded from: classes4.dex */
public final class ViewBottomsheetCustomKeyboardX2xBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final NumpadView PlaceComponentResult;
    public final View getAuthRequestContext;
    private final CoordinatorLayout scheduleImpl;

    private ViewBottomsheetCustomKeyboardX2xBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NumpadView numpadView, View view) {
        this.scheduleImpl = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = numpadView;
        this.getAuthRequestContext = view;
    }

    public static ViewBottomsheetCustomKeyboardX2xBinding getAuthRequestContext(View view) {
        int i = R.id.f3467btnDoneNumpad;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3467btnDoneNumpad);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3593clCustomKeyboardBottomSheet);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clViewNumpad);
                if (constraintLayout2 != null) {
                    NumpadView numpadView = (NumpadView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewNumpad);
                    if (numpadView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a1add_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ViewBottomsheetCustomKeyboardX2xBinding((CoordinatorLayout) view, danaButtonPrimaryView, constraintLayout, constraintLayout2, numpadView, BuiltInFictitiousFunctionClassFactory);
                        }
                        i = R.id.res_0x7f0a1add_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider;
                    } else {
                        i = R.id.viewNumpad;
                    }
                } else {
                    i = R.id.clViewNumpad;
                }
            } else {
                i = R.id.f3593clCustomKeyboardBottomSheet;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
