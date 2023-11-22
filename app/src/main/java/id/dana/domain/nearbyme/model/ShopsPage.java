package id.dana.domain.nearbyme.model;

import id.dana.notification.DanaFirebaseMessagingService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010!"}, d2 = {"Lid/dana/domain/nearbyme/model/ShopsPage;", "", "", "component1", "()Z", "", "Lid/dana/domain/nearbyme/model/Shop;", "component2", "()Ljava/util/List;", "component3", "hasMore", "shops", "promoFlag", "copy", "(ZLjava/util/List;Z)Lid/dana/domain/nearbyme/model/ShopsPage;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "setHasMore", "(Z)V", "getPromoFlag", "setPromoFlag", "Ljava/util/List;", "getShops", "setShops", "(Ljava/util/List;)V", "<init>", "(ZLjava/util/List;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ShopsPage {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasMore;
    private boolean promoFlag;
    private List<Shop> shops;

    public ShopsPage() {
        this(false, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopsPage copy$default(ShopsPage shopsPage, boolean z, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = shopsPage.hasMore;
        }
        if ((i & 2) != 0) {
            list = shopsPage.shops;
        }
        if ((i & 4) != 0) {
            z2 = shopsPage.promoFlag;
        }
        return shopsPage.copy(z, list, z2);
    }

    @JvmStatic
    public static final ShopsPage empty() {
        return INSTANCE.empty();
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Shop> component2() {
        return this.shops;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getPromoFlag() {
        return this.promoFlag;
    }

    public final ShopsPage copy(boolean hasMore, List<Shop> shops, boolean promoFlag) {
        return new ShopsPage(hasMore, shops, promoFlag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ShopsPage) {
            ShopsPage shopsPage = (ShopsPage) other;
            return this.hasMore == shopsPage.hasMore && Intrinsics.areEqual(this.shops, shopsPage.shops) && this.promoFlag == shopsPage.promoFlag;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        List<Shop> list = this.shops;
        int hashCode = list == null ? 0 : list.hashCode();
        boolean z2 = this.promoFlag;
        return (((r0 * 31) + hashCode) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopsPage(hasMore=");
        sb.append(this.hasMore);
        sb.append(", shops=");
        sb.append(this.shops);
        sb.append(", promoFlag=");
        sb.append(this.promoFlag);
        sb.append(')');
        return sb.toString();
    }

    public ShopsPage(boolean z, List<Shop> list, boolean z2) {
        this.hasMore = z;
        this.shops = list;
        this.promoFlag = z2;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "setHasMore")
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public /* synthetic */ ShopsPage(boolean z, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z2);
    }

    @JvmName(name = "getShops")
    public final List<Shop> getShops() {
        return this.shops;
    }

    @JvmName(name = "setShops")
    public final void setShops(List<Shop> list) {
        this.shops = list;
    }

    @JvmName(name = "getPromoFlag")
    public final boolean getPromoFlag() {
        return this.promoFlag;
    }

    @JvmName(name = "setPromoFlag")
    public final void setPromoFlag(boolean z) {
        this.promoFlag = z;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/ShopsPage$Companion;", "", "Lid/dana/domain/nearbyme/model/ShopsPage;", DanaFirebaseMessagingService.EMPTY, "()Lid/dana/domain/nearbyme/model/ShopsPage;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShopsPage empty() {
            return new ShopsPage(false, CollectionsKt.emptyList(), false);
        }
    }
}
