package id.dana.wallet_v3.identity.view;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IdentityWalletDetailFragment_MembersInjector implements MembersInjector<IdentityWalletDetailFragment> {
    private final Provider<DynamicUrlWrapper> dynamicUrlWrapperProvider;
    private final Provider<PersonalContract.Presenter> personalPresenterProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public IdentityWalletDetailFragment_MembersInjector(Provider<PersonalContract.Presenter> provider, Provider<DynamicUrlWrapper> provider2, Provider<WalletV3TrackerImpl> provider3) {
        this.personalPresenterProvider = provider;
        this.dynamicUrlWrapperProvider = provider2;
        this.walletV3TrackerImplementationProvider = provider3;
    }

    public static MembersInjector<IdentityWalletDetailFragment> create(Provider<PersonalContract.Presenter> provider, Provider<DynamicUrlWrapper> provider2, Provider<WalletV3TrackerImpl> provider3) {
        return new IdentityWalletDetailFragment_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(IdentityWalletDetailFragment identityWalletDetailFragment) {
        injectPersonalPresenter(identityWalletDetailFragment, this.personalPresenterProvider.get());
        injectDynamicUrlWrapper(identityWalletDetailFragment, this.dynamicUrlWrapperProvider.get());
        injectWalletV3TrackerImplementation(identityWalletDetailFragment, this.walletV3TrackerImplementationProvider.get());
    }

    public static void injectPersonalPresenter(IdentityWalletDetailFragment identityWalletDetailFragment, PersonalContract.Presenter presenter) {
        identityWalletDetailFragment.personalPresenter = presenter;
    }

    public static void injectDynamicUrlWrapper(IdentityWalletDetailFragment identityWalletDetailFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        identityWalletDetailFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void injectWalletV3TrackerImplementation(IdentityWalletDetailFragment identityWalletDetailFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        identityWalletDetailFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }
}
