package id.dana.contract.maintenance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MaintenanceBroadcastModule_ProvidePresenterFactory implements Factory<MaintenanceBroadcastContract.Presenter> {
    private final Provider<MaintenanceBroadcastPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MaintenanceBroadcastModule MyBillsEntityDataFactory;

    private MaintenanceBroadcastModule_ProvidePresenterFactory(MaintenanceBroadcastModule maintenanceBroadcastModule, Provider<MaintenanceBroadcastPresenter> provider) {
        this.MyBillsEntityDataFactory = maintenanceBroadcastModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MaintenanceBroadcastModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(MaintenanceBroadcastModule maintenanceBroadcastModule, Provider<MaintenanceBroadcastPresenter> provider) {
        return new MaintenanceBroadcastModule_ProvidePresenterFactory(maintenanceBroadcastModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MaintenanceBroadcastContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
