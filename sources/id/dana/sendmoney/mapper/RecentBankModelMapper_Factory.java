package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class RecentBankModelMapper_Factory implements Factory<RecentBankModelMapper> {
    public static RecentBankModelMapper_Factory PlaceComponentResult() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final RecentBankModelMapper_Factory getAuthRequestContext = new RecentBankModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecentBankModelMapper();
    }
}
