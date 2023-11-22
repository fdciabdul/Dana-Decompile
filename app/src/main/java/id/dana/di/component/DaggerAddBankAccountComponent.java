package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.bank.BankSelectorActivity;
import id.dana.bank.BankSelectorActivity_MembersInjector;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.bank.contract.BankSelectorPresenter;
import id.dana.bank.contract.BankSelectorPresenter_Factory;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.BankSelectorModule;
import id.dana.di.modules.BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory;
import id.dana.di.modules.BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.BillerX2BModule_ProvidePresenterFactory;
import id.dana.di.modules.BillerX2BModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.bank.interactor.CheckUserBankExist;
import id.dana.domain.bank.interactor.CheckUserBankExist_Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.interactor.GetBankSelectorConfig;
import id.dana.domain.requestmoney.interactor.GetBankSelectorConfig_Factory;
import id.dana.domain.requestmoney.interactor.GetNameCheckCount;
import id.dana.domain.requestmoney.interactor.GetNameCheckCount_Factory;
import id.dana.domain.requestmoney.interactor.IsFreezeNameCheck;
import id.dana.domain.requestmoney.interactor.IsFreezeNameCheck_Factory;
import id.dana.domain.requestmoney.interactor.NameCheck;
import id.dana.domain.requestmoney.interactor.NameCheck_Factory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature_Factory;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix_Factory;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.sendmoney.mapper.BankModelMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney.mapper.PayMethodRiskMapper_Factory;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerAddBankAccountComponent {
    private DaggerAddBankAccountComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SendMoneyTrackerModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;
        public BillerX2BModule PlaceComponentResult;
        public BankSelectorModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class AddBankAccountComponentImpl implements AddBankAccountComponent {
        private Provider<SendMoneyRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<BillerX2BPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> C;
        private Provider<GetRecentRecipient> DatabaseTableConfigUtil;
        private Provider<UserBankRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<NameCheck> GetContactSyncConfig;
        private Provider<CheckCardNoPrefixFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckUserBankExist> MyBillsEntityDataFactory;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetEmptyUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetNameCheckCount> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SendMoneyAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<QueryCardWithoutPrefix> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<BillerX2BContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<RecentRecipientRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<BillerX2BContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<BankSelectorContract.View> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<BankSelectorPresenter> PlaceComponentResult;
        private Provider<OauthRepository> PrepareContext;
        private Provider<SaveRecentBank> SubSequence;
        private Provider<UserConsentRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private final AddBankAccountComponentImpl getAuthRequestContext;
        private Provider<SendDigitalMoneyRepository> getCallingPid;
        private Provider<GetAuthCode> getErrorConfigVersion;
        private Provider<RequestMoneyRepository> getSupportButtonTintMode;
        private Provider<IsFreezeNameCheck> initRecordTimeStamp;
        private Provider<BankSelectorContract.Presenter> isLayoutRequested;
        private Provider<GetAllBillerX2B> lookAheadTest;
        private Provider<Context> moveToNextValue;
        private Provider<PostExecutionThread> newProxyInstance;
        private Provider<SendMoneyMixpanelTracker> readMicros;
        private Provider<GetBankSelectorConfig> scheduleImpl;
        private Provider<SendMoneyBankMapper> whenAvailable;

        public /* synthetic */ AddBankAccountComponentImpl(BankSelectorModule bankSelectorModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(bankSelectorModule, billerX2BModule, sendMoneyTrackerModule, applicationComponent);
        }

        private AddBankAccountComponentImpl(BankSelectorModule bankSelectorModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory.MyBillsEntityDataFactory(bankSelectorModule));
            this.moveToNextValue = new ContextProvider(applicationComponent);
            this.whenAvailable = SendMoneyBankMapper_Factory.PlaceComponentResult(PayMethodRiskMapper_Factory.getAuthRequestContext(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.getSupportButtonTintMode = new RequestMoneyRepositoryProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = sendMoneyRepositoryProvider;
            this.GetContactSyncConfig = NameCheck_Factory.create(this.getSupportButtonTintMode, sendMoneyRepositoryProvider);
            this.initRecordTimeStamp = IsFreezeNameCheck_Factory.create(this.getSupportButtonTintMode);
            this.scheduleImpl = GetBankSelectorConfig_Factory.create(this.getSupportButtonTintMode, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetNameCheckCount_Factory.create(this.getSupportButtonTintMode);
            ProvideUserBankRepositoryProvider provideUserBankRepositoryProvider = new ProvideUserBankRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideUserBankRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckUserBankExist_Factory.create(provideUserBankRepositoryProvider);
            this.C = new ThreadExecutorProvider(applicationComponent);
            this.newProxyInstance = new PostExecutionThreadProvider(applicationComponent);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = recentRecipientRepositoryProvider;
            GetRecentRecipient_Factory create = GetRecentRecipient_Factory.create(this.C, this.newProxyInstance, recentRecipientRepositoryProvider);
            this.DatabaseTableConfigUtil = create;
            BankSelectorPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = BankSelectorPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.moveToNextValue, this.whenAvailable, this.GetContactSyncConfig, this.initRecordTimeStamp, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.MyBillsEntityDataFactory, create, BankModelMapper_Factory.MyBillsEntityDataFactory());
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(bankSelectorModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvideViewFactory.getAuthRequestContext(billerX2BModule));
            this.lookAheadTest = GetAllBillerX2B_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            SendDigitalMoneyRepositoryProvider sendDigitalMoneyRepositoryProvider = new SendDigitalMoneyRepositoryProvider(applicationComponent);
            this.getCallingPid = sendDigitalMoneyRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckCardNoPrefixFeature_Factory.create(sendDigitalMoneyRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = QueryCardWithoutPrefix_Factory.create(this.getCallingPid);
            this.PrepareContext = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = create2;
            this.getErrorConfigVersion = GetAuthCode_Factory.create(this.PrepareContext, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DeviceInformationProviderProvider(applicationComponent);
            SaveRecentBank_Factory create3 = SaveRecentBank_Factory.create(this.C, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.SubSequence = create3;
            Provider<BillerX2BPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(BillerX2BPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create3));
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvidePresenterFactory.PlaceComponentResult(billerX2BModule, authRequestContext));
            SendMoneyMixpanelTracker_Factory authRequestContext2 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.moveToNextValue);
            this.readMicros = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext2));
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
        public static final class RequestMoneyRepositoryProvider implements Provider<RequestMoneyRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            RequestMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RequestMoneyRepository get() {
                return (RequestMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FlowableConcatMapEagerPublisher());
            }
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class ProvideUserBankRepositoryProvider implements Provider<UserBankRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideUserBankRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserBankRepository get() {
                return (UserBankRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$getCapacity$p());
            }
        }

        /* loaded from: classes4.dex */
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
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.access$setShowcaseShowing$p());
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
            private final ApplicationComponent PlaceComponentResult;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        @Override // id.dana.di.component.AddBankAccountComponent
        public final void getAuthRequestContext(BankSelectorActivity bankSelectorActivity) {
            BankSelectorActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bankSelectorActivity, this.isLayoutRequested.get());
            BankSelectorActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bankSelectorActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda7.get());
            BankSelectorActivity_MembersInjector.getAuthRequestContext(bankSelectorActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
        }
    }
}
