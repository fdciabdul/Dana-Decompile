package id.dana.data.nearbyme.repository.source;

import dagger.internal.Factory;
import id.dana.data.nearbyme.repository.source.local.DefaultMerchantConfigEntityData;
import id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyMeConfigDataFactory_Factory implements Factory<NearbyMeConfigDataFactory> {
    private final Provider<DefaultMerchantConfigEntityData> defaultMerchantConfigEntityDataProvider;
    private final Provider<SplitMerchantConfigEntity> splitMerchantConfigEntityProvider;

    public NearbyMeConfigDataFactory_Factory(Provider<SplitMerchantConfigEntity> provider, Provider<DefaultMerchantConfigEntityData> provider2) {
        this.splitMerchantConfigEntityProvider = provider;
        this.defaultMerchantConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NearbyMeConfigDataFactory get() {
        return newInstance(this.splitMerchantConfigEntityProvider.get(), this.defaultMerchantConfigEntityDataProvider.get());
    }

    public static NearbyMeConfigDataFactory_Factory create(Provider<SplitMerchantConfigEntity> provider, Provider<DefaultMerchantConfigEntityData> provider2) {
        return new NearbyMeConfigDataFactory_Factory(provider, provider2);
    }

    public static NearbyMeConfigDataFactory newInstance(SplitMerchantConfigEntity splitMerchantConfigEntity, DefaultMerchantConfigEntityData defaultMerchantConfigEntityData) {
        return new NearbyMeConfigDataFactory(splitMerchantConfigEntity, defaultMerchantConfigEntityData);
    }
}
