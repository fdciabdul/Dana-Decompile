package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MaintenanceBroadcastResultMapper_Factory implements Factory<MaintenanceBroadcastResultMapper> {
    @Override // javax.inject.Provider
    public final MaintenanceBroadcastResultMapper get() {
        return newInstance();
    }

    public static MaintenanceBroadcastResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static MaintenanceBroadcastResultMapper newInstance() {
        return new MaintenanceBroadcastResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MaintenanceBroadcastResultMapper_Factory getAuthRequestContext = new MaintenanceBroadcastResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
