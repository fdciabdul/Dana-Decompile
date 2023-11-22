package id.dana.data.deeplink.repository.source;

import dagger.internal.Factory;
import id.dana.data.deeplink.repository.source.network.NetworkLinkApiEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LinkApiEntityDataFactory_Factory implements Factory<LinkApiEntityDataFactory> {
    private final Provider<NetworkLinkApiEntityData> networkLinkApiEntityDataProvider;

    public LinkApiEntityDataFactory_Factory(Provider<NetworkLinkApiEntityData> provider) {
        this.networkLinkApiEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LinkApiEntityDataFactory get() {
        return newInstance(this.networkLinkApiEntityDataProvider.get());
    }

    public static LinkApiEntityDataFactory_Factory create(Provider<NetworkLinkApiEntityData> provider) {
        return new LinkApiEntityDataFactory_Factory(provider);
    }

    public static LinkApiEntityDataFactory newInstance(NetworkLinkApiEntityData networkLinkApiEntityData) {
        return new LinkApiEntityDataFactory(networkLinkApiEntityData);
    }
}
