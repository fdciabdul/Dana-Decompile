package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.PushVerifyModule;
import id.dana.di.modules.PushVerifyModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.PushVerifyModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge_Factory;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge_Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity_MembersInjector;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;
import id.dana.pushverify.view.verificationdetail.PushVerifyPresenter;
import id.dana.pushverify.view.verificationdetail.PushVerifyPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPushVerifyComponent {
    private DaggerPushVerifyComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public PushVerifyModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PushVerifyComponentImpl implements PushVerifyComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<PushVerifyPresenter> GetContactSyncConfig;
        private Provider<GetPushVerifyChallenge> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetVerifyPushChallenge> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final PushVerifyComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<PushVerifyRepository> initRecordTimeStamp;
        private Provider<PushVerifyContract.Presenter> lookAheadTest;
        private Provider<PushVerifyTracker> moveToNextValue;
        private Provider<PushVerifyContract.View> scheduleImpl;

        public /* synthetic */ PushVerifyComponentImpl(PushVerifyModule pushVerifyModule, ApplicationComponent applicationComponent, byte b) {
            this(pushVerifyModule, applicationComponent);
        }

        private PushVerifyComponentImpl(PushVerifyModule pushVerifyModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.PlaceComponentResult = applicationComponent;
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            this.scheduleImpl = PushVerifyModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(pushVerifyModule);
            this.moveToNextValue = new ProvidePushVerifyTrackerProvider(applicationComponent);
            PushVerifyRepositoryProvider pushVerifyRepositoryProvider = new PushVerifyRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = pushVerifyRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetPushVerifyChallenge_Factory.create(pushVerifyRepositoryProvider);
            GetVerifyPushChallenge_Factory create2 = GetVerifyPushChallenge_Factory.create(this.initRecordTimeStamp);
            this.MyBillsEntityDataFactory = create2;
            PushVerifyPresenter_Factory BuiltInFictitiousFunctionClassFactory = PushVerifyPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, create2);
            this.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory;
            this.lookAheadTest = PushVerifyModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(pushVerifyModule, BuiltInFictitiousFunctionClassFactory);
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
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

        /* loaded from: classes4.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent getAuthRequestContext;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PushVerifyRepositoryProvider implements Provider<PushVerifyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PushVerifyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyRepository get() {
                return (PushVerifyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.InitSecurePreferenceAccount());
            }
        }

        @Override // id.dana.di.component.PushVerifyComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyActivity pushVerifyActivity) {
            ((BaseActivity) pushVerifyActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(pushVerifyActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(pushVerifyActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            PushVerifyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(pushVerifyActivity, DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
        }
    }
}
