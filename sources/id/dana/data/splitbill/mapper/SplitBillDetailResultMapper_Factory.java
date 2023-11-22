package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SplitBillDetailResultMapper_Factory implements Factory<SplitBillDetailResultMapper> {
    @Override // javax.inject.Provider
    public final SplitBillDetailResultMapper get() {
        return newInstance();
    }

    public static SplitBillDetailResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static SplitBillDetailResultMapper newInstance() {
        return new SplitBillDetailResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SplitBillDetailResultMapper_Factory MyBillsEntityDataFactory = new SplitBillDetailResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
