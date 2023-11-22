package id.dana.data.favoriteservice.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FavoriteServicesResultMapper_Factory implements Factory<FavoriteServicesResultMapper> {
    @Override // javax.inject.Provider
    public final FavoriteServicesResultMapper get() {
        return newInstance();
    }

    public static FavoriteServicesResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static FavoriteServicesResultMapper newInstance() {
        return new FavoriteServicesResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FavoriteServicesResultMapper_Factory PlaceComponentResult = new FavoriteServicesResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
