package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SplitBillEncodeEntityMapper_Factory implements Factory<SplitBillEncodeEntityMapper> {
    @Override // javax.inject.Provider
    public final SplitBillEncodeEntityMapper get() {
        return newInstance();
    }

    public static SplitBillEncodeEntityMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static SplitBillEncodeEntityMapper newInstance() {
        return new SplitBillEncodeEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SplitBillEncodeEntityMapper_Factory BuiltInFictitiousFunctionClassFactory = new SplitBillEncodeEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
