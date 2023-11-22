package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.danapoly.R;

/* loaded from: classes8.dex */
public final class BottomSheetTncBinding implements ViewBinding {
    public final DanaDividerView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaDividerView getAuthRequestContext;
    public final NestedScrollView getErrorConfigVersion;
    private final CoordinatorLayout lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final View scheduleImpl;

    private BottomSheetTncBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, DanaDividerView danaDividerView, DanaDividerView danaDividerView2, NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.lookAheadTest = coordinatorLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = danaDividerView;
        this.getAuthRequestContext = danaDividerView2;
        this.getErrorConfigVersion = nestedScrollView;
        this.moveToNextValue = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.scheduleImpl = view;
    }

    public static BottomSheetTncBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_tnc, (ViewGroup) null, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.flTnc;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.OtpRegistrationPresenter$input$2;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.CheckPromoQuestFeature_res_0x7f0a120f;
                    DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (danaDividerView != null) {
                        i = R.id.ConcurrentKt;
                        DanaDividerView danaDividerView2 = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (danaDividerView2 != null) {
                            i = R.id.onPolygonsChanged_res_0x7f0a12a8;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (nestedScrollView != null) {
                                i = R.id.onTooManyRedirects;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView != null) {
                                    i = R.id.getGnBenefitEntityDanaProtection;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (appCompatTextView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.TwilioRepository_res_0x7f0a1a8c))) != null) {
                                        return new BottomSheetTncBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, appCompatImageView, danaDividerView, danaDividerView2, nestedScrollView, appCompatTextView, appCompatTextView2, BuiltInFictitiousFunctionClassFactory);
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
        return this.lookAheadTest;
    }
}
