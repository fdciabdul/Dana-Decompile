package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ExpiryInfoResultMapper_Factory implements Factory<ExpiryInfoResultMapper> {
    @Override // javax.inject.Provider
    public final ExpiryInfoResultMapper get() {
        return newInstance();
    }

    public static ExpiryInfoResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static ExpiryInfoResultMapper newInstance() {
        return new ExpiryInfoResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ExpiryInfoResultMapper_Factory PlaceComponentResult = new ExpiryInfoResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
