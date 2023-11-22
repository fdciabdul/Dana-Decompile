package id.dana.data.risk.riskevent.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes4.dex */
public class SendRiskEventRpcRequest extends BaseRpcRequest implements Serializable {
    public String action;
    public String bizOrderId;
    public String bizType;
    public Map<String, String> extendInfo;
}
