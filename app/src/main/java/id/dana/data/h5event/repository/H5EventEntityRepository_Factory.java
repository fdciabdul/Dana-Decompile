package id.dana.data.h5event.repository;

import dagger.internal.Factory;

/* loaded from: classes8.dex */
public final class H5EventEntityRepository_Factory implements Factory<H5EventEntityRepository> {
    @Override // javax.inject.Provider
    public final H5EventEntityRepository get() {
        return newInstance();
    }

    public static H5EventEntityRepository_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static H5EventEntityRepository newInstance() {
        return new H5EventEntityRepository();
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final H5EventEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new H5EventEntityRepository_Factory();

        private InstanceHolder() {
        }
    }
}
