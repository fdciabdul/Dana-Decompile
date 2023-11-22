package id.dana.explore.data.globalsearch;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.explore.data.globalsearch.source.network.request.AutoCompleteRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.RecommendationExploreRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.SearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.result.AutoCompleteResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.HistoricalSkuResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.SearchResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.TrendingSearchResultEntity;
import id.dana.explore.data.sku.repository.source.network.response.ProductMappingEntityResult;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000f0\u0003H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lid/dana/explore/data/globalsearch/GlobalSearchEntityData;", "", "getAutoCompleteResult", "Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "autoCompleteRequestEntity", "Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;", "getHistoricalSku", "Lid/dana/explore/data/globalsearch/source/network/result/HistoricalSkuResultEntity;", "profileKeys", "", "", "profileKeyMaxResult", "", "getProductCode", "", "Lid/dana/explore/data/sku/repository/source/network/response/ProductMappingEntityResult;", "getRecommendationInfo", "Lid/dana/explore/data/globalsearch/source/network/result/SearchResultEntity;", "request", "Lid/dana/explore/data/globalsearch/source/network/request/RecommendationExploreRequestEntity;", "getSearchResult", "searchRequestEntity", "Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;", "getTrendingSearch", "Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchResultEntity;", "page", GriverMonitorConstants.KEY_SIZE, "feature-explore_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSearchEntityData {
    Observable<Map<String, ProductMappingEntityResult>> BuiltInFictitiousFunctionClassFactory();

    Observable<SearchResultEntity> KClassImpl$Data$declaredNonStaticMembers$2(RecommendationExploreRequestEntity recommendationExploreRequestEntity);

    Observable<SearchResultEntity> KClassImpl$Data$declaredNonStaticMembers$2(SearchRequestEntity searchRequestEntity);

    Observable<TrendingSearchResultEntity> MyBillsEntityDataFactory();

    Observable<HistoricalSkuResultEntity> PlaceComponentResult(List<String> list);

    Observable<AutoCompleteResultEntity> getAuthRequestContext(AutoCompleteRequestEntity autoCompleteRequestEntity);
}
