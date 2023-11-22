package id.dana.data.otp.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class SendOtpResult extends BaseRpcResult {
    public String action;
    public int expirySeconds;
    public int otpCodeLength;
    public int retrySendSeconds;
}
