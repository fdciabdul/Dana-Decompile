package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentInputConfirmPinBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final PinEntryEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final ViewToolbarBinding getErrorConfigVersion;

    private FragmentInputConfirmPinBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, PinEntryEditText pinEntryEditText, TextView textView, TextView textView2, ViewToolbarBinding viewToolbarBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pinEntryEditText;
        this.MyBillsEntityDataFactory = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
        this.getErrorConfigVersion = viewToolbarBinding;
    }

    public static FragmentInputConfirmPinBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01d0_kclassimpl_data_declarednonstaticmembers_2, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            i = R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8;
            PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (pinEntryEditText != null) {
                i = R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    i = R.id.res_0x7f0a0908_networkuserentitydata_externalsyntheticlambda5;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.v_toolbar))) != null) {
                        return new FragmentInputConfirmPinBinding(constraintLayout, appCompatTextView, constraintLayout, pinEntryEditText, textView, textView2, ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
