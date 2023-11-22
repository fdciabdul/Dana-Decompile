package id.dana.requestmoney.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class SplitBillRecentPayerMapper_Factory implements Factory<SplitBillRecentPayerMapper> {
    public static SplitBillRecentPayerMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final SplitBillRecentPayerMapper_Factory PlaceComponentResult = new SplitBillRecentPayerMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillRecentPayerMapper();
    }
}
