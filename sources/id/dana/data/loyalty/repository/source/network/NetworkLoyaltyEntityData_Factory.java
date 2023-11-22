package id.dana.data.loyalty.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkLoyaltyEntityData_Factory implements Factory<NetworkLoyaltyEntityData> {
    private final Provider<LoyaltyApi> loyaltyApiProvider;

    public NetworkLoyaltyEntityData_Factory(Provider<LoyaltyApi> provider) {
        this.loyaltyApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkLoyaltyEntityData get() {
        return newInstance(this.loyaltyApiProvider.get());
    }

    public static NetworkLoyaltyEntityData_Factory create(Provider<LoyaltyApi> provider) {
        return new NetworkLoyaltyEntityData_Factory(provider);
    }

    public static NetworkLoyaltyEntityData newInstance(LoyaltyApi loyaltyApi) {
        return new NetworkLoyaltyEntityData(loyaltyApi);
    }
}
