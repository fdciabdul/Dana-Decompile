package id.dana.data.nearbyme.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.nearbyme.repository.source.local.PreferenceMerchantReviewFormEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantReviewFormEntityRepository_Factory implements Factory<MerchantReviewFormEntityRepository> {
    private final Provider<PreferenceMerchantReviewFormEntityData> merchantReviewEntityDataProvider;
    private final Provider<PreferenceAccountEntityData> preferenceAccountEntityDataProvider;

    public MerchantReviewFormEntityRepository_Factory(Provider<PreferenceMerchantReviewFormEntityData> provider, Provider<PreferenceAccountEntityData> provider2) {
        this.merchantReviewEntityDataProvider = provider;
        this.preferenceAccountEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MerchantReviewFormEntityRepository get() {
        return newInstance(this.merchantReviewEntityDataProvider.get(), this.preferenceAccountEntityDataProvider.get());
    }

    public static MerchantReviewFormEntityRepository_Factory create(Provider<PreferenceMerchantReviewFormEntityData> provider, Provider<PreferenceAccountEntityData> provider2) {
        return new MerchantReviewFormEntityRepository_Factory(provider, provider2);
    }

    public static MerchantReviewFormEntityRepository newInstance(PreferenceMerchantReviewFormEntityData preferenceMerchantReviewFormEntityData, PreferenceAccountEntityData preferenceAccountEntityData) {
        return new MerchantReviewFormEntityRepository(preferenceMerchantReviewFormEntityData, preferenceAccountEntityData);
    }
}
