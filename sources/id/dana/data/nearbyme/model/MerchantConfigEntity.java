package id.dana.data.nearbyme.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "", "", "component1", "()Z", "enable", "copy", "(Z)Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantConfigEntity {
    public boolean enable;

    public /* synthetic */ MerchantConfigEntity() {
    }

    public static /* synthetic */ MerchantConfigEntity copy$default(MerchantConfigEntity merchantConfigEntity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = merchantConfigEntity.enable;
        }
        return merchantConfigEntity.copy(z);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final MerchantConfigEntity copy(boolean enable) {
        return new MerchantConfigEntity(enable);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MerchantConfigEntity) && this.enable == ((MerchantConfigEntity) other).enable;
    }

    public final int hashCode() {
        boolean z = this.enable;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantConfigEntity(enable=");
        sb.append(this.enable);
        sb.append(')');
        return sb.toString();
    }

    public MerchantConfigEntity(boolean z) {
        this.enable = z;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }
}
