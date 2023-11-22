package id.dana.data.zendesk.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkZendeskEntityData_Factory implements Factory<NetworkZendeskEntityData> {
    private final Provider<ZendeskApi> zendeskApiProvider;

    public NetworkZendeskEntityData_Factory(Provider<ZendeskApi> provider) {
        this.zendeskApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkZendeskEntityData get() {
        return newInstance(this.zendeskApiProvider.get());
    }

    public static NetworkZendeskEntityData_Factory create(Provider<ZendeskApi> provider) {
        return new NetworkZendeskEntityData_Factory(provider);
    }

    public static NetworkZendeskEntityData newInstance(ZendeskApi zendeskApi) {
        return new NetworkZendeskEntityData(zendeskApi);
    }
}
