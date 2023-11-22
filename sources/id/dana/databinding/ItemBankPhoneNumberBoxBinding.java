package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemBankPhoneNumberBoxBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextInputLayout PlaceComponentResult;
    public final TextInputEditText getAuthRequestContext;

    private ItemBankPhoneNumberBoxBinding(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.getAuthRequestContext = textInputEditText;
        this.PlaceComponentResult = textInputLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
    }

    public static ItemBankPhoneNumberBoxBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.item_bank_phone_number_box, (ViewGroup) null, false);
        int i = R.id.etBankPhoneNumber;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etBankPhoneNumber);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilBankPhoneNumber);
            if (textInputLayout != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorHelper);
                if (appCompatTextView != null) {
                    return new ItemBankPhoneNumberBoxBinding((ConstraintLayout) inflate, textInputEditText, textInputLayout, appCompatTextView);
                }
                i = R.id.tvErrorHelper;
            } else {
                i = R.id.tilBankPhoneNumber;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
