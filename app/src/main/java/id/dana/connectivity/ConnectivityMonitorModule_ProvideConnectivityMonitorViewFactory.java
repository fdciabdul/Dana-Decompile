package id.dana.connectivity;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.connectivity.ConnectivityMonitorContract;

/* loaded from: classes4.dex */
public final class ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory implements Factory<ConnectivityMonitorContract.View> {
    private final ConnectivityMonitorModule BuiltInFictitiousFunctionClassFactory;

    private ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory(ConnectivityMonitorModule connectivityMonitorModule) {
        this.BuiltInFictitiousFunctionClassFactory = connectivityMonitorModule;
    }

    public static ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory getAuthRequestContext(ConnectivityMonitorModule connectivityMonitorModule) {
        return new ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory(connectivityMonitorModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ConnectivityMonitorContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
