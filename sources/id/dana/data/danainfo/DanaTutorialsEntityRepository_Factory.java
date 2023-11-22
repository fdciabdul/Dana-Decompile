package id.dana.data.danainfo;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaTutorialsEntityRepository_Factory implements Factory<DanaTutorialsEntityRepository> {
    private final Provider<ContentDeliveryEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SpaceResultMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContentDeliveryCacheEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<HoldLoginV1EntityRepository> PlaceComponentResult;

    private DanaTutorialsEntityRepository_Factory(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<SpaceResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static DanaTutorialsEntityRepository_Factory PlaceComponentResult(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<SpaceResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new DanaTutorialsEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaTutorialsEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
