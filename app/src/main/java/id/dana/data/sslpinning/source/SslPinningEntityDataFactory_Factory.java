package id.dana.data.sslpinning.source;

import dagger.internal.Factory;
import id.dana.data.sslpinning.source.remote.RemoteSslPinningEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SslPinningEntityDataFactory_Factory implements Factory<SslPinningEntityDataFactory> {
    private final Provider<RemoteSslPinningEntityData> remoteSslPinningEntityDataProvider;

    public SslPinningEntityDataFactory_Factory(Provider<RemoteSslPinningEntityData> provider) {
        this.remoteSslPinningEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SslPinningEntityDataFactory get() {
        return newInstance(this.remoteSslPinningEntityDataProvider.get());
    }

    public static SslPinningEntityDataFactory_Factory create(Provider<RemoteSslPinningEntityData> provider) {
        return new SslPinningEntityDataFactory_Factory(provider);
    }

    public static SslPinningEntityDataFactory newInstance(RemoteSslPinningEntityData remoteSslPinningEntityData) {
        return new SslPinningEntityDataFactory(remoteSslPinningEntityData);
    }
}
