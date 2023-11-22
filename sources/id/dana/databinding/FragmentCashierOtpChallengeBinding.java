package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierOtpChallengeBinding implements ViewBinding {
    public final DanaProtectionLoadingView BuiltInFictitiousFunctionClassFactory;
    public final View DatabaseTableConfigUtil;
    public final View GetContactSyncConfig;
    public final PinEntryEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final TextView PlaceComponentResult;
    public final LogoProgressView getAuthRequestContext;
    public final ViewCashierRiskBindingPayBinding getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private FragmentCashierOtpChallengeBinding(ConstraintLayout constraintLayout, DanaProtectionLoadingView danaProtectionLoadingView, PinEntryEditText pinEntryEditText, FrameLayout frameLayout, LogoProgressView logoProgressView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ViewCashierRiskBindingPayBinding viewCashierRiskBindingPayBinding, View view, View view2, View view3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaProtectionLoadingView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pinEntryEditText;
        this.MyBillsEntityDataFactory = frameLayout;
        this.getAuthRequestContext = logoProgressView;
        this.PlaceComponentResult = textView;
        this.moveToNextValue = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.scheduleImpl = textView4;
        this.lookAheadTest = textView5;
        this.getErrorConfigVersion = viewCashierRiskBindingPayBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view;
        this.DatabaseTableConfigUtil = view2;
        this.GetContactSyncConfig = view3;
    }

    public static FragmentCashierOtpChallengeBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_otp_challenge, (ViewGroup) null, false);
        int i = R.id.f3731danaProtectLoadingView;
        DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3731danaProtectLoadingView);
        if (danaProtectionLoadingView != null) {
            PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3748res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
            if (pinEntryEditText != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
                if (frameLayout != null) {
                    LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                    if (logoProgressView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvEnterOtp);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4269res_0x7f0a145e_logfilemanager_1);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOtpDesc);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ViewholderFriendListEmptyBinding);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.setMinusSignString);
                                        if (textView5 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vRiskBinding);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                ViewCashierRiskBindingPayBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCashierRiskBindingPayBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vShimmerEnterOtp);
                                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vShimmerInputOtp);
                                                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                        View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vShimmerResend);
                                                        if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                            return new FragmentCashierOtpChallengeBinding((ConstraintLayout) inflate, danaProtectionLoadingView, pinEntryEditText, frameLayout, logoProgressView, textView, textView2, textView3, textView4, textView5, KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4);
                                                        }
                                                        i = R.id.vShimmerResend;
                                                    } else {
                                                        i = R.id.vShimmerInputOtp;
                                                    }
                                                } else {
                                                    i = R.id.vShimmerEnterOtp;
                                                }
                                            } else {
                                                i = R.id.vRiskBinding;
                                            }
                                        } else {
                                            i = R.id.setMinusSignString;
                                        }
                                    } else {
                                        i = R.id.ViewholderFriendListEmptyBinding;
                                    }
                                } else {
                                    i = R.id.tvOtpDesc;
                                }
                            } else {
                                i = R.id.f4269res_0x7f0a145e_logfilemanager_1;
                            }
                        } else {
                            i = R.id.tvEnterOtp;
                        }
                    } else {
                        i = R.id.f4033lpvLoading;
                    }
                } else {
                    i = R.id.flDanaLoading;
                }
            } else {
                i = R.id.f3748res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
