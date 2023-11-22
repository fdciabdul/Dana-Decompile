package id.dana.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PayerModelMapper_Factory implements Factory<PayerModelMapper> {
    public static PayerModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PayerModelMapper_Factory getAuthRequestContext = new PayerModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayerModelMapper();
    }
}
