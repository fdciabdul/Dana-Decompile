package id.dana.data.otp.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class SendOtpRequest extends BaseRpcRequest implements Serializable {
    public String otpChannel;
    public String otpScene;
    @SerializedName("phoneNumber")
    public String phoneNumber;
    public String securityId;
    public String sendStrategy;
    public String serviceCode;
}
