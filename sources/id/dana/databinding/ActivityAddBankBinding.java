package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityAddBankBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutAddBankBinding MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final LayoutGeneralEmptyStateBinding getAuthRequestContext;

    private ActivityAddBankBinding(ConstraintLayout constraintLayout, LayoutAddBankBinding layoutAddBankBinding, LayoutGeneralEmptyStateBinding layoutGeneralEmptyStateBinding, LayoutToolbarBinding layoutToolbarBinding) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = layoutAddBankBinding;
        this.getAuthRequestContext = layoutGeneralEmptyStateBinding;
        this.PlaceComponentResult = layoutToolbarBinding;
    }

    public static ActivityAddBankBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_add_bank, (ViewGroup) null, false);
        int i = R.id.layoutAddBank;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutAddBank);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutAddBankBinding MyBillsEntityDataFactory = LayoutAddBankBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutGeneralEmptyState);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                LayoutGeneralEmptyStateBinding BuiltInFictitiousFunctionClassFactory3 = LayoutGeneralEmptyStateBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
                View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                if (BuiltInFictitiousFunctionClassFactory4 != null) {
                    return new ActivityAddBankBinding((ConstraintLayout) inflate, MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory3, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4));
                }
                i = R.id.layoutToolbar;
            } else {
                i = R.id.layoutGeneralEmptyState;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
