package id.dana.data.homeinfo.repository.source;

import dagger.internal.Factory;
import id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeOmniEntityDataFactory_Factory implements Factory<HomeOmniEntityDataFactory> {
    private final Provider<NetworkHomeOmniEntityData> networkHomeOmniEntityDataProvider;

    public HomeOmniEntityDataFactory_Factory(Provider<NetworkHomeOmniEntityData> provider) {
        this.networkHomeOmniEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HomeOmniEntityDataFactory get() {
        return newInstance(this.networkHomeOmniEntityDataProvider.get());
    }

    public static HomeOmniEntityDataFactory_Factory create(Provider<NetworkHomeOmniEntityData> provider) {
        return new HomeOmniEntityDataFactory_Factory(provider);
    }

    public static HomeOmniEntityDataFactory newInstance(NetworkHomeOmniEntityData networkHomeOmniEntityData) {
        return new HomeOmniEntityDataFactory(networkHomeOmniEntityData);
    }
}
