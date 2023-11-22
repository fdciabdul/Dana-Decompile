package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.cashier.view.ExpirationDateInputView;

/* loaded from: classes4.dex */
public final class ItemExpiryDateCvvBinding implements ViewBinding {
    public final TextInputEditText BuiltInFictitiousFunctionClassFactory;
    public final TextInputLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final ExpirationDateInputView PlaceComponentResult;
    private final LinearLayout getAuthRequestContext;

    private ItemExpiryDateCvvBinding(LinearLayout linearLayout, TextInputEditText textInputEditText, ExpirationDateInputView expirationDateInputView, LinearLayout linearLayout2, TextInputLayout textInputLayout) {
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = textInputEditText;
        this.PlaceComponentResult = expirationDateInputView;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputLayout;
    }

    public static ItemExpiryDateCvvBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.etCardCvv;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.etCardCvv);
        if (textInputEditText != null) {
            ExpirationDateInputView expirationDateInputView = (ExpirationDateInputView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3761x701b0d2a);
            if (expirationDateInputView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tilCvv);
                if (textInputLayout != null) {
                    return new ItemExpiryDateCvvBinding(linearLayout, textInputEditText, expirationDateInputView, linearLayout, textInputLayout);
                }
                i = R.id.tilCvv;
            } else {
                i = R.id.f3761x701b0d2a;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
