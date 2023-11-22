package com.iap.ac.android.region.cdp.component.defaults;

import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.region.cdp.component.FatigueComponent;
import com.iap.ac.android.region.cdp.component.GetSpaceInfoComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.component.RemoteDataSourceComponent;
import com.iap.ac.android.region.cdp.component.UpdatePolicyComponent;
import com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.SpProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultGetSpaceInfoComponent extends BaseComponent implements GetSpaceInfoComponent {
    public static final String TAG = CdpUtils.logTag("DefaultGetSpaceInfoComponent");

    @Override // com.iap.ac.android.region.cdp.component.GetSpaceInfoComponent
    public void getSpaceInfoMap(final List<String> list, final Map<String, String> map, final GetSpaceInfoCallback getSpaceInfoCallback) {
        if (RegionRPCConfigCenter.INSTANCE.getRegionBizToggle() && this.mWalletCdpKit.isCdpEnable()) {
            IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<Map<String, CdpSpaceInfo>>() { // from class: com.iap.ac.android.region.cdp.component.defaults.DefaultGetSpaceInfoComponent.1
                {
                    DefaultGetSpaceInfoComponent.this = this;
                }

                private Map<String, CdpSpaceInfo> getSpaceInfoFromRemote(List<String> list2, String str, String str2) throws Exception {
                    return ((RemoteDataSourceComponent) DefaultGetSpaceInfoComponent.this.getComponent(RemoteDataSourceComponent.class)).batchQuerySpaceInfoMap(list2, str, str2, map);
                }

                private void log(String str) {
                    ACLog.d(DefaultGetSpaceInfoComponent.TAG, String.format("%s. [spaceCodes are %s]", str, list));
                }

                private void logError(String str, Exception exc) {
                    ACLog.e(DefaultGetSpaceInfoComponent.TAG, String.format("%s. [spaceCode are %s]", str, list), exc);
                }

                private void saveLastUpdateTime(Collection<String> collection) {
                    if (CdpUtils.isEmpty(collection)) {
                        return;
                    }
                    Iterator<String> it = collection.iterator();
                    while (it.hasNext()) {
                        SpProvider.getInstance().saveLastUpdateTime(it.next(), System.currentTimeMillis());
                    }
                }

                @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
                public void onFailure(Exception exc) {
                    String str = DefaultGetSpaceInfoComponent.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("get space info failed: ");
                    sb.append(exc);
                    ACLog.d(str, sb.toString());
                    getSpaceInfoCallback.onFailure(exc);
                }

                @Override // com.iap.ac.android.common.task.async.IAPAsyncTask.Runner
                public Map<String, CdpSpaceInfo> execute() throws Exception {
                    Map<String, CdpSpaceInfo> map2;
                    String openId = SPIManager.getInstance().getOpenId();
                    String appLanguage = CdpUtils.getAppLanguage();
                    LocalStorageComponent localStorageComponent = (LocalStorageComponent) DefaultGetSpaceInfoComponent.this.getComponent(LocalStorageComponent.class);
                    UpdatePolicyComponent updatePolicyComponent = (UpdatePolicyComponent) DefaultGetSpaceInfoComponent.this.getComponent(UpdatePolicyComponent.class);
                    FatigueComponent fatigueComponent = (FatigueComponent) DefaultGetSpaceInfoComponent.this.getComponent(FatigueComponent.class);
                    localStorageComponent.deleteSpaceInfo(list, false);
                    Map<String, CdpSpaceInfo> hashMap = new HashMap<>();
                    try {
                        hashMap = localStorageComponent.getSpaceInfoMap(list, openId, appLanguage);
                        StringBuilder sb = new StringBuilder();
                        sb.append("get local space info success: ");
                        sb.append(hashMap);
                        log(sb.toString());
                    } catch (Exception e) {
                        logError("get local space info failed", e);
                    }
                    ArrayList arrayList = new ArrayList(list);
                    if (!CdpUtils.isEmpty(hashMap)) {
                        Iterator it = new ArrayList(hashMap.values()).iterator();
                        while (it.hasNext()) {
                            CdpSpaceInfo cdpSpaceInfo = (CdpSpaceInfo) it.next();
                            if (!updatePolicyComponent.shouldUpdate(cdpSpaceInfo)) {
                                StringBuilder a2 = a.a("no need to update the local space info: ");
                                a2.append(cdpSpaceInfo.spaceCode);
                                log(a2.toString());
                                fatigueComponent.filterExhaustedFatigue(cdpSpaceInfo);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("filter local space info with fatigue: ");
                                sb2.append(appLanguage);
                                log(sb2.toString());
                                arrayList.remove(cdpSpaceInfo.spaceCode);
                            } else {
                                hashMap.remove(cdpSpaceInfo.spaceCode);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return hashMap;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("an update for the local space info is needed: ");
                    sb3.append(arrayList);
                    log(sb3.toString());
                    try {
                        map2 = getSpaceInfoFromRemote(arrayList, openId, appLanguage);
                        saveLastUpdateTime(map2.keySet());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("get remote space info success: ");
                        sb4.append(map2);
                        log(sb4.toString());
                    } catch (Exception e2) {
                        HashMap hashMap2 = new HashMap();
                        ACLogEvent.newLogger("mini_program_operation", CdpConstants.SEED_ID_EXCEPTION_TRIGGERED).addParams("spaceCodes", list).addParams("errorMessage", "get remote space info map failed.").addParams("exception", e2).event("region_biz");
                        logError("get remote space info map failed.", e2);
                        map2 = hashMap2;
                    }
                    localStorageComponent.deleteSpaceInfo(map2.keySet(), true);
                    try {
                        localStorageComponent.insertOrReplaceSpaceInfo(map2.values());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("create or update local space info success: ");
                        sb5.append(map2);
                        log(sb5.toString());
                    } catch (Exception e3) {
                        logError("create or update local space info failed", e3);
                    }
                    HashMap hashMap3 = new HashMap(hashMap);
                    hashMap3.putAll(map2);
                    fatigueComponent.filterExhaustedFatigue(hashMap3.values());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("filter exhausted remote space info with fatigue: ");
                    sb6.append(hashMap3);
                    log(sb6.toString());
                    return hashMap3;
                }

                @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
                public void onSuccess(Map<String, CdpSpaceInfo> map2) {
                    String str = DefaultGetSpaceInfoComponent.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("get space info successfully: ");
                    sb.append(map2);
                    ACLog.d(str, sb.toString());
                    GetSpaceInfoCallback getSpaceInfoCallback2 = getSpaceInfoCallback;
                    if (map2 == null) {
                        map2 = new HashMap<>();
                    }
                    getSpaceInfoCallback2.onSuccess(map2);
                }
            });
        } else {
            getSpaceInfoCallback.onFailure(new Exception("the wallet cdp is disabled in amcs."));
        }
    }
}
