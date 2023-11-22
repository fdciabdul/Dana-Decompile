package id.dana.contract.referraltracker;

import dagger.internal.Factory;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate;
import id.dana.domain.referral.interactor.GetLatestReferralCampaign;
import id.dana.domain.referral.interactor.GetReferralBanner;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets;
import id.dana.domain.synccontact.interactor.SyncOneContact;
import id.dana.mapper.ReferralTrackerModelMapper;
import id.dana.mapper.ReferralWidgetModelMapper;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.ReferralBannerMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReferralTrackerPresenter_Factory implements Factory<ReferralTrackerPresenter> {
    private final Provider<GetReferralMessageTemplate> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ReferralTrackerContract.View> DatabaseTableConfigUtil;
    private final Provider<ReferralWidgetModelMapper> GetContactSyncConfig;
    private final Provider<GenerateReferralDeepLink> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetLatestReferralCampaign> MyBillsEntityDataFactory;
    private final Provider<ReferralTrackerModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveLastSeenReferralCampaign> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetReferralConsult> PlaceComponentResult;
    private final Provider<GetReferralBanner> getAuthRequestContext;
    private final Provider<ReferralBannerMapper> getErrorConfigVersion;
    private final Provider<SyncOneContact> initRecordTimeStamp;
    private final Provider<GetReferralWidgets> lookAheadTest;
    private final Provider<MyReferralConsultMapper> moveToNextValue;
    private final Provider<GetReferralTracker> scheduleImpl;

    private ReferralTrackerPresenter_Factory(Provider<ReferralTrackerContract.View> provider, Provider<ReferralWidgetModelMapper> provider2, Provider<SaveLastSeenReferralCampaign> provider3, Provider<MyReferralConsultMapper> provider4, Provider<SyncOneContact> provider5, Provider<GenerateReferralDeepLink> provider6, Provider<GetReferralBanner> provider7, Provider<ReferralBannerMapper> provider8, Provider<GetReferralTracker> provider9, Provider<ReferralTrackerModelMapper> provider10, Provider<GetReferralWidgets> provider11, Provider<GetLatestReferralCampaign> provider12, Provider<GetReferralConsult> provider13, Provider<GetReferralMessageTemplate> provider14) {
        this.DatabaseTableConfigUtil = provider;
        this.GetContactSyncConfig = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider3;
        this.moveToNextValue = provider4;
        this.initRecordTimeStamp = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.getAuthRequestContext = provider7;
        this.getErrorConfigVersion = provider8;
        this.scheduleImpl = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.lookAheadTest = provider11;
        this.MyBillsEntityDataFactory = provider12;
        this.PlaceComponentResult = provider13;
        this.BuiltInFictitiousFunctionClassFactory = provider14;
    }

    public static ReferralTrackerPresenter_Factory PlaceComponentResult(Provider<ReferralTrackerContract.View> provider, Provider<ReferralWidgetModelMapper> provider2, Provider<SaveLastSeenReferralCampaign> provider3, Provider<MyReferralConsultMapper> provider4, Provider<SyncOneContact> provider5, Provider<GenerateReferralDeepLink> provider6, Provider<GetReferralBanner> provider7, Provider<ReferralBannerMapper> provider8, Provider<GetReferralTracker> provider9, Provider<ReferralTrackerModelMapper> provider10, Provider<GetReferralWidgets> provider11, Provider<GetLatestReferralCampaign> provider12, Provider<GetReferralConsult> provider13, Provider<GetReferralMessageTemplate> provider14) {
        return new ReferralTrackerPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralTrackerPresenter(this.DatabaseTableConfigUtil.get(), this.GetContactSyncConfig.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.moveToNextValue.get(), this.initRecordTimeStamp.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.getErrorConfigVersion.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
