package id.dana.wallet_v3.vouchersandtickets.presenter;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListPresenter_Factory implements Factory<VoucherAndTicketExpiredListPresenter> {
    private final Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
    private final Provider<VoucherAndTicketExpiredListContract.View> viewProvider;

    public VoucherAndTicketExpiredListPresenter_Factory(Provider<VoucherAndTicketExpiredListContract.View> provider, Provider<GetUserPocketWalletAsset> provider2) {
        this.viewProvider = provider;
        this.getUserPocketWalletAssetProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final VoucherAndTicketExpiredListPresenter get() {
        return newInstance(this.viewProvider.get(), this.getUserPocketWalletAssetProvider.get());
    }

    public static VoucherAndTicketExpiredListPresenter_Factory create(Provider<VoucherAndTicketExpiredListContract.View> provider, Provider<GetUserPocketWalletAsset> provider2) {
        return new VoucherAndTicketExpiredListPresenter_Factory(provider, provider2);
    }

    public static VoucherAndTicketExpiredListPresenter newInstance(VoucherAndTicketExpiredListContract.View view, GetUserPocketWalletAsset getUserPocketWalletAsset) {
        return new VoucherAndTicketExpiredListPresenter(view, getUserPocketWalletAsset);
    }
}
