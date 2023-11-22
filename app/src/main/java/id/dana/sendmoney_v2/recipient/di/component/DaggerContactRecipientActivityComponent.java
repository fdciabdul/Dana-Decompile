package id.dana.sendmoney_v2.recipient.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.referraltracker.ReferralTrackerPresenter;
import id.dana.contract.referraltracker.ReferralTrackerPresenter_Factory;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.RecipientPresenter;
import id.dana.contract.sendmoney.RecipientPresenter_Factory;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.SendMoneyPresenter;
import id.dana.contract.sendmoney.SendMoneyPresenter_Factory;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.RecipientActivityModule_ProvidePresenterFactory;
import id.dana.di.modules.RecipientActivityModule_ProvideViewFactory;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.di.modules.ReferralTrackerModule_ProvidePresenterFactory;
import id.dana.di.modules.ReferralTrackerModule_ProvideViewFactory;
import id.dana.di.modules.SendMoneyModule;
import id.dana.di.modules.SendMoneyModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate;
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact_Factory;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentcontact.interactor.SaveRecentContact_Factory;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.interactor.GetLatestReferralCampaign;
import id.dana.domain.referral.interactor.GetLatestReferralCampaign_Factory;
import id.dana.domain.referral.interactor.GetReferralBanner;
import id.dana.domain.referral.interactor.GetReferralBanner_Factory;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign_Factory;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig_Factory;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.interactor.GetReferralTracker_Factory;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets_Factory;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature_Factory;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature_Factory;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig_Factory;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitTransferMoney_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.interactor.SyncOneContact;
import id.dana.domain.synccontact.interactor.SyncOneContact_Factory;
import id.dana.mapper.ReferralTrackerModelMapper_Factory;
import id.dana.mapper.ReferralWidgetModelMapper_Factory;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.referral.model.ReferralBannerMapper_Factory;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney.di.module.SendMoneyCoreModule_ProvidePresenterFactory;
import id.dana.sendmoney.di.module.SendMoneyCoreModule_ProvideViewFactory;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import id.dana.sendmoney.domain.core.interactor.GetSendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.interactor.GetTransferBalanceInit;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney.mapper.SendMoneyInitMapper;
import id.dana.sendmoney.mapper.SendMoneyInitMapper_Factory;
import id.dana.sendmoney.mapper.TransferBankMapper_Factory;
import id.dana.sendmoney.mapper.TransferContactMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawOTCMapper_Factory;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity_MembersInjector;
import id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity_MembersInjector;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerContactRecipientActivityComponent {
    private DaggerContactRecipientActivityComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public RecipientActivityModule BuiltInFictitiousFunctionClassFactory;
        public SendMoneyModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public SendMoneyCoreModule PlaceComponentResult;
        public ReferralTrackerModule getAuthRequestContext;
        public SendMoneyTrackerModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContactRecipientActivityComponentImpl implements ContactRecipientActivityComponent {
        private Provider<RecentRecipientRepository> A;
        private Provider<SaveDanaUserContact> AppCompatEmojiTextHelper;
        private Provider<ReferralTrackerContract.View> B;
        private Provider<RecipientPresenter> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckTransferX2PFeature> BuiltInFictitiousFunctionClassFactory;
        private Provider<RecentContactRepository> C;
        private Provider<ReferralConfigRepository> D;
        private Provider<GetPhoneNumber> DatabaseTableConfigUtil;
        private Provider<ReferralWidgetRepository> E;
        private Provider<SaveRecentBank> F;
        private Provider<MyReferralConsultMapper> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SaveRecentContact> G;
        private Provider<GetReferralSendMoneyConfig> GetContactSyncConfig;
        private Provider<SaveLastSeenReferralCampaign> H;
        private Provider<SaveRecentGroup> I;
        private Provider<SendMoneyRepository> J;
        private final SendMoneyCoreModule K;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SendMoneyMixpanelTracker> L;
        private Provider<SendMoneyPresenter> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<SyncContactRepository> N;
        private Provider<GenerateReferralDeepLink> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetReferralConsult> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetReferralMessageTemplate> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<LiteAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<MyReferralConsultRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetSmartFrictionConfig> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetReferralWidgets> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ThreadExecutor> P;
        private final ContactRecipientActivityComponentImpl PlaceComponentResult;
        private Provider<GetReferralTracker> PrepareContext;
        private Provider<RecipientContract.View> SubSequence;
        private Provider<SyncOneContact> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<SendMoneyContract.View> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<ReferralTrackerPresenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<CheckBelowKitkatDialogX2BFeature> getAuthRequestContext;
        private Provider<SendMoneyAnalyticTracker> getCallingPid;
        private Provider<GenerateLinkRepository> getErrorConfigVersion;
        private Provider<SendMoneyInitMapper> getNameOrBuilderList;
        private Provider<ReferralTrackerRepository> getOnBoardingScenario;
        private Provider<RecipientContract.Presenter> getSupportButtonTintMode;
        private Provider<SSLPinningRepository> getValueOfTouchPositionAbsolute;
        private Provider<GetReferralBanner> initRecordTimeStamp;
        private Provider<InitSendMoneyContact> isLayoutRequested;
        private Provider<GetLatestReferralCampaign> lookAheadTest;
        private Provider<FeatureConfigRepository> moveToNextValue;
        private Provider<InitTransferMoney> newProxyInstance;
        private Provider<SendMoneyContract.Presenter> readMicros;
        private Provider<Context> scheduleImpl;
        private Provider<ReferralTrackerContract.Presenter> whenAvailable;

        public /* synthetic */ ContactRecipientActivityComponentImpl(RecipientActivityModule recipientActivityModule, ReferralTrackerModule referralTrackerModule, SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent, byte b) {
            this(recipientActivityModule, referralTrackerModule, sendMoneyModule, sendMoneyTrackerModule, sendMoneyCoreModule, applicationComponent);
        }

        private ContactRecipientActivityComponentImpl(RecipientActivityModule recipientActivityModule, ReferralTrackerModule referralTrackerModule, SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent) {
            ReferralTrackerModelMapper_Factory referralTrackerModelMapper_Factory;
            this.PlaceComponentResult = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.K = sendMoneyCoreModule;
            this.P = new ThreadExecutorProvider(applicationComponent);
            this.getValueOfTouchPositionAbsolute = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.moveToNextValue = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.P, this.getValueOfTouchPositionAbsolute, create);
            this.SubSequence = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvideViewFactory.getAuthRequestContext(recipientActivityModule));
            this.getAuthRequestContext = CheckBelowKitkatDialogX2BFeature_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.moveToNextValue);
            ReferralConfigRepositoryProvider referralConfigRepositoryProvider = new ReferralConfigRepositoryProvider(applicationComponent);
            this.D = referralConfigRepositoryProvider;
            this.GetContactSyncConfig = GetReferralSendMoneyConfig_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, referralConfigRepositoryProvider);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.A = recentRecipientRepositoryProvider;
            this.F = SaveRecentBank_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, recentRecipientRepositoryProvider);
            this.G = SaveRecentContact_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.A);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetSmartFrictionConfig_Factory.create(this.moveToNextValue);
            SaveRecentGroup_Factory create2 = SaveRecentGroup_Factory.create(this.A);
            this.I = create2;
            Provider<RecipientPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(RecipientPresenter_Factory.PlaceComponentResult(this.SubSequence, this.getAuthRequestContext, this.GetContactSyncConfig, this.F, this.G, this.NetworkUserEntityData$$ExternalSyntheticLambda7, create2));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = authRequestContext;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvidePresenterFactory.getAuthRequestContext(recipientActivityModule, authRequestContext));
            this.B = DoubleCheck.getAuthRequestContext(ReferralTrackerModule_ProvideViewFactory.MyBillsEntityDataFactory(referralTrackerModule));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = myReferralConsultRepositoryProvider;
            this.H = SaveLastSeenReferralCampaign_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, myReferralConsultRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            SyncContactRepositoryProvider syncContactRepositoryProvider = new SyncContactRepositoryProvider(applicationComponent);
            this.N = syncContactRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = SyncOneContact_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, syncContactRepositoryProvider, this.moveToNextValue);
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = generateLinkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GenerateReferralDeepLink_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, generateLinkRepositoryProvider);
            this.initRecordTimeStamp = GetReferralBanner_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            ReferralTrackerRepositoryProvider referralTrackerRepositoryProvider = new ReferralTrackerRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = referralTrackerRepositoryProvider;
            this.PrepareContext = GetReferralTracker_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, referralTrackerRepositoryProvider);
            ReferralWidgetRepositoryProvider referralWidgetRepositoryProvider = new ReferralWidgetRepositoryProvider(applicationComponent);
            this.E = referralWidgetRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = GetReferralWidgets_Factory.create(referralWidgetRepositoryProvider);
            this.lookAheadTest = GetLatestReferralCampaign_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetReferralConsult_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetReferralMessageTemplate_Factory.create(this.moveToNextValue);
            Provider<ReferralTrackerContract.View> provider = this.B;
            ReferralWidgetModelMapper_Factory PlaceComponentResult = ReferralWidgetModelMapper_Factory.PlaceComponentResult();
            Provider<SaveLastSeenReferralCampaign> provider2 = this.H;
            Provider<MyReferralConsultMapper> provider3 = this.FragmentBottomSheetPaymentSettingBinding;
            Provider<SyncOneContact> provider4 = this.SummaryVoucherView$$ExternalSyntheticLambda0;
            Provider<GenerateReferralDeepLink> provider5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Provider<GetReferralBanner> provider6 = this.initRecordTimeStamp;
            ReferralBannerMapper_Factory MyBillsEntityDataFactory = ReferralBannerMapper_Factory.MyBillsEntityDataFactory();
            Provider<GetReferralTracker> provider7 = this.PrepareContext;
            referralTrackerModelMapper_Factory = ReferralTrackerModelMapper_Factory.InstanceHolder.getAuthRequestContext;
            ReferralTrackerPresenter_Factory PlaceComponentResult2 = ReferralTrackerPresenter_Factory.PlaceComponentResult(provider, PlaceComponentResult, provider2, provider3, provider4, provider5, provider6, MyBillsEntityDataFactory, provider7, referralTrackerModelMapper_Factory, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = PlaceComponentResult2;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(ReferralTrackerModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(referralTrackerModule, PlaceComponentResult2));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.J = sendMoneyRepositoryProvider;
            this.newProxyInstance = InitTransferMoney_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, sendMoneyRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendMoneyModule));
            this.BuiltInFictitiousFunctionClassFactory = CheckTransferX2PFeature_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.moveToNextValue);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = liteAccountRepositoryProvider;
            this.DatabaseTableConfigUtil = GetPhoneNumber_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, liteAccountRepositoryProvider);
            this.scheduleImpl = new ContextProvider(applicationComponent);
            this.getNameOrBuilderList = SendMoneyInitMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.C = recentContactRepositoryProvider;
            this.AppCompatEmojiTextHelper = SaveDanaUserContact_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, recentContactRepositoryProvider);
            this.isLayoutRequested = InitSendMoneyContact_Factory.create(this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.J);
            Provider<SendMoneyPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(SendMoneyPresenter_Factory.getAuthRequestContext(this.newProxyInstance, TransferBankMapper_Factory.getAuthRequestContext(), this.VerifyPinStateManager$executeRiskChallenge$2$1, this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, this.scheduleImpl, TransferContactMapper_Factory.MyBillsEntityDataFactory(), this.getNameOrBuilderList, this.AppCompatEmojiTextHelper, this.isLayoutRequested, WithdrawOTCMapper_Factory.MyBillsEntityDataFactory()));
            this.M = authRequestContext2;
            this.readMicros = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvidePresenterFactory.MyBillsEntityDataFactory(sendMoneyModule, authRequestContext2));
            SendMoneyMixpanelTracker_Factory authRequestContext3 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.scheduleImpl);
            this.L = authRequestContext3;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class ReferralConfigRepositoryProvider implements Provider<ReferralConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ReferralConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralConfigRepository get() {
                return (ReferralConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.insertActivities());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SyncContactRepositoryProvider implements Provider<SyncContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SyncContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SyncContactRepository get() {
                return (SyncContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.containsObjectForKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ReferralTrackerRepositoryProvider implements Provider<ReferralTrackerRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ReferralTrackerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralTrackerRepository get() {
                return (ReferralTrackerRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getReadyFragment());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ReferralWidgetRepositoryProvider implements Provider<ReferralWidgetRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ReferralWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralWidgetRepository get() {
                return (ReferralWidgetRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isRegionMiniProgram());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class RecentContactRepositoryProvider implements Provider<RecentContactRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ReferralMapper_Factory());
            }
        }

        @Override // id.dana.sendmoney_v2.recipient.di.component.ContactRecipientActivityComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ContactRecipientActivity contactRecipientActivity) {
            ((BaseActivity) contactRecipientActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(contactRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(contactRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseRecipientActivity_MembersInjector.MyBillsEntityDataFactory(contactRecipientActivity, this.getSupportButtonTintMode.get());
            contactRecipientActivity.referralTrackerPresenter = this.whenAvailable.get();
            ContactRecipientActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(contactRecipientActivity, this.readMicros.get());
            ContactRecipientActivity_MembersInjector.MyBillsEntityDataFactory(contactRecipientActivity, SendMoneyCoreModule_ProvidePresenterFactory.PlaceComponentResult(this.K, new SendMoneyCorePresenter(SendMoneyCoreModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(this.K), new GetSendMoneyApiMigrationConfig((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WrappedDrawableState())), new GetTransferBalanceInit((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WrappedDrawableState())), new GetUserId((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper())), new GetPhoneNumber((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper())))));
            ContactRecipientActivity_MembersInjector.getAuthRequestContext(contactRecipientActivity, this.getCallingPid.get());
        }
    }
}
