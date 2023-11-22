package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemBankPhoneNumberBinding implements ViewBinding {
    private final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final TextInputEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextInputLayout getAuthRequestContext;

    private ItemBankPhoneNumberBinding(RelativeLayout relativeLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputEditText;
        this.getAuthRequestContext = textInputLayout;
    }

    public static ItemBankPhoneNumberBinding getAuthRequestContext(View view) {
        int i = R.id.etBankPhoneNumber;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.etBankPhoneNumber);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tilBankPhoneNumber);
            if (textInputLayout != null) {
                return new ItemBankPhoneNumberBinding((RelativeLayout) view, textInputEditText, textInputLayout);
            }
            i = R.id.tilBankPhoneNumber;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
