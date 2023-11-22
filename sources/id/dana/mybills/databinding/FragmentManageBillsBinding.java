package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class FragmentManageBillsBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final ViewErrorBillsBinding KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final NestedScrollView PlaceComponentResult;
    public final MyBillsToolbarLayoutBinding getAuthRequestContext;

    private FragmentManageBillsBinding(ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, RecyclerView recyclerView, MyBillsToolbarLayoutBinding myBillsToolbarLayoutBinding, ViewErrorBillsBinding viewErrorBillsBinding) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = nestedScrollView;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.getAuthRequestContext = myBillsToolbarLayoutBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewErrorBillsBinding;
    }

    public static FragmentManageBillsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01de_networkuserentitydata_externalsyntheticlambda0, viewGroup, false);
        int i = R.id.nsvBillsTransactions;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (nestedScrollView != null) {
            i = R.id.rvManageBills;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (recyclerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter))) != null) {
                MyBillsToolbarLayoutBinding KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsToolbarLayoutBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                i = R.id.viewErrorStateBill;
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    return new FragmentManageBillsBinding((ConstraintLayout) inflate, nestedScrollView, recyclerView, KClassImpl$Data$declaredNonStaticMembers$2, ViewErrorBillsBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
