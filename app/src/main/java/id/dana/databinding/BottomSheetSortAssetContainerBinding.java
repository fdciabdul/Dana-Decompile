package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetSortAssetContainerBinding implements ViewBinding {
    private final CoordinatorLayout MyBillsEntityDataFactory;
    public final BottomSheetSortAssetBinding getAuthRequestContext;

    private BottomSheetSortAssetContainerBinding(CoordinatorLayout coordinatorLayout, BottomSheetSortAssetBinding bottomSheetSortAssetBinding) {
        this.MyBillsEntityDataFactory = coordinatorLayout;
        this.getAuthRequestContext = bottomSheetSortAssetBinding;
    }

    public static BottomSheetSortAssetContainerBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_sort_asset_container, (ViewGroup) null, false);
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new BottomSheetSortAssetContainerBinding((CoordinatorLayout) inflate, BottomSheetSortAssetBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.container)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
