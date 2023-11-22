package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.DonationModule;
import id.dana.di.modules.DonationModule_ProvideDonationPresenterFactory;
import id.dana.di.modules.DonationModule_ProvideDonationViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.donation.DonationRepository;
import id.dana.domain.donation.interactor.GetDonationCampaigns;
import id.dana.domain.donation.interactor.GetDonationCampaigns_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetDonationCampaignConfig;
import id.dana.domain.featureconfig.interactor.GetDonationCampaignConfig_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.donation.DonationContract;
import id.dana.donation.DonationPresenter;
import id.dana.donation.DonationPresenter_Factory;
import id.dana.richview.donation.DonationView;
import id.dana.richview.donation.DonationView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerDonationComponent {
    private DaggerDonationComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public DonationModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class DonationComponentImpl implements DonationComponent {
        private Provider<DonationPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<DonationContract.View> DatabaseTableConfigUtil;
        private Provider<UserConsentRepository> GetContactSyncConfig;
        private Provider<DonationRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetAuthCode> MyBillsEntityDataFactory;
        private Provider<GetEmptyUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DonationContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private final DonationComponentImpl getAuthRequestContext;
        private Provider<GetDonationCampaignConfig> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<GetDonationCampaigns> moveToNextValue;
        private Provider<OauthRepository> scheduleImpl;

        public /* synthetic */ DonationComponentImpl(DonationModule donationModule, ApplicationComponent applicationComponent, byte b) {
            this(donationModule, applicationComponent);
        }

        private DonationComponentImpl(DonationModule donationModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(DonationModule_ProvideDonationViewFactory.MyBillsEntityDataFactory(donationModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            DonationRepositoryProvider donationRepositoryProvider = new DonationRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = donationRepositoryProvider;
            this.moveToNextValue = GetDonationCampaigns_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, donationRepositoryProvider);
            this.scheduleImpl = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.MyBillsEntityDataFactory = GetAuthCode_Factory.create(this.scheduleImpl, create);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            GetDonationCampaignConfig_Factory create2 = GetDonationCampaignConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, featureConfigRepositoryProvider);
            this.getErrorConfigVersion = create2;
            Provider<DonationPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(DonationPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.moveToNextValue, this.MyBillsEntityDataFactory, create2));
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(DonationModule_ProvideDonationPresenterFactory.MyBillsEntityDataFactory(donationModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class DonationRepositoryProvider implements Provider<DonationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            DonationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DonationRepository get() {
                return (DonationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isLayoutRequested());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.WithdrawSavedCardChannelView());
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

        @Override // id.dana.di.component.DonationComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DonationView donationView) {
            DonationView_MembersInjector.getAuthRequestContext(donationView, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
