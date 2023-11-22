package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.animation.danaprotection.DanaProtectionHomeView;
import id.dana.animation.danaprotection.DanaProtectionHomeView_MembersInjector;
import id.dana.animation.danaprotection.DanaProtectionPresenter;
import id.dana.animation.danaprotection.DanaProtectionPresenter_Factory;
import id.dana.animation.danaprotection.tracker.DanaProtectionTrackerImpl;
import id.dana.animation.danaprotection.tracker.DanaProtectionTrackerImpl_Factory;
import id.dana.di.modules.DanaProtectionModule;
import id.dana.di.modules.DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.DanaProtectionModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo_Factory;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig_Factory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.interactor.GetDanaProtectionHomeWidgetInfoWithConfigFromLocal;
import id.dana.domain.home.interactor.GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory;
import id.dana.domain.home.interactor.SaveDanaProtectionHomeWidgetInfoLocal;
import id.dana.domain.home.interactor.SaveDanaProtectionHomeWidgetInfoLocal_Factory;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerDanaProtectionWidgetComponent {
    private DaggerDanaProtectionWidgetComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DanaProtectionModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class DanaProtectionWidgetComponentImpl implements DanaProtectionWidgetComponent {
        private Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetDanaProtectionRecommendation> DatabaseTableConfigUtil;
        private Provider<UserSecurityQuestionStateRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<CredentialRepository> GetContactSyncConfig;
        private Provider<DanaProtectionPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private final DanaProtectionWidgetComponentImpl MyBillsEntityDataFactory;
        private Provider<FaceAuthPopUpConsultationRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DanaProtectionInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MixpanelAnalytics> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SaveDanaProtectionHomeWidgetInfoLocal> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DanaProtectionContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<EventTrackerQueue> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<FirebasePerformanceMonitor> PrepareContext;
        private Provider<DanaProtectionTrackerImpl> getAuthRequestContext;
        private Provider<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> getErrorConfigVersion;
        private Provider<GetDanaProtectionWidgetConfig> initRecordTimeStamp;
        private Provider<DanaProtectionContract.View> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<GetDanaProtectionInfo> moveToNextValue;
        private Provider<HomeWidgetRepository> newProxyInstance;
        private Provider<FirebaseAnalytics> scheduleImpl;

        public /* synthetic */ DanaProtectionWidgetComponentImpl(DanaProtectionModule danaProtectionModule, ApplicationComponent applicationComponent, byte b) {
            this(danaProtectionModule, applicationComponent);
        }

        private DanaProtectionWidgetComponentImpl(DanaProtectionModule danaProtectionModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.MyBillsEntityDataFactory = this;
            this.isLayoutRequested = DanaProtectionModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(danaProtectionModule);
            ProvideDanaProtectionInfoRepositoryProvider provideDanaProtectionInfoRepositoryProvider = new ProvideDanaProtectionInfoRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provideDanaProtectionInfoRepositoryProvider;
            this.moveToNextValue = GetDanaProtectionInfo_Factory.create(provideDanaProtectionInfoRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = new ProvideCredentialRepositoryProvider(applicationComponent);
            UserSecurityQuestionStateRepositoryProvider userSecurityQuestionStateRepositoryProvider = new UserSecurityQuestionStateRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = userSecurityQuestionStateRepositoryProvider;
            this.DatabaseTableConfigUtil = GetDanaProtectionRecommendation_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, userSecurityQuestionStateRepositoryProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            this.initRecordTimeStamp = GetDanaProtectionWidgetConfig_Factory.create(featureConfigRepositoryProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            ProvideHomeWidgetRepositoryProvider provideHomeWidgetRepositoryProvider = new ProvideHomeWidgetRepositoryProvider(applicationComponent);
            this.newProxyInstance = provideHomeWidgetRepositoryProvider;
            this.getErrorConfigVersion = GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory.create(provideHomeWidgetRepositoryProvider);
            SaveDanaProtectionHomeWidgetInfoLocal_Factory create = SaveDanaProtectionHomeWidgetInfoLocal_Factory.create(this.newProxyInstance);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = create;
            DanaProtectionPresenter_Factory MyBillsEntityDataFactory = DanaProtectionPresenter_Factory.MyBillsEntityDataFactory(this.isLayoutRequested, this.moveToNextValue, this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.getErrorConfigVersion, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(danaProtectionModule, MyBillsEntityDataFactory);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.PrepareContext = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provideEventTrackerQueueProvider;
            this.scheduleImpl = FirebaseAnalytics_Factory.PlaceComponentResult(this.PlaceComponentResult, this.PrepareContext, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.scheduleImpl;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.getAuthRequestContext = DanaProtectionTrackerImpl_Factory.MyBillsEntityDataFactory(PlaceComponentResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanaProtectionInfoRepositoryProvider implements Provider<DanaProtectionInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideDanaProtectionInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanaProtectionInfoRepository get() {
                return (DanaProtectionInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideCredentialRepositoryProvider implements Provider<CredentialRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideCredentialRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CredentialRepository get() {
                return (CredentialRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowViewUtil$textChanges$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserSecurityQuestionStateRepositoryProvider implements Provider<UserSecurityQuestionStateRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserSecurityQuestionStateRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserSecurityQuestionStateRepository get() {
                return (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getPhoneMask());
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
        public static final class ProvideHomeWidgetRepositoryProvider implements Provider<HomeWidgetRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideHomeWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetRepository get() {
                return (HomeWidgetRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.q());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$2());
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

        @Override // id.dana.di.component.DanaProtectionWidgetComponent
        public final void PlaceComponentResult(DanaProtectionHomeView danaProtectionHomeView) {
            DanaProtectionHomeView_MembersInjector.getAuthRequestContext(danaProtectionHomeView, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            DanaProtectionHomeView_MembersInjector.PlaceComponentResult(danaProtectionHomeView, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
        }
    }
}
