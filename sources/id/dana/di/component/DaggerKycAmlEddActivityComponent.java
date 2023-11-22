package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.animation.KycAmlEddActivity;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.KycAmlEddModule;
import id.dana.di.modules.KycAmlEddModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult_Factory;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.KycAmlEddPresenter;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerKycAmlEddActivityComponent {
    private DaggerKycAmlEddActivityComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public KycAmlEddModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class KycAmlEddActivityComponentImpl implements KycAmlEddActivityComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsOfflineF2FPay> MyBillsEntityDataFactory;
        private final KycAmlEddActivityComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetKycAmlEddConsult> PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<KycAmlEddContract.View> getErrorConfigVersion;
        private Provider<SubmitEddAmlKyc> initRecordTimeStamp;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<KycAmlEddRepository> moveToNextValue;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ KycAmlEddActivityComponentImpl(KycAmlEddModule kycAmlEddModule, ApplicationComponent applicationComponent, byte b) {
            this(kycAmlEddModule, applicationComponent);
        }

        private KycAmlEddActivityComponentImpl(KycAmlEddModule kycAmlEddModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl, create);
            this.getErrorConfigVersion = KycAmlEddModule_ProvideView$app_productionReleaseFactory.getAuthRequestContext(kycAmlEddModule);
            KycAmlEddRepositoryProvider kycAmlEddRepositoryProvider = new KycAmlEddRepositoryProvider(applicationComponent);
            this.moveToNextValue = kycAmlEddRepositoryProvider;
            this.PlaceComponentResult = GetKycAmlEddConsult_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, kycAmlEddRepositoryProvider);
            this.initRecordTimeStamp = SubmitEddAmlKyc_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, this.moveToNextValue);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
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
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
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
        public static final class KycAmlEddRepositoryProvider implements Provider<KycAmlEddRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            KycAmlEddRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KycAmlEddRepository get() {
                return (KycAmlEddRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.I());
            }
        }

        @Override // id.dana.di.component.KycAmlEddActivityComponent
        public final void getAuthRequestContext(KycAmlEddActivity kycAmlEddActivity) {
            ((BaseActivity) kycAmlEddActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(kycAmlEddActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(kycAmlEddActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            kycAmlEddActivity.kycAmlEddPresenter = new KycAmlEddPresenter(DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
        }
    }
}
