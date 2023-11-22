package id.dana.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class SplitBillPayerListMapper_Factory implements Factory<SplitBillPayerListMapper> {

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final SplitBillPayerListMapper_Factory getAuthRequestContext = new SplitBillPayerListMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillPayerListMapper();
    }
}
