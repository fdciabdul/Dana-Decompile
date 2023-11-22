package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.di.modules.OnboardingModule;
import id.dana.di.modules.OnboardingModule_ProvideOnboardingPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingContract;
import id.dana.onboarding.OnboardingPresenter;
import id.dana.onboarding.OnboardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerOnboardingComponent {
    private DaggerOnboardingComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OnboardingModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class OnboardingComponentImpl implements OnboardingComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private final OnboardingComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<IsOfflineF2FPay> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<RiskTracker> getErrorConfigVersion;
        private Provider<OnboardingContract.Presenter> lookAheadTest;
        private Provider<SSLPinningRepository> moveToNextValue;
        private Provider<OnboardingPresenter> scheduleImpl;

        public /* synthetic */ OnboardingComponentImpl(OnboardingModule onboardingModule, ApplicationComponent applicationComponent, byte b) {
            this(onboardingModule, applicationComponent);
        }

        private OnboardingComponentImpl(OnboardingModule onboardingModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, create);
            ProvideRiskTrackerProvider provideRiskTrackerProvider = new ProvideRiskTrackerProvider(applicationComponent);
            this.getErrorConfigVersion = provideRiskTrackerProvider;
            OnboardingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OnboardingPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideRiskTrackerProvider);
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            this.lookAheadTest = OnboardingModule_ProvideOnboardingPresenterFactory.MyBillsEntityDataFactory(onboardingModule, KClassImpl$Data$declaredNonStaticMembers$2);
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
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
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
        public static final class ProvideRiskTrackerProvider implements Provider<RiskTracker> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideRiskTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RiskTracker get() {
                return (RiskTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getDefaultSenderId());
            }
        }

        @Override // id.dana.di.component.OnboardingComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(OnboardingActivity onboardingActivity) {
            ((BaseActivity) onboardingActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(onboardingActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(onboardingActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            onboardingActivity.presenter = DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest);
        }
    }
}
