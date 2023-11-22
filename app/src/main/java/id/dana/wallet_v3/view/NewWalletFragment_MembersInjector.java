package id.dana.wallet_v3.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.presenter.NewWalletContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class NewWalletFragment_MembersInjector implements MembersInjector<NewWalletFragment> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<DynamicUrlWrapper> dynamicUrlWrapperProvider;
    private final Provider<FeatureContract.Presenter> featurePresenterProvider;
    private final Provider<GetBalanceContract.Presenter> getBalancePresenterProvider;
    private final Provider<NewWalletContract.Presenter> newWalletPresenterProvider;
    private final Provider<PersonalContract.Presenter> personalPresenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenterProvider;
    private final Provider<ServicesContract.Presenter> servicePresenterProvider;
    private final Provider<WalletH5ServicesImplementation> walletH5ServicesImplementationProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public NewWalletFragment_MembersInjector(Provider<NewWalletContract.Presenter> provider, Provider<GetBalanceContract.Presenter> provider2, Provider<PersonalContract.Presenter> provider3, Provider<DynamicUrlWrapper> provider4, Provider<ServicesContract.Presenter> provider5, Provider<ReadLinkPropertiesContract.Presenter> provider6, Provider<DeviceInformationProvider> provider7, Provider<WalletH5ServicesImplementation> provider8, Provider<WalletV3TrackerImpl> provider9, Provider<FeatureContract.Presenter> provider10) {
        this.newWalletPresenterProvider = provider;
        this.getBalancePresenterProvider = provider2;
        this.personalPresenterProvider = provider3;
        this.dynamicUrlWrapperProvider = provider4;
        this.servicePresenterProvider = provider5;
        this.readLinkPropertiesPresenterProvider = provider6;
        this.deviceInformationProvider = provider7;
        this.walletH5ServicesImplementationProvider = provider8;
        this.walletV3TrackerImplementationProvider = provider9;
        this.featurePresenterProvider = provider10;
    }

    public static MembersInjector<NewWalletFragment> create(Provider<NewWalletContract.Presenter> provider, Provider<GetBalanceContract.Presenter> provider2, Provider<PersonalContract.Presenter> provider3, Provider<DynamicUrlWrapper> provider4, Provider<ServicesContract.Presenter> provider5, Provider<ReadLinkPropertiesContract.Presenter> provider6, Provider<DeviceInformationProvider> provider7, Provider<WalletH5ServicesImplementation> provider8, Provider<WalletV3TrackerImpl> provider9, Provider<FeatureContract.Presenter> provider10) {
        return new NewWalletFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public final void injectMembers(NewWalletFragment newWalletFragment) {
        injectNewWalletPresenter(newWalletFragment, this.newWalletPresenterProvider.get());
        injectGetBalancePresenter(newWalletFragment, this.getBalancePresenterProvider.get());
        injectPersonalPresenter(newWalletFragment, this.personalPresenterProvider.get());
        injectDynamicUrlWrapper(newWalletFragment, this.dynamicUrlWrapperProvider.get());
        injectServicePresenter(newWalletFragment, this.servicePresenterProvider.get());
        injectReadLinkPropertiesPresenter(newWalletFragment, this.readLinkPropertiesPresenterProvider.get());
        injectDeviceInformationProvider(newWalletFragment, this.deviceInformationProvider.get());
        injectWalletH5ServicesImplementation(newWalletFragment, this.walletH5ServicesImplementationProvider.get());
        injectWalletV3TrackerImplementation(newWalletFragment, this.walletV3TrackerImplementationProvider.get());
        injectFeaturePresenter(newWalletFragment, this.featurePresenterProvider.get());
    }

    public static void injectNewWalletPresenter(NewWalletFragment newWalletFragment, NewWalletContract.Presenter presenter) {
        newWalletFragment.newWalletPresenter = presenter;
    }

    public static void injectGetBalancePresenter(NewWalletFragment newWalletFragment, GetBalanceContract.Presenter presenter) {
        newWalletFragment.getBalancePresenter = presenter;
    }

    public static void injectPersonalPresenter(NewWalletFragment newWalletFragment, PersonalContract.Presenter presenter) {
        newWalletFragment.personalPresenter = presenter;
    }

    public static void injectDynamicUrlWrapper(NewWalletFragment newWalletFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        newWalletFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void injectServicePresenter(NewWalletFragment newWalletFragment, ServicesContract.Presenter presenter) {
        newWalletFragment.servicePresenter = presenter;
    }

    public static void injectReadLinkPropertiesPresenter(NewWalletFragment newWalletFragment, ReadLinkPropertiesContract.Presenter presenter) {
        newWalletFragment.readLinkPropertiesPresenter = presenter;
    }

    public static void injectDeviceInformationProvider(NewWalletFragment newWalletFragment, DeviceInformationProvider deviceInformationProvider) {
        newWalletFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectWalletH5ServicesImplementation(NewWalletFragment newWalletFragment, WalletH5ServicesImplementation walletH5ServicesImplementation) {
        newWalletFragment.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    public static void injectWalletV3TrackerImplementation(NewWalletFragment newWalletFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        newWalletFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }

    public static void injectFeaturePresenter(NewWalletFragment newWalletFragment, FeatureContract.Presenter presenter) {
        newWalletFragment.featurePresenter = presenter;
    }
}
