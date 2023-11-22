package id.dana.domain.splitbill.model;

import id.dana.domain.user.CurrencyAmount;
import java.util.List;

/* loaded from: classes4.dex */
public class SplitBillHistory extends SplitBill {
    private List<String> avatars;
    private long createdDate;
    private String deeplink;
    private String payeeIndex;
    private String payerIndex;
    private String splitBillId;
    private String status;
    private CurrencyAmount totalAmount;

    public List<String> getAvatars() {
        return this.avatars;
    }

    public void setAvatars(List<String> list) {
        this.avatars = list;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public long getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(long j) {
        this.createdDate = j;
    }

    public CurrencyAmount getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmount currencyAmount) {
        this.totalAmount = currencyAmount;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    @Override // id.dana.domain.splitbill.model.SplitBill
    public String getSplitBillId() {
        return this.splitBillId;
    }

    @Override // id.dana.domain.splitbill.model.SplitBill
    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public String getPayeeIndex() {
        return this.payeeIndex;
    }

    public void setPayeeIndex(String str) {
        this.payeeIndex = str;
    }

    public String getPayerIndex() {
        return this.payerIndex;
    }

    public void setPayerIndex(String str) {
        this.payerIndex = str;
    }
}
