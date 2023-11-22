package com.iap.ac.android.region.cdp.component.defaults;

import android.text.TextUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.region.cdp.component.BehaviorComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.component.RemoteDataSourceComponent;
import com.iap.ac.android.region.cdp.model.CdpBehaviorInfo;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.model.CdpUploadFatigueEvent;
import com.iap.ac.android.region.cdp.model.request.CdpSpaceQueryRpcRequest;
import com.iap.ac.android.region.cdp.model.result.CdpSpaceQueryRpcResult;
import com.iap.ac.android.region.cdp.rpc.CdpQueryRpcFacade;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.SpProvider;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class DefaultRemoteDataSourceComponent extends BaseComponent implements RemoteDataSourceComponent {
    public static final String BEHAVIOR_LOG_KEY = "BEHAVIOR_LOG";
    public static final String RPC_BIZ_TYPE = "region_biz";
    public static final String TAG = CdpUtils.logTag("DefaultRemoteDataSourceComponent");

    private CdpSpaceQueryRpcRequest createCdpSpaceQueryRpcRequest(List<String> list, String str, String str2, Map<String, String> map) {
        CdpSpaceQueryRpcRequest cdpSpaceQueryRpcRequest = new CdpSpaceQueryRpcRequest();
        cdpSpaceQueryRpcRequest.spaceCodes = list;
        cdpSpaceQueryRpcRequest.extParams = map;
        if (cdpSpaceQueryRpcRequest.extParams == null) {
            cdpSpaceQueryRpcRequest.extParams = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                List<CdpUploadFatigueEvent> createUploadFatigueEvents = createUploadFatigueEvents(list.get(i), str, str2);
                if (!CdpUtils.isEmpty(createUploadFatigueEvents)) {
                    arrayList.addAll(createUploadFatigueEvents);
                }
            }
            cdpSpaceQueryRpcRequest.extParams.put(BEHAVIOR_LOG_KEY, JsonUtils.toJson(arrayList));
        }
        String str3 = TAG;
        StringBuilder a2 = a.a("ext params: ");
        a2.append(cdpSpaceQueryRpcRequest.extParams.get(BEHAVIOR_LOG_KEY));
        ACLog.d(str3, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("request: ");
        sb.append(cdpSpaceQueryRpcRequest);
        ACLog.d(str3, sb.toString());
        return cdpSpaceQueryRpcRequest;
    }

    private List<CdpUploadFatigueEvent> createUploadFatigueEvents(String str, String str2, String str3) {
        List<CdpBehaviorInfo> list;
        try {
            list = ((LocalStorageComponent) getComponent(LocalStorageComponent.class)).getBehaviorInfo(str, str2, str3);
            try {
                String str4 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("get fatigue info list success, ");
                sb.append(list);
                ACLog.d(str4, sb.toString());
            } catch (Exception e) {
                e = e;
                String str5 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get fatigue info list fail, Exception: ");
                sb2.append(e);
                ACLog.d(str5, sb2.toString());
                if (list != null) {
                }
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            list = null;
        }
        if (list != null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CdpBehaviorInfo cdpBehaviorInfo = list.get(i);
            if (cdpBehaviorInfo.lastUploadCount != cdpBehaviorInfo.count) {
                CdpUploadFatigueEvent cdpUploadFatigueEvent = new CdpUploadFatigueEvent();
                cdpUploadFatigueEvent.recordId = getOrCreateRecordId();
                cdpUploadFatigueEvent.deliverId = cdpBehaviorInfo.deliverId;
                cdpUploadFatigueEvent.action = cdpBehaviorInfo.action;
                cdpUploadFatigueEvent.period = cdpBehaviorInfo.period;
                cdpUploadFatigueEvent.periodStartTime = cdpBehaviorInfo.periodStartTime;
                cdpUploadFatigueEvent.count = cdpBehaviorInfo.count;
                arrayList.add(cdpUploadFatigueEvent);
            }
        }
        String str6 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createUploadFatigueEvents: ");
        sb3.append(arrayList);
        ACLog.d(str6, sb3.toString());
        return arrayList;
    }

    private String getOrCreateRecordId() {
        String recordId = SpProvider.getInstance().getRecordId();
        if (TextUtils.isEmpty(recordId)) {
            String obj = UUID.randomUUID().toString();
            SpProvider.getInstance().saveRecordId(obj);
            return obj;
        }
        return recordId;
    }

    private void log(String str, List<String> list, String str2) {
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(". space code is ");
        sb.append(list);
        sb.append(", locale is ");
        sb.append(str2);
        sb.append(".");
        ACLog.d(str3, sb.toString());
    }

    private void monitor(List<String> list, String str) {
        ACLogEvent.newLogger("mini_program_operation", CdpConstants.SEED_ID_EXCEPTION_TRIGGERED).addParams("spaceCodes", list).addParams("errorMessage", str).event("region_biz");
    }

    private List<CdpUploadFatigueEvent> parseJsonStrToList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(JsonUtils.fromJson(jSONArray.optString(i), CdpUploadFatigueEvent.class));
                }
            }
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("get fatigue info list fail, Exception: ");
            sb.append(e);
            ACLog.w(str2, sb.toString());
        }
        return arrayList;
    }

    private Map<String, CdpSpaceInfo> processOnSuccess(CdpSpaceQueryRpcRequest cdpSpaceQueryRpcRequest, CdpSpaceQueryRpcResult cdpSpaceQueryRpcResult) {
        if (!TextUtils.isEmpty(cdpSpaceQueryRpcResult.timeZone)) {
            this.mWalletCdpKit.setTimezone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory(cdpSpaceQueryRpcResult.timeZone));
        }
        this.mWalletCdpKit.setTimeInMillis(cdpSpaceQueryRpcResult.serverTimeInMillis);
        updateLastUploadCount(cdpSpaceQueryRpcRequest, cdpSpaceQueryRpcResult);
        for (CdpSpaceInfo cdpSpaceInfo : cdpSpaceQueryRpcResult.spaceInfos.values()) {
            if (!CdpUtils.isEmpty(cdpSpaceInfo.contentInfos)) {
                for (CdpContentInfo cdpContentInfo : cdpSpaceInfo.contentInfos) {
                    cdpContentInfo.spaceCode = cdpSpaceInfo.spaceCode;
                    if (!CdpUtils.isEmpty(cdpContentInfo.fatigueInfos)) {
                        for (CdpFatigueInfo cdpFatigueInfo : cdpContentInfo.fatigueInfos) {
                            cdpFatigueInfo.spaceCode = cdpSpaceInfo.spaceCode;
                            cdpFatigueInfo.deliverId = cdpContentInfo.deliverId;
                        }
                    }
                }
            }
        }
        return cdpSpaceQueryRpcResult.spaceInfos;
    }

    private void updateLastUploadCount(CdpSpaceQueryRpcRequest cdpSpaceQueryRpcRequest, CdpSpaceQueryRpcResult cdpSpaceQueryRpcResult) {
        if (CdpUtils.isEmpty(cdpSpaceQueryRpcRequest.extParams) || CdpUtils.isEmpty(cdpSpaceQueryRpcResult.extendInfo) || !Boolean.parseBoolean(cdpSpaceQueryRpcResult.extendInfo.get("fatigueSuccess"))) {
            return;
        }
        ((BehaviorComponent) getComponent(BehaviorComponent.class)).updateLastUploadCount(parseJsonStrToList(cdpSpaceQueryRpcRequest.extParams.get(BEHAVIOR_LOG_KEY)));
    }

    @Override // com.iap.ac.android.region.cdp.component.RemoteDataSourceComponent
    public Map<String, CdpSpaceInfo> batchQuerySpaceInfoMap(List<String> list, String str, String str2, Map<String, String> map) {
        log("DefaultRemoteDataSourceComponent#getSpaceInfo called", list, str2);
        CdpSpaceQueryRpcRequest createCdpSpaceQueryRpcRequest = createCdpSpaceQueryRpcRequest(list, str, str2, map);
        StringBuilder sb = new StringBuilder();
        sb.append("CdpSpaceQueryRpcRequest");
        sb.append(" built");
        log(sb.toString(), list, str2);
        StringBuilder a2 = a.a("getting ");
        a2.append("CdpQueryRpcFacade");
        a2.append("'s implementation");
        log(a2.toString(), list, str2);
        CdpQueryRpcFacade cdpQueryRpcFacade = (CdpQueryRpcFacade) RPCProxyHost.getInterfaceProxy(CdpQueryRpcFacade.class, "region_biz");
        if (cdpQueryRpcFacade != null) {
            log("start CdpQueryRpc", list, str2);
            try {
                CdpSpaceQueryRpcResult querySpace = cdpQueryRpcFacade.querySpace(createCdpSpaceQueryRpcRequest);
                StringBuilder a3 = a.a("got raw ");
                a3.append("CdpSpaceQueryRpcResult");
                log(a3.toString(), list, str2);
                if (querySpace != null) {
                    if (querySpace.success) {
                        if (!CdpUtils.isEmpty(querySpace.spaceInfos)) {
                            return processOnSuccess(createCdpSpaceQueryRpcRequest, querySpace);
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CdpSpaceQueryRpcResult");
                        sb2.append(" is success but cdpSpaceInfo is empty");
                        String obj = sb2.toString();
                        log(obj, list, str2);
                        monitor(list, obj);
                        throw new RuntimeException(obj);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("CdpSpaceQueryRpcResult");
                    sb3.append(" is not success, errorCode: ");
                    sb3.append(querySpace.errorCode);
                    sb3.append(", errorMessage: ");
                    sb3.append(querySpace.errorMessage);
                    String obj2 = sb3.toString();
                    log(obj2, list, str2);
                    monitor(list, obj2);
                    throw new RuntimeException(obj2);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CdpSpaceQueryRpcResult");
                sb4.append(" is null");
                String obj3 = sb4.toString();
                log(obj3, list, str2);
                monitor(list, obj3);
                throw new RuntimeException(obj3);
            } catch (Exception e) {
                log("CdpQueryRpc failed", list, str2, e);
                monitor(list, "CdpQueryRpc failed");
                throw e;
            }
        }
        StringBuilder a4 = a.a("No RPC implementation for ");
        a4.append("CdpQueryRpcFacade");
        a4.append(". Use RPCProxyHost.setRPCImplement() to set one");
        String obj4 = a4.toString();
        log(obj4, list, str2);
        monitor(list, obj4);
        throw new IllegalStateException(obj4);
    }

    private void log(String str, List<String> list, String str2, Throwable th) {
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(". space code is ");
        sb.append(list);
        sb.append(", locale is ");
        sb.append(str2);
        sb.append(".");
        ACLog.d(str3, sb.toString(), th);
    }
}
