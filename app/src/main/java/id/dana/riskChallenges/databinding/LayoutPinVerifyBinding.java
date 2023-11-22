package id.dana.riskChallenges.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.dialog.DanaLogoProgressView;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class LayoutPinVerifyBinding implements ViewBinding {
    private final LinearLayoutCompat BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final PinEntryEditText MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final DanaLogoProgressView getAuthRequestContext;

    private LayoutPinVerifyBinding(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, DanaLogoProgressView danaLogoProgressView, PinEntryEditText pinEntryEditText, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayoutCompat;
        this.PlaceComponentResult = appCompatTextView;
        this.getAuthRequestContext = danaLogoProgressView;
        this.MyBillsEntityDataFactory = pinEntryEditText;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static LayoutPinVerifyBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a01e2;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatTextView != null) {
            i = R.id.res_0x7f0a059b_networkuserentitydata_externalsyntheticlambda1;
            DanaLogoProgressView danaLogoProgressView = (DanaLogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (danaLogoProgressView != null) {
                i = R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8;
                PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (pinEntryEditText != null) {
                    i = R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (textView != null) {
                        return new LayoutPinVerifyBinding((LinearLayoutCompat) view, appCompatTextView, danaLogoProgressView, pinEntryEditText, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
