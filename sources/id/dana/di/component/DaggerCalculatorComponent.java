package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.SendMoneyPresenter;
import id.dana.contract.sendmoney.SendMoneyPresenter_Factory;
import id.dana.di.modules.SendMoneyModule;
import id.dana.di.modules.SendMoneyModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact_Factory;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature_Factory;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitTransferMoney_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
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
import id.dana.sendmoney.summary.view.SummaryView;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCalculatorComponent {
    private DaggerCalculatorComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SendMoneyCoreModule BuiltInFictitiousFunctionClassFactory;
        public SendMoneyModule KClassImpl$Data$declaredNonStaticMembers$2;
        public SendMoneyTrackerModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CalculatorComponentImpl implements CalculatorComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<SendMoneyContract.Presenter> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SaveDanaUserContact> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<InitSendMoneyContact> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<RecentContactRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SendMoneyContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SendMoneyInitMapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SendMoneyPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final CalculatorComponentImpl PlaceComponentResult;
        private Provider<SendMoneyMixpanelTracker> PrepareContext;
        private Provider<CheckTransferX2PFeature> getAuthRequestContext;
        private Provider<InitTransferMoney> getErrorConfigVersion;
        private Provider<SendMoneyAnalyticTracker> initRecordTimeStamp;
        private Provider<SendMoneyRepository> isLayoutRequested;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<GetPhoneNumber> moveToNextValue;
        private final SendMoneyCoreModule newProxyInstance;
        private Provider<LiteAccountRepository> scheduleImpl;

        public /* synthetic */ CalculatorComponentImpl(SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent, byte b) {
            this(sendMoneyModule, sendMoneyTrackerModule, sendMoneyCoreModule, applicationComponent);
        }

        private CalculatorComponentImpl(SendMoneyModule sendMoneyModule, SendMoneyTrackerModule sendMoneyTrackerModule, SendMoneyCoreModule sendMoneyCoreModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.newProxyInstance = sendMoneyCoreModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.FragmentBottomSheetPaymentSettingBinding = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.isLayoutRequested = sendMoneyRepositoryProvider;
            this.getErrorConfigVersion = InitTransferMoney_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.lookAheadTest, sendMoneyRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendMoneyModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            this.getAuthRequestContext = CheckTransferX2PFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.lookAheadTest, featureConfigRepositoryProvider);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.scheduleImpl = liteAccountRepositoryProvider;
            this.moveToNextValue = GetPhoneNumber_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.lookAheadTest, liteAccountRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = SendMoneyInitMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentContactRepositoryProvider;
            this.GetContactSyncConfig = SaveDanaUserContact_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.lookAheadTest, recentContactRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = InitSendMoneyContact_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.lookAheadTest, this.isLayoutRequested);
            Provider<SendMoneyPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SendMoneyPresenter_Factory.getAuthRequestContext(this.getErrorConfigVersion, TransferBankMapper_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getAuthRequestContext, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, TransferContactMapper_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda0, WithdrawOTCMapper_Factory.MyBillsEntityDataFactory()));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(SendMoneyModule_ProvidePresenterFactory.MyBillsEntityDataFactory(sendMoneyModule, authRequestContext));
            SendMoneyMixpanelTracker_Factory authRequestContext2 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.PrepareContext = authRequestContext2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext2));
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
        /* loaded from: classes4.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.AppCompatEmojiTextHelper());
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
            private final ApplicationComponent PlaceComponentResult;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ReferralMapper_Factory());
            }
        }

        @Override // id.dana.di.component.CalculatorComponent
        public final void PlaceComponentResult(SummaryView summaryView) {
            summaryView.presenter = this.DatabaseTableConfigUtil.get();
            summaryView.sendMoneyCorePresenter = SendMoneyCoreModule_ProvidePresenterFactory.PlaceComponentResult(this.newProxyInstance, new SendMoneyCorePresenter(SendMoneyCoreModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(this.newProxyInstance), new GetSendMoneyApiMigrationConfig((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WrappedDrawableState())), new GetTransferBalanceInit((SendMoneyCoreRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WrappedDrawableState())), new GetUserId((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper())), new GetPhoneNumber((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper()))));
            summaryView.sendMoneyAnalyticalTracker = this.initRecordTimeStamp.get();
        }
    }
}
