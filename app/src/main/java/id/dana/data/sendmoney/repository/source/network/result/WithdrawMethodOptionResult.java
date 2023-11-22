package id.dana.data.sendmoney.repository.source.network.result;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes8.dex */
public class WithdrawMethodOptionResult {
    private List<WithdrawSavedCardChannelViewResult> withdrawCardOptions;
    private List<WithdrawChannelViewResult> withdrawChannelOptions;
    private String withdrawMethod;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface WithdrawMethod {
        public static final String WITHDRAW_BANKCARD = "WITHDRAW_BANKCARD";
    }

    public List<WithdrawSavedCardChannelViewResult> getWithdrawCardOptions() {
        return this.withdrawCardOptions;
    }

    public void setWithdrawCardOptions(List<WithdrawSavedCardChannelViewResult> list) {
        this.withdrawCardOptions = list;
    }

    public List<WithdrawChannelViewResult> getWithdrawChannelOptions() {
        return this.withdrawChannelOptions;
    }

    public void setWithdrawChannelOptions(List<WithdrawChannelViewResult> list) {
        this.withdrawChannelOptions = list;
    }

    public String getWithdrawMethod() {
        return this.withdrawMethod;
    }

    public void setWithdrawMethod(String str) {
        this.withdrawMethod = str;
    }
}
