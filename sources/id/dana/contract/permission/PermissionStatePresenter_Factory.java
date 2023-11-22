package id.dana.contract.permission;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PermissionStatePresenter_Factory implements Factory<PermissionStatePresenter> {
    private final Provider<CheckDeniedLocationPermission> MyBillsEntityDataFactory;
    private final Provider<SetDeniedLocationPermission> PlaceComponentResult;
    private final Provider<PermissionStateContract.View> getAuthRequestContext;

    private PermissionStatePresenter_Factory(Provider<PermissionStateContract.View> provider, Provider<SetDeniedLocationPermission> provider2, Provider<CheckDeniedLocationPermission> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static PermissionStatePresenter_Factory getAuthRequestContext(Provider<PermissionStateContract.View> provider, Provider<SetDeniedLocationPermission> provider2, Provider<CheckDeniedLocationPermission> provider3) {
        return new PermissionStatePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PermissionStatePresenter(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
