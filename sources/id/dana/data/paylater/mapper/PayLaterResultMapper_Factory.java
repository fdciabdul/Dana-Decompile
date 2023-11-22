package id.dana.data.paylater.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PayLaterResultMapper_Factory implements Factory<PayLaterResultMapper> {
    @Override // javax.inject.Provider
    public final PayLaterResultMapper get() {
        return newInstance();
    }

    public static PayLaterResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static PayLaterResultMapper newInstance() {
        return new PayLaterResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PayLaterResultMapper_Factory PlaceComponentResult = new PayLaterResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
