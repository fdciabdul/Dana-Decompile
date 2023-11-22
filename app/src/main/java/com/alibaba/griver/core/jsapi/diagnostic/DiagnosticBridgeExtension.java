package com.alibaba.griver.core.jsapi.diagnostic;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.UploadCallback;
import com.alibaba.griver.api.ui.share.GriverShareSchemeExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.pdstrackers.PdsTrackersMonitor;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.iap.ac.android.diagnoselog.api.DiagnoseLogService;
import com.iap.ac.android.diagnoselog.api.OnLogUploadListener;
import com.iap.ac.android.diagnoselog.core.LogUploadInfo;
import java.util.Date;
import java.util.List;

/* loaded from: classes6.dex */
public class DiagnosticBridgeExtension implements BridgeExtension {
    private static final String ACTION_ALL_RECORDS = "allRecords";
    private static final String ACTION_FETCH_RUNNING_REPORTS = "fetchRunningReports";
    private static final String ACTION_PDS_ALL_TRACKERS = "pds_all_trackers";
    private static final String ACTION_PDS_TRIGGER_TRACKER = "pds_trigger_tracker";
    private static final String ACTION_UPLOAD_LOG = "uploadDigoLogs";
    private static final String ACTION_UPLOAD_RUNNING_REPORT = "uploadRunningReport";
    private static final String TAG = "DiagnosticBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void pdsReportTracks(@BindingNode(App.class) App app, @BindingParam(name = {"action"}) String str, @BindingParam(name = {"allTrackers"}) JSONArray jSONArray, @BindingParam(name = {"tracker"}, stringDefault = "") String str2, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        str.hashCode();
        if (str.equals(ACTION_PDS_TRIGGER_TRACKER)) {
            PdsTrackersMonitor pdsTrackersMonitor = (PdsTrackersMonitor) PerformanceMonitorFactory.getPerformanceMonitor(app.getAppId(), PerformanceMonitorFactory.PerformanceType.PDS_TRACKERS);
            if (pdsTrackersMonitor != null) {
                pdsTrackersMonitor.addTracker(str2);
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else if (str.equals(ACTION_PDS_ALL_TRACKERS)) {
            PdsTrackersMonitor pdsTrackersMonitor2 = (PdsTrackersMonitor) PerformanceMonitorFactory.getPerformanceMonitor(app.getAppId(), PerformanceMonitorFactory.PerformanceType.PDS_TRACKERS);
            if (pdsTrackersMonitor2 != null) {
                pdsTrackersMonitor2.setTrackerListKeys(jSONArray);
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
    }

    @ActionFilter
    public void griverInternalDiagnoticTool(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam(name = {"action"}) String str, @BindingParam(name = {"dateTimeStamp"}) Long l, @BindingParam(name = {"data"}) JSONObject jSONObject, @BindingParam(name = {"operationType"}, stringDefault = "") String str2, @BindingParam(name = {"gateWay"}, stringDefault = "") String str3, @BindingParam(name = {"report"}, stringDefault = "") String str4, @BindingCallback final BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1821289119:
                if (str.equals(ACTION_ALL_RECORDS)) {
                    c = 0;
                    break;
                }
                break;
            case -1005374374:
                if (str.equals(ACTION_FETCH_RUNNING_REPORTS)) {
                    c = 1;
                    break;
                }
                break;
            case -593737571:
                if (str.equals(ACTION_UPLOAD_LOG)) {
                    c = 2;
                    break;
                }
                break;
            case 1149400914:
                if (str.equals(ACTION_UPLOAD_RUNNING_REPORT)) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            List<Record> allRecords = ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).getAllRecords();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", (Object) JSONArray.parseArray(JSON.toJSONString(allRecords)));
            bridgeCallback.sendJSONResponse(jSONObject2);
        } else if (c == 1) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("list", (Object) ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).getAllRunningRecords(app));
            bridgeCallback.sendJSONResponse(jSONObject3);
        } else if (c == 2) {
            if (l == null || l.longValue() <= 0) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            GriverLogger.d(TAG, "start to upload");
            DiagnoseLogService.setOnLogUploadListener(new OnLogUploadListener() { // from class: com.alibaba.griver.core.jsapi.diagnostic.DiagnosticBridgeExtension.1
                @Override // com.iap.ac.android.diagnoselog.api.OnLogUploadListener
                public void onProgress(LogUploadInfo logUploadInfo) {
                    if (logUploadInfo != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("OnLogUploadListener onProgress: ");
                        sb.append(logUploadInfo.bytesUploaded);
                        GriverLogger.d(DiagnosticBridgeExtension.TAG, sb.toString());
                    }
                }

                @Override // com.iap.ac.android.diagnoselog.api.OnLogUploadListener
                public void onFinished(boolean z, String str5) {
                    DiagnoseLogService.setOnLogUploadListener(null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnLogUploadListener success:");
                    sb.append(z);
                    sb.append(" taskId:");
                    sb.append(str5);
                    GriverLogger.d(DiagnosticBridgeExtension.TAG, sb.toString());
                    JSONObject jSONObject4 = new JSONObject();
                    if (z) {
                        jSONObject4.put("success", (Object) Boolean.TRUE);
                        jSONObject4.put("taskId", (Object) str5);
                    } else {
                        jSONObject4.put("success", (Object) Boolean.FALSE);
                    }
                    bridgeCallback.sendJSONResponse(jSONObject4);
                }
            });
            DiagnoseLogService.upload(new Date(l.longValue()));
        } else if (c == 3) {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            } else {
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).uploadRunningReport(str2, str3, str4, new UploadCallback() { // from class: com.alibaba.griver.core.jsapi.diagnostic.DiagnosticBridgeExtension.2
                    @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
                    public void onSuccess(String str5) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    }

                    @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
                    public void onFailed(String str5, String str6) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    }
                });
            }
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
    }

    @ActionFilter
    public void griverCheckWalletApi(@BindingNode(App.class) App app, @BindingParam(name = {"walletApiName"}) String str, @BindingParam(name = {"griverExtensionName"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (WalletServiceManager.getInstance().getService(Class.forName(str)) != null) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                } else {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
                }
            } catch (WalletServiceManager.ServiceNotFoundException unused) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
            } catch (Exception e) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
            }
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                Object obj = RVProxy.get((Class<Object>) Class.forName(str2), true);
                if (obj != null) {
                    if ((obj instanceof GriverShareSchemeExtension) && TextUtils.isEmpty(((GriverShareSchemeExtension) obj).getScheme())) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
                        return;
                    } else {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                        return;
                    }
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
            } catch (Exception e2) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e2.getMessage()));
            }
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, "param is null"));
        }
    }
}
