package id.dana.data.splitbill.model;

import android.text.TextUtils;
import id.dana.data.model.CurrencyAmountResult;
import java.util.List;

/* loaded from: classes4.dex */
public class SplitBillHistoryResult {
    private List<String> avatarPayersList;
    private String comment;
    private long splitBillDate;
    private String splitBillId;
    private String status;
    private CurrencyAmountResult totalAmount;

    public String getSplitBillId() {
        return this.splitBillId;
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public CurrencyAmountResult getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmountResult currencyAmountResult) {
        this.totalAmount = currencyAmountResult;
    }

    public long getSplitBillDate() {
        return this.splitBillDate;
    }

    public void setSplitBillDate(long j) {
        this.splitBillDate = j;
    }

    public List<String> getAvatarPayersList() {
        return this.avatarPayersList;
    }

    public void setAvatarPayersList(List<String> list) {
        this.avatarPayersList = list;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean isPendingItem() {
        return !TextUtils.isEmpty(this.status) && "IN_PROGRESS".equals(this.status);
    }
}
