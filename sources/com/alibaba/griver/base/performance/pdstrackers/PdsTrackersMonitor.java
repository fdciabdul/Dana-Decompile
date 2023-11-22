package com.alibaba.griver.base.performance.pdstrackers;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.performance.PerformanceBaseMonitor;
import java.util.Map;

/* loaded from: classes6.dex */
public class PdsTrackersMonitor extends PerformanceBaseMonitor {
    public static final String KEY_PDS_TRACKERS = "pds_trackers";
    public PdsTrackersModel mPdsTrackersModel = new PdsTrackersModel();

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void upload(App app) {
    }

    public void setTrackerListKeys(JSONArray jSONArray) {
        this.mPdsTrackersModel.setPdsTrackers(jSONArray);
    }

    public void addTracker(String str) {
        this.mPdsTrackersModel.addTracker(str);
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void clear() {
        this.mPdsTrackersModel.clear();
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public JSONObject getData() {
        Map<String, Integer> uploadMap = this.mPdsTrackersModel.getUploadMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pds_trackers", (Object) uploadMap);
        return jSONObject;
    }
}
