package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PayOptionsResultMapper_Factory implements Factory<PayOptionsResultMapper> {
    @Override // javax.inject.Provider
    public final PayOptionsResultMapper get() {
        return newInstance();
    }

    public static PayOptionsResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static PayOptionsResultMapper newInstance() {
        return new PayOptionsResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PayOptionsResultMapper_Factory PlaceComponentResult = new PayOptionsResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
