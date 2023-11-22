package id.dana.contract.permission;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.permission.PermissionStateContract;

@Module
/* loaded from: classes4.dex */
public class PermissionStateModule {
    private final PermissionStateContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PermissionStateContract.Presenter getAuthRequestContext(PermissionStatePresenter permissionStatePresenter) {
        return permissionStatePresenter;
    }

    public PermissionStateModule(PermissionStateContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PermissionStateContract.View PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
