package id.dana.data.registration.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.registration.source.network.request.CheckUserRegistrationStatusRequest;
import id.dana.data.registration.source.network.request.RegisterRpcRequest;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import id.dana.data.registration.source.network.result.RegisterRpcResult;

/* loaded from: classes4.dex */
public interface RegistrationRpcFacade {
    public static final String CHECK_REGISTER_AND_SEND_OTP_OPERATION_TYPE = "alipayplus.mobilewallet.user.checkRegisteredUserAndSendOTP";

    @OperationType("alipayplus.mobilewallet.user.checkRegisteredUserAndSendOTP")
    @SignCheck
    CheckUserRegistrationStatusResult checkRegisteredUserAndSendOtp(CheckUserRegistrationStatusRequest checkUserRegistrationStatusRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.REGISTER)
    @SignCheck
    RegisterRpcResult register(RegisterRpcRequest registerRpcRequest);
}
