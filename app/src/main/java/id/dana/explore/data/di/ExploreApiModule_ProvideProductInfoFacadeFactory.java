package id.dana.explore.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.data.sku.repository.source.network.ProductInfoFacade;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ExploreApiModule_ProvideProductInfoFacadeFactory implements Factory<ProductInfoFacade> {
    private final ExploreApiModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Retrofit.Builder> MyBillsEntityDataFactory;

    private ExploreApiModule_ProvideProductInfoFacadeFactory(ExploreApiModule exploreApiModule, Provider<Retrofit.Builder> provider) {
        this.BuiltInFictitiousFunctionClassFactory = exploreApiModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ExploreApiModule_ProvideProductInfoFacadeFactory BuiltInFictitiousFunctionClassFactory(ExploreApiModule exploreApiModule, Provider<Retrofit.Builder> provider) {
        return new ExploreApiModule_ProvideProductInfoFacadeFactory(exploreApiModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ProductInfoFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
