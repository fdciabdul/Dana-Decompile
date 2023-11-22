package id.dana.contract.permission;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.permission.PermissionStateContract;

/* loaded from: classes4.dex */
public final class PermissionStateModule_ProvideViewFactory implements Factory<PermissionStateContract.View> {
    private final PermissionStateModule PlaceComponentResult;

    private PermissionStateModule_ProvideViewFactory(PermissionStateModule permissionStateModule) {
        this.PlaceComponentResult = permissionStateModule;
    }

    public static PermissionStateModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(PermissionStateModule permissionStateModule) {
        return new PermissionStateModule_ProvideViewFactory(permissionStateModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PermissionStateContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult());
    }
}
