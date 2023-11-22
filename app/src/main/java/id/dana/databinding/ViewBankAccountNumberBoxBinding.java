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
public final class ViewBankAccountNumberBoxBinding implements ViewBinding {
    public final TextInputLayout BuiltInFictitiousFunctionClassFactory;
    public final TextInputEditText KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;

    private ViewBankAccountNumberBoxBinding(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputEditText;
        this.BuiltInFictitiousFunctionClassFactory = textInputLayout;
        this.getAuthRequestContext = appCompatTextView;
    }

    public static ViewBankAccountNumberBoxBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_bank_account_number_box, (ViewGroup) null, false);
        int i = R.id.etAccountNumber;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etAccountNumber);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilAccountNumber);
            if (textInputLayout != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorCard);
                if (appCompatTextView != null) {
                    return new ViewBankAccountNumberBoxBinding((ConstraintLayout) inflate, textInputEditText, textInputLayout, appCompatTextView);
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
        return this.PlaceComponentResult;
    }
}
