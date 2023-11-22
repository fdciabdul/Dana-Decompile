package id.dana.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class SplitBillPayerToPayerModelMapper_Factory implements Factory<SplitBillPayerToPayerModelMapper> {

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final SplitBillPayerToPayerModelMapper_Factory MyBillsEntityDataFactory = new SplitBillPayerToPayerModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillPayerToPayerModelMapper();
    }
}
