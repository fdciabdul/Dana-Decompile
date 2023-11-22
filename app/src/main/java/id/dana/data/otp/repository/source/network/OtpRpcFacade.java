package id.dana.data.otp.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.otp.repository.source.network.request.SendOtpRequest;
import id.dana.data.otp.repository.source.network.request.VerifyOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.network.response.login.VerifyOtpResult;

/* loaded from: classes4.dex */
public interface OtpRpcFacade {
    public static final String SEND_OTP_OPERATION_TYPE = "alipayplus.mobilewallet.user.security.sendOtp";

    @OperationType("alipayplus.mobilewallet.user.security.sendOtp")
    @SignCheck
    SendOtpResult sendOtp(SendOtpRequest sendOtpRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP)
    @SignCheck
    VerifyOtpResult verifyOtp(VerifyOtpRequest verifyOtpRequest);
}
