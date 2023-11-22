package id.dana.data.registration.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class CheckUserRegistrationStatusRequest extends BaseRpcRequest implements Serializable {
    public String cashierUrl;
    public String clientId;
    public String merchantRedirectUrl;
    public String otpChannel;
    public String phoneNumber;
    public Boolean skipSendOtp;
    public String subMerchantId;
}
