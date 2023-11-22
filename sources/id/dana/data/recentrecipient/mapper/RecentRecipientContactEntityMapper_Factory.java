package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RecentRecipientContactEntityMapper_Factory implements Factory<RecentRecipientContactEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentRecipientContactEntityMapper get() {
        return newInstance();
    }

    public static RecentRecipientContactEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static RecentRecipientContactEntityMapper newInstance() {
        return new RecentRecipientContactEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RecentRecipientContactEntityMapper_Factory PlaceComponentResult = new RecentRecipientContactEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
