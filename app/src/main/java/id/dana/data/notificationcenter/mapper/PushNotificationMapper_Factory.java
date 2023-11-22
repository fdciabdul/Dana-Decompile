package id.dana.data.notificationcenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PushNotificationMapper_Factory implements Factory<PushNotificationMapper> {
    @Override // javax.inject.Provider
    public final PushNotificationMapper get() {
        return newInstance();
    }

    public static PushNotificationMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static PushNotificationMapper newInstance() {
        return new PushNotificationMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PushNotificationMapper_Factory PlaceComponentResult = new PushNotificationMapper_Factory();

        private InstanceHolder() {
        }
    }
}
