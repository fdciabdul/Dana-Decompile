package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cardbinding.view.DisclaimerView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes8.dex */
public final class ViewBottomSheetCardBindingBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ViewCardBindingBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final DisclaimerView getErrorConfigVersion;
    public final NestedScrollView lookAheadTest;
    private final ConstraintLayout moveToNextValue;

    private ViewBottomSheetCardBindingBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ViewCardBindingBinding viewCardBindingBinding, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, DisclaimerView disclaimerView, NestedScrollView nestedScrollView) {
        this.moveToNextValue = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewCardBindingBinding;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout4;
        this.getErrorConfigVersion = disclaimerView;
        this.lookAheadTest = nestedScrollView;
    }

    public static ViewBottomSheetCardBindingBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_bottom_sheet_card_binding, (ViewGroup) null, false);
        int i = R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1);
        if (danaButtonPrimaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cardBindingContentView);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewCardBindingBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCardBindingBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clCardBindingContainer);
                if (constraintLayout2 != null) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clStickySection);
                    if (constraintLayout3 != null) {
                        DisclaimerView disclaimerView = (DisclaimerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.GetPersonalizationOptions);
                        if (disclaimerView != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.svField);
                            if (nestedScrollView != null) {
                                return new ViewBottomSheetCardBindingBinding(constraintLayout, danaButtonPrimaryView, KClassImpl$Data$declaredNonStaticMembers$2, constraintLayout, constraintLayout2, constraintLayout3, disclaimerView, nestedScrollView);
                            }
                            i = R.id.svField;
                        } else {
                            i = R.id.GetPersonalizationOptions;
                        }
                    } else {
                        i = R.id.clStickySection;
                    }
                } else {
                    i = R.id.clCardBindingContainer;
                }
            } else {
                i = R.id.cardBindingContentView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
