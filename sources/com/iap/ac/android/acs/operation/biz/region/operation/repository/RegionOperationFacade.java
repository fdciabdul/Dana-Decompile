package com.iap.ac.android.acs.operation.biz.region.operation.repository;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;

/* loaded from: classes3.dex */
public interface RegionOperationFacade {
    public static final String OPERATION_TYPE_FETCH_ALL_APPS = "eco.region.client.miniprogram.queryAllApps";
    public static final String OPERATION_TYPE_QUERY_ALL_APPS = "eco.region.client.miniprogram.queryAllApps";
    public static final String OPERATION_TYPE_QUERY_FAVORITE = "eco.region.client.favorite.queryFavorites";
    public static final String OPERATION_TYPE_QUERY_RECENTLY_USED_APPS = "eco.region.client.recentlyused.queryRecentlyUsedApps";
    public static final String OPERATION_TYPE_REMOVE_RECENTLY_USED_APP = "eco.region.client.recentlyused.removeRecentlyUsedApp";
    public static final String OPERATION_TYPE_REORDER_FAVORITE = "eco.region.client.favorite.reorderFavorites";
    public static final String OPERATION_TYPE_SEARCH_APPS_BY_KEYWORDS = "eco.region.client.miniprogram.search";

    @ACRpcRequest
    @OperationType("eco.region.client.miniprogram.queryAllApps")
    @SignCheck
    FetchAllAppsResult fetchAllApps(FetchAllAppsRequest fetchAllAppsRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_QUERY_FAVORITE)
    @SignCheck
    QueryFavoritesResult fetchFavoriteApps(QueryFavoritesRequest queryFavoritesRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_QUERY_RECENTLY_USED_APPS)
    @SignCheck
    QueryRecentlyUsedResult fetchRecentlyUsedApps(QueryRecentlyUsedRequest queryRecentlyUsedRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_REMOVE_RECENTLY_USED_APP)
    @SignCheck
    RemoveRecentlyUsedResult removeRecentlyUsedApp(RemoveRecentlyUsedRequest removeRecentlyUsedRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_REORDER_FAVORITE)
    @SignCheck
    ReorderFavoritesResult reorderFavoriteApps(ReorderFavoritesRequest reorderFavoritesRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_SEARCH_APPS_BY_KEYWORDS)
    @SignCheck
    SearchAppsByKeyWordResult searchAppsByKeyWord(SearchAppsByKeyWordRequest searchAppsByKeyWordRequest);
}
