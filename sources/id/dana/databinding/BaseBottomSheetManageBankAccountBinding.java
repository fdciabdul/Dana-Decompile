package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BaseBottomSheetManageBankAccountBinding implements ViewBinding {
    public final ViewBottomSheetManageBankAccountBinding BuiltInFictitiousFunctionClassFactory;
    private final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewBottomSheetRenameBankAccountBinding MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;
    public final CoordinatorLayout getAuthRequestContext;

    private BaseBottomSheetManageBankAccountBinding(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout2, ViewBottomSheetManageBankAccountBinding viewBottomSheetManageBankAccountBinding, ViewBottomSheetRenameBankAccountBinding viewBottomSheetRenameBankAccountBinding) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout;
        this.PlaceComponentResult = frameLayout;
        this.getAuthRequestContext = coordinatorLayout2;
        this.BuiltInFictitiousFunctionClassFactory = viewBottomSheetManageBankAccountBinding;
        this.MyBillsEntityDataFactory = viewBottomSheetRenameBankAccountBinding;
    }

    public static BaseBottomSheetManageBankAccountBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.base_bottom_sheet_manage_bank_account, (ViewGroup) null, false);
        int i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
        if (frameLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSheetManageBankAccount);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewBottomSheetManageBankAccountBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewBottomSheetManageBankAccountBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSheetRenameBankAccount);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    return new BaseBottomSheetManageBankAccountBinding(coordinatorLayout, frameLayout, coordinatorLayout, KClassImpl$Data$declaredNonStaticMembers$2, ViewBottomSheetRenameBankAccountBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2));
                }
                i = R.id.viewSheetRenameBankAccount;
            } else {
                i = R.id.viewSheetManageBankAccount;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
