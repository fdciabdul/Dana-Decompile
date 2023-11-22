package id.dana.domain.nearbyme.model;

import id.dana.contract.deeplink.path.FeatureParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001a"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lid/dana/domain/nearbyme/model/PromoInfo;", "component3", "()Ljava/util/List;", "merchantId", FeatureParams.SHOP_ID, "promoInfos", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMerchantId", "setMerchantId", "(Ljava/lang/String;)V", "Ljava/util/List;", "getPromoInfos", "setPromoInfos", "(Ljava/util/List;)V", "getShopId", "setShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyShopsPromo {
    private String merchantId;
    private List<PromoInfo> promoInfos;
    private String shopId;

    public NearbyShopsPromo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyShopsPromo copy$default(NearbyShopsPromo nearbyShopsPromo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nearbyShopsPromo.merchantId;
        }
        if ((i & 2) != 0) {
            str2 = nearbyShopsPromo.shopId;
        }
        if ((i & 4) != 0) {
            list = nearbyShopsPromo.promoInfos;
        }
        return nearbyShopsPromo.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    public final List<PromoInfo> component3() {
        return this.promoInfos;
    }

    public final NearbyShopsPromo copy(String merchantId, String shopId, List<PromoInfo> promoInfos) {
        return new NearbyShopsPromo(merchantId, shopId, promoInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyShopsPromo) {
            NearbyShopsPromo nearbyShopsPromo = (NearbyShopsPromo) other;
            return Intrinsics.areEqual(this.merchantId, nearbyShopsPromo.merchantId) && Intrinsics.areEqual(this.shopId, nearbyShopsPromo.shopId) && Intrinsics.areEqual(this.promoInfos, nearbyShopsPromo.promoInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.merchantId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.shopId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<PromoInfo> list = this.promoInfos;
        return (((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyShopsPromo(merchantId=");
        sb.append(this.merchantId);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", promoInfos=");
        sb.append(this.promoInfos);
        sb.append(')');
        return sb.toString();
    }

    public NearbyShopsPromo(String str, String str2, List<PromoInfo> list) {
        this.merchantId = str;
        this.shopId = str2;
        this.promoInfos = list;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "setShopId")
    public final void setShopId(String str) {
        this.shopId = str;
    }

    public /* synthetic */ NearbyShopsPromo(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPromoInfos")
    public final List<PromoInfo> getPromoInfos() {
        return this.promoInfos;
    }

    @JvmName(name = "setPromoInfos")
    public final void setPromoInfos(List<PromoInfo> list) {
        this.promoInfos = list;
    }
}
