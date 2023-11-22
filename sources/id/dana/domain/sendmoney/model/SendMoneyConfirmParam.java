package id.dana.domain.sendmoney.model;

/* loaded from: classes4.dex */
public class SendMoneyConfirmParam {
    private String acceptTimeoutUnit;
    private String acceptTimeoutValue;
    private String amount;
    private String cardIndexNo;
    private String couponId;
    private String fundType;
    private String originInstId;
    private String payMethod;
    private TransferParticipant payeeInfo;
    private String remarks;
    private boolean shareActivity;
    private String splitBillId;
    private String transferMethod;
    private String transferScenario;

    public String getAcceptTimeoutUnit() {
        return this.acceptTimeoutUnit;
    }

    public void setAcceptTimeoutUnit(String str) {
        this.acceptTimeoutUnit = str;
    }

    public String getAcceptTimeoutValue() {
        return this.acceptTimeoutValue;
    }

    public void setAcceptTimeoutValue(String str) {
        this.acceptTimeoutValue = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public String getFundType() {
        return this.fundType;
    }

    public void setFundType(String str) {
        this.fundType = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public String getOriginInstId() {
        return this.originInstId;
    }

    public void setOriginInstId(String str) {
        this.originInstId = str;
    }

    public String getTransferScenario() {
        return this.transferScenario;
    }

    public void setTransferScenario(String str) {
        this.transferScenario = str;
    }

    public TransferParticipant getPayeeInfo() {
        return this.payeeInfo;
    }

    public void setPayeeInfo(TransferParticipant transferParticipant) {
        this.payeeInfo = transferParticipant;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public String getSplitBillId() {
        return this.splitBillId;
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public boolean isShareActivity() {
        return this.shareActivity;
    }

    public void setShareActivity(boolean z) {
        this.shareActivity = z;
    }

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(String str) {
        this.transferMethod = str;
    }
}
