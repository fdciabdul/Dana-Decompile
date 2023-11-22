package id.dana.wallet_v3.view.search.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class WalletSearchFragment_MembersInjector implements MembersInjector<WalletSearchFragment> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<DynamicUrlWrapper> dynamicUrlWrapperProvider;
    private final Provider<FeatureContract.Presenter> featurePresenterProvider;
    private final Provider<GetBalanceContract.Presenter> getBalancePresenterProvider;
    private final Provider<LoyaltyWalletContract.Presenter> loyaltyPresenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenterProvider;
    private final Provider<ServicesContract.Presenter> servicesPresenterProvider;
    private final Provider<WalletH5ServicesImplementation> walletH5ServicesImplementationProvider;
    private final Provider<WalletSearchPresenter> walletSearchPresenterProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public WalletSearchFragment_MembersInjector(Provider<WalletSearchPresenter> provider, Provider<ServicesContract.Presenter> provider2, Provider<ReadLinkPropertiesContract.Presenter> provider3, Provider<LoyaltyWalletContract.Presenter> provider4, Provider<GetBalanceContract.Presenter> provider5, Provider<DynamicUrlWrapper> provider6, Provider<DeviceInformationProvider> provider7, Provider<WalletH5ServicesImplementation> provider8, Provider<WalletV3TrackerImpl> provider9, Provider<FeatureContract.Presenter> provider10) {
        this.walletSearchPresenterProvider = provider;
        this.servicesPresenterProvider = provider2;
        this.readLinkPropertiesPresenterProvider = provider3;
        this.loyaltyPresenterProvider = provider4;
        this.getBalancePresenterProvider = provider5;
        this.dynamicUrlWrapperProvider = provider6;
        this.deviceInformationProvider = provider7;
        this.walletH5ServicesImplementationProvider = provider8;
        this.walletV3TrackerImplementationProvider = provider9;
        this.featurePresenterProvider = provider10;
    }

    public static MembersInjector<WalletSearchFragment> create(Provider<WalletSearchPresenter> provider, Provider<ServicesContract.Presenter> provider2, Provider<ReadLinkPropertiesContract.Presenter> provider3, Provider<LoyaltyWalletContract.Presenter> provider4, Provider<GetBalanceContract.Presenter> provider5, Provider<DynamicUrlWrapper> provider6, Provider<DeviceInformationProvider> provider7, Provider<WalletH5ServicesImplementation> provider8, Provider<WalletV3TrackerImpl> provider9, Provider<FeatureContract.Presenter> provider10) {
        return new WalletSearchFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public final void injectMembers(WalletSearchFragment walletSearchFragment) {
        injectWalletSearchPresenter(walletSearchFragment, this.walletSearchPresenterProvider.get());
        injectServicesPresenter(walletSearchFragment, this.servicesPresenterProvider.get());
        injectReadLinkPropertiesPresenter(walletSearchFragment, this.readLinkPropertiesPresenterProvider.get());
        injectLoyaltyPresenter(walletSearchFragment, this.loyaltyPresenterProvider.get());
        injectGetBalancePresenter(walletSearchFragment, this.getBalancePresenterProvider.get());
        injectDynamicUrlWrapper(walletSearchFragment, this.dynamicUrlWrapperProvider.get());
        injectDeviceInformationProvider(walletSearchFragment, this.deviceInformationProvider.get());
        injectWalletH5ServicesImplementation(walletSearchFragment, this.walletH5ServicesImplementationProvider.get());
        injectWalletV3TrackerImplementation(walletSearchFragment, this.walletV3TrackerImplementationProvider.get());
        injectFeaturePresenter(walletSearchFragment, this.featurePresenterProvider.get());
    }

    public static void injectWalletSearchPresenter(WalletSearchFragment walletSearchFragment, WalletSearchPresenter walletSearchPresenter) {
        walletSearchFragment.walletSearchPresenter = walletSearchPresenter;
    }

    public static void injectServicesPresenter(WalletSearchFragment walletSearchFragment, ServicesContract.Presenter presenter) {
        walletSearchFragment.servicesPresenter = presenter;
    }

    public static void injectReadLinkPropertiesPresenter(WalletSearchFragment walletSearchFragment, ReadLinkPropertiesContract.Presenter presenter) {
        walletSearchFragment.readLinkPropertiesPresenter = presenter;
    }

    public static void injectLoyaltyPresenter(WalletSearchFragment walletSearchFragment, LoyaltyWalletContract.Presenter presenter) {
        walletSearchFragment.loyaltyPresenter = presenter;
    }

    public static void injectGetBalancePresenter(WalletSearchFragment walletSearchFragment, GetBalanceContract.Presenter presenter) {
        walletSearchFragment.getBalancePresenter = presenter;
    }

    public static void injectDynamicUrlWrapper(WalletSearchFragment walletSearchFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        walletSearchFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void injectDeviceInformationProvider(WalletSearchFragment walletSearchFragment, DeviceInformationProvider deviceInformationProvider) {
        walletSearchFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectWalletH5ServicesImplementation(WalletSearchFragment walletSearchFragment, WalletH5ServicesImplementation walletH5ServicesImplementation) {
        walletSearchFragment.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    public static void injectWalletV3TrackerImplementation(WalletSearchFragment walletSearchFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        walletSearchFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }

    public static void injectFeaturePresenter(WalletSearchFragment walletSearchFragment, FeatureContract.Presenter presenter) {
        walletSearchFragment.featurePresenter = presenter;
    }
}
