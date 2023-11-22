package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetActivityReactionsCoordinatorBinding implements ViewBinding {
    public final BottomSheetActivityReactionsBinding BuiltInFictitiousFunctionClassFactory;
    public final CoordinatorLayout MyBillsEntityDataFactory;
    private final CoordinatorLayout getAuthRequestContext;

    private BottomSheetActivityReactionsCoordinatorBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.MyBillsEntityDataFactory = coordinatorLayout2;
        this.BuiltInFictitiousFunctionClassFactory = bottomSheetActivityReactionsBinding;
    }

    public static BottomSheetActivityReactionsCoordinatorBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_activity_reactions_coordinator, (ViewGroup) null, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fl_bottom_sheet_activity_reactions);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new BottomSheetActivityReactionsCoordinatorBinding(coordinatorLayout, coordinatorLayout, BottomSheetActivityReactionsBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.fl_bottom_sheet_activity_reactions)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
