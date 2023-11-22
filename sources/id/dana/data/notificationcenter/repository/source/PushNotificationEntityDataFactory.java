package id.dana.data.notificationcenter.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.notificationcenter.repository.source.network.NetworkPushNotificationEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PushNotificationEntityDataFactory extends AbstractEntityDataFactory<PushNotificationEntityData> {
    private final NetworkPushNotificationEntityData networkPushNotificationEntityData;

    @Inject
    public PushNotificationEntityDataFactory(NetworkPushNotificationEntityData networkPushNotificationEntityData) {
        this.networkPushNotificationEntityData = networkPushNotificationEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PushNotificationEntityData createData2(String str) {
        return this.networkPushNotificationEntityData;
    }
}
