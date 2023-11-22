package id.dana.connectivity;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.connectivity.ConnectivityMonitorContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory implements Factory<ConnectivityMonitorContract.Presenter> {
    private final ConnectivityMonitorModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConnectivityMonitorPresenter> MyBillsEntityDataFactory;

    private ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory(ConnectivityMonitorModule connectivityMonitorModule, Provider<ConnectivityMonitorPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = connectivityMonitorModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory MyBillsEntityDataFactory(ConnectivityMonitorModule connectivityMonitorModule, Provider<ConnectivityMonitorPresenter> provider) {
        return new ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory(connectivityMonitorModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ConnectivityMonitorContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
