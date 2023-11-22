package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager;
import id.dana.domain.globalnetwork.interactor.GetForex;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideGlobalNetworkManagerFactory implements Factory<GlobalNetworkPluginManager> {
    private final Provider<GetRealTimeForex> BuiltInFictitiousFunctionClassFactory;
    private final GContainerModule MyBillsEntityDataFactory;
    private final Provider<GetForex> PlaceComponentResult;
    private final Provider<GetSelectedCountryCode> getAuthRequestContext;

    private GContainerModule_ProvideGlobalNetworkManagerFactory(GContainerModule gContainerModule, Provider<GetSelectedCountryCode> provider, Provider<GetForex> provider2, Provider<GetRealTimeForex> provider3) {
        this.MyBillsEntityDataFactory = gContainerModule;
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static GContainerModule_ProvideGlobalNetworkManagerFactory getAuthRequestContext(GContainerModule gContainerModule, Provider<GetSelectedCountryCode> provider, Provider<GetForex> provider2, Provider<GetRealTimeForex> provider3) {
        return new GContainerModule_ProvideGlobalNetworkManagerFactory(gContainerModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkPluginManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
