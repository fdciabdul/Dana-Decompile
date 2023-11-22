package id.dana.data.shortener.repository.source;

import dagger.internal.Factory;
import id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UrlShortenerEntityDataFactory_Factory implements Factory<UrlShortenerEntityDataFactory> {
    private final Provider<NetworkUrlShortenerEntityData> networkUrlShortensEntityDataProvider;

    public UrlShortenerEntityDataFactory_Factory(Provider<NetworkUrlShortenerEntityData> provider) {
        this.networkUrlShortensEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UrlShortenerEntityDataFactory get() {
        return newInstance(this.networkUrlShortensEntityDataProvider.get());
    }

    public static UrlShortenerEntityDataFactory_Factory create(Provider<NetworkUrlShortenerEntityData> provider) {
        return new UrlShortenerEntityDataFactory_Factory(provider);
    }

    public static UrlShortenerEntityDataFactory newInstance(NetworkUrlShortenerEntityData networkUrlShortenerEntityData) {
        return new UrlShortenerEntityDataFactory(networkUrlShortenerEntityData);
    }
}
