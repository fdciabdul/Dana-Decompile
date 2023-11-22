package id.dana.explore.data.globalsearch.model;

import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\t¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e"}, d2 = {"Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "", "", "exploreDanaBottomNav", "Ljava/lang/Boolean;", "getExploreDanaBottomNav", "()Ljava/lang/Boolean;", "exploreOnlineMerchantWidget", "getExploreOnlineMerchantWidget", "", "Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "explorePopularPlaces", "Ljava/util/List;", "getExplorePopularPlaces", "()Ljava/util/List;", "Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;", "explorePromoConfig", "Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;", "getExplorePromoConfig", "()Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;", "explorePromoWidget", "getExplorePromoWidget", "exploreShowPopularPlacesWidget", "getExploreShowPopularPlacesWidget", "exploreSkuWidget", "getExploreSkuWidget", "Lid/dana/explore/data/globalsearch/model/GlobalSearchWidgetResponse;", "widgetOrder", "getWidgetOrder", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchConfigResponse {
    public Boolean exploreDanaBottomNav;
    public Boolean exploreOnlineMerchantWidget;
    public List<PopularPlaceInfo> explorePopularPlaces;
    public ExplorePromoConfigResponse explorePromoConfig;
    public Boolean explorePromoWidget;
    public Boolean exploreShowPopularPlacesWidget;
    public Boolean exploreSkuWidget;
    public List<GlobalSearchWidgetResponse> widgetOrder;

    public GlobalSearchConfigResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public GlobalSearchConfigResponse(Boolean bool, List<PopularPlaceInfo> list, Boolean bool2, Boolean bool3, ExplorePromoConfigResponse explorePromoConfigResponse, Boolean bool4, Boolean bool5, List<GlobalSearchWidgetResponse> list2) {
        this.exploreDanaBottomNav = bool;
        this.explorePopularPlaces = list;
        this.exploreShowPopularPlacesWidget = bool2;
        this.explorePromoWidget = bool3;
        this.explorePromoConfig = explorePromoConfigResponse;
        this.exploreSkuWidget = bool4;
        this.exploreOnlineMerchantWidget = bool5;
        this.widgetOrder = list2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ GlobalSearchConfigResponse(java.lang.Boolean r10, java.util.List r11, java.lang.Boolean r12, java.lang.Boolean r13, id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse r14, java.lang.Boolean r15, java.lang.Boolean r16, java.util.List r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r2 = r0 & 1
            if (r2 == 0) goto La
            r2 = r1
            goto Lb
        La:
            r2 = r10
        Lb:
            r3 = r0 & 2
            if (r3 == 0) goto L14
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            goto L15
        L14:
            r3 = r11
        L15:
            r4 = r0 & 4
            if (r4 == 0) goto L1b
            r4 = r1
            goto L1c
        L1b:
            r4 = r12
        L1c:
            r5 = r0 & 8
            if (r5 == 0) goto L22
            r5 = r1
            goto L23
        L22:
            r5 = r13
        L23:
            r6 = r0 & 16
            if (r6 == 0) goto L2f
            id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse r6 = new id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse
            r7 = 0
            r8 = 1
            r6.<init>(r7, r8, r7)
            goto L30
        L2f:
            r6 = r14
        L30:
            r7 = r0 & 32
            if (r7 == 0) goto L36
            r7 = r1
            goto L37
        L36:
            r7 = r15
        L37:
            r8 = r0 & 64
            if (r8 != 0) goto L3d
            r1 = r16
        L3d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L46
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L48
        L46:
            r0 = r17
        L48:
            r10 = r9
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r1
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.<init>(java.lang.Boolean, java.util.List, java.lang.Boolean, java.lang.Boolean, id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse, java.lang.Boolean, java.lang.Boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getExploreDanaBottomNav")
    public final Boolean getExploreDanaBottomNav() {
        return this.exploreDanaBottomNav;
    }

    @JvmName(name = "getExplorePopularPlaces")
    public final List<PopularPlaceInfo> getExplorePopularPlaces() {
        return this.explorePopularPlaces;
    }

    @JvmName(name = "getExploreShowPopularPlacesWidget")
    public final Boolean getExploreShowPopularPlacesWidget() {
        return this.exploreShowPopularPlacesWidget;
    }

    @JvmName(name = "getExplorePromoWidget")
    public final Boolean getExplorePromoWidget() {
        return this.explorePromoWidget;
    }

    @JvmName(name = "getExplorePromoConfig")
    public final ExplorePromoConfigResponse getExplorePromoConfig() {
        return this.explorePromoConfig;
    }

    @JvmName(name = "getExploreSkuWidget")
    public final Boolean getExploreSkuWidget() {
        return this.exploreSkuWidget;
    }

    @JvmName(name = "getExploreOnlineMerchantWidget")
    public final Boolean getExploreOnlineMerchantWidget() {
        return this.exploreOnlineMerchantWidget;
    }

    @JvmName(name = "getWidgetOrder")
    public final List<GlobalSearchWidgetResponse> getWidgetOrder() {
        return this.widgetOrder;
    }
}
