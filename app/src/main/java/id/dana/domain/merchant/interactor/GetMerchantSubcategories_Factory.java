package id.dana.domain.merchant.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantSubcategories_Factory implements Factory<GetMerchantSubcategories> {
    private final Provider<MerchantCategoriesRepository> merchantCategoriesRepositoryProvider;

    public GetMerchantSubcategories_Factory(Provider<MerchantCategoriesRepository> provider) {
        this.merchantCategoriesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantSubcategories get() {
        return newInstance(this.merchantCategoriesRepositoryProvider.get());
    }

    public static GetMerchantSubcategories_Factory create(Provider<MerchantCategoriesRepository> provider) {
        return new GetMerchantSubcategories_Factory(provider);
    }

    public static GetMerchantSubcategories newInstance(MerchantCategoriesRepository merchantCategoriesRepository) {
        return new GetMerchantSubcategories(merchantCategoriesRepository);
    }
}
