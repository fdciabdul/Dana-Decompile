package id.dana.contract.permission;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.permission.PermissionStateContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PermissionStateModule_ProvidePresenterFactory implements Factory<PermissionStateContract.Presenter> {
    private final Provider<PermissionStatePresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PermissionStateModule PlaceComponentResult;

    private PermissionStateModule_ProvidePresenterFactory(PermissionStateModule permissionStateModule, Provider<PermissionStatePresenter> provider) {
        this.PlaceComponentResult = permissionStateModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PermissionStateModule_ProvidePresenterFactory PlaceComponentResult(PermissionStateModule permissionStateModule, Provider<PermissionStatePresenter> provider) {
        return new PermissionStateModule_ProvidePresenterFactory(permissionStateModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PermissionStateContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
