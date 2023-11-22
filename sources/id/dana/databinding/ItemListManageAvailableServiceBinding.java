package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemListManageAvailableServiceBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final SwitchMaterial MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ItemListManageAvailableServiceBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, SwitchMaterial switchMaterial, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = switchMaterial;
        this.getAuthRequestContext = textView;
    }

    public static ItemListManageAvailableServiceBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_list_manage_available_service, viewGroup, false);
        int i = R.id.ivIconService;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivIconService);
        if (appCompatImageView != null) {
            SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.switchService);
            if (switchMaterial != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvNameService);
                if (textView != null) {
                    return new ItemListManageAvailableServiceBinding((ConstraintLayout) inflate, appCompatImageView, switchMaterial, textView);
                }
                i = R.id.tvNameService;
            } else {
                i = R.id.switchService;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
