package id.dana.wallet_v3.view.addasset.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class BottomSheetAddAsset_MembersInjector implements MembersInjector<BottomSheetAddAsset> {
    private final Provider<BottomSheetAddAssetPresenter> bottomSheetAddAssetPresenterProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<FeatureContract.Presenter> featurePresenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenterProvider;
    private final Provider<WalletH5ServicesImplementation> walletH5ServicesImplementationProvider;

    public BottomSheetAddAsset_MembersInjector(Provider<BottomSheetAddAssetPresenter> provider, Provider<ReadLinkPropertiesContract.Presenter> provider2, Provider<DeviceInformationProvider> provider3, Provider<WalletH5ServicesImplementation> provider4, Provider<FeatureContract.Presenter> provider5) {
        this.bottomSheetAddAssetPresenterProvider = provider;
        this.readLinkPropertiesPresenterProvider = provider2;
        this.deviceInformationProvider = provider3;
        this.walletH5ServicesImplementationProvider = provider4;
        this.featurePresenterProvider = provider5;
    }

    public static MembersInjector<BottomSheetAddAsset> create(Provider<BottomSheetAddAssetPresenter> provider, Provider<ReadLinkPropertiesContract.Presenter> provider2, Provider<DeviceInformationProvider> provider3, Provider<WalletH5ServicesImplementation> provider4, Provider<FeatureContract.Presenter> provider5) {
        return new BottomSheetAddAsset_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public final void injectMembers(BottomSheetAddAsset bottomSheetAddAsset) {
        injectBottomSheetAddAssetPresenter(bottomSheetAddAsset, this.bottomSheetAddAssetPresenterProvider.get());
        injectReadLinkPropertiesPresenter(bottomSheetAddAsset, this.readLinkPropertiesPresenterProvider.get());
        injectDeviceInformationProvider(bottomSheetAddAsset, this.deviceInformationProvider.get());
        injectWalletH5ServicesImplementation(bottomSheetAddAsset, this.walletH5ServicesImplementationProvider.get());
        injectFeaturePresenter(bottomSheetAddAsset, this.featurePresenterProvider.get());
    }

    public static void injectBottomSheetAddAssetPresenter(BottomSheetAddAsset bottomSheetAddAsset, BottomSheetAddAssetPresenter bottomSheetAddAssetPresenter) {
        bottomSheetAddAsset.bottomSheetAddAssetPresenter = bottomSheetAddAssetPresenter;
    }

    public static void injectReadLinkPropertiesPresenter(BottomSheetAddAsset bottomSheetAddAsset, ReadLinkPropertiesContract.Presenter presenter) {
        bottomSheetAddAsset.readLinkPropertiesPresenter = presenter;
    }

    public static void injectDeviceInformationProvider(BottomSheetAddAsset bottomSheetAddAsset, DeviceInformationProvider deviceInformationProvider) {
        bottomSheetAddAsset.deviceInformationProvider = deviceInformationProvider;
    }

    public static void injectWalletH5ServicesImplementation(BottomSheetAddAsset bottomSheetAddAsset, WalletH5ServicesImplementation walletH5ServicesImplementation) {
        bottomSheetAddAsset.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    public static void injectFeaturePresenter(BottomSheetAddAsset bottomSheetAddAsset, FeatureContract.Presenter presenter) {
        bottomSheetAddAsset.featurePresenter = presenter;
    }
}
