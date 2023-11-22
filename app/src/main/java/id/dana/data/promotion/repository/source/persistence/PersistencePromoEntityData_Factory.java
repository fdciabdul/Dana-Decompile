package id.dana.data.promotion.repository.source.persistence;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistencePromoEntityData_Factory implements Factory<PersistencePromoEntityData> {
    private final Provider<PromoPreference> promoPreferenceProvider;

    public PersistencePromoEntityData_Factory(Provider<PromoPreference> provider) {
        this.promoPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersistencePromoEntityData get() {
        return newInstance(this.promoPreferenceProvider.get());
    }

    public static PersistencePromoEntityData_Factory create(Provider<PromoPreference> provider) {
        return new PersistencePromoEntityData_Factory(provider);
    }

    public static PersistencePromoEntityData newInstance(PromoPreference promoPreference) {
        return new PersistencePromoEntityData(promoPreference);
    }
}
