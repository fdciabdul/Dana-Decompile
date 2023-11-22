package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.SendMoneyExternalModule;
import id.dana.di.modules.SendMoneyExternalModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyExternalModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sendmoney.interactor.GetWithdrawChannelInfoData;
import id.dana.domain.sendmoney.interactor.GetWithdrawChannelInfoData_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitTransferMoney_Factory;
import id.dana.domain.sendmoney.interactor.InitWithdraw;
import id.dana.domain.sendmoney.interactor.InitWithdraw_Factory;
import id.dana.domain.sendmoney.interactor.IsNeedToShowExternalOnboardingDialog;
import id.dana.domain.sendmoney.interactor.IsNeedToShowExternalOnboardingDialog_Factory;
import id.dana.domain.sendmoney.interactor.SaveExternalOnboardingDialog;
import id.dana.domain.sendmoney.interactor.SaveExternalOnboardingDialog_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.sendmoney.external.SendMoneyExternalActivity;
import id.dana.sendmoney.external.SendMoneyExternalActivity_MembersInjector;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.external.SendMoneyExternalPresenter;
import id.dana.sendmoney.external.SendMoneyExternalPresenter_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import id.dana.sendmoney.mapper.TransferMethodMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawChannelModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawInitChannelOptionModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawInitMethodOptionModelMapper;
import id.dana.sendmoney.mapper.WithdrawInitMethodOptionModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawMethodOptionModelMapper;
import id.dana.sendmoney.mapper.WithdrawMethodOptionModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawSavedCardChannelModelMapper_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSendMoneyExternalComponent {
    private DaggerSendMoneyExternalComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public SendMoneyTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public SendMoneyExternalModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SendMoneyExternalComponentImpl implements SendMoneyExternalComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SendMoneyAnalyticTracker> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<InitWithdraw> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SendMoneyExternalContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<WithdrawInitMethodOptionModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<TransferMethodMapper> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<WithdrawMethodOptionModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<SendMoneyExternalPresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private final SendMoneyExternalComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetUserInfoWithKyc> PlaceComponentResult;
        private Provider<SendMoneyRepository> PrepareContext;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<GetWithdrawChannelInfoData> getErrorConfigVersion;
        private Provider<SendMoneyExternalContract.View> initRecordTimeStamp;
        private Provider<SaveExternalOnboardingDialog> isLayoutRequested;
        private Provider<IsNeedToShowExternalOnboardingDialog> lookAheadTest;
        private Provider<InitTransferMoney> moveToNextValue;
        private Provider<SendMoneyMixpanelTracker> newProxyInstance;
        private Provider<IsOfflineF2FPay> scheduleImpl;

        public /* synthetic */ SendMoneyExternalComponentImpl(SendMoneyExternalModule sendMoneyExternalModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(sendMoneyExternalModule, sendMoneyTrackerModule, applicationComponent);
        }

        private SendMoneyExternalComponentImpl(SendMoneyExternalModule sendMoneyExternalModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.FragmentBottomSheetPaymentSettingBinding = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SSLPinningRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.DatabaseTableConfigUtil, featureConfigRepositoryProvider);
            this.scheduleImpl = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            this.MyBillsEntityDataFactory = new ContextProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.PrepareContext = sendMoneyRepositoryProvider;
            this.moveToNextValue = InitTransferMoney_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.DatabaseTableConfigUtil, sendMoneyRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = InitWithdraw_Factory.create(this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = WithdrawMethodOptionModelMapper_Factory.getAuthRequestContext(WithdrawSavedCardChannelModelMapper_Factory.MyBillsEntityDataFactory(), WithdrawChannelModelMapper_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = TransferMethodMapper_Factory.MyBillsEntityDataFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.lookAheadTest = IsNeedToShowExternalOnboardingDialog_Factory.create(this.PrepareContext);
            this.isLayoutRequested = SaveExternalOnboardingDialog_Factory.create(this.PrepareContext);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = userRepositoryProvider;
            this.PlaceComponentResult = GetUserInfoWithKyc_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.DatabaseTableConfigUtil, userRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = WithdrawInitMethodOptionModelMapper_Factory.getAuthRequestContext(WithdrawSavedCardChannelModelMapper_Factory.MyBillsEntityDataFactory(), WithdrawInitChannelOptionModelMapper_Factory.PlaceComponentResult());
            this.getErrorConfigVersion = GetWithdrawChannelInfoData_Factory.create(this.PrepareContext);
            Provider<SendMoneyExternalContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(SendMoneyExternalModule_ProvideViewFactory.MyBillsEntityDataFactory(sendMoneyExternalModule));
            this.initRecordTimeStamp = authRequestContext;
            SendMoneyExternalPresenter_Factory MyBillsEntityDataFactory = SendMoneyExternalPresenter_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.lookAheadTest, this.isLayoutRequested, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getErrorConfigVersion, authRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(SendMoneyExternalModule_ProvidePresenterFactory.MyBillsEntityDataFactory(sendMoneyExternalModule, MyBillsEntityDataFactory));
            SendMoneyMixpanelTracker_Factory authRequestContext2 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.MyBillsEntityDataFactory);
            this.newProxyInstance = authRequestContext2;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext2));
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
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        @Override // id.dana.di.component.SendMoneyExternalComponent
        public final void PlaceComponentResult(SendMoneyExternalActivity sendMoneyExternalActivity) {
            ((BaseActivity) sendMoneyExternalActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendMoneyExternalActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(sendMoneyExternalActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            SendMoneyExternalActivity_MembersInjector.PlaceComponentResult(sendMoneyExternalActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            SendMoneyExternalActivity_MembersInjector.PlaceComponentResult(sendMoneyExternalActivity, this.GetContactSyncConfig.get());
        }
    }
}
