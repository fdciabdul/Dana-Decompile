package id.dana.contract.maintenance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;

/* loaded from: classes4.dex */
public final class MaintenanceBroadcastModule_ProvideViewFactory implements Factory<MaintenanceBroadcastContract.View> {
    private final MaintenanceBroadcastModule KClassImpl$Data$declaredNonStaticMembers$2;

    private MaintenanceBroadcastModule_ProvideViewFactory(MaintenanceBroadcastModule maintenanceBroadcastModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = maintenanceBroadcastModule;
    }

    public static MaintenanceBroadcastModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(MaintenanceBroadcastModule maintenanceBroadcastModule) {
        return new MaintenanceBroadcastModule_ProvideViewFactory(maintenanceBroadcastModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MaintenanceBroadcastContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
    }
}
