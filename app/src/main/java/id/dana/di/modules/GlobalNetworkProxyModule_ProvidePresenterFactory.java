package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;
import id.dana.globalnetworkproxy.GlobalNetworkProxyPresenter;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalNetworkProxyModule_ProvidePresenterFactory implements Factory<GlobalNetworkProxyContract.Presenter> {
    private final Provider<GlobalNetworkProxyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final GlobalNetworkProxyModule PlaceComponentResult;

    private GlobalNetworkProxyModule_ProvidePresenterFactory(GlobalNetworkProxyModule globalNetworkProxyModule, Provider<GlobalNetworkProxyPresenter> provider) {
        this.PlaceComponentResult = globalNetworkProxyModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GlobalNetworkProxyModule_ProvidePresenterFactory getAuthRequestContext(GlobalNetworkProxyModule globalNetworkProxyModule, Provider<GlobalNetworkProxyPresenter> provider) {
        return new GlobalNetworkProxyModule_ProvidePresenterFactory(globalNetworkProxyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkProxyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
