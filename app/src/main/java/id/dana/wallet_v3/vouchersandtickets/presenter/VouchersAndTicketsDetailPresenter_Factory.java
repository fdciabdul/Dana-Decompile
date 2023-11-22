package id.dana.wallet_v3.vouchersandtickets.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.SetPocketUpdate;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailPresenter_Factory implements Factory<VouchersAndTicketsDetailPresenter> {
    private final Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
    private final Provider<SetPocketUpdate> setPocketUpdateProvider;
    private final Provider<VouchersAndTicketsDetailContract.View> viewProvider;

    public VouchersAndTicketsDetailPresenter_Factory(Provider<VouchersAndTicketsDetailContract.View> provider, Provider<GetUserPocketWalletAsset> provider2, Provider<SetPocketUpdate> provider3) {
        this.viewProvider = provider;
        this.getUserPocketWalletAssetProvider = provider2;
        this.setPocketUpdateProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final VouchersAndTicketsDetailPresenter get() {
        return newInstance(this.viewProvider.get(), this.getUserPocketWalletAssetProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.setPocketUpdateProvider));
    }

    public static VouchersAndTicketsDetailPresenter_Factory create(Provider<VouchersAndTicketsDetailContract.View> provider, Provider<GetUserPocketWalletAsset> provider2, Provider<SetPocketUpdate> provider3) {
        return new VouchersAndTicketsDetailPresenter_Factory(provider, provider2, provider3);
    }

    public static VouchersAndTicketsDetailPresenter newInstance(VouchersAndTicketsDetailContract.View view, GetUserPocketWalletAsset getUserPocketWalletAsset, Lazy<SetPocketUpdate> lazy) {
        return new VouchersAndTicketsDetailPresenter(view, getUserPocketWalletAsset, lazy);
    }
}
