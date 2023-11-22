package id.dana.data.otp.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class VerifyOtpRequest extends BaseRpcRequest implements Serializable {
    public String otpValue;
    public String phoneNumber;
}
