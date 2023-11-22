package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CreateOrderInfoResultMapper_Factory implements Factory<CreateOrderInfoResultMapper> {
    @Override // javax.inject.Provider
    public final CreateOrderInfoResultMapper get() {
        return newInstance();
    }

    public static CreateOrderInfoResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static CreateOrderInfoResultMapper newInstance() {
        return new CreateOrderInfoResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CreateOrderInfoResultMapper_Factory MyBillsEntityDataFactory = new CreateOrderInfoResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
