package id.dana.wallet_v3.identity.di;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.domain.wallet_v3.interactor.CheckKtpConsultPopUp;
import id.dana.domain.wallet_v3.interactor.CheckKtpConsultPopUp_Factory;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved_Factory;
import id.dana.domain.wallet_v3.interactor.GetInsuranceAssetList;
import id.dana.domain.wallet_v3.interactor.GetInsuranceAssetList_Factory;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi_Factory;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo_Factory;
import id.dana.domain.wallet_v3.interactor.GetUserKYCStatus;
import id.dana.domain.wallet_v3.interactor.GetUserKYCStatus_Factory;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp_Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.di.module.PersonalModule;
import id.dana.wallet_v3.di.module.PersonalModule_ProvidePresenterFactory;
import id.dana.wallet_v3.di.module.PersonalModule_ProvideViewFactory;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter_Factory;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment_MembersInjector;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerIdentityWalletDetailComponent {
    private DaggerIdentityWalletDetailComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private PersonalModule personalModule;

        private Builder() {
        }

        public final Builder personalModule(PersonalModule personalModule) {
            this.personalModule = (PersonalModule) Preconditions.getAuthRequestContext(personalModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final IdentityWalletDetailComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.personalModule, PersonalModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new IdentityWalletDetailComponentImpl(this.personalModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class IdentityWalletDetailComponentImpl implements IdentityWalletDetailComponent {
        private final ApplicationComponent applicationComponent;
        private Provider<CheckKtpConsultPopUp> checkKtpConsultPopUpProvider;
        private Provider<CheckKtpIsSaved> checkKtpIsSavedProvider;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> consultAgreementOnlyParamSpaceCodesProvider;
        private Provider<GetInsuranceAssetList> getInsuranceAssetListProvider;
        private Provider<GetIntervalTimeHitWalletApi> getIntervalTimeHitWalletApiProvider;
        private Provider<GetKtpInfo> getKtpInfoProvider;
        private Provider<GetUserKYCStatus> getUserKYCStatusProvider;
        private final IdentityWalletDetailComponentImpl identityWalletDetailComponentImpl;
        private Provider<PersonalPresenter> personalPresenterProvider;
        private Provider<PersonalTabRepository> providePersonalTabRepositoryProvider;
        private Provider<PersonalContract.Presenter> providePresenterProvider;
        private Provider<PersonalContract.View> provideViewProvider;
        private Provider<WalletConfigRepository> provideWalletConfigRepositoryProvider;
        private Provider<RecordAgreementOnlyAgreementKey> recordAgreementOnlyAgreementKeyProvider;
        private Provider<SaveKtpConsultPopUp> saveKtpConsultPopUpProvider;
        private Provider<UserConsentRepository> userConsentRepositoryProvider;

        private IdentityWalletDetailComponentImpl(PersonalModule personalModule, ApplicationComponent applicationComponent) {
            this.identityWalletDetailComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(personalModule, applicationComponent);
        }

        private FirebaseAnalytics firebaseAnalytics() {
            return new FirebaseAnalytics((Context) Preconditions.PlaceComponentResult(this.applicationComponent.moveToNextValue()), (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.applicationComponent.OtpRegistrationPresenter$input$2()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.applicationComponent.j()));
        }

        private MixpanelAnalytics mixpanelAnalytics() {
            return new MixpanelAnalytics((Context) Preconditions.PlaceComponentResult(this.applicationComponent.moveToNextValue()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.applicationComponent.j()));
        }

        private AnalyticsTrackerFactory analyticsTrackerFactory() {
            return new AnalyticsTrackerFactory(firebaseAnalytics(), mixpanelAnalytics(), new FullStoryAnalytics());
        }

        private WalletV3TrackerImpl walletV3TrackerImpl() {
            return new WalletV3TrackerImpl(analyticsTrackerFactory());
        }

        private void initialize(PersonalModule personalModule, ApplicationComponent applicationComponent) {
            this.provideViewProvider = DoubleCheck.getAuthRequestContext(PersonalModule_ProvideViewFactory.create(personalModule));
            ProvidePersonalTabRepositoryProvider providePersonalTabRepositoryProvider = new ProvidePersonalTabRepositoryProvider(applicationComponent);
            this.providePersonalTabRepositoryProvider = providePersonalTabRepositoryProvider;
            this.checkKtpConsultPopUpProvider = CheckKtpConsultPopUp_Factory.create(providePersonalTabRepositoryProvider);
            this.saveKtpConsultPopUpProvider = SaveKtpConsultPopUp_Factory.create(this.providePersonalTabRepositoryProvider);
            this.getUserKYCStatusProvider = GetUserKYCStatus_Factory.create(this.providePersonalTabRepositoryProvider);
            this.getKtpInfoProvider = GetKtpInfo_Factory.create(this.providePersonalTabRepositoryProvider);
            this.getInsuranceAssetListProvider = GetInsuranceAssetList_Factory.create(this.providePersonalTabRepositoryProvider);
            this.checkKtpIsSavedProvider = CheckKtpIsSaved_Factory.create(this.providePersonalTabRepositoryProvider);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.userConsentRepositoryProvider = userConsentRepositoryProvider;
            this.consultAgreementOnlyParamSpaceCodesProvider = ConsultAgreementOnlyParamSpaceCodes_Factory.create(userConsentRepositoryProvider);
            this.recordAgreementOnlyAgreementKeyProvider = RecordAgreementOnlyAgreementKey_Factory.create(this.userConsentRepositoryProvider);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.provideWalletConfigRepositoryProvider = provideWalletConfigRepositoryProvider;
            GetIntervalTimeHitWalletApi_Factory create = GetIntervalTimeHitWalletApi_Factory.create(provideWalletConfigRepositoryProvider);
            this.getIntervalTimeHitWalletApiProvider = create;
            PersonalPresenter_Factory create2 = PersonalPresenter_Factory.create(this.provideViewProvider, this.checkKtpConsultPopUpProvider, this.saveKtpConsultPopUpProvider, this.getUserKYCStatusProvider, this.getKtpInfoProvider, this.getInsuranceAssetListProvider, this.checkKtpIsSavedProvider, this.consultAgreementOnlyParamSpaceCodesProvider, this.recordAgreementOnlyAgreementKeyProvider, create);
            this.personalPresenterProvider = create2;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(PersonalModule_ProvidePresenterFactory.create(personalModule, create2));
        }

        @Override // id.dana.wallet_v3.identity.di.IdentityWalletDetailComponent
        public final void inject(IdentityWalletDetailFragment identityWalletDetailFragment) {
            injectIdentityWalletDetailFragment(identityWalletDetailFragment);
        }

        private IdentityWalletDetailFragment injectIdentityWalletDetailFragment(IdentityWalletDetailFragment identityWalletDetailFragment) {
            IdentityWalletDetailFragment_MembersInjector.injectPersonalPresenter(identityWalletDetailFragment, this.providePresenterProvider.get());
            IdentityWalletDetailFragment_MembersInjector.injectDynamicUrlWrapper(identityWalletDetailFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.applicationComponent.PrepareContext()));
            IdentityWalletDetailFragment_MembersInjector.injectWalletV3TrackerImplementation(identityWalletDetailFragment, walletV3TrackerImpl());
            return identityWalletDetailFragment;
        }

        /* loaded from: classes5.dex */
        public static final class ProvidePersonalTabRepositoryProvider implements Provider<PersonalTabRepository> {
            private final ApplicationComponent applicationComponent;

            ProvidePersonalTabRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PersonalTabRepository get() {
                return (PersonalTabRepository) Preconditions.PlaceComponentResult(this.applicationComponent.RequestMoneyQrContract$View());
            }
        }

        /* loaded from: classes5.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent applicationComponent;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.applicationComponent.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvideWalletConfigRepositoryProvider implements Provider<WalletConfigRepository> {
            private final ApplicationComponent applicationComponent;

            ProvideWalletConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final WalletConfigRepository get() {
                return (WalletConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.getIndexName());
            }
        }
    }
}
