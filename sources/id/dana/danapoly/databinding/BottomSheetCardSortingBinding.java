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
public final class BottomSheetCardSortingBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    private final CoordinatorLayout DatabaseTableConfigUtil;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RadioButton MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final RadioButton PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final DanaDividerView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final DanaDividerView moveToNextValue;
    public final RadioGroup scheduleImpl;

    private BottomSheetCardSortingBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, DanaDividerView danaDividerView, DanaDividerView danaDividerView2, AppCompatTextView appCompatTextView, View view) {
        this.DatabaseTableConfigUtil = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = radioButton;
        this.PlaceComponentResult = radioButton2;
        this.scheduleImpl = radioGroup;
        this.moveToNextValue = danaDividerView;
        this.getErrorConfigVersion = danaDividerView2;
        this.lookAheadTest = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
    }

    public static BottomSheetCardSortingBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d00f6_networkuserentitydata_externalsyntheticlambda0, (ViewGroup) null, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.flCardSorting;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.OtpRegistrationPresenter$input$2;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.useDaemonThreadFactory_res_0x7f0a1020;
                    RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (radioButton != null) {
                        i = R.id.encodingStream_res_0x7f0a1021;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (radioButton2 != null) {
                            i = R.id.rgCardSorting;
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
                                            return new BottomSheetCardSortingBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, appCompatImageView, radioButton, radioButton2, radioGroup, danaDividerView, danaDividerView2, appCompatTextView, BuiltInFictitiousFunctionClassFactory);
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
        return this.DatabaseTableConfigUtil;
    }
}
