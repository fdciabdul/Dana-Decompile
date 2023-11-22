package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.KybCpmModule;
import id.dana.di.modules.KybCpmModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.KybCpmModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.CreatePaymentOrderCpm;
import id.dana.kyb.domain.interactor.CreatePaymentOrderCpm_Factory;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.KybCpmPresenter;
import id.dana.kybcpm.KybCpmPresenter_Factory;
import id.dana.kybcpm.tracker.MixpanelKybCpmTracker;
import id.dana.kybcpm.tracker.MixpanelKybCpmTracker_Factory;
import id.dana.kybcpm.view.KybCpmLoadingActivity;
import id.dana.kybcpm.view.KybCpmLoadingActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerKybCpmComponent {
    private DaggerKybCpmComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;
        public KybCpmModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class KybCpmComponentImpl implements KybCpmComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<KybCpmContract.View> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<KybCpmContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<CreatePaymentOrderCpm> getAuthRequestContext;
        private Provider<MixpanelKybCpmTracker> getErrorConfigVersion;
        private Provider<PostExecutionThread> initRecordTimeStamp;
        private final KybCpmComponentImpl lookAheadTest;
        private Provider<KybRepository> moveToNextValue;
        private Provider<KybCpmPresenter> scheduleImpl;

        public /* synthetic */ KybCpmComponentImpl(KybCpmModule kybCpmModule, ApplicationComponent applicationComponent, byte b) {
            this(kybCpmModule, applicationComponent);
        }

        private KybCpmComponentImpl(KybCpmModule kybCpmModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.initRecordTimeStamp, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.DatabaseTableConfigUtil, create);
            this.GetContactSyncConfig = KybCpmModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(kybCpmModule);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.moveToNextValue = kybRepositoryProvider;
            this.getAuthRequestContext = CreatePaymentOrderCpm_Factory.KClassImpl$Data$declaredNonStaticMembers$2(kybRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            MixpanelKybCpmTracker_Factory authRequestContext = MixpanelKybCpmTracker_Factory.getAuthRequestContext(contextProvider);
            this.getErrorConfigVersion = authRequestContext;
            KybCpmPresenter_Factory MyBillsEntityDataFactory = KybCpmPresenter_Factory.MyBillsEntityDataFactory(this.GetContactSyncConfig, this.getAuthRequestContext, authRequestContext);
            this.scheduleImpl = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KybCpmModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(kybCpmModule, MyBillsEntityDataFactory);
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
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

        @Override // id.dana.di.component.KybCpmComponent
        public final void MyBillsEntityDataFactory(KybCpmLoadingActivity kybCpmLoadingActivity) {
            ((BaseActivity) kybCpmLoadingActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(kybCpmLoadingActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(kybCpmLoadingActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            KybCpmLoadingActivity_MembersInjector.getAuthRequestContext(kybCpmLoadingActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
        }
    }
}
