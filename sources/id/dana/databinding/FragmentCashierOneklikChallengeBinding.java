package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierOneklikChallengeBinding implements ViewBinding {
    public final DanaProtectionLoadingView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonGhostView MyBillsEntityDataFactory;
    public final ViewCashierToolbarBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final FrameLayout PlaceComponentResult;
    public final PinEntryEditText getAuthRequestContext;
    public final Spinner getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final LogoProgressView lookAheadTest;
    public final LinearLayout moveToNextValue;
    public final Group scheduleImpl;

    private FragmentCashierOneklikChallengeBinding(ConstraintLayout constraintLayout, DanaButtonGhostView danaButtonGhostView, DanaButtonSecondaryView danaButtonSecondaryView, DanaProtectionLoadingView danaProtectionLoadingView, PinEntryEditText pinEntryEditText, FrameLayout frameLayout, Group group, LinearLayout linearLayout, LogoProgressView logoProgressView, ViewCashierToolbarBinding viewCashierToolbarBinding, Spinner spinner, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonGhostView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaProtectionLoadingView;
        this.getAuthRequestContext = pinEntryEditText;
        this.PlaceComponentResult = frameLayout;
        this.scheduleImpl = group;
        this.moveToNextValue = linearLayout;
        this.lookAheadTest = logoProgressView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewCashierToolbarBinding;
        this.getErrorConfigVersion = spinner;
        this.DatabaseTableConfigUtil = textView;
        this.GetContactSyncConfig = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView3;
        this.initRecordTimeStamp = textView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView5;
    }

    public static FragmentCashierOneklikChallengeBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_oneklik_challenge, (ViewGroup) null, false);
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnOneklikChallengeCountdown);
        int i = R.id.btnOneklikChallengeSendOtp;
        if (danaButtonGhostView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnOneklikChallengeSendOtp);
            if (danaButtonSecondaryView != null) {
                DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3731danaProtectLoadingView);
                if (danaProtectionLoadingView != null) {
                    PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etInputOneklikOtp);
                    if (pinEntryEditText != null) {
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
                        if (frameLayout != null) {
                            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupOtpInput);
                            if (group != null) {
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llOneklikChallengePhoneNumber);
                                if (linearLayout != null) {
                                    LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                                    if (logoProgressView != null) {
                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.onekliKChallengeHeader);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                                            Spinner spinner = (Spinner) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.oneklikChallengeSpinner);
                                            if (spinner != null) {
                                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.oneklikChallengeSpinnerPrefix);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOneklikChallengeOtpError);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOneklikChallengeOtpTitle);
                                                        if (textView3 != null) {
                                                            TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOneklikChallengeTitle);
                                                            if (textView4 != null) {
                                                                TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOneklikChallengeTitleDescription);
                                                                if (textView5 != null) {
                                                                    return new FragmentCashierOneklikChallengeBinding((ConstraintLayout) inflate, danaButtonGhostView, danaButtonSecondaryView, danaProtectionLoadingView, pinEntryEditText, frameLayout, group, linearLayout, logoProgressView, authRequestContext, spinner, textView, textView2, textView3, textView4, textView5);
                                                                }
                                                                i = R.id.tvOneklikChallengeTitleDescription;
                                                            } else {
                                                                i = R.id.tvOneklikChallengeTitle;
                                                            }
                                                        } else {
                                                            i = R.id.tvOneklikChallengeOtpTitle;
                                                        }
                                                    } else {
                                                        i = R.id.tvOneklikChallengeOtpError;
                                                    }
                                                } else {
                                                    i = R.id.oneklikChallengeSpinnerPrefix;
                                                }
                                            } else {
                                                i = R.id.oneklikChallengeSpinner;
                                            }
                                        } else {
                                            i = R.id.onekliKChallengeHeader;
                                        }
                                    } else {
                                        i = R.id.f4033lpvLoading;
                                    }
                                } else {
                                    i = R.id.llOneklikChallengePhoneNumber;
                                }
                            } else {
                                i = R.id.groupOtpInput;
                            }
                        } else {
                            i = R.id.flDanaLoading;
                        }
                    } else {
                        i = R.id.etInputOneklikOtp;
                    }
                } else {
                    i = R.id.f3731danaProtectLoadingView;
                }
            }
        } else {
            i = R.id.btnOneklikChallengeCountdown;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }
}
