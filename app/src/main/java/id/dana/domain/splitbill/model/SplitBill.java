package id.dana.domain.splitbill.model;

import java.util.List;

/* loaded from: classes4.dex */
public class SplitBill {
    private String comment;
    private List<SplitBillPayer> payers;
    private String splitBillId;

    public String getSplitBillId() {
        return this.splitBillId;
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public List<SplitBillPayer> getPayers() {
        return this.payers;
    }

    public void setPayers(List<SplitBillPayer> list) {
        this.payers = list;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }
}
