package id.dana.wallet_v3.vouchersandtickets.di;

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
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset_Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter_Factory;
import id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity;
import id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class DaggerVoucherAndTicketExpiredListComponent {
    private DaggerVoucherAndTicketExpiredListComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule;

        private Builder() {
        }

        public final Builder voucherAndTicketExpiredListModule(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule) {
            this.voucherAndTicketExpiredListModule = (VoucherAndTicketExpiredListModule) Preconditions.getAuthRequestContext(voucherAndTicketExpiredListModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final VoucherAndTicketExpiredListComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.voucherAndTicketExpiredListModule, VoucherAndTicketExpiredListModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new VoucherAndTicketExpiredListComponentImpl(this.voucherAndTicketExpiredListModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class VoucherAndTicketExpiredListComponentImpl implements VoucherAndTicketExpiredListComponent {
        private final ApplicationComponent applicationComponent;
        private Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
        private Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
        private Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
        private Provider<IsOfflineF2FPay> isOfflineF2FPayProvider;
        private Provider<PostExecutionThread> postExecutionThreadProvider;
        private Provider<VoucherAndTicketExpiredListContract.Presenter> providePresenterProvider;
        private Provider<VoucherAndTicketExpiredListContract.View> provideViewProvider;
        private Provider<WalletV3Repository> provideWalletV3RepositoryProvider;
        private Provider<SSLPinningRepository> sSLPinningRepositoryProvider;
        private Provider<ThreadExecutor> threadExecutorProvider;
        private final VoucherAndTicketExpiredListComponentImpl voucherAndTicketExpiredListComponentImpl;
        private Provider<VoucherAndTicketExpiredListPresenter> voucherAndTicketExpiredListPresenterProvider;

        private VoucherAndTicketExpiredListComponentImpl(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule, ApplicationComponent applicationComponent) {
            this.voucherAndTicketExpiredListComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(voucherAndTicketExpiredListModule, applicationComponent);
        }

        private void initialize(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule, ApplicationComponent applicationComponent) {
            this.threadExecutorProvider = new ThreadExecutorProvider(applicationComponent);
            this.sSLPinningRepositoryProvider = new SSLPinningRepositoryProvider(applicationComponent);
            this.postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.featureConfigRepositoryProvider = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, featureConfigRepositoryProvider);
            this.isOfflineF2FPayProvider = create;
            this.connectionStatusReceiverProvider = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.threadExecutorProvider, this.sSLPinningRepositoryProvider, create);
            this.provideViewProvider = DoubleCheck.getAuthRequestContext(VoucherAndTicketExpiredListModule_ProvideViewFactory.create(voucherAndTicketExpiredListModule));
            ProvideWalletV3RepositoryProvider provideWalletV3RepositoryProvider = new ProvideWalletV3RepositoryProvider(applicationComponent);
            this.provideWalletV3RepositoryProvider = provideWalletV3RepositoryProvider;
            GetUserPocketWalletAsset_Factory create2 = GetUserPocketWalletAsset_Factory.create(provideWalletV3RepositoryProvider);
            this.getUserPocketWalletAssetProvider = create2;
            VoucherAndTicketExpiredListPresenter_Factory create3 = VoucherAndTicketExpiredListPresenter_Factory.create(this.provideViewProvider, create2);
            this.voucherAndTicketExpiredListPresenterProvider = create3;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(VoucherAndTicketExpiredListModule_ProvidePresenterFactory.create(voucherAndTicketExpiredListModule, create3));
        }

        @Override // id.dana.wallet_v3.vouchersandtickets.di.VoucherAndTicketExpiredListComponent
        public final void inject(VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity) {
            injectVoucherAndTicketExpiredListActivity(voucherAndTicketExpiredListActivity);
        }

        private VoucherAndTicketExpiredListActivity injectVoucherAndTicketExpiredListActivity(VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity) {
            ((BaseActivity) voucherAndTicketExpiredListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.applicationComponent.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(voucherAndTicketExpiredListActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(voucherAndTicketExpiredListActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
            VoucherAndTicketExpiredListActivity_MembersInjector.injectVoucherAndTicketExpiredListPresenter(voucherAndTicketExpiredListActivity, this.providePresenterProvider.get());
            return voucherAndTicketExpiredListActivity;
        }

        /* loaded from: classes6.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent applicationComponent;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.applicationComponent.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes6.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent applicationComponent;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.applicationComponent.getRawPath());
            }
        }

        /* loaded from: classes6.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent applicationComponent;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.applicationComponent.isAuto());
            }
        }

        /* loaded from: classes6.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent applicationComponent;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
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
