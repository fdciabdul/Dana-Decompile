package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class RequestMoneyInfoResult {
    @JSONField(name = "maximum_amount")
    private int maxAmount;
    @JSONField(name = "minimum_amount")
    private int minAmount;

    public int getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(int i) {
        this.minAmount = i;
    }

    public int getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(int i) {
        this.maxAmount = i;
    }
}
