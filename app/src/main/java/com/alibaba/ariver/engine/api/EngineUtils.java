package com.alibaba.ariver.engine.api;

import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.common.log.IgnoreLogUtils;
import com.alibaba.ariver.engine.api.common.log.LogCountInfo;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLogConfigProxy;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.EventLog;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class EngineUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6017a;
    private static final Set<String> b;
    private static Map<String, LogCountInfo> c;
    private static int d;
    private static boolean e;
    private static Set<String> f;

    public static String getUserAgentSuffix() {
        return "Ariver/1.0.0";
    }

    static {
        HashSet hashSet = new HashSet();
        f6017a = hashSet;
        HashSet hashSet2 = new HashSet();
        b = hashSet2;
        c = null;
        d = 0;
        e = false;
        f = null;
        hashSet.add(NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
        hashSet.add("message");
        hashSet2.add(RVEvents.FIRE_PULL_TO_REFRESH);
        hashSet2.add(RVEvents.PULL_INTERCEPT);
        hashSet2.add("onShare");
        hashSet2.add("promotionClose");
    }

    private static void a() {
        if (e) {
            return;
        }
        if (((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)) != null) {
            f = ((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)).getIgnoreEventList();
            d = ((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)).getIgnoreApiLogCount();
        }
        e = true;
        c = new HashMap();
    }

    public static Worker getWorker(RVEngine rVEngine) {
        if (rVEngine.isDestroyed() || rVEngine.getEngineRouter() == null) {
            return null;
        }
        return rVEngine.getEngineRouter().getWorkerById(null);
    }

    public static void sendToRender(Render render, String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        sendToRender(render, null, str, jSONObject, sendToRenderCallback);
    }

    public static void sendToRender(Render render, Worker worker, String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        sendToRender(render, worker, str, jSONObject, sendToRenderCallback, true);
    }

    public static void sendToRender(Render render, Worker worker, String str, JSONObject jSONObject, final SendToRenderCallback sendToRenderCallback, boolean z) {
        if (render == null) {
            RVLogger.w("AriverEngine:EngineUtils", "sendToRender but render == null!!");
            return;
        }
        if (worker == null) {
            worker = render.getEngine().getEngineRouter().getWorkerById(getWorkerId(render));
        }
        final boolean z2 = false;
        if (worker != null && !f6017a.contains(str)) {
            z2 = !b.contains(str);
            sendPushWorkMessage(render, worker, str, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.engine.api.EngineUtils.1
                @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                public final void onCallBack(JSONObject jSONObject2) {
                    SendToRenderCallback sendToRenderCallback2 = SendToRenderCallback.this;
                    if (sendToRenderCallback2 == null || !z2) {
                        return;
                    }
                    sendToRenderCallback2.onCallBack(jSONObject2);
                }
            });
        }
        if (render.getRenderBridge() == null) {
            RVLogger.w("AriverEngine:EngineUtils", "sendToRender but render.getRenderBridge == null!!");
            return;
        }
        RenderCallContext.Builder param = RenderCallContext.newBuilder(render).type("call").action(str).param(jSONObject);
        RenderBridge renderBridge = render.getRenderBridge();
        RenderCallContext build = param.build();
        if (z2) {
            sendToRenderCallback = null;
        }
        renderBridge.sendToRender(build, sendToRenderCallback, z);
        a(render, str, jSONObject);
    }

    public static void sendPushWorkMessage(Render render, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        sendPushWorkMessage(render, null, str, jSONObject, sendToWorkerCallback);
    }

    public static void sendPushWorkMessage(Render render, Worker worker, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String obj = sb.toString();
        if (worker == null) {
            worker = render.getEngine().getEngineRouter().getWorkerById(getWorkerId(render));
        }
        if (worker == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendPushWorkerMessage action: ");
            sb2.append(str);
            sb2.append(", param: ");
            sb2.append(jSONObject);
            sb2.append(", but worker == null!");
            RVLogger.w("AriverEngine:EngineUtils", sb2.toString());
            a((String) null, obj, sendToWorkerCallback);
        } else if (worker.isDestroyed()) {
            RVLogger.w("AriverEngine:EngineUtils", "sendPushWorkerMessage but worker destroyed!");
            a((String) null, obj, sendToWorkerCallback);
        } else {
            worker.sendPushMessage(render, str, jSONObject, sendToWorkerCallback);
        }
    }

    public static String getWorkerId(Render render) {
        WorkerStore workerStore = (WorkerStore) render.getPage().getData(WorkerStore.class);
        return workerStore != null ? workerStore.workerId : "";
    }

    private static void a(String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        if (sendToWorkerCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", (Object) str);
            jSONObject.put("result", "2");
            jSONObject.put("messageId", (Object) str2);
            sendToWorkerCallback.onCallBack(jSONObject);
        }
    }

    private static void a(Render render, String str, JSONObject jSONObject) {
        String str2;
        RVLogger.d("AriverEngine:EngineUtils", "logEvent");
        try {
            str2 = JSONUtils.toString(jSONObject);
        } catch (Exception e2) {
            RVLogger.e("AriverEngine:EngineUtils", "logEvent JSON to string error.", e2);
            str2 = "";
        }
        DataNode page = render.getPage();
        if (page == null) {
            return;
        }
        a();
        Set<String> set = f;
        if (set != null && set.contains(str)) {
            IgnoreLogUtils.handleIgnoreLog(AppLogUtils.getParentId(page), str, "", "logEvent", d, c, "event");
        } else {
            AppLogger.log(new EventLog.Builder().setParentId(AppLogUtils.getParentId(page)).setGroupId("-").setData(str2).setEventName(str).build());
        }
    }

    public static String getClientExtendConfig() {
        StringBuilder sb = new StringBuilder("var CLIENT_EXTEND_CONFIG = {'apis':[");
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        if (extensionManager != null && extensionManager.getBridgeDSLs() != null && !extensionManager.getBridgeDSLs().isEmpty()) {
            int size = extensionManager.getBridgeDSLs().size();
            for (int i = 0; i < size; i++) {
                sb.append(extensionManager.getBridgeDSLs().get(i).toJSONString());
                if (i < size - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
