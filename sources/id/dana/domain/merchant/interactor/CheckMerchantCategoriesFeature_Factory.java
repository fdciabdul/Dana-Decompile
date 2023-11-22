package id.dana.domain.merchant.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckMerchantCategoriesFeature_Factory implements Factory<CheckMerchantCategoriesFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckMerchantCategoriesFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckMerchantCategoriesFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckMerchantCategoriesFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckMerchantCategoriesFeature_Factory(provider);
    }

    public static CheckMerchantCategoriesFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckMerchantCategoriesFeature(featureConfigRepository);
    }
}
