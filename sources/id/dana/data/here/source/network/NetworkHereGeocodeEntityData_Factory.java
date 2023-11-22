package id.dana.data.here.source.network;

import dagger.internal.Factory;
import id.dana.data.here.HereOauthManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkHereGeocodeEntityData_Factory implements Factory<NetworkHereGeocodeEntityData> {
    private final Provider<HereGeocodeApi> geocodeApiProvider;
    private final Provider<HereOauthManager> oauthManagerProvider;

    public NetworkHereGeocodeEntityData_Factory(Provider<HereGeocodeApi> provider, Provider<HereOauthManager> provider2) {
        this.geocodeApiProvider = provider;
        this.oauthManagerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NetworkHereGeocodeEntityData get() {
        return newInstance(this.geocodeApiProvider.get(), this.oauthManagerProvider.get());
    }

    public static NetworkHereGeocodeEntityData_Factory create(Provider<HereGeocodeApi> provider, Provider<HereOauthManager> provider2) {
        return new NetworkHereGeocodeEntityData_Factory(provider, provider2);
    }

    public static NetworkHereGeocodeEntityData newInstance(HereGeocodeApi hereGeocodeApi, HereOauthManager hereOauthManager) {
        return new NetworkHereGeocodeEntityData(hereGeocodeApi, hereOauthManager);
    }
}
