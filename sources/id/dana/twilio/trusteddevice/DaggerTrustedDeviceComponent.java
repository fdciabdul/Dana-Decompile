package id.dana.twilio.trusteddevice;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetTwilioManualCheckConfig;
import id.dana.domain.featureconfig.interactor.GetTwilioManualCheckConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.CheckPendingChallenge;
import id.dana.domain.twilio.interactor.CheckPendingChallenge_Factory;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor_Factory;
import id.dana.domain.twilio.interactor.SubmitTwilioDeroll;
import id.dana.domain.twilio.interactor.SubmitTwilioDeroll_Factory;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerTrustedDeviceComponent {
    private DaggerTrustedDeviceComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        TrustedDeviceModule BuiltInFictitiousFunctionClassFactory;
        ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class TrustedDeviceComponentImpl implements TrustedDeviceComponent {
        private Provider<CheckPendingChallenge> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<SubmitTwilioDeroll> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<DeleteTwilioLocalFactor> MyBillsEntityDataFactory;
        private Provider<GetUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<TrustedDeviceContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<TrustedDevicePresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private Provider<TwilioSdkRepository> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GetTwilioManualCheckConfig> getErrorConfigVersion;
        private final TrustedDeviceComponentImpl initRecordTimeStamp;
        private Provider<TwilioRepository> isLayoutRequested;
        private Provider<IsOfflineF2FPay> lookAheadTest;
        private Provider<TrustedDeviceContract.Presenter> moveToNextValue;
        private Provider<UserRepository> newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ TrustedDeviceComponentImpl(TrustedDeviceModule trustedDeviceModule, ApplicationComponent applicationComponent, byte b) {
            this(trustedDeviceModule, applicationComponent);
        }

        private TrustedDeviceComponentImpl(TrustedDeviceModule trustedDeviceModule, ApplicationComponent applicationComponent) {
            this.initRecordTimeStamp = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.scheduleImpl, featureConfigRepositoryProvider);
            this.lookAheadTest = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.DatabaseTableConfigUtil, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(TrustedDeviceModule_ProvideViewFactory.PlaceComponentResult(trustedDeviceModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.newProxyInstance = userRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetUserInfo_Factory.create(userRepositoryProvider);
            this.getErrorConfigVersion = GetTwilioManualCheckConfig_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            TwilioEnrollmentRepositoryProvider twilioEnrollmentRepositoryProvider = new TwilioEnrollmentRepositoryProvider(applicationComponent);
            this.isLayoutRequested = twilioEnrollmentRepositoryProvider;
            this.GetContactSyncConfig = SubmitTwilioDeroll_Factory.create(twilioEnrollmentRepositoryProvider);
            TwilioEntityRepositoryProvider twilioEntityRepositoryProvider = new TwilioEntityRepositoryProvider(applicationComponent);
            this.PrepareContext = twilioEntityRepositoryProvider;
            this.MyBillsEntityDataFactory = DeleteTwilioLocalFactor_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.scheduleImpl, twilioEntityRepositoryProvider);
            CheckPendingChallenge_Factory create2 = CheckPendingChallenge_Factory.create(this.PrepareContext);
            this.BuiltInFictitiousFunctionClassFactory = create2;
            TrustedDevicePresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = TrustedDevicePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, this.GetContactSyncConfig, this.MyBillsEntityDataFactory, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(TrustedDeviceModule_ProvidePresenterFactory.MyBillsEntityDataFactory(trustedDeviceModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class TwilioEnrollmentRepositoryProvider implements Provider<TwilioRepository> {
            private final ApplicationComponent getAuthRequestContext;

            TwilioEnrollmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioRepository get() {
                return (TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class TwilioEntityRepositoryProvider implements Provider<TwilioSdkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            TwilioEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioSdkRepository get() {
                return (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ArrayTable$2());
            }
        }

        @Override // id.dana.twilio.trusteddevice.TrustedDeviceComponent
        public final void getAuthRequestContext(TrustedDeviceActivity trustedDeviceActivity) {
            ((BaseActivity) trustedDeviceActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(trustedDeviceActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(trustedDeviceActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            trustedDeviceActivity.trustedDevicePresenter = this.moveToNextValue.get();
        }
    }
}
