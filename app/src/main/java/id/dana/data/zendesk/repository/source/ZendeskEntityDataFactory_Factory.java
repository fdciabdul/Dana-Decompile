package id.dana.data.zendesk.repository.source;

import dagger.internal.Factory;
import id.dana.data.zendesk.repository.source.network.NetworkZendeskEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ZendeskEntityDataFactory_Factory implements Factory<ZendeskEntityDataFactory> {
    private final Provider<NetworkZendeskEntityData> networkZendeskEntityDataProvider;

    public ZendeskEntityDataFactory_Factory(Provider<NetworkZendeskEntityData> provider) {
        this.networkZendeskEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ZendeskEntityDataFactory get() {
        return newInstance(this.networkZendeskEntityDataProvider.get());
    }

    public static ZendeskEntityDataFactory_Factory create(Provider<NetworkZendeskEntityData> provider) {
        return new ZendeskEntityDataFactory_Factory(provider);
    }

    public static ZendeskEntityDataFactory newInstance(NetworkZendeskEntityData networkZendeskEntityData) {
        return new ZendeskEntityDataFactory(networkZendeskEntityData);
    }
}
