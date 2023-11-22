package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.TransferAccountSuccessModule;
import id.dana.di.modules.TransferAccountSuccessModule_ProvidePresenterFactory;
import id.dana.di.modules.TransferAccountSuccessModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.transferaccount.TransferAccountRepository;
import id.dana.domain.transferaccount.interactor.ClearTransferAccountCache;
import id.dana.domain.transferaccount.interactor.ClearTransferAccountCache_Factory;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.transferaccount.success.TransferAccountSuccessActivity;
import id.dana.transferaccount.success.TransferAccountSuccessActivity_MembersInjector;
import id.dana.transferaccount.success.TransferAccountSuccessContract;
import id.dana.transferaccount.success.TransferAccountSuccessPresenter;
import id.dana.transferaccount.success.TransferAccountSuccessPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerTransferAccountSuccessComponent {
    private DaggerTransferAccountSuccessComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public TransferAccountSuccessModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class TransferAccountSuccessComponentImpl implements TransferAccountSuccessComponent {
        private Provider<TransferAccountSuccessPresenter> B;
        private Provider<ClearCacheFavoriteServices> BuiltInFictitiousFunctionClassFactory;
        private Provider<DeviceInformationProvider> DatabaseTableConfigUtil;
        private Provider<HomeWidgetClearable> FragmentBottomSheetPaymentSettingBinding;
        private Provider<FeatureConfigRepository> GetContactSyncConfig;
        private Provider<ClearAllDanapolyData> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ClearAllSyncEngineUseCase> MyBillsEntityDataFactory;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GlobalNetworkRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaSessionManager> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<TransferAccountSuccessContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeedInitRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<TransferAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DanapolyClearRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<Logout> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ClearAllFeedsUsecase> PlaceComponentResult;
        private Provider<IsOfflineF2FPay> PrepareContext;
        private Provider<SSLPinningRepository> SubSequence;
        private final ApplicationComponent getAuthRequestContext;
        private final TransferAccountSuccessComponentImpl getCallingPid;
        private Provider<ClearKybData> getErrorConfigVersion;
        private Provider<TransferAccountSuccessContract.View> getSupportButtonTintMode;
        private Provider<ForceLogout> initRecordTimeStamp;
        private Provider<KybRepository> isLayoutRequested;
        private Provider<ContactRepository> lookAheadTest;
        private Provider<ClearTransferAccountCache> moveToNextValue;
        private Provider<LoginRepository> newProxyInstance;
        private Provider<ThreadExecutor> readMicros;
        private Provider<ConnectionStatusReceiver> scheduleImpl;
        private Provider<ServicesRepository> whenAvailable;

        public /* synthetic */ TransferAccountSuccessComponentImpl(TransferAccountSuccessModule transferAccountSuccessModule, ApplicationComponent applicationComponent, byte b) {
            this(transferAccountSuccessModule, applicationComponent);
        }

        private TransferAccountSuccessComponentImpl(TransferAccountSuccessModule transferAccountSuccessModule, ApplicationComponent applicationComponent) {
            this.getCallingPid = this;
            this.getAuthRequestContext = applicationComponent;
            this.readMicros = new ThreadExecutorProvider(applicationComponent);
            this.SubSequence = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda7, featureConfigRepositoryProvider);
            this.PrepareContext = create;
            this.scheduleImpl = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.readMicros, this.SubSequence, create);
            ProvideTransferAccountRepositoryProvider provideTransferAccountRepositoryProvider = new ProvideTransferAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provideTransferAccountRepositoryProvider;
            this.moveToNextValue = ClearTransferAccountCache_Factory.create(provideTransferAccountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new DeviceInformationProviderProvider(applicationComponent);
            this.newProxyInstance = new LoginRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideHomeWidgetClearableProvider;
            this.initRecordTimeStamp = ForceLogout_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda1, provideHomeWidgetClearableProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = Logout_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.newProxyInstance, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.lookAheadTest = contractRepositoryProvider;
            this.MyBillsEntityDataFactory = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provideFeedInitRepositoryProvider;
            this.PlaceComponentResult = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.whenAvailable = servicesRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provideDanapolyClearRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.isLayoutRequested = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.getErrorConfigVersion = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DanaSessionManager_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext);
            Provider<TransferAccountSuccessContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(TransferAccountSuccessModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(transferAccountSuccessModule));
            this.getSupportButtonTintMode = authRequestContext2;
            TransferAccountSuccessPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = TransferAccountSuccessPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda2, authRequestContext2);
            this.B = KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(TransferAccountSuccessModule_ProvidePresenterFactory.MyBillsEntityDataFactory(transferAccountSuccessModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent getAuthRequestContext;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent getAuthRequestContext;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        @Override // id.dana.di.component.TransferAccountSuccessComponent
        public final void PlaceComponentResult(TransferAccountSuccessActivity transferAccountSuccessActivity) {
            ((BaseActivity) transferAccountSuccessActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(transferAccountSuccessActivity, DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(transferAccountSuccessActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            TransferAccountSuccessActivity_MembersInjector.PlaceComponentResult(transferAccountSuccessActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
        }
    }
}
