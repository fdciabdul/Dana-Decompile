package id.dana.data.recentbank.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RecentBankEntityMapper_Factory implements Factory<RecentBankEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentBankEntityMapper get() {
        return newInstance();
    }

    public static RecentBankEntityMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static RecentBankEntityMapper newInstance() {
        return new RecentBankEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RecentBankEntityMapper_Factory getAuthRequestContext = new RecentBankEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
