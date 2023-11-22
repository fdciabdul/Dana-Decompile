package id.dana.data.sendmoney.model;

import java.util.List;

/* loaded from: classes4.dex */
public class WithdrawChannelOptionViewResult {
    private boolean enableStatus;
    private String instId;
    private String instLocalName;
    private String instName;
    private String payMethod;
    private List<PayMethodInfoResult> payMethodInfos;
    private String payOption;

    public List<PayMethodInfoResult> getPayMethodInfos() {
        return this.payMethodInfos;
    }

    public void setPayMethodInfos(List<PayMethodInfoResult> list) {
        this.payMethodInfos = list;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public boolean isEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(boolean z) {
        this.enableStatus = z;
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
