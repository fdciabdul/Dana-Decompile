package id.dana.domain.qrpay;

import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import id.dana.domain.model.f2fpay.response.F2FPaymentCodeResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface QrPayRepository {
    Observable<Boolean> getOtpInitResult();

    Observable<F2FPaymentCodeResponse> getPaymentCode();

    Observable<F2FPayResultResponse> getPaymentResult();

    Observable<Boolean> getQrInitResult();

    Observable<Boolean> initOfflinePay();

    Boolean pause();

    Observable<Boolean> restart();

    Observable<Boolean> setSeedExtra(String str);

    Observable<Boolean> start();

    Boolean stop();
}
