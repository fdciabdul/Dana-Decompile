package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView;

/* loaded from: classes4.dex */
public final class ItemSwitchLocationPermissionBinding implements ViewBinding {
    private final SwitchLocationPermissionView MyBillsEntityDataFactory;
    public final SwitchLocationPermissionView getAuthRequestContext;

    private ItemSwitchLocationPermissionBinding(SwitchLocationPermissionView switchLocationPermissionView, SwitchLocationPermissionView switchLocationPermissionView2) {
        this.MyBillsEntityDataFactory = switchLocationPermissionView;
        this.getAuthRequestContext = switchLocationPermissionView2;
    }

    public static ItemSwitchLocationPermissionBinding PlaceComponentResult(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        SwitchLocationPermissionView switchLocationPermissionView = (SwitchLocationPermissionView) view;
        return new ItemSwitchLocationPermissionBinding(switchLocationPermissionView, switchLocationPermissionView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
