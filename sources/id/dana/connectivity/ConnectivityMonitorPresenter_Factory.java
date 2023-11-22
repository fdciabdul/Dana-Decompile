package id.dana.connectivity;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.connectivity.ConnectivityMonitorContract;
import id.dana.domain.connectionbar.interactor.GetIsFeatureConnectionBarWithSignalOn;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConnectivityMonitorPresenter_Factory implements Factory<ConnectivityMonitorPresenter> {
    private final Provider<GetIsFeatureConnectionBarWithSignalOn> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConnectivityMonitorContract.View> getAuthRequestContext;

    private ConnectivityMonitorPresenter_Factory(Provider<ConnectivityMonitorContract.View> provider, Provider<GetIsFeatureConnectionBarWithSignalOn> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static ConnectivityMonitorPresenter_Factory MyBillsEntityDataFactory(Provider<ConnectivityMonitorContract.View> provider, Provider<GetIsFeatureConnectionBarWithSignalOn> provider2) {
        return new ConnectivityMonitorPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConnectivityMonitorPresenter(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
