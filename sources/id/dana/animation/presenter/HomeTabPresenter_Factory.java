package id.dana.animation.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.domain.account.interactor.IsFirstTime;
import id.dana.domain.devicestats.storage.ScheduleDeviceStatsReport;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked;
import id.dana.domain.home.interactor.SavePassiveBioTracked;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig;
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.GetIsSessionChecked;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.user.interactor.GetUserCohort;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomeTabPresenter_Factory implements Factory<HomeTabPresenter> {
    private final Provider<CheckSession> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SavePassiveBioTracked> DatabaseTableConfigUtil;
    private final Provider<SaveIsSessionChecked> GetContactSyncConfig;
    private final Provider<GetIsSessionChecked> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConsultForceDanaVizEnroll> MyBillsEntityDataFactory;
    private final Provider<GetUserCohort> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetVoiceAssistantConfig> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<RiskTracker> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<CheckHomePassiveBioTracked> PlaceComponentResult;
    private final Provider<ScheduleDeviceStatsReport> PrepareContext;
    private final Provider<GetFeatureHoldLoginConfig> getAuthRequestContext;
    private final Provider<GetPasswordLastModifiedWithConfigChecking> getErrorConfigVersion;
    private final Provider<IsFirstTime> initRecordTimeStamp;
    private final Provider<HomeTabContract.View> isLayoutRequested;
    private final Provider<GetMixpanelStorageConfig> lookAheadTest;
    private final Provider<GetResetAndChangePinNativeEntryConfig> moveToNextValue;
    private final Provider<GetQueryUserDataConfig> scheduleImpl;

    private HomeTabPresenter_Factory(Provider<HomeTabContract.View> provider, Provider<GetMixpanelStorageConfig> provider2, Provider<GetVoiceAssistantConfig> provider3, Provider<GetUserCohort> provider4, Provider<RiskTracker> provider5, Provider<CheckHomePassiveBioTracked> provider6, Provider<SavePassiveBioTracked> provider7, Provider<GetPasswordLastModifiedWithConfigChecking> provider8, Provider<GetQueryUserDataConfig> provider9, Provider<GetFeatureHoldLoginConfig> provider10, Provider<ConsultForceDanaVizEnroll> provider11, Provider<GetResetAndChangePinNativeEntryConfig> provider12, Provider<ScheduleDeviceStatsReport> provider13, Provider<GetIsSessionChecked> provider14, Provider<SaveIsSessionChecked> provider15, Provider<CheckSession> provider16, Provider<IsFirstTime> provider17) {
        this.isLayoutRequested = provider;
        this.lookAheadTest = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider5;
        this.PlaceComponentResult = provider6;
        this.DatabaseTableConfigUtil = provider7;
        this.getErrorConfigVersion = provider8;
        this.scheduleImpl = provider9;
        this.getAuthRequestContext = provider10;
        this.MyBillsEntityDataFactory = provider11;
        this.moveToNextValue = provider12;
        this.PrepareContext = provider13;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider14;
        this.GetContactSyncConfig = provider15;
        this.BuiltInFictitiousFunctionClassFactory = provider16;
        this.initRecordTimeStamp = provider17;
    }

    public static HomeTabPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<HomeTabContract.View> provider, Provider<GetMixpanelStorageConfig> provider2, Provider<GetVoiceAssistantConfig> provider3, Provider<GetUserCohort> provider4, Provider<RiskTracker> provider5, Provider<CheckHomePassiveBioTracked> provider6, Provider<SavePassiveBioTracked> provider7, Provider<GetPasswordLastModifiedWithConfigChecking> provider8, Provider<GetQueryUserDataConfig> provider9, Provider<GetFeatureHoldLoginConfig> provider10, Provider<ConsultForceDanaVizEnroll> provider11, Provider<GetResetAndChangePinNativeEntryConfig> provider12, Provider<ScheduleDeviceStatsReport> provider13, Provider<GetIsSessionChecked> provider14, Provider<SaveIsSessionChecked> provider15, Provider<CheckSession> provider16, Provider<IsFirstTime> provider17) {
        return new HomeTabPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeTabPresenter(this.isLayoutRequested.get(), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
    }
}
