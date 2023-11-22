package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewExpirationDateInputBinding implements ViewBinding {
    public final TextInputLayout BuiltInFictitiousFunctionClassFactory;
    public final TextInputEditText MyBillsEntityDataFactory;
    private final RelativeLayout getAuthRequestContext;

    private ViewExpirationDateInputBinding(RelativeLayout relativeLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        this.getAuthRequestContext = relativeLayout;
        this.MyBillsEntityDataFactory = textInputEditText;
        this.BuiltInFictitiousFunctionClassFactory = textInputLayout;
    }

    public static ViewExpirationDateInputBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_expiration_date_input, (ViewGroup) null, false);
        int i = R.id.etExpireDate;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etExpireDate);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilExpirationDate);
            if (textInputLayout != null) {
                return new ViewExpirationDateInputBinding((RelativeLayout) inflate, textInputEditText, textInputLayout);
            }
            i = R.id.tilExpirationDate;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
