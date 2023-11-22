package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemEktpNumberBinding implements ViewBinding {
    private final RelativeLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextInputLayout MyBillsEntityDataFactory;
    public final TextInputEditText PlaceComponentResult;

    private ItemEktpNumberBinding(RelativeLayout relativeLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = relativeLayout;
        this.PlaceComponentResult = textInputEditText;
        this.MyBillsEntityDataFactory = textInputLayout;
    }

    public static ItemEktpNumberBinding PlaceComponentResult(View view) {
        int i = R.id.etEktp;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.etEktp);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tilEktp);
            if (textInputLayout != null) {
                return new ItemEktpNumberBinding((RelativeLayout) view, textInputEditText, textInputLayout);
            }
            i = R.id.tilEktp;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
