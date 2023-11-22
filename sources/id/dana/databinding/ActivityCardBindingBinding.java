package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cardbinding.view.DisclaimerView;
import id.dana.cardbinding.view.SupportedCardsView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes2.dex */
public final class ActivityCardBindingBinding implements ViewBinding {
    public final DisclaimerView BuiltInFictitiousFunctionClassFactory;
    public final DisclaimerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ViewCardBindingBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final SupportedCardsView getErrorConfigVersion;
    public final ActivityOnboardingCardBindingBinding lookAheadTest;
    public final View moveToNextValue;
    public final LayoutToolbarBinding scheduleImpl;

    private ActivityCardBindingBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, DisclaimerView disclaimerView, AppCompatImageView appCompatImageView, DisclaimerView disclaimerView2, SupportedCardsView supportedCardsView, ViewCardBindingBinding viewCardBindingBinding, View view, ActivityOnboardingCardBindingBinding activityOnboardingCardBindingBinding, LayoutToolbarBinding layoutToolbarBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = disclaimerView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = disclaimerView2;
        this.getErrorConfigVersion = supportedCardsView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewCardBindingBinding;
        this.moveToNextValue = view;
        this.lookAheadTest = activityOnboardingCardBindingBinding;
        this.scheduleImpl = layoutToolbarBinding;
    }

    public static ActivityCardBindingBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_card_binding, (ViewGroup) null, false);
        int i = R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3461res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clStickySection);
            if (constraintLayout != null) {
                DisclaimerView disclaimerView = (DisclaimerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.GetPersonalizationOptions);
                if (disclaimerView != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBackground);
                    if (appCompatImageView != null) {
                        DisclaimerView disclaimerView2 = (DisclaimerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.oneklikDisclaimerView);
                        if (disclaimerView2 != null) {
                            SupportedCardsView supportedCardsView = (SupportedCardsView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.supportedCardsView);
                            if (supportedCardsView != null) {
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewCardBinding);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    ViewCardBindingBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCardBindingBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewDivider);
                                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewOnBoarding);
                                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                            ActivityOnboardingCardBindingBinding PlaceComponentResult = ActivityOnboardingCardBindingBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                                            View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewToolbarCardBinding);
                                            if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                return new ActivityCardBindingBinding((ConstraintLayout) inflate, danaButtonPrimaryView, constraintLayout, disclaimerView, appCompatImageView, disclaimerView2, supportedCardsView, KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2, PlaceComponentResult, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4));
                                            }
                                            i = R.id.viewToolbarCardBinding;
                                        } else {
                                            i = R.id.viewOnBoarding;
                                        }
                                    } else {
                                        i = R.id.viewDivider;
                                    }
                                } else {
                                    i = R.id.viewCardBinding;
                                }
                            } else {
                                i = R.id.supportedCardsView;
                            }
                        } else {
                            i = R.id.oneklikDisclaimerView;
                        }
                    } else {
                        i = R.id.ivBackground;
                    }
                } else {
                    i = R.id.GetPersonalizationOptions;
                }
            } else {
                i = R.id.clStickySection;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
