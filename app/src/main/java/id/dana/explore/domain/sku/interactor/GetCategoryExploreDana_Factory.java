package id.dana.explore.domain.sku.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.sku.ProductInfoRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetCategoryExploreDana_Factory implements Factory<GetCategoryExploreDana> {
    private final Provider<GlobalSearchRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ProductInfoRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ServicesRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCategoryExploreDana(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
