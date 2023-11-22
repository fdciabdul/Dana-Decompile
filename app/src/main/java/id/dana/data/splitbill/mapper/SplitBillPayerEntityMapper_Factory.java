package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SplitBillPayerEntityMapper_Factory implements Factory<SplitBillPayerEntityMapper> {
    @Override // javax.inject.Provider
    public final SplitBillPayerEntityMapper get() {
        return newInstance();
    }

    public static SplitBillPayerEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static SplitBillPayerEntityMapper newInstance() {
        return new SplitBillPayerEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SplitBillPayerEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new SplitBillPayerEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
