package com.alibaba.ariver.engine.common.bridge;

import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class BaseRenderBridgeImpl implements RenderBridge {

    /* renamed from: a  reason: collision with root package name */
    private String f6029a;
    private final Map<String, SendToRenderCallback> b;
    private Node c;
    private EventSendInterceptorPoint d;

    public abstract void executeSendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback);

    public BaseRenderBridgeImpl(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("AriverEngine:");
        sb.append("BaseRenderBridgeImpl");
        this.f6029a = sb.toString();
        this.b = new HashMap();
        this.c = node;
        this.d = (EventSendInterceptorPoint) ExtensionPoint.as(EventSendInterceptorPoint.class).node(node).useCache(true).defaultValue(Boolean.FALSE).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && !list.isEmpty()) {
                    Iterator<Boolean> it = list.iterator();
                    while (it.hasNext()) {
                        if (!it.next().booleanValue()) {
                            return Boolean.FALSE;
                        }
                    }
                }
                return Boolean.TRUE;
            }
        }).create();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public SendToRenderCallback takeCallback(String str) {
        String str2 = this.f6029a;
        StringBuilder sb = new StringBuilder();
        sb.append("try takeCallback: ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        return this.b.remove(str);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback, boolean z) {
        if (z && a(renderCallContext.getAction(), renderCallContext.getParam())) {
            if (sendToRenderCallback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prevent", (Object) Boolean.FALSE);
                sendToRenderCallback.onCallBack(jSONObject);
                String str = this.f6029a;
                StringBuilder sb = new StringBuilder();
                sb.append(renderCallContext.getAction());
                sb.append(" H5 onCallback for ");
                sb.append(renderCallContext.getAction());
                sb.append(" invoke was prevented");
                RVLogger.d(str, sb.toString());
            }
            String str2 = this.f6029a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sender");
            sb2.append(this.c.hashCode());
            sb2.append(" send event[");
            sb2.append(renderCallContext.getAction());
            sb2.append("] was intercepted by extension");
            RVLogger.d(str2, sb2.toString());
            return;
        }
        if (sendToRenderCallback != null) {
            String str3 = this.f6029a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("sendToRender ");
            sb3.append(renderCallContext.getAction());
            sb3.append(" record callback ");
            sb3.append(renderCallContext.getEventId());
            RVLogger.d(str3, sb3.toString());
            this.b.put(renderCallContext.getEventId(), sendToRenderCallback);
        }
        executeSendToRender(renderCallContext, sendToRenderCallback);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        sendToRender(renderCallContext, sendToRenderCallback, true);
    }

    private boolean a(String str, JSONObject jSONObject) {
        return this.d.needIntercept(str, jSONObject);
    }

    protected JSONObject warpData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 == null || jSONObject2.size() != 1) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", (Object) jSONObject);
            return jSONObject3;
        }
        return jSONObject2;
    }
}
