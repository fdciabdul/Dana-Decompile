package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityAddNewBillsBinding implements ViewBinding {
    public final ViewDiscoverBillsServiceBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutToolbarBinding MyBillsEntityDataFactory;
    public final ViewBillsRecentTransactionBinding PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ActivityAddNewBillsBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, ViewBillsRecentTransactionBinding viewBillsRecentTransactionBinding, ViewDiscoverBillsServiceBinding viewDiscoverBillsServiceBinding) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = layoutToolbarBinding;
        this.PlaceComponentResult = viewBillsRecentTransactionBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewDiscoverBillsServiceBinding;
    }

    public static ActivityAddNewBillsBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_add_new_bills, (ViewGroup) null, false);
        int i = R.id.layoutToolbar;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_bills_recent_transaction);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                ViewBillsRecentTransactionBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewBillsRecentTransactionBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_discover_bills_service);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    return new ActivityAddNewBillsBinding((ConstraintLayout) inflate, MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2, ViewDiscoverBillsServiceBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3));
                }
                i = R.id.view_discover_bills_service;
            } else {
                i = R.id.view_bills_recent_transaction;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
