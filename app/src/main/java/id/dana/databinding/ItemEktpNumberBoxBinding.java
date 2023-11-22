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
public final class ItemEktpNumberBoxBinding implements ViewBinding {
    public final TextInputEditText KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final TextInputLayout getAuthRequestContext;

    private ItemEktpNumberBoxBinding(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputEditText;
        this.getAuthRequestContext = textInputLayout;
        this.PlaceComponentResult = appCompatTextView;
    }

    public static ItemEktpNumberBoxBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.item_ektp_number_box, (ViewGroup) null, false);
        int i = R.id.etEktp;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etEktp);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilEktp);
            if (textInputLayout != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorCard);
                if (appCompatTextView != null) {
                    return new ItemEktpNumberBoxBinding((ConstraintLayout) inflate, textInputEditText, textInputLayout, appCompatTextView);
                }
                i = R.id.tvErrorCard;
            } else {
                i = R.id.tilEktp;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
