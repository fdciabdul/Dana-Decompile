package id.dana.data.here.source.network;

import dagger.internal.Factory;
import id.dana.data.here.HereOauthManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkHereLocationEntityData_Factory implements Factory<NetworkHereLocationEntityData> {
    private final Provider<HereAutosuggestApi> hereAutosuggestApiProvider;
    private final Provider<HereOauthManager> hereOauthManagerProvider;

    public NetworkHereLocationEntityData_Factory(Provider<HereAutosuggestApi> provider, Provider<HereOauthManager> provider2) {
        this.hereAutosuggestApiProvider = provider;
        this.hereOauthManagerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NetworkHereLocationEntityData get() {
        return newInstance(this.hereAutosuggestApiProvider.get(), this.hereOauthManagerProvider.get());
    }

    public static NetworkHereLocationEntityData_Factory create(Provider<HereAutosuggestApi> provider, Provider<HereOauthManager> provider2) {
        return new NetworkHereLocationEntityData_Factory(provider, provider2);
    }

    public static NetworkHereLocationEntityData newInstance(HereAutosuggestApi hereAutosuggestApi, HereOauthManager hereOauthManager) {
        return new NetworkHereLocationEntityData(hereAutosuggestApi, hereOauthManager);
    }
}
