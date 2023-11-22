package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.RecipientPresenter;
import id.dana.contract.sendmoney.RecipientPresenter_Factory;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.SendMoneyPresenter;
import id.dana.contract.sendmoney.SendMoneyPresenter_Factory;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.BillerX2BModule_ProvidePresenterFactory;
import id.dana.di.modules.BillerX2BModule_ProvideViewFactory;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.RecipientActivityModule_ProvidePresenterFactory;
import id.dana.di.modules.RecipientActivityModule_ProvideViewFactory;
import id.dana.di.modules.SendMoneyModule;
import id.dana.di.modules.SendMoneyModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
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
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig_Factory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature_Factory;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix_Factory;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature_Factory;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature_Factory;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B_Factory;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig_Factory;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitTransferMoney_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
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
import id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity_MembersInjector;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSearchActivityComponent {
    private DaggerSearchActivityComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public RecipientActivityModule BuiltInFictitiousFunctionClassFactory;
        public SendMoneyCoreModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public BillerX2BModule PlaceComponentResult;
        public SendMoneyModule getAuthRequestContext;
        public SendMoneyTrackerModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SearchActivityComponentImpl implements SearchActivityComponent {
        private Provider<SaveDanaUserContact> A;
        private Provider<SendMoneyInitMapper> AppCompatEmojiTextHelper;
        private Provider<SSLPinningRepository> B;
        private Provider<RecentRecipientRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<ReferralConfigRepository> C;
        private Provider<SaveRecentBank> D;
        private Provider<GetEmptyUserInfo> DatabaseTableConfigUtil;
        private Provider<SendDigitalMoneyRepository> E;
        private Provider<SendMoneyMixpanelTracker> F;
        private Provider<RecipientContract.Presenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SendMoneyRepository> G;
        private Provider<GetReferralSendMoneyConfig> GetContactSyncConfig;
        private Provider<SendMoneyPresenter> H;
        private final SendMoneyCoreModule I;
        private Provider<ThreadExecutor> J;
        private Provider<CheckTransferX2PFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<UserConsentRepository> M;
        private Provider<CheckCardNoPrefixFeature> MyBillsEntityDataFactory;
        private Provider<GetAllBillerX2B> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetAuthCode> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetPhoneNumber> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SendMoneyContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<SendMoneyAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<BillerX2BContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<InitTransferMoney> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<BillerX2BPresenter> PlaceComponentResult;
        private Provider<LiteAccountRepository> PrepareContext;
        private Provider<RecentContactRepository> SubSequence;
        private Provider<RecipientPresenter> VerifyPinStateManager$executeRiskChallenge$2$1;
        private final SearchActivityComponentImpl VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<CheckBelowKitkatDialogX2BFeature> getAuthRequestContext;
        private Provider<BillerX2BContract.View> getCallingPid;
        private Provider<ConnectionStatusReceiver> getErrorConfigVersion;
        private Provider<SaveRecentGroup> getOnBoardingScenario;
        private Provider<SendMoneyContract.View> getSupportButtonTintMode;
        private Provider<SaveRecentContact> getValueOfTouchPositionAbsolute;
        private Provider<GetSmartFrictionConfig> initRecordTimeStamp;
        private Provider<OauthRepository> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<DeviceInformationProvider> moveToNextValue;
        private Provider<InitSendMoneyContact> newProxyInstance;
        private Provider<RecipientContract.View> readMicros;
        private Provider<Context> scheduleImpl;
        private Provider<QueryCardWithoutPrefix> whenAvailable;

        public /* synthetic */ SearchActivityComponentImpl(RecipientActivityModule recipientActivityModule, BillerX2BModule billerX2BModule, SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent, byte b) {
            this(recipientActivityModule, billerX2BModule, sendMoneyModule, sendMoneyTrackerModule, sendMoneyCoreModule, applicationComponent);
        }

        private SearchActivityComponentImpl(RecipientActivityModule recipientActivityModule, BillerX2BModule billerX2BModule, SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.I = sendMoneyCoreModule;
            this.J = new ThreadExecutorProvider(applicationComponent);
            this.B = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = create;
            this.getErrorConfigVersion = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.J, this.B, create);
            this.readMicros = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvideViewFactory.getAuthRequestContext(recipientActivityModule));
            this.getAuthRequestContext = CheckBelowKitkatDialogX2BFeature_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.lookAheadTest);
            ReferralConfigRepositoryProvider referralConfigRepositoryProvider = new ReferralConfigRepositoryProvider(applicationComponent);
            this.C = referralConfigRepositoryProvider;
            this.GetContactSyncConfig = GetReferralSendMoneyConfig_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, referralConfigRepositoryProvider);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = recentRecipientRepositoryProvider;
            this.D = SaveRecentBank_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, recentRecipientRepositoryProvider);
            this.getValueOfTouchPositionAbsolute = SaveRecentContact_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.initRecordTimeStamp = GetSmartFrictionConfig_Factory.create(this.lookAheadTest);
            SaveRecentGroup_Factory create2 = SaveRecentGroup_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.getOnBoardingScenario = create2;
            Provider<RecipientPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(RecipientPresenter_Factory.PlaceComponentResult(this.readMicros, this.getAuthRequestContext, this.GetContactSyncConfig, this.D, this.getValueOfTouchPositionAbsolute, this.initRecordTimeStamp, create2));
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = authRequestContext;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvidePresenterFactory.getAuthRequestContext(recipientActivityModule, authRequestContext));
            this.getCallingPid = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvideViewFactory.getAuthRequestContext(billerX2BModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.G = sendMoneyRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetAllBillerX2B_Factory.create(sendMoneyRepositoryProvider);
            SendDigitalMoneyRepositoryProvider sendDigitalMoneyRepositoryProvider = new SendDigitalMoneyRepositoryProvider(applicationComponent);
            this.E = sendDigitalMoneyRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckCardNoPrefixFeature_Factory.create(sendDigitalMoneyRepositoryProvider);
            this.whenAvailable = QueryCardWithoutPrefix_Factory.create(this.E);
            this.isLayoutRequested = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.M = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create3 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.DatabaseTableConfigUtil = create3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetAuthCode_Factory.create(this.isLayoutRequested, create3);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.moveToNextValue = deviceInformationProviderProvider;
            Provider<BillerX2BPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(BillerX2BPresenter_Factory.PlaceComponentResult(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda1, deviceInformationProviderProvider, this.D));
            this.PlaceComponentResult = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvidePresenterFactory.PlaceComponentResult(billerX2BModule, authRequestContext2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = InitTransferMoney_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.G);
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendMoneyModule));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckTransferX2PFeature_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.lookAheadTest);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.PrepareContext = liteAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetPhoneNumber_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, liteAccountRepositoryProvider);
            this.scheduleImpl = new ContextProvider(applicationComponent);
            this.AppCompatEmojiTextHelper = SendMoneyInitMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.SubSequence = recentContactRepositoryProvider;
            this.A = SaveDanaUserContact_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, recentContactRepositoryProvider);
            this.newProxyInstance = InitSendMoneyContact_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.G);
            Provider<SendMoneyPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(SendMoneyPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, TransferBankMapper_Factory.getAuthRequestContext(), this.getSupportButtonTintMode, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl, TransferContactMapper_Factory.MyBillsEntityDataFactory(), this.AppCompatEmojiTextHelper, this.A, this.newProxyInstance, WithdrawOTCMapper_Factory.MyBillsEntityDataFactory()));
            this.H = authRequestContext3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvidePresenterFactory.MyBillsEntityDataFactory(sendMoneyModule, authRequestContext3));
            SendMoneyMixpanelTracker_Factory authRequestContext4 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.scheduleImpl);
            this.F = authRequestContext4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext4));
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
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
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SendDigitalMoneyRepositoryProvider implements Provider<SendDigitalMoneyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SendDigitalMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendDigitalMoneyRepository get() {
                return (SendDigitalMoneyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.encodingStream());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent getAuthRequestContext;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView());
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
        /* loaded from: classes4.dex */
        public static final class RecentContactRepositoryProvider implements Provider<RecentContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ReferralMapper_Factory());
            }
        }

        @Override // id.dana.di.component.SearchActivityComponent
        public final void BuiltInFictitiousFunctionClassFactory(SearchRecipientActivity searchRecipientActivity) {
            ((BaseActivity) searchRecipientActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(searchRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(searchRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
            BaseRecipientActivity_MembersInjector.MyBillsEntityDataFactory(searchRecipientActivity, this.FragmentBottomSheetPaymentSettingBinding.get());
            SearchRecipientActivity_MembersInjector.getAuthRequestContext(searchRecipientActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
            searchRecipientActivity.calculatorPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda3.get();
            SearchRecipientActivity_MembersInjector.PlaceComponentResult(searchRecipientActivity, SendMoneyCoreModule_ProvidePresenterFactory.PlaceComponentResult(this.I, new SendMoneyCorePresenter(SendMoneyCoreModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(this.I), new GetSendMoneyApiMigrationConfig((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WrappedDrawableState())), new GetTransferBalanceInit((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WrappedDrawableState())), new GetUserId((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper())), new GetPhoneNumber((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper())))));
            SearchRecipientActivity_MembersInjector.MyBillsEntityDataFactory(searchRecipientActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda5.get());
        }
    }
}
