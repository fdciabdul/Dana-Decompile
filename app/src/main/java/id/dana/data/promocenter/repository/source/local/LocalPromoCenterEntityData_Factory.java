package id.dana.data.promocenter.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPromoCenterEntityData_Factory implements Factory<LocalPromoCenterEntityData> {
    private final Provider<PromoAdsPreferences> promoAdsPreferencesProvider;
    private final Provider<PromoCategoryPreferences> promoCategoryPreferencesProvider;

    public LocalPromoCenterEntityData_Factory(Provider<PromoCategoryPreferences> provider, Provider<PromoAdsPreferences> provider2) {
        this.promoCategoryPreferencesProvider = provider;
        this.promoAdsPreferencesProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LocalPromoCenterEntityData get() {
        return newInstance(this.promoCategoryPreferencesProvider.get(), this.promoAdsPreferencesProvider.get());
    }

    public static LocalPromoCenterEntityData_Factory create(Provider<PromoCategoryPreferences> provider, Provider<PromoAdsPreferences> provider2) {
        return new LocalPromoCenterEntityData_Factory(provider, provider2);
    }

    public static LocalPromoCenterEntityData newInstance(PromoCategoryPreferences promoCategoryPreferences, PromoAdsPreferences promoAdsPreferences) {
        return new LocalPromoCenterEntityData(promoCategoryPreferences, promoAdsPreferences);
    }
}
