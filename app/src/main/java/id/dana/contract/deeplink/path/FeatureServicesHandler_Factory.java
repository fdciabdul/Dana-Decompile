package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.mapper.ThirdPartyServicesMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureServicesHandler_Factory implements Factory<FeatureServicesHandler> {
    private final Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThirdPartyServicesMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetAuthCode> MyBillsEntityDataFactory;
    private final Provider<FeatureContract.View> PlaceComponentResult;
    private final Provider<GetServicesByKey> getAuthRequestContext;

    private FeatureServicesHandler_Factory(Provider<FeatureContract.View> provider, Provider<GetServicesByKey> provider2, Provider<ThirdPartyServicesMapper> provider3, Provider<GetAuthCode> provider4, Provider<DeviceInformationProvider> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
    }

    public static FeatureServicesHandler_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeatureContract.View> provider, Provider<GetServicesByKey> provider2, Provider<ThirdPartyServicesMapper> provider3, Provider<GetAuthCode> provider4, Provider<DeviceInformationProvider> provider5) {
        return new FeatureServicesHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureServicesHandler(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
