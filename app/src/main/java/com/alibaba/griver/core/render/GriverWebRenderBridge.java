package com.alibaba.griver.core.render;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.APWebView;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverWebRenderBridge extends BaseRenderBridgeImpl {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f6447a = new ArrayList();
    private static List<String> b = new ArrayList();
    private APWebView c;

    static {
        f6447a.add("JSPlugin_AlipayH5Share");
        f6447a.add(RVEvents.BEFORE_UNLOAD);
        f6447a.add("message");
        f6447a.add(RVEvents.NBCOMPONENT_CANRENDER);
        b.add(ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY);
        b.add("showUCFailDialog");
        b.add("setKeyboardType");
        b.add("monitorH5Performance");
        b.add("getStartupParams");
    }

    public GriverWebRenderBridge(Node node, APWebView aPWebView) {
        super(node);
        this.c = aPWebView;
    }

    private void a(JSONObject jSONObject) {
        String jSONString = JSON.toJSONString(jSONObject.toJSONString());
        StringBuilder sb = new StringBuilder();
        sb.append("AlipayJSBridge._invokeJS(");
        sb.append(jSONString);
        sb.append(")");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:(function(){if(typeof AlipayJSBridge === 'object'){");
        sb2.append(obj);
        sb2.append("}})();");
        loadUrl(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("jsapi rep:");
        sb3.append(obj);
        RVLogger.d("WebEngine:", sb3.toString());
    }

    public void loadUrl(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderBridge.1
            @Override // java.lang.Runnable
            public void run() {
                GriverWebRenderBridge.this.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (str.startsWith("javascript")) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.c.evaluateJavascript(str, null);
                } else {
                    this.c.loadUrl(str);
                }
            }
        } catch (Throwable th) {
            RVLogger.e("WebEngine:", "loadUrl exception.", th);
        }
    }

    @Override // com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl
    public void executeSendToRender(final RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        if (!"yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_postWebOnUi", null))) {
            try {
                executeSendToRenderWrap(renderCallContext);
                return;
            } catch (Throwable th) {
                RVLogger.e("WebEngine:", th);
                return;
            }
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderBridge.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GriverWebRenderBridge.this.executeSendToRenderWrap(renderCallContext);
                } catch (Throwable th2) {
                    RVLogger.e("WebEngine:", th2);
                }
            }
        });
    }

    public void executeSendToRenderWrap(RenderCallContext renderCallContext) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientId", (Object) renderCallContext.getEventId());
        jSONObject.put("func", (Object) renderCallContext.getAction());
        jSONObject.put("param", (Object) renderCallContext.getParam());
        jSONObject.put("msgType", (Object) renderCallContext.getType());
        jSONObject.put("keepCallback", (Object) Boolean.valueOf(renderCallContext.getKeep()));
        a(jSONObject);
    }
}
