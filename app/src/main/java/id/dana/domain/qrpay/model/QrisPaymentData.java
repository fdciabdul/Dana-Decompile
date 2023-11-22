package id.dana.domain.qrpay.model;

import id.dana.domain.model.f2fpay.response.F2FPaymentCodeResponse;
import id.dana.domain.user.UserInfoResponse;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class QrisPaymentData {
    private F2FPaymentCodeResponse f2FPaymentCodeResponse;
    private int fundSource;
    private UserInfoResponse userInfoResponse;

    @Inject
    public QrisPaymentData() {
    }

    public void setPaymentCodeResponse(F2FPaymentCodeResponse f2FPaymentCodeResponse) {
        this.f2FPaymentCodeResponse = f2FPaymentCodeResponse;
    }

    public void setUserInfoResponse(UserInfoResponse userInfoResponse) {
        this.userInfoResponse = userInfoResponse;
    }

    public String getPaymentCode() {
        F2FPaymentCodeResponse f2FPaymentCodeResponse = this.f2FPaymentCodeResponse;
        return f2FPaymentCodeResponse == null ? "" : f2FPaymentCodeResponse.getPaymentCode();
    }

    public boolean isCodeEmpty() {
        F2FPaymentCodeResponse f2FPaymentCodeResponse = this.f2FPaymentCodeResponse;
        return f2FPaymentCodeResponse == null || f2FPaymentCodeResponse.isCodeEmpty();
    }

    public String getCardholderName() {
        UserInfoResponse userInfoResponse = this.userInfoResponse;
        return userInfoResponse == null ? "" : userInfoResponse.getNickname();
    }

    public String getUserPan() {
        UserInfoResponse userInfoResponse = this.userInfoResponse;
        return userInfoResponse == null ? "" : userInfoResponse.getUserPan();
    }

    public int getFundSource() {
        return this.fundSource;
    }

    public void setFundSource(int i) {
        this.fundSource = i;
    }
}
