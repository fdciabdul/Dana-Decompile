package id.dana.wallet_v3.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder_Factory;
import id.dana.domain.wallet_v3.interactor.GetWalletSortCategory;
import id.dana.domain.wallet_v3.interactor.GetWalletSortCategory_Factory;
import id.dana.domain.wallet_v3.interactor.SaveVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.SaveVoucherAndTicketOrder_Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.wallet_v3.di.module.BottomSheetSortAssetModule;
import id.dana.wallet_v3.di.module.BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter;
import id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset;
import id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerBottomSheetSortAssetComponent {
    private DaggerBottomSheetSortAssetComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private BottomSheetSortAssetModule bottomSheetSortAssetModule;

        private Builder() {
        }

        public final Builder bottomSheetSortAssetModule(BottomSheetSortAssetModule bottomSheetSortAssetModule) {
            this.bottomSheetSortAssetModule = (BottomSheetSortAssetModule) Preconditions.getAuthRequestContext(bottomSheetSortAssetModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final BottomSheetSortAssetComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.bottomSheetSortAssetModule, BottomSheetSortAssetModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new BottomSheetSortAssetComponentImpl(this.bottomSheetSortAssetModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BottomSheetSortAssetComponentImpl implements BottomSheetSortAssetComponent {
        private final BottomSheetSortAssetComponentImpl bottomSheetSortAssetComponentImpl;
        private Provider<GetVoucherAndTicketOrder> getVoucherAndTicketOrderProvider;
        private Provider<GetWalletSortCategory> getWalletSortCategoryProvider;
        private Provider<BottomSheetSortAssetContract.View> provideView$app_productionReleaseProvider;
        private Provider<WalletConfigRepository> provideWalletConfigRepositoryProvider;
        private Provider<WalletV3Repository> provideWalletV3RepositoryProvider;
        private Provider<SaveVoucherAndTicketOrder> saveVoucherAndTicketOrderProvider;

        private BottomSheetSortAssetComponentImpl(BottomSheetSortAssetModule bottomSheetSortAssetModule, ApplicationComponent applicationComponent) {
            this.bottomSheetSortAssetComponentImpl = this;
            initialize(bottomSheetSortAssetModule, applicationComponent);
        }

        private BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter() {
            return new BottomSheetSortAssetPresenter(DoubleCheck.MyBillsEntityDataFactory(this.provideView$app_productionReleaseProvider), DoubleCheck.MyBillsEntityDataFactory(this.getWalletSortCategoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveVoucherAndTicketOrderProvider), DoubleCheck.MyBillsEntityDataFactory(this.getVoucherAndTicketOrderProvider));
        }

        private void initialize(BottomSheetSortAssetModule bottomSheetSortAssetModule, ApplicationComponent applicationComponent) {
            this.provideView$app_productionReleaseProvider = BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory.create(bottomSheetSortAssetModule);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.provideWalletConfigRepositoryProvider = provideWalletConfigRepositoryProvider;
            this.getWalletSortCategoryProvider = GetWalletSortCategory_Factory.create(provideWalletConfigRepositoryProvider);
            ProvideWalletV3RepositoryProvider provideWalletV3RepositoryProvider = new ProvideWalletV3RepositoryProvider(applicationComponent);
            this.provideWalletV3RepositoryProvider = provideWalletV3RepositoryProvider;
            this.saveVoucherAndTicketOrderProvider = SaveVoucherAndTicketOrder_Factory.create(provideWalletV3RepositoryProvider);
            this.getVoucherAndTicketOrderProvider = GetVoucherAndTicketOrder_Factory.create(this.provideWalletV3RepositoryProvider);
        }

        @Override // id.dana.wallet_v3.di.component.BottomSheetSortAssetComponent
        public final void inject(BottomSheetSortAsset bottomSheetSortAsset) {
            injectBottomSheetSortAsset(bottomSheetSortAsset);
        }

        private BottomSheetSortAsset injectBottomSheetSortAsset(BottomSheetSortAsset bottomSheetSortAsset) {
            BottomSheetSortAsset_MembersInjector.injectBottomSheetSortAssetPresenter(bottomSheetSortAsset, bottomSheetSortAssetPresenter());
            return bottomSheetSortAsset;
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
