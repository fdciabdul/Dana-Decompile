package com.alibaba.griver.api.jsapi.diagnostic;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverExtension;
import java.util.List;

/* loaded from: classes2.dex */
public interface GriverAllRecordsExtension extends GriverExtension {
    void addRecord(Record record);

    boolean canUseRecords(App app);

    void clear();

    void createRecordReport(App app);

    List<Record> getAllRecords();

    JSONArray getAllRunningRecords(App app);

    void reportJSAPIError(App app, JSONObject jSONObject);

    void updateRecordReport(App app, JSONObject jSONObject);

    void uploadAppxProfile(App app, String str);

    void uploadRunningReport(String str, String str2, String str3, UploadCallback uploadCallback);
}
