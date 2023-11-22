package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.feeds.mapper.FeedsModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomeDataModelMapper_Factory implements Factory<HomeDataModelMapper> {
    private final Provider<FeedsModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HomeInfoMapper> MyBillsEntityDataFactory;
    private final Provider<PromotionMapper> PlaceComponentResult;
    private final Provider<HasNewModelMapper> getAuthRequestContext;

    private HomeDataModelMapper_Factory(Provider<HomeInfoMapper> provider, Provider<PromotionMapper> provider2, Provider<FeedsModelMapper> provider3, Provider<HasNewModelMapper> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static HomeDataModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<HomeInfoMapper> provider, Provider<PromotionMapper> provider2, Provider<FeedsModelMapper> provider3, Provider<HasNewModelMapper> provider4) {
        return new HomeDataModelMapper_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeDataModelMapper(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
