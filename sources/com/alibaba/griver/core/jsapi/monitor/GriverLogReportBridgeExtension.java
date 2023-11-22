package com.alibaba.griver.core.jsapi.monitor;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GriverLogReportBridgeExtension implements BridgeExtension {
    public static final String JSAPI_GRIVER_LOG_CACHE = "griverLogCache";
    public static final String JSAPI_GRIVER_LOG_REPORT = "griverLogReport";

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

    public static List<String> getJSAPI() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(JSAPI_GRIVER_LOG_REPORT);
        arrayList.add(JSAPI_GRIVER_LOG_CACHE);
        return arrayList;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse griverLogReport(@BindingNode(App.class) App app, @BindingParam({"url"}) String str, @BindingParam({"bizType"}) String str2, @BindingParam({"data"}) String str3, @BindingParam({"logType"}) String str4, @BindingParam({"cacheData"}) JSONObject jSONObject) {
        if (!GriverLogReportManager.getInstance().canReport(app.getAppId())) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return BridgeResponse.INVALID_PARAM;
        }
        GriverLogReportManager.getInstance().reportData(str, str2, str3, str4, jSONObject);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse griverLogCache(@BindingNode(App.class) App app, @BindingParam({"url"}) String str, @BindingParam({"bizType"}) String str2) {
        if (!GriverLogReportManager.getInstance().canReport(app.getAppId())) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BridgeResponse.INVALID_PARAM;
        }
        return BridgeResponse.newValue("cacheData", GriverLogReportManager.getInstance().logCache(str, str2));
    }
}
