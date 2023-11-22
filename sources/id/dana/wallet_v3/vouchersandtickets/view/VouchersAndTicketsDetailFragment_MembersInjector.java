package id.dana.wallet_v3.vouchersandtickets.view;

import dagger.MembersInjector;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailFragment_MembersInjector implements MembersInjector<VouchersAndTicketsDetailFragment> {
    private final Provider<VouchersAndTicketsDetailContract.Presenter> vouchersAndTicketsDetailPresenterProvider;
    private final Provider<WalletV3TrackerImpl> walletV3TrackerImplementationProvider;

    public VouchersAndTicketsDetailFragment_MembersInjector(Provider<VouchersAndTicketsDetailContract.Presenter> provider, Provider<WalletV3TrackerImpl> provider2) {
        this.vouchersAndTicketsDetailPresenterProvider = provider;
        this.walletV3TrackerImplementationProvider = provider2;
    }

    public static MembersInjector<VouchersAndTicketsDetailFragment> create(Provider<VouchersAndTicketsDetailContract.Presenter> provider, Provider<WalletV3TrackerImpl> provider2) {
        return new VouchersAndTicketsDetailFragment_MembersInjector(provider, provider2);
    }

    public final void injectMembers(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment) {
        injectVouchersAndTicketsDetailPresenter(vouchersAndTicketsDetailFragment, this.vouchersAndTicketsDetailPresenterProvider.get());
        injectWalletV3TrackerImplementation(vouchersAndTicketsDetailFragment, this.walletV3TrackerImplementationProvider.get());
    }

    public static void injectVouchersAndTicketsDetailPresenter(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, VouchersAndTicketsDetailContract.Presenter presenter) {
        vouchersAndTicketsDetailFragment.vouchersAndTicketsDetailPresenter = presenter;
    }

    public static void injectWalletV3TrackerImplementation(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, WalletV3TrackerImpl walletV3TrackerImpl) {
        vouchersAndTicketsDetailFragment.walletV3TrackerImplementation = walletV3TrackerImpl;
    }
}
