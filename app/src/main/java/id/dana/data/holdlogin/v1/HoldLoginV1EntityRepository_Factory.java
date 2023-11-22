package id.dana.data.holdlogin.v1;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.base.AuthenticatedEntityRepository_MembersInjector;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.errorconfig.ErrorConfigFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.holdlogin.v2.HoldLoginFeatureFlag;
import id.dana.data.login.source.LoginEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginV1EntityRepository_Factory implements Factory<HoldLoginV1EntityRepository> {
    private final Provider<HoldLoginFeatureFlag> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ErrorConfigFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LoginEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<AccountEntityDataFactory> PlaceComponentResult;
    private final Provider<DeepLinkPayloadManager> getAuthRequestContext;
    private final Provider<SecurityGuardFacade> lookAheadTest;

    private HoldLoginV1EntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<LoginEntityDataFactory> provider2, Provider<SecurityGuardFacade> provider3, Provider<ErrorConfigFactory> provider4, Provider<HoldLoginFeatureFlag> provider5, Provider<DeepLinkPayloadManager> provider6) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.lookAheadTest = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getAuthRequestContext = provider6;
    }

    public static HoldLoginV1EntityRepository_Factory MyBillsEntityDataFactory(Provider<AccountEntityDataFactory> provider, Provider<LoginEntityDataFactory> provider2, Provider<SecurityGuardFacade> provider3, Provider<ErrorConfigFactory> provider4, Provider<HoldLoginFeatureFlag> provider5, Provider<DeepLinkPayloadManager> provider6) {
        return new HoldLoginV1EntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = new HoldLoginV1EntityRepository(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
        AuthenticatedEntityRepository_MembersInjector.injectBuildDeepLinkPayloadDependencies(holdLoginV1EntityRepository, this.getAuthRequestContext.get());
        return holdLoginV1EntityRepository;
    }
}
