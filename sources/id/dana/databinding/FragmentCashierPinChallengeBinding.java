package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierPinChallengeBinding implements ViewBinding {
    public final LogoProgressView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final Guideline KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final ViewCashierRiskBindingPayBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final PinEntryEditText PlaceComponentResult;
    public final DanaProtectionLoadingView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private FragmentCashierPinChallengeBinding(ConstraintLayout constraintLayout, DanaProtectionLoadingView danaProtectionLoadingView, PinEntryEditText pinEntryEditText, FrameLayout frameLayout, Guideline guideline, LogoProgressView logoProgressView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ViewCashierRiskBindingPayBinding viewCashierRiskBindingPayBinding) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.getAuthRequestContext = danaProtectionLoadingView;
        this.PlaceComponentResult = pinEntryEditText;
        this.MyBillsEntityDataFactory = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = guideline;
        this.BuiltInFictitiousFunctionClassFactory = logoProgressView;
        this.lookAheadTest = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.getErrorConfigVersion = appCompatTextView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewCashierRiskBindingPayBinding;
    }

    public static FragmentCashierPinChallengeBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_pin_challenge, (ViewGroup) null, false);
        int i = R.id.f3731danaProtectLoadingView;
        DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3731danaProtectLoadingView);
        if (danaProtectionLoadingView != null) {
            PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.edtInputPin);
            if (pinEntryEditText != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
                if (frameLayout != null) {
                    Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.guideline4);
                    if (guideline != null) {
                        LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                        if (logoProgressView != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCancelPin);
                            if (appCompatTextView != null) {
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvEnterPin);
                                if (appCompatTextView2 != null) {
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvForgotPin);
                                    if (appCompatTextView3 != null) {
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvPinError);
                                        if (appCompatTextView4 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vRiskBinding);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                return new FragmentCashierPinChallengeBinding((ConstraintLayout) inflate, danaProtectionLoadingView, pinEntryEditText, frameLayout, guideline, logoProgressView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, ViewCashierRiskBindingPayBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory));
                                            }
                                            i = R.id.vRiskBinding;
                                        } else {
                                            i = R.id.tvPinError;
                                        }
                                    } else {
                                        i = R.id.tvForgotPin;
                                    }
                                } else {
                                    i = R.id.tvEnterPin;
                                }
                            } else {
                                i = R.id.tvCancelPin;
                            }
                        } else {
                            i = R.id.f4033lpvLoading;
                        }
                    } else {
                        i = R.id.guideline4;
                    }
                } else {
                    i = R.id.flDanaLoading;
                }
            } else {
                i = R.id.edtInputPin;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
