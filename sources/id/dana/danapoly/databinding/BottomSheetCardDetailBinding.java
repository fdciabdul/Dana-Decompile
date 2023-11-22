package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class BottomSheetCardDetailBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    private final CoordinatorLayout DatabaseTableConfigUtil;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaDividerView MyBillsEntityDataFactory;
    public final DanaDividerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private BottomSheetCardDetailBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, DanaDividerView danaDividerView, DanaDividerView danaDividerView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.DatabaseTableConfigUtil = coordinatorLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = danaDividerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = danaDividerView2;
        this.moveToNextValue = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
        this.getErrorConfigVersion = view;
    }

    public static BottomSheetCardDetailBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d00f4_kclassimpl_data_declarednonstaticmembers_2, (ViewGroup) null, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a071c_summaryvoucherview_externalsyntheticlambda2;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.ivCardIcon;
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (shapeableImageView != null) {
                    i = R.id.OtpRegistrationPresenter$input$2;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.CheckPromoQuestFeature_res_0x7f0a120f;
                        DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (danaDividerView != null) {
                            i = R.id.ConcurrentKt;
                            DanaDividerView danaDividerView2 = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (danaDividerView2 != null) {
                                i = R.id.MultiLanguageHttpClient_res_0x7f0a13f4;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView != null) {
                                    i = R.id.res_0x7f0a13f7_unicastprocessor_unicastqueuesubscription;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (appCompatTextView2 != null) {
                                        i = R.id.getGnBenefitEntityDanaProtection;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (appCompatTextView3 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.TwilioRepository_res_0x7f0a1a8c))) != null) {
                                            return new BottomSheetCardDetailBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, frameLayout, shapeableImageView, appCompatImageView, danaDividerView, danaDividerView2, appCompatTextView, appCompatTextView2, appCompatTextView3, BuiltInFictitiousFunctionClassFactory);
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
