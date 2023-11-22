package id.dana.data.splitbill.model;

import java.util.List;

/* loaded from: classes4.dex */
public class SplitBillDetailResult {
    private String comment;
    private String deeplinkUrl;
    private String payeeIndex;
    private String payerAmount;
    private String payerIndex;
    private List<SplitBillPayerResult> payersResult;
    private String splitBillId;
    private String status;

    public String getSplitBillId() {
        return this.splitBillId;
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public String getPayerIndex() {
        return this.payerIndex;
    }

    public void setPayerIndex(String str) {
        this.payerIndex = str;
    }

    public String getPayeeIndex() {
        return this.payeeIndex;
    }

    public void setPayeeIndex(String str) {
        this.payeeIndex = str;
    }

    public String getPayerAmount() {
        return this.payerAmount;
    }

    public void setPayerAmount(String str) {
        this.payerAmount = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public List<SplitBillPayerResult> getPayersResult() {
        return this.payersResult;
    }

    public void setPayersResult(List<SplitBillPayerResult> list) {
        this.payersResult = list;
    }

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }
}
