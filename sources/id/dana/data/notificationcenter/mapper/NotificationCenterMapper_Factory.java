package id.dana.data.notificationcenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class NotificationCenterMapper_Factory implements Factory<NotificationCenterMapper> {
    @Override // javax.inject.Provider
    public final NotificationCenterMapper get() {
        return newInstance();
    }

    public static NotificationCenterMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static NotificationCenterMapper newInstance() {
        return new NotificationCenterMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final NotificationCenterMapper_Factory BuiltInFictitiousFunctionClassFactory = new NotificationCenterMapper_Factory();

        private InstanceHolder() {
        }
    }
}
