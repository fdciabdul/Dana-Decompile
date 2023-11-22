package id.dana.data.nearbyme.repository.source;

import dagger.internal.Factory;
import id.dana.data.nearbyme.repository.source.session.LocalNearbyMeEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CacheNearbyPromoFactory_Factory implements Factory<CacheNearbyPromoFactory> {
    private final Provider<LocalNearbyMeEntityData> localNearbyMeEntityDataProvider;

    public CacheNearbyPromoFactory_Factory(Provider<LocalNearbyMeEntityData> provider) {
        this.localNearbyMeEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CacheNearbyPromoFactory get() {
        return newInstance(this.localNearbyMeEntityDataProvider.get());
    }

    public static CacheNearbyPromoFactory_Factory create(Provider<LocalNearbyMeEntityData> provider) {
        return new CacheNearbyPromoFactory_Factory(provider);
    }

    public static CacheNearbyPromoFactory newInstance(LocalNearbyMeEntityData localNearbyMeEntityData) {
        return new CacheNearbyPromoFactory(localNearbyMeEntityData);
    }
}
