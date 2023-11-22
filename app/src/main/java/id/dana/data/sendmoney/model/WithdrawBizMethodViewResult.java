package id.dana.data.sendmoney.model;

import java.util.List;

/* loaded from: classes4.dex */
public class WithdrawBizMethodViewResult {
    public String payMethod;
    public List<WithdrawCardOptionViewResult> withdrawCardOptionViews;
    public List<WithdrawChannelOptionViewResult> withdrawChannelOptionViews;

    public String getPayMethod() {
        return this.payMethod;
    }

    public List<WithdrawCardOptionViewResult> getWithdrawCardOptionViews() {
        return this.withdrawCardOptionViews;
    }

    public List<WithdrawChannelOptionViewResult> getWithdrawChannelOptionViews() {
        return this.withdrawChannelOptionViews;
    }
}
