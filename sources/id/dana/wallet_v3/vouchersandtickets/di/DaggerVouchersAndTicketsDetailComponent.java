package id.dana.wallet_v3.vouchersandtickets.di;

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
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset_Factory;
import id.dana.domain.wallet_v3.interactor.SetPocketUpdate;
import id.dana.domain.wallet_v3.interactor.SetPocketUpdate_Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter_Factory;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class DaggerVouchersAndTicketsDetailComponent {
    private DaggerVouchersAndTicketsDetailComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule;

        private Builder() {
        }

        public final Builder vouchersAndTicketsDetailModule(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule) {
            this.vouchersAndTicketsDetailModule = (VouchersAndTicketsDetailModule) Preconditions.getAuthRequestContext(vouchersAndTicketsDetailModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final VouchersAndTicketsDetailComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.vouchersAndTicketsDetailModule, VouchersAndTicketsDetailModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new VouchersAndTicketsDetailComponentImpl(this.vouchersAndTicketsDetailModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class VouchersAndTicketsDetailComponentImpl implements VouchersAndTicketsDetailComponent {
        private final ApplicationComponent applicationComponent;
        private Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
        private Provider<VouchersAndTicketsDetailContract.Presenter> providePresenterProvider;
        private Provider<VouchersAndTicketsDetailContract.View> provideViewProvider;
        private Provider<WalletV3Repository> provideWalletV3RepositoryProvider;
        private Provider<SetPocketUpdate> setPocketUpdateProvider;
        private final VouchersAndTicketsDetailComponentImpl vouchersAndTicketsDetailComponentImpl;
        private Provider<VouchersAndTicketsDetailPresenter> vouchersAndTicketsDetailPresenterProvider;

        private VouchersAndTicketsDetailComponentImpl(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule, ApplicationComponent applicationComponent) {
            this.vouchersAndTicketsDetailComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(vouchersAndTicketsDetailModule, applicationComponent);
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

        private void initialize(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule, ApplicationComponent applicationComponent) {
            this.provideViewProvider = DoubleCheck.getAuthRequestContext(VouchersAndTicketsDetailModule_ProvideViewFactory.create(vouchersAndTicketsDetailModule));
            ProvideWalletV3RepositoryProvider provideWalletV3RepositoryProvider = new ProvideWalletV3RepositoryProvider(applicationComponent);
            this.provideWalletV3RepositoryProvider = provideWalletV3RepositoryProvider;
            this.getUserPocketWalletAssetProvider = GetUserPocketWalletAsset_Factory.create(provideWalletV3RepositoryProvider);
            SetPocketUpdate_Factory create = SetPocketUpdate_Factory.create(this.provideWalletV3RepositoryProvider);
            this.setPocketUpdateProvider = create;
            VouchersAndTicketsDetailPresenter_Factory create2 = VouchersAndTicketsDetailPresenter_Factory.create(this.provideViewProvider, this.getUserPocketWalletAssetProvider, create);
            this.vouchersAndTicketsDetailPresenterProvider = create2;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(VouchersAndTicketsDetailModule_ProvidePresenterFactory.create(vouchersAndTicketsDetailModule, create2));
        }

        @Override // id.dana.wallet_v3.vouchersandtickets.di.VouchersAndTicketsDetailComponent
        public final void inject(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment) {
            injectVouchersAndTicketsDetailFragment(vouchersAndTicketsDetailFragment);
        }

        private VouchersAndTicketsDetailFragment injectVouchersAndTicketsDetailFragment(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment) {
            VouchersAndTicketsDetailFragment_MembersInjector.injectVouchersAndTicketsDetailPresenter(vouchersAndTicketsDetailFragment, this.providePresenterProvider.get());
            VouchersAndTicketsDetailFragment_MembersInjector.injectWalletV3TrackerImplementation(vouchersAndTicketsDetailFragment, walletV3TrackerImpl());
            return vouchersAndTicketsDetailFragment;
        }

        /* loaded from: classes6.dex */
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
