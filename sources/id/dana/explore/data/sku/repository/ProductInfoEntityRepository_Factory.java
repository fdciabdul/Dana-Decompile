package id.dana.explore.data.sku.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.explore.data.sku.repository.source.network.NetworkProductInfoEntityData;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ProductInfoEntityRepository_Factory implements Factory<ProductInfoEntityRepository> {
    private final Provider<ExploreConfigEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NetworkProductInfoEntityData> PlaceComponentResult;
    private final Provider<HoldLoginV1EntityRepository> getAuthRequestContext;

    private ProductInfoEntityRepository_Factory(Provider<NetworkProductInfoEntityData> provider, Provider<ExploreConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static ProductInfoEntityRepository_Factory PlaceComponentResult(Provider<NetworkProductInfoEntityData> provider, Provider<ExploreConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new ProductInfoEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ProductInfoEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
