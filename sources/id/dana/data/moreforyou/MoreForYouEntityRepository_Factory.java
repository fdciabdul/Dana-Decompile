package id.dana.data.moreforyou;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MoreForYouEntityRepository_Factory implements Factory<MoreForYouEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContentDeliveryCacheEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<SpaceResultMapper> PlaceComponentResult;
    private final Provider<ContentDeliveryEntityDataFactory> getAuthRequestContext;

    private MoreForYouEntityRepository_Factory(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<SpaceResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static MoreForYouEntityRepository_Factory getAuthRequestContext(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<SpaceResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new MoreForYouEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MoreForYouEntityRepository(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
