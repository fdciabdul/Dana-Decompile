package id.dana.wallet_v3.view.sort.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.GetWalletSortCategory;
import id.dana.domain.wallet_v3.interactor.SaveVoucherAndTicketOrder;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BottomSheetSortAssetPresenter_Factory implements Factory<BottomSheetSortAssetPresenter> {
    private final Provider<GetVoucherAndTicketOrder> getVoucherAndTicketOrderProvider;
    private final Provider<GetWalletSortCategory> getWalletSortCategoryProvider;
    private final Provider<SaveVoucherAndTicketOrder> saveVoucherAndTicketOrderProvider;
    private final Provider<BottomSheetSortAssetContract.View> viewProvider;

    public BottomSheetSortAssetPresenter_Factory(Provider<BottomSheetSortAssetContract.View> provider, Provider<GetWalletSortCategory> provider2, Provider<SaveVoucherAndTicketOrder> provider3, Provider<GetVoucherAndTicketOrder> provider4) {
        this.viewProvider = provider;
        this.getWalletSortCategoryProvider = provider2;
        this.saveVoucherAndTicketOrderProvider = provider3;
        this.getVoucherAndTicketOrderProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final BottomSheetSortAssetPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.getWalletSortCategoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveVoucherAndTicketOrderProvider), DoubleCheck.MyBillsEntityDataFactory(this.getVoucherAndTicketOrderProvider));
    }

    public static BottomSheetSortAssetPresenter_Factory create(Provider<BottomSheetSortAssetContract.View> provider, Provider<GetWalletSortCategory> provider2, Provider<SaveVoucherAndTicketOrder> provider3, Provider<GetVoucherAndTicketOrder> provider4) {
        return new BottomSheetSortAssetPresenter_Factory(provider, provider2, provider3, provider4);
    }

    public static BottomSheetSortAssetPresenter newInstance(Lazy<BottomSheetSortAssetContract.View> lazy, Lazy<GetWalletSortCategory> lazy2, Lazy<SaveVoucherAndTicketOrder> lazy3, Lazy<GetVoucherAndTicketOrder> lazy4) {
        return new BottomSheetSortAssetPresenter(lazy, lazy2, lazy3, lazy4);
    }
}
