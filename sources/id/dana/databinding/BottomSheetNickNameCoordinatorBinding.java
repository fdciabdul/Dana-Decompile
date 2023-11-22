package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetNickNameCoordinatorBinding implements ViewBinding {
    public final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final BottomSheetNickNameBinding MyBillsEntityDataFactory;
    private final CoordinatorLayout getAuthRequestContext;

    private BottomSheetNickNameCoordinatorBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, BottomSheetNickNameBinding bottomSheetNickNameBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout2;
        this.MyBillsEntityDataFactory = bottomSheetNickNameBinding;
    }

    public static BottomSheetNickNameCoordinatorBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_nick_name_coordinator, (ViewGroup) null, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutBottomSheet);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new BottomSheetNickNameCoordinatorBinding(coordinatorLayout, coordinatorLayout, BottomSheetNickNameBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.layoutBottomSheet)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
