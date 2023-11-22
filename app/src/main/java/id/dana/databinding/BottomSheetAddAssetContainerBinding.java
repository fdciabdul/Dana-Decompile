package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetAddAssetContainerBinding implements ViewBinding {
    public final BottomSheetAddAssetBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final CoordinatorLayout getAuthRequestContext;

    private BottomSheetAddAssetContainerBinding(CoordinatorLayout coordinatorLayout, BottomSheetAddAssetBinding bottomSheetAddAssetBinding) {
        this.getAuthRequestContext = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetAddAssetBinding;
    }

    public static BottomSheetAddAssetContainerBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_add_asset_container, (ViewGroup) null, false);
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.content);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new BottomSheetAddAssetContainerBinding((CoordinatorLayout) inflate, BottomSheetAddAssetBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.content)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
