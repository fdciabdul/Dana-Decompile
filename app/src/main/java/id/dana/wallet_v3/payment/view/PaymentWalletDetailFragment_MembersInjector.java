package id.dana.wallet_v3.payment.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class PaymentWalletDetailFragment_MembersInjector implements MembersInjector<PaymentWalletDetailFragment> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<DynamicUrlWrapper> dynamicUrlWrapperProvider;
    private final Provider<FeatureContract.Presenter> featurePresenterProvider;
    private final Provider<PaymentWalletDetailContract.Presenter> paymentWalletDetailPresenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenterProvider;
    private final Provider<ServicesContract.Presenter> servicesPresenterProvider;
    private final Provider<WalletH5ServicesImplementation> walletH5ServicesImplementationProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public PaymentWalletDetailFragment_MembersInjector(Provider<ServicesContract.Presenter> provider, Provider<DynamicUrlWrapper> provider2, Provider<ReadLinkPropertiesContract.Presenter> provider3, Provider<DeviceInformationProvider> provider4, Provider<PaymentWalletDetailContract.Presenter> provider5, Provider<WalletH5ServicesImplementation> provider6, Provider<WalletV3TrackerImpl> provider7, Provider<FeatureContract.Presenter> provider8) {
        this.servicesPresenterProvider = provider;
        this.dynamicUrlWrapperProvider = provider2;
        this.readLinkPropertiesPresenterProvider = provider3;
        this.deviceInformationProvider = provider4;
        this.paymentWalletDetailPresenterProvider = provider5;
        this.walletH5ServicesImplementationProvider = provider6;
        this.walletV3TrackerImplementationProvider = provider7;
        this.featurePresenterProvider = provider8;
    }

    public static MembersInjector<PaymentWalletDetailFragment> create(Provider<ServicesContract.Presenter> provider, Provider<DynamicUrlWrapper> provider2, Provider<ReadLinkPropertiesContract.Presenter> provider3, Provider<DeviceInformationProvider> provider4, Provider<PaymentWalletDetailContract.Presenter> provider5, Provider<WalletH5ServicesImplementation> provider6, Provider<WalletV3TrackerImpl> provider7, Provider<FeatureContract.Presenter> provider8) {
        return new PaymentWalletDetailFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public final void injectMembers(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        injectServicesPresenter(paymentWalletDetailFragment, this.servicesPresenterProvider.get());
        injectDynamicUrlWrapper(paymentWalletDetailFragment, this.dynamicUrlWrapperProvider.get());
        injectReadLinkPropertiesPresenter(paymentWalletDetailFragment, this.readLinkPropertiesPresenterProvider.get());
        injectDeviceInformationProvider(paymentWalletDetailFragment, this.deviceInformationProvider.get());
        injectPaymentWalletDetailPresenter(paymentWalletDetailFragment, this.paymentWalletDetailPresenterProvider.get());
        injectWalletH5ServicesImplementation(paymentWalletDetailFragment, this.walletH5ServicesImplementationProvider.get());
        injectWalletV3TrackerImplementation(paymentWalletDetailFragment, this.walletV3TrackerImplementationProvider.get());
        injectFeaturePresenter(paymentWalletDetailFragment, this.featurePresenterProvider.get());
    }

    public static void injectServicesPresenter(PaymentWalletDetailFragment paymentWalletDetailFragment, ServicesContract.Presenter presenter) {
        paymentWalletDetailFragment.servicesPresenter = presenter;
    }

    public static void injectDynamicUrlWrapper(PaymentWalletDetailFragment paymentWalletDetailFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        paymentWalletDetailFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void injectReadLinkPropertiesPresenter(PaymentWalletDetailFragment paymentWalletDetailFragment, ReadLinkPropertiesContract.Presenter presenter) {
        paymentWalletDetailFragment.readLinkPropertiesPresenter = presenter;
    }

    public static void injectDeviceInformationProvider(PaymentWalletDetailFragment paymentWalletDetailFragment, DeviceInformationProvider deviceInformationProvider) {
        paymentWalletDetailFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectPaymentWalletDetailPresenter(PaymentWalletDetailFragment paymentWalletDetailFragment, PaymentWalletDetailContract.Presenter presenter) {
        paymentWalletDetailFragment.paymentWalletDetailPresenter = presenter;
    }

    public static void injectWalletH5ServicesImplementation(PaymentWalletDetailFragment paymentWalletDetailFragment, WalletH5ServicesImplementation walletH5ServicesImplementation) {
        paymentWalletDetailFragment.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    public static void injectWalletV3TrackerImplementation(PaymentWalletDetailFragment paymentWalletDetailFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        paymentWalletDetailFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }

    public static void injectFeaturePresenter(PaymentWalletDetailFragment paymentWalletDetailFragment, FeatureContract.Presenter presenter) {
        paymentWalletDetailFragment.featurePresenter = presenter;
    }
}
