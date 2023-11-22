package id.dana.data.lazada.repository.source;

import dagger.internal.Factory;
import id.dana.data.lazada.repository.source.network.NetworkLazadaRegistrationUrlEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LazadaRegistrationUrlEntityDataFactory_Factory implements Factory<LazadaRegistrationUrlEntityDataFactory> {
    private final Provider<NetworkLazadaRegistrationUrlEntityData> networkLazadaRegistrationUrlEntityDataProvider;

    public LazadaRegistrationUrlEntityDataFactory_Factory(Provider<NetworkLazadaRegistrationUrlEntityData> provider) {
        this.networkLazadaRegistrationUrlEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LazadaRegistrationUrlEntityDataFactory get() {
        return newInstance(this.networkLazadaRegistrationUrlEntityDataProvider.get());
    }

    public static LazadaRegistrationUrlEntityDataFactory_Factory create(Provider<NetworkLazadaRegistrationUrlEntityData> provider) {
        return new LazadaRegistrationUrlEntityDataFactory_Factory(provider);
    }

    public static LazadaRegistrationUrlEntityDataFactory newInstance(NetworkLazadaRegistrationUrlEntityData networkLazadaRegistrationUrlEntityData) {
        return new LazadaRegistrationUrlEntityDataFactory(networkLazadaRegistrationUrlEntityData);
    }
}
