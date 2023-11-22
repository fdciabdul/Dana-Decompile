package id.dana.data.notificationcenter.repository.source;

import dagger.internal.Factory;
import id.dana.data.notificationcenter.repository.source.network.NetworkPushNotificationEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushNotificationEntityDataFactory_Factory implements Factory<PushNotificationEntityDataFactory> {
    private final Provider<NetworkPushNotificationEntityData> networkPushNotificationEntityDataProvider;

    public PushNotificationEntityDataFactory_Factory(Provider<NetworkPushNotificationEntityData> provider) {
        this.networkPushNotificationEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PushNotificationEntityDataFactory get() {
        return newInstance(this.networkPushNotificationEntityDataProvider.get());
    }

    public static PushNotificationEntityDataFactory_Factory create(Provider<NetworkPushNotificationEntityData> provider) {
        return new PushNotificationEntityDataFactory_Factory(provider);
    }

    public static PushNotificationEntityDataFactory newInstance(NetworkPushNotificationEntityData networkPushNotificationEntityData) {
        return new PushNotificationEntityDataFactory(networkPushNotificationEntityData);
    }
}
