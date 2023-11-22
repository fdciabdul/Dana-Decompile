package id.dana.wallet_v3.investment.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InvestmentWalletDetailFragment_MembersInjector implements MembersInjector<InvestmentWalletDetailFragment> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<FeatureContract.Presenter> featurePresenterProvider;
    private final Provider<GetBalanceContract.Presenter> getBalancePresenterProvider;
    private final Provider<InvestmentWalletDetailContract.Presenter> investmentPresenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenterProvider;
    private final Provider<ServicesContract.Presenter> servicesPresenterProvider;
    private final Provider<WalletH5ServicesImplementation> walletH5ServicesImplementationProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public InvestmentWalletDetailFragment_MembersInjector(Provider<InvestmentWalletDetailContract.Presenter> provider, Provider<ServicesContract.Presenter> provider2, Provider<GetBalanceContract.Presenter> provider3, Provider<ReadLinkPropertiesContract.Presenter> provider4, Provider<DeviceInformationProvider> provider5, Provider<WalletH5ServicesImplementation> provider6, Provider<WalletV3TrackerImpl> provider7, Provider<FeatureContract.Presenter> provider8) {
        this.investmentPresenterProvider = provider;
        this.servicesPresenterProvider = provider2;
        this.getBalancePresenterProvider = provider3;
        this.readLinkPropertiesPresenterProvider = provider4;
        this.deviceInformationProvider = provider5;
        this.walletH5ServicesImplementationProvider = provider6;
        this.walletV3TrackerImplementationProvider = provider7;
        this.featurePresenterProvider = provider8;
    }

    public static MembersInjector<InvestmentWalletDetailFragment> create(Provider<InvestmentWalletDetailContract.Presenter> provider, Provider<ServicesContract.Presenter> provider2, Provider<GetBalanceContract.Presenter> provider3, Provider<ReadLinkPropertiesContract.Presenter> provider4, Provider<DeviceInformationProvider> provider5, Provider<WalletH5ServicesImplementation> provider6, Provider<WalletV3TrackerImpl> provider7, Provider<FeatureContract.Presenter> provider8) {
        return new InvestmentWalletDetailFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public final void injectMembers(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        injectInvestmentPresenter(investmentWalletDetailFragment, this.investmentPresenterProvider.get());
        injectServicesPresenter(investmentWalletDetailFragment, this.servicesPresenterProvider.get());
        injectGetBalancePresenter(investmentWalletDetailFragment, this.getBalancePresenterProvider.get());
        injectReadLinkPropertiesPresenter(investmentWalletDetailFragment, this.readLinkPropertiesPresenterProvider.get());
        injectDeviceInformationProvider(investmentWalletDetailFragment, this.deviceInformationProvider.get());
        injectWalletH5ServicesImplementation(investmentWalletDetailFragment, this.walletH5ServicesImplementationProvider.get());
        injectWalletV3TrackerImplementation(investmentWalletDetailFragment, this.walletV3TrackerImplementationProvider.get());
        injectFeaturePresenter(investmentWalletDetailFragment, this.featurePresenterProvider.get());
    }

    public static void injectInvestmentPresenter(InvestmentWalletDetailFragment investmentWalletDetailFragment, InvestmentWalletDetailContract.Presenter presenter) {
        investmentWalletDetailFragment.investmentPresenter = presenter;
    }

    public static void injectServicesPresenter(InvestmentWalletDetailFragment investmentWalletDetailFragment, ServicesContract.Presenter presenter) {
        investmentWalletDetailFragment.servicesPresenter = presenter;
    }

    public static void injectGetBalancePresenter(InvestmentWalletDetailFragment investmentWalletDetailFragment, GetBalanceContract.Presenter presenter) {
        investmentWalletDetailFragment.getBalancePresenter = presenter;
    }

    public static void injectReadLinkPropertiesPresenter(InvestmentWalletDetailFragment investmentWalletDetailFragment, ReadLinkPropertiesContract.Presenter presenter) {
        investmentWalletDetailFragment.readLinkPropertiesPresenter = presenter;
    }

    public static void injectDeviceInformationProvider(InvestmentWalletDetailFragment investmentWalletDetailFragment, DeviceInformationProvider deviceInformationProvider) {
        investmentWalletDetailFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectWalletH5ServicesImplementation(InvestmentWalletDetailFragment investmentWalletDetailFragment, WalletH5ServicesImplementation walletH5ServicesImplementation) {
        investmentWalletDetailFragment.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    public static void injectWalletV3TrackerImplementation(InvestmentWalletDetailFragment investmentWalletDetailFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        investmentWalletDetailFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }

    public static void injectFeaturePresenter(InvestmentWalletDetailFragment investmentWalletDetailFragment, FeatureContract.Presenter presenter) {
        investmentWalletDetailFragment.featurePresenter = presenter;
    }
}
