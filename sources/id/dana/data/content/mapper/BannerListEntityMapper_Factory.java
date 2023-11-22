package id.dana.data.content.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class BannerListEntityMapper_Factory implements Factory<BannerListEntityMapper> {
    @Override // javax.inject.Provider
    public final BannerListEntityMapper get() {
        return newInstance();
    }

    public static BannerListEntityMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static BannerListEntityMapper newInstance() {
        return new BannerListEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final BannerListEntityMapper_Factory MyBillsEntityDataFactory = new BannerListEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
