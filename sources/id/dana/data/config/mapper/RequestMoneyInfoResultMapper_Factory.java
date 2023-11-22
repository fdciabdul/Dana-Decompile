package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RequestMoneyInfoResultMapper_Factory implements Factory<RequestMoneyInfoResultMapper> {
    @Override // javax.inject.Provider
    public final RequestMoneyInfoResultMapper get() {
        return newInstance();
    }

    public static RequestMoneyInfoResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static RequestMoneyInfoResultMapper newInstance() {
        return new RequestMoneyInfoResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RequestMoneyInfoResultMapper_Factory MyBillsEntityDataFactory = new RequestMoneyInfoResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
