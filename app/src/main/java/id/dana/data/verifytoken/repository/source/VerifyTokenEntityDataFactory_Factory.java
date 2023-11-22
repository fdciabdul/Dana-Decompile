package id.dana.data.verifytoken.repository.source;

import dagger.internal.Factory;
import id.dana.data.verifytoken.repository.source.network.NetworkVerifyTokenEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class VerifyTokenEntityDataFactory_Factory implements Factory<VerifyTokenEntityDataFactory> {
    private final Provider<NetworkVerifyTokenEntityData> networkVerifyTokenEntityDataProvider;

    public VerifyTokenEntityDataFactory_Factory(Provider<NetworkVerifyTokenEntityData> provider) {
        this.networkVerifyTokenEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyTokenEntityDataFactory get() {
        return newInstance(this.networkVerifyTokenEntityDataProvider.get());
    }

    public static VerifyTokenEntityDataFactory_Factory create(Provider<NetworkVerifyTokenEntityData> provider) {
        return new VerifyTokenEntityDataFactory_Factory(provider);
    }

    public static VerifyTokenEntityDataFactory newInstance(NetworkVerifyTokenEntityData networkVerifyTokenEntityData) {
        return new VerifyTokenEntityDataFactory(networkVerifyTokenEntityData);
    }
}
