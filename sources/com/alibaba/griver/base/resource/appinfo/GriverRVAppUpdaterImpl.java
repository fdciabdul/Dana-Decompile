package com.alibaba.griver.base.resource.appinfo;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginParam;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.resource.appinfo.AppInfoConstants;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.fetcher.ConfigNotifyCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GriverRVAppUpdaterImpl implements IAppUpdater {
    @Override // com.alibaba.ariver.resource.api.appinfo.IAppUpdater
    public void updatePlugin(UpdatePluginParam updatePluginParam, UpdatePluginCallback updatePluginCallback) {
    }

    @Override // com.alibaba.ariver.resource.api.appinfo.IAppUpdater
    public void updateApp(final UpdateAppParam updateAppParam, final UpdateAppCallback updateAppCallback) {
        if (updateAppParam == null || updateAppParam.getRequestApps() == null || updateAppParam.getRequestApps().size() == 0) {
            GriverLogger.w("GriverRVAppUpdaterImpl", "update app param is null, callback error directly");
            if (updateAppCallback != null) {
                updateAppCallback.onError(new UpdateAppException("0", "params error"));
                return;
            }
            return;
        }
        GriverExecutors.getExecutor(updateAppParam.isForce() ? ExecutorType.URGENT : ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appinfo.GriverRVAppUpdaterImpl.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                Pair<String, String> requestMainPackage = updateAppParam.getRequestMainPackage();
                if (requestMainPackage != null && requestMainPackage.getAuthRequestContext != null) {
                    hashMap.put(requestMainPackage.getAuthRequestContext, requestMainPackage.PlaceComponentResult);
                }
                final Map<String, String> requestApps = updateAppParam.getRequestApps();
                if (requestApps != null && requestApps.size() > 0) {
                    hashMap.putAll(requestApps);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                GriverRVAppUpdaterImpl.a(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.griver.base.resource.appinfo.GriverRVAppUpdaterImpl.1.1
                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onSuccess(List<AppModel> list) {
                        boolean z;
                        if (list == null || list.size() == 0) {
                            GriverLogger.d("GriverRVAppUpdaterImpl", "app info not exist");
                            a("1", "app info not exist");
                            return;
                        }
                        LinkedList<AppModel> linkedList = new LinkedList();
                        Bundle extras = updateAppParam.getExtras();
                        ArrayList<AppModel> arrayList = new ArrayList();
                        if (extras != null && (AppInfoScene.isDevSource(extras) || !TextUtils.isEmpty(GriverEnv.getEnvironment()))) {
                            for (AppModel appModel : list) {
                                if (appModel.getAppInfoModel() == null) {
                                    arrayList.add(appModel);
                                } else {
                                    appModel.setAppInfoModel(appModel.getAppInfoModel());
                                    if (AppInfoUtils.isValid(appModel) && 2 == AppInfoUtils.getAppType(appModel)) {
                                        linkedList.add(appModel);
                                    } else {
                                        arrayList.add(appModel);
                                    }
                                }
                            }
                        } else {
                            for (AppModel appModel2 : list) {
                                if (appModel2.getAppInfoModel() == null) {
                                    arrayList.add(appModel2);
                                } else {
                                    appModel2.setAppInfoModel(appModel2.getAppInfoModel());
                                    if (AppInfoUtils.isValid(appModel2) && 2 == AppInfoUtils.getAppType(appModel2)) {
                                        List<AppModel> queryAppInfo = GriverAppCenter.queryAppInfo(appModel2.getAppId());
                                        if (queryAppInfo != null && queryAppInfo.size() > 0) {
                                            for (AppModel appModel3 : queryAppInfo) {
                                                if (appModel3 != null && RVResourceUtils.compareVersion(appModel3.getAppVersion(), appModel2.getAppInfoModel().getVersion()) > 0) {
                                                    arrayList.add(appModel2);
                                                    z = false;
                                                    break;
                                                }
                                            }
                                        }
                                        z = true;
                                        if (z) {
                                            linkedList.add(appModel2);
                                        } else {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("received a low version of ");
                                            sb.append(appModel2.getAppVersion());
                                            RVLogger.w("GriverRVAppUpdaterImpl", sb.toString());
                                            if (GriverEnv.isDebuggable()) {
                                                Application applicationContext = GriverEnv.getApplicationContext();
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(appModel2.getAppId());
                                                sb2.append(" is not the latest version.");
                                                ToastUtils.showToast(applicationContext, sb2.toString(), 0);
                                            }
                                        }
                                    } else {
                                        arrayList.add(appModel2);
                                    }
                                }
                            }
                            GriverAppCenter.saveAppInfos(linkedList);
                        }
                        if (linkedList.size() == 0) {
                            GriverLogger.w("GriverRVAppUpdaterImpl", "no valid app info");
                            a("1", "no valid app info");
                            return;
                        }
                        if (arrayList.size() > 0) {
                            for (AppModel appModel4 : arrayList) {
                                MonitorMap.Builder builder = new MonitorMap.Builder();
                                builder.appId(appModel4.getAppId()).version(appModel4).needAsynAppType(true);
                                builder.message("no valid app info").code("1");
                                builder.cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                GriverMonitor.error(GriverMonitorConstants.ERROR_FETCH_APP_EXCEPTION, "GriverAppContainer", builder.build());
                            }
                        }
                        if (updateAppCallback != null) {
                            updateAppCallback.onSuccess(linkedList);
                        }
                        for (AppModel appModel5 : linkedList) {
                            MonitorMap.Builder builder2 = new MonitorMap.Builder();
                            builder2.appId(appModel5.getAppId()).version(appModel5).needAsynAppType(true).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            GriverMonitor.event(GriverMonitorConstants.EVENT_FETCH_APP_SUCCESS, "GriverAppContainer", builder2.build());
                        }
                    }

                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onError(UpdateAppException updateAppException) {
                        if (updateAppCallback != null) {
                            if (updateAppParam.getUpdateMode() == UpdateMode.SYNC_TRY) {
                                updateAppException.setNeedShowError(false);
                            }
                            updateAppCallback.onError(updateAppException);
                        }
                    }

                    private void a(String str, String str2) {
                        onError(new UpdateAppException(str, str2));
                        for (Map.Entry entry : requestApps.entrySet()) {
                            MonitorMap.Builder builder = new MonitorMap.Builder();
                            builder.appId((String) entry.getKey()).version((String) entry.getValue()).deployVersion((String) entry.getValue()).needAsynAppType(true);
                            builder.message(str2).code(str);
                            builder.cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            GriverMonitor.error(GriverMonitorConstants.ERROR_FETCH_APP_EXCEPTION, "GriverAppContainer", builder.build());
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(UpdateAppParam updateAppParam, final UpdateAppCallback updateAppCallback) {
        final Map<String, String> requestApps = updateAppParam.getRequestApps();
        LinkedList linkedList = new LinkedList();
        Bundle extras = updateAppParam.getExtras();
        if (extras != null && AppInfoScene.isDevSource(extras)) {
            Iterator<Map.Entry<String, String>> it = requestApps.entrySet().iterator();
            while (it.hasNext()) {
                String format = String.format("mini-%s-%s-%s.%s", BundleUtils.getString(extras, AppInfoScene.PARAM_SCENE), AppInfoScene.extractSceneVersion(extras), BundleUtils.getString(extras, AppInfoConstants.ARIVER_TOKEN), it.next().getKey());
                if (!TextUtils.isEmpty(GriverEnv.getEnvironment()) && !"prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(format);
                    sb.append(".");
                    sb.append(GriverEnv.getEnvironment());
                    format = sb.toString();
                }
                linkedList.add(format);
            }
        } else if (!TextUtils.isEmpty(GriverEnv.getEnvironment()) && !"prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim())) {
            for (Map.Entry<String, String> entry : requestApps.entrySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("mini.");
                sb2.append(entry.getKey());
                sb2.append(".");
                sb2.append(GriverEnv.getEnvironment());
                linkedList.add(sb2.toString());
            }
        } else {
            for (Map.Entry<String, String> entry2 : requestApps.entrySet()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("mini.");
                sb3.append(entry2.getKey());
                linkedList.add(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("refresh apps: ");
        sb4.append(JSON.toJSONString(linkedList));
        GriverLogger.d("GriverRVAppUpdaterImpl", sb4.toString());
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("reference", GriverAccount.getUserId());
        } catch (Throwable unused) {
            hashMap.put("reference", "");
            GriverLogger.e("GriverRVAppUpdaterImpl", "can not get the openId");
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ConfigCenter.getInstance("GriverAppContainer").refreshByKeys(linkedList, hashMap, new ConfigNotifyCallback() { // from class: com.alibaba.griver.base.resource.appinfo.GriverRVAppUpdaterImpl.2
            @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
            public final void onFetchSuccess(JSONObject jSONObject) {
                LinkedList linkedList2 = new LinkedList();
                if (jSONObject != null && jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        try {
                            linkedList2.add((AppModel) JSON.parseObject(jSONObject.getJSONObject(keys.next()).toString(), AppModel.class));
                        } catch (Exception e) {
                            GriverLogger.e("GriverRVAppUpdaterImpl", "parse app info failed", e);
                        }
                    }
                }
                UpdateAppCallback updateAppCallback2 = UpdateAppCallback.this;
                if (updateAppCallback2 != null) {
                    updateAppCallback2.onSuccess(linkedList2);
                }
            }

            @Override // com.iap.ac.config.lite.fetcher.ConfigNotifyCallback
            public final void onFetchFailed(String str, String str2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fetch config failed, ");
                sb5.append(str);
                sb5.append(" = ");
                sb5.append(str2);
                GriverLogger.e("GriverRVAppUpdaterImpl", sb5.toString());
                UpdateAppCallback updateAppCallback2 = UpdateAppCallback.this;
                if (updateAppCallback2 != null) {
                    updateAppCallback2.onError(new UpdateAppException("0", "fetch failed"));
                }
                for (Map.Entry entry3 : requestApps.entrySet()) {
                    MonitorMap.Builder builder = new MonitorMap.Builder();
                    builder.appId((String) entry3.getKey()).version((String) entry3.getValue()).deployVersion((String) entry3.getValue()).needAsynAppType(true);
                    builder.message(str2).code(str);
                    builder.cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    GriverMonitor.error(GriverMonitorConstants.ERROR_FETCH_APP_EXCEPTION, "GriverAppContainer", builder.build());
                }
            }
        }, false);
    }
}
