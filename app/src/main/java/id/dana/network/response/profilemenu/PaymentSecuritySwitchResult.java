package id.dana.network.response.profilemenu;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes5.dex */
public class PaymentSecuritySwitchResult extends BaseRpcResult {
    public int identFailedCount;
    public int maxFailedLimit;
    public RiskResult riskResult;
    public SecurityContextResult securityContext;
}
