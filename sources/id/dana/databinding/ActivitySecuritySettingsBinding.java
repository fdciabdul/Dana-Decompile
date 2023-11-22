package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivitySecuritySettingsBinding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;

    private ActivitySecuritySettingsBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, RecyclerView recyclerView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    public static ActivitySecuritySettingsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_security_settings, (ViewGroup) null, false);
        int i = R.id.SecurityGuardProfileProvider;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_security_settings);
            if (recyclerView != null) {
                return new ActivitySecuritySettingsBinding((ConstraintLayout) inflate, MyBillsEntityDataFactory, recyclerView);
            }
            i = R.id.rv_security_settings;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
