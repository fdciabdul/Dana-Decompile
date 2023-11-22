package id.dana.contract.payqr;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.qrpay.interactor.GetPaymentCode;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData;
import id.dana.domain.qrpay.interactor.PauseOfflinePay;
import id.dana.domain.qrpay.interactor.RestartOfflinePay;
import id.dana.domain.qrpay.interactor.StartOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay;

/* loaded from: classes4.dex */
public final class PayQrPresenter_MembersInjector implements MembersInjector<PayQrPresenter> {
    public static void PlaceComponentResult(PayQrPresenter payQrPresenter, Lazy<GetPaymentCode> lazy, Lazy<GetQrisPaymentData> lazy2) {
        payQrPresenter.MyBillsEntityDataFactory(lazy, lazy2);
    }

    public static void PlaceComponentResult(PayQrPresenter payQrPresenter, Lazy<StartOfflinePay> lazy, Lazy<StopOfflinePay> lazy2, Lazy<PauseOfflinePay> lazy3, Lazy<RestartOfflinePay> lazy4, Lazy<IsOfflineF2FPay> lazy5) {
        payQrPresenter.PlaceComponentResult(lazy, lazy2, lazy3, lazy4, lazy5);
    }
}
