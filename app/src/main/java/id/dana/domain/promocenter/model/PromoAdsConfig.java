package id.dana.domain.promocenter.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/promocenter/model/PromoAdsConfig;", "", "", "component1", "()Z", "", "component2", "()I", "enable", "numberOfItemBatch", "copy", "(ZI)Lid/dana/domain/promocenter/model/PromoAdsConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "I", "getNumberOfItemBatch", "<init>", "(ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoAdsConfig {
    private final boolean enable;
    private final int numberOfItemBatch;

    public static /* synthetic */ PromoAdsConfig copy$default(PromoAdsConfig promoAdsConfig, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = promoAdsConfig.enable;
        }
        if ((i2 & 2) != 0) {
            i = promoAdsConfig.numberOfItemBatch;
        }
        return promoAdsConfig.copy(z, i);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final int getNumberOfItemBatch() {
        return this.numberOfItemBatch;
    }

    public final PromoAdsConfig copy(boolean enable, int numberOfItemBatch) {
        return new PromoAdsConfig(enable, numberOfItemBatch);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoAdsConfig) {
            PromoAdsConfig promoAdsConfig = (PromoAdsConfig) other;
            return this.enable == promoAdsConfig.enable && this.numberOfItemBatch == promoAdsConfig.numberOfItemBatch;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.numberOfItemBatch;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoAdsConfig(enable=");
        sb.append(this.enable);
        sb.append(", numberOfItemBatch=");
        sb.append(this.numberOfItemBatch);
        sb.append(')');
        return sb.toString();
    }

    public PromoAdsConfig(boolean z, int i) {
        this.enable = z;
        this.numberOfItemBatch = i;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getNumberOfItemBatch")
    public final int getNumberOfItemBatch() {
        return this.numberOfItemBatch;
    }
}
