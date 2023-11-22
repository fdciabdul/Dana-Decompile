package id.dana.data.sendmoney.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.model.cashier.AttributesResult;
import id.dana.data.model.cashier.PayMethodRiskResult;

/* loaded from: classes4.dex */
public class SendMoneyResult extends BaseRpcResult {
    public AttributesResult attributes;
    public String cashierOrderId;
    public String fundAmount;
    public String fundOrderId;
    public PayMethodRiskResult payMethodRiskResult;
    public String pubKey;
    public String riskPhoneNumber;
}
