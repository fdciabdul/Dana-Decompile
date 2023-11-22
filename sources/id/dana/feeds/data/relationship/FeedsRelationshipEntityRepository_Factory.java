package id.dana.feeds.data.relationship;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.relationship.source.FeedsRelationshipDataFactory;
import id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData;
import id.dana.feeds.data.storage.preferences.SocialPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsRelationshipEntityRepository_Factory implements Factory<FeedsRelationshipEntityRepository> {
    private final Provider<ContactDeviceNameMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsRelationshipDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<HoldLoginV1EntityRepository> MyBillsEntityDataFactory;
    private final Provider<PersistenceRelationshipEntityData> PlaceComponentResult;
    private final Provider<SocialPreferences> getAuthRequestContext;

    private FeedsRelationshipEntityRepository_Factory(Provider<PersistenceRelationshipEntityData> provider, Provider<FeedsRelationshipDataFactory> provider2, Provider<SocialPreferences> provider3, Provider<ContactDeviceNameMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static FeedsRelationshipEntityRepository_Factory PlaceComponentResult(Provider<PersistenceRelationshipEntityData> provider, Provider<FeedsRelationshipDataFactory> provider2, Provider<SocialPreferences> provider3, Provider<ContactDeviceNameMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new FeedsRelationshipEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsRelationshipEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
