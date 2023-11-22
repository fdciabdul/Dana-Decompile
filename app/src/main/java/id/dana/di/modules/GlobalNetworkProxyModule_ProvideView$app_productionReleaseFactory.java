package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;

/* loaded from: classes2.dex */
public final class GlobalNetworkProxyModule_ProvideView$app_productionReleaseFactory implements Factory<GlobalNetworkProxyContract.View> {
    private final GlobalNetworkProxyModule MyBillsEntityDataFactory;

    private GlobalNetworkProxyModule_ProvideView$app_productionReleaseFactory(GlobalNetworkProxyModule globalNetworkProxyModule) {
        this.MyBillsEntityDataFactory = globalNetworkProxyModule;
    }

    public static GlobalNetworkProxyModule_ProvideView$app_productionReleaseFactory PlaceComponentResult(GlobalNetworkProxyModule globalNetworkProxyModule) {
        return new GlobalNetworkProxyModule_ProvideView$app_productionReleaseFactory(globalNetworkProxyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkProxyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory());
    }
}
