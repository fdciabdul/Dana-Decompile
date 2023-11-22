package id.dana.data.promodiscovery.repository;

import dagger.internal.Factory;
import id.dana.data.promodiscovery.repository.source.local.LocalPromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.network.NetworkPromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.split.SplitPromoDiscoveryConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoDiscoveryEntityDataFactory_Factory implements Factory<PromoDiscoveryEntityDataFactory> {
    private final Provider<LocalPromoDiscoveryEntityData> localPromoDiscoveryEntityDataProvider;
    private final Provider<NetworkPromoDiscoveryEntityData> networkPromoDiscoveryEntityDataProvider;
    private final Provider<SplitPromoDiscoveryConfigEntityData> splitPromoDiscoveryConfigEntityDataProvider;

    public PromoDiscoveryEntityDataFactory_Factory(Provider<SplitPromoDiscoveryConfigEntityData> provider, Provider<NetworkPromoDiscoveryEntityData> provider2, Provider<LocalPromoDiscoveryEntityData> provider3) {
        this.splitPromoDiscoveryConfigEntityDataProvider = provider;
        this.networkPromoDiscoveryEntityDataProvider = provider2;
        this.localPromoDiscoveryEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PromoDiscoveryEntityDataFactory get() {
        return newInstance(this.splitPromoDiscoveryConfigEntityDataProvider.get(), this.networkPromoDiscoveryEntityDataProvider.get(), this.localPromoDiscoveryEntityDataProvider.get());
    }

    public static PromoDiscoveryEntityDataFactory_Factory create(Provider<SplitPromoDiscoveryConfigEntityData> provider, Provider<NetworkPromoDiscoveryEntityData> provider2, Provider<LocalPromoDiscoveryEntityData> provider3) {
        return new PromoDiscoveryEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static PromoDiscoveryEntityDataFactory newInstance(SplitPromoDiscoveryConfigEntityData splitPromoDiscoveryConfigEntityData, NetworkPromoDiscoveryEntityData networkPromoDiscoveryEntityData, LocalPromoDiscoveryEntityData localPromoDiscoveryEntityData) {
        return new PromoDiscoveryEntityDataFactory(splitPromoDiscoveryConfigEntityData, networkPromoDiscoveryEntityData, localPromoDiscoveryEntityData);
    }
}
