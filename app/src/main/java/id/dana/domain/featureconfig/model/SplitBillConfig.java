package id.dana.domain.featureconfig.model;

/* loaded from: classes4.dex */
public class SplitBillConfig {
    private boolean featureEnable;
    private int maxRecipient;

    public SplitBillConfig(boolean z, int i) {
        this.featureEnable = z;
        this.maxRecipient = i;
    }

    public boolean isFeatureEnable() {
        return this.featureEnable;
    }

    public int getMaxRecipient() {
        return this.maxRecipient;
    }
}
