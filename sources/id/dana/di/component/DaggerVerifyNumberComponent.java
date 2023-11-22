package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.contract.permission.PermissionStateModule;
import id.dana.contract.permission.PermissionStateModule_ProvidePresenterFactory;
import id.dana.contract.permission.PermissionStateModule_ProvideViewFactory;
import id.dana.contract.permission.PermissionStatePresenter;
import id.dana.contract.permission.PermissionStatePresenter_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
import id.dana.di.modules.VerifyNumberModule;
import id.dana.di.modules.VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory;
import id.dana.di.modules.VerifyNumberModule_ProvidesPresenterFactory;
import id.dana.di.modules.VerifyNumberModule_ProvidesViewFactory;
import id.dana.dialog.RiskRejectDialog_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage_Factory;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload_Factory;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckHelpButtonChatbotFeature;
import id.dana.domain.featureconfig.interactor.CheckHelpButtonChatbotFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetFrozenAccountChatbotConfig;
import id.dana.domain.featureconfig.interactor.GetFrozenAccountChatbotConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetOnboardingWarningTextConfig;
import id.dana.domain.featureconfig.interactor.GetOnboardingWarningTextConfig_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.IsGoogleBlockRegistration;
import id.dana.domain.globalnetwork.interactor.IsGoogleBlockRegistration_Factory;
import id.dana.domain.globalnetwork.interactor.IsMerchantBlockRegistration;
import id.dana.domain.globalnetwork.interactor.IsMerchantBlockRegistration_Factory;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.ConsultTrust2RiskLogin;
import id.dana.domain.login.interactor.ConsultTrust2RiskLogin_Factory;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.GetLoginRegisterConfig;
import id.dana.domain.login.interactor.GetLoginRegisterConfig_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig_Factory;
import id.dana.domain.onboarding.interactor.IsFirebaseLoginPerformanceTrackerOn;
import id.dana.domain.onboarding.interactor.IsFirebaseLoginPerformanceTrackerOn_Factory;
import id.dana.domain.onboarding.interactor.IsFirebaseRegisterPerformanceTrackerOn;
import id.dana.domain.onboarding.interactor.IsFirebaseRegisterPerformanceTrackerOn_Factory;
import id.dana.domain.permission.PermissionRepository;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission_Factory;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber_Factory;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.registration.interactor.GetChatBotTimestamp_Factory;
import id.dana.domain.registration.interactor.GetIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.GetIsFreezeVerifyOtp_Factory;
import id.dana.domain.registration.interactor.GetLastOtpChannel;
import id.dana.domain.registration.interactor.GetLastOtpChannel_Factory;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp_Factory;
import id.dana.domain.registration.interactor.GetResendOtpTimeLimit;
import id.dana.domain.registration.interactor.GetResendOtpTimeLimit_Factory;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp_Factory;
import id.dana.domain.registration.interactor.ResendOtp;
import id.dana.domain.registration.interactor.ResendOtp_Factory;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.mapper.FaceAuthenticationModelMapper_Factory;
import id.dana.onboarding.track.LocationPermissionTrackerImpl;
import id.dana.onboarding.track.LocationPermissionTrackerImpl_Factory;
import id.dana.onboarding.verify.FaceAuthManager_Factory;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.onboarding.verify.VerifyNumberFragment;
import id.dana.onboarding.verify.VerifyNumberFragment_MembersInjector;
import id.dana.onboarding.verify.VerifyPresenter;
import id.dana.onboarding.verify.VerifyPresenter_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerVerifyNumberComponent {
    private DaggerVerifyNumberComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public LogoutModule KClassImpl$Data$declaredNonStaticMembers$2;
        public VerifyNumberModule MyBillsEntityDataFactory;
        public PermissionStateModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class VerifyNumberComponentImpl implements VerifyNumberComponent {
        private Provider<GetOnboardingWarningTextConfig> A;
        private Provider<PermissionStatePresenter> AppCompatEmojiTextHelper;
        private Provider<GetResendOtpTimeLimit> B;
        private Provider<IsFirebaseLoginPerformanceTrackerOn> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;
        private Provider<GlobalNetworkRepository> C;
        private Provider<LocationPermissionTrackerImpl> D;
        private Provider<ContactRepository> DatabaseTableConfigUtil;
        private Provider<LoginRepository> E;
        private Provider<MixpanelAnalytics> F;
        private Provider<FirebaseAnalytics> FragmentBottomSheetPaymentSettingBinding;
        private Provider<LogoutPresenter> G;
        private Provider<Context> GetContactSyncConfig;
        private Provider<PermissionRepository> H;
        private Provider<Logout> I;
        private Provider<CarrierIdentificationRepository> J;
        private Provider<DanapolyClearRepository> K;
        private Provider<CheckHelpButtonChatbotFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<PostExecutionThread> L;
        private Provider<BotProtectionChallenge> M;
        private Provider<CheckRegisteredPhoneNumber> MyBillsEntityDataFactory;
        private Provider<FeedInitRepository> N;
        private Provider<ClearAllDanapolyData> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ClearKybData> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ConsultTrust2RiskLogin> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetChatBotTimestamp> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<GetEmergencyNotifConfig> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ForceLogout> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FaceAuthPopUpConsultationRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DanaSessionManager> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<HomeWidgetClearable> O;
        private Provider<LocationPermissionSubject> P;
        private Provider<CheckIpificationCoverage> PlaceComponentResult;
        private Provider<DeviceInformationProvider> PrepareContext;
        private Provider<FirebasePerformanceMonitor> Q;
        private Provider<PermissionStateContract.View> R;
        private Provider<PermissionStateContract.Presenter> S;
        private Provider<GetLastOtpChannel> SubSequence;
        private Provider<LoginTracker> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<LogoutContract.Presenter> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<LogoutContract.View> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<RegistrationRepository> T;
        private Provider<VerifyNumberContract.View> U;
        private Provider<Boolean> V;
        private Provider<IsFirebaseRegisterPerformanceTrackerOn> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<KybRepository> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<RemoveDeepLinkPayload> W;
        private Provider<VerifyNumberContract.Presenter> X;
        private Provider<RemoveNumberOfRequestOtp> Y;
        private Provider<SetDeniedLocationPermission> Z;

        /* renamed from: a */
        private Provider<VerifyPresenter> f8163a;
        private Provider<ThreadExecutor> c;
        private final VerifyNumberComponentImpl d;
        private Provider<SaveNumberOfRequestOtp> flip;
        private Provider<CheckDeniedLocationPermission> getAuthRequestContext;
        private Provider<GetLoginRegisterConfig> getCallingPid;
        private Provider<ClearAllSyncEngineUseCase> getErrorConfigVersion;
        private Provider<EventTrackerQueue> getNameOrBuilderList;
        private Provider<IsGoogleBlockRegistration> getOnBoardingScenario;
        private Provider<GetFrozenAccountChatbotConfig> getSupportButtonTintMode;
        private Provider<IsMerchantBlockRegistration> getValueOfTouchPositionAbsolute;
        private Provider<ClearFaceAuthSuggestionState> initRecordTimeStamp;
        private Provider<RegistrationTracker> isAuth;
        private Provider<ServicesRepository> isAuto;
        private Provider<DynamicUrlWrapper> isLayoutRequested;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<ClearCacheFavoriteServices> moveToNextValue;
        private Provider<DeepLinkRepository> newProxyInstance;
        private Provider<GetNumberOfRequestOtp> readMicros;
        private Provider<ClearAllFeedsUsecase> scheduleImpl;
        private Provider<ResendOtp> shouldRecycleViewType;
        private Provider<GetIsFreezeVerifyOtp> whenAvailable;

        public /* synthetic */ VerifyNumberComponentImpl(VerifyNumberModule verifyNumberModule, PermissionStateModule permissionStateModule, LogoutModule logoutModule, ApplicationComponent applicationComponent, byte b) {
            this(verifyNumberModule, permissionStateModule, logoutModule, applicationComponent);
        }

        private VerifyNumberComponentImpl(VerifyNumberModule verifyNumberModule, PermissionStateModule permissionStateModule, LogoutModule logoutModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            FaceAuthenticationModelMapper_Factory faceAuthenticationModelMapper_Factory;
            this.d = this;
            this.isLayoutRequested = new DynamicUrlWrapperProvider(applicationComponent);
            this.R = PermissionStateModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(permissionStateModule);
            this.c = new ThreadExecutorProvider(applicationComponent);
            this.L = new PostExecutionThreadProvider(applicationComponent);
            PermissionRepositoryProvider permissionRepositoryProvider = new PermissionRepositoryProvider(applicationComponent);
            this.H = permissionRepositoryProvider;
            this.Z = SetDeniedLocationPermission_Factory.create(this.c, this.L, permissionRepositoryProvider);
            CheckDeniedLocationPermission_Factory create = CheckDeniedLocationPermission_Factory.create(this.c, this.L, this.H);
            this.getAuthRequestContext = create;
            Provider<PermissionStatePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(PermissionStatePresenter_Factory.getAuthRequestContext(this.R, this.Z, create));
            this.AppCompatEmojiTextHelper = authRequestContext;
            this.S = PermissionStateModule_ProvidePresenterFactory.PlaceComponentResult(permissionStateModule, authRequestContext);
            this.P = new ProvideLocationPermissionSubjectProvider(applicationComponent);
            this.GetContactSyncConfig = new ContextProvider(applicationComponent);
            this.U = DoubleCheck.getAuthRequestContext(VerifyNumberModule_ProvidesViewFactory.PlaceComponentResult(verifyNumberModule));
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.T = registrationRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckRegisteredPhoneNumber_Factory.create(registrationRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = featureConfigRepositoryProvider;
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(featureConfigRepositoryProvider);
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.newProxyInstance = deepLinkRepositoryProvider;
            this.W = RemoveDeepLinkPayload_Factory.create(deepLinkRepositoryProvider);
            this.V = DoubleCheck.getAuthRequestContext(VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory.KClassImpl$Data$declaredNonStaticMembers$2(verifyNumberModule));
            this.shouldRecycleViewType = ResendOtp_Factory.create(this.T);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.C = globalNetworkRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = IsMerchantBlockRegistration_Factory.create(globalNetworkRepositoryProvider);
            this.getOnBoardingScenario = IsGoogleBlockRegistration_Factory.create(this.C);
            this.getSupportButtonTintMode = GetFrozenAccountChatbotConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = IsFirebaseLoginPerformanceTrackerOn_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = IsFirebaseRegisterPerformanceTrackerOn_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckHelpButtonChatbotFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = GetEmergencyNotifConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.flip = SaveNumberOfRequestOtp_Factory.create(this.T);
            this.readMicros = GetNumberOfRequestOtp_Factory.create(this.T);
            this.Y = RemoveNumberOfRequestOtp_Factory.create(this.T);
            this.Q = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.getNameOrBuilderList = provideEventTrackerQueueProvider;
            this.FragmentBottomSheetPaymentSettingBinding = FirebaseAnalytics_Factory.PlaceComponentResult(this.GetContactSyncConfig, this.Q, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, this.getNameOrBuilderList);
            this.F = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.FragmentBottomSheetPaymentSettingBinding;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.D = LocationPermissionTrackerImpl_Factory.MyBillsEntityDataFactory(PlaceComponentResult);
            this.SubSequence = GetLastOtpChannel_Factory.create(this.T);
            ProvideCarrierIdentificationRepositoryProvider provideCarrierIdentificationRepositoryProvider = new ProvideCarrierIdentificationRepositoryProvider(applicationComponent);
            this.J = provideCarrierIdentificationRepositoryProvider;
            this.PlaceComponentResult = CheckIpificationCoverage_Factory.create(provideCarrierIdentificationRepositoryProvider);
            this.whenAvailable = GetIsFreezeVerifyOtp_Factory.create(this.T);
            this.B = GetResendOtpTimeLimit_Factory.create(this.T);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = GetChatBotTimestamp_Factory.create(this.T);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = new ProvideLoginTrackerProvider(applicationComponent);
            this.isAuth = new ProvideRegistrationTrackerProvider(applicationComponent);
            this.getCallingPid = GetLoginRegisterConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.E = loginRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ConsultTrust2RiskLogin_Factory.create(loginRepositoryProvider);
            this.A = GetOnboardingWarningTextConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Provider<Context> provider2 = this.GetContactSyncConfig;
            Provider<VerifyNumberContract.View> provider3 = this.U;
            Provider<CheckRegisteredPhoneNumber> provider4 = this.MyBillsEntityDataFactory;
            Provider<CheckShowReferralCodeFeature> provider5 = this.lookAheadTest;
            FaceAuthManager_Factory MyBillsEntityDataFactory = FaceAuthManager_Factory.MyBillsEntityDataFactory();
            faceAuthenticationModelMapper_Factory = FaceAuthenticationModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            Provider<VerifyPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(VerifyPresenter_Factory.MyBillsEntityDataFactory(provider2, provider3, provider4, provider5, MyBillsEntityDataFactory, faceAuthenticationModelMapper_Factory, this.W, this.V, this.shouldRecycleViewType, this.getValueOfTouchPositionAbsolute, this.getOnBoardingScenario, this.getSupportButtonTintMode, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.flip, this.readMicros, this.Y, this.D, this.SubSequence, this.PlaceComponentResult, this.whenAvailable, this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.isAuth, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.A));
            this.f8163a = authRequestContext2;
            this.X = DoubleCheck.getAuthRequestContext(VerifyNumberModule_ProvidesPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(verifyNumberModule, authRequestContext2));
            this.PrepareContext = new DeviceInformationProviderProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.O = provideHomeWidgetClearableProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = ForceLogout_Factory.create(this.c, this.L, this.E, this.C, provideHomeWidgetClearableProvider);
            this.I = Logout_Factory.create(this.c, this.L, this.E, this.O, this.C);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = contractRepositoryProvider;
            this.getErrorConfigVersion = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.N = provideFeedInitRepositoryProvider;
            this.scheduleImpl = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.isAuto = servicesRepositoryProvider;
            this.moveToNextValue = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.K = provideDanapolyClearRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext3 = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DanaSessionManager_Factory.getAuthRequestContext(this.GetContactSyncConfig, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.I, this.getErrorConfigVersion, this.scheduleImpl, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, authRequestContext3);
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create2 = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.initRecordTimeStamp = create2;
            Provider<LogoutPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda8, create2));
            this.G = authRequestContext4;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext4));
            this.M = new ProvideBotProtectionChallengeProvider(applicationComponent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent PlaceComponentResult;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PermissionRepositoryProvider implements Provider<PermissionRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PermissionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PermissionRepository get() {
                return (PermissionRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.flip());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideLocationPermissionSubjectProvider implements Provider<LocationPermissionSubject> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideLocationPermissionSubjectProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LocationPermissionSubject get() {
                return (LocationPermissionSubject) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.w());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.rotateTo());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.OtpRegistrationPresenter$input$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.j());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideCarrierIdentificationRepositoryProvider implements Provider<CarrierIdentificationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideCarrierIdentificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CarrierIdentificationRepository get() {
                return (CarrierIdentificationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideLoginTrackerProvider implements Provider<LoginTracker> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideLoginTrackerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginTracker get() {
                return (LoginTracker) Preconditions.PlaceComponentResult(this.PlaceComponentResult.v());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.getAuthRequestContext.verifyNotNull());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent getAuthRequestContext;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent PlaceComponentResult;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.PlaceComponentResult.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideBotProtectionChallengeProvider implements Provider<BotProtectionChallenge> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideBotProtectionChallengeProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ BotProtectionChallenge get() {
                return (BotProtectionChallenge) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FillAnimation());
            }
        }

        @Override // id.dana.di.component.VerifyNumberComponent
        public final void BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment verifyNumberFragment) {
            VerifyNumberFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested));
            VerifyNumberFragment_MembersInjector.getErrorConfigVersion(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.S));
            VerifyNumberFragment_MembersInjector.PlaceComponentResult(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.P));
            VerifyNumberFragment_MembersInjector.scheduleImpl(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.X));
            verifyNumberFragment.deviceInformationProvider = DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext);
            VerifyNumberFragment_MembersInjector.getAuthRequestContext(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.SummaryVoucherView$$ExternalSyntheticLambda1));
            VerifyNumberFragment_MembersInjector.MyBillsEntityDataFactory(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(this.M));
            VerifyNumberFragment_MembersInjector.moveToNextValue(verifyNumberFragment, DoubleCheck.MyBillsEntityDataFactory(RiskRejectDialog_Factory.MyBillsEntityDataFactory()));
        }
    }
}
