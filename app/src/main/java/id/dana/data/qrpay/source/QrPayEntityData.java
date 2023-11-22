package id.dana.data.qrpay.source;

import com.alipay.iap.android.f2fpay.client.pay.F2FPayResult;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface QrPayEntityData {
    Observable<OtpInitResult> getOtpInitResult();

    Observable<F2FPaymentCodeInfo> getPaymentCode();

    Observable<F2FPayResult> getPaymentResult();

    Observable<Boolean> getQrInitResult();

    void init(String str, int i);

    Boolean pause();

    Observable<Boolean> reStart(String str, int i);

    Observable<Boolean> setSeedExtra(String str, String str2, int i);

    Observable<Boolean> start(String str, int i);

    Boolean stop();
}
