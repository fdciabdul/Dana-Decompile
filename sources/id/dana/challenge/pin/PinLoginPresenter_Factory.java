package id.dana.challenge.pin;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.featureconfig.interactor.CheckFaceLoginFeature;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch;
import id.dana.domain.login.interactor.Login;
import id.dana.domain.login.interactor.Trust2RiskLogin;
import id.dana.domain.login.interactor.TrustRiskLogin;
import id.dana.domain.login.interactor.VerifyPasswordTrustRiskV2;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinLoginPresenter_Factory implements Factory<PinLoginPresenter> {
    private final Provider<GetChatBotTimestamp> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Trust2RiskLogin> DatabaseTableConfigUtil;
    private final Provider<LoginTracker> GetContactSyncConfig;
    private final Provider<CheckKnowledgeBasedAuthFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<IsAppFirstLaunch> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveIsSyncPermission> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<PasskeyTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<TrustRiskLogin> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<AbstractPinContract.View> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<CheckFaceLoginFeature> PlaceComponentResult;
    private final Provider<DeviceInformationProvider> getAuthRequestContext;
    private final Provider<Login> getErrorConfigVersion;
    private final Provider<SplitFacade> initRecordTimeStamp;
    private final Provider<GetIsSyncPermission> lookAheadTest;
    private final Provider<GetUserId> moveToNextValue;
    private final Provider<VerifyPasswordTrustRiskV2> newProxyInstance;
    private final Provider<GetQueryUserDataConfig> scheduleImpl;

    private PinLoginPresenter_Factory(Provider<AbstractPinContract.View> provider, Provider<Login> provider2, Provider<TrustRiskLogin> provider3, Provider<CheckKnowledgeBasedAuthFeature> provider4, Provider<IsAppFirstLaunch> provider5, Provider<Context> provider6, Provider<DeviceInformationProvider> provider7, Provider<CheckFaceLoginFeature> provider8, Provider<SplitFacade> provider9, Provider<GetUserId> provider10, Provider<GetIsSyncPermission> provider11, Provider<SaveIsSyncPermission> provider12, Provider<GetChatBotTimestamp> provider13, Provider<GetQueryUserDataConfig> provider14, Provider<LoginTracker> provider15, Provider<VerifyPasswordTrustRiskV2> provider16, Provider<Trust2RiskLogin> provider17, Provider<PasskeyTrackerImpl> provider18) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider;
        this.getErrorConfigVersion = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.getAuthRequestContext = provider7;
        this.PlaceComponentResult = provider8;
        this.initRecordTimeStamp = provider9;
        this.moveToNextValue = provider10;
        this.lookAheadTest = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider12;
        this.BuiltInFictitiousFunctionClassFactory = provider13;
        this.scheduleImpl = provider14;
        this.GetContactSyncConfig = provider15;
        this.newProxyInstance = provider16;
        this.DatabaseTableConfigUtil = provider17;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider18;
    }

    public static PinLoginPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<AbstractPinContract.View> provider, Provider<Login> provider2, Provider<TrustRiskLogin> provider3, Provider<CheckKnowledgeBasedAuthFeature> provider4, Provider<IsAppFirstLaunch> provider5, Provider<Context> provider6, Provider<DeviceInformationProvider> provider7, Provider<CheckFaceLoginFeature> provider8, Provider<SplitFacade> provider9, Provider<GetUserId> provider10, Provider<GetIsSyncPermission> provider11, Provider<SaveIsSyncPermission> provider12, Provider<GetChatBotTimestamp> provider13, Provider<GetQueryUserDataConfig> provider14, Provider<LoginTracker> provider15, Provider<VerifyPasswordTrustRiskV2> provider16, Provider<Trust2RiskLogin> provider17, Provider<PasskeyTrackerImpl> provider18) {
        return new PinLoginPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinLoginPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.initRecordTimeStamp.get(), this.moveToNextValue.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
    }
}
