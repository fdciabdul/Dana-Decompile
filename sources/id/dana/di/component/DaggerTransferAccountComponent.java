package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.TransferAccountModule;
import id.dana.di.modules.TransferAccountModule_ProvidePresenterFactory;
import id.dana.di.modules.TransferAccountModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.transferaccount.TransferAccountRepository;
import id.dana.domain.transferaccount.interactor.GetTransferAccountStatus;
import id.dana.domain.transferaccount.interactor.GetTransferAccountStatus_Factory;
import id.dana.transferaccount.tracker.TransferAccountTrackerImpl;
import id.dana.transferaccount.tracker.TransferAccountTrackerImpl_Factory;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;
import id.dana.transferaccount.transferaccountstatus.TransferAccountPresenter;
import id.dana.transferaccount.transferaccountstatus.TransferAccountPresenter_Factory;
import id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity;
import id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerTransferAccountComponent {
    private DaggerTransferAccountComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public TransferAccountModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class TransferAccountComponentImpl implements TransferAccountComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private Provider<TransferAccountContract.View> DatabaseTableConfigUtil;
        private Provider<EventTrackerQueue> GetContactSyncConfig;
        private Provider<AnalyticsTrackerFactory> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<GetTransferAccountStatus> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FirebasePerformanceMonitor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<TransferAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<TransferAccountPresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<TransferAccountTrackerImpl> PrepareContext;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<IsOfflineF2FPay> getErrorConfigVersion;
        private Provider<TransferAccountContract.Presenter> initRecordTimeStamp;
        private Provider<SSLPinningRepository> isLayoutRequested;
        private Provider<FirebaseAnalytics> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private final TransferAccountComponentImpl newProxyInstance;
        private Provider<MixpanelAnalytics> scheduleImpl;

        public /* synthetic */ TransferAccountComponentImpl(TransferAccountModule transferAccountModule, ApplicationComponent applicationComponent, byte b) {
            this(transferAccountModule, applicationComponent);
        }

        private TransferAccountComponentImpl(TransferAccountModule transferAccountModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.newProxyInstance = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ThreadExecutorProvider(applicationComponent);
            this.isLayoutRequested = new SSLPinningRepositoryProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.moveToNextValue, featureConfigRepositoryProvider);
            this.getErrorConfigVersion = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.isLayoutRequested, create);
            ProvideTransferAccountRepositoryProvider provideTransferAccountRepositoryProvider = new ProvideTransferAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provideTransferAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetTransferAccountStatus_Factory.create(provideTransferAccountRepositoryProvider);
            this.MyBillsEntityDataFactory = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.GetContactSyncConfig = provideEventTrackerQueueProvider;
            this.lookAheadTest = FirebaseAnalytics_Factory.PlaceComponentResult(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.GetContactSyncConfig);
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.lookAheadTest;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            this.PrepareContext = TransferAccountTrackerImpl_Factory.MyBillsEntityDataFactory(PlaceComponentResult);
            Provider<TransferAccountContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(TransferAccountModule_ProvideViewFactory.getAuthRequestContext(transferAccountModule));
            this.DatabaseTableConfigUtil = authRequestContext;
            TransferAccountPresenter_Factory authRequestContext2 = TransferAccountPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PrepareContext, authRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = authRequestContext2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(TransferAccountModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(transferAccountModule, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.j());
            }
        }

        @Override // id.dana.di.component.TransferAccountComponent
        public final void BuiltInFictitiousFunctionClassFactory(TransferAccountStatusActivity transferAccountStatusActivity) {
            ((BaseActivity) transferAccountStatusActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(transferAccountStatusActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(transferAccountStatusActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            TransferAccountStatusActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(transferAccountStatusActivity, this.initRecordTimeStamp.get());
        }
    }
}
