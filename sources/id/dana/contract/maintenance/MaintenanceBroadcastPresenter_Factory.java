package id.dana.contract.maintenance;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import id.dana.domain.maintenance.interactor.ObserveMaintenanceBroadcast;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MaintenanceBroadcastPresenter_Factory implements Factory<MaintenanceBroadcastPresenter> {
    private final Provider<MaintenanceBroadcastContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ObserveMaintenanceBroadcast> PlaceComponentResult;

    private MaintenanceBroadcastPresenter_Factory(Provider<MaintenanceBroadcastContract.View> provider, Provider<ObserveMaintenanceBroadcast> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static MaintenanceBroadcastPresenter_Factory getAuthRequestContext(Provider<MaintenanceBroadcastContract.View> provider, Provider<ObserveMaintenanceBroadcast> provider2) {
        return new MaintenanceBroadcastPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MaintenanceBroadcastPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
