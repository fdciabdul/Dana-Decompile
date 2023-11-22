package id.dana.data.homeinfo.repository.source;

import dagger.internal.Factory;
import id.dana.data.homeinfo.repository.source.network.NetworkHomeEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeInfoEntityDataFactory_Factory implements Factory<HomeInfoEntityDataFactory> {
    private final Provider<NetworkHomeEntityData> networkHomeEntityDataProvider;

    public HomeInfoEntityDataFactory_Factory(Provider<NetworkHomeEntityData> provider) {
        this.networkHomeEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HomeInfoEntityDataFactory get() {
        return newInstance(this.networkHomeEntityDataProvider.get());
    }

    public static HomeInfoEntityDataFactory_Factory create(Provider<NetworkHomeEntityData> provider) {
        return new HomeInfoEntityDataFactory_Factory(provider);
    }

    public static HomeInfoEntityDataFactory newInstance(NetworkHomeEntityData networkHomeEntityData) {
        return new HomeInfoEntityDataFactory(networkHomeEntityData);
    }
}
