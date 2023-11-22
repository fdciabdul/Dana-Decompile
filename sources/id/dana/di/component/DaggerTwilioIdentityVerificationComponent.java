package id.dana.di.component;

import android.content.Context;
import android.text.TextUtils;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
import id.dana.di.modules.TwilioIdentityVerificationModule;
import id.dana.di.modules.TwilioIdentityVerificationModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
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
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.GetTwilioChallengeDetails;
import id.dana.domain.twilio.interactor.IsTwilioForceLogout;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity_MembersInjector;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;
import id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.util.RaspUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import o.C;

/* loaded from: classes4.dex */
public final class DaggerTwilioIdentityVerificationComponent {
    private DaggerTwilioIdentityVerificationComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public LogoutModule BuiltInFictitiousFunctionClassFactory;
        public TwilioIdentityVerificationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class TwilioIdentityVerificationComponentImpl implements TwilioIdentityVerificationComponent {
        private Provider<ThreadExecutor> A;
        private Provider<ClearAllDanapolyData> BuiltInFictitiousFunctionClassFactory;
        private final TwilioIdentityVerificationComponentImpl C;
        private Provider<FaceAuthPopUpConsultationRepository> DatabaseTableConfigUtil;
        private Provider<Logout> FragmentBottomSheetPaymentSettingBinding;
        private Provider<ForceLogout> GetContactSyncConfig;
        private Provider<ClearCacheFavoriteServices> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ClearAllFeedsUsecase> MyBillsEntityDataFactory;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaSessionManager> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeedInitRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<HomeWidgetClearable> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<DanapolyClearRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<LoginRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GlobalNetworkRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ClearAllSyncEngineUseCase> PlaceComponentResult;
        private Provider<LogoutPresenter> PrepareContext;
        private Provider<LogoutContract.View> SubSequence;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<LogoutContract.Presenter> getCallingPid;
        private Provider<ClearKybData> getErrorConfigVersion;
        private Provider<TwilioIdentityVerificationContract.View> getSupportButtonTintMode;
        private Provider<FeatureConfigRepository> initRecordTimeStamp;
        private Provider<IsOfflineF2FPay> isLayoutRequested;
        private Provider<ContactRepository> lookAheadTest;
        private Provider<ConnectionStatusReceiver> moveToNextValue;
        private Provider<KybRepository> newProxyInstance;
        private Provider<SSLPinningRepository> readMicros;
        private Provider<ClearFaceAuthSuggestionState> scheduleImpl;
        private Provider<ServicesRepository> whenAvailable;

        public /* synthetic */ TwilioIdentityVerificationComponentImpl(TwilioIdentityVerificationModule twilioIdentityVerificationModule, LogoutModule logoutModule, ApplicationComponent applicationComponent, byte b) {
            this(twilioIdentityVerificationModule, logoutModule, applicationComponent);
        }

        private TwilioIdentityVerificationComponentImpl(TwilioIdentityVerificationModule twilioIdentityVerificationModule, LogoutModule logoutModule, ApplicationComponent applicationComponent) {
            this.C = this;
            this.getAuthRequestContext = applicationComponent;
            this.A = new ThreadExecutorProvider(applicationComponent);
            this.readMicros = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda6, featureConfigRepositoryProvider);
            this.isLayoutRequested = create;
            this.moveToNextValue = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.A, this.readMicros, create);
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(TwilioIdentityVerificationModule_ProvideViewFactory.getAuthRequestContext(twilioIdentityVerificationModule));
            this.SubSequence = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new DeviceInformationProviderProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LoginRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provideHomeWidgetClearableProvider;
            this.GetContactSyncConfig = ForceLogout_Factory.create(this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda8, provideHomeWidgetClearableProvider);
            this.FragmentBottomSheetPaymentSettingBinding = Logout_Factory.create(this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.lookAheadTest = contractRepositoryProvider;
            this.PlaceComponentResult = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = provideFeedInitRepositoryProvider;
            this.MyBillsEntityDataFactory = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.whenAvailable = servicesRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provideDanapolyClearRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.newProxyInstance = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.getErrorConfigVersion = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DanaSessionManager_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.GetContactSyncConfig, this.FragmentBottomSheetPaymentSettingBinding, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, authRequestContext);
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create2 = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.scheduleImpl = create2;
            Provider<LogoutPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create2));
            this.PrepareContext = authRequestContext2;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext2));
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
            private final ApplicationComponent PlaceComponentResult;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private static int $10 = 0;
            private static int $11 = 1;
            private static char KClassImpl$Data$declaredNonStaticMembers$2 = 25552;
            private static char MyBillsEntityDataFactory = 59481;
            private static char PlaceComponentResult = 202;
            private static char getAuthRequestContext = 64261;
            private static int getErrorConfigVersion = 0;
            private static int scheduleImpl = 1;
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                int i = getErrorConfigVersion + 109;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                LoginRepository PlaceComponentResult2 = PlaceComponentResult();
                try {
                    int i3 = scheduleImpl + 97;
                    getErrorConfigVersion = i3 % 128;
                    int i4 = i3 % 2;
                    return PlaceComponentResult2;
                } catch (Exception e) {
                    throw e;
                }
            }

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            private LoginRepository PlaceComponentResult() {
                try {
                    int i = scheduleImpl + 81;
                    getErrorConfigVersion = i % 128;
                    if ((i % 2 != 0 ? '`' : '%') != '`') {
                        return (LoginRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.G());
                    }
                    LoginRepository loginRepository = (LoginRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.G());
                    Object obj = null;
                    obj.hashCode();
                    return loginRepository;
                } catch (Exception e) {
                    throw e;
                }
            }

            public static void $$a(long j, long j2) {
                long j3 = j ^ (j2 << 32);
                Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                a(TextUtils.indexOf("", "", 0, 0) + 6, new char[]{25653, 54977, 13696, 21900, 15147, 39911}, objArr);
                sb.append((String) objArr[0]);
                sb.append(j3);
                String obj = sb.toString();
                Intrinsics.checkNotNullParameter(obj, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
                RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
                Intrinsics.checkNotNullParameter(dexguardException, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
                RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
                UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
                int i = getErrorConfigVersion + 27;
                scheduleImpl = i % 128;
                int i2 = i % 2;
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                int i2;
                C c = new C();
                char[] cArr2 = new char[cArr.length];
                c.BuiltInFictitiousFunctionClassFactory = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? ';' : 'E') != 'E') {
                        int i3 = $10 + 69;
                        $11 = i3 % 128;
                        int i4 = 58224;
                        if (i3 % 2 == 0) {
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory % 1];
                            i2 = 1;
                        } else {
                            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                            i2 = 0;
                        }
                        while (true) {
                            if (i2 >= 16) {
                                break;
                            }
                            int i5 = $11 + 117;
                            $10 = i5 % 128;
                            int i6 = i5 % 2;
                            cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                            cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                            i4 -= 40503;
                            i2++;
                        }
                        cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                        cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                        c.BuiltInFictitiousFunctionClassFactory += 2;
                    } else {
                        objArr[0] = new String(cArr2, 0, i);
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SubSequence());
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
            private final ApplicationComponent PlaceComponentResult;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent PlaceComponentResult;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        @Override // id.dana.di.component.TwilioIdentityVerificationComponent
        public final void MyBillsEntityDataFactory(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity) {
            ((BaseActivity) twilioIdentityVerificationActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(twilioIdentityVerificationActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(twilioIdentityVerificationActivity, DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            TwilioIdentityVerificationActivity_MembersInjector.MyBillsEntityDataFactory(twilioIdentityVerificationActivity, new TwilioIdentityVerificationPresenter((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()), this.getSupportButtonTintMode.get(), new GetTwilioChallengeDetails((TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new UpdateTwilioChallenge((TwilioSdkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$2())), new IsTwilioForceLogout((TwilioRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1())), new TwilioMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()))));
            twilioIdentityVerificationActivity.logoutPresenter = this.getCallingPid.get();
        }
    }
}
