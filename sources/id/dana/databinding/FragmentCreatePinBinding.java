package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;

/* loaded from: classes4.dex */
public final class FragmentCreatePinBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final PinEntryEditText MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    private final RelativeLayout getAuthRequestContext;

    private FragmentCreatePinBinding(RelativeLayout relativeLayout, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, PinEntryEditText pinEntryEditText) {
        this.getAuthRequestContext = relativeLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
        this.MyBillsEntityDataFactory = pinEntryEditText;
    }

    public static FragmentCreatePinBinding getAuthRequestContext(View view) {
        int i = R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0);
        if (appCompatTextView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.header_description);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.header_title);
                if (textView2 != null) {
                    PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8);
                    if (pinEntryEditText != null) {
                        return new FragmentCreatePinBinding((RelativeLayout) view, appCompatTextView, textView, textView2, pinEntryEditText);
                    }
                    i = R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8;
                } else {
                    i = R.id.header_title;
                }
            } else {
                i = R.id.header_description;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
