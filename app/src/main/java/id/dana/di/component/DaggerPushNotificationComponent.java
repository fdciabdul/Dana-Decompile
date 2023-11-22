package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationPresenter;
import id.dana.contract.notification.PushNotificationPresenter_Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.PushNotificationModule;
import id.dana.di.modules.PushNotificationModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature_Factory;
import id.dana.domain.notificationcenter.interactor.BindApp;
import id.dana.domain.notificationcenter.interactor.BindApp_Factory;
import id.dana.domain.notificationcenter.interactor.ReportDevice;
import id.dana.domain.notificationcenter.interactor.ReportDevice_Factory;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt_Factory;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken_Factory;
import id.dana.notification.DanaFirebaseMessagingService;
import id.dana.notification.DanaFirebaseMessagingService_MembersInjector;
import id.dana.notification.NotificationDirectorFactory;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerPushNotificationComponent {
    private DaggerPushNotificationComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public PushNotificationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class PushNotificationComponentImpl implements PushNotificationComponent {
        private Provider<BindApp> BuiltInFictitiousFunctionClassFactory;
        private Provider<TwilioSdkRepository> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> GetContactSyncConfig;
        private Provider<PostExecutionThread> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<PushNotificationPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<UpdateTwilioPushToken> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SaveTwilioChallengeAttempt> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<CheckPushNotifDiagnosticFeature> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<PushNotificationContract.View> getErrorConfigVersion;
        private Provider<PushNotificationRepository> lookAheadTest;
        private Provider<ReportDevice> moveToNextValue;
        private final PushNotificationComponentImpl scheduleImpl;

        public /* synthetic */ PushNotificationComponentImpl(PushNotificationModule pushNotificationModule, ApplicationComponent applicationComponent, byte b) {
            this(pushNotificationModule, applicationComponent);
        }

        private PushNotificationComponentImpl(PushNotificationModule pushNotificationModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(PushNotificationModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(pushNotificationModule));
            this.GetContactSyncConfig = new ThreadExecutorProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            this.PlaceComponentResult = CheckPushNotifDiagnosticFeature_Factory.create(this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, featureConfigRepositoryProvider);
            PushNotificationRepositoryProvider pushNotificationRepositoryProvider = new PushNotificationRepositoryProvider(applicationComponent);
            this.lookAheadTest = pushNotificationRepositoryProvider;
            this.moveToNextValue = ReportDevice_Factory.create(this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, pushNotificationRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = BindApp_Factory.create(this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest);
            TwilioEntityRepositoryProvider twilioEntityRepositoryProvider = new TwilioEntityRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = twilioEntityRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = UpdateTwilioPushToken_Factory.create(this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, twilioEntityRepositoryProvider);
            SaveTwilioChallengeAttempt_Factory create = SaveTwilioChallengeAttempt_Factory.create(this.DatabaseTableConfigUtil);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(PushNotificationPresenter_Factory.MyBillsEntityDataFactory(this.getErrorConfigVersion, this.PlaceComponentResult, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PushNotificationRepositoryProvider implements Provider<PushNotificationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PushNotificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushNotificationRepository get() {
                return (PushNotificationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.retainOrRemoveAllInternal());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class TwilioEntityRepositoryProvider implements Provider<TwilioSdkRepository> {
            private final ApplicationComponent PlaceComponentResult;

            TwilioEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioSdkRepository get() {
                return (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$2());
            }
        }

        @Override // id.dana.di.component.PushNotificationComponent
        public final void MyBillsEntityDataFactory(DanaFirebaseMessagingService danaFirebaseMessagingService) {
            DanaFirebaseMessagingService_MembersInjector.BuiltInFictitiousFunctionClassFactory(danaFirebaseMessagingService, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
            DanaFirebaseMessagingService_MembersInjector.MyBillsEntityDataFactory(danaFirebaseMessagingService, new NotificationDirectorFactory((DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext())));
            DanaFirebaseMessagingService_MembersInjector.MyBillsEntityDataFactory(danaFirebaseMessagingService, new TwilioMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }
    }
}
