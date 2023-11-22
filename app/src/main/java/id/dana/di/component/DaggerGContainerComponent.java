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
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl_Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.danah5.RequestResultBridge;
import id.dana.danah5.RequestResultBridge_MembersInjector;
import id.dana.danah5.bca.BcaWebviewEventHandler;
import id.dana.danah5.bca.BcaWebviewEventHandler_MembersInjector;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.bioutility.BioUtilityBridge_MembersInjector;
import id.dana.danah5.bottomsheet.BottomSheetBridge;
import id.dana.danah5.bottomsheet.BottomSheetBridge_MembersInjector;
import id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager;
import id.dana.danah5.cardbinding.CardBindingBridge;
import id.dana.danah5.cardbinding.CardBindingBridge_MembersInjector;
import id.dana.danah5.cashier.CashierUrlEventHandler;
import id.dana.danah5.cashier.CashierUrlEventHandler_MembersInjector;
import id.dana.danah5.contact.ContactBridge;
import id.dana.danah5.contact.ContactBridge_MembersInjector;
import id.dana.danah5.customredirectto.CutomRedirectToBridge;
import id.dana.danah5.customredirectto.CutomRedirectToBridge_MembersInjector;
import id.dana.danah5.danaprotection.DanaProtectionBridge;
import id.dana.danah5.danaprotection.DanaProtectionBridge_MembersInjector;
import id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge;
import id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge_MembersInjector;
import id.dana.danah5.easteregg.EasterEggsEventHandler;
import id.dana.danah5.easteregg.EasterEggsEventHandler_MembersInjector;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge_MembersInjector;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import id.dana.danah5.getonlineconfig.GetOnlineConfigBridge;
import id.dana.danah5.getonlineconfig.GetOnlineConfigBridge_MembersInjector;
import id.dana.danah5.globalnetwork.GlobalNetworkBridge;
import id.dana.danah5.globalnetwork.GlobalNetworkBridge_MembersInjector;
import id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager;
import id.dana.danah5.location.GetLocationNameBridge;
import id.dana.danah5.location.GetLocationNameBridge_MembersInjector;
import id.dana.danah5.locationpicker.MapsUtilityBridge;
import id.dana.danah5.locationpicker.MapsUtilityBridge_MembersInjector;
import id.dana.danah5.mixpanel.MixpanelBridge;
import id.dana.danah5.mixpanel.MixpanelBridge_MembersInjector;
import id.dana.danah5.mixpanel.StrictBaseBridge_MembersInjector;
import id.dana.danah5.nfcutility.NfcUtilityBridge;
import id.dana.danah5.nfcutility.NfcUtilityBridge_MembersInjector;
import id.dana.danah5.qrbinding.QrBindingCatcherEventHandler;
import id.dana.danah5.qrbinding.QrBindingCatcherEventHandler_MembersInjector;
import id.dana.danah5.referralengagement.ShowReferralEngagementDialogBridge;
import id.dana.danah5.referralengagement.ShowReferralEngagementDialogBridge_MembersInjector;
import id.dana.danah5.resetpin.GetPhoneNumberBridge;
import id.dana.danah5.resetpin.GetPhoneNumberBridge_MembersInjector;
import id.dana.danah5.resetpin.SelfUnfreezeEventHandler;
import id.dana.danah5.resetpin.SelfUnfreezeEventHandler_MembersInjector;
import id.dana.danah5.sendevent.SendEventBridge;
import id.dana.danah5.sendevent.SendEventBridge_MembersInjector;
import id.dana.danah5.sendmoney.SendMoneyBridge;
import id.dana.danah5.sendmoney.SendMoneyBridge_MembersInjector;
import id.dana.danah5.share.ShareBridge;
import id.dana.danah5.share.ShareBridge_MembersInjector;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.danah5.showagreement.ShowAgreementBridge_MembersInjector;
import id.dana.danah5.splitbill.SplitBillBridge;
import id.dana.danah5.splitbill.SplitBillBridge_MembersInjector;
import id.dana.danah5.subapp.CallSubAppBridge;
import id.dana.danah5.subapp.CallSubAppBridge_MembersInjector;
import id.dana.danah5.suggestlocations.SuggestLocationsBridge;
import id.dana.danah5.suggestlocations.SuggestLocationsBridge_MembersInjector;
import id.dana.danah5.tnccardpayment.TncCardPaymentBridge;
import id.dana.danah5.tnccardpayment.TncCardPaymentBridge_MembersInjector;
import id.dana.danah5.tracker.GeneralTrackEventBridge;
import id.dana.danah5.tracker.StartTimeEventBridge;
import id.dana.danah5.tracker.TrackEventBridge;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductBridge;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductBridge_MembersInjector;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.danah5.uploadfiles.UploadFilesBridge;
import id.dana.danah5.uploadfiles.UploadFilesBridge_MembersInjector;
import id.dana.danah5.userinfo.GetUsernameBridge;
import id.dana.danah5.userinfo.GetUsernameBridge_MembersInjector;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.risk.riskevent.SendRiskEventReceiver;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.modules.GContainerModule;
import id.dana.di.modules.GContainerModule_ProvideCashierEventHandlerFactory;
import id.dana.di.modules.GContainerModule_ProvideFaceVerificationEnablementManagerFactory;
import id.dana.di.modules.GContainerModule_ProvideGlobalNetworkManagerFactory;
import id.dana.di.modules.GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory;
import id.dana.di.modules.GContainerModule_ProvideSendMoneyEventHandlerFactory;
import id.dana.di.modules.GContainerModule_ProvideServicesBottomSheetManagerFactory;
import id.dana.di.modules.GContainerModule_ProvideShareTextBroadcastReceiverFactory;
import id.dana.di.modules.GContainerModule_ProvideSplitBillEventHandlerFactory;
import id.dana.di.modules.GContainerModule_ProvideTncCardPaymentEventHandlerFactory;
import id.dana.di.modules.GContainerModule_ProvideTwilioSecurityProductManagerFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.SaveLastTransaction;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.interactor.GetElectronicMoneyConfig;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.GetForex;
import id.dana.domain.globalnetwork.interactor.GetForex_Factory;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex_Factory;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode_Factory;
import id.dana.domain.h5onlineconfig.GetH5OnlineConfig;
import id.dana.domain.h5onlineconfig.H5OnlineConfigRepository;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.interactor.GetListSuggestedLocations;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.profilemenu.interactor.GetMobileEnvInfo;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetPhoneNumberAttempt;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll_Factory;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetTempRegistrationPhoneNumber;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.transferaccount.TransferAccountRepository;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber_Factory;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken_Factory;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus_Factory;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge_Factory;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct_Factory;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge_Factory;
import id.dana.domain.uploadfiles.AddSelectedFiles;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.uploadfiles.GetSelectedFiles;
import id.dana.domain.uploadfiles.GetTotalFilesSize;
import id.dana.domain.uploadfiles.RemoveSelectedFile;
import id.dana.domain.uploadfiles.SetTotalFilesSize;
import id.dana.domain.uploadfiles.UploadFile;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.BuildAgreementContent;
import id.dana.domain.useragreement.interactor.BuildIncompleteUserDataContent;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.RecordAgreement;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.domain.webviewinterceptor.WebviewInterceptorRepository;
import id.dana.domain.webviewinterceptor.interactor.GetListWebviewInterceptorDataConfig;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.miniprogram.provider.OauthServiceProvider_MembersInjector;
import id.dana.myprofile.GetEnvInfoBridge;
import id.dana.myprofile.GetEnvInfoBridge_MembersInjector;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.sendmoney_v2.recipient.SendMoneyEventHandler;
import id.dana.splitbill.SplitBillEventHandler;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.GetContactByPhoneNumber;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerGContainerComponent {
    private DaggerGContainerComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public FaceAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;
        public GContainerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final GContainerComponent KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new GContainerModule();
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new FaceAuthenticationModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new GContainerComponentImpl(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class GContainerComponentImpl implements GContainerComponent {
        private Provider<SplitBillEventHandler> A;
        private Provider<ThreadExecutor> AppCompatEmojiTextHelper;
        private Provider<SendMoneyEventHandler> B;
        private Provider<ServicesBottomSheetManager> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;
        private Provider<SaveReferralEngagementDialogCache> C;
        private Provider<TwilioVerifySecurityProductManager> D;
        private Provider<GetForex> DatabaseTableConfigUtil;
        private Provider<RecordAgreementOnlyAgreementKey> E;
        private Provider<TwilioRepository> F;
        private Provider<LiteAccountRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SendRiskEventReceiver> G;
        private Provider<GetCashierNativeConfig> GetContactSyncConfig;
        private Provider<SwitchFaceAuthentication> H;
        private Provider<SaveTransferAccountToken> I;
        private Provider<UpdateTwilioChallenge> J;
        private Provider<TwilioVerifySecurityProduct> K;
        private Provider<CheckTwilioEnrollmentStatus> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<TwilioMixpanelTracker> L;
        private Provider<TwilioSdkRepository> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<UserRepository> N;
        private Provider<FinishForceDanaVizEnroll> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final GContainerComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetRealTimeForex> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<CashierEventHandler> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<EventTrackerQueue> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<MixpanelAnalytics> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetSelectedCountryCode> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GlobalNetworkRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<UserConsentRepository> P;
        private Provider<Context> PlaceComponentResult;
        private Provider<GetRequestMoneyInfoFeature> PrepareContext;
        private Provider<FirebasePerformanceMonitor> SubSequence;
        private Provider<ShareTextBroadcastReceiver> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<TncCardPaymentEventHandler> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> getAuthRequestContext;
        private Provider<FaceAuthentication> getCallingPid;
        private Provider<FaceAuthenticationRepository> getErrorConfigVersion;
        private Provider<TwilioRequestChallenge> getNameOrBuilderList;
        private Provider<ReferralRepository> getOnBoardingScenario;
        private Provider<ResetPinRepository> getSupportButtonTintMode;
        private Provider<TransferAccountRepository> getValueOfTouchPositionAbsolute;
        private Provider<FirebaseAnalytics> initRecordTimeStamp;
        private Provider<GetSplitBillConfig> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<DanaVizTrackerImpl> moveToNextValue;
        private Provider<GetUserId> newProxyInstance;
        private Provider<GlobalNetworkPluginManager> readMicros;
        private Provider<DeletionChangeNumber> scheduleImpl;
        private Provider<FaceAuthenticationManager> whenAvailable;

        /* synthetic */ GContainerComponentImpl(GContainerModule gContainerModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(gContainerModule, faceAuthenticationModule, applicationComponent);
        }

        private GContainerComponentImpl(GContainerModule gContainerModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.AppCompatEmojiTextHelper = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new PostExecutionThreadProvider(applicationComponent);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = globalNetworkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetSelectedCountryCode_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, globalNetworkRepositoryProvider);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.N = userRepositoryProvider;
            this.DatabaseTableConfigUtil = GetForex_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda8, userRepositoryProvider);
            GetRealTimeForex_Factory create = GetRealTimeForex_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.N);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create;
            this.readMicros = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideGlobalNetworkManagerFactory.getAuthRequestContext(gContainerModule, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.DatabaseTableConfigUtil, create));
            SendRiskEventReceiverProvider sendRiskEventReceiverProvider = new SendRiskEventReceiverProvider(applicationComponent);
            this.G = sendRiskEventReceiverProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideShareTextBroadcastReceiverFactory.getAuthRequestContext(gContainerModule, sendRiskEventReceiverProvider));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideServicesBottomSheetManagerFactory.PlaceComponentResult(gContainerModule));
            FaceAuthenticationRepositoryProvider faceAuthenticationRepositoryProvider = new FaceAuthenticationRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = faceAuthenticationRepositoryProvider;
            this.H = SwitchFaceAuthentication_Factory.create(faceAuthenticationRepositoryProvider);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = liteAccountRepositoryProvider;
            this.newProxyInstance = GetUserId_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, liteAccountRepositoryProvider);
            this.getCallingPid = FaceAuthenticationModule_ProvideFaceAuthenticationFactory.getAuthRequestContext(faceAuthenticationModule);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.SubSequence = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provideEventTrackerQueueProvider;
            this.initRecordTimeStamp = FirebaseAnalytics_Factory.PlaceComponentResult(this.PlaceComponentResult, this.SubSequence, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.initRecordTimeStamp;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.moveToNextValue = DanaVizTrackerImpl_Factory.PlaceComponentResult(PlaceComponentResult);
            ProvideTransferAccountRepositoryProvider provideTransferAccountRepositoryProvider = new ProvideTransferAccountRepositoryProvider(applicationComponent);
            this.getValueOfTouchPositionAbsolute = provideTransferAccountRepositoryProvider;
            this.I = SaveTransferAccountToken_Factory.create(provideTransferAccountRepositoryProvider);
            this.scheduleImpl = DeletionChangeNumber_Factory.create(this.getValueOfTouchPositionAbsolute);
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = provideResetPinRepositoryProvider;
            FinishForceDanaVizEnroll_Factory create2 = FinishForceDanaVizEnroll_Factory.create(provideResetPinRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create2;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideFaceVerificationEnablementManagerFactory.PlaceComponentResult(gContainerModule, this.H, this.newProxyInstance, this.getCallingPid, this.moveToNextValue, this.I, this.scheduleImpl, create2));
            TwilioEntityRepositoryProvider twilioEntityRepositoryProvider = new TwilioEntityRepositoryProvider(applicationComponent);
            this.M = twilioEntityRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckTwilioEnrollmentStatus_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, twilioEntityRepositoryProvider);
            TwilioEnrollmentRepositoryProvider twilioEnrollmentRepositoryProvider = new TwilioEnrollmentRepositoryProvider(applicationComponent);
            this.F = twilioEnrollmentRepositoryProvider;
            this.getNameOrBuilderList = TwilioRequestChallenge_Factory.create(twilioEnrollmentRepositoryProvider);
            this.K = TwilioVerifySecurityProduct_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.F);
            this.J = UpdateTwilioChallenge_Factory.create(this.M);
            TwilioMixpanelTracker_Factory authRequestContext = TwilioMixpanelTracker_Factory.getAuthRequestContext(this.PlaceComponentResult);
            this.L = authRequestContext;
            this.D = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideTwilioSecurityProductManagerFactory.getAuthRequestContext(gContainerModule, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getNameOrBuilderList, this.K, this.J, authRequestContext));
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = referralRepositoryProvider;
            this.C = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideSaveReferralEngagementDialogCacheFactory.BuiltInFictitiousFunctionClassFactory(gContainerModule, referralRepositoryProvider));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            GetCashierNativeConfig_Factory create3 = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.GetContactSyncConfig = create3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideCashierEventHandlerFactory.getAuthRequestContext(gContainerModule, create3));
            this.B = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideSendMoneyEventHandlerFactory.KClassImpl$Data$declaredNonStaticMembers$2(gContainerModule));
            this.PrepareContext = GetRequestMoneyInfoFeature_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.lookAheadTest);
            GetSplitBillConfig_Factory create4 = GetSplitBillConfig_Factory.create(this.AppCompatEmojiTextHelper, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.lookAheadTest);
            this.isLayoutRequested = create4;
            this.A = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideSplitBillEventHandlerFactory.PlaceComponentResult(gContainerModule, this.PrepareContext, create4));
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.P = userConsentRepositoryProvider;
            this.getAuthRequestContext = ConsultAgreementOnlyParamSpaceCodes_Factory.create(userConsentRepositoryProvider);
            RecordAgreementOnlyAgreementKey_Factory create5 = RecordAgreementOnlyAgreementKey_Factory.create(this.P);
            this.E = create5;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = DoubleCheck.getAuthRequestContext(GContainerModule_ProvideTncCardPaymentEventHandlerFactory.PlaceComponentResult(gContainerModule, this.getAuthRequestContext, create5));
        }

        private GetAuthCode getAuthRequestContext() {
            return new GetAuthCode((OauthRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SummaryVoucherView$$ExternalSyntheticLambda1()), new GetEmptyUserInfo((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
        }

        private GetAccount PlaceComponentResult() {
            return new GetAccount((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()));
        }

        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent PlaceComponentResult;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SubSequence());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SendRiskEventReceiverProvider implements Provider<SendRiskEventReceiver> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SendRiskEventReceiverProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendRiskEventReceiver get() {
                return (SendRiskEventReceiver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SecuritySettingsActivity$createPinLauncher$2$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FaceAuthenticationRepositoryProvider implements Provider<FaceAuthenticationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FaceAuthenticationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthenticationRepository get() {
                return (FaceAuthenticationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.OtpRegistrationPresenter$input$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.j());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideTransferAccountRepositoryProvider implements Provider<TransferAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideTransferAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TransferAccountRepository get() {
                return (TransferAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.checkRegisteredUserAndSendOtp());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getContainerAuth());
            }
        }

        /* loaded from: classes4.dex */
        public static final class TwilioEntityRepositoryProvider implements Provider<TwilioSdkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            TwilioEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioSdkRepository get() {
                return (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentRepositoryProvider implements Provider<TwilioRepository> {
            private final ApplicationComponent getAuthRequestContext;

            TwilioEnrollmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioRepository get() {
                return (TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ReferralRepositoryProvider implements Provider<ReferralRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ReferralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralRepository get() {
                return (ReferralRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NewMerchantCategoryAdapter());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.WithdrawSavedCardChannelView());
            }
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(RequestResultBridge requestResultBridge) {
            RequestResultBridge_MembersInjector.injectSplitFacade(requestResultBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
            RequestResultBridge_MembersInjector.injectGetService(requestResultBridge, new GetService((ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1())));
            RequestResultBridge_MembersInjector.injectConsultAgreement(requestResultBridge, new ConsultAgreement((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(BcaWebviewEventHandler bcaWebviewEventHandler) {
            BcaWebviewEventHandler_MembersInjector.injectGetListWebviewInterceptorDataConfig(bcaWebviewEventHandler, new GetListWebviewInterceptorDataConfig((WebviewInterceptorRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.InvestmentWalletAdapter())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(BioUtilityBridge bioUtilityBridge) {
            BioUtilityBridge_MembersInjector.injectDefaultFaceAuthenticationManager(bioUtilityBridge, this.whenAvailable.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetBridge bottomSheetBridge) {
            BottomSheetBridge_MembersInjector.injectServicesBottomSheetManager(bottomSheetBridge, this.BottomSheetCardBindingView$watcherCardNumberView$1.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(CardBindingBridge cardBindingBridge) {
            CardBindingBridge_MembersInjector.injectFeatureCardBinding(cardBindingBridge, new FeatureCardBinding(new GetIsCardBindingV2Enabled((CardBindingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.z()))));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(CashierUrlEventHandler cashierUrlEventHandler) {
            CashierUrlEventHandler_MembersInjector.injectCashierEventHandler(cashierUrlEventHandler, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ContactBridge contactBridge) {
            ContactBridge_MembersInjector.injectGetContactByPhoneNumber(contactBridge, new GetContactByPhoneNumber((ContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(CutomRedirectToBridge cutomRedirectToBridge) {
            CutomRedirectToBridge_MembersInjector.injectMiniProgramPreference(cutomRedirectToBridge, new MiniProgramPreference((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(DanaProtectionBridge danaProtectionBridge) {
            DanaProtectionBridge_MembersInjector.injectGetDanaProtectionWidgetConfig(danaProtectionBridge, new GetDanaProtectionWidgetConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5()), (DanaProtectionInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$1())));
            DanaProtectionBridge_MembersInjector.injectGetDanaProtectionRecommendation(danaProtectionBridge, new GetDanaProtectionRecommendation((FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda3()), (CredentialRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$2()), (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getPhoneMask()), (DanaProtectionInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$1())));
            DanaProtectionBridge_MembersInjector.injectGetDanaProtectionInfo(danaProtectionBridge, new GetDanaProtectionInfo((DanaProtectionInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$1())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(RiskChallengeBridge riskChallengeBridge) {
            RiskChallengeBridge_MembersInjector.injectGetAccount(riskChallengeBridge, PlaceComponentResult());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(EasterEggsEventHandler easterEggsEventHandler) {
            EasterEggsEventHandler_MembersInjector.injectDeviceInformationProvider(easterEggsEventHandler, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            EasterEggsEventHandler_MembersInjector.injectDatabase(easterEggsEventHandler, (BasePersistenceDao) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.m()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(FaceAuthenticationBridge faceAuthenticationBridge) {
            FaceAuthenticationBridge_MembersInjector.injectFaceAuthenticationManager(faceAuthenticationBridge, this.whenAvailable.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(GetOnlineConfigBridge getOnlineConfigBridge) {
            GetOnlineConfigBridge_MembersInjector.injectGetH5OnlineConfig(getOnlineConfigBridge, new GetH5OnlineConfig((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (H5OnlineConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.A())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(GlobalNetworkBridge globalNetworkBridge) {
            GlobalNetworkBridge_MembersInjector.injectGlobalNetworkPluginManager(globalNetworkBridge, this.readMicros.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(GetLocationNameBridge getLocationNameBridge) {
            GetLocationNameBridge_MembersInjector.injectGetIndoSubdivisionsByLocation(getLocationNameBridge, new GetIndoSubdivisionsByLocation((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (GeocodeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getSupportButtonTintMode())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(MapsUtilityBridge mapsUtilityBridge) {
            MapsUtilityBridge_MembersInjector.injectSplitFacade(mapsUtilityBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(MixpanelBridge mixpanelBridge) {
            StrictBaseBridge_MembersInjector.injectSplitFacade(mixpanelBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
            MixpanelBridge_MembersInjector.injectGetService(mixpanelBridge, new GetService((ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void PlaceComponentResult(NfcUtilityBridge nfcUtilityBridge) {
            NfcUtilityBridge_MembersInjector.injectGetElectronicMoneyConfig(nfcUtilityBridge, new GetElectronicMoneyConfig((ElectronicmoneyRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(QrBindingCatcherEventHandler qrBindingCatcherEventHandler) {
            QrBindingCatcherEventHandler_MembersInjector.injectGetQrBindingConfig(qrBindingCatcherEventHandler, new GetQrBindingConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(ShowReferralEngagementDialogBridge showReferralEngagementDialogBridge) {
            ShowReferralEngagementDialogBridge_MembersInjector.injectSaveReferralEngagementDialogCache(showReferralEngagementDialogBridge, this.C.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(GetPhoneNumberBridge getPhoneNumberBridge) {
            GetPhoneNumberBridge_MembersInjector.injectGetPhoneNumber(getPhoneNumberBridge, new GetPhoneNumberAttempt((RegistrationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.rotateTo())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SelfUnfreezeEventHandler selfUnfreezeEventHandler) {
            SelfUnfreezeEventHandler_MembersInjector.injectGetResetAndChangePinNativeEntryConfig(selfUnfreezeEventHandler, new GetResetAndChangePinNativeEntryConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())));
            SelfUnfreezeEventHandler_MembersInjector.injectGetTempRegistrationPhoneNumber(selfUnfreezeEventHandler, new GetTempRegistrationPhoneNumber((ResetPinRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getContainerAuth())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(SendEventBridge sendEventBridge) {
            SendEventBridge_MembersInjector.injectRemoteGnPaymentEntityData(sendEventBridge, (RemoteGnPaymentEntityData) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getFontAssetManager()));
            SendEventBridge_MembersInjector.injectSplitFacade(sendEventBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
            SendEventBridge_MembersInjector.injectSaveLastTransaction(sendEventBridge, new SaveLastTransaction((AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory())));
            SendEventBridge_MembersInjector.injectGetContactsUseCase(sendEventBridge, (GetContactsUseCase) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.p()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(SendMoneyBridge sendMoneyBridge) {
            SendMoneyBridge_MembersInjector.injectSendMoneyEventHandler(sendMoneyBridge, this.B.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(ShareBridge shareBridge) {
            ShareBridge_MembersInjector.injectShareTextBroadcastReceiver(shareBridge, this.VerifyPinStateManager$executeRiskChallenge$2$1.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(ShareToFeedBridge shareToFeedBridge) {
            StrictBaseBridge_MembersInjector.injectSplitFacade(shareToFeedBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ShowAgreementBridge showAgreementBridge) {
            ShowAgreementBridge_MembersInjector.injectGetService(showAgreementBridge, new GetService((ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1())));
            ShowAgreementBridge_MembersInjector.injectConsultAgreement(showAgreementBridge, new ConsultAgreement((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            ShowAgreementBridge_MembersInjector.injectRecordAgreement(showAgreementBridge, new RecordAgreement((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            ShowAgreementBridge_MembersInjector.injectGetEmptyUserInfo(showAgreementBridge, new GetEmptyUserInfo((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            ShowAgreementBridge_MembersInjector.injectGetAuthCode(showAgreementBridge, getAuthRequestContext());
            ShowAgreementBridge_MembersInjector.injectBuildIncompleteUserDataContent(showAgreementBridge, new BuildIncompleteUserDataContent((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            ShowAgreementBridge_MembersInjector.injectBuildAgreementContent(showAgreementBridge, new BuildAgreementContent((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillBridge splitBillBridge) {
            SplitBillBridge_MembersInjector.injectSplitBillEventHandler(splitBillBridge, this.A.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(CallSubAppBridge callSubAppBridge) {
            CallSubAppBridge_MembersInjector.injectCashierEventHandler(callSubAppBridge, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(SuggestLocationsBridge suggestLocationsBridge) {
            SuggestLocationsBridge_MembersInjector.injectGetListSuggestedLocations(suggestLocationsBridge, new GetListSuggestedLocations((NearbyPlaceRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.S())));
            SuggestLocationsBridge_MembersInjector.injectDeviceInformationProvider(suggestLocationsBridge, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(TncCardPaymentBridge tncCardPaymentBridge) {
            TncCardPaymentBridge_MembersInjector.injectTncCardPaymentEventHandler(tncCardPaymentBridge, this.VerifyPinStateManager$executeRiskChallenge$2$2.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(GeneralTrackEventBridge generalTrackEventBridge) {
            StrictBaseBridge_MembersInjector.injectSplitFacade(generalTrackEventBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(StartTimeEventBridge startTimeEventBridge) {
            StrictBaseBridge_MembersInjector.injectSplitFacade(startTimeEventBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void BuiltInFictitiousFunctionClassFactory(TrackEventBridge trackEventBridge) {
            StrictBaseBridge_MembersInjector.injectSplitFacade(trackEventBridge, (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash()));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void MyBillsEntityDataFactory(TwilioVerifySecurityProductBridge twilioVerifySecurityProductBridge) {
            TwilioVerifySecurityProductBridge_MembersInjector.injectTwilioVerifySecurityProductManager(twilioVerifySecurityProductBridge, this.D.get());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(UploadFilesBridge uploadFilesBridge) {
            UploadFilesBridge_MembersInjector.injectGetSelectedFiles(uploadFilesBridge, new GetSelectedFiles((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectAddSelectedFiles(uploadFilesBridge, new AddSelectedFiles((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectRemoveSelectedFile(uploadFilesBridge, new RemoveSelectedFile((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectUploadFile(uploadFilesBridge, new UploadFile((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectClearFiles(uploadFilesBridge, new ClearFiles((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectSetTotalFilesSize(uploadFilesBridge, new SetTotalFilesSize((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
            UploadFilesBridge_MembersInjector.injectGetTotalFilesSize(uploadFilesBridge, new GetTotalFilesSize((UploadFilesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ApiStatus$AvailableSince())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(GetUsernameBridge getUsernameBridge) {
            GetUsernameBridge_MembersInjector.injectGetAccount(getUsernameBridge, PlaceComponentResult());
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(OauthServiceProvider oauthServiceProvider) {
            oauthServiceProvider.miniProgramPreference = new MiniProgramPreference((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()));
            OauthServiceProvider_MembersInjector.PlaceComponentResult(oauthServiceProvider, (RemoteGnPaymentEntityData) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getFontAssetManager()));
            oauthServiceProvider.checkUserInfo = new GetEmptyUserInfo((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView()));
            OauthServiceProvider_MembersInjector.getAuthRequestContext(oauthServiceProvider, new ConsultAgreement((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            OauthServiceProvider_MembersInjector.getAuthRequestContext(oauthServiceProvider, new RecordAgreement((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            OauthServiceProvider_MembersInjector.MyBillsEntityDataFactory(oauthServiceProvider, getAuthRequestContext());
            oauthServiceProvider.splitFacade = (SplitFacade) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.secondaryHash());
            OauthServiceProvider_MembersInjector.BuiltInFictitiousFunctionClassFactory(oauthServiceProvider, new BuildIncompleteUserDataContent((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
            OauthServiceProvider_MembersInjector.BuiltInFictitiousFunctionClassFactory(oauthServiceProvider, new BuildAgreementContent((UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView())));
        }

        @Override // id.dana.di.component.GContainerComponent
        public final void getAuthRequestContext(GetEnvInfoBridge getEnvInfoBridge) {
            GetEnvInfoBridge_MembersInjector.getAuthRequestContext(getEnvInfoBridge, new GetMobileEnvInfo((LoginRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.G())));
        }
    }
}
