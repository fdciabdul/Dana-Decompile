package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;

/* loaded from: classes4.dex */
public class TransferInitRequest extends BaseRpcRequest {
    private String amount;
    private boolean needPayMethod;
    private boolean needTransferMethod;
    private boolean needWithdrawMethod;
    private TransferParticipantDTO payeeInfo;
    private String transferMethod;
    private String version;

    public boolean isNeedTransferMethod() {
        return this.needTransferMethod;
    }

    public void setNeedTransferMethod(boolean z) {
        this.needTransferMethod = z;
    }

    public boolean isNeedWithdrawMethod() {
        return this.needWithdrawMethod;
    }

    public void setNeedWithdrawMethod(boolean z) {
        this.needWithdrawMethod = z;
    }

    public boolean isNeedPayMethod() {
        return this.needPayMethod;
    }

    public void setNeedPayMethod(boolean z) {
        this.needPayMethod = z;
    }

    public TransferParticipantDTO getPayeeInfo() {
        return this.payeeInfo;
    }

    public void setPayeeInfo(TransferParticipantDTO transferParticipantDTO) {
        this.payeeInfo = transferParticipantDTO;
    }

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(String str) {
        this.transferMethod = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
