package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class DialogDanaSuccessBinding implements ViewBinding {
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView getAuthRequestContext;

    private DialogDanaSuccessBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = appCompatImageView;
    }

    public static DialogDanaSuccessBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d017a_kclassimpl_data_declarednonstaticmembers_2, viewGroup, false);
        int i = R.id.res_0x7f0a099c_networkuserentitydata_externalsyntheticlambda8;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            return new DialogDanaSuccessBinding((ConstraintLayout) inflate, appCompatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
