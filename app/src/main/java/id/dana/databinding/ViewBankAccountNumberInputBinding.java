package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewBankAccountNumberInputBinding implements ViewBinding {
    public final TextInputLayout BuiltInFictitiousFunctionClassFactory;
    public final TextInputEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView PlaceComponentResult;
    private final RelativeLayout getAuthRequestContext;

    private ViewBankAccountNumberInputBinding(RelativeLayout relativeLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        this.getAuthRequestContext = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputEditText;
        this.BuiltInFictitiousFunctionClassFactory = textInputLayout;
        this.PlaceComponentResult = appCompatTextView;
    }

    public static ViewBankAccountNumberInputBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_bank_account_number_input, (ViewGroup) null, false);
        int i = R.id.etAccountNumber;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etAccountNumber);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilAccountNumber);
            if (textInputLayout != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorCard);
                if (appCompatTextView != null) {
                    return new ViewBankAccountNumberInputBinding((RelativeLayout) inflate, textInputEditText, textInputLayout, appCompatTextView);
                }
                i = R.id.tvErrorCard;
            } else {
                i = R.id.tilAccountNumber;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
