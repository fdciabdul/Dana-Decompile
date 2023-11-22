package com.alibaba.exthub.base;

import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.exthub.event.ExtHubEventUtil;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class ExtHubRenderBridgeImpl implements RenderBridge {
    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public SendToRenderCallback takeCallback(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback, boolean z) {
        if (renderCallContext == null) {
            ExtHubLogger.d("sendNativeEvent bridgeContext is null");
            return;
        }
        String action = renderCallContext.getAction();
        JSONObject param = renderCallContext.getParam();
        if (param == null) {
            param = new JSONObject();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendNativeEvent: ");
        sb.append(action);
        ExtHubLogger.d(sb.toString());
        ExtHubEventUtil.sendNativeEvent(action, param);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        sendToRender(renderCallContext, sendToRenderCallback, true);
    }
}
