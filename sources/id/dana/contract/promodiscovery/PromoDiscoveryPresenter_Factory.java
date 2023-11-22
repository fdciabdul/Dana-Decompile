package id.dana.contract.promodiscovery;

import dagger.internal.Factory;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.domain.promodiscovery.interactor.GetDanaDealsThumbnail;
import id.dana.domain.promodiscovery.interactor.GetFourKingsPromo;
import id.dana.domain.promodiscovery.interactor.GetPromoDiscoverySectionConfig;
import id.dana.domain.promodiscovery.interactor.SwitchFourKingsPromoRedDot;
import id.dana.domain.services.interactor.GetService;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.referral.model.MyReferralConsultMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoDiscoveryPresenter_Factory implements Factory<PromoDiscoveryPresenter> {
    private final Provider<GetFourKingsPromo> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SwitchFourKingsPromoRedDot> DatabaseTableConfigUtil;
    private final Provider<ReferralSettingConfigRunner> GetContactSyncConfig;
    private final Provider<GetDanaDealsThumbnail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPromoList> MyBillsEntityDataFactory;
    private final Provider<GetPromoList> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<PromoDiscoveryContract.View> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<CheckShowReferralCodeFeature> PlaceComponentResult;
    private final Provider<GetLatestSubdivision> getAuthRequestContext;
    private final Provider<GetPromoCategorizedList> getErrorConfigVersion;
    private final Provider<GetPromoDiscoverySectionConfig> lookAheadTest;
    private final Provider<MyReferralConsultMapper> moveToNextValue;
    private final Provider<GetService> scheduleImpl;

    private PromoDiscoveryPresenter_Factory(Provider<PromoDiscoveryContract.View> provider, Provider<GetPromoDiscoverySectionConfig> provider2, Provider<GetPromoList> provider3, Provider<GetPromoList> provider4, Provider<GetPromoCategorizedList> provider5, Provider<GetDanaDealsThumbnail> provider6, Provider<ReferralSettingConfigRunner> provider7, Provider<CheckShowReferralCodeFeature> provider8, Provider<MyReferralConsultMapper> provider9, Provider<GetFourKingsPromo> provider10, Provider<SwitchFourKingsPromoRedDot> provider11, Provider<GetLatestSubdivision> provider12, Provider<GetService> provider13) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider;
        this.lookAheadTest = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getErrorConfigVersion = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.GetContactSyncConfig = provider7;
        this.PlaceComponentResult = provider8;
        this.moveToNextValue = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
        this.DatabaseTableConfigUtil = provider11;
        this.getAuthRequestContext = provider12;
        this.scheduleImpl = provider13;
    }

    public static PromoDiscoveryPresenter_Factory getAuthRequestContext(Provider<PromoDiscoveryContract.View> provider, Provider<GetPromoDiscoverySectionConfig> provider2, Provider<GetPromoList> provider3, Provider<GetPromoList> provider4, Provider<GetPromoCategorizedList> provider5, Provider<GetDanaDealsThumbnail> provider6, Provider<ReferralSettingConfigRunner> provider7, Provider<CheckShowReferralCodeFeature> provider8, Provider<MyReferralConsultMapper> provider9, Provider<GetFourKingsPromo> provider10, Provider<SwitchFourKingsPromoRedDot> provider11, Provider<GetLatestSubdivision> provider12, Provider<GetService> provider13) {
        return new PromoDiscoveryPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoDiscoveryPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.GetContactSyncConfig.get(), this.PlaceComponentResult.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.DatabaseTableConfigUtil.get(), this.getAuthRequestContext.get(), this.scheduleImpl.get());
    }
}
