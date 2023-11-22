package id.dana.wallet_v3.loyalty.di;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.pocket.PocketRepository;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.pocket.interactor.GetLoyaltyToken_Factory;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset_Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter_Factory;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment_MembersInjector;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerLoyaltyWalletDetailComponent {
    private DaggerLoyaltyWalletDetailComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private LoyaltyWalletDetailModule loyaltyWalletDetailModule;

        private Builder() {
        }

        public final Builder loyaltyWalletDetailModule(LoyaltyWalletDetailModule loyaltyWalletDetailModule) {
            this.loyaltyWalletDetailModule = (LoyaltyWalletDetailModule) Preconditions.getAuthRequestContext(loyaltyWalletDetailModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final LoyaltyWalletDetailComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.loyaltyWalletDetailModule, LoyaltyWalletDetailModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new LoyaltyWalletDetailComponentImpl(this.loyaltyWalletDetailModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LoyaltyWalletDetailComponentImpl implements LoyaltyWalletDetailComponent {
        private Provider<AccountRepository> accountRepositoryProvider;
        private final ApplicationComponent applicationComponent;
        private Provider<GetKycLevel> getKycLevelProvider;
        private Provider<GetLoyaltyToken> getLoyaltyTokenProvider;
        private Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
        private final LoyaltyWalletDetailComponentImpl loyaltyWalletDetailComponentImpl;
        private Provider<LoyaltyWalletPresenter> loyaltyWalletPresenterProvider;
        private Provider<PocketRepository> pocketRepositoryProvider;
        private Provider<LoyaltyWalletContract.Presenter> providePresenterProvider;
        private Provider<LoyaltyWalletContract.View> provideViewProvider;
        private Provider<WalletV3Repository> provideWalletV3RepositoryProvider;

        private LoyaltyWalletDetailComponentImpl(LoyaltyWalletDetailModule loyaltyWalletDetailModule, ApplicationComponent applicationComponent) {
            this.loyaltyWalletDetailComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(loyaltyWalletDetailModule, applicationComponent);
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

        private void initialize(LoyaltyWalletDetailModule loyaltyWalletDetailModule, ApplicationComponent applicationComponent) {
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.accountRepositoryProvider = accountRepositoryProvider;
            this.getKycLevelProvider = GetKycLevel_Factory.create(accountRepositoryProvider);
            PocketRepositoryProvider pocketRepositoryProvider = new PocketRepositoryProvider(applicationComponent);
            this.pocketRepositoryProvider = pocketRepositoryProvider;
            this.getLoyaltyTokenProvider = GetLoyaltyToken_Factory.create(pocketRepositoryProvider);
            ProvideWalletV3RepositoryProvider provideWalletV3RepositoryProvider = new ProvideWalletV3RepositoryProvider(applicationComponent);
            this.provideWalletV3RepositoryProvider = provideWalletV3RepositoryProvider;
            this.getUserPocketWalletAssetProvider = GetUserPocketWalletAsset_Factory.create(provideWalletV3RepositoryProvider);
            Provider<LoyaltyWalletContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(LoyaltyWalletDetailModule_ProvideViewFactory.create(loyaltyWalletDetailModule));
            this.provideViewProvider = authRequestContext;
            LoyaltyWalletPresenter_Factory create = LoyaltyWalletPresenter_Factory.create(this.getKycLevelProvider, this.getLoyaltyTokenProvider, this.getUserPocketWalletAssetProvider, authRequestContext);
            this.loyaltyWalletPresenterProvider = create;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(LoyaltyWalletDetailModule_ProvidePresenterFactory.create(loyaltyWalletDetailModule, create));
        }

        @Override // id.dana.wallet_v3.loyalty.di.LoyaltyWalletDetailComponent
        public final void inject(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment) {
            injectLoyaltyWalletDetailFragment(loyaltyWalletDetailFragment);
        }

        private LoyaltyWalletDetailFragment injectLoyaltyWalletDetailFragment(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment) {
            LoyaltyWalletDetailFragment_MembersInjector.injectLoyaltyPresenter(loyaltyWalletDetailFragment, this.providePresenterProvider.get());
            LoyaltyWalletDetailFragment_MembersInjector.injectWalletV3TrackerImplementation(loyaltyWalletDetailFragment, walletV3TrackerImpl());
            return loyaltyWalletDetailFragment;
        }

        /* loaded from: classes5.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent applicationComponent;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.applicationComponent.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PocketRepositoryProvider implements Provider<PocketRepository> {
            private final ApplicationComponent applicationComponent;

            PocketRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PocketRepository get() {
                return (PocketRepository) Preconditions.PlaceComponentResult(this.applicationComponent.Y());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvideWalletV3RepositoryProvider implements Provider<WalletV3Repository> {
            private final ApplicationComponent applicationComponent;

            ProvideWalletV3RepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final WalletV3Repository get() {
                return (WalletV3Repository) Preconditions.PlaceComponentResult(this.applicationComponent.mo2242reduceIndexedz1zDJgo());
            }
        }
    }
}
