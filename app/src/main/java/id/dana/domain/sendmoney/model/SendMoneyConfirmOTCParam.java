package id.dana.domain.sendmoney.model;

/* loaded from: classes4.dex */
public class SendMoneyConfirmOTCParam extends SendMoneyConfirmParam {
    private String instId;
    private String payOption;
    private String withdrawInstId;
    private String withdrawInstLocalName;
    private String withdrawInstName;
    private String withdrawPayMethod;
    private String withdrawPayOption;

    public String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    public void setWithdrawInstId(String str) {
        this.withdrawInstId = str;
    }

    public String getWithdrawInstName() {
        return this.withdrawInstName;
    }

    public void setWithdrawInstName(String str) {
        this.withdrawInstName = str;
    }

    public String getWithdrawInstLocalName() {
        return this.withdrawInstLocalName;
    }

    public void setWithdrawInstLocalName(String str) {
        this.withdrawInstLocalName = str;
    }

    public String getWithdrawPayMethod() {
        return this.withdrawPayMethod;
    }

    public void setWithdrawPayMethod(String str) {
        this.withdrawPayMethod = str;
    }

    public String getWithdrawPayOption() {
        return this.withdrawPayOption;
    }

    public void setWithdrawPayOption(String str) {
        this.withdrawPayOption = str;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public void setPayOption(String str) {
        this.payOption = str;
    }
}
