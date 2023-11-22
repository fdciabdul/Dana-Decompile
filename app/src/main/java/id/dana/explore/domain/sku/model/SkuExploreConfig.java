package id.dana.explore.domain.sku.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "id", "type", "serviceName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getId", "getServiceName", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SkuExploreConfig {
    private final String id;
    private final String serviceName;
    private final String type;

    public static /* synthetic */ SkuExploreConfig copy$default(SkuExploreConfig skuExploreConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skuExploreConfig.id;
        }
        if ((i & 2) != 0) {
            str2 = skuExploreConfig.type;
        }
        if ((i & 4) != 0) {
            str3 = skuExploreConfig.serviceName;
        }
        return skuExploreConfig.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3  reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    public final SkuExploreConfig copy(String id2, String type, String serviceName) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(serviceName, "");
        return new SkuExploreConfig(id2, type, serviceName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SkuExploreConfig) {
            SkuExploreConfig skuExploreConfig = (SkuExploreConfig) other;
            return Intrinsics.areEqual(this.id, skuExploreConfig.id) && Intrinsics.areEqual(this.type, skuExploreConfig.type) && Intrinsics.areEqual(this.serviceName, skuExploreConfig.serviceName);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.serviceName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkuExploreConfig(id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", serviceName=");
        sb.append(this.serviceName);
        sb.append(')');
        return sb.toString();
    }

    public SkuExploreConfig(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.id = str;
        this.type = str2;
        this.serviceName = str3;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getServiceName")
    public final String getServiceName() {
        return this.serviceName;
    }
}
