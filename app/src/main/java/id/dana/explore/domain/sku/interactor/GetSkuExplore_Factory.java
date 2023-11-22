package id.dana.explore.domain.sku.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.sku.ProductInfoRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetSkuExplore_Factory implements Factory<GetSkuExplore> {
    private final Provider<ProductInfoRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GlobalSearchRepository> MyBillsEntityDataFactory;
    private final Provider<ServicesRepository> PlaceComponentResult;

    private GetSkuExplore_Factory(Provider<ProductInfoRepository> provider, Provider<ServicesRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static GetSkuExplore_Factory MyBillsEntityDataFactory(Provider<ProductInfoRepository> provider, Provider<ServicesRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        return new GetSkuExplore_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSkuExplore(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
