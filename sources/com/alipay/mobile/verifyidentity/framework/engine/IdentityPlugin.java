package com.alipay.mobile.verifyidentity.framework.engine;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class IdentityPlugin extends H5SimplePlugin {
    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return false;
    }

    public void onInitialize(H5CoreNode h5CoreNode) {
    }

    public void onRelease() {
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction("secVIVerify");
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if ("secVIVerify".equals(h5Event.getAction())) {
            startVerifyIdentity(h5Event, h5BridgeContext);
            return true;
        }
        return false;
    }

    private void startVerifyIdentity(H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        if ("secVIVerify".equalsIgnoreCase(h5Event.getAction())) {
            JSONObject param = h5Event.getParam();
            Boolean bool = param.getBoolean(RequestConstants.SecVIKeyAutoSecData);
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                if (entry.getValue() != null && (entry.getValue() instanceof String)) {
                    hashMap.put(entry.getKey(), entry.getValue().toString());
                }
            }
            if (bool != null && bool.booleanValue()) {
                hashMap.put(RequestConstants.SecVIKeyAutoSecData, SummaryActivity.CHECKED);
            }
            VIEngine.startVerify(h5Event.getActivity(), RequestConstants.VerifyProductVerify, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.framework.engine.IdentityPlugin.1
                @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                public void onVerifyAction(VIAction vIAction) {
                }

                @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                public void onVerifyResult(VIResult vIResult) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", (Object) String.valueOf(vIResult.getResult()));
                    if (vIResult.getResult() != 1000) {
                        jSONObject.put("error", (Object) String.valueOf(vIResult.getResult()));
                    }
                    jSONObject.put("verifyId", (Object) vIResult.getVerifyId());
                    h5BridgeContext.sendBridgeResult(jSONObject);
                }
            }, null);
        }
    }
}
