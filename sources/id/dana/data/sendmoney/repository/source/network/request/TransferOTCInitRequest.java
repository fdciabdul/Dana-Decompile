package id.dana.data.sendmoney.repository.source.network.request;

/* loaded from: classes4.dex */
public class TransferOTCInitRequest extends TransferInitRequest {
    private String amount;
    private String fundType;

    @Override // id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest
    public String getAmount() {
        return this.amount;
    }

    @Override // id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest
    public void setAmount(String str) {
        this.amount = str;
    }

    public String getFundType() {
        return this.fundType;
    }

    public void setFundType(String str) {
        this.fundType = str;
    }
}
