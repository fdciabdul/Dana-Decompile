package id.dana.explore.data.globalsearch.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.explore.data.globalsearch.source.network.request.AutoCompleteRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.HistoricalSkuRequest;
import id.dana.explore.data.globalsearch.source.network.request.RecommendationExploreRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.SearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.TrendingSearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.result.AutoCompleteResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.HistoricalSkuResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.SearchResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.TrendingSearchResultEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/SearchFacade;", "", "Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;", "autoCompleteRequestEntity", "Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "autoCompleteQuery", "(Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;)Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "Lid/dana/explore/data/globalsearch/source/network/request/HistoricalSkuRequest;", "historicalSkuRequest", "Lid/dana/explore/data/globalsearch/source/network/result/HistoricalSkuResultEntity;", "getHistoricalSku", "(Lid/dana/explore/data/globalsearch/source/network/request/HistoricalSkuRequest;)Lid/dana/explore/data/globalsearch/source/network/result/HistoricalSkuResultEntity;", "Lid/dana/explore/data/globalsearch/source/network/request/RecommendationExploreRequestEntity;", "recommendationExploreRequestEntity", "Lid/dana/explore/data/globalsearch/source/network/result/SearchResultEntity;", "getRecommendationExplore", "(Lid/dana/explore/data/globalsearch/source/network/request/RecommendationExploreRequestEntity;)Lid/dana/explore/data/globalsearch/source/network/result/SearchResultEntity;", "Lid/dana/explore/data/globalsearch/source/network/request/TrendingSearchRequestEntity;", "trendingSearchRequestEntity", "Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchResultEntity;", "getTrendingSearch", "(Lid/dana/explore/data/globalsearch/source/network/request/TrendingSearchRequestEntity;)Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchResultEntity;", "Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;", "searchRequestEntity", "searchQuery", "(Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;)Lid/dana/explore/data/globalsearch/source/network/result/SearchResultEntity;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SearchFacade {
    @OperationType("id.dana.danasearch.search.paysearch.autocomplete")
    @SignCheck
    AutoCompleteResultEntity autoCompleteQuery(AutoCompleteRequestEntity autoCompleteRequestEntity);

    @OperationType("alipayplus.mobilewallet.product.query.successful.biz.ids")
    @SignCheck
    HistoricalSkuResultEntity getHistoricalSku(HistoricalSkuRequest historicalSkuRequest);

    @OperationType("id.dana.explore.recommendation.user")
    @SignCheck
    SearchResultEntity getRecommendationExplore(RecommendationExploreRequestEntity recommendationExploreRequestEntity);

    @OperationType("id.dana.danasearch.search.trending")
    @SignCheck
    TrendingSearchResultEntity getTrendingSearch(TrendingSearchRequestEntity trendingSearchRequestEntity);

    @OperationType("id.dana.danasearch.search.paysearch")
    @SignCheck
    SearchResultEntity searchQuery(SearchRequestEntity searchRequestEntity);
}
