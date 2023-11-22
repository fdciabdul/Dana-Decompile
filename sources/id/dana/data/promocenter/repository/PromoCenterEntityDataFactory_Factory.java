package id.dana.data.promocenter.repository;

import dagger.internal.Factory;
import id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData;
import id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoCenterEntityDataFactory_Factory implements Factory<PromoCenterEntityDataFactory> {
    private final Provider<LocalPromoCenterEntityData> localPromoCenterEntityDataProvider;
    private final Provider<NetworkPromoCenterEntityData> networkPromoCenterEntityDataProvider;

    public PromoCenterEntityDataFactory_Factory(Provider<NetworkPromoCenterEntityData> provider, Provider<LocalPromoCenterEntityData> provider2) {
        this.networkPromoCenterEntityDataProvider = provider;
        this.localPromoCenterEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PromoCenterEntityDataFactory get() {
        return newInstance(this.networkPromoCenterEntityDataProvider.get(), this.localPromoCenterEntityDataProvider.get());
    }

    public static PromoCenterEntityDataFactory_Factory create(Provider<NetworkPromoCenterEntityData> provider, Provider<LocalPromoCenterEntityData> provider2) {
        return new PromoCenterEntityDataFactory_Factory(provider, provider2);
    }

    public static PromoCenterEntityDataFactory newInstance(NetworkPromoCenterEntityData networkPromoCenterEntityData, LocalPromoCenterEntityData localPromoCenterEntityData) {
        return new PromoCenterEntityDataFactory(networkPromoCenterEntityData, localPromoCenterEntityData);
    }
}
