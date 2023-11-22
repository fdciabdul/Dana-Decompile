package id.dana.wallet_v3.payment.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class PaymentWalletDetailPresenter_Factory implements Factory<PaymentWalletDetailPresenter> {
    private final Provider<GetBottomSheetServices> getBottomSheetServicesProvider;
    private final Provider<GetUserPaymentWalletAsset> getUserPaymentWalletAssetProvider;
    private final Provider<ThirdPartyServicesMapper> mapperProvider;
    private final Provider<PaymentWalletDetailContract.View> viewProvider;

    public PaymentWalletDetailPresenter_Factory(Provider<PaymentWalletDetailContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2, Provider<GetBottomSheetServices> provider3, Provider<ThirdPartyServicesMapper> provider4) {
        this.viewProvider = provider;
        this.getUserPaymentWalletAssetProvider = provider2;
        this.getBottomSheetServicesProvider = provider3;
        this.mapperProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final PaymentWalletDetailPresenter get() {
        return newInstance(this.viewProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.getUserPaymentWalletAssetProvider), DoubleCheck.MyBillsEntityDataFactory(this.getBottomSheetServicesProvider), this.mapperProvider.get());
    }

    public static PaymentWalletDetailPresenter_Factory create(Provider<PaymentWalletDetailContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2, Provider<GetBottomSheetServices> provider3, Provider<ThirdPartyServicesMapper> provider4) {
        return new PaymentWalletDetailPresenter_Factory(provider, provider2, provider3, provider4);
    }

    public static PaymentWalletDetailPresenter newInstance(PaymentWalletDetailContract.View view, Lazy<GetUserPaymentWalletAsset> lazy, Lazy<GetBottomSheetServices> lazy2, ThirdPartyServicesMapper thirdPartyServicesMapper) {
        return new PaymentWalletDetailPresenter(view, lazy, lazy2, thirdPartyServicesMapper);
    }
}
