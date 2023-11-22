package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CreateOrderInfoRequestMapper_Factory implements Factory<CreateOrderInfoRequestMapper> {
    @Override // javax.inject.Provider
    public final CreateOrderInfoRequestMapper get() {
        return newInstance();
    }

    public static CreateOrderInfoRequestMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static CreateOrderInfoRequestMapper newInstance() {
        return new CreateOrderInfoRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CreateOrderInfoRequestMapper_Factory getAuthRequestContext = new CreateOrderInfoRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
