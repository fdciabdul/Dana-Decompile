package com.iap.ac.android.container.adapter.griver;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.container.utils.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GriverContainerBridgeContext extends ContainerBridgeContext {

    /* renamed from: a  reason: collision with root package name */
    private BridgeCallback f7552a;
    private Page b;

    public GriverContainerBridgeContext(Page page, BridgeCallback bridgeCallback) {
        this.f7552a = bridgeCallback;
        this.b = page;
    }

    @Override // com.iap.ac.android.common.container.js.ContainerBridgeContext
    public boolean sendBridgeResult(JSONObject jSONObject) {
        if (this.b == null || this.f7552a == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder("jsonObject  = ");
        sb.append(jSONObject);
        sb.append(", page = ");
        sb.append(this.b);
        sb.append(", bridgeCallback = ");
        sb.append(this.f7552a);
        sb.append(", page.getPageContext");
        sb.append(this.b.getPageContext());
        ACLog.d("GriverContainerBridgeCo", sb.toString());
        if (this.b.getPageContext() == null || this.b.getPageContext().getActivity() == null || ContainerUtils.isActivityRunning(this.b.getPageContext().getActivity())) {
            this.f7552a.sendJSONResponse(Utils.jsonObjectToFastJson(jSONObject));
            return true;
        }
        return false;
    }

    @Override // com.iap.ac.android.common.container.js.ContainerBridgeContext
    public boolean sendBridgeResult(String str, Object obj) {
        if (this.b == null || this.f7552a == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder("key  = ");
        sb.append(str);
        sb.append(", value = ");
        sb.append(obj);
        sb.append(", page = ");
        sb.append(this.b);
        sb.append(", bridgeCallback = ");
        sb.append(this.f7552a);
        sb.append(", page.getPageContext");
        sb.append(this.b.getPageContext());
        ACLog.d("GriverContainerBridgeCo", sb.toString());
        if (this.b.getPageContext() == null || ContainerUtils.isActivityRunning(this.b.getPageContext().getActivity())) {
            this.f7552a.sendBridgeResponse(BridgeResponse.newValue(str, obj));
            return true;
        }
        return false;
    }
}
