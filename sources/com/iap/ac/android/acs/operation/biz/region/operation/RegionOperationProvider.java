package com.iap.ac.android.acs.operation.biz.region.operation;

import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.operation.biz.region.bean.AddFavoriteResult;
import com.iap.ac.android.acs.operation.biz.region.bean.RemoveFavoriteResult;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.biz.region.menu.repository.AddFavoriteRepository;
import com.iap.ac.android.acs.operation.biz.region.menu.repository.RemoveFavoriteRepository;
import com.iap.ac.android.acs.operation.biz.region.operation.bean.LaunchableGroups;
import com.iap.ac.android.acs.operation.biz.region.operation.bean.QueryFavoriteApps;
import com.iap.ac.android.acs.operation.biz.region.operation.bean.QueryRecentlyUsedApps;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.FetchAllAppsResult;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.QueryFavoritesResult;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.QueryRecentlyUsedResult;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.RegionOperationRepository;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.RemoveRecentlyUsedResult;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.ReorderFavoritesResult;
import com.iap.ac.android.acs.operation.biz.region.operation.repository.SearchAppsByKeyWordResult;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RegionOperationProvider {
    public static final String TAG = "RegionOperationProvider";
    public final int CODE_SERVER_ERROR = 10105;
    public final String MSG_SERVER_ERROR = "Server error";
    public final int CODE_API_BANNED = 10100;
    public final String MSG_API_BANNED = "API is banned";
    public final int CODE_PARAMETER_INVALID = 10102;
    public final String MSG_PARAMETER_INVALID = "Parameters is invalid";
    public final int CODE_NETWORK_ERROR = 10104;
    public final String MSG_NETWORK_ERROR = "Network error";
    public final int CODE_BUSINESS_ERROR = 20200;
    public final int CODE_COLLECT_LIMIT = 100000;
    public final String SERVER_COLLECT_LIMIT = "AE15115113003200";
    public final String MSG_COLLECT_LIMIT = "The number of collections exceeds limit!";
    public final int CODE_COLLECTED = 100001;
    public final String SERVER_COLLECTED = "AE15115113003201";
    public final String MSG_COLLECTED = "App has been collected!";
    public final int CODE_COLLECT_COUNT_DIFF = 100002;
    public final String SERVER_COLLECT_COUNT_DIFF = "AE15115113003202";
    public final String MSG_COLLECT_COUNT_DIFF = "Favorite list size mismatch!";
    public final int CODE_COLLECT_CONTENT_DIFF = 100003;
    public final String SERVER_COLLECT_CONTENT_DIFF = "AE15115113003203";
    public final String MSG_COLLECT_CONTENT_DIFF = "Favorite list info mismatch!";
    public final int LIMIT_RECENT_USED = 20;

    private boolean checkRegionEnable(Callback<Bundle> callback) {
        if (RegionRPCConfigCenter.INSTANCE.getRegionBizToggle()) {
            return true;
        }
        callback.onResultFailed(10100, "API is banned");
        return false;
    }

    private boolean isInit(Callback<Bundle> callback) {
        boolean isInit = RegionManager.getInstance() instanceof RegionManager ? ((RegionManager) RegionManager.getInstance()).isInit() : false;
        if (!isInit) {
            callback.onResultFailed(10105, "Server error");
        }
        return isInit;
    }

    public void favoriteApp(String str, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (str != null && str.length() != 0) {
                AddFavoriteResult addFavorite = new AddFavoriteRepository(callback).addFavorite(str);
                if (addFavorite != null) {
                    if (addFavorite.success) {
                        Bundle bundle = new Bundle();
                        bundle.putString("result", JsonUtils.toJson(new Object()));
                        callback.onResultSuccess(bundle);
                        return;
                    } else if ("AE15115113003200".equals(addFavorite.errorCode)) {
                        callback.onResultFailed(100000, "The number of collections exceeds limit!");
                        return;
                    } else if ("AE15115113003201".equals(addFavorite.errorCode)) {
                        callback.onResultFailed(100001, "App has been collected!");
                        return;
                    } else {
                        callback.onResultFailed(20200, addFavorite.errorMessage);
                        return;
                    }
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void fetchFavoriteApps(Callback<Bundle> callback) {
        QueryFavoritesResult fetchFavoriteApps;
        if (isInit(callback) && checkRegionEnable(callback) && (fetchFavoriteApps = new RegionOperationRepository(callback).fetchFavoriteApps()) != null) {
            if (fetchFavoriteApps.success) {
                Bundle bundle = new Bundle();
                QueryFavoriteApps queryFavoriteApps = new QueryFavoriteApps();
                queryFavoriteApps.apps = fetchFavoriteApps.favoriteApps;
                bundle.putString("result", JsonUtils.toJson(queryFavoriteApps));
                callback.onResultSuccess(bundle);
                return;
            }
            callback.onResultFailed(20200, fetchFavoriteApps.errorMessage);
        }
    }

    public void fetchLaunchableGroups(List<String> list, final Callback<Bundle> callback) {
        LaunchableGroupManager.getInstance().fetchLaunchableGroupsWithCodes(list, new FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>>() { // from class: com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider.1
            @Override // com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback
            public void onFailure(String str, String str2) {
                int i = 20200;
                try {
                    i = Integer.parseInt(str);
                } catch (NumberFormatException unused) {
                    String str3 = RegionOperationProvider.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchLaunchableGroups:");
                    sb.append(20200);
                    sb.append(":");
                    sb.append(str2);
                    ACLog.e(str3, sb.toString());
                }
                if (i == 10104) {
                    str2 = "Network error";
                } else if (i == 10105) {
                    str2 = "Server error";
                }
                callback.onResultFailed(i, str2);
            }

            @Override // com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback
            public void onResponse(Map<String, LaunchableGroup> map) {
                LaunchableGroups launchableGroups = new LaunchableGroups();
                launchableGroups.groups = map;
                Bundle bundle = new Bundle();
                bundle.putSerializable("result", JsonUtils.toJson(launchableGroups));
                callback.onResultSuccess(bundle);
            }
        }, false);
    }

    public void fetchRecentlyUsedApps(long j, int i, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (j >= 0 && i >= 0) {
                QueryRecentlyUsedResult fetchRecentlyUsedApps = new RegionOperationRepository(callback).fetchRecentlyUsedApps(j, i);
                if (fetchRecentlyUsedApps != null) {
                    if (fetchRecentlyUsedApps.success) {
                        Bundle bundle = new Bundle();
                        QueryRecentlyUsedApps queryRecentlyUsedApps = new QueryRecentlyUsedApps();
                        queryRecentlyUsedApps.apps = fetchRecentlyUsedApps.recentlyUsedApps;
                        queryRecentlyUsedApps.hasMore = fetchRecentlyUsedApps.hasMore;
                        bundle.putString("result", JsonUtils.toJson(queryRecentlyUsedApps));
                        callback.onResultSuccess(bundle);
                        return;
                    }
                    callback.onResultFailed(20200, fetchRecentlyUsedApps.errorMessage);
                    return;
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void regionFetchAllApps(String str, int i, int i2, String str2, String str3, String str4, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (i >= 0 && i2 >= 0) {
                FetchAllAppsResult fetchAllApps = new RegionOperationRepository(callback).fetchAllApps(str, i, i2, str2, str3, str4);
                if (fetchAllApps != null) {
                    if (fetchAllApps.success) {
                        Bundle bundle = new Bundle();
                        fetchAllApps.apps = fetchAllApps.appInfos;
                        fetchAllApps.appInfos = null;
                        bundle.putString("result", JsonUtils.toJson(fetchAllApps));
                        callback.onResultSuccess(bundle);
                        return;
                    }
                    callback.onResultFailed(20200, fetchAllApps.errorMessage);
                    return;
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void regionSearchAppsByKeywords(String str, int i, int i2, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (!TextUtils.isEmpty(str) && i >= 0 && i2 >= 0) {
                SearchAppsByKeyWordResult searchAppsByKeyWord = new RegionOperationRepository(callback).searchAppsByKeyWord(str, i, i2);
                if (searchAppsByKeyWord != null) {
                    if (searchAppsByKeyWord.success) {
                        Bundle bundle = new Bundle();
                        searchAppsByKeyWord.apps = searchAppsByKeyWord.appInfos;
                        searchAppsByKeyWord.appInfos = null;
                        bundle.putString("result", JsonUtils.toJson(searchAppsByKeyWord));
                        callback.onResultSuccess(bundle);
                        return;
                    }
                    callback.onResultFailed(20200, searchAppsByKeyWord.errorMessage);
                    return;
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void removeRecentlyUsedApp(String str, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (str != null && str.length() != 0) {
                RemoveRecentlyUsedResult removeRecentlyUsedApp = new RegionOperationRepository(callback).removeRecentlyUsedApp(str);
                if (removeRecentlyUsedApp != null) {
                    if (removeRecentlyUsedApp.success) {
                        Bundle bundle = new Bundle();
                        bundle.putString("result", JsonUtils.toJson(new Object()));
                        callback.onResultSuccess(bundle);
                        return;
                    }
                    callback.onResultFailed(20200, removeRecentlyUsedApp.errorMessage);
                    return;
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void reorderFavoriteApps(List<String> list, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (list != null && list.size() != 0) {
                ReorderFavoritesResult reorderFavoriteApps = new RegionOperationRepository(callback).reorderFavoriteApps(list);
                if (reorderFavoriteApps != null) {
                    if (reorderFavoriteApps.success) {
                        Bundle bundle = new Bundle();
                        bundle.putString("result", JsonUtils.toJson(new Object()));
                        callback.onResultSuccess(bundle);
                        return;
                    } else if ("AE15115113003202".equals(reorderFavoriteApps.errorCode)) {
                        callback.onResultFailed(100002, "Favorite list size mismatch!");
                        return;
                    } else if ("AE15115113003203".equals(reorderFavoriteApps.errorCode)) {
                        callback.onResultFailed(100003, "Favorite list info mismatch!");
                        return;
                    } else {
                        callback.onResultFailed(20200, reorderFavoriteApps.errorMessage);
                        return;
                    }
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }

    public void unfavoriteApp(String str, Callback<Bundle> callback) {
        if (isInit(callback) && checkRegionEnable(callback)) {
            if (str != null && str.length() != 0) {
                RemoveFavoriteResult removeFavorite = new RemoveFavoriteRepository(callback).removeFavorite(str);
                if (removeFavorite != null) {
                    if (removeFavorite.success) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("result", JsonUtils.toJson(new Object()));
                        callback.onResultSuccess(bundle);
                        return;
                    }
                    callback.onResultFailed(20200, removeFavorite.errorMessage);
                    return;
                }
                return;
            }
            callback.onResultFailed(10102, "Parameters is invalid");
        }
    }
}
