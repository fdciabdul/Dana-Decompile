package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class SplitBillConfigResult {
    @JSONField(name = "feature_enable")
    private boolean featureEnable;
    @JSONField(name = "max_recipient")
    private int maxRecipient;

    public boolean isFeatureEnable() {
        return this.featureEnable;
    }

    public void setFeatureEnable(boolean z) {
        this.featureEnable = z;
    }

    public int getMaxRecipient() {
        return this.maxRecipient;
    }

    public void setMaxRecipient(int i) {
        this.maxRecipient = i;
    }
}
