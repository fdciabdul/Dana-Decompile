package com.alibaba.griver.base.resource.predownload;

import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.predownloadstorage.GriverAppInfoPreDownloadStorage;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.fetcher.ConfigNotifyCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppPreDownloadCacheManager {
    public static final String TAG = "AppPreDownloadCacheManager";

    public static List<AppModel> requestAppWithAppId(List<String> list, long j) {
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : list) {
            if ((System.currentTimeMillis() - GriverAppInfoPreDownloadStorage.queryLastRefreshTimestamp(str)) / 1000 > j) {
                arrayList2.add(str);
            } else {
                arrayList.add(GriverAppInfoPreDownloadStorage.queryHighestAppInfo(str));
            }
        }
        if (arrayList2.size() == 0) {
            GriverLogger.d(TAG, "no need update app info");
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("requestAppWithAppId appIds:");
        sb.append(JSON.toJSONString(arrayList2));
        GriverLogger.d(TAG, sb.toString());
        UpdateAppParam updateAppParam = new UpdateAppParam(null, null);
        HashMap hashMap = new HashMap();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            hashMap.put((String) it.next(), "");
        }
        updateAppParam.setRequestApps(hashMap);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        a(arrayList2, new UpdateAppCallback() { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadCacheManager.1
            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public final void onSuccess(List<AppModel> list2) {
                if (list2 != null && list2.size() > 0) {
                    arrayList.addAll(list2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("async update success appInfos = ");
                    sb2.append(JSON.toJSONString(list2));
                    GriverLogger.w(AppPreDownloadCacheManager.TAG, sb2.toString());
                    GriverAppInfoPreDownloadStorage.saveAppInfos(list2);
                } else {
                    GriverLogger.w(AppPreDownloadCacheManager.TAG, "async update success but result is null");
                }
                countDownLatch.countDown();
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public final void onError(UpdateAppException updateAppException) {
                GriverLogger.w(AppPreDownloadCacheManager.TAG, "async update failed with exception", updateAppException);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AppPreDownloadCacheManager#requestAppWithAppId");
            sb2.append(e);
            GriverLogger.e(TAG, sb2.toString());
        }
        return arrayList;
    }

    private static void a(List<String> list, final UpdateAppCallback updateAppCallback) {
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("mini.");
            sb.append(str);
            linkedList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("refresh apps: ");
        sb2.append(JSON.toJSONString(linkedList));
        GriverLogger.d(TAG, sb2.toString());
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("reference", GriverAccount.getUserId());
        } catch (Throwable unused) {
            hashMap.put("reference", "");
            GriverLogger.e(TAG, "can not get the openId");
        }
        ConfigCenter.getInstance("GriverAppContainer").refreshByKeys("", linkedList, hashMap, new ConfigNotifyCallback() { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadCacheManager.2
            @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
            public final void onFetchSuccess(JSONObject jSONObject) {
                LinkedList linkedList2 = new LinkedList();
                if (jSONObject != null && jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        try {
                            linkedList2.add((AppModel) JSON.parseObject(jSONObject.getJSONObject(keys.next()).toString(), AppModel.class));
                        } catch (Exception e) {
                            GriverLogger.e(AppPreDownloadCacheManager.TAG, "parse app info failed", e);
                        }
                    }
                }
                UpdateAppCallback updateAppCallback2 = updateAppCallback;
                if (updateAppCallback2 != null) {
                    updateAppCallback2.onSuccess(linkedList2);
                }
            }

            @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
            public final void onFetchFailed(String str2, String str3) {
                UpdateAppCallback updateAppCallback2 = updateAppCallback;
                if (updateAppCallback2 != null) {
                    updateAppCallback2.onError(new UpdateAppException("0", "fetch failed"));
                }
            }
        }, false, true);
    }
}
