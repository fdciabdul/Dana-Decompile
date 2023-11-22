package com.alibaba.griver.base.t2;

import android.os.SystemClock;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.CollectPerformanceCallback;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.GriverPerformanceStages;
import com.alibaba.griver.base.api.INebulaPage;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;

/* loaded from: classes3.dex */
public class T2Utils {
    public static GriverFullLinkStageMonitor performanceJST2(final App app) {
        final GriverFullLinkStageMonitor griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        if (griverFullLinkStageMonitor != null && !griverFullLinkStageMonitor.isUploaded()) {
            griverFullLinkStageMonitor.setUpload();
            griverFullLinkStageMonitor.transitToNext(GriverPerformanceStages.KEY_APP_FINISHED);
            final Page removeT2Page = GriverAppConfig.getInstance().removeT2Page(app);
            if (removeT2Page != null) {
                a(removeT2Page, new CollectPerformanceCallback() { // from class: com.alibaba.griver.base.t2.T2Utils.1
                    @Override // com.alibaba.ariver.app.api.point.view.CollectPerformanceCallback
                    public final void afterProcess() {
                        try {
                            T2Store t2Store = (T2Store) Page.this.getData(T2Store.class);
                            if (t2Store != null) {
                                JSONObject extraJsT2MapStr = t2Store.getExtraJsT2MapStr();
                                long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                                griverFullLinkStageMonitor.transitToNext(GriverMonitorConstants.KEY_JST2_START, Long.parseLong(extraJsT2MapStr.getString("N_ST")) - currentTimeMillis);
                                griverFullLinkStageMonitor.transitToNext(GriverMonitorConstants.KEY_JST2_T2_RENDER, Long.parseLong(t2Store.getUcJsT2()) - currentTimeMillis);
                                griverFullLinkStageMonitor.transitToNext(GriverMonitorConstants.KEY_JST2_FP, Long.parseLong(extraJsT2MapStr.getString("P_FP")) - currentTimeMillis);
                                griverFullLinkStageMonitor.transitToNext(GriverMonitorConstants.KEY_JST2_FCP, Long.parseLong(extraJsT2MapStr.getString("P_FCP")) - currentTimeMillis);
                                griverFullLinkStageMonitor.transitToNext(GriverMonitorConstants.KEY_JST2_LCP, Long.parseLong(extraJsT2MapStr.getString("P_LCP").split(",")[0]) - currentTimeMillis);
                                griverFullLinkStageMonitor.addParam(GriverMonitorConstants.KEY_JST2_T2_STOP_REASON, t2Store.getUcJsT2State());
                                griverFullLinkStageMonitor.addParam(GriverMonitorConstants.KEY_JST2_VERSION, extraJsT2MapStr.getString("G_VER"));
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("RVPerfLogLifeCycleExtension#onAppExit parse t2 error");
                            sb.append(th);
                            GriverLogger.e("T2Utils", sb.toString());
                        }
                        griverFullLinkStageMonitor.upload(app);
                    }
                });
            } else {
                griverFullLinkStageMonitor.upload(app);
            }
        }
        return griverFullLinkStageMonitor;
    }

    private static void a(final Page page, final CollectPerformanceCallback collectPerformanceCallback) {
        APWebView webView;
        try {
            final T2PageInfo t2PageInfo = (T2PageInfo) page.getData(T2PageInfo.class, false);
            if (!(page instanceof INebulaPage) || (webView = ((INebulaPage) page).getWebView()) == null) {
                return;
            }
            final Runnable runnable = new Runnable() { // from class: com.alibaba.griver.base.t2.T2Utils.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (T2PageInfo.this.isWaiting()) {
                        T2PageInfo.this.setWaiting(false);
                        StringBuilder sb = new StringBuilder();
                        sb.append("androidT2 callback delayandroidT2AppId");
                        sb.append(page.getApp().getAppId());
                        RVLogger.d("T2Utils", sb.toString());
                        CollectPerformanceCallback collectPerformanceCallback2 = collectPerformanceCallback;
                        if (collectPerformanceCallback2 != null) {
                            collectPerformanceCallback2.afterProcess();
                        }
                    }
                }
            };
            t2PageInfo.setWaiting(true);
            executeSendToRender(webView, t2PageInfo, RenderCallContext.newBuilder(page.getRender()).type("call").action("collectPerformanceBeforeDestroy").param(null).build(), new SendToRenderCallback() { // from class: com.alibaba.griver.base.t2.T2Utils.3
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                public final void onCallBack(JSONObject jSONObject) {
                    if (T2PageInfo.this.isWaiting()) {
                        T2PageInfo.this.setWaiting(false);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("eventExtraData");
                        T2Store t2Store = null;
                        if (jSONObject2 != null) {
                            t2Store = new T2Store(JSONUtils.getString(jSONObject2, "enableJsT2"), JSONUtils.getString(jSONObject2, "ucJsT2"), JSONUtils.getString(jSONObject2, "ucJsT2State"), JSONUtils.getJSONObject(jSONObject2, "extraJsT2Map", null));
                            StringBuilder sb = new StringBuilder();
                            sb.append("androidT2 callback data:");
                            sb.append(t2Store);
                            sb.append("androidT2AppId");
                            sb.append(page.getApp().getAppId());
                            RVLogger.d("T2Utils", sb.toString());
                        }
                        page.setData(T2Store.class, t2Store);
                        ExecutorUtils.removeOnMain(runnable);
                        CollectPerformanceCallback collectPerformanceCallback2 = collectPerformanceCallback;
                        if (collectPerformanceCallback2 != null) {
                            collectPerformanceCallback2.afterProcess();
                        }
                    }
                }
            });
            ExecutorUtils.runOnMain(runnable, 1000L);
        } catch (Throwable unused) {
            if (collectPerformanceCallback != null) {
                collectPerformanceCallback.afterProcess();
            }
        }
    }

    public static void executeSendToRender(APWebView aPWebView, T2PageInfo t2PageInfo, RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        t2PageInfo.putRenderCallback(renderCallContext.getEventId(), sendToRenderCallback);
        String eventId = renderCallContext.getEventId();
        String action = renderCallContext.getAction();
        JSONObject param = renderCallContext.getParam();
        String type = renderCallContext.getType();
        boolean keep = renderCallContext.getKeep();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientId", (Object) eventId);
        jSONObject.put("func", (Object) action);
        jSONObject.put("param", (Object) param);
        jSONObject.put("msgType", (Object) type);
        jSONObject.put("keepCallback", (Object) Boolean.valueOf(keep));
        String jSONString = JSON.toJSONString(jSONObject.toJSONString());
        StringBuilder sb = new StringBuilder();
        sb.append("AlipayJSBridge._invokeJS(");
        sb.append(jSONString);
        sb.append(")");
        String obj = sb.toString();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("javascript:(function(){if(typeof AlipayJSBridge === 'object'){");
            sb2.append(obj);
            sb2.append("}})();");
            aPWebView.loadUrl(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("androidT2 jsapi rep:");
            sb3.append(obj);
            RVLogger.d("T2Utils", sb3.toString());
        } catch (Exception e) {
            RVLogger.e("T2Utils", "androidT2 loadUrl exception", e);
        }
    }
}
