package id.dana.data.risk.riskevent;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.risk.riskevent.request.SendRiskEventRpcRequest;
import id.dana.data.risk.riskevent.result.SendRiskEventRpcResult;

/* loaded from: classes4.dex */
public interface SendRiskEventRpcFacade {
    @OperationType("alipayplus.mobilewallet.risk.sendriskevent")
    @SignCheck
    SendRiskEventRpcResult sendRiskEvent(SendRiskEventRpcRequest sendRiskEventRpcRequest);
}
