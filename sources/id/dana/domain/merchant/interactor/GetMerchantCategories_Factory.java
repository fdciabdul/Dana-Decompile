package id.dana.domain.merchant.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMerchantCategories_Factory implements Factory<GetMerchantCategories> {
    private final Provider<MerchantCategoriesRepository> merchantCategoriesRepositoryProvider;

    public GetMerchantCategories_Factory(Provider<MerchantCategoriesRepository> provider) {
        this.merchantCategoriesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantCategories get() {
        return newInstance(this.merchantCategoriesRepositoryProvider.get());
    }

    public static GetMerchantCategories_Factory create(Provider<MerchantCategoriesRepository> provider) {
        return new GetMerchantCategories_Factory(provider);
    }

    public static GetMerchantCategories newInstance(MerchantCategoriesRepository merchantCategoriesRepository) {
        return new GetMerchantCategories(merchantCategoriesRepository);
    }
}
