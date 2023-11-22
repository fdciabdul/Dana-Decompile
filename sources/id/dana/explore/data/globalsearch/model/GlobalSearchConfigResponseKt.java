package id.dana.explore.data.globalsearch.model;

import id.dana.domain.featureconfig.model.ExplorePromoConfig;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.GlobalSearchWidget;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\f*\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;", "Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "toExplorePromoConfig", "(Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;)Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "toGlobalSearchConfig", "(Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;)Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "Lid/dana/explore/data/globalsearch/model/GlobalSearchWidgetResponse;", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchWidget;", "toGlobalSearchWidget", "(Lid/dana/explore/data/globalsearch/model/GlobalSearchWidgetResponse;)Lid/dana/explore/domain/globalsearch/model/GlobalSearchWidget;", "", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchConfigResponseKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    public static final GlobalSearchConfig toGlobalSearchConfig(GlobalSearchConfigResponse globalSearchConfigResponse) {
        ExplorePromoConfig explorePromoConfig;
        Intrinsics.checkNotNullParameter(globalSearchConfigResponse, "");
        Boolean exploreDanaBottomNav = globalSearchConfigResponse.getExploreDanaBottomNav();
        int i = 0;
        boolean booleanValue = exploreDanaBottomNav != null ? exploreDanaBottomNav.booleanValue() : false;
        List<PopularPlaceInfo> explorePopularPlaces = globalSearchConfigResponse.getExplorePopularPlaces();
        if (explorePopularPlaces == null) {
            explorePopularPlaces = CollectionsKt.emptyList();
        }
        List<PopularPlaceInfo> list = explorePopularPlaces;
        Boolean exploreShowPopularPlacesWidget = globalSearchConfigResponse.getExploreShowPopularPlacesWidget();
        boolean booleanValue2 = exploreShowPopularPlacesWidget != null ? exploreShowPopularPlacesWidget.booleanValue() : false;
        Boolean explorePromoWidget = globalSearchConfigResponse.getExplorePromoWidget();
        boolean booleanValue3 = explorePromoWidget != null ? explorePromoWidget.booleanValue() : false;
        ExplorePromoConfigResponse explorePromoConfig2 = globalSearchConfigResponse.getExplorePromoConfig();
        if (explorePromoConfig2 == null || (explorePromoConfig = toExplorePromoConfig(explorePromoConfig2)) == null) {
            explorePromoConfig = new ExplorePromoConfig(i, 1, r2);
        }
        ExplorePromoConfig explorePromoConfig3 = explorePromoConfig;
        Boolean exploreSkuWidget = globalSearchConfigResponse.getExploreSkuWidget();
        boolean booleanValue4 = exploreSkuWidget != null ? exploreSkuWidget.booleanValue() : false;
        Boolean exploreOnlineMerchantWidget = globalSearchConfigResponse.getExploreOnlineMerchantWidget();
        boolean booleanValue5 = exploreOnlineMerchantWidget != null ? exploreOnlineMerchantWidget.booleanValue() : false;
        List<GlobalSearchWidgetResponse> widgetOrder = globalSearchConfigResponse.getWidgetOrder();
        r2 = widgetOrder != null ? toGlobalSearchWidget(widgetOrder) : null;
        return new GlobalSearchConfig(booleanValue, list, booleanValue2, booleanValue3, booleanValue5, explorePromoConfig3, booleanValue4, r2 == null ? CollectionsKt.emptyList() : r2);
    }

    public static final ExplorePromoConfig toExplorePromoConfig(ExplorePromoConfigResponse explorePromoConfigResponse) {
        Intrinsics.checkNotNullParameter(explorePromoConfigResponse, "");
        Integer promoBannerLimit = explorePromoConfigResponse.getPromoBannerLimit();
        return new ExplorePromoConfig(promoBannerLimit != null ? promoBannerLimit.intValue() : 5);
    }

    public static final List<GlobalSearchWidget> toGlobalSearchWidget(List<GlobalSearchWidgetResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<GlobalSearchWidgetResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toGlobalSearchWidget((GlobalSearchWidgetResponse) it.next()));
        }
        return arrayList;
    }

    public static final GlobalSearchWidget toGlobalSearchWidget(GlobalSearchWidgetResponse globalSearchWidgetResponse) {
        Intrinsics.checkNotNullParameter(globalSearchWidgetResponse, "");
        Integer orderId = globalSearchWidgetResponse.getOrderId();
        int intValue = orderId != null ? orderId.intValue() : 0;
        String name = globalSearchWidgetResponse.getName();
        return new GlobalSearchWidget(intValue, name != null ? name : "");
    }
}
