package id.dana.onboarding.verify;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.featureconfig.interactor.CheckHelpButtonChatbotFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.GetFrozenAccountChatbotConfig;
import id.dana.domain.featureconfig.interactor.GetOnboardingWarningTextConfig;
import id.dana.domain.globalnetwork.interactor.IsGoogleBlockRegistration;
import id.dana.domain.globalnetwork.interactor.IsMerchantBlockRegistration;
import id.dana.domain.login.interactor.ConsultTrust2RiskLogin;
import id.dana.domain.login.interactor.GetLoginRegisterConfig;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig;
import id.dana.domain.onboarding.interactor.IsFirebaseLoginPerformanceTrackerOn;
import id.dana.domain.onboarding.interactor.IsFirebaseRegisterPerformanceTrackerOn;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.registration.interactor.GetIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.GetLastOtpChannel;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.GetResendOtpTimeLimit;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.ResendOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.mapper.FaceAuthenticationModelMapper;
import id.dana.onboarding.track.LocationPermissionTrackerImpl;
import id.dana.onboarding.verify.VerifyNumberContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyPresenter_Factory implements Factory<VerifyPresenter> {
    private final Provider<CheckIpificationCoverage> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetLoginRegisterConfig> DatabaseTableConfigUtil;
    private final Provider<Boolean> FragmentBottomSheetPaymentSettingBinding;
    private final Provider<GetFrozenAccountChatbotConfig> GetContactSyncConfig;
    private final Provider<CheckHelpButtonChatbotFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckShowReferralCodeFeature> MyBillsEntityDataFactory;
    private final Provider<GetChatBotTimestamp> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetNumberOfRequestOtp> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetLastOtpChannel> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<IsMerchantBlockRegistration> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Provider<RegistrationTracker> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Provider<LocationPermissionTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Provider<LoginTracker> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Provider<IsFirebaseRegisterPerformanceTrackerOn> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<IsFirebaseLoginPerformanceTrackerOn> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<ConsultTrust2RiskLogin> PlaceComponentResult;
    private final Provider<GetOnboardingWarningTextConfig> PrepareContext;
    private final Provider<VerifyNumberContract.View> SubSequence;
    private final Provider<CheckRegisteredPhoneNumber> getAuthRequestContext;
    private final Provider<RemoveNumberOfRequestOtp> getCallingPid;
    private final Provider<GetEmergencyNotifConfig> getErrorConfigVersion;
    private final Provider<ResendOtp> getSupportButtonTintMode;
    private final Provider<GetIsFreezeVerifyOtp> initRecordTimeStamp;
    private final Provider<IsGoogleBlockRegistration> isLayoutRequested;
    private final Provider<FaceAuthManager> lookAheadTest;
    private final Provider<FaceAuthenticationModelMapper> moveToNextValue;
    private final Provider<GetResendOtpTimeLimit> newProxyInstance;
    private final Provider<RemoveDeepLinkPayload> readMicros;
    private final Provider<Context> scheduleImpl;
    private final Provider<SaveNumberOfRequestOtp> whenAvailable;

    private VerifyPresenter_Factory(Provider<Context> provider, Provider<VerifyNumberContract.View> provider2, Provider<CheckRegisteredPhoneNumber> provider3, Provider<CheckShowReferralCodeFeature> provider4, Provider<FaceAuthManager> provider5, Provider<FaceAuthenticationModelMapper> provider6, Provider<RemoveDeepLinkPayload> provider7, Provider<Boolean> provider8, Provider<ResendOtp> provider9, Provider<IsMerchantBlockRegistration> provider10, Provider<IsGoogleBlockRegistration> provider11, Provider<GetFrozenAccountChatbotConfig> provider12, Provider<IsFirebaseLoginPerformanceTrackerOn> provider13, Provider<IsFirebaseRegisterPerformanceTrackerOn> provider14, Provider<CheckHelpButtonChatbotFeature> provider15, Provider<GetEmergencyNotifConfig> provider16, Provider<SaveNumberOfRequestOtp> provider17, Provider<GetNumberOfRequestOtp> provider18, Provider<RemoveNumberOfRequestOtp> provider19, Provider<LocationPermissionTrackerImpl> provider20, Provider<GetLastOtpChannel> provider21, Provider<CheckIpificationCoverage> provider22, Provider<GetIsFreezeVerifyOtp> provider23, Provider<GetResendOtpTimeLimit> provider24, Provider<GetChatBotTimestamp> provider25, Provider<LoginTracker> provider26, Provider<RegistrationTracker> provider27, Provider<GetLoginRegisterConfig> provider28, Provider<ConsultTrust2RiskLogin> provider29, Provider<GetOnboardingWarningTextConfig> provider30) {
        this.scheduleImpl = provider;
        this.SubSequence = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.lookAheadTest = provider5;
        this.moveToNextValue = provider6;
        this.readMicros = provider7;
        this.FragmentBottomSheetPaymentSettingBinding = provider8;
        this.getSupportButtonTintMode = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = provider10;
        this.isLayoutRequested = provider11;
        this.GetContactSyncConfig = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider14;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider15;
        this.getErrorConfigVersion = provider16;
        this.whenAvailable = provider17;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider18;
        this.getCallingPid = provider19;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provider20;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider21;
        this.BuiltInFictitiousFunctionClassFactory = provider22;
        this.initRecordTimeStamp = provider23;
        this.newProxyInstance = provider24;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider25;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provider26;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provider27;
        this.DatabaseTableConfigUtil = provider28;
        this.PlaceComponentResult = provider29;
        this.PrepareContext = provider30;
    }

    public static VerifyPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<VerifyNumberContract.View> provider2, Provider<CheckRegisteredPhoneNumber> provider3, Provider<CheckShowReferralCodeFeature> provider4, Provider<FaceAuthManager> provider5, Provider<FaceAuthenticationModelMapper> provider6, Provider<RemoveDeepLinkPayload> provider7, Provider<Boolean> provider8, Provider<ResendOtp> provider9, Provider<IsMerchantBlockRegistration> provider10, Provider<IsGoogleBlockRegistration> provider11, Provider<GetFrozenAccountChatbotConfig> provider12, Provider<IsFirebaseLoginPerformanceTrackerOn> provider13, Provider<IsFirebaseRegisterPerformanceTrackerOn> provider14, Provider<CheckHelpButtonChatbotFeature> provider15, Provider<GetEmergencyNotifConfig> provider16, Provider<SaveNumberOfRequestOtp> provider17, Provider<GetNumberOfRequestOtp> provider18, Provider<RemoveNumberOfRequestOtp> provider19, Provider<LocationPermissionTrackerImpl> provider20, Provider<GetLastOtpChannel> provider21, Provider<CheckIpificationCoverage> provider22, Provider<GetIsFreezeVerifyOtp> provider23, Provider<GetResendOtpTimeLimit> provider24, Provider<GetChatBotTimestamp> provider25, Provider<LoginTracker> provider26, Provider<RegistrationTracker> provider27, Provider<GetLoginRegisterConfig> provider28, Provider<ConsultTrust2RiskLogin> provider29, Provider<GetOnboardingWarningTextConfig> provider30) {
        return new VerifyPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPresenter(DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.SubSequence), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.readMicros), DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding), DoubleCheck.MyBillsEntityDataFactory(this.getSupportButtonTintMode), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.whenAvailable), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
    }
}
