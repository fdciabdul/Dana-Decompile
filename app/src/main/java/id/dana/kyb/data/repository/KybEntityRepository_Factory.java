package id.dana.kyb.data.repository;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.kyb.data.repository.source.KybConfigEntityDataFactory;
import id.dana.kyb.data.repository.source.KybEntityDataFactory;
import id.dana.kyb.data.repository.source.KybPreferenceEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KybEntityRepository_Factory implements Factory<KybEntityRepository> {
    private final Provider<KybEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<KybPreferenceEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<KybConfigEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<ContentDeliveryEntityDataFactory> PlaceComponentResult;
    private final Provider<HoldLoginV1EntityRepository> getAuthRequestContext;
    private final Provider<SpaceResultMapper> lookAheadTest;

    private KybEntityRepository_Factory(Provider<KybEntityDataFactory> provider, Provider<KybConfigEntityDataFactory> provider2, Provider<ContentDeliveryEntityDataFactory> provider3, Provider<KybPreferenceEntityDataFactory> provider4, Provider<SpaceResultMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.lookAheadTest = provider5;
        this.getAuthRequestContext = provider6;
    }

    public static KybEntityRepository_Factory MyBillsEntityDataFactory(Provider<KybEntityDataFactory> provider, Provider<KybConfigEntityDataFactory> provider2, Provider<ContentDeliveryEntityDataFactory> provider3, Provider<KybPreferenceEntityDataFactory> provider4, Provider<SpaceResultMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        return new KybEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get());
    }
}
