package id.dana.feeds.data.timeline;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.timeline.source.FeedsTimelineDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedsTimelineEntityRepository_Factory implements Factory<FeedsTimelineEntityRepository> {
    private final Provider<FeedsTimelineDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ContactDeviceNameMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<SocialPreferencesDataFactory> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeedsConfigEntityRepository> PlaceComponentResult;
    private final Provider<HoldLoginV1EntityRepository> getAuthRequestContext;
    private final Provider<UserConfigEntityRepository> scheduleImpl;

    private FeedsTimelineEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<UserConfigEntityRepository> provider2, Provider<FeedsTimelineDataFactory> provider3, Provider<ContactDeviceNameMapper> provider4, Provider<SocialPreferencesDataFactory> provider5, Provider<FeedsConfigEntityRepository> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.MyBillsEntityDataFactory = provider;
        this.scheduleImpl = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.PlaceComponentResult = provider6;
        this.getAuthRequestContext = provider7;
    }

    public static FeedsTimelineEntityRepository_Factory MyBillsEntityDataFactory(Provider<AccountEntityDataFactory> provider, Provider<UserConfigEntityRepository> provider2, Provider<FeedsTimelineDataFactory> provider3, Provider<ContactDeviceNameMapper> provider4, Provider<SocialPreferencesDataFactory> provider5, Provider<FeedsConfigEntityRepository> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new FeedsTimelineEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsTimelineEntityRepository(this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
