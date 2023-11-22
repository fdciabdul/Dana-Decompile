package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes8.dex */
public final class RecentRecipientBankEntityMapper_Factory implements Factory<RecentRecipientBankEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentRecipientBankEntityMapper get() {
        return newInstance();
    }

    public static RecentRecipientBankEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static RecentRecipientBankEntityMapper newInstance() {
        return new RecentRecipientBankEntityMapper();
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final RecentRecipientBankEntityMapper_Factory PlaceComponentResult = new RecentRecipientBankEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
