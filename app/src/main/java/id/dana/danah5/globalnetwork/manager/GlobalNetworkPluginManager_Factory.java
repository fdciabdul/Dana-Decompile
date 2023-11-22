package id.dana.danah5.globalnetwork.manager;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.interactor.GetForex;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GlobalNetworkPluginManager_Factory implements Factory<GlobalNetworkPluginManager> {
    private final Provider<GetForex> getForexProvider;
    private final Provider<GetRealTimeForex> getRealTimeForexProvider;
    private final Provider<GetSelectedCountryCode> getSelectedCountryCodeProvider;

    public GlobalNetworkPluginManager_Factory(Provider<GetSelectedCountryCode> provider, Provider<GetForex> provider2, Provider<GetRealTimeForex> provider3) {
        this.getSelectedCountryCodeProvider = provider;
        this.getForexProvider = provider2;
        this.getRealTimeForexProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GlobalNetworkPluginManager get() {
        return newInstance(this.getSelectedCountryCodeProvider.get(), this.getForexProvider.get(), this.getRealTimeForexProvider.get());
    }

    public static GlobalNetworkPluginManager_Factory create(Provider<GetSelectedCountryCode> provider, Provider<GetForex> provider2, Provider<GetRealTimeForex> provider3) {
        return new GlobalNetworkPluginManager_Factory(provider, provider2, provider3);
    }

    public static GlobalNetworkPluginManager newInstance(GetSelectedCountryCode getSelectedCountryCode, GetForex getForex, GetRealTimeForex getRealTimeForex) {
        return new GlobalNetworkPluginManager(getSelectedCountryCode, getForex, getRealTimeForex);
    }
}
