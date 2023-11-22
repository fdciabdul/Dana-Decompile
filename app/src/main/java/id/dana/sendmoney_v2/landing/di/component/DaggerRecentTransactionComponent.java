package id.dana.sendmoney_v2.landing.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.BillerX2BModule_ProvidePresenterFactory;
import id.dana.di.modules.BillerX2BModule_ProvideViewFactory;
import id.dana.di.modules.UserConfigModule;
import id.dana.di.modules.UserConfigModule_ProvideUserConfigPresenterFactory;
import id.dana.di.modules.UserConfigModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash_Factory;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom_Factory;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentContact_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction_Factory;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient_Factory;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature_Factory;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix_Factory;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B_Factory;
import id.dana.domain.sendmoney.interactor.GetRecentGroup;
import id.dana.domain.sendmoney.interactor.GetRecentGroup_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.user.interactor.GetUserPan;
import id.dana.domain.user.interactor.GetUserPan_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper_Factory;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule_ProvidePresenterFactory;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule_ProvideViewFactory;
import id.dana.sendmoney.recipient.recent.RecentRecipientPresenter;
import id.dana.sendmoney.recipient.recent.RecentRecipientPresenter_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView_MembersInjector;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.userconfig.UserConfigContract;
import id.dana.userconfig.UserConfigPresenter;
import id.dana.userconfig.UserConfigPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerRecentTransactionComponent {
    private DaggerRecentTransactionComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public UserConfigModule BuiltInFictitiousFunctionClassFactory;
        public RecentRecipientModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public SendMoneyTrackerModule PlaceComponentResult;
        public BillerX2BModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class RecentTransactionComponentImpl implements RecentTransactionComponent {
        private Provider<SendDigitalMoneyRepository> A;
        private final RecentTransactionComponentImpl B;
        private Provider<SaveRecentBank> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckCardNoPrefixFeature> BuiltInFictitiousFunctionClassFactory;
        private Provider<RecentRecipientRepository> C;
        private Provider<ThreadExecutor> D;
        private Provider<GetRecentContact> DatabaseTableConfigUtil;
        private Provider<UserConfigPresenter> E;
        private Provider<SendMoneyAnalyticTracker> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetRecentRecipient> GetContactSyncConfig;
        private Provider<CheckTransferToLinkFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckSendMoneyPeerToCash> MyBillsEntityDataFactory;
        private Provider<GetAuthCode> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetRecentGroup> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetIsRecentRecipientMigratedToRoom> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<RecentRecipientContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<UserConfigContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<BillerX2BContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetUserPan> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<MaskingRecentRecipient> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<GetRecentTransaction> PrepareContext;
        private Provider<RecentRecipientContract.View> SubSequence;
        private Provider<SendMoneyMixpanelTracker> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<UserRepository> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<BillerX2BPresenter> getAuthRequestContext;
        private Provider<RecentRecipientPresenter> getCallingPid;
        private Provider<GetEmptyUserInfo> getErrorConfigVersion;
        private Provider<UserConsentRepository> getOnBoardingScenario;
        private Provider<UserConfigContract.View> getSupportButtonTintMode;
        private Provider<SendMoneyRepository> getValueOfTouchPositionAbsolute;
        private Provider<GetMaxRecentRecipient> initRecordTimeStamp;
        private Provider<OauthRepository> isLayoutRequested;
        private Provider<DeviceInformationProvider> lookAheadTest;
        private Provider<GetAllBillerX2B> moveToNextValue;
        private Provider<MigrateRecentRecipientConfigToRoom> newProxyInstance;
        private Provider<QueryCardWithoutPrefix> readMicros;
        private Provider<FeatureConfigRepository> scheduleImpl;
        private Provider<BillerX2BContract.View> whenAvailable;

        public /* synthetic */ RecentTransactionComponentImpl(RecentRecipientModule recentRecipientModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, UserConfigModule userConfigModule, ApplicationComponent applicationComponent, byte b) {
            this(recentRecipientModule, billerX2BModule, sendMoneyTrackerModule, userConfigModule, applicationComponent);
        }

        private RecentTransactionComponentImpl(RecentRecipientModule recentRecipientModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, UserConfigModule userConfigModule, ApplicationComponent applicationComponent) {
            this.B = this;
            this.SubSequence = DoubleCheck.getAuthRequestContext(RecentRecipientModule_ProvideViewFactory.MyBillsEntityDataFactory(recentRecipientModule));
            this.D = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new PostExecutionThreadProvider(applicationComponent);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.C = recentRecipientRepositoryProvider;
            this.GetContactSyncConfig = GetRecentRecipient_Factory.create(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda5, recentRecipientRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.scheduleImpl = featureConfigRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckTransferToLinkFeature_Factory.create(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda5, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = CheckSendMoneyPeerToCash_Factory.create(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.scheduleImpl);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = MaskingRecentRecipient_Factory.create(this.C);
            this.initRecordTimeStamp = GetMaxRecentRecipient_Factory.create(this.C);
            this.PrepareContext = GetRecentTransaction_Factory.create(this.C);
            this.DatabaseTableConfigUtil = GetRecentContact_Factory.create(this.C);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetRecentGroup_Factory.create(this.C);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetIsRecentRecipientMigratedToRoom_Factory.create(this.C);
            RecentRecipientPresenter_Factory MyBillsEntityDataFactory = RecentRecipientPresenter_Factory.MyBillsEntityDataFactory(this.SubSequence, this.GetContactSyncConfig, RecentRecipientModelMapper_Factory.PlaceComponentResult(), this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.initRecordTimeStamp, this.PrepareContext, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.getCallingPid = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(RecentRecipientModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(recentRecipientModule, MyBillsEntityDataFactory));
            this.whenAvailable = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvideViewFactory.getAuthRequestContext(billerX2BModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.getValueOfTouchPositionAbsolute = sendMoneyRepositoryProvider;
            this.moveToNextValue = GetAllBillerX2B_Factory.create(sendMoneyRepositoryProvider);
            SendDigitalMoneyRepositoryProvider sendDigitalMoneyRepositoryProvider = new SendDigitalMoneyRepositoryProvider(applicationComponent);
            this.A = sendDigitalMoneyRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckCardNoPrefixFeature_Factory.create(sendDigitalMoneyRepositoryProvider);
            this.readMicros = QueryCardWithoutPrefix_Factory.create(this.A);
            this.isLayoutRequested = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.getErrorConfigVersion = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetAuthCode_Factory.create(this.isLayoutRequested, create);
            this.lookAheadTest = new DeviceInformationProviderProvider(applicationComponent);
            SaveRecentBank_Factory create2 = SaveRecentBank_Factory.create(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.C);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create2;
            Provider<BillerX2BPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(BillerX2BPresenter_Factory.PlaceComponentResult(this.whenAvailable, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, create2));
            this.getAuthRequestContext = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvidePresenterFactory.PlaceComponentResult(billerX2BModule, authRequestContext));
            this.newProxyInstance = MigrateRecentRecipientConfigToRoom_Factory.create(this.C);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = userRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetUserPan_Factory.create(userRepositoryProvider);
            Provider<UserConfigContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(UserConfigModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(userConfigModule));
            this.getSupportButtonTintMode = authRequestContext2;
            UserConfigPresenter_Factory authRequestContext3 = UserConfigPresenter_Factory.getAuthRequestContext(this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7, authRequestContext2);
            this.E = authRequestContext3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(UserConfigModule_ProvideUserConfigPresenterFactory.BuiltInFictitiousFunctionClassFactory(userConfigModule, authRequestContext3));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            SendMoneyMixpanelTracker_Factory authRequestContext4 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(contextProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = authRequestContext4;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext4));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.sendmoney_v2.landing.di.component.RecentTransactionComponent
        public final void PlaceComponentResult(RecentTransactionView recentTransactionView) {
            RecentTransactionView_MembersInjector.PlaceComponentResult(recentTransactionView, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
            RecentTransactionView_MembersInjector.BuiltInFictitiousFunctionClassFactory(recentTransactionView, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
            RecentTransactionView_MembersInjector.BuiltInFictitiousFunctionClassFactory(recentTransactionView, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            RecentTransactionView_MembersInjector.BuiltInFictitiousFunctionClassFactory(recentTransactionView, this.FragmentBottomSheetPaymentSettingBinding.get());
        }
    }
}
