package id.dana.data.nearbyme.repository;

import dagger.internal.Factory;
import id.dana.data.nearbyme.repository.source.NearbyMeConfigDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantConfigEntityRepository_Factory implements Factory<MerchantConfigEntityRepository> {
    private final Provider<NearbyMeConfigDataFactory> nearbyMeConfigDataFactoryProvider;

    public MerchantConfigEntityRepository_Factory(Provider<NearbyMeConfigDataFactory> provider) {
        this.nearbyMeConfigDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MerchantConfigEntityRepository get() {
        return newInstance(this.nearbyMeConfigDataFactoryProvider.get());
    }

    public static MerchantConfigEntityRepository_Factory create(Provider<NearbyMeConfigDataFactory> provider) {
        return new MerchantConfigEntityRepository_Factory(provider);
    }

    public static MerchantConfigEntityRepository newInstance(NearbyMeConfigDataFactory nearbyMeConfigDataFactory) {
        return new MerchantConfigEntityRepository(nearbyMeConfigDataFactory);
    }
}
