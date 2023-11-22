package id.dana.data.loyalty.repository.source;

import dagger.internal.Factory;
import id.dana.data.loyalty.repository.source.local.LocalLoyaltyEntityData;
import id.dana.data.loyalty.repository.source.network.NetworkLoyaltyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LoyaltyEntityDataFactory_Factory implements Factory<LoyaltyEntityDataFactory> {
    private final Provider<LocalLoyaltyEntityData> localLoyaltyEntityDataProvider;
    private final Provider<NetworkLoyaltyEntityData> networkLoyaltyEntityDataProvider;

    public LoyaltyEntityDataFactory_Factory(Provider<NetworkLoyaltyEntityData> provider, Provider<LocalLoyaltyEntityData> provider2) {
        this.networkLoyaltyEntityDataProvider = provider;
        this.localLoyaltyEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LoyaltyEntityDataFactory get() {
        return newInstance(this.networkLoyaltyEntityDataProvider.get(), this.localLoyaltyEntityDataProvider.get());
    }

    public static LoyaltyEntityDataFactory_Factory create(Provider<NetworkLoyaltyEntityData> provider, Provider<LocalLoyaltyEntityData> provider2) {
        return new LoyaltyEntityDataFactory_Factory(provider, provider2);
    }

    public static LoyaltyEntityDataFactory newInstance(NetworkLoyaltyEntityData networkLoyaltyEntityData, LocalLoyaltyEntityData localLoyaltyEntityData) {
        return new LoyaltyEntityDataFactory(networkLoyaltyEntityData, localLoyaltyEntityData);
    }
}
