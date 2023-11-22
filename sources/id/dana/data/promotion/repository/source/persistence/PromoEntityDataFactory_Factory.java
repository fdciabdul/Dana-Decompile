package id.dana.data.promotion.repository.source.persistence;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoEntityDataFactory_Factory implements Factory<PromoEntityDataFactory> {
    private final Provider<PersistencePromoEntityData> persistencePromoEntityDataProvider;

    public PromoEntityDataFactory_Factory(Provider<PersistencePromoEntityData> provider) {
        this.persistencePromoEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PromoEntityDataFactory get() {
        return newInstance(this.persistencePromoEntityDataProvider.get());
    }

    public static PromoEntityDataFactory_Factory create(Provider<PersistencePromoEntityData> provider) {
        return new PromoEntityDataFactory_Factory(provider);
    }

    public static PromoEntityDataFactory newInstance(PersistencePromoEntityData persistencePromoEntityData) {
        return new PromoEntityDataFactory(persistencePromoEntityData);
    }
}
