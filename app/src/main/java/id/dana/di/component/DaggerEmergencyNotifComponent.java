package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.EmergencyNotifModule;
import id.dana.di.modules.EmergencyNotifModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.EmergencyNotifModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.maintenance.EmergencyNotifActivity;
import id.dana.maintenance.EmergencyNotifActivity_MembersInjector;
import id.dana.maintenance.EmergencyNotifPresenter;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerEmergencyNotifComponent {
    private DaggerEmergencyNotifComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public EmergencyNotifModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class EmergencyNotifComponentImpl implements EmergencyNotifComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final EmergencyNotifModule MyBillsEntityDataFactory;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final EmergencyNotifComponentImpl PlaceComponentResult;
        private Provider<CheckIpificationCoverage> getAuthRequestContext;
        private Provider<CarrierIdentificationRepository> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<IsOfflineF2FPay> lookAheadTest;
        private Provider<FeatureConfigRepository> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ EmergencyNotifComponentImpl(EmergencyNotifModule emergencyNotifModule, ApplicationComponent applicationComponent, byte b) {
            this(emergencyNotifModule, applicationComponent);
        }

        private EmergencyNotifComponentImpl(EmergencyNotifModule emergencyNotifModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.MyBillsEntityDataFactory = emergencyNotifModule;
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.moveToNextValue = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.initRecordTimeStamp, this.scheduleImpl, featureConfigRepositoryProvider);
            this.lookAheadTest = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
            ProvideCarrierIdentificationRepositoryProvider provideCarrierIdentificationRepositoryProvider = new ProvideCarrierIdentificationRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = provideCarrierIdentificationRepositoryProvider;
            this.getAuthRequestContext = CheckIpificationCoverage_Factory.create(provideCarrierIdentificationRepositoryProvider);
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
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
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
        public static final class ProvideCarrierIdentificationRepositoryProvider implements Provider<CarrierIdentificationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideCarrierIdentificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CarrierIdentificationRepository get() {
                return (CarrierIdentificationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.e());
            }
        }

        @Override // id.dana.di.component.EmergencyNotifComponent
        public final void getAuthRequestContext(EmergencyNotifActivity emergencyNotifActivity) {
            ((BaseActivity) emergencyNotifActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(emergencyNotifActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(emergencyNotifActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            EmergencyNotifActivity_MembersInjector.PlaceComponentResult(emergencyNotifActivity, EmergencyNotifModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, new EmergencyNotifPresenter(EmergencyNotifModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), new GetEmergencyNotifConfig((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new CheckRegisteredPhoneNumber((RegistrationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.rotateTo())), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext))));
        }
    }
}
