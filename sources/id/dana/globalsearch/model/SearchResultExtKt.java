package id.dana.globalsearch.model;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import id.dana.utils.LocationUtil;
import id.dana.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\u000b\u001a.\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000f¨\u0006\u0013"}, d2 = {"getCategory", "", "Lid/dana/globalsearch/model/SearchResult;", "getCategoryName", HummerConstants.CONTEXT, "Landroid/content/Context;", "toListPaySearchInfoModel", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "toSearchResult", "Lid/dana/explore/domain/globalsearch/model/SearchResultResponse;", "toSearchResultModel", "Lid/dana/globalsearch/model/SearchResultModel;", "hasSeeAll", "", "limitList", "", "shouldLoadMore", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchResultExtKt {
    public static /* synthetic */ SearchResultModel BuiltInFictitiousFunctionClassFactory(SearchResult searchResult, Context context, boolean z, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        return MyBillsEntityDataFactory(searchResult, context, z, i, false);
    }

    public static final SearchResult PlaceComponentResult(SearchResultResponse searchResultResponse) {
        Intrinsics.checkNotNullParameter(searchResultResponse, "");
        return new SearchResult(searchResultResponse.getSearchResultList(), searchResultResponse.getPaginator(), searchResultResponse.getRequiresLocationPermission());
    }

    public static final List<PaySearchInfoModel> KClassImpl$Data$declaredNonStaticMembers$2(List<PaySearchInfo> list, Context context) {
        String str;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(context, "");
        List<PaySearchInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PaySearchInfo paySearchInfo : list2) {
            if (paySearchInfo.getUserLocation().isUndefined() || paySearchInfo.getLocation() == null) {
                str = null;
            } else {
                double latitude = paySearchInfo.getUserLocation().getLatitude();
                double longitude = paySearchInfo.getUserLocation().getLongitude();
                LatLng location = paySearchInfo.getLocation();
                Intrinsics.checkNotNull(location);
                double latitude2 = location.getLatitude();
                LatLng location2 = paySearchInfo.getLocation();
                Intrinsics.checkNotNull(location2);
                str = TextUtil.getAuthRequestContext(context, LocationUtil.BuiltInFictitiousFunctionClassFactory(latitude, longitude, latitude2, location2.getLongitude()));
            }
            arrayList.add(new PaySearchInfoModel(paySearchInfo.getId(), paySearchInfo.getName(), paySearchInfo.getMcc(), paySearchInfo.getCategory(), paySearchInfo.getSubCategory(), paySearchInfo.getUrlMap(), paySearchInfo.getLogo(), paySearchInfo.getTag(), paySearchInfo.getDescription(), paySearchInfo.getScore(), paySearchInfo.getRating(), paySearchInfo.getAddress(), paySearchInfo.getLocation(), paySearchInfo.getInfoType(), paySearchInfo.getInfo(), str, null, false, paySearchInfo.getTrendingFlag(), paySearchInfo.getNewFlag(), 196608, null));
        }
        return arrayList;
    }

    public static final String PlaceComponentResult(SearchResult searchResult) {
        PaySearchInfo paySearchInfo;
        Intrinsics.checkNotNullParameter(searchResult, "");
        List<PaySearchInfo> list = searchResult.PlaceComponentResult;
        String category = (list == null || (paySearchInfo = (PaySearchInfo) CollectionsKt.firstOrNull((List) list)) == null) ? null : paySearchInfo.getCategory();
        return category == null ? "" : category;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final SearchResultModel MyBillsEntityDataFactory(SearchResult searchResult, Context context, boolean z, int i, boolean z2) {
        String string;
        Intrinsics.checkNotNullParameter(searchResult, "");
        Intrinsics.checkNotNullParameter(context, "");
        String PlaceComponentResult = PlaceComponentResult(searchResult);
        switch (PlaceComponentResult.hashCode()) {
            case -1592831339:
                if (PlaceComponentResult.equals("SERVICE")) {
                    string = context.getString(R.string.services_title);
                    break;
                }
                string = context.getString(R.string.eazy_eats_restaurant_title);
                break;
            case -667013580:
                if (PlaceComponentResult.equals("ONLINE_MERCHANT")) {
                    string = context.getString(R.string.online_merchant_title);
                    break;
                }
                string = context.getString(R.string.eazy_eats_restaurant_title);
                break;
            case 1016896708:
                if (PlaceComponentResult.equals("OFFLINE_MERCHANT")) {
                    string = context.getString(R.string.nearby_merchants_title);
                    break;
                }
                string = context.getString(R.string.eazy_eats_restaurant_title);
                break;
            case 2014341056:
                if (PlaceComponentResult.equals("DF_SKU")) {
                    string = context.getString(R.string.eazy_eats_dishes_title);
                    break;
                }
                string = context.getString(R.string.eazy_eats_restaurant_title);
                break;
            default:
                string = context.getString(R.string.eazy_eats_restaurant_title);
                break;
        }
        String str = string;
        Intrinsics.checkNotNullExpressionValue(str, "");
        boolean builtInFictitiousFunctionClassFactory = searchResult.getBuiltInFictitiousFunctionClassFactory();
        List<PaySearchInfo> list = searchResult.PlaceComponentResult;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return new SearchResultModel(str, builtInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2(list, context), z, i, z2);
    }
}
