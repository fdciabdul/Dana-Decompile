package id.dana.data.profilemenu.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class PaymentSecuritySwitchRequest extends BaseRpcRequest implements Serializable {
    public boolean authenticationStatus;
    public String authenticationType;
    public String securityId;
    public String validateData;
}
