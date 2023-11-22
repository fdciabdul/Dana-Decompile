package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SplitBillHistoriesMapper_Factory implements Factory<SplitBillHistoriesMapper> {
    @Override // javax.inject.Provider
    public final SplitBillHistoriesMapper get() {
        return newInstance();
    }

    public static SplitBillHistoriesMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static SplitBillHistoriesMapper newInstance() {
        return new SplitBillHistoriesMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SplitBillHistoriesMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new SplitBillHistoriesMapper_Factory();

        private InstanceHolder() {
        }
    }
}
