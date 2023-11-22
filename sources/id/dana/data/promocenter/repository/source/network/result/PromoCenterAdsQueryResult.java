package id.dana.data.promocenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.promocenter.mapper.PromoResultMapperKt;
import id.dana.data.promocenter.repository.source.network.model.DisplayPromoResponse;
import id.dana.domain.promocenter.model.PromoAds;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005"}, d2 = {"Lid/dana/data/promocenter/repository/source/network/result/PromoCenterAdsQueryResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/promocenter/repository/source/network/model/DisplayPromoResponse;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "listOfAdsPromo", "hasMore", "copy", "(Ljava/util/List;Z)Lid/dana/data/promocenter/repository/source/network/result/PromoCenterAdsQueryResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/promocenter/model/PromoAds;", "toPromoAds", "()Lid/dana/domain/promocenter/model/PromoAds;", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getListOfAdsPromo", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCenterAdsQueryResult extends BaseRpcResult {
    private final boolean hasMore;
    private final List<DisplayPromoResponse> listOfAdsPromo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoCenterAdsQueryResult copy$default(PromoCenterAdsQueryResult promoCenterAdsQueryResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = promoCenterAdsQueryResult.listOfAdsPromo;
        }
        if ((i & 2) != 0) {
            z = promoCenterAdsQueryResult.hasMore;
        }
        return promoCenterAdsQueryResult.copy(list, z);
    }

    public final List<DisplayPromoResponse> component1() {
        return this.listOfAdsPromo;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final PromoCenterAdsQueryResult copy(List<DisplayPromoResponse> listOfAdsPromo, boolean hasMore) {
        Intrinsics.checkNotNullParameter(listOfAdsPromo, "");
        return new PromoCenterAdsQueryResult(listOfAdsPromo, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoCenterAdsQueryResult) {
            PromoCenterAdsQueryResult promoCenterAdsQueryResult = (PromoCenterAdsQueryResult) other;
            return Intrinsics.areEqual(this.listOfAdsPromo, promoCenterAdsQueryResult.listOfAdsPromo) && this.hasMore == promoCenterAdsQueryResult.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.listOfAdsPromo.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCenterAdsQueryResult(listOfAdsPromo=");
        sb.append(this.listOfAdsPromo);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PromoCenterAdsQueryResult(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, z);
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getListOfAdsPromo")
    public final List<DisplayPromoResponse> getListOfAdsPromo() {
        return this.listOfAdsPromo;
    }

    public PromoCenterAdsQueryResult(List<DisplayPromoResponse> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.listOfAdsPromo = list;
        this.hasMore = z;
    }

    public final PromoAds toPromoAds() {
        return new PromoAds(PromoResultMapperKt.toPromos(this.listOfAdsPromo), this.hasMore);
    }
}
