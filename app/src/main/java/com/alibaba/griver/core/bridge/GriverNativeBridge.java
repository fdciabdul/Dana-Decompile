package com.alibaba.griver.core.bridge;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.common.log.APILogUtils;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;
import com.alibaba.ariver.engine.common.track.JSAPIEventTrackerProxy;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeGuard;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.permission.DefaultAccessControlManagement;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.api.bridge.GriverBridgeCallEvent;
import com.alibaba.griver.api.bridge.GriverBridgeCallPreInterceptEvent;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.core.common.monitor.KeyJSAPIMonitor;
import com.alibaba.griver.core.utils.MiniProgramMetaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverNativeBridge implements NativeBridge {
    public static final String TAG = "GriverNativeBridge";

    /* renamed from: a */
    private boolean f6394a = false;
    private EngineRouter b;

    protected void onRelease() {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void bindEngineRouter(EngineRouter engineRouter) {
        this.b = engineRouter;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
        if (this.f6394a || nativeCallContext == null) {
            GriverLogger.w(TAG, "sendToNative but released!");
            return false;
        }
        return a(nativeCallContext, sendToNativeCallback, true);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        if (this.f6394a || nativeCallContext == null) {
            GriverLogger.w(TAG, "sendToNative but released!");
            return false;
        }
        return a(nativeCallContext, sendToNativeCallback, z);
    }

    private boolean a(final NativeCallContext nativeCallContext, final SendToNativeCallback sendToNativeCallback, boolean z) {
        List<Render> registeredRender;
        SendToRenderCallback takeCallback;
        Page activePage;
        if (nativeCallContext == null) {
            GriverLogger.w(TAG, "executeNative but bridgeContext == null!");
            return false;
        }
        if (nativeCallContext.getNode() == null) {
            GriverLogger.w(TAG, "executeNative with node == null!!! may cause memory leak");
        }
        nativeCallContext.getStatData().triggerTimeStamp = SystemClock.elapsedRealtime();
        if (nativeCallContext.getRender() == null) {
            if (nativeCallContext.getNode() instanceof Page) {
                nativeCallContext.setRender(((Page) nativeCallContext.getNode()).getRender());
            } else if ((nativeCallContext.getNode() instanceof App) && (activePage = ((App) nativeCallContext.getNode()).getActivePage()) != null) {
                nativeCallContext.setRender(activePage.getRender());
            }
        }
        final String appId = (nativeCallContext.getRender() == null || TextUtils.isEmpty(nativeCallContext.getRender().getAppId())) ? "" : nativeCallContext.getRender().getAppId();
        EngineRouter engineRouter = this.b;
        if (engineRouter != null && (registeredRender = engineRouter.getRegisteredRender()) != null) {
            for (Render render : registeredRender) {
                if (render.getRenderBridge() != null && (takeCallback = render.getRenderBridge().takeCallback(nativeCallContext.getId())) != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("executeNative hit callback! ");
                    sb.append(nativeCallContext.getId());
                    GriverLogger.d(TAG, sb.toString());
                    takeCallback.onCallBack(nativeCallContext.getParams());
                    return true;
                }
            }
        }
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            GriverLogger.w(TAG, "cannot dispatch empty API!");
            return true;
        }
        if (KeyJSAPIMonitor.isKeyAPI(nativeCallContext.getName())) {
            KeyJSAPIMonitor.monitorKeyAPIInvoke(nativeCallContext);
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(new SendToNativeCallback() { // from class: com.alibaba.griver.core.bridge.GriverNativeBridge.1
            {
                GriverNativeBridge.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(final JSONObject jSONObject, boolean z2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RVTraceKey.RV_JSAPI_onCallback_);
                sb2.append(nativeCallContext.getName());
                RVTraceUtils.traceBeginSection(sb2.toString());
                NativeCallResultPoint nativeCallResultPoint = GriverNativeBridge.this.getNativeCallResultPoint(nativeCallContext);
                if (nativeCallResultPoint != null) {
                    jSONObject.put("startTime", (Object) Long.valueOf(elapsedRealtime));
                    nativeCallResultPoint.onSendBack(nativeCallContext, jSONObject);
                }
                if (sendToNativeCallback != null) {
                    nativeCallContext.getStatData().callbackTimeStamp = SystemClock.elapsedRealtime();
                    sendToNativeCallback.onCallback(jSONObject, z2);
                }
                String jSONUtils = JSONUtils.toString(jSONObject);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("executeNative jsapi rep name={");
                sb3.append(nativeCallContext.getName());
                sb3.append("} ");
                sb3.append(nativeCallContext.getId());
                sb3.append(" ");
                sb3.append(jSONUtils);
                sb3.append(", keepCallback: ");
                sb3.append(z2);
                sb3.append(", stat: ");
                sb3.append(nativeCallContext.getStatData().print());
                GriverLogger.d(GriverNativeBridge.TAG, sb3.toString());
                APILogUtils.logApiSendBack(nativeCallContext, jSONObject, jSONUtils);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(RVTraceKey.RV_JSAPI_onCallback_);
                sb4.append(nativeCallContext.getName());
                RVTraceUtils.traceEndSection(sb4.toString());
                try {
                    GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.core.bridge.GriverNativeBridge.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ((GriverBridgeCallEvent) ExtensionPoint.as(GriverBridgeCallEvent.class).node(nativeCallContext.getNode()).create()).onBridgeCall(nativeCallContext.getName(), nativeCallContext.getParams(), jSONObject, nativeCallContext.getId(), appId);
                        }
                    });
                } catch (Exception e) {
                    GriverLogger.e(GriverNativeBridge.TAG, "send bridge call exception", e);
                }
            }
        });
        StringBuilder sb2 = new StringBuilder();
        sb2.append("executeNative jsapi req name={");
        sb2.append(nativeCallContext.getName());
        sb2.append("} ");
        sb2.append(nativeCallContext.getId());
        GriverLogger.d(TAG, sb2.toString());
        APILogUtils.logApiDispatch(nativeCallContext);
        if (PerformanceAmcsManager.getInstance().canMonitorJSAPI()) {
            GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.core.bridge.GriverNativeBridge.2
                {
                    GriverNativeBridge.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((GriverBridgeCallEvent) ExtensionPoint.as(GriverBridgeCallEvent.class).node(nativeCallContext.getNode()).create()).apiDispatch(nativeCallContext.getName(), nativeCallContext.getId(), appId);
                }
            });
        }
        ((JSAPIEventTrackerProxy) RVProxy.get(JSAPIEventTrackerProxy.class)).trackKeyJSAPIInvoke(nativeCallContext);
        String name = nativeCallContext.getName();
        if (nativeCallContext.getRender() != null && nativeCallContext.getNode() != null && GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_ENABLE_JSAPI_PRE_INTERCEPTOR, false)) {
            GriverBridgeCallPreInterceptEvent.PreInterceptBridgeContext preInterceptBridgeContext = new GriverBridgeCallPreInterceptEvent.PreInterceptBridgeContext();
            preInterceptBridgeContext.jsapiName = name;
            preInterceptBridgeContext.context = nativeCallContext.getRender().getActivity();
            preInterceptBridgeContext.page = (Page) nativeCallContext.getRender().getPage();
            preInterceptBridgeContext.jsParameters = nativeCallContext.getParams();
            preInterceptBridgeContext.miniProgramAppID = nativeCallContext.getRender().getAppId();
            preInterceptBridgeContext.miniProgramPageURL = nativeCallContext.getRender().getCurrentUri();
            preInterceptBridgeContext.startParams = nativeCallContext.getRender().getStartParams();
            MiniProgramMetaUtils.extractAcParams((Page) nativeCallContext.getNode(), preInterceptBridgeContext, name);
            MiniProgramMetaUtils.adaptAppId(nativeCallContext, preInterceptBridgeContext);
            if (((GriverBridgeCallPreInterceptEvent) ExtensionPoint.as(GriverBridgeCallPreInterceptEvent.class).node(nativeCallContext.getNode()).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.bridge.GriverNativeBridge.3
                {
                    GriverNativeBridge.this = this;
                }

                @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
                public Boolean resolve(List<Boolean> list) {
                    if (list != null && list.size() != 0) {
                        Iterator<Boolean> it = list.iterator();
                        while (it.hasNext()) {
                            if (it.next().booleanValue()) {
                                return Boolean.TRUE;
                            }
                        }
                    }
                    return Boolean.FALSE;
                }
            }).create()).handleBridgeCallPreIntercept(preInterceptBridgeContext, new DefaultBridgeCallback(bridgeResponseHelper))) {
                GriverLogger.d(TAG, "executeNative handlePreIntercept intercepted");
                return true;
            }
        }
        BridgeInterceptor bridgeInterceptor = BridgeInterceptorManager.getInstance().getBridgeInterceptor(name);
        if (bridgeInterceptor != null) {
            BridgeInterceptor.InterceptContext interceptContext = new BridgeInterceptor.InterceptContext();
            if (nativeCallContext.getPluginId() != null) {
                interceptContext.pluginId = nativeCallContext.getPluginId();
            }
            interceptContext.context = nativeCallContext.getRender().getActivity();
            interceptContext.page = (Page) nativeCallContext.getRender().getPage();
            interceptContext.jsParameters = nativeCallContext.getParams();
            interceptContext.miniProgramAppID = nativeCallContext.getRender().getAppId();
            interceptContext.miniProgramPageURL = nativeCallContext.getRender().getCurrentUri();
            interceptContext.startParams = nativeCallContext.getRender().getStartParams();
            MiniProgramMetaUtils.extractAcParams((Page) nativeCallContext.getNode(), interceptContext, name);
            if (bridgeInterceptor.willHandleJSAPI(name, interceptContext, new DefaultBridgeCallback(bridgeResponseHelper))) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("jsapi: ");
                sb3.append(name);
                sb3.append(" is intercepted by ");
                sb3.append(bridgeInterceptor);
                GriverLogger.d(TAG, sb3.toString());
                return true;
            }
        }
        if (BridgeDispatcher.getInstance().dispatch(nativeCallContext, bridgeResponseHelper, z)) {
            return true;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("executeNative but not found Extension!");
        sb4.append(nativeCallContext.getName());
        GriverLogger.w(TAG, sb4.toString());
        if (z) {
            try {
                if (doCheckPermission(nativeCallContext, bridgeResponseHelper)) {
                    return true;
                }
            } catch (AccessControlException e) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("executeNative check failed for legacy call! ");
                sb5.append(nativeCallContext.getName());
                GriverLogger.d(TAG, sb5.toString());
                String message = e.getMessage();
                if (message.startsWith("N22")) {
                    bridgeResponseHelper.sendNoRigHtToInvoke(message);
                } else {
                    bridgeResponseHelper.sendNoRigHtToInvoke();
                }
                return true;
            }
        }
        if (((NativeCallNotFoundPoint) ExtensionPoint.as(NativeCallNotFoundPoint.class).node(nativeCallContext.getNode()).useCache(true).create()).handleNotFound(nativeCallContext, bridgeResponseHelper)) {
            GriverLogger.d(TAG, "executeNative handleNotFound intercepted");
            return true;
        }
        bridgeResponseHelper.sendNotFound();
        return false;
    }

    public boolean doCheckPermission(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) throws AccessControlException {
        DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement(nativeCallContext, bridgeResponseHelper, BridgeDispatcher.getInstance().getExtensionManager());
        DefaultAccessController defaultAccessController = new DefaultAccessController();
        defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BridgeGuard(new BridgePermission(nativeCallContext.getName(), nativeCallContext.getName())));
        ((BridgeAccessPoint) ExtensionPoint.as(BridgeAccessPoint.class).extensionManager(BridgeDispatcher.getInstance().getExtensionManager()).useCache(true).node(nativeCallContext.getNode()).create()).needPermissionCheck(nativeCallContext.getNode(), arrayList);
        if (defaultAccessController.check(nativeCallContext.getNode(), arrayList, null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("executeNative check pending! ");
            sb.append(nativeCallContext.getName());
            GriverLogger.d(TAG, sb.toString());
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("executeNative check success! ");
        sb2.append(nativeCallContext.getName());
        GriverLogger.d(TAG, sb2.toString());
        return false;
    }

    public NativeCallResultPoint getNativeCallResultPoint(NativeCallContext nativeCallContext) {
        return (NativeCallResultPoint) ExtensionPoint.as(NativeCallResultPoint.class).node(nativeCallContext.getNode()).create();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public final void release() {
        if (this.f6394a) {
            return;
        }
        this.f6394a = true;
        onRelease();
    }
}
