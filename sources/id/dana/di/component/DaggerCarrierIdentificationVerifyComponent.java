package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.CarrierIdentificationVerifyModule;
import id.dana.di.modules.CarrierIdentificationVerifyModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.CarrierIdentificationVerifyModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.interactor.CheckIpificationAuthCode;
import id.dana.domain.carrieridentification.interactor.CheckIpificationAuthCode_Factory;
import id.dana.domain.carrieridentification.interactor.VerifyIpificationAuthCode;
import id.dana.domain.carrieridentification.interactor.VerifyIpificationAuthCode_Factory;
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
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity_MembersInjector;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCarrierIdentificationVerifyComponent {
    private DaggerCarrierIdentificationVerifyComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public CarrierIdentificationVerifyModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public LogoutModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CarrierIdentificationVerifyComponentImpl implements CarrierIdentificationVerifyComponent {
        private Provider<SSLPinningRepository> A;
        private Provider<ServicesRepository> B;
        private Provider<ThreadExecutor> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<ClearAllDanapolyData> BuiltInFictitiousFunctionClassFactory;
        private Provider<LogoutContract.View> C;
        private Provider<Context> DatabaseTableConfigUtil;
        private Provider<LoginRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<ContactRepository> GetContactSyncConfig;
        private final CarrierIdentificationVerifyComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckIpificationAuthCode> MyBillsEntityDataFactory;
        private Provider<ClearKybData> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Logout> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<LogoutPresenter> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<KybRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ForceLogout> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final CarrierIdentificationVerifyModule PlaceComponentResult;
        private Provider<FeatureConfigRepository> PrepareContext;
        private Provider<FeedInitRepository> SubSequence;
        private Provider<RegistrationTracker> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<VerifyIpificationAuthCode> VerifyPinStateManager$executeRiskChallenge$2$2;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<LogoutContract.Presenter> getCallingPid;
        private Provider<ClearAllFeedsUsecase> getErrorConfigVersion;
        private Provider<CarrierIdentificationRepository> getSupportButtonTintMode;
        private Provider<DanaSessionManager> initRecordTimeStamp;
        private Provider<GlobalNetworkRepository> isLayoutRequested;
        private Provider<ClearFaceAuthSuggestionState> lookAheadTest;
        private Provider<ClearCacheFavoriteServices> moveToNextValue;
        private Provider<FaceAuthPopUpConsultationRepository> newProxyInstance;
        private Provider<HomeWidgetClearable> readMicros;
        private Provider<ClearAllSyncEngineUseCase> scheduleImpl;
        private Provider<DanapolyClearRepository> whenAvailable;

        public /* synthetic */ CarrierIdentificationVerifyComponentImpl(LogoutModule logoutModule, CarrierIdentificationVerifyModule carrierIdentificationVerifyModule, ApplicationComponent applicationComponent, byte b) {
            this(logoutModule, carrierIdentificationVerifyModule, applicationComponent);
        }

        private CarrierIdentificationVerifyComponentImpl(LogoutModule logoutModule, CarrierIdentificationVerifyModule carrierIdentificationVerifyModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.getAuthRequestContext = applicationComponent;
            this.PlaceComponentResult = carrierIdentificationVerifyModule;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new ThreadExecutorProvider(applicationComponent);
            this.A = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PrepareContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda4, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.A, create);
            this.C = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            this.DatabaseTableConfigUtil = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new DeviceInformationProviderProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = new LoginRepositoryProvider(applicationComponent);
            this.isLayoutRequested = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.readMicros = provideHomeWidgetClearableProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ForceLogout_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.FragmentBottomSheetPaymentSettingBinding, this.isLayoutRequested, provideHomeWidgetClearableProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = Logout_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.FragmentBottomSheetPaymentSettingBinding, this.readMicros, this.isLayoutRequested);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = contractRepositoryProvider;
            this.scheduleImpl = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.SubSequence = provideFeedInitRepositoryProvider;
            this.getErrorConfigVersion = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.B = servicesRepositoryProvider;
            this.moveToNextValue = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.whenAvailable = provideDanapolyClearRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
            this.initRecordTimeStamp = DanaSessionManager_Factory.getAuthRequestContext(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.scheduleImpl, this.getErrorConfigVersion, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, authRequestContext);
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.newProxyInstance = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create2 = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.lookAheadTest = create2;
            Provider<LogoutPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.C, this.initRecordTimeStamp, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext2;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext2));
            ProvideCarrierIdentificationRepositoryProvider provideCarrierIdentificationRepositoryProvider = new ProvideCarrierIdentificationRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = provideCarrierIdentificationRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckIpificationAuthCode_Factory.create(provideCarrierIdentificationRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = VerifyIpificationAuthCode_Factory.create(this.getSupportButtonTintMode);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new ProvideRegistrationTrackerProvider(applicationComponent);
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
            private final ApplicationComponent getAuthRequestContext;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.PlaceComponentResult.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideCarrierIdentificationRepositoryProvider implements Provider<CarrierIdentificationRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideCarrierIdentificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CarrierIdentificationRepository get() {
                return (CarrierIdentificationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.verifyNotNull());
            }
        }

        @Override // id.dana.di.component.CarrierIdentificationVerifyComponent
        public final void getAuthRequestContext(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
            ((BaseActivity) carrierIdentificationVerifyActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(carrierIdentificationVerifyActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            CarrierIdentificationVerifyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyActivity, this.getCallingPid.get());
            CarrierIdentificationVerifyActivity_MembersInjector.PlaceComponentResult(carrierIdentificationVerifyActivity, CarrierIdentificationVerifyModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(this.PlaceComponentResult, new CarrierIdentificationVerifyPresenter((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()), CarrierIdentificationVerifyModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$2), DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$1))));
        }
    }
}
