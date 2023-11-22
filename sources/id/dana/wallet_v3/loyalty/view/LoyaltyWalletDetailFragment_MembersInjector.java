package id.dana.wallet_v3.loyalty.view;

import dagger.MembersInjector;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LoyaltyWalletDetailFragment_MembersInjector implements MembersInjector<LoyaltyWalletDetailFragment> {
    private final Provider<LoyaltyWalletContract.Presenter> loyaltyPresenterProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public LoyaltyWalletDetailFragment_MembersInjector(Provider<LoyaltyWalletContract.Presenter> provider, Provider<WalletV3TrackerImpl> provider2) {
        this.loyaltyPresenterProvider = provider;
        this.walletV3TrackerImplementationProvider = provider2;
    }

    public static MembersInjector<LoyaltyWalletDetailFragment> create(Provider<LoyaltyWalletContract.Presenter> provider, Provider<WalletV3TrackerImpl> provider2) {
        return new LoyaltyWalletDetailFragment_MembersInjector(provider, provider2);
    }

    public final void injectMembers(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment) {
        injectLoyaltyPresenter(loyaltyWalletDetailFragment, this.loyaltyPresenterProvider.get());
        injectWalletV3TrackerImplementation(loyaltyWalletDetailFragment, this.walletV3TrackerImplementationProvider.get());
    }

    public static void injectLoyaltyPresenter(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment, LoyaltyWalletContract.Presenter presenter) {
        loyaltyWalletDetailFragment.loyaltyPresenter = presenter;
    }

    public static void injectWalletV3TrackerImplementation(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        loyaltyWalletDetailFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }
}
