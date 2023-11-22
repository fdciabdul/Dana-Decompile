package id.dana.domain.nearbyme.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ^\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\u0014\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0011\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\nR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u0007R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b$\u0010\u0007R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b)\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b*\u0010\n"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantConsult;", "", "Lid/dana/domain/nearbyme/model/Shop;", "component1", "()Lid/dana/domain/nearbyme/model/Shop;", "", "component2", "()Ljava/util/List;", "", "component3", "()Z", "Lid/dana/domain/nearbyme/model/Tag;", "component4", "component5", "component6", "reviewableShop", "shopInfos", "hasMore", "positiveTags", "negativeSentiments", "showRedDot", "copy", "(Lid/dana/domain/nearbyme/model/Shop;Ljava/util/List;ZLjava/util/List;Ljava/util/List;Z)Lid/dana/domain/nearbyme/model/MerchantConsult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getNegativeSentiments", "getPositiveTags", "Lid/dana/domain/nearbyme/model/Shop;", "getReviewableShop", "setReviewableShop", "(Lid/dana/domain/nearbyme/model/Shop;)V", "getShopInfos", "getShowRedDot", "<init>", "(Lid/dana/domain/nearbyme/model/Shop;Ljava/util/List;ZLjava/util/List;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantConsult {
    private final boolean hasMore;
    private final List<Tag> negativeSentiments;
    private final List<Tag> positiveTags;
    private Shop reviewableShop;
    private final List<Shop> shopInfos;
    private final boolean showRedDot;

    public MerchantConsult() {
        this(null, null, false, null, null, false, 63, null);
    }

    public static /* synthetic */ MerchantConsult copy$default(MerchantConsult merchantConsult, Shop shop, List list, boolean z, List list2, List list3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            shop = merchantConsult.reviewableShop;
        }
        List<Shop> list4 = list;
        if ((i & 2) != 0) {
            list4 = merchantConsult.shopInfos;
        }
        List list5 = list4;
        if ((i & 4) != 0) {
            z = merchantConsult.hasMore;
        }
        boolean z3 = z;
        List<Tag> list6 = list2;
        if ((i & 8) != 0) {
            list6 = merchantConsult.positiveTags;
        }
        List list7 = list6;
        List<Tag> list8 = list3;
        if ((i & 16) != 0) {
            list8 = merchantConsult.negativeSentiments;
        }
        List list9 = list8;
        if ((i & 32) != 0) {
            z2 = merchantConsult.showRedDot;
        }
        return merchantConsult.copy(shop, list5, z3, list7, list9, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final Shop getReviewableShop() {
        return this.reviewableShop;
    }

    public final List<Shop> component2() {
        return this.shopInfos;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Tag> component4() {
        return this.positiveTags;
    }

    public final List<Tag> component5() {
        return this.negativeSentiments;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public final MerchantConsult copy(Shop reviewableShop, List<Shop> shopInfos, boolean hasMore, List<Tag> positiveTags, List<Tag> negativeSentiments, boolean showRedDot) {
        Intrinsics.checkNotNullParameter(reviewableShop, "");
        Intrinsics.checkNotNullParameter(shopInfos, "");
        Intrinsics.checkNotNullParameter(positiveTags, "");
        Intrinsics.checkNotNullParameter(negativeSentiments, "");
        return new MerchantConsult(reviewableShop, shopInfos, hasMore, positiveTags, negativeSentiments, showRedDot);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantConsult) {
            MerchantConsult merchantConsult = (MerchantConsult) other;
            return Intrinsics.areEqual(this.reviewableShop, merchantConsult.reviewableShop) && Intrinsics.areEqual(this.shopInfos, merchantConsult.shopInfos) && this.hasMore == merchantConsult.hasMore && Intrinsics.areEqual(this.positiveTags, merchantConsult.positiveTags) && Intrinsics.areEqual(this.negativeSentiments, merchantConsult.negativeSentiments) && this.showRedDot == merchantConsult.showRedDot;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.reviewableShop.hashCode();
        int hashCode2 = this.shopInfos.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode3 = this.positiveTags.hashCode();
        int hashCode4 = this.negativeSentiments.hashCode();
        boolean z2 = this.showRedDot;
        return (((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + hashCode4) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantConsult(reviewableShop=");
        sb.append(this.reviewableShop);
        sb.append(", shopInfos=");
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

    public MerchantConsult(Shop shop, List<Shop> list, boolean z, List<Tag> list2, List<Tag> list3, boolean z2) {
        Intrinsics.checkNotNullParameter(shop, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.reviewableShop = shop;
        this.shopInfos = list;
        this.hasMore = z;
        this.positiveTags = list2;
        this.negativeSentiments = list3;
        this.showRedDot = z2;
    }

    public /* synthetic */ MerchantConsult(Shop shop, List list, boolean z, List list2, List list3, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Shop(null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, null, null, false, -1, null) : shop, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? CollectionsKt.emptyList() : list3, (i & 32) == 0 ? z2 : false);
    }

    @JvmName(name = "getReviewableShop")
    public final Shop getReviewableShop() {
        return this.reviewableShop;
    }

    @JvmName(name = "setReviewableShop")
    public final void setReviewableShop(Shop shop) {
        Intrinsics.checkNotNullParameter(shop, "");
        this.reviewableShop = shop;
    }

    @JvmName(name = "getShopInfos")
    public final List<Shop> getShopInfos() {
        return this.shopInfos;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getPositiveTags")
    public final List<Tag> getPositiveTags() {
        return this.positiveTags;
    }

    @JvmName(name = "getNegativeSentiments")
    public final List<Tag> getNegativeSentiments() {
        return this.negativeSentiments;
    }

    @JvmName(name = "getShowRedDot")
    public final boolean getShowRedDot() {
        return this.showRedDot;
    }
}
