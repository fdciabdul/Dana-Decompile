package id.dana.domain.promocenter.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b"}, d2 = {"Lid/dana/domain/promocenter/model/PromoAds;", "", "", "Lid/dana/domain/promocenter/model/Promo;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "adsList", "hasMore", "copy", "(Ljava/util/List;Z)Lid/dana/domain/promocenter/model/PromoAds;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getAdsList", "Z", "getHasMore", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoAds {
    private final List<Promo> adsList;
    private final boolean hasMore;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoAds copy$default(PromoAds promoAds, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = promoAds.adsList;
        }
        if ((i & 2) != 0) {
            z = promoAds.hasMore;
        }
        return promoAds.copy(list, z);
    }

    public final List<Promo> component1() {
        return this.adsList;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final PromoAds copy(List<? extends Promo> adsList, boolean hasMore) {
        Intrinsics.checkNotNullParameter(adsList, "");
        return new PromoAds(adsList, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoAds) {
            PromoAds promoAds = (PromoAds) other;
            return Intrinsics.areEqual(this.adsList, promoAds.adsList) && this.hasMore == promoAds.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.adsList.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoAds(adsList=");
        sb.append(this.adsList);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PromoAds(List<? extends Promo> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.adsList = list;
        this.hasMore = z;
    }

    @JvmName(name = "getAdsList")
    public final List<Promo> getAdsList() {
        return this.adsList;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }
}
