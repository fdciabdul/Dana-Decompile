package id.dana.data.homeinfo.model;

import java.util.Objects;

/* loaded from: classes4.dex */
public class KybEntity {
    public String certificateTier;
    public boolean enableCertificateTier;
    public String failedReason;
    public String kybLevel;
    public String orderStatus;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KybEntity kybEntity = (KybEntity) obj;
        return Objects.equals(this.kybLevel, kybEntity.kybLevel) && Objects.equals(this.orderStatus, kybEntity.orderStatus) && Objects.equals(this.failedReason, kybEntity.failedReason);
    }

    public int hashCode() {
        return Objects.hash(this.kybLevel, this.orderStatus, this.failedReason);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybEntity{kybLevel='");
        sb.append(this.kybLevel);
        sb.append('\'');
        sb.append(", orderStatus='");
        sb.append(this.orderStatus);
        sb.append('\'');
        sb.append(", failedReason='");
        sb.append(this.failedReason);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
