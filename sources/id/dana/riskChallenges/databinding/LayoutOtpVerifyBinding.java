package id.dana.riskChallenges.databinding;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.dialog.DanaLogoProgressView;
import id.dana.core.ui.richview.OtpInputView;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class LayoutOtpVerifyBinding implements ViewBinding {
    public final DanaLogoProgressView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final OtpInputView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final EditText PlaceComponentResult;
    public final RetryAndTimerView getAuthRequestContext;
    private final LinearLayoutCompat moveToNextValue;

    private LayoutOtpVerifyBinding(LinearLayoutCompat linearLayoutCompat, RetryAndTimerView retryAndTimerView, DanaLogoProgressView danaLogoProgressView, EditText editText, OtpInputView otpInputView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = linearLayoutCompat;
        this.getAuthRequestContext = retryAndTimerView;
        this.BuiltInFictitiousFunctionClassFactory = danaLogoProgressView;
        this.PlaceComponentResult = editText;
        this.MyBillsEntityDataFactory = otpInputView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
    }

    public static LayoutOtpVerifyBinding getAuthRequestContext(View view) {
        int i = R.id.btn_retry_otp;
        RetryAndTimerView retryAndTimerView = (RetryAndTimerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (retryAndTimerView != null) {
            i = R.id.res_0x7f0a059b_networkuserentitydata_externalsyntheticlambda1;
            DanaLogoProgressView danaLogoProgressView = (DanaLogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (danaLogoProgressView != null) {
                i = R.id.res_0x7f0a067b_networkuserentitydata_externalsyntheticlambda2;
                EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (editText != null) {
                    i = R.id.isLayoutRequested_res_0x7f0a0904;
                    OtpInputView otpInputView = (OtpInputView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (otpInputView != null) {
                        i = R.id.L;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (appCompatTextView != null) {
                            i = R.id.getNameOrBuilderList;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (appCompatTextView2 != null) {
                                return new LayoutOtpVerifyBinding((LinearLayoutCompat) view, retryAndTimerView, danaLogoProgressView, editText, otpInputView, appCompatTextView, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
