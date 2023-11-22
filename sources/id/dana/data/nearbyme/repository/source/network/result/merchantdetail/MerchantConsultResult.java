package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.nearbyme.mapper.NearbyShopsResultMapper;
import id.dana.data.nearbyme.model.ShopEntity;
import id.dana.data.nearbyme.model.TagEntity;
import id.dana.data.nearbyme.model.TagEntityKt;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.Shop;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\\\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\"\u001a\u00020!*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\bR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0005R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b(\u0010\u0005R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b)\u0010\u0005R\u001a\u0010\u0012\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010\r"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/nearbyme/model/ShopEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Boolean;", "Lid/dana/data/nearbyme/model/TagEntity;", "component3", "component4", "component5", "()Z", "shopInfos", "hasMore", "positiveTags", "negativeSentiments", "showRedDot", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Z)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;", "nearbyShopsResultMapper", "Lid/dana/domain/nearbyme/model/MerchantConsult;", "toMerchantConsult", "(Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;)Lid/dana/domain/nearbyme/model/MerchantConsult;", "Ljava/lang/Boolean;", "getHasMore", "Ljava/util/List;", "getNegativeSentiments", "getPositiveTags", "getShopInfos", "Z", "getShowRedDot", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantConsultResult extends BaseRpcResult {
    private final Boolean hasMore;
    private final List<TagEntity> negativeSentiments;
    private final List<TagEntity> positiveTags;
    private final List<ShopEntity> shopInfos;
    private final boolean showRedDot;

    public MerchantConsultResult() {
        this(null, null, null, null, false, 31, null);
    }

    public static /* synthetic */ MerchantConsultResult copy$default(MerchantConsultResult merchantConsultResult, List list, Boolean bool, List list2, List list3, boolean z, int i, Object obj) {
        List<ShopEntity> list4 = list;
        if ((i & 1) != 0) {
            list4 = merchantConsultResult.shopInfos;
        }
        if ((i & 2) != 0) {
            bool = merchantConsultResult.hasMore;
        }
        Boolean bool2 = bool;
        List<TagEntity> list5 = list2;
        if ((i & 4) != 0) {
            list5 = merchantConsultResult.positiveTags;
        }
        List list6 = list5;
        List<TagEntity> list7 = list3;
        if ((i & 8) != 0) {
            list7 = merchantConsultResult.negativeSentiments;
        }
        List list8 = list7;
        if ((i & 16) != 0) {
            z = merchantConsultResult.showRedDot;
        }
        return merchantConsultResult.copy(list4, bool2, list6, list8, z);
    }

    public final List<ShopEntity> component1() {
        return this.shopInfos;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<TagEntity> component3() {
        return this.positiveTags;
    }

    public final List<TagEntity> component4() {
        return this.negativeSentiments;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public final MerchantConsultResult copy(List<? extends ShopEntity> shopInfos, Boolean hasMore, List<TagEntity> positiveTags, List<TagEntity> negativeSentiments, boolean showRedDot) {
        return new MerchantConsultResult(shopInfos, hasMore, positiveTags, negativeSentiments, showRedDot);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantConsultResult) {
            MerchantConsultResult merchantConsultResult = (MerchantConsultResult) other;
            return Intrinsics.areEqual(this.shopInfos, merchantConsultResult.shopInfos) && Intrinsics.areEqual(this.hasMore, merchantConsultResult.hasMore) && Intrinsics.areEqual(this.positiveTags, merchantConsultResult.positiveTags) && Intrinsics.areEqual(this.negativeSentiments, merchantConsultResult.negativeSentiments) && this.showRedDot == merchantConsultResult.showRedDot;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        List<ShopEntity> list = this.shopInfos;
        int hashCode = list == null ? 0 : list.hashCode();
        Boolean bool = this.hasMore;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        List<TagEntity> list2 = this.positiveTags;
        int hashCode3 = list2 == null ? 0 : list2.hashCode();
        List<TagEntity> list3 = this.negativeSentiments;
        int hashCode4 = list3 != null ? list3.hashCode() : 0;
        boolean z = this.showRedDot;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantConsultResult(shopInfos=");
        sb.append(this.shopInfos);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(", positiveTags=");
        sb.append(this.positiveTags);
        sb.append(", negativeSentiments=");
        sb.append(this.negativeSentiments);
        sb.append(", showRedDot=");
        sb.append(this.showRedDot);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ MerchantConsultResult(List list, Boolean bool, List list2, List list3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3, (i & 16) != 0 ? false : z);
    }

    @JvmName(name = "getShopInfos")
    public final List<ShopEntity> getShopInfos() {
        return this.shopInfos;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getPositiveTags")
    public final List<TagEntity> getPositiveTags() {
        return this.positiveTags;
    }

    @JvmName(name = "getNegativeSentiments")
    public final List<TagEntity> getNegativeSentiments() {
        return this.negativeSentiments;
    }

    @JvmName(name = "getShowRedDot")
    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantConsultResult(List<? extends ShopEntity> list, Boolean bool, List<TagEntity> list2, List<TagEntity> list3, boolean z) {
        this.shopInfos = list;
        this.hasMore = bool;
        this.positiveTags = list2;
        this.negativeSentiments = list3;
        this.showRedDot = z;
    }

    public final MerchantConsult toMerchantConsult(MerchantConsultResult merchantConsultResult, NearbyShopsResultMapper nearbyShopsResultMapper) {
        Intrinsics.checkNotNullParameter(merchantConsultResult, "");
        Intrinsics.checkNotNullParameter(nearbyShopsResultMapper, "");
        Shop shop = new Shop(null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, null, null, false, -1, null);
        List<Shop> transform = nearbyShopsResultMapper.transform(merchantConsultResult.shopInfos);
        if (transform == null) {
            transform = CollectionsKt.emptyList();
        }
        List<Shop> list = transform;
        Boolean bool = merchantConsultResult.hasMore;
        return new MerchantConsult(shop, list, bool != null ? bool.booleanValue() : false, TagEntityKt.toTag(merchantConsultResult.positiveTags), TagEntityKt.toTag(merchantConsultResult.negativeSentiments), merchantConsultResult.showRedDot);
    }
}
