package id.dana.explore.domain.globalsearch.model;

import id.dana.domain.featureconfig.model.ExplorePromoConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJl\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b'\u0010\u0004R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\bR\u001a\u0010\u0017\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010.R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b0\u0010\u0004R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b1\u0010\b"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "", "", "component1", "()Z", "", "Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "component6", "()Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "component7", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchWidget;", "component8", "exploreDanaBottomNav", "explorePopularPlaces", "exploreShowPopularPlacesWidget", "explorePromoWidget", "exploreOnlineMerchantWidget", "explorePromoConfig", "exploreSkuWidget", "widgetOrder", "copy", "(ZLjava/util/List;ZZZLid/dana/domain/featureconfig/model/ExplorePromoConfig;ZLjava/util/List;)Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getExploreDanaBottomNav", "getExploreOnlineMerchantWidget", "Ljava/util/List;", "getExplorePopularPlaces", "Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "getExplorePromoConfig", "getExplorePromoWidget", "setExplorePromoWidget", "(Z)V", "getExploreShowPopularPlacesWidget", "getExploreSkuWidget", "getWidgetOrder", "<init>", "(ZLjava/util/List;ZZZLid/dana/domain/featureconfig/model/ExplorePromoConfig;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GlobalSearchConfig {
    private final boolean exploreDanaBottomNav;
    private final boolean exploreOnlineMerchantWidget;
    private final List<PopularPlaceInfo> explorePopularPlaces;
    private final ExplorePromoConfig explorePromoConfig;
    private boolean explorePromoWidget;
    private final boolean exploreShowPopularPlacesWidget;
    private final boolean exploreSkuWidget;
    private final List<GlobalSearchWidget> widgetOrder;

    public GlobalSearchConfig() {
        this(false, null, false, false, false, null, false, null, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getExploreDanaBottomNav() {
        return this.exploreDanaBottomNav;
    }

    public final List<PopularPlaceInfo> component2() {
        return this.explorePopularPlaces;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getExploreShowPopularPlacesWidget() {
        return this.exploreShowPopularPlacesWidget;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getExplorePromoWidget() {
        return this.explorePromoWidget;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getExploreOnlineMerchantWidget() {
        return this.exploreOnlineMerchantWidget;
    }

    /* renamed from: component6  reason: from getter */
    public final ExplorePromoConfig getExplorePromoConfig() {
        return this.explorePromoConfig;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getExploreSkuWidget() {
        return this.exploreSkuWidget;
    }

    public final List<GlobalSearchWidget> component8() {
        return this.widgetOrder;
    }

    public final GlobalSearchConfig copy(boolean exploreDanaBottomNav, List<PopularPlaceInfo> explorePopularPlaces, boolean exploreShowPopularPlacesWidget, boolean explorePromoWidget, boolean exploreOnlineMerchantWidget, ExplorePromoConfig explorePromoConfig, boolean exploreSkuWidget, List<GlobalSearchWidget> widgetOrder) {
        Intrinsics.checkNotNullParameter(explorePopularPlaces, "");
        Intrinsics.checkNotNullParameter(explorePromoConfig, "");
        Intrinsics.checkNotNullParameter(widgetOrder, "");
        return new GlobalSearchConfig(exploreDanaBottomNav, explorePopularPlaces, exploreShowPopularPlacesWidget, explorePromoWidget, exploreOnlineMerchantWidget, explorePromoConfig, exploreSkuWidget, widgetOrder);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GlobalSearchConfig) {
            GlobalSearchConfig globalSearchConfig = (GlobalSearchConfig) other;
            return this.exploreDanaBottomNav == globalSearchConfig.exploreDanaBottomNav && Intrinsics.areEqual(this.explorePopularPlaces, globalSearchConfig.explorePopularPlaces) && this.exploreShowPopularPlacesWidget == globalSearchConfig.exploreShowPopularPlacesWidget && this.explorePromoWidget == globalSearchConfig.explorePromoWidget && this.exploreOnlineMerchantWidget == globalSearchConfig.exploreOnlineMerchantWidget && Intrinsics.areEqual(this.explorePromoConfig, globalSearchConfig.explorePromoConfig) && this.exploreSkuWidget == globalSearchConfig.exploreSkuWidget && Intrinsics.areEqual(this.widgetOrder, globalSearchConfig.widgetOrder);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.exploreDanaBottomNav;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.explorePopularPlaces.hashCode();
        ?? r3 = this.exploreShowPopularPlacesWidget;
        int i = r3;
        if (r3 != 0) {
            i = 1;
        }
        ?? r4 = this.explorePromoWidget;
        int i2 = r4;
        if (r4 != 0) {
            i2 = 1;
        }
        ?? r5 = this.exploreOnlineMerchantWidget;
        int i3 = r5;
        if (r5 != 0) {
            i3 = 1;
        }
        int hashCode2 = this.explorePromoConfig.hashCode();
        boolean z2 = this.exploreSkuWidget;
        return (((((((((((((r0 * 31) + hashCode) * 31) + i) * 31) + i2) * 31) + i3) * 31) + hashCode2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.widgetOrder.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GlobalSearchConfig(exploreDanaBottomNav=");
        sb.append(this.exploreDanaBottomNav);
        sb.append(", explorePopularPlaces=");
        sb.append(this.explorePopularPlaces);
        sb.append(", exploreShowPopularPlacesWidget=");
        sb.append(this.exploreShowPopularPlacesWidget);
        sb.append(", explorePromoWidget=");
        sb.append(this.explorePromoWidget);
        sb.append(", exploreOnlineMerchantWidget=");
        sb.append(this.exploreOnlineMerchantWidget);
        sb.append(", explorePromoConfig=");
        sb.append(this.explorePromoConfig);
        sb.append(", exploreSkuWidget=");
        sb.append(this.exploreSkuWidget);
        sb.append(", widgetOrder=");
        sb.append(this.widgetOrder);
        sb.append(')');
        return sb.toString();
    }

    public GlobalSearchConfig(boolean z, List<PopularPlaceInfo> list, boolean z2, boolean z3, boolean z4, ExplorePromoConfig explorePromoConfig, boolean z5, List<GlobalSearchWidget> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(explorePromoConfig, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.exploreDanaBottomNav = z;
        this.explorePopularPlaces = list;
        this.exploreShowPopularPlacesWidget = z2;
        this.explorePromoWidget = z3;
        this.exploreOnlineMerchantWidget = z4;
        this.explorePromoConfig = explorePromoConfig;
        this.exploreSkuWidget = z5;
        this.widgetOrder = list2;
    }

    @JvmName(name = "getExploreDanaBottomNav")
    public final boolean getExploreDanaBottomNav() {
        return this.exploreDanaBottomNav;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ GlobalSearchConfig(boolean r11, java.util.List r12, boolean r13, boolean r14, boolean r15, id.dana.domain.featureconfig.model.ExplorePromoConfig r16, boolean r17, java.util.List r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r11
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L13
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            goto L14
        L13:
            r3 = r12
        L14:
            r4 = r0 & 4
            if (r4 == 0) goto L1a
            r4 = 0
            goto L1b
        L1a:
            r4 = r13
        L1b:
            r5 = r0 & 8
            if (r5 == 0) goto L21
            r5 = 0
            goto L22
        L21:
            r5 = r14
        L22:
            r6 = r0 & 16
            if (r6 == 0) goto L28
            r6 = 0
            goto L29
        L28:
            r6 = r15
        L29:
            r7 = r0 & 32
            if (r7 == 0) goto L35
            id.dana.domain.featureconfig.model.ExplorePromoConfig r7 = new id.dana.domain.featureconfig.model.ExplorePromoConfig
            r8 = 0
            r9 = 1
            r7.<init>(r2, r9, r8)
            goto L37
        L35:
            r7 = r16
        L37:
            r8 = r0 & 64
            if (r8 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r17
        L3e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L47
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L49
        L47:
            r0 = r18
        L49:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r2
            r19 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.domain.globalsearch.model.GlobalSearchConfig.<init>(boolean, java.util.List, boolean, boolean, boolean, id.dana.domain.featureconfig.model.ExplorePromoConfig, boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getExplorePopularPlaces")
    public final List<PopularPlaceInfo> getExplorePopularPlaces() {
        return this.explorePopularPlaces;
    }

    @JvmName(name = "getExploreShowPopularPlacesWidget")
    public final boolean getExploreShowPopularPlacesWidget() {
        return this.exploreShowPopularPlacesWidget;
    }

    @JvmName(name = "getExplorePromoWidget")
    public final boolean getExplorePromoWidget() {
        return this.explorePromoWidget;
    }

    @JvmName(name = "setExplorePromoWidget")
    public final void setExplorePromoWidget(boolean z) {
        this.explorePromoWidget = z;
    }

    @JvmName(name = "getExploreOnlineMerchantWidget")
    public final boolean getExploreOnlineMerchantWidget() {
        return this.exploreOnlineMerchantWidget;
    }

    @JvmName(name = "getExplorePromoConfig")
    public final ExplorePromoConfig getExplorePromoConfig() {
        return this.explorePromoConfig;
    }

    @JvmName(name = "getExploreSkuWidget")
    public final boolean getExploreSkuWidget() {
        return this.exploreSkuWidget;
    }

    @JvmName(name = "getWidgetOrder")
    public final List<GlobalSearchWidget> getWidgetOrder() {
        return this.widgetOrder;
    }
}
