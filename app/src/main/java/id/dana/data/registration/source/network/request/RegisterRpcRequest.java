package id.dana.data.registration.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class RegisterRpcRequest extends BaseRpcRequest implements Serializable {
    public String avatarUrl;
    public String nickname;
    public String passcode;
    public String phoneNumber;
    public String referralCode;
    public String verifyMethod;
}
