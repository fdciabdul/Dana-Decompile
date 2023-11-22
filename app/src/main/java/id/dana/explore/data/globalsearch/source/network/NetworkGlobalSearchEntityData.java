package id.dana.explore.data.globalsearch.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.explore.data.globalsearch.GlobalSearchEntityData;
import id.dana.explore.data.globalsearch.source.network.request.AutoCompleteRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.HistoricalSkuRequest;
import id.dana.explore.data.globalsearch.source.network.request.RecommendationExploreRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.SearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.TrendingSearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.result.AutoCompleteResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.HistoricalSkuResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.SearchResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.TrendingSearchResultEntity;
import id.dana.explore.data.sku.repository.source.network.ExploreDanaApi;
import id.dana.explore.data.sku.repository.source.network.response.ProductMappingEntityResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\"\u0012\u0006\u0010\u0010\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020 ¢\u0006\u0004\b)\u0010*J\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00140\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0005\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0005\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001a\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0017R\u0014\u0010\b\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010!"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/NetworkGlobalSearchEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/explore/data/globalsearch/source/network/SearchFacade;", "Lid/dana/explore/data/globalsearch/GlobalSearchEntityData;", "Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;", "p0", "Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "getAuthRequestContext", "(Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "", "", "p1", "Lid/dana/explore/data/globalsearch/source/network/result/HistoricalSkuResultEntity;", "PlaceComponentResult", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "Lid/dana/explore/data/sku/repository/source/network/response/ProductMappingEntityResult;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/source/network/request/RecommendationExploreRequestEntity;", "Lid/dana/explore/data/globalsearch/source/network/result/SearchResultEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/explore/data/globalsearch/source/network/request/RecommendationExploreRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;", "(Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchResultEntity;", "MyBillsEntityDataFactory", "Lid/dana/explore/data/sku/repository/source/network/ExploreDanaApi;", "Lid/dana/explore/data/sku/repository/source/network/ExploreDanaApi;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "p4", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/explore/data/sku/repository/source/network/ExploreDanaApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkGlobalSearchEntityData extends SecureBaseNetwork<SearchFacade> implements GlobalSearchEntityData {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ExploreDanaApi getAuthRequestContext;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<SearchFacade> getFacadeClass() {
        return SearchFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkGlobalSearchEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, ExploreDanaApi exploreDanaApi) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(exploreDanaApi, "");
        this.getAuthRequestContext = exploreDanaApi;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<SearchResultEntity> KClassImpl$Data$declaredNonStaticMembers$2(SearchRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final SearchRequestEntity searchRequestEntity = new SearchRequestEntity(null, null, null, null, null, 31, null);
        searchRequestEntity.setSearchConditionList(p0.getSearchConditionList());
        searchRequestEntity.setPage(p0.getPage());
        searchRequestEntity.setSize(p0.getSize());
        searchRequestEntity.setSort(p0.getSort());
        searchRequestEntity.envInfo = generateMobileEnvInfo();
        searchRequestEntity.setUserId(p0.getUserId());
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkGlobalSearchEntityData.KClassImpl$Data$declaredNonStaticMembers$2(SearchRequestEntity.this, (SearchFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<AutoCompleteResultEntity> getAuthRequestContext(AutoCompleteRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final AutoCompleteRequestEntity autoCompleteRequestEntity = new AutoCompleteRequestEntity(p0.getContextConditions(), p0.getSearchType(), p0.getSuggestKeyword(), p0.getPage(), p0.getSize());
        MobileEnvInfo generateMobileEnvInfo = generateMobileEnvInfo();
        generateMobileEnvInfo.locationInfo = null;
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        autoCompleteRequestEntity.envInfo = generateMobileEnvInfo;
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkGlobalSearchEntityData.KClassImpl$Data$declaredNonStaticMembers$2(AutoCompleteRequestEntity.this, (SearchFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<HistoricalSkuResultEntity> PlaceComponentResult(final List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        final int i = 1;
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor(list, i, this) { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda5
            public final /* synthetic */ NetworkGlobalSearchEntityData KClassImpl$Data$declaredNonStaticMembers$2;
            public final /* synthetic */ List PlaceComponentResult;
            public final /* synthetic */ int getAuthRequestContext = 1;

            {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            }

            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkGlobalSearchEntityData.MyBillsEntityDataFactory(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, (SearchFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map PlaceComponentResult(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "");
        try {
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jsonElement.toString(), null), new TypeToken<Map<String, ? extends ProductMappingEntityResult>>() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$getProductCode$lambda-6$$inlined$toMap$default$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            return (Map) fromJson;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<Map<String, ProductMappingEntityResult>> BuiltInFictitiousFunctionClassFactory() {
        Observable map = this.getAuthRequestContext.PlaceComponentResult().map(new Function() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map PlaceComponentResult;
                PlaceComponentResult = NetworkGlobalSearchEntityData.PlaceComponentResult((JsonElement) obj);
                return PlaceComponentResult;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<TrendingSearchResultEntity> MyBillsEntityDataFactory() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda4
            public final /* synthetic */ int getAuthRequestContext = 1;
            public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2 = 10;

            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkGlobalSearchEntityData.PlaceComponentResult(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, NetworkGlobalSearchEntityData.this, (SearchFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchEntityData
    public final Observable<SearchResultEntity> KClassImpl$Data$declaredNonStaticMembers$2(final RecommendationExploreRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkGlobalSearchEntityData.PlaceComponentResult(RecommendationExploreRequestEntity.this, this, (SearchFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ AutoCompleteResultEntity KClassImpl$Data$declaredNonStaticMembers$2(AutoCompleteRequestEntity autoCompleteRequestEntity, SearchFacade searchFacade) {
        Intrinsics.checkNotNullParameter(autoCompleteRequestEntity, "");
        return searchFacade.autoCompleteQuery(autoCompleteRequestEntity);
    }

    public static /* synthetic */ TrendingSearchResultEntity PlaceComponentResult(int i, int i2, NetworkGlobalSearchEntityData networkGlobalSearchEntityData, SearchFacade searchFacade) {
        Intrinsics.checkNotNullParameter(networkGlobalSearchEntityData, "");
        TrendingSearchRequestEntity trendingSearchRequestEntity = new TrendingSearchRequestEntity(Integer.valueOf(i), Integer.valueOf(i2));
        trendingSearchRequestEntity.envInfo = networkGlobalSearchEntityData.generateMobileEnvInfo();
        return searchFacade.getTrendingSearch(trendingSearchRequestEntity);
    }

    public static /* synthetic */ SearchResultEntity PlaceComponentResult(RecommendationExploreRequestEntity recommendationExploreRequestEntity, NetworkGlobalSearchEntityData networkGlobalSearchEntityData, SearchFacade searchFacade) {
        Intrinsics.checkNotNullParameter(recommendationExploreRequestEntity, "");
        Intrinsics.checkNotNullParameter(networkGlobalSearchEntityData, "");
        recommendationExploreRequestEntity.envInfo = networkGlobalSearchEntityData.generateMobileEnvInfo();
        return searchFacade.getRecommendationExplore(recommendationExploreRequestEntity);
    }

    public static /* synthetic */ SearchResultEntity KClassImpl$Data$declaredNonStaticMembers$2(SearchRequestEntity searchRequestEntity, SearchFacade searchFacade) {
        Intrinsics.checkNotNullParameter(searchRequestEntity, "");
        return searchFacade.searchQuery(searchRequestEntity);
    }

    public static /* synthetic */ HistoricalSkuResultEntity MyBillsEntityDataFactory(List list, int i, NetworkGlobalSearchEntityData networkGlobalSearchEntityData, SearchFacade searchFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(networkGlobalSearchEntityData, "");
        HistoricalSkuRequest historicalSkuRequest = new HistoricalSkuRequest(list, i);
        historicalSkuRequest.envInfo = networkGlobalSearchEntityData.generateMobileEnvInfo();
        return searchFacade.getHistoricalSku(historicalSkuRequest);
    }
}
