package com.iap.ac.config.lite.facade.request;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.utils.ConfigUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AmcsConfigRpcRequest implements Serializable {
    private static String TAG = e.b("AmcsConfigRpcRequest");
    public String appId;
    public long lastResponseTime;
    private Map<String, Object> mapParameters;
    public JSONObject parameters;
    public String tntInstId;
    public String workspaceId;

    public void addParameter(String str, Object obj) {
        if (this.parameters == null) {
            this.parameters = new JSONObject();
        }
        try {
            this.parameters.put(str, obj);
        } catch (JSONException e) {
            ACLog.w(TAG, "addParameter: failed", e);
        }
    }

    public void addParameters(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.parameters == null) {
            this.parameters = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.parameters.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                ACLog.w(TAG, "addParameter: failed", e);
            }
        }
    }

    public Map<String, Object> convertParameters() {
        if (this.parameters == null) {
            return null;
        }
        this.mapParameters = new HashMap();
        Iterator<String> keys = this.parameters.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.mapParameters.put(next, this.parameters.opt(next));
            } catch (Exception e) {
                ACLog.w(TAG, "convertParameters: failed", e);
            }
        }
        return this.mapParameters;
    }

    public long getLastResponseTime() {
        return this.lastResponseTime;
    }

    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
