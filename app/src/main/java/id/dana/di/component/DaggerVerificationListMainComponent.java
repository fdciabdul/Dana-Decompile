package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.VerificationListMainModule;
import id.dana.di.modules.VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.VerificationListMainModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.pushverify.interactor.IsNotificationPromptDisabled;
import id.dana.domain.pushverify.interactor.IsNotificationPromptDisabled_Factory;
import id.dana.domain.pushverify.interactor.SaveDisabledNotificationPromptPreference;
import id.dana.domain.pushverify.interactor.SaveDisabledNotificationPromptPreference_Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.pushverify.view.verificationlist.VerificationListActivity;
import id.dana.pushverify.view.verificationlist.VerificationListActivity_MembersInjector;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;
import id.dana.pushverify.view.verificationlist.VerificationListMainPresenter;
import id.dana.pushverify.view.verificationlist.VerificationListMainPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerVerificationListMainComponent {
    private DaggerVerificationListMainComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public VerificationListMainModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class VerificationListMainComponentImpl implements VerificationListMainComponent {
        private Provider<IsNotificationPromptDisabled> BuiltInFictitiousFunctionClassFactory;
        private final VerificationListMainComponentImpl DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<VerificationListMainContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SaveDisabledNotificationPromptPreference> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<IsOfflineF2FPay> PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<VerificationListMainContract.View> getErrorConfigVersion;
        private Provider<VerificationListMainPresenter> initRecordTimeStamp;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<PushVerifyRepository> moveToNextValue;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ VerificationListMainComponentImpl(VerificationListMainModule verificationListMainModule, ApplicationComponent applicationComponent, byte b) {
            this(verificationListMainModule, applicationComponent);
        }

        private VerificationListMainComponentImpl(VerificationListMainModule verificationListMainModule, ApplicationComponent applicationComponent) {
            this.DatabaseTableConfigUtil = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.GetContactSyncConfig = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.GetContactSyncConfig, this.lookAheadTest, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.GetContactSyncConfig, this.scheduleImpl, create);
            this.getErrorConfigVersion = VerificationListMainModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(verificationListMainModule);
            PushVerifyRepositoryProvider pushVerifyRepositoryProvider = new PushVerifyRepositoryProvider(applicationComponent);
            this.moveToNextValue = pushVerifyRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = IsNotificationPromptDisabled_Factory.create(pushVerifyRepositoryProvider);
            SaveDisabledNotificationPromptPreference_Factory create2 = SaveDisabledNotificationPromptPreference_Factory.create(this.moveToNextValue);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create2;
            VerificationListMainPresenter_Factory PlaceComponentResult = VerificationListMainPresenter_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory, create2);
            this.initRecordTimeStamp = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(verificationListMainModule, PlaceComponentResult);
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
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
        public static final class PushVerifyRepositoryProvider implements Provider<PushVerifyRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PushVerifyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyRepository get() {
                return (PushVerifyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.InitSecurePreferenceAccount());
            }
        }

        @Override // id.dana.di.component.VerificationListMainComponent
        public final void getAuthRequestContext(VerificationListActivity verificationListActivity) {
            ((BaseActivity) verificationListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(verificationListActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(verificationListActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            VerificationListActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(verificationListActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
    }
}
