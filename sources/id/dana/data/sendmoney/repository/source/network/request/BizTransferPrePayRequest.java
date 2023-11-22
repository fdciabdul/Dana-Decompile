package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;

/* loaded from: classes4.dex */
public class BizTransferPrePayRequest extends BaseRpcRequest {
    private String amount;
    private String transferMethod;

    public BizTransferPrePayRequest(String str, String str2) {
        this.amount = str;
        this.transferMethod = str2;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(String str) {
        this.transferMethod = str;
    }
}
