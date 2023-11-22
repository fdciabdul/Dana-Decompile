package id.dana.explore.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.data.sku.repository.source.network.ExploreDanaApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ExploreApiModule_ProvideExploreDanaApiFactory implements Factory<ExploreDanaApi> {
    private final ExploreApiModule MyBillsEntityDataFactory;
    private final Provider<Retrofit.Builder> PlaceComponentResult;

    private ExploreApiModule_ProvideExploreDanaApiFactory(ExploreApiModule exploreApiModule, Provider<Retrofit.Builder> provider) {
        this.MyBillsEntityDataFactory = exploreApiModule;
        this.PlaceComponentResult = provider;
    }

    public static ExploreApiModule_ProvideExploreDanaApiFactory MyBillsEntityDataFactory(ExploreApiModule exploreApiModule, Provider<Retrofit.Builder> provider) {
        return new ExploreApiModule_ProvideExploreDanaApiFactory(exploreApiModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExploreDanaApi) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
