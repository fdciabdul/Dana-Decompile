package id.dana.domain.nearbyme.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001a\u0010\f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "", "", "Lid/dana/domain/nearbyme/model/Shop;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "component3", "shops", "hasMore", "promoFlag", "copy", "(Ljava/util/List;ZZ)Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "getPromoFlag", "Ljava/util/List;", "getShops", "setShops", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OtherStoreListResult {
    private final boolean hasMore;
    private final boolean promoFlag;
    private List<Shop> shops;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OtherStoreListResult copy$default(OtherStoreListResult otherStoreListResult, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = otherStoreListResult.shops;
        }
        if ((i & 2) != 0) {
            z = otherStoreListResult.hasMore;
        }
        if ((i & 4) != 0) {
            z2 = otherStoreListResult.promoFlag;
        }
        return otherStoreListResult.copy(list, z, z2);
    }

    public final List<Shop> component1() {
        return this.shops;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getPromoFlag() {
        return this.promoFlag;
    }

    public final OtherStoreListResult copy(List<Shop> shops, boolean hasMore, boolean promoFlag) {
        Intrinsics.checkNotNullParameter(shops, "");
        return new OtherStoreListResult(shops, hasMore, promoFlag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OtherStoreListResult) {
            OtherStoreListResult otherStoreListResult = (OtherStoreListResult) other;
            return Intrinsics.areEqual(this.shops, otherStoreListResult.shops) && this.hasMore == otherStoreListResult.hasMore && this.promoFlag == otherStoreListResult.promoFlag;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.shops.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.promoFlag;
        return (((hashCode * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OtherStoreListResult(shops=");
        sb.append(this.shops);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(", promoFlag=");
        sb.append(this.promoFlag);
        sb.append(')');
        return sb.toString();
    }

    public OtherStoreListResult(List<Shop> list, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.shops = list;
        this.hasMore = z;
        this.promoFlag = z2;
    }

    @JvmName(name = "getShops")
    public final List<Shop> getShops() {
        return this.shops;
    }

    @JvmName(name = "setShops")
    public final void setShops(List<Shop> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.shops = list;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getPromoFlag")
    public final boolean getPromoFlag() {
        return this.promoFlag;
    }
}
