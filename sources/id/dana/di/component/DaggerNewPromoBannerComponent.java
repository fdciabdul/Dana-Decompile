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
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.animation.promobanner.NewPromoBannerPresenter;
import id.dana.animation.promobanner.NewPromoBannerPresenter_Factory;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.tracker.HomeTrackerImpl_Factory;
import id.dana.di.modules.NewPromoBannerModule;
import id.dana.di.modules.NewPromoBannerModule_ProvidePresenterFactory;
import id.dana.di.modules.NewPromoBannerModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.announcement.interactor.GetAnnouncements;
import id.dana.domain.announcement.interactor.GetAnnouncements_Factory;
import id.dana.domain.announcement.interactor.GetGnAnnouncementsId;
import id.dana.domain.announcement.interactor.GetGnAnnouncementsId_Factory;
import id.dana.domain.announcement.interactor.GetTrackedAnnouncementsId;
import id.dana.domain.announcement.interactor.GetTrackedAnnouncementsId_Factory;
import id.dana.domain.announcement.interactor.SaveTrackedAnnouncementId;
import id.dana.domain.announcement.interactor.SaveTrackedAnnouncementId_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckAnnouncementFeature;
import id.dana.domain.featureconfig.interactor.CheckAnnouncementFeature_Factory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.interactor.GetPromoBannerAnnouncementFromPersistence;
import id.dana.domain.home.interactor.GetPromoBannerAnnouncementFromPersistence_Factory;
import id.dana.domain.home.interactor.GetPromoBannerContentFromPersistence;
import id.dana.domain.home.interactor.GetPromoBannerContentFromPersistence_Factory;
import id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence;
import id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence_Factory;
import id.dana.domain.home.interactor.SavePromoBannerCdpContentIntoPersistence;
import id.dana.domain.home.interactor.SavePromoBannerCdpContentIntoPersistence_Factory;
import id.dana.domain.promotion.interactor.GetHomePromotionBanner;
import id.dana.domain.promotion.interactor.GetHomePromotionBanner_Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.richview.NewPromoBannerView;
import id.dana.richview.NewPromoBannerView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNewPromoBannerComponent {
    private DaggerNewPromoBannerComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public NewPromoBannerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewPromoBannerComponentImpl implements NewPromoBannerComponent {
        private Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetTrackedAnnouncementsId> DatabaseTableConfigUtil;
        private Provider<HomeWidgetRepository> FragmentBottomSheetPaymentSettingBinding;
        private final NewPromoBannerComponentImpl GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AnnouncementRepository> MyBillsEntityDataFactory;
        private Provider<GetAnnouncements> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MixpanelAnalytics> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<HomeTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<NewPromoBannerContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<SavePromoBannerAnnouncementIntoPersistence> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PushVerifyTracker> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<NewPromoBannerContract.View> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<PromotionRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FirebasePerformanceMonitor> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<CheckAnnouncementFeature> PlaceComponentResult;
        private Provider<PostExecutionThread> PrepareContext;
        private Provider<ThreadExecutor> SubSequence;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<GetHomePromotionBanner> getErrorConfigVersion;
        private Provider<SavePromoBannerCdpContentIntoPersistence> getSupportButtonTintMode;
        private Provider<GetPromoBannerContentFromPersistence> initRecordTimeStamp;
        private Provider<NewPromoBannerPresenter> isLayoutRequested;
        private Provider<GetGnAnnouncementsId> lookAheadTest;
        private Provider<GetPromoBannerAnnouncementFromPersistence> moveToNextValue;
        private Provider<EventTrackerQueue> newProxyInstance;
        private Provider<FirebaseAnalytics> scheduleImpl;
        private Provider<SaveTrackedAnnouncementId> whenAvailable;

        public /* synthetic */ NewPromoBannerComponentImpl(NewPromoBannerModule newPromoBannerModule, ApplicationComponent applicationComponent, byte b) {
            this(newPromoBannerModule, applicationComponent);
        }

        private NewPromoBannerComponentImpl(NewPromoBannerModule newPromoBannerModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.GetContactSyncConfig = this;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = NewPromoBannerModule_ProvideViewFactory.MyBillsEntityDataFactory(newPromoBannerModule);
            this.SubSequence = new ThreadExecutorProvider(applicationComponent);
            this.PrepareContext = new PostExecutionThreadProvider(applicationComponent);
            PromotionRepositoryProvider promotionRepositoryProvider = new PromotionRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = promotionRepositoryProvider;
            this.getErrorConfigVersion = GetHomePromotionBanner_Factory.create(this.SubSequence, this.PrepareContext, promotionRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            this.PlaceComponentResult = CheckAnnouncementFeature_Factory.create(featureConfigRepositoryProvider);
            AnnouncementRepositoryProvider announcementRepositoryProvider = new AnnouncementRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = announcementRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetAnnouncements_Factory.create(announcementRepositoryProvider);
            this.lookAheadTest = GetGnAnnouncementsId_Factory.create(this.MyBillsEntityDataFactory);
            this.DatabaseTableConfigUtil = GetTrackedAnnouncementsId_Factory.create(this.MyBillsEntityDataFactory);
            this.whenAvailable = SaveTrackedAnnouncementId_Factory.create(this.MyBillsEntityDataFactory);
            ProvideHomeWidgetRepositoryProvider provideHomeWidgetRepositoryProvider = new ProvideHomeWidgetRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideHomeWidgetRepositoryProvider;
            this.getSupportButtonTintMode = SavePromoBannerCdpContentIntoPersistence_Factory.create(provideHomeWidgetRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = SavePromoBannerAnnouncementIntoPersistence_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.initRecordTimeStamp = GetPromoBannerContentFromPersistence_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.moveToNextValue = GetPromoBannerAnnouncementFromPersistence_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ProvidePushVerifyTrackerProvider(applicationComponent);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            Provider<NewPromoBannerPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(NewPromoBannerPresenter_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getErrorConfigVersion, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.DatabaseTableConfigUtil, this.whenAvailable, this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda5, contextProvider));
            this.isLayoutRequested = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = NewPromoBannerModule_ProvidePresenterFactory.PlaceComponentResult(newPromoBannerModule, authRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.newProxyInstance = provideEventTrackerQueueProvider;
            this.scheduleImpl = FirebaseAnalytics_Factory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda8, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.newProxyInstance);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.scheduleImpl;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
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
        public static final class PromotionRepositoryProvider implements Provider<PromotionRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromotionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromotionRepository get() {
                return (PromotionRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.a());
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
        public static final class AnnouncementRepositoryProvider implements Provider<AnnouncementRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AnnouncementRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AnnouncementRepository get() {
                return (AnnouncementRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetRepositoryProvider implements Provider<HomeWidgetRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideHomeWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetRepository get() {
                return (HomeWidgetRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.q());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent PlaceComponentResult;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.PlaceComponentResult.FlowableCreate$BufferAsyncEmitter());
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

        @Override // id.dana.di.component.NewPromoBannerComponent
        public final void MyBillsEntityDataFactory(NewPromoBannerView newPromoBannerView) {
            NewPromoBannerView_MembersInjector.getAuthRequestContext(newPromoBannerView, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            newPromoBannerView.homeTrackerImpl = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
    }
}
