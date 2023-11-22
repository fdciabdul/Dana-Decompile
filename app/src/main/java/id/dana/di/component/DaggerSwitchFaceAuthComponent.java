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
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl_Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.SwitchFaceAuthenticationModule;
import id.dana.di.modules.SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication_Factory;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll_Factory;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView_MembersInjector;
import id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView;
import id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView_MembersInjector;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSwitchFaceAuthComponent {
    private DaggerSwitchFaceAuthComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FaceAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public SwitchFaceAuthenticationModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final SwitchFaceAuthComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, SwitchFaceAuthenticationModule.class);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new FaceAuthenticationModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, ApplicationComponent.class);
            return new SwitchFaceAuthComponentImpl(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SwitchFaceAuthComponentImpl implements SwitchFaceAuthComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> DatabaseTableConfigUtil;
        private Provider<FaceAuthentication> GetContactSyncConfig;
        private Provider<DanaVizTrackerImpl> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FaceAuthenticationRepository> MyBillsEntityDataFactory;
        private Provider<GetUserId> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FirebasePerformanceMonitor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ResetPinRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SwitchFaceAuthPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<SwitchFaceAuthContract.View> PrepareContext;
        private Provider<AnalyticsTrackerFactory> getAuthRequestContext;
        private Provider<FinishForceDanaVizEnroll> getErrorConfigVersion;
        private Provider<EventTrackerQueue> initRecordTimeStamp;
        private Provider<SwitchFaceAuthentication> isLayoutRequested;
        private Provider<FirebaseAnalytics> lookAheadTest;
        private Provider<LiteAccountRepository> moveToNextValue;
        private final SwitchFaceAuthComponentImpl newProxyInstance;
        private Provider<MixpanelAnalytics> scheduleImpl;

        /* synthetic */ SwitchFaceAuthComponentImpl(SwitchFaceAuthenticationModule switchFaceAuthenticationModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(switchFaceAuthenticationModule, faceAuthenticationModule, applicationComponent);
        }

        private SwitchFaceAuthComponentImpl(SwitchFaceAuthenticationModule switchFaceAuthenticationModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.newProxyInstance = this;
            this.PlaceComponentResult = applicationComponent;
            this.PrepareContext = SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(switchFaceAuthenticationModule);
            FaceAuthenticationRepositoryProvider faceAuthenticationRepositoryProvider = new FaceAuthenticationRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = faceAuthenticationRepositoryProvider;
            this.isLayoutRequested = SwitchFaceAuthentication_Factory.create(faceAuthenticationRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new PostExecutionThreadProvider(applicationComponent);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.moveToNextValue = liteAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetUserId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.DatabaseTableConfigUtil, liteAccountRepositoryProvider);
            this.GetContactSyncConfig = FaceAuthenticationModule_ProvideFaceAuthenticationFactory.getAuthRequestContext(faceAuthenticationModule);
            this.BuiltInFictitiousFunctionClassFactory = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.initRecordTimeStamp = provideEventTrackerQueueProvider;
            this.lookAheadTest = FirebaseAnalytics_Factory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.initRecordTimeStamp);
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.lookAheadTest;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.getAuthRequestContext = PlaceComponentResult;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DanaVizTrackerImpl_Factory.PlaceComponentResult(PlaceComponentResult);
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provideResetPinRepositoryProvider;
            FinishForceDanaVizEnroll_Factory create = FinishForceDanaVizEnroll_Factory.create(provideResetPinRepositoryProvider);
            this.getErrorConfigVersion = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(SwitchFaceAuthPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.PrepareContext, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, create));
        }

        /* loaded from: classes4.dex */
        public static final class FaceAuthenticationRepositoryProvider implements Provider<FaceAuthenticationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FaceAuthenticationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthenticationRepository get() {
                return (FaceAuthenticationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.OtpRegistrationPresenter$input$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getContainerAuth());
            }
        }

        @Override // id.dana.di.component.SwitchFaceAuthComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView) {
            NewSwitchFaceAuthenticationView_MembersInjector.PlaceComponentResult(newSwitchFaceAuthenticationView, this.NetworkUserEntityData$$ExternalSyntheticLambda8.get());
            NewSwitchFaceAuthenticationView_MembersInjector.MyBillsEntityDataFactory(newSwitchFaceAuthenticationView, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
        }

        @Override // id.dana.di.component.SwitchFaceAuthComponent
        public final void BuiltInFictitiousFunctionClassFactory(SwitchFaceAuthenticationView switchFaceAuthenticationView) {
            SwitchFaceAuthenticationView_MembersInjector.getAuthRequestContext(switchFaceAuthenticationView, this.NetworkUserEntityData$$ExternalSyntheticLambda8.get());
            SwitchFaceAuthenticationView_MembersInjector.PlaceComponentResult(switchFaceAuthenticationView, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
        }
    }
}
