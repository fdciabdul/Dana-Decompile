package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class BottomSheetCardFilterBinding implements ViewBinding {
    public final RadioButton BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final DanaDividerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final RadioButton PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final RadioGroup getErrorConfigVersion;
    public final DanaDividerView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final RadioButton scheduleImpl;

    private BottomSheetCardFilterBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, DanaDividerView danaDividerView, DanaDividerView danaDividerView2, AppCompatTextView appCompatTextView, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = coordinatorLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = radioButton;
        this.PlaceComponentResult = radioButton2;
        this.scheduleImpl = radioButton3;
        this.getErrorConfigVersion = radioGroup;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = danaDividerView;
        this.lookAheadTest = danaDividerView2;
        this.moveToNextValue = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view;
    }

    public static BottomSheetCardFilterBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_card_filter, (ViewGroup) null, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.flCardFilter;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.OtpRegistrationPresenter$input$2;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.getTextEndPadding;
                    RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (radioButton != null) {
                        i = R.id.getRawPath_res_0x7f0a101c;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (radioButton2 != null) {
                            i = R.id.WrappedDrawableState_res_0x7f0a101e;
                            RadioButton radioButton3 = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (radioButton3 != null) {
                                i = R.id.res_0x7f0a106d_basesocialfeedcontract_presenter;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (radioGroup != null) {
                                    i = R.id.CheckPromoQuestFeature_res_0x7f0a120f;
                                    DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (danaDividerView != null) {
                                        i = R.id.ConcurrentKt;
                                        DanaDividerView danaDividerView2 = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (danaDividerView2 != null) {
                                            i = R.id.getGnBenefitEntityDanaProtection;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (appCompatTextView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.TwilioRepository_res_0x7f0a1a8c))) != null) {
                                                return new BottomSheetCardFilterBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, appCompatImageView, radioButton, radioButton2, radioButton3, radioGroup, danaDividerView, danaDividerView2, appCompatTextView, BuiltInFictitiousFunctionClassFactory);
                                            }
                                        }
                                    }
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
