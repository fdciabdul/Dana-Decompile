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
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl_Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayCashier_Factory;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier_Factory;
import id.dana.cashier.mapper.AttributeModelMapper;
import id.dana.cashier.mapper.AttributeModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper_Factory;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper_Factory;
import id.dana.cashier.mapper.VoucherCashierModelsMapper;
import id.dana.cashier.mapper.VoucherCashierModelsMapper_Factory;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.challenge.pin.PinAuthAgreementPresenter;
import id.dana.challenge.pin.PinAuthAgreementPresenter_Factory;
import id.dana.challenge.pin.PinChallengeFragment;
import id.dana.challenge.pin.PinChallengeFragment_MembersInjector;
import id.dana.challenge.pin.PinLoginPresenter;
import id.dana.challenge.pin.PinLoginPresenter_Factory;
import id.dana.challenge.pin.PinPaymentAuthPresenter;
import id.dana.challenge.pin.PinPaymentAuthPresenter_Factory;
import id.dana.challenge.pin.PinSwitchAutoRoutePresenter;
import id.dana.challenge.pin.PinSwitchAutoRoutePresenter_Factory;
import id.dana.challenge.pin.PinSwitchFaceAuthPresenter;
import id.dana.challenge.pin.PinSwitchFaceAuthPresenter_Factory;
import id.dana.challenge.pin.PinTwilioPresenter;
import id.dana.challenge.pin.PinTwilioPresenter_Factory;
import id.dana.challenge.pin.presenter.PinCardBindingPresenter;
import id.dana.challenge.pin.presenter.PinCardBindingPresenter_Factory;
import id.dana.challenge.pin.presenter.PinFamilyAccountPresenter;
import id.dana.challenge.pin.presenter.PinFamilyAccountPresenter_Factory;
import id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter;
import id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter_Factory;
import id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter;
import id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.modules.PinChallengeModule;
import id.dana.di.modules.PinChallengeModule_ProvidePresenterFactory;
import id.dana.di.modules.PinChallengeModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.auth.face.interactor.VerifyFaceAuthentication;
import id.dana.domain.auth.face.interactor.VerifyFaceAuthentication_Factory;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation_Factory;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember_Factory;
import id.dana.domain.featureconfig.AppGeneralRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckFaceLoginFeature;
import id.dana.domain.featureconfig.interactor.CheckFaceLoginFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.Login;
import id.dana.domain.login.interactor.Login_Factory;
import id.dana.domain.login.interactor.Trust2RiskLogin;
import id.dana.domain.login.interactor.Trust2RiskLogin_Factory;
import id.dana.domain.login.interactor.TrustRiskLogin;
import id.dana.domain.login.interactor.TrustRiskLogin_Factory;
import id.dana.domain.login.interactor.VerifyPasswordTrustRiskV2;
import id.dana.domain.login.interactor.VerifyPasswordTrustRiskV2_Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.interactor.UnbindMerchant;
import id.dana.domain.merchantmanagement.interactor.UnbindMerchant_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.registration.interactor.GetChatBotTimestamp_Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll_Factory;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct_Factory;
import id.dana.domain.wallet_v3.interactor.VerifyPinPersonalKtp;
import id.dana.domain.wallet_v3.interactor.VerifyPinPersonalKtp_Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper_Factory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission_Factory;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPinChallengeComponent {
    private DaggerPinChallengeComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FaceAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public PinChallengeModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PinChallengeComponentImpl implements PinChallengeComponent {
        private Provider<PasskeyTrackerImpl> A;
        private Provider<PinSwitchAutoRoutePresenter> AppCompatEmojiTextHelper;
        private Provider<MixpanelAnalytics> B;
        private Provider<PayCashier> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AttributeModelMapper> BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantManagementRepository> C;
        private Provider<PinAuthAgreementPresenter> D;
        private Provider<ContactRepository> DatabaseTableConfigUtil;
        private Provider<PinCardBindingPresenter> E;
        private Provider<PinTwilioPresenter> F;
        private Provider<GetChatBotTimestamp> FragmentBottomSheetPaymentSettingBinding;
        private Provider<PinSwitchFaceAuthPresenter> G;
        private Provider<CheckKnowledgeBasedAuthFeature> GetContactSyncConfig;
        private Provider<PinLoginPresenter> H;
        private Provider<PinPaymentAuthPresenter> I;
        private Provider<PinUnbindMerchantPresenter> J;
        private Provider<PostExecutionThread> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<PinWalletPersonalKtpPresenter> L;
        private Provider<BotProtectionChallenge> M;
        private Provider<AppGeneralRepository> MyBillsEntityDataFactory;
        private Provider<LoginTracker> N;
        private Provider<CashierPayModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ControlSwitchPaymentAuthentication> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CouponPayMethodInfoListModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FinishForceDanaVizEnroll> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetQueryUserDataConfig> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FirebaseAnalytics> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<GetIsSyncPermission> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DanaVizTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<FamilyAccountRepository> O;
        private Provider<FaceAuthentication> P;
        private Provider<AnalyticsTrackerFactory> PlaceComponentResult;
        private Provider<FaceAuthenticationRepository> PrepareContext;
        private Provider<FirebasePerformanceMonitor> Q;
        private Provider<VerifyPasswordTrustRiskV2> QrExpiredActivity;
        private Provider<AbstractPinContract.Presenter> R;
        private Provider<RegistrationRepository> S;
        private Provider<LiteAccountRepository> SubSequence;
        private Provider<PersonalTabRepository> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<ResetPinRepository> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<SplitFacade> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<SettingRepository> T;
        private Provider<RemoveFamilyAccount> U;
        private Provider<RemoveFamilyMember> V;
        private Provider<LoginRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<PinFamilyAccountPresenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<SwitchAutoRouting> W;
        private Provider<SaveIsSyncPermission> X;
        private Provider<TwilioRepository> Y;
        private Provider<TwilioVerifySecurityProduct> Z;

        /* renamed from: a */
        private Provider<UnbindMerchant> f8150a;
        private Provider<VoucherCashierModelsMapper> b;
        private Provider<VerifyFaceAuthentication> c;
        private Provider<VerifyPinPersonalKtp> d;
        private Provider<TrustRiskLogin> flip;
        private Provider<AcceptFamilyInvitation> getAuthRequestContext;
        private Provider<InviteFamilyAccount> getCallingPid;
        private Provider<CashierRepository> getErrorConfigVersion;
        private Provider<EventTrackerQueue> getNameOrBuilderList;
        private Provider<PayQueryCashier> getOnBoardingScenario;
        private Provider<IsAppFirstLaunch> getSupportButtonTintMode;
        private final PinChallengeComponentImpl getValueOfTouchPositionAbsolute;
        private Provider<Context> initRecordTimeStamp;
        private Provider<AbstractPinContract.View> isAuth;
        private Provider<ThreadExecutor> isAuto;
        private Provider<FeatureConfigRepository> isLayoutRequested;
        private Provider<CashierPayChannelModelsMapper> lookAheadTest;
        private Provider<AutoRouteRepository> moveToNextValue;
        private Provider<CouponPayMethodInfoModelMapper> newProxyInstance;
        private Provider<GetUserId> readMicros;
        private Provider<CheckFaceLoginFeature> scheduleImpl;
        private Provider<Trust2RiskLogin> shouldRecycleViewType;
        private Provider<Login> whenAvailable;

        public /* synthetic */ PinChallengeComponentImpl(PinChallengeModule pinChallengeModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(pinChallengeModule, faceAuthenticationModule, applicationComponent);
        }

        private PinChallengeComponentImpl(PinChallengeModule pinChallengeModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.getValueOfTouchPositionAbsolute = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.isAuth = DoubleCheck.getAuthRequestContext(PinChallengeModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(pinChallengeModule));
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = loginRepositoryProvider;
            this.whenAvailable = Login_Factory.create(loginRepositoryProvider);
            this.flip = TrustRiskLogin_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.isAuto = new ThreadExecutorProvider(applicationComponent);
            this.K = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.isLayoutRequested = featureConfigRepositoryProvider;
            this.GetContactSyncConfig = CheckKnowledgeBasedAuthFeature_Factory.create(this.isAuto, this.K, featureConfigRepositoryProvider);
            AppGeneralRepositoryProvider appGeneralRepositoryProvider = new AppGeneralRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = appGeneralRepositoryProvider;
            this.getSupportButtonTintMode = IsAppFirstLaunch_Factory.create(this.isAuto, this.K, appGeneralRepositoryProvider);
            this.initRecordTimeStamp = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DeviceInformationProviderProvider(applicationComponent);
            this.scheduleImpl = CheckFaceLoginFeature_Factory.create(this.isLayoutRequested);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = new ProvideSplitFacadeProvider(applicationComponent);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.SubSequence = liteAccountRepositoryProvider;
            this.readMicros = GetUserId_Factory.create(this.isAuto, this.K, liteAccountRepositoryProvider);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = contractRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = GetIsSyncPermission_Factory.PlaceComponentResult(contractRepositoryProvider);
            this.X = SaveIsSyncPermission_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.S = registrationRepositoryProvider;
            this.FragmentBottomSheetPaymentSettingBinding = GetChatBotTimestamp_Factory.create(registrationRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = GetQueryUserDataConfig_Factory.create(this.isLayoutRequested);
            this.N = new ProvideLoginTrackerProvider(applicationComponent);
            this.QrExpiredActivity = VerifyPasswordTrustRiskV2_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.shouldRecycleViewType = Trust2RiskLogin_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.Q = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.getNameOrBuilderList = provideEventTrackerQueueProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FirebaseAnalytics_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.Q, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.getNameOrBuilderList);
            this.B = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.PlaceComponentResult = PlaceComponentResult;
            PasskeyTrackerImpl_Factory authRequestContext = PasskeyTrackerImpl_Factory.getAuthRequestContext(PlaceComponentResult);
            this.A = authRequestContext;
            this.H = DoubleCheck.getAuthRequestContext(PinLoginPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.isAuth, this.whenAvailable, this.flip, this.GetContactSyncConfig, this.getSupportButtonTintMode, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.scheduleImpl, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.X, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.N, this.QrExpiredActivity, this.shouldRecycleViewType, authRequestContext));
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.T = settingRepositoryProvider;
            ControlSwitchPaymentAuthentication_Factory create = ControlSwitchPaymentAuthentication_Factory.create(this.isAuto, this.K, settingRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = create;
            this.I = PinPaymentAuthPresenter_Factory.getAuthRequestContext(this.initRecordTimeStamp, this.isAuth, create);
            FaceAuthenticationRepositoryProvider faceAuthenticationRepositoryProvider = new FaceAuthenticationRepositoryProvider(applicationComponent);
            this.PrepareContext = faceAuthenticationRepositoryProvider;
            this.c = VerifyFaceAuthentication_Factory.create(faceAuthenticationRepositoryProvider);
            this.P = FaceAuthenticationModule_ProvideFaceAuthenticationFactory.getAuthRequestContext(faceAuthenticationModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DanaVizTrackerImpl_Factory.PlaceComponentResult(this.PlaceComponentResult);
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = provideResetPinRepositoryProvider;
            FinishForceDanaVizEnroll_Factory create2 = FinishForceDanaVizEnroll_Factory.create(provideResetPinRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = create2;
            this.G = PinSwitchFaceAuthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.c, this.readMicros, this.P, this.isAuth, this.NetworkUserEntityData$$ExternalSyntheticLambda8, create2);
            MerchantManagementRepositoryProvider merchantManagementRepositoryProvider = new MerchantManagementRepositoryProvider(applicationComponent);
            this.C = merchantManagementRepositoryProvider;
            UnbindMerchant_Factory create3 = UnbindMerchant_Factory.create(merchantManagementRepositoryProvider);
            this.f8150a = create3;
            this.J = PinUnbindMerchantPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.isAuth, create3);
            TwilioEnrollmentRepositoryProvider twilioEnrollmentRepositoryProvider = new TwilioEnrollmentRepositoryProvider(applicationComponent);
            this.Y = twilioEnrollmentRepositoryProvider;
            TwilioVerifySecurityProduct_Factory create4 = TwilioVerifySecurityProduct_Factory.create(this.isAuto, this.K, twilioEnrollmentRepositoryProvider);
            this.Z = create4;
            this.F = PinTwilioPresenter_Factory.BuiltInFictitiousFunctionClassFactory(create4, this.isAuth);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.moveToNextValue = autoRouteRepositoryProvider;
            SwitchAutoRouting_Factory create5 = SwitchAutoRouting_Factory.create(autoRouteRepositoryProvider);
            this.W = create5;
            this.AppCompatEmojiTextHelper = PinSwitchAutoRoutePresenter_Factory.getAuthRequestContext(this.initRecordTimeStamp, create5, this.isAuth);
            this.D = PinAuthAgreementPresenter_Factory.PlaceComponentResult(this.isAuth, this.Z);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.O = provideFamilyAccountRepositoryProvider;
            this.getCallingPid = InviteFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.U = RemoveFamilyAccount_Factory.create(this.O);
            this.V = RemoveFamilyMember_Factory.create(this.O);
            AcceptFamilyInvitation_Factory create6 = AcceptFamilyInvitation_Factory.create(this.O);
            this.getAuthRequestContext = create6;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = PinFamilyAccountPresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.getCallingPid, this.U, this.V, create6, this.Z, this.isAuth);
            ProvidePersonalTabRepositoryProvider providePersonalTabRepositoryProvider = new ProvidePersonalTabRepositoryProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = providePersonalTabRepositoryProvider;
            VerifyPinPersonalKtp_Factory create7 = VerifyPinPersonalKtp_Factory.create(providePersonalTabRepositoryProvider);
            this.d = create7;
            this.L = PinWalletPersonalKtpPresenter_Factory.MyBillsEntityDataFactory(this.isAuth, create7);
            CashierRepositoryProvider cashierRepositoryProvider = new CashierRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = cashierRepositoryProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = PayCashier_Factory.create(cashierRepositoryProvider);
            this.getOnBoardingScenario = PayQueryCashier_Factory.create(this.getErrorConfigVersion);
            CouponPayMethodInfoModelMapper_Factory PlaceComponentResult2 = CouponPayMethodInfoModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.newProxyInstance = PlaceComponentResult2;
            CouponPayMethodInfoListModelMapper_Factory BuiltInFictitiousFunctionClassFactory = CouponPayMethodInfoListModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = BuiltInFictitiousFunctionClassFactory;
            VoucherCashierModelsMapper_Factory authRequestContext2 = VoucherCashierModelsMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            this.b = authRequestContext2;
            CashierPayChannelModelsMapper_Factory PlaceComponentResult3 = CashierPayChannelModelsMapper_Factory.PlaceComponentResult(authRequestContext2);
            this.lookAheadTest = PlaceComponentResult3;
            AttributeModelMapper_Factory BuiltInFictitiousFunctionClassFactory2 = AttributeModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult3);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
            CashierPayModelMapper_Factory authRequestContext3 = CashierPayModelMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext3;
            PinCardBindingPresenter_Factory PlaceComponentResult4 = PinCardBindingPresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.getOnBoardingScenario, authRequestContext3, this.isAuth);
            this.E = PlaceComponentResult4;
            this.R = DoubleCheck.getAuthRequestContext(PinChallengeModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(pinChallengeModule, this.H, this.I, this.G, this.J, this.F, this.AppCompatEmojiTextHelper, this.D, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.L, PlaceComponentResult4));
            this.M = new ProvideBotProtectionChallengeProvider(applicationComponent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AppGeneralRepositoryProvider implements Provider<AppGeneralRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AppGeneralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AppGeneralRepository get() {
                return (AppGeneralRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideSplitFacadeProvider implements Provider<SplitFacade> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideSplitFacadeProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitFacade get() {
                return (SplitFacade) Preconditions.PlaceComponentResult(this.getAuthRequestContext.secondaryHash());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.rotateTo());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideLoginTrackerProvider implements Provider<LoginTracker> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideLoginTrackerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginTracker get() {
                return (LoginTracker) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.v());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isInfoWindowShown());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthenticationRepositoryProvider implements Provider<FaceAuthenticationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FaceAuthenticationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthenticationRepository get() {
                return (FaceAuthenticationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getContainerAuth());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantManagementRepositoryProvider implements Provider<MerchantManagementRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MerchantManagementRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantManagementRepository get() {
                return (MerchantManagementRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.O());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentRepositoryProvider implements Provider<TwilioRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            TwilioEnrollmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioRepository get() {
                return (TwilioRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvidePersonalTabRepositoryProvider implements Provider<PersonalTabRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvidePersonalTabRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PersonalTabRepository get() {
                return (PersonalTabRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.RequestMoneyQrContract$View());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class CashierRepositoryProvider implements Provider<CashierRepository> {
            private final ApplicationComponent PlaceComponentResult;

            CashierRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CashierRepository get() {
                return (CashierRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.lookAheadTest());
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

        @Override // id.dana.di.component.PinChallengeComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PinChallengeFragment pinChallengeFragment) {
            PinChallengeFragment_MembersInjector.getAuthRequestContext(pinChallengeFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
            PinChallengeFragment_MembersInjector.MyBillsEntityDataFactory(pinChallengeFragment, this.R.get());
            PinChallengeFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(pinChallengeFragment, DoubleCheck.MyBillsEntityDataFactory(this.M));
        }
    }
}
