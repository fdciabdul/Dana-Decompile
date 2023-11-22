package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PromoInfoEntityMapper_Factory implements Factory<PromoInfoEntityMapper> {
    @Override // javax.inject.Provider
    public final PromoInfoEntityMapper get() {
        return newInstance();
    }

    public static PromoInfoEntityMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static PromoInfoEntityMapper newInstance() {
        return new PromoInfoEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PromoInfoEntityMapper_Factory getAuthRequestContext = new PromoInfoEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
