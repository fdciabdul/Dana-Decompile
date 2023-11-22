package id.dana.contract.deeplink.path;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.pushverify.tracker.PushVerifyTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeaturePresenter_Factory implements Factory<FeaturePresenter> {
    private final Provider<CheckDeepLinkActionVisibility> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckWhitelistedValidDomain> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetFeedConfig> MyBillsEntityDataFactory;
    private final Provider<PushVerifyTracker> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeatureContract.View> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<CheckMyBillsVersionConfig> PlaceComponentResult;
    private final Provider<FeatureServicesHandler> getAuthRequestContext;
    private final Provider<GetUpdateAvailability> getErrorConfigVersion;
    private final Provider<GetService> lookAheadTest;
    private final Provider<GetNearbyConfig> moveToNextValue;
    private final Provider<GetPromoCenterVersion> scheduleImpl;

    private FeaturePresenter_Factory(Provider<FeatureContract.View> provider, Provider<FeatureServicesHandler> provider2, Provider<CheckDeepLinkActionVisibility> provider3, Provider<CheckWhitelistedValidDomain> provider4, Provider<GetNearbyConfig> provider5, Provider<GetFeedConfig> provider6, Provider<GetPromoCenterVersion> provider7, Provider<GetUpdateAvailability> provider8, Provider<CheckMyBillsVersionConfig> provider9, Provider<PushVerifyTracker> provider10, Provider<GetService> provider11) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.moveToNextValue = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.scheduleImpl = provider7;
        this.getErrorConfigVersion = provider8;
        this.PlaceComponentResult = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.lookAheadTest = provider11;
    }

    public static FeaturePresenter_Factory PlaceComponentResult(Provider<FeatureContract.View> provider, Provider<FeatureServicesHandler> provider2, Provider<CheckDeepLinkActionVisibility> provider3, Provider<CheckWhitelistedValidDomain> provider4, Provider<GetNearbyConfig> provider5, Provider<GetFeedConfig> provider6, Provider<GetPromoCenterVersion> provider7, Provider<GetUpdateAvailability> provider8, Provider<CheckMyBillsVersionConfig> provider9, Provider<PushVerifyTracker> provider10, Provider<GetService> provider11) {
        return new FeaturePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeaturePresenter(DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}
