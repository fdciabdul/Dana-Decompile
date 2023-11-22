package com.iap.ac.android.acs.plugin.biz.region.stageinfo;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.biz.region.RegionConstants;
import com.iap.ac.android.acs.operation.biz.region.bean.ExceptionWrap;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.CategoryInfo;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.FetchStageInfoRepository;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.FetchStageInfosResult;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.StageAppInfo;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.StageContentInfo;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.StageInfo;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.CDPLaunchableItem;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableCategory;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableItem;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.MiniProgramLaunchableItem;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.container.IContainer;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.container.model.AppInfoData;
import com.iap.ac.android.common.container.model.AppInfoListData;
import com.iap.ac.android.common.container.model.CategoryInfoData;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.common.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class LaunchableGroupManager {
    public static final String ERROR_CODE_API_BANED = "10100";
    public static final String ERROR_CODE_ARGS_ERROR = "10102";
    public static final String ERROR_CODE_FETCH_APPINFO = "20101";
    public static final String ERROR_CODE_FETCH_STAGE = "20100";
    public static final String TAG = "LaunchableGroupManager";
    public static LaunchableGroupManager stageInfoManager;
    public final int CODE_NETWORK_ERROR = 10104;
    public final int CODE_SERVER_ERROR = 10105;
    public String TAG_RED_DOT = "RED_DOT";
    public String TAG_HOT = "HOT";
    public Handler handler = new Handler(Looper.getMainLooper());

    private LaunchableItem convertAppInfo(StageContentInfo stageContentInfo) {
        StageAppInfo stageAppInfo = stageContentInfo.appInfo;
        String str = stageContentInfo.contentType;
        str.hashCode();
        if (!str.equals("MINI_PROGRAM")) {
            if (str.equals("CDP") && stageContentInfo.spaceCode != null) {
                CDPLaunchableItem cDPLaunchableItem = new CDPLaunchableItem();
                cDPLaunchableItem.type = stageContentInfo.contentType;
                cDPLaunchableItem.spaceCode = stageContentInfo.spaceCode;
                return cDPLaunchableItem;
            }
            return null;
        } else if (stageAppInfo == null || stageAppInfo.identifier != null) {
            MiniProgramLaunchableItem miniProgramLaunchableItem = new MiniProgramLaunchableItem();
            miniProgramLaunchableItem.type = stageContentInfo.contentType;
            miniProgramLaunchableItem.identifier = stageAppInfo.identifier;
            miniProgramLaunchableItem.introduction = stageAppInfo.introduction;
            miniProgramLaunchableItem.name = stageAppInfo.name;
            miniProgramLaunchableItem.slogan = stageAppInfo.slogan;
            miniProgramLaunchableItem.releaseVersion = stageAppInfo.releaseVersion;
            miniProgramLaunchableItem.iconURL = stageAppInfo.iconURL;
            miniProgramLaunchableItem.isFavorite = stageAppInfo.isFavorite;
            miniProgramLaunchableItem.lastUsedTimestamp = stageAppInfo.lastUsedTimestamp;
            miniProgramLaunchableItem.isUsed = stageAppInfo.isUsed;
            ArrayList arrayList = new ArrayList();
            List<CategoryInfo> list = stageAppInfo.categories;
            if (list != null) {
                for (CategoryInfo categoryInfo : list) {
                    if (categoryInfo != null) {
                        LaunchableCategory launchableCategory = new LaunchableCategory();
                        launchableCategory.identifier = categoryInfo.identifier;
                        launchableCategory.name = categoryInfo.name;
                        launchableCategory.setCategory2(categoryInfo.getCategory2());
                        launchableCategory.setCategory3(categoryInfo.getCategory3());
                        launchableCategory.setCategoryCode2(categoryInfo.getCategoryCode2());
                        launchableCategory.setCategoryCode3(categoryInfo.getCategoryCode3());
                        arrayList.add(launchableCategory);
                    }
                }
                miniProgramLaunchableItem.categories = arrayList;
            }
            miniProgramLaunchableItem.spaceCode = stageContentInfo.spaceCode;
            return miniProgramLaunchableItem;
        } else {
            return null;
        }
    }

    private void convertStageInfoInner(LaunchableGroup launchableGroup, StageInfo stageInfo) {
        launchableGroup.code = stageInfo.stageCode;
        launchableGroup.displayName = stageInfo.displayName;
        Map<String, Object> map = stageInfo.layoutConfig;
        if (map != null && map.size() > 0) {
            launchableGroup.setLayoutConfig(stageInfo.layoutConfig);
        }
        if (stageInfo.contentInfoList != null) {
            ArrayList arrayList = new ArrayList();
            launchableGroup.launchableItems = arrayList;
            Iterator<StageContentInfo> it = stageInfo.contentInfoList.iterator();
            while (it.hasNext()) {
                StageContentInfo next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    LaunchableItem convertAppInfo = convertAppInfo(next);
                    if (convertAppInfo != null) {
                        arrayList.add(convertAppInfo);
                    }
                }
            }
            if (arrayList.size() == 0) {
                launchableGroup.launchableItems = null;
            }
        }
        List<StageInfo> list = stageInfo.subStageList;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (StageInfo stageInfo2 : list) {
                LaunchableGroup launchableGroup2 = new LaunchableGroup();
                convertStageInfoInner(launchableGroup2, stageInfo2);
                arrayList2.add(launchableGroup2);
            }
            if (arrayList2.size() > 0) {
                launchableGroup.launchableGroups = arrayList2;
            }
        }
    }

    public void excludeInvalidAppInfo(Map<String, LaunchableGroup> map) {
        List<LaunchableItem> list;
        for (LaunchableGroup launchableGroup : map.values()) {
            if (launchableGroup != null && (list = launchableGroup.launchableItems) != null && list.size() != 0) {
                Iterator<LaunchableItem> it = launchableGroup.launchableItems.iterator();
                while (it.hasNext()) {
                    LaunchableItem next = it.next();
                    if (next != null) {
                        if ("MINI_PROGRAM".equals(next.type) && ((MiniProgramLaunchableItem) next).identifier == null) {
                            it.remove();
                        }
                        if ("CDP".equals(next.type) && ((CDPLaunchableItem) next).spaceCode == null) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private List<String> getAppIds(FetchStageInfosResult fetchStageInfosResult) {
        ArrayList arrayList = new ArrayList();
        Map<String, StageInfo> map = fetchStageInfosResult.stageInfo;
        if (map == null || map.isEmpty() || map.values() == null) {
            return arrayList;
        }
        Iterator<StageInfo> it = map.values().iterator();
        while (it.hasNext()) {
            getAppIdsInner(it.next(), arrayList);
        }
        return new ArrayList(new LinkedHashSet(arrayList));
    }

    public int getExceptionCode(int i) {
        return (i == 4001 || i == 5000) ? 10104 : 10105;
    }

    public static LaunchableGroupManager getInstance() {
        if (stageInfoManager == null) {
            synchronized (LaunchableGroupManager.class) {
                if (stageInfoManager == null) {
                    stageInfoManager = new LaunchableGroupManager();
                }
            }
        }
        return stageInfoManager;
    }

    public void posetResultSuccess(final Map<String, LaunchableGroup> map, final FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            fetchLaunchableGroupsCallback.onResponse(map);
        } else {
            this.handler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager.3
                {
                    LaunchableGroupManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fetchLaunchableGroupsCallback.onResponse(map);
                }
            });
        }
    }

    public void postResultFailed(final String str, final String str2, final FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            fetchLaunchableGroupsCallback.onFailure(str, str2);
        } else {
            this.handler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager.4
                {
                    LaunchableGroupManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fetchLaunchableGroupsCallback.onFailure(str, str2);
                }
            });
        }
    }

    private void reassignAppInfo(MiniProgramLaunchableItem miniProgramLaunchableItem, StageContentInfo stageContentInfo, List<AppInfoData> list) {
        StageAppInfo stageAppInfo = stageContentInfo.appInfo;
        for (AppInfoData appInfoData : list) {
            if (appInfoData != null && appInfoData.getAppId() != null && stageAppInfo.appId.equals(appInfoData.getAppId())) {
                miniProgramLaunchableItem.introduction = appInfoData.getAppDesc();
                miniProgramLaunchableItem.name = appInfoData.getAppName();
                miniProgramLaunchableItem.slogan = appInfoData.getAppSlogan();
                miniProgramLaunchableItem.releaseVersion = appInfoData.getDeployVersion();
                miniProgramLaunchableItem.iconURL = appInfoData.getIconUrl();
                miniProgramLaunchableItem.identifier = appInfoData.getAppId();
                miniProgramLaunchableItem.isFavorite = stageAppInfo.isFavorite;
                miniProgramLaunchableItem.lastUsedTimestamp = stageAppInfo.lastUsedTimestamp;
                miniProgramLaunchableItem.isUsed = stageAppInfo.isUsed;
                List<CategoryInfoData> categoryInfos = appInfoData.getCategoryInfos();
                ArrayList arrayList = new ArrayList();
                if (categoryInfos != null && categoryInfos.size() > 0) {
                    for (CategoryInfoData categoryInfoData : categoryInfos) {
                        if (categoryInfoData != null) {
                            LaunchableCategory launchableCategory = new LaunchableCategory();
                            launchableCategory.name = categoryInfoData.getCategory();
                            launchableCategory.identifier = categoryInfoData.getCategoryId();
                            arrayList.add(launchableCategory);
                        }
                    }
                    miniProgramLaunchableItem.categories = arrayList;
                }
                miniProgramLaunchableItem.spaceCode = stageContentInfo.spaceCode;
                return;
            }
        }
    }

    public void reassignStageInfo(AppInfoListData appInfoListData, FetchStageInfosResult fetchStageInfosResult, Map<String, LaunchableGroup> map) {
        Map<String, StageInfo> map2 = fetchStageInfosResult.stageInfo;
        if (map == null) {
            map = new HashMap<>();
        }
        for (Map.Entry<String, StageInfo> entry : map2.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                StageInfo value = entry.getValue();
                LaunchableGroup launchableGroup = new LaunchableGroup();
                map.put(key, launchableGroup);
                reassignStageInfoInner(launchableGroup, value, appInfoListData.getAppInfoList());
            }
        }
    }

    private void reassignStageInfoInner(LaunchableGroup launchableGroup, StageInfo stageInfo, List<AppInfoData> list) {
        StageAppInfo stageAppInfo;
        launchableGroup.code = stageInfo.stageCode;
        launchableGroup.displayName = stageInfo.displayName;
        Map<String, Object> map = stageInfo.layoutConfig;
        if (map != null && map.size() > 0) {
            launchableGroup.setLayoutConfig(stageInfo.layoutConfig);
        }
        if (stageInfo.contentInfoList != null) {
            ArrayList arrayList = new ArrayList();
            launchableGroup.launchableItems = arrayList;
            Iterator<StageContentInfo> it = stageInfo.contentInfoList.iterator();
            while (it.hasNext()) {
                StageContentInfo next = it.next();
                if (next != null && (stageAppInfo = next.appInfo) != null && stageAppInfo.appId != null) {
                    MiniProgramLaunchableItem miniProgramLaunchableItem = new MiniProgramLaunchableItem();
                    reassignAppInfo(miniProgramLaunchableItem, next, list);
                    if (miniProgramLaunchableItem.identifier != null) {
                        arrayList.add(miniProgramLaunchableItem);
                    }
                } else {
                    it.remove();
                }
            }
            if (arrayList.size() == 0) {
                launchableGroup.launchableItems = null;
            }
        }
        List<StageInfo> list2 = stageInfo.subStageList;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (StageInfo stageInfo2 : list2) {
                LaunchableGroup launchableGroup2 = new LaunchableGroup();
                reassignStageInfoInner(launchableGroup2, stageInfo2, list);
                arrayList2.add(launchableGroup2);
            }
            if (arrayList2.size() > 0) {
                launchableGroup.launchableGroups = arrayList2;
            }
        }
    }

    public void convertResultToLaunchGroup(FetchStageInfosResult fetchStageInfosResult, FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, StageInfo> entry : fetchStageInfosResult.stageInfo.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                StageInfo value = entry.getValue();
                LaunchableGroup launchableGroup = new LaunchableGroup();
                hashMap.put(key, launchableGroup);
                convertStageInfoInner(launchableGroup, value);
            }
        }
        excludeInvalidAppInfo(hashMap);
        posetResultSuccess(hashMap, fetchLaunchableGroupsCallback);
    }

    public void fetchAppInfoListByIds(final FetchStageInfosResult fetchStageInfosResult, final FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        final HashMap hashMap = new HashMap();
        List<String> appIds = getAppIds(fetchStageInfosResult);
        if (appIds == null) {
            appIds = new ArrayList<>();
        }
        WebContainer.getInstance("ac_biz").fetchAppInfoListByIds(appIds, new Callback<AppInfoListData>() { // from class: com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager.2
            {
                LaunchableGroupManager.this = this;
            }

            @Override // com.iap.ac.android.common.container.callback.Callback
            public void onResultFailed(int i, String str) {
                String valueOf = i == 10104 ? String.valueOf(i) : LaunchableGroupManager.ERROR_CODE_FETCH_APPINFO;
                StringBuilder sb = new StringBuilder();
                sb.append("FetchAppInfosByIds error: ");
                sb.append(str);
                String obj = sb.toString();
                LaunchableGroupManager.this.postResultFailed(valueOf, obj, fetchLaunchableGroupsCallback);
                MonitorUtil.monitorRPCError("fetch_stage_info_error", valueOf, obj);
            }

            @Override // com.iap.ac.android.common.container.callback.Callback
            public void onResultSuccess(AppInfoListData appInfoListData) {
                if (appInfoListData != null && appInfoListData.getAppInfoList() != null && appInfoListData.getAppInfoList().size() != 0) {
                    LaunchableGroupManager.this.reassignStageInfo(appInfoListData, fetchStageInfosResult, hashMap);
                    LaunchableGroupManager.this.excludeInvalidAppInfo(hashMap);
                }
                LaunchableGroupManager.this.posetResultSuccess(hashMap, fetchLaunchableGroupsCallback);
            }
        });
    }

    public void fetchLaunchableGroupsWithCodes(final List<String> list, final FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback, final boolean z) {
        if (fetchLaunchableGroupsCallback == null) {
            ACLog.e(TAG, "callback is null");
        } else if (list != null && list.size() != 0) {
            if (!RegionRPCConfigCenter.INSTANCE.fetchStageInfoEnabled()) {
                postResultFailed("10100", "API is banned ", fetchLaunchableGroupsCallback);
            } else {
                IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager.1
                    {
                        LaunchableGroupManager.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean z2;
                        ExceptionWrap exceptionWrap = new ExceptionWrap(10105);
                        FetchStageInfosResult fetchStageInfosResult = null;
                        if (z) {
                            String launchGroupCacheKey = LaunchableGroupManager.this.getLaunchGroupCacheKey(list);
                            str = launchGroupCacheKey;
                            fetchStageInfosResult = LaunchableGroupManager.this.getLaunchGroupCache(launchGroupCacheKey);
                        } else {
                            str = null;
                        }
                        String str2 = LaunchableGroupManager.TAG;
                        StringBuilder a2 = a.a("get result is use cache function = ");
                        a2.append(z);
                        ACLog.d(str2, a2.toString());
                        if (fetchStageInfosResult == null) {
                            z2 = true;
                            fetchStageInfosResult = new FetchStageInfoRepository(exceptionWrap).fetchStageInfo(list);
                            ACLog.d(LaunchableGroupManager.TAG, "get result from net");
                        } else {
                            z2 = false;
                        }
                        if (fetchStageInfosResult == null) {
                            int exceptionCode = LaunchableGroupManager.this.getExceptionCode(exceptionWrap.exceptionCode);
                            String str3 = exceptionWrap.exceptionMsg;
                            LaunchableGroupManager.this.postResultFailed(String.valueOf(exceptionCode), str3, fetchLaunchableGroupsCallback);
                            MonitorUtil.monitorRPCError("fetch_stage_info_error", String.valueOf(exceptionCode), str3);
                        } else if (fetchStageInfosResult.success) {
                            LaunchableGroupManager.this.convertResultToLaunchGroup(fetchStageInfosResult, fetchLaunchableGroupsCallback);
                            if (z && str != null && z2) {
                                WebContainer.getInstance("ac_biz").setObject("batchQueryByStageCode", str, JsonUtils.toJson(fetchStageInfosResult), 1000 * fetchStageInfosResult.clientCacheExpireTime * 60);
                            }
                        } else {
                            StringBuilder a3 = a.a("BatchQueryByStageCode error: ");
                            a3.append(fetchStageInfosResult.errorMessage);
                            String obj = a3.toString();
                            MonitorUtil.monitorRPCError("fetch_stage_info_error", LaunchableGroupManager.ERROR_CODE_FETCH_STAGE, obj);
                            LaunchableGroupManager.this.postResultFailed(LaunchableGroupManager.ERROR_CODE_FETCH_STAGE, obj, fetchLaunchableGroupsCallback);
                        }
                    }
                });
            }
        } else {
            ACLog.e(TAG, "stageCodes size should be greater than zero");
            postResultFailed("10102", "Parameter is invalid", fetchLaunchableGroupsCallback);
        }
    }

    public void getAppIdsInner(StageInfo stageInfo, List<String> list) {
        StageAppInfo stageAppInfo;
        if (stageInfo != null) {
            if (stageInfo.contentInfoList == null && stageInfo.subStageList == null) {
                return;
            }
            List<StageInfo> list2 = stageInfo.subStageList;
            if (list2 != null) {
                Iterator<StageInfo> it = list2.iterator();
                while (it.hasNext()) {
                    getAppIdsInner(it.next(), list);
                }
            }
            List<StageContentInfo> list3 = stageInfo.contentInfoList;
            if (list3 == null) {
                return;
            }
            for (StageContentInfo stageContentInfo : list3) {
                if (stageContentInfo != null && (stageAppInfo = stageContentInfo.appInfo) != null) {
                    list.add(stageAppInfo.appId);
                }
            }
        }
    }

    public FetchStageInfosResult getLaunchGroupCache(String str) {
        int stageCacheVersion = RegionRPCConfigCenter.INSTANCE.getStageCacheVersion();
        String objectForKey = WebContainer.getInstance("ac_biz").objectForKey(RegionConstants.KEY_STAGE_CACHE_VERSION, RegionConstants.KEY_STAGE_CACHE_VERSION);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("get result use cache function amcs version = ");
        sb.append(stageCacheVersion);
        sb.append(" localVersion = ");
        sb.append(objectForKey);
        ACLog.d(str2, sb.toString());
        if (TextUtils.isEmpty(objectForKey) || Integer.valueOf(objectForKey).intValue() < stageCacheVersion) {
            WebContainer.getInstance("ac_biz").removeAllObjects("batchQueryByStageCode");
            IContainer webContainer = WebContainer.getInstance("ac_biz");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(stageCacheVersion);
            webContainer.setObject(RegionConstants.KEY_STAGE_CACHE_VERSION, RegionConstants.KEY_STAGE_CACHE_VERSION, sb2.toString(), -1L);
            ACLog.d(str2, "local version small then cloud version , clear all cache");
        }
        String objectForKey2 = WebContainer.getInstance("ac_biz").objectForKey("batchQueryByStageCode", str);
        try {
            if (TextUtils.isEmpty(objectForKey2)) {
                return null;
            }
            ACLog.d(str2, "get result from cache");
            return (FetchStageInfosResult) JsonUtils.fromJson(objectForKey2, FetchStageInfosResult.class);
        } catch (Exception unused) {
            ACLog.e(TAG, "parse cache to FetchStageInfosResult failed ");
            return null;
        }
    }

    public String getLaunchGroupCacheKey(List<String> list) {
        String openId = SPIManager.getInstance().getOpenId();
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(",");
            sb.append(sb2.toString());
        }
        if (openId == null) {
            openId = "";
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb.substring(0, sb.length() - 1));
        sb3.append("-");
        sb3.append(openId);
        return MiscUtils.md5(sb3.toString());
    }
}
