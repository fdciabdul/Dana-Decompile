package id.dana.domain.featureconfig.model;

/* loaded from: classes4.dex */
public class DeepLinkFeatureSwitchModel {
    private boolean featureActive;
    private boolean featureNonAmcs;

    public boolean isFeatureNonAmcs() {
        return this.featureNonAmcs;
    }

    public void setFeatureNonAmcs(boolean z) {
        this.featureNonAmcs = z;
    }

    public boolean isFeatureActive() {
        return this.featureActive;
    }

    public void setFeatureActive(boolean z) {
        this.featureActive = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeepLinkFeatureSwitchModel{featureNonAmcs=");
        sb.append(this.featureNonAmcs);
        sb.append(", featureActive=");
        sb.append(this.featureActive);
        sb.append('}');
        return sb.toString();
    }
}
