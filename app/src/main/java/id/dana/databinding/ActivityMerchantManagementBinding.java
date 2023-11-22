package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.merchantmanagement.view.richview.ErrorLinkedMerchantListView;

/* loaded from: classes4.dex */
public final class ActivityMerchantManagementBinding implements ViewBinding {
    public final ViewEmptyMerchantListBinding BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutToolbarBinding MyBillsEntityDataFactory;
    public final ErrorLinkedMerchantListView PlaceComponentResult;
    public final ViewCustomSnackbarForUnbindBinding getAuthRequestContext;
    public final ViewLinkedMerchantsBinding getErrorConfigVersion;
    private final ConstraintLayout scheduleImpl;

    private ActivityMerchantManagementBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ErrorLinkedMerchantListView errorLinkedMerchantListView, LayoutToolbarBinding layoutToolbarBinding, ViewCustomSnackbarForUnbindBinding viewCustomSnackbarForUnbindBinding, ViewEmptyMerchantListBinding viewEmptyMerchantListBinding, ViewLinkedMerchantsBinding viewLinkedMerchantsBinding) {
        this.scheduleImpl = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = errorLinkedMerchantListView;
        this.MyBillsEntityDataFactory = layoutToolbarBinding;
        this.getAuthRequestContext = viewCustomSnackbarForUnbindBinding;
        this.BuiltInFictitiousFunctionClassFactory = viewEmptyMerchantListBinding;
        this.getErrorConfigVersion = viewLinkedMerchantsBinding;
    }

    public static ActivityMerchantManagementBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_merchant_management, (ViewGroup) null, false);
        int i = R.id.containerLinkedAccounts;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.containerLinkedAccounts);
        if (constraintLayout != null) {
            ErrorLinkedMerchantListView errorLinkedMerchantListView = (ErrorLinkedMerchantListView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.elmlvErrorGetMerchantList);
            if (errorLinkedMerchantListView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewCustomSnackbar);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        ViewCustomSnackbarForUnbindBinding authRequestContext = ViewCustomSnackbarForUnbindBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewEmptyMerchantList);
                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                            ViewEmptyMerchantListBinding BuiltInFictitiousFunctionClassFactory4 = ViewEmptyMerchantListBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3);
                            View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewMerchantList);
                            if (BuiltInFictitiousFunctionClassFactory5 != null) {
                                return new ActivityMerchantManagementBinding((ConstraintLayout) inflate, constraintLayout, errorLinkedMerchantListView, MyBillsEntityDataFactory, authRequestContext, BuiltInFictitiousFunctionClassFactory4, ViewLinkedMerchantsBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory5));
                            }
                            i = R.id.viewMerchantList;
                        } else {
                            i = R.id.viewEmptyMerchantList;
                        }
                    } else {
                        i = R.id.viewCustomSnackbar;
                    }
                } else {
                    i = R.id.SecurityGuardProfileProvider;
                }
            } else {
                i = R.id.elmlvErrorGetMerchantList;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
