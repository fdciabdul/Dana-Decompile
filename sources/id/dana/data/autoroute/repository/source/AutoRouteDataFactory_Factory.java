package id.dana.data.autoroute.repository.source;

import dagger.internal.Factory;
import id.dana.data.autoroute.repository.source.mock.MockAutoRouteEntityData;
import id.dana.data.autoroute.repository.source.network.NetworkAutoRouteEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AutoRouteDataFactory_Factory implements Factory<AutoRouteDataFactory> {
    private final Provider<MockAutoRouteEntityData> mockAutoRouteEntityDataProvider;
    private final Provider<NetworkAutoRouteEntityData> networkAutoRouteEntityDataProvider;

    public AutoRouteDataFactory_Factory(Provider<NetworkAutoRouteEntityData> provider, Provider<MockAutoRouteEntityData> provider2) {
        this.networkAutoRouteEntityDataProvider = provider;
        this.mockAutoRouteEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AutoRouteDataFactory get() {
        return newInstance(this.networkAutoRouteEntityDataProvider.get(), this.mockAutoRouteEntityDataProvider.get());
    }

    public static AutoRouteDataFactory_Factory create(Provider<NetworkAutoRouteEntityData> provider, Provider<MockAutoRouteEntityData> provider2) {
        return new AutoRouteDataFactory_Factory(provider, provider2);
    }

    public static AutoRouteDataFactory newInstance(NetworkAutoRouteEntityData networkAutoRouteEntityData, MockAutoRouteEntityData mockAutoRouteEntityData) {
        return new AutoRouteDataFactory(networkAutoRouteEntityData, mockAutoRouteEntityData);
    }
}
