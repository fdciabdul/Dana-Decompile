package id.dana.data.sendmoney.repository.source.network.result;

/* loaded from: classes8.dex */
public class WithdrawChannelViewResult {
    private String channelIndex;
    private boolean disable;
    private String instId;
    private String instLocalName;
    private String instName;
    private String payMethod;
    private String payOption;

    public String getChannelIndex() {
        return this.channelIndex;
    }

    public void setChannelIndex(String str) {
        this.channelIndex = str;
    }

    public boolean isDisable() {
        return this.disable;
    }

    public void setDisable(boolean z) {
        this.disable = z;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstName(String str) {
        this.instName = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public void setPayOption(String str) {
        this.payOption = str;
    }
}
