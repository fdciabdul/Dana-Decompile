package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.challenge.otp.OtpChallengeFragment;
import id.dana.challenge.otp.OtpChallengeFragment_MembersInjector;
import id.dana.challenge.otp.OtpLoginPresenter;
import id.dana.challenge.otp.OtpLoginPresenter_Factory;
import id.dana.challenge.otp.OtpRegistrationPresenter;
import id.dana.challenge.otp.OtpRegistrationPresenter_Factory;
import id.dana.challenge.otp.OtpTwilioPresenter;
import id.dana.challenge.otp.OtpTwilioPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository_Factory;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvideViewFactory;
import id.dana.di.modules.ChangePhoneNumberH5EventModule_ProvidesChangePhoneNumberH5EventRepositoryFactory;
import id.dana.di.modules.OtpChallengeModule;
import id.dana.di.modules.OtpChallengeModule_ProvidePresenterFactory;
import id.dana.di.modules.OtpChallengeModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable_Factory;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig_Factory;
import id.dana.domain.h5event.interactor.GetChangePhoneNumberH5Event;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.OtpLogin;
import id.dana.domain.login.interactor.OtpLogin_Factory;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.ReceiveOtp_Factory;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.SendOtp_Factory;
import id.dana.domain.otp.interactor.VerifyOtp;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.otp.interactor.VerifyOtpRisk_Factory;
import id.dana.domain.otp.interactor.VerifyOtp_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp_Factory;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp_Factory;
import id.dana.domain.registration.interactor.ResendOtp;
import id.dana.domain.registration.interactor.ResendOtp_Factory;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp_Factory;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp_Factory;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct_Factory;
import id.dana.h5event.ChangePhoneNumberH5EventPresenter;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission_Factory;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerOtpChallengeComponent {
    private DaggerOtpChallengeComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ChangePhoneNumberH5EventModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;
        public OtpChallengeModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class OtpChallengeComponentImpl implements OtpChallengeComponent {
        private Provider<SaveIsSyncPermission> A;
        private Provider<SaveNumberOfRequestOtp> B;
        private Provider<SendOtp> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> C;
        private Provider<TwilioVerifySecurityProduct> D;
        private Provider<OtpLogin> DatabaseTableConfigUtil;
        private Provider<VerifyOtpRisk> E;
        private Provider<RegistrationTracker> FragmentBottomSheetPaymentSettingBinding;
        private Provider<OtpLoginPresenter> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ContactRepository> MyBillsEntityDataFactory;
        private Provider<GetIsSyncPermission> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final OtpChallengeComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<LoginRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<AbstractOtpContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<LoginTracker> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<SplitFacade> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<AbstractOtpContract.View> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<OtpRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<OtpTwilioPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ChangePhoneNumberH5EventModule PlaceComponentResult;
        private Provider<CarrierIdentificationRepository> PrepareContext;
        private Provider<RemoveNumberOfRequestOtp> SubSequence;
        private Provider<TwilioRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<CheckResendWhatsAppEnable> getAuthRequestContext;
        private Provider<ReceiveOtp> getCallingPid;
        private Provider<DeviceInformationProvider> getErrorConfigVersion;
        private Provider<VerifyOtp> getOnBoardingScenario;
        private Provider<SaveIsFreezeVerifyOtp> getSupportButtonTintMode;
        private Provider<UserInfoMapper> getValueOfTouchPositionAbsolute;
        private Provider<OtpRegistrationPresenter> initRecordTimeStamp;
        private Provider<BotProtectionChallenge> isLayoutRequested;
        private Provider<GetQueryUserDataConfig> lookAheadTest;
        private Provider<FeatureConfigRepository> moveToNextValue;
        private Provider<PostExecutionThread> newProxyInstance;
        private Provider<ResendOtp> readMicros;
        private Provider<GetNumberOfRequestOtp> scheduleImpl;
        private Provider<RegistrationRepository> whenAvailable;

        public /* synthetic */ OtpChallengeComponentImpl(OtpChallengeModule otpChallengeModule, ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, ApplicationComponent applicationComponent, byte b) {
            this(otpChallengeModule, changePhoneNumberH5EventModule, applicationComponent);
        }

        private OtpChallengeComponentImpl(OtpChallengeModule otpChallengeModule, ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.PlaceComponentResult = changePhoneNumberH5EventModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(OtpChallengeModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(otpChallengeModule));
            OtpRepositoryProvider otpRepositoryProvider = new OtpRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = otpRepositoryProvider;
            this.getOnBoardingScenario = VerifyOtp_Factory.create(otpRepositoryProvider);
            ProvideCarrierIdentificationRepositoryProvider provideCarrierIdentificationRepositoryProvider = new ProvideCarrierIdentificationRepositoryProvider(applicationComponent);
            this.PrepareContext = provideCarrierIdentificationRepositoryProvider;
            this.E = VerifyOtpRisk_Factory.create(provideCarrierIdentificationRepositoryProvider);
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.whenAvailable = registrationRepositoryProvider;
            this.readMicros = ResendOtp_Factory.create(registrationRepositoryProvider);
            this.getCallingPid = ReceiveOtp_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.moveToNextValue = featureConfigRepositoryProvider;
            this.getAuthRequestContext = CheckResendWhatsAppEnable_Factory.create(featureConfigRepositoryProvider);
            this.scheduleImpl = GetNumberOfRequestOtp_Factory.create(this.whenAvailable);
            this.B = SaveNumberOfRequestOtp_Factory.create(this.whenAvailable);
            this.SubSequence = RemoveNumberOfRequestOtp_Factory.create(this.whenAvailable);
            this.getSupportButtonTintMode = SaveIsFreezeVerifyOtp_Factory.create(this.whenAvailable);
            ProvideRegistrationTrackerProvider provideRegistrationTrackerProvider = new ProvideRegistrationTrackerProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideRegistrationTrackerProvider;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(OtpRegistrationPresenter_Factory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getOnBoardingScenario, this.E, this.readMicros, this.getCallingPid, this.getAuthRequestContext, this.scheduleImpl, this.B, this.SubSequence, this.getSupportButtonTintMode, provideRegistrationTrackerProvider));
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = loginRepositoryProvider;
            this.DatabaseTableConfigUtil = OtpLogin_Factory.create(loginRepositoryProvider);
            this.C = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.newProxyInstance = postExecutionThreadProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = SendOtp_Factory.create(this.C, postExecutionThreadProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getErrorConfigVersion = new DeviceInformationProviderProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ProvideSplitFacadeProvider(applicationComponent);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contractRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetIsSyncPermission_Factory.PlaceComponentResult(contractRepositoryProvider);
            this.A = SaveIsSyncPermission_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            this.lookAheadTest = GetQueryUserDataConfig_Factory.create(this.moveToNextValue);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ProvideLoginTrackerProvider(applicationComponent);
            UserInfoMapper_Factory PlaceComponentResult = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.getValueOfTouchPositionAbsolute = PlaceComponentResult;
            this.GetContactSyncConfig = OtpLoginPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.DatabaseTableConfigUtil, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.getCallingPid, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.A, this.getSupportButtonTintMode, this.scheduleImpl, this.B, this.SubSequence, this.getAuthRequestContext, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.E, PlaceComponentResult);
            TwilioEnrollmentRepositoryProvider twilioEnrollmentRepositoryProvider = new TwilioEnrollmentRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = twilioEnrollmentRepositoryProvider;
            TwilioVerifySecurityProduct_Factory create = TwilioVerifySecurityProduct_Factory.create(this.C, this.newProxyInstance, twilioEnrollmentRepositoryProvider);
            this.D = create;
            OtpTwilioPresenter_Factory MyBillsEntityDataFactory = OtpTwilioPresenter_Factory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.BottomSheetCardBindingView$watcherCardNumberView$1, create, this.getCallingPid);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(OtpChallengeModule_ProvidePresenterFactory.getAuthRequestContext(otpChallengeModule, this.initRecordTimeStamp, this.GetContactSyncConfig, MyBillsEntityDataFactory));
            this.isLayoutRequested = new ProvideBotProtectionChallengeProvider(applicationComponent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OtpRepositoryProvider implements Provider<OtpRepository> {
            private final ApplicationComponent getAuthRequestContext;

            OtpRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OtpRepository get() {
                return (OtpRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.W());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideCarrierIdentificationRepositoryProvider implements Provider<CarrierIdentificationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideCarrierIdentificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CarrierIdentificationRepository get() {
                return (CarrierIdentificationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.rotateTo());
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
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.verifyNotNull());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.G());
            }
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
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideSplitFacadeProvider implements Provider<SplitFacade> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideSplitFacadeProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitFacade get() {
                return (SplitFacade) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.secondaryHash());
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
        public static final class ProvideLoginTrackerProvider implements Provider<LoginTracker> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideLoginTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginTracker get() {
                return (LoginTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.v());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentRepositoryProvider implements Provider<TwilioRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            TwilioEnrollmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioRepository get() {
                return (TwilioRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideBotProtectionChallengeProvider implements Provider<BotProtectionChallenge> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideBotProtectionChallengeProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ BotProtectionChallenge get() {
                return (BotProtectionChallenge) Preconditions.PlaceComponentResult(this.PlaceComponentResult.FillAnimation());
            }
        }

        @Override // id.dana.di.component.OtpChallengeComponent
        public final void getAuthRequestContext(OtpChallengeFragment otpChallengeFragment) {
            OtpChallengeFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment, ChangePhoneNumberH5EventModule_ProvidePresenterFactory.PlaceComponentResult(this.PlaceComponentResult, new ChangePhoneNumberH5EventPresenter(new GetChangePhoneNumberH5Event((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), ChangePhoneNumberH5EventModule_ProvidesChangePhoneNumberH5EventRepositoryFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ChangePhoneNumberH5EventEntityRepository_Factory.newInstance())), ChangePhoneNumberH5EventModule_ProvideViewFactory.getAuthRequestContext(this.PlaceComponentResult))));
            OtpChallengeFragment_MembersInjector.getAuthRequestContext(otpChallengeFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda3.get());
            OtpChallengeFragment_MembersInjector.getAuthRequestContext(otpChallengeFragment, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            OtpChallengeFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment, DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested));
        }
    }
}
