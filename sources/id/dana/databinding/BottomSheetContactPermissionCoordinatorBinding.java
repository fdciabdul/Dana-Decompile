package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetContactPermissionCoordinatorBinding implements ViewBinding {
    public final BottomSheetContactPermissionRequestBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final CoordinatorLayout MyBillsEntityDataFactory;
    private final CoordinatorLayout getAuthRequestContext;

    private BottomSheetContactPermissionCoordinatorBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, BottomSheetContactPermissionRequestBinding bottomSheetContactPermissionRequestBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.MyBillsEntityDataFactory = coordinatorLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetContactPermissionRequestBinding;
    }

    public static BottomSheetContactPermissionCoordinatorBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_contact_permission_coordinator, viewGroup, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutBottomSheetContactPermissionRequest);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new BottomSheetContactPermissionCoordinatorBinding(coordinatorLayout, coordinatorLayout, BottomSheetContactPermissionRequestBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.layoutBottomSheetContactPermissionRequest)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
