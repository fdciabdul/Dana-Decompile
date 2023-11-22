package com.alibaba.griver.base.performance.setdata;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.performance.PerformanceBaseMonitor;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceSetDataMonitor extends PerformanceBaseMonitor {
    public static final String KEY_GRIVER_SETDATA_STATISTIC = "griver_setdata_statistic";
    public PerformanceSetDataModel setDataModel = new PerformanceSetDataModel();

    public void setData(String str, int i, long j) {
        this.setDataModel.setData(str, i, j);
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void clear() {
        this.setDataModel.clear();
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void upload(App app) {
        Map<String, String> uploadMap = this.setDataModel.getUploadMap();
        if (uploadMap != null) {
            GriverMonitor.event(KEY_GRIVER_SETDATA_STATISTIC, "GriverAppContainer", getExtendInfo(app, uploadMap));
        }
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> uploadMap = this.setDataModel.getUploadMap();
        if (uploadMap != null) {
            jSONObject.put(InvoiceConstant.SUMMARY, (Object) encodeMap(uploadMap));
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(KEY_GRIVER_SETDATA_STATISTIC, (Object) jSONObject);
        return jSONObject2;
    }
}
