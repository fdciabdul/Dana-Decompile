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
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentcontact.interactor.SaveRecentContact_Factory;
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
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B_Factory;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity_MembersInjector;
import id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity_MembersInjector;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerBankActivityComponent {
    private DaggerBankActivityComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public BillerX2BModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public RecipientActivityModule MyBillsEntityDataFactory;
        public SendMoneyTrackerModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class BankActivityComponentImpl implements BankActivityComponent {
        private Provider<SendMoneyRepository> A;
        private Provider<UserConsentRepository> B;
        private Provider<ThreadExecutor> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckCardNoPrefixFeature> BuiltInFictitiousFunctionClassFactory;
        private Provider<SendMoneyMixpanelTracker> C;
        private Provider<GetReferralSendMoneyConfig> DatabaseTableConfigUtil;
        private Provider<RecipientContract.View> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetEmptyUserInfo> GetContactSyncConfig;
        private final BankActivityComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckBelowKitkatDialogX2BFeature> MyBillsEntityDataFactory;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetSmartFrictionConfig> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetAuthCode> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<RecipientPresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<QueryCardWithoutPrefix> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<BillerX2BContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<RecentRecipientRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<OauthRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<BillerX2BPresenter> PlaceComponentResult;
        private Provider<SendMoneyAnalyticTracker> PrepareContext;
        private Provider<SaveRecentBank> SubSequence;
        private Provider<SendDigitalMoneyRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<ReferralConfigRepository> getCallingPid;
        private Provider<Context> getErrorConfigVersion;
        private Provider<SSLPinningRepository> getSupportButtonTintMode;
        private Provider<IsOfflineF2FPay> initRecordTimeStamp;
        private Provider<BillerX2BContract.Presenter> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<GetAllBillerX2B> moveToNextValue;
        private Provider<RecipientContract.Presenter> newProxyInstance;
        private Provider<SaveRecentGroup> readMicros;
        private Provider<DeviceInformationProvider> scheduleImpl;
        private Provider<SaveRecentContact> whenAvailable;

        public /* synthetic */ BankActivityComponentImpl(RecipientActivityModule recipientActivityModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(recipientActivityModule, billerX2BModule, sendMoneyTrackerModule, applicationComponent);
        }

        private BankActivityComponentImpl(RecipientActivityModule recipientActivityModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.getAuthRequestContext = applicationComponent;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new ThreadExecutorProvider(applicationComponent);
            this.getSupportButtonTintMode = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, featureConfigRepositoryProvider);
            this.initRecordTimeStamp = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.getSupportButtonTintMode, create);
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvideViewFactory.getAuthRequestContext(recipientActivityModule));
            this.MyBillsEntityDataFactory = CheckBelowKitkatDialogX2BFeature_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.lookAheadTest);
            ReferralConfigRepositoryProvider referralConfigRepositoryProvider = new ReferralConfigRepositoryProvider(applicationComponent);
            this.getCallingPid = referralConfigRepositoryProvider;
            this.DatabaseTableConfigUtil = GetReferralSendMoneyConfig_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, referralConfigRepositoryProvider);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = recentRecipientRepositoryProvider;
            this.SubSequence = SaveRecentBank_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, recentRecipientRepositoryProvider);
            this.whenAvailable = SaveRecentContact_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetSmartFrictionConfig_Factory.create(this.lookAheadTest);
            SaveRecentGroup_Factory create2 = SaveRecentGroup_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.readMicros = create2;
            Provider<RecipientPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(RecipientPresenter_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.MyBillsEntityDataFactory, this.DatabaseTableConfigUtil, this.SubSequence, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvidePresenterFactory.getAuthRequestContext(recipientActivityModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvideViewFactory.getAuthRequestContext(billerX2BModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.A = sendMoneyRepositoryProvider;
            this.moveToNextValue = GetAllBillerX2B_Factory.create(sendMoneyRepositoryProvider);
            SendDigitalMoneyRepositoryProvider sendDigitalMoneyRepositoryProvider = new SendDigitalMoneyRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = sendDigitalMoneyRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckCardNoPrefixFeature_Factory.create(sendDigitalMoneyRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = QueryCardWithoutPrefix_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.B = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create3 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.GetContactSyncConfig = create3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetAuthCode_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, create3);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.scheduleImpl = deviceInformationProviderProvider;
            Provider<BillerX2BPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(BillerX2BPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda2, deviceInformationProviderProvider, this.SubSequence));
            this.PlaceComponentResult = authRequestContext2;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvidePresenterFactory.PlaceComponentResult(billerX2BModule, authRequestContext2));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.getErrorConfigVersion = contextProvider;
            SendMoneyMixpanelTracker_Factory authRequestContext3 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(contextProvider);
            this.C = authRequestContext3;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext3));
        }

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

        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
            }
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class ReferralConfigRepositoryProvider implements Provider<ReferralConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ReferralConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralConfigRepository get() {
                return (ReferralConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.insertActivities());
            }
        }

        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$setShowcaseShowing$p());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BaseSocialFeedContract$Presenter());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView());
            }
        }

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

        @Override // id.dana.di.component.BankActivityComponent
        public final void PlaceComponentResult(BankRecipientActivity bankRecipientActivity) {
            ((BaseActivity) bankRecipientActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bankRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(bankRecipientActivity, DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
            BaseRecipientActivity_MembersInjector.MyBillsEntityDataFactory(bankRecipientActivity, this.newProxyInstance.get());
            bankRecipientActivity.billerX2BPresenter = this.isLayoutRequested.get();
            BankRecipientActivity_MembersInjector.MyBillsEntityDataFactory(bankRecipientActivity, this.PrepareContext.get());
        }
    }
}
