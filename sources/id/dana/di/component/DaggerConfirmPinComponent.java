package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.ConfirmPinModule;
import id.dana.di.modules.ConfirmPinModule_ProvidesPresenterFactory;
import id.dana.di.modules.ConfirmPinModule_ProvidesViewFactory;
import id.dana.di.modules.TncSummaryModules;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryPresenterFactory;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.CreateProfile;
import id.dana.domain.registration.interactor.CreateProfile_Factory;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode_Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.onboarding.confirmpin.ConfirmPinFragment;
import id.dana.onboarding.confirmpin.ConfirmPinFragment_MembersInjector;
import id.dana.onboarding.confirmpin.ConfirmPinPresenter;
import id.dana.onboarding.confirmpin.ConfirmPinPresenter_Factory;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.TncSummaryPresenter;
import id.dana.tncsummary.TncSummaryPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerConfirmPinComponent {
    private DaggerConfirmPinComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public TncSummaryModules KClassImpl$Data$declaredNonStaticMembers$2;
        public ConfirmPinModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ConfirmPinComponentImpl implements ConfirmPinComponent {
        private Provider<ConfirmPinPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<RegistrationTracker> DatabaseTableConfigUtil;
        private Provider<UserConsentRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<CreateProfile> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> MyBillsEntityDataFactory;
        private Provider<GetSummaryTncConfigWithSpaceCode> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<LiteAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<TncSummaryContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<TncSummaryPresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<TncSummaryRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ConfirmPinContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ConfirmPinContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ConfirmPinComponentImpl PlaceComponentResult;
        private Provider<RegistrationRepository> PrepareContext;
        private Provider<Context> getAuthRequestContext;
        private Provider<DeviceInformationProvider> getErrorConfigVersion;
        private Provider<TncSummaryContract.View> initRecordTimeStamp;
        private Provider<ThreadExecutor> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<GetUserId> moveToNextValue;
        private Provider<RecordAgreementOnlyAgreementKey> newProxyInstance;
        private Provider<GetAuthenticationTypeFeature> scheduleImpl;

        public /* synthetic */ ConfirmPinComponentImpl(ConfirmPinModule confirmPinModule, TncSummaryModules tncSummaryModules, ApplicationComponent applicationComponent, byte b) {
            this(confirmPinModule, tncSummaryModules, applicationComponent);
        }

        private ConfirmPinComponentImpl(ConfirmPinModule confirmPinModule, TncSummaryModules tncSummaryModules, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.getAuthRequestContext = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(ConfirmPinModule_ProvidesViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(confirmPinModule));
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.PrepareContext = registrationRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CreateProfile_Factory.create(registrationRepositoryProvider);
            this.getErrorConfigVersion = new DeviceInformationProviderProvider(applicationComponent);
            this.isLayoutRequested = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = liteAccountRepositoryProvider;
            this.moveToNextValue = GetUserId_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, liteAccountRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            this.scheduleImpl = GetAuthenticationTypeFeature_Factory.create(featureConfigRepositoryProvider);
            ProvideRegistrationTrackerProvider provideRegistrationTrackerProvider = new ProvideRegistrationTrackerProvider(applicationComponent);
            this.DatabaseTableConfigUtil = provideRegistrationTrackerProvider;
            ConfirmPinPresenter_Factory MyBillsEntityDataFactory = ConfirmPinPresenter_Factory.MyBillsEntityDataFactory(this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.moveToNextValue, this.scheduleImpl, provideRegistrationTrackerProvider);
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(ConfirmPinModule_ProvidesPresenterFactory.getAuthRequestContext(confirmPinModule, MyBillsEntityDataFactory));
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryViewFactory.getAuthRequestContext(tncSummaryModules));
            TncSummaryRepositoryProvider tncSummaryRepositoryProvider = new TncSummaryRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = tncSummaryRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetSummaryTncConfigWithSpaceCode_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, tncSummaryRepositoryProvider);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = userConsentRepositoryProvider;
            this.MyBillsEntityDataFactory = ConsultAgreementOnlyParamSpaceCodes_Factory.create(userConsentRepositoryProvider);
            RecordAgreementOnlyAgreementKey_Factory create = RecordAgreementOnlyAgreementKey_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.newProxyInstance = create;
            TncSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = TncSummaryPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryPresenterFactory.PlaceComponentResult(tncSummaryModules, KClassImpl$Data$declaredNonStaticMembers$2));
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
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.rotateTo());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRegistrationTrackerProvider implements Provider<RegistrationTracker> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideRegistrationTrackerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationTracker get() {
                return (RegistrationTracker) Preconditions.PlaceComponentResult(this.PlaceComponentResult.verifyNotNull());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TncSummaryRepositoryProvider implements Provider<TncSummaryRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            TncSummaryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TncSummaryRepository get() {
                return (TncSummaryRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ArrayTable$3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView());
            }
        }

        @Override // id.dana.di.component.ConfirmPinComponent
        public final void PlaceComponentResult(ConfirmPinFragment confirmPinFragment) {
            ConfirmPinFragment_MembersInjector.MyBillsEntityDataFactory(confirmPinFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda8.get());
            ConfirmPinFragment_MembersInjector.PlaceComponentResult(confirmPinFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
        }
    }
}
