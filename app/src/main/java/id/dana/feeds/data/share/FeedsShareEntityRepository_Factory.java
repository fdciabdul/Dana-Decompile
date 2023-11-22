package id.dana.feeds.data.share;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.share.source.FeedsShareDataFactory;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.timeline.source.FeedsTimelineDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsShareEntityRepository_Factory implements Factory<FeedsShareEntityRepository> {
    private final Provider<FeedsTimelineDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsShareDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<SocialPreferencesDataFactory> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<HoldLoginV1EntityRepository> PlaceComponentResult;
    private final Provider<FeedsConfigEntityRepository> getAuthRequestContext;
    private final Provider<UserConfigEntityRepository> moveToNextValue;

    private FeedsShareEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<FeedsShareDataFactory> provider2, Provider<SocialPreferencesDataFactory> provider3, Provider<FeedsConfigEntityRepository> provider4, Provider<UserConfigEntityRepository> provider5, Provider<FeedsTimelineDataFactory> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.getAuthRequestContext = provider4;
        this.moveToNextValue = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.PlaceComponentResult = provider7;
    }

    public static FeedsShareEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<AccountEntityDataFactory> provider, Provider<FeedsShareDataFactory> provider2, Provider<SocialPreferencesDataFactory> provider3, Provider<FeedsConfigEntityRepository> provider4, Provider<UserConfigEntityRepository> provider5, Provider<FeedsTimelineDataFactory> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new FeedsShareEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsShareEntityRepository(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), this.PlaceComponentResult.get());
    }
}
