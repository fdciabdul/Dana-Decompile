package id.dana.domain.merchant.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetNewMerchantCategories_Factory implements Factory<GetNewMerchantCategories> {
    private final Provider<MerchantCategoriesRepository> merchantCategoriesRepositoryProvider;

    public GetNewMerchantCategories_Factory(Provider<MerchantCategoriesRepository> provider) {
        this.merchantCategoriesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNewMerchantCategories get() {
        return newInstance(this.merchantCategoriesRepositoryProvider.get());
    }

    public static GetNewMerchantCategories_Factory create(Provider<MerchantCategoriesRepository> provider) {
        return new GetNewMerchantCategories_Factory(provider);
    }

    public static GetNewMerchantCategories newInstance(MerchantCategoriesRepository merchantCategoriesRepository) {
        return new GetNewMerchantCategories(merchantCategoriesRepository);
    }
}
