package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class FragmentAddNewBillsBinding implements ViewBinding {
    public final ViewMyBillsRecentTransactionV2Binding BuiltInFictitiousFunctionClassFactory;
    public final MyBillsToolbarLayoutBinding KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout PlaceComponentResult;
    public final ViewDiscoverBillsServiceV2Binding getAuthRequestContext;

    private FragmentAddNewBillsBinding(ConstraintLayout constraintLayout, MyBillsToolbarLayoutBinding myBillsToolbarLayoutBinding, ViewMyBillsRecentTransactionV2Binding viewMyBillsRecentTransactionV2Binding, ViewDiscoverBillsServiceV2Binding viewDiscoverBillsServiceV2Binding) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myBillsToolbarLayoutBinding;
        this.BuiltInFictitiousFunctionClassFactory = viewMyBillsRecentTransactionV2Binding;
        this.getAuthRequestContext = viewDiscoverBillsServiceV2Binding;
    }

    public static FragmentAddNewBillsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_new_bills, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            MyBillsToolbarLayoutBinding KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsToolbarLayoutBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            int i2 = R.id.view_bills_recent_transaction_v2;
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i2);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                ViewMyBillsRecentTransactionV2Binding authRequestContext = ViewMyBillsRecentTransactionV2Binding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                int i3 = R.id.view_discover_bills_service_v2;
                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i3);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    return new FragmentAddNewBillsBinding((ConstraintLayout) inflate, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, ViewDiscoverBillsServiceV2Binding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3));
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
