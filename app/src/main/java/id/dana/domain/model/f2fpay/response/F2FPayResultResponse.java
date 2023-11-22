package id.dana.domain.model.f2fpay.response;

import id.dana.domain.model.f2fpay.F2FPayOrderInfo;
import id.dana.domain.model.f2fpay.F2FPaymentResultStatus;

/* loaded from: classes4.dex */
public class F2FPayResultResponse {
    private F2FPayOrderInfo orderInfo;
    private F2FPaymentResultStatus status;

    public F2FPaymentResultStatus getStatus() {
        return this.status;
    }

    public void setStatus(F2FPaymentResultStatus f2FPaymentResultStatus) {
        this.status = f2FPaymentResultStatus;
    }

    public F2FPayOrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public void setOrderInfo(F2FPayOrderInfo f2FPayOrderInfo) {
        this.orderInfo = f2FPayOrderInfo;
    }
}
