package id.dana.globalnetworkproxy;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetGlobalNetworkProxyConfig;
import id.dana.domain.globalnetwork.interactor.GnConsult;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalNetworkProxyPresenter_Factory implements Factory<GlobalNetworkProxyPresenter> {
    private final Provider<GetGlobalNetworkProxyConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GnConsult> MyBillsEntityDataFactory;
    private final Provider<GlobalNetworkProxyContract.View> PlaceComponentResult;

    private GlobalNetworkProxyPresenter_Factory(Provider<GlobalNetworkProxyContract.View> provider, Provider<GnConsult> provider2, Provider<GetGlobalNetworkProxyConfig> provider3) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static GlobalNetworkProxyPresenter_Factory MyBillsEntityDataFactory(Provider<GlobalNetworkProxyContract.View> provider, Provider<GnConsult> provider2, Provider<GetGlobalNetworkProxyConfig> provider3) {
        return new GlobalNetworkProxyPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalNetworkProxyPresenter(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
