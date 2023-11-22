package id.dana.richview.boundcard.model;

import java.io.Serializable;

/* loaded from: classes9.dex */
public class PayChannelOptionViewDTO implements Serializable {
    private Boolean enableStatus;
    private String instId;
    private String instName;
    private Boolean interBank;
    private String payOption;

    public Boolean getEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(Boolean bool) {
        this.enableStatus = bool;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstName(String str) {
        this.instName = str;
    }

    public Boolean getInterBank() {
        return this.interBank;
    }

    public void setInterBank(Boolean bool) {
        this.interBank = bool;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public void setPayOption(String str) {
        this.payOption = str;
    }
}
