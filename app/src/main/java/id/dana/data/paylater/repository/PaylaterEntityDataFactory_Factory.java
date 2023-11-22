package id.dana.data.paylater.repository;

import dagger.internal.Factory;
import id.dana.data.paylater.repository.source.local.LocalPaylaterEntityData;
import id.dana.data.paylater.repository.source.network.NetworkPaylaterEntityData;
import id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaylaterEntityDataFactory_Factory implements Factory<PaylaterEntityDataFactory> {
    private final Provider<LocalPaylaterEntityData> localPaylaterEntityDataProvider;
    private final Provider<NetworkPaylaterEntityData> networkPaylaterEntityDataProvider;
    private final Provider<SplitPaylaterEntityData> splitPaylaterEntityDataProvider;

    public PaylaterEntityDataFactory_Factory(Provider<NetworkPaylaterEntityData> provider, Provider<LocalPaylaterEntityData> provider2, Provider<SplitPaylaterEntityData> provider3) {
        this.networkPaylaterEntityDataProvider = provider;
        this.localPaylaterEntityDataProvider = provider2;
        this.splitPaylaterEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PaylaterEntityDataFactory get() {
        return newInstance(this.networkPaylaterEntityDataProvider.get(), this.localPaylaterEntityDataProvider.get(), this.splitPaylaterEntityDataProvider.get());
    }

    public static PaylaterEntityDataFactory_Factory create(Provider<NetworkPaylaterEntityData> provider, Provider<LocalPaylaterEntityData> provider2, Provider<SplitPaylaterEntityData> provider3) {
        return new PaylaterEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static PaylaterEntityDataFactory newInstance(NetworkPaylaterEntityData networkPaylaterEntityData, LocalPaylaterEntityData localPaylaterEntityData, SplitPaylaterEntityData splitPaylaterEntityData) {
        return new PaylaterEntityDataFactory(networkPaylaterEntityData, localPaylaterEntityData, splitPaylaterEntityData);
    }
}
