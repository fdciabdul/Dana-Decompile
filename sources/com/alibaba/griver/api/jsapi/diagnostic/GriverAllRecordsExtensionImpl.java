package com.alibaba.griver.api.jsapi.diagnostic;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.jsapi.diagnostic.rpc.RecordProcessor;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes6.dex */
public class GriverAllRecordsExtensionImpl implements GriverAllRecordsExtension {
    private static final int MAX_LENGTH = 50;
    private ReportConfig config;
    private final LinkedList<Record> mRecordsCache = new LinkedList<>();
    private final LinkedHashMap<String, JSONObject> mRecordReportMap = new LinkedHashMap<>();

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public List<Record> getAllRecords() {
        return new ArrayList(this.mRecordsCache);
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void addRecord(Record record) {
        if (this.mRecordsCache.size() == 50) {
            this.mRecordsCache.removeFirst();
        }
        this.mRecordsCache.add(record);
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void clear() {
        this.mRecordsCache.clear();
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void createRecordReport(App app) {
        LinkedHashMap<String, JSONObject> linkedHashMap = this.mRecordReportMap;
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        if (linkedHashMap.containsKey(sb.toString())) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", (Object) String.valueOf(UUID.randomUUID()));
        jSONObject.put(RecordReportConstants.TIME_ZONE, (Object) String.valueOf(TimeZone.getDefault().getID()));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RecordReportConstants.WORKSPACE_ID, (Object) GriverEnv.getWorkSpaceId());
        jSONObject2.put("app_id", (Object) GriverEnv.getAppId());
        jSONObject2.put(RecordReportConstants.APP_NAME, (Object) GriverEnv.getAppName());
        jSONObject.put(RecordReportConstants.GMPOP_ENV, (Object) jSONObject2);
        LinkedHashMap<String, JSONObject> linkedHashMap2 = this.mRecordReportMap;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(app.getAppId());
        sb2.append(app.getStartToken());
        linkedHashMap2.put(sb2.toString(), jSONObject);
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void updateRecordReport(App app, JSONObject jSONObject) {
        LinkedHashMap<String, JSONObject> linkedHashMap = this.mRecordReportMap;
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        if (linkedHashMap.containsKey(sb.toString())) {
            LinkedHashMap<String, JSONObject> linkedHashMap2 = this.mRecordReportMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(app.getAppId());
            sb2.append(app.getStartToken());
            JSONObject jSONObject2 = linkedHashMap2.get(sb2.toString());
            if (jSONObject2 != null) {
                jSONObject2.putAll(jSONObject);
            }
        }
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void reportJSAPIError(App app, JSONObject jSONObject) {
        LinkedHashMap<String, JSONObject> linkedHashMap = this.mRecordReportMap;
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        if (linkedHashMap.containsKey(sb.toString())) {
            LinkedHashMap<String, JSONObject> linkedHashMap2 = this.mRecordReportMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(app.getAppId());
            sb2.append(app.getStartToken());
            JSONObject jSONObject2 = linkedHashMap2.get(sb2.toString());
            if (jSONObject2 != null) {
                if (!jSONObject2.containsKey(RecordReportConstants.JSAPI_ERRORS)) {
                    jSONObject2.put(RecordReportConstants.JSAPI_ERRORS, (Object) new JSONArray());
                }
                jSONObject2.getJSONArray(RecordReportConstants.JSAPI_ERRORS).add(jSONObject);
            }
        }
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void uploadRunningReport(String str, String str2, String str3, final UploadCallback uploadCallback) {
        new RecordProcessor().uploadRunningReport(str, str2, str3, new UploadCallback() { // from class: com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtensionImpl.1
            @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
            public void onSuccess(String str4) {
                uploadCallback.onSuccess(str4);
            }

            @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
            public void onFailed(String str4, String str5) {
                uploadCallback.onFailed(str4, str5);
            }
        });
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public JSONArray getAllRunningRecords(App app) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, JSONObject>> it = this.mRecordReportMap.entrySet().iterator();
        while (it.hasNext()) {
            JSONObject value = it.next().getValue();
            if (value.containsKey(RecordReportConstants.REPORT_TS)) {
                jSONArray.add(value);
            }
        }
        return jSONArray;
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public boolean canUseRecords(App app) {
        if (app.isTinyApp()) {
            if (this.config == null) {
                this.config = new ReportConfig(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_GRV_RUNNING_REPORT_COLLECTING, ""));
            }
            return this.config.canReport(app.getAppId()) && "INSTALL".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()));
        }
        return false;
    }

    @Override // com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension
    public void uploadAppxProfile(App app, String str) {
        LinkedHashMap<String, JSONObject> linkedHashMap = this.mRecordReportMap;
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        if (linkedHashMap.containsKey(sb.toString())) {
            LinkedHashMap<String, JSONObject> linkedHashMap2 = this.mRecordReportMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(app.getAppId());
            sb2.append(app.getStartToken());
            final JSONObject jSONObject = linkedHashMap2.get(sb2.toString());
            if (jSONObject != null) {
                String string = jSONObject.getString("uuid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append(".json");
                new RecordProcessor().uploadFile(string, sb3.toString(), str, GriverEnv.getWorkSpaceId(), new UploadCallback() { // from class: com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtensionImpl.2
                    @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
                    public void onFailed(String str2, String str3) {
                    }

                    @Override // com.alibaba.griver.api.jsapi.diagnostic.UploadCallback
                    public void onSuccess(String str2) {
                        jSONObject.put(RecordReportConstants.APPX_PROFILE_URL, (Object) str2);
                    }
                });
            }
        }
    }
}
