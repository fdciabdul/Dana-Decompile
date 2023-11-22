package id.dana.data.lazada.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class LazadaRegistrationUrlMapper_Factory implements Factory<LazadaRegistrationUrlMapper> {
    @Override // javax.inject.Provider
    public final LazadaRegistrationUrlMapper get() {
        return newInstance();
    }

    public static LazadaRegistrationUrlMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static LazadaRegistrationUrlMapper newInstance() {
        return new LazadaRegistrationUrlMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final LazadaRegistrationUrlMapper_Factory PlaceComponentResult = new LazadaRegistrationUrlMapper_Factory();

        private InstanceHolder() {
        }
    }
}
