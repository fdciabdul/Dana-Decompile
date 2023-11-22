package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;

/* loaded from: classes4.dex */
public class TransferSubmitRequest extends BaseRpcRequest {
    public String acceptTimeoutUnit;
    public String acceptTimeoutValue;
    public String amount;
    public List<String> couponIds;
    public String fundType;
    public String instId;
    public String payMethod;
    public TransferParticipantDTO payeeInfo;
    public String remarks;
    public String requestId;
    public boolean shareActivity;
    public String splitBillId;
    private String transferMethod;
    public String transferScenario;

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(String str) {
        this.transferMethod = str;
    }
}
