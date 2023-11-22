package id.dana.notificationcenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class NotificationCenterMapper_Factory implements Factory<NotificationCenterMapper> {

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final NotificationCenterMapper_Factory MyBillsEntityDataFactory = new NotificationCenterMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NotificationCenterMapper();
    }
}
