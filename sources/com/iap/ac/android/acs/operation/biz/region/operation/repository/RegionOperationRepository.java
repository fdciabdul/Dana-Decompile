package com.iap.ac.android.acs.operation.biz.region.operation.repository;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.FacadeRepository;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import java.util.List;

/* loaded from: classes3.dex */
public class RegionOperationRepository extends FacadeRepository {
    public static final String TAG = "RegionOperationRepository";

    public RegionOperationRepository(Callback<Bundle> callback) {
        this.callback = callback;
    }

    public FetchAllAppsResult fetchAllApps(String str, int i, int i2, String str2, String str3, String str4) {
        try {
            RegionOperationFacade regionOperationFacade = (RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz");
            FetchAllAppsRequest fetchAllAppsRequest = new FetchAllAppsRequest();
            fetchAllAppsRequest.category = str;
            fetchAllAppsRequest.queryStartIndex = i;
            fetchAllAppsRequest.querySize = i2;
            fetchAllAppsRequest.orderKey = str2;
            fetchAllAppsRequest.orderType = str3;
            fetchAllAppsRequest.sourceStageCode = str4;
            return regionOperationFacade.fetchAllApps(fetchAllAppsRequest);
        } catch (Throwable th) {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("fetchAllApps error:");
            sb.append(th);
            ACLog.e(str5, sb.toString());
            handleException(th);
            return null;
        }
    }

    public QueryFavoritesResult fetchFavoriteApps() {
        try {
            return ((RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz")).fetchFavoriteApps(new QueryFavoritesRequest());
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("fetchFavoriteApps error:");
            sb.append(th);
            ACLog.e(str, sb.toString());
            handleException(th);
            return null;
        }
    }

    public QueryRecentlyUsedResult fetchRecentlyUsedApps(long j, int i) {
        try {
            RegionOperationFacade regionOperationFacade = (RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz");
            QueryRecentlyUsedRequest queryRecentlyUsedRequest = new QueryRecentlyUsedRequest();
            queryRecentlyUsedRequest.cursor = j;
            queryRecentlyUsedRequest.maxCount = i;
            return regionOperationFacade.fetchRecentlyUsedApps(queryRecentlyUsedRequest);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("fetchRecentlyUsedApps error:");
            sb.append(th);
            ACLog.e(str, sb.toString());
            handleException(th);
            return null;
        }
    }

    public RemoveRecentlyUsedResult removeRecentlyUsedApp(String str) {
        try {
            RegionOperationFacade regionOperationFacade = (RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz");
            RemoveRecentlyUsedRequest removeRecentlyUsedRequest = new RemoveRecentlyUsedRequest();
            removeRecentlyUsedRequest.appId = str;
            return regionOperationFacade.removeRecentlyUsedApp(removeRecentlyUsedRequest);
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("removeRecentlyUsedApp error:");
            sb.append(th);
            ACLog.e(str2, sb.toString());
            handleException(th);
            return null;
        }
    }

    public ReorderFavoritesResult reorderFavoriteApps(List<String> list) {
        try {
            RegionOperationFacade regionOperationFacade = (RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz");
            ReorderFavoritesRequest reorderFavoritesRequest = new ReorderFavoritesRequest();
            reorderFavoritesRequest.appIdList = list;
            return regionOperationFacade.reorderFavoriteApps(reorderFavoritesRequest);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("reorderFavoriteApps error:");
            sb.append(th);
            ACLog.e(str, sb.toString());
            handleException(th);
            return null;
        }
    }

    public SearchAppsByKeyWordResult searchAppsByKeyWord(String str, int i, int i2) {
        try {
            RegionOperationFacade regionOperationFacade = (RegionOperationFacade) RPCProxyHost.getInterfaceProxy(RegionOperationFacade.class, "region_biz");
            SearchAppsByKeyWordRequest searchAppsByKeyWordRequest = new SearchAppsByKeyWordRequest();
            searchAppsByKeyWordRequest.keyword = str;
            searchAppsByKeyWordRequest.queryStartIndex = i;
            searchAppsByKeyWordRequest.querySize = i2;
            return regionOperationFacade.searchAppsByKeyWord(searchAppsByKeyWordRequest);
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("searchAppsByKeyWordResult error:");
            sb.append(th);
            ACLog.e(str2, sb.toString());
            handleException(th);
            return null;
        }
    }
}
