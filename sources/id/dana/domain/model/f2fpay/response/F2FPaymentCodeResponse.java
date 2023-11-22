package id.dana.domain.model.f2fpay.response;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class F2FPaymentCodeResponse {
    private String paymentCode;
    private String totp;

    public boolean isCodeEmpty() {
        return TextUtils.isEmpty(this.paymentCode) && TextUtils.isEmpty(this.totp);
    }

    public String getPaymentCode() {
        return this.paymentCode;
    }

    public void setPaymentCode(String str) {
        this.paymentCode = str;
    }

    public String getTotp() {
        return this.totp;
    }

    public void setTotp(String str) {
        this.totp = str;
    }
}
