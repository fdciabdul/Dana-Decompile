package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView;

/* loaded from: classes5.dex */
public final class ItemDefaultFormBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final EditTextFormView KClassImpl$Data$declaredNonStaticMembers$2;

    private ItemDefaultFormBinding(ConstraintLayout constraintLayout, EditTextFormView editTextFormView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editTextFormView;
    }

    public static ItemDefaultFormBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d02ae_networkuserentitydata_externalsyntheticlambda6, viewGroup, false);
        int i = R.id.viewEditTextForm;
        EditTextFormView editTextFormView = (EditTextFormView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (editTextFormView != null) {
            return new ItemDefaultFormBinding((ConstraintLayout) inflate, editTextFormView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
