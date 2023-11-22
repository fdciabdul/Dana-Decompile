package com.alibaba.griver.core.jsapi.monitor;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.utils.StringUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.sendmoney.summary.SummaryActivity;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class MonitorBridgeExtension implements BridgeExtension {
    public static final String JSAPI_GRIVER_LOG_EVENT = "griverLogEvent";
    private static final String TAG = "MonitorBridgeExtension";

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
        arrayList.add(JSAPI_GRIVER_LOG_EVENT);
        return arrayList;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse griverLogEvent(@BindingNode(App.class) App app, @BindingParam({"eventName"}) Object obj, @BindingParam({"bizType"}) Object obj2, @BindingParam({"params"}) Object obj3) {
        String str;
        if ("RV_APP_STARTUP".equals(obj)) {
            if (canFullLinkMonit(app)) {
                GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
                JSONObject jSONObject = new JSONObject();
                if (obj3 != null) {
                    if (obj3 instanceof JSONObject) {
                        jSONObject = (JSONObject) obj3;
                    } else {
                        return BridgeResponse.INVALID_PARAM;
                    }
                }
                if (jSONObject.size() == 0) {
                    return BridgeResponse.INVALID_PARAM;
                }
                String encodeJSONObject = encodeJSONObject(jSONObject);
                if (TextUtils.isEmpty(encodeJSONObject) || encodeJSONObject.length() > 10240) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("paramsLength", String.valueOf(encodeJSONObject.length()));
                    GriverMonitor.commonException(GriverMonitorConstants.KEY_JSAPI_GRIVER_LOG_EVENT_ERROR, "GriverAppContainer", "1", "Params is too long", hashMap);
                    return BridgeResponse.INVALID_PARAM;
                }
                stageMonitor.addParamUnique("miniAppExtendInfo", encodeJSONObject);
                return BridgeResponse.SUCCESS;
            }
            return BridgeResponse.FORBIDDEN_ERROR;
        } else if (((TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class)).isInner(app) && GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_JSAPI_GRIVER_LOG_EVENT_TOGGLE, true)) {
            JSONObject jSONObject2 = new JSONObject();
            if (obj == null || TextUtils.isEmpty(String.valueOf(obj))) {
                return BridgeResponse.INVALID_PARAM;
            }
            if (!(obj instanceof String)) {
                return BridgeResponse.INVALID_PARAM;
            }
            String str2 = (String) obj;
            if (obj2 == null) {
                str = "";
            } else if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                return BridgeResponse.INVALID_PARAM;
            }
            if (obj3 != null) {
                if (obj3 instanceof JSONObject) {
                    jSONObject2 = (JSONObject) obj3;
                } else {
                    return BridgeResponse.INVALID_PARAM;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("appId", app.getAppId());
            hashMap2.put("appVersion", app.getAppVersion());
            hashMap2.put("isAppJSAPILogEvent", SummaryActivity.CHECKED);
            for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                    hashMap2.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                GriverMonitor.event(str2, str, hashMap2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(GriverMonitorConstants.APPX_BEHAVIOR_BIZ_TYPE_PREFIX);
                sb.append(app.getAppId());
                GriverMonitor.event(str2, sb.toString(), hashMap2);
            }
            return BridgeResponse.SUCCESS;
        } else {
            return BridgeResponse.NOT_FOUND;
        }
    }

    private boolean canFullLinkMonit(App app) {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_JSAPI_GRIVER_LOG_EVENT_FULLLINK_CONFIG);
        if (configJSONObject != null && JSONUtils.contains(configJSONObject, "enable") && JSONUtils.getBoolean(configJSONObject, "enable", true)) {
            return !JSONUtils.getJSONArray(configJSONObject, "blackList", new JSONArray()).contains(app.getAppId());
        }
        return true;
    }

    protected String encodeJSONObject(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : jSONObject.keySet()) {
            Object obj = jSONObject.get(str);
            if (obj != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(URLEncoder.encode(str));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(obj)));
                arrayList.add(sb.toString());
            }
        }
        return URLEncoder.encode(StringUtils.join(arrayList.toArray(), ContainerUtils.FIELD_DELIMITER));
    }
}
