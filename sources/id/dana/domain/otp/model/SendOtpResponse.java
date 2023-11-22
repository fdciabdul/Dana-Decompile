package id.dana.domain.otp.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class SendOtpResponse extends BaseRpcResponse {
    private int expirySeconds;
    private int otpCodeLength;
    private int retrySendSeconds;

    public int getExpirySeconds() {
        return this.expirySeconds;
    }

    public void setExpirySeconds(int i) {
        this.expirySeconds = i;
    }

    public int getRetrySendSeconds() {
        return this.retrySendSeconds;
    }

    public void setRetrySendSeconds(int i) {
        this.retrySendSeconds = i;
    }

    public int getOtpCodeLength() {
        return this.otpCodeLength;
    }

    public void setOtpCodeLength(int i) {
        this.otpCodeLength = i;
    }
}
