package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RecentRecipientPayerEntityMapper_Factory implements Factory<RecentRecipientPayerEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentRecipientPayerEntityMapper get() {
        return newInstance();
    }

    public static RecentRecipientPayerEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static RecentRecipientPayerEntityMapper newInstance() {
        return new RecentRecipientPayerEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RecentRecipientPayerEntityMapper_Factory PlaceComponentResult = new RecentRecipientPayerEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
