package id.dana.domain.merchant.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InitNewMerchantCategories_Factory implements Factory<InitNewMerchantCategories> {
    private final Provider<MerchantCategoriesRepository> merchantCategoriesRepositoryProvider;

    public InitNewMerchantCategories_Factory(Provider<MerchantCategoriesRepository> provider) {
        this.merchantCategoriesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitNewMerchantCategories get() {
        return newInstance(this.merchantCategoriesRepositoryProvider.get());
    }

    public static InitNewMerchantCategories_Factory create(Provider<MerchantCategoriesRepository> provider) {
        return new InitNewMerchantCategories_Factory(provider);
    }

    public static InitNewMerchantCategories newInstance(MerchantCategoriesRepository merchantCategoriesRepository) {
        return new InitNewMerchantCategories(merchantCategoriesRepository);
    }
}
