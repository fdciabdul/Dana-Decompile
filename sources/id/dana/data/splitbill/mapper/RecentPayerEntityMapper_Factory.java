package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RecentPayerEntityMapper_Factory implements Factory<RecentPayerEntityMapper> {
    @Override // javax.inject.Provider
    public final RecentPayerEntityMapper get() {
        return newInstance();
    }

    public static RecentPayerEntityMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static RecentPayerEntityMapper newInstance() {
        return new RecentPayerEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RecentPayerEntityMapper_Factory MyBillsEntityDataFactory = new RecentPayerEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
