package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierCvvChallengeBinding implements ViewBinding {
    public final PinEntryEditText BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout GetContactSyncConfig;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LogoProgressView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaProtectionLoadingView PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final ViewCashierRiskBindingPayBinding getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private FragmentCashierCvvChallengeBinding(ConstraintLayout constraintLayout, DanaProtectionLoadingView danaProtectionLoadingView, PinEntryEditText pinEntryEditText, FrameLayout frameLayout, LinearLayout linearLayout, LogoProgressView logoProgressView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ViewCashierRiskBindingPayBinding viewCashierRiskBindingPayBinding) {
        this.GetContactSyncConfig = constraintLayout;
        this.PlaceComponentResult = danaProtectionLoadingView;
        this.BuiltInFictitiousFunctionClassFactory = pinEntryEditText;
        this.getAuthRequestContext = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.MyBillsEntityDataFactory = logoProgressView;
        this.moveToNextValue = textView;
        this.scheduleImpl = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.lookAheadTest = textView4;
        this.getErrorConfigVersion = viewCashierRiskBindingPayBinding;
    }

    public static FragmentCashierCvvChallengeBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_cvv_challenge, (ViewGroup) null, false);
        int i = R.id.f3731danaProtectLoadingView;
        DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3731danaProtectLoadingView);
        if (danaProtectionLoadingView != null) {
            PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etInputCvv);
            if (pinEntryEditText != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
                if (frameLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llActionContainer);
                    if (linearLayout != null) {
                        LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                        if (logoProgressView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCancelCvv);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4269res_0x7f0a145e_logfilemanager_1);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvWhatIsCvv);
                                        if (textView4 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vRiskBinding);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                return new FragmentCashierCvvChallengeBinding((ConstraintLayout) inflate, danaProtectionLoadingView, pinEntryEditText, frameLayout, linearLayout, logoProgressView, textView, textView2, textView3, textView4, ViewCashierRiskBindingPayBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory));
                                            }
                                            i = R.id.vRiskBinding;
                                        } else {
                                            i = R.id.tvWhatIsCvv;
                                        }
                                    } else {
                                        i = R.id.tvTitle;
                                    }
                                } else {
                                    i = R.id.f4269res_0x7f0a145e_logfilemanager_1;
                                }
                            } else {
                                i = R.id.tvCancelCvv;
                            }
                        } else {
                            i = R.id.f4033lpvLoading;
                        }
                    } else {
                        i = R.id.llActionContainer;
                    }
                } else {
                    i = R.id.flDanaLoading;
                }
            } else {
                i = R.id.etInputCvv;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
