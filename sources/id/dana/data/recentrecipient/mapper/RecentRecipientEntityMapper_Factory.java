package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RecentRecipientEntityMapper_Factory implements Factory<RecentRecipientEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentRecipientEntityMapper get() {
        return newInstance();
    }

    public static RecentRecipientEntityMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static RecentRecipientEntityMapper newInstance() {
        return new RecentRecipientEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RecentRecipientEntityMapper_Factory MyBillsEntityDataFactory = new RecentRecipientEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
