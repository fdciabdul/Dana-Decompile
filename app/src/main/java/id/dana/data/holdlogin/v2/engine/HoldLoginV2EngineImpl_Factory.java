package id.dana.data.holdlogin.v2.engine;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.holdlogin.v2.entity.HoldLoginEntityDataFactory;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginV2EngineImpl_Factory implements Factory<HoldLoginV2EngineImpl> {
    private final Provider<HoldLoginConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<HoldLoginEntityDataFactory> PlaceComponentResult;
    private final Provider<DeepLinkPayloadManager> getAuthRequestContext;
    private final Provider<LoginLogoutSubject> lookAheadTest;
    private final Provider<SecurityGuardFacade> moveToNextValue;

    private HoldLoginV2EngineImpl_Factory(Provider<AccountEntityDataFactory> provider, Provider<SecurityGuardFacade> provider2, Provider<LoginLogoutSubject> provider3, Provider<DeviceInformationProvider> provider4, Provider<HoldLoginConfig> provider5, Provider<HoldLoginEntityDataFactory> provider6, Provider<DeepLinkPayloadManager> provider7) {
        this.MyBillsEntityDataFactory = provider;
        this.moveToNextValue = provider2;
        this.lookAheadTest = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.PlaceComponentResult = provider6;
        this.getAuthRequestContext = provider7;
    }

    public static HoldLoginV2EngineImpl_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<AccountEntityDataFactory> provider, Provider<SecurityGuardFacade> provider2, Provider<LoginLogoutSubject> provider3, Provider<DeviceInformationProvider> provider4, Provider<HoldLoginConfig> provider5, Provider<HoldLoginEntityDataFactory> provider6, Provider<DeepLinkPayloadManager> provider7) {
        return new HoldLoginV2EngineImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        HoldLoginV2EngineImpl holdLoginV2EngineImpl = new HoldLoginV2EngineImpl(this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
        HoldLoginV2EngineImpl_MembersInjector.MyBillsEntityDataFactory(holdLoginV2EngineImpl, this.getAuthRequestContext.get());
        return holdLoginV2EngineImpl;
    }
}
