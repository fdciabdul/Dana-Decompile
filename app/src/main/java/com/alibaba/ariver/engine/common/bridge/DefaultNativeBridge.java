package com.alibaba.ariver.engine.common.bridge;

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
import com.alibaba.ariver.engine.api.point.NativeCallDispatchPoint;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.engine.common.track.JSAPIEventTrackerProxy;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeGuard;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.permission.DefaultAccessControlManagement;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DefaultNativeBridge implements NativeBridge {
    public static final String TAG = "AriverEngine:NativeBridge";
    private EngineRouter b;

    /* renamed from: a */
    private boolean f6031a = false;
    private RVJsStatTrackService c = (RVJsStatTrackService) RVProxy.get(RVJsStatTrackService.class);

    protected void onRelease() {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void bindEngineRouter(EngineRouter engineRouter) {
        this.b = engineRouter;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
        if (this.f6031a || nativeCallContext == null) {
            RVLogger.w(TAG, "sendToNative but released!");
            return false;
        }
        return a(nativeCallContext, sendToNativeCallback, true);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        if (this.f6031a || nativeCallContext == null) {
            RVLogger.w(TAG, "sendToNative but released!");
            return false;
        }
        return a(nativeCallContext, sendToNativeCallback, z);
    }

    private boolean a(final NativeCallContext nativeCallContext, final SendToNativeCallback sendToNativeCallback, boolean z) {
        List<Render> registeredRender;
        SendToRenderCallback takeCallback;
        Page activePage;
        if (nativeCallContext == null) {
            RVLogger.w(TAG, "executeNative but bridgeContext == null!");
            return false;
        }
        if (nativeCallContext.getNode() == null) {
            RVLogger.w(TAG, "executeNative with node == null!!! may cause memory leak");
        }
        nativeCallContext.getStatData().triggerTimeStamp = SystemClock.elapsedRealtime();
        if (nativeCallContext.getRender() == null) {
            if (nativeCallContext.getNode() instanceof Page) {
                nativeCallContext.setRender(((Page) nativeCallContext.getNode()).getRender());
            } else if ((nativeCallContext.getNode() instanceof App) && (activePage = ((App) nativeCallContext.getNode()).getActivePage()) != null) {
                nativeCallContext.setRender(activePage.getRender());
            }
        }
        EngineRouter engineRouter = this.b;
        if (engineRouter != null && (registeredRender = engineRouter.getRegisteredRender()) != null) {
            for (Render render : registeredRender) {
                if (render.getRenderBridge() != null && (takeCallback = render.getRenderBridge().takeCallback(nativeCallContext.getId())) != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("executeNative hit callback! ");
                    sb.append(nativeCallContext.getId());
                    RVLogger.d(TAG, sb.toString());
                    takeCallback.onCallBack(nativeCallContext.getParams());
                    return true;
                }
            }
        }
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            RVLogger.w(TAG, "cannot dispatch empty API!");
            return true;
        }
        BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(new SendToNativeCallback() { // from class: com.alibaba.ariver.engine.common.bridge.DefaultNativeBridge.1
            {
                DefaultNativeBridge.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject, boolean z2) {
                DefaultNativeBridge.this.getCallTimeoutHandlerPoint(nativeCallContext).removeMonitor(nativeCallContext);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RVTraceKey.RV_JSAPI_onCallback_);
                sb2.append(nativeCallContext.getName());
                RVTraceUtils.traceBeginSection(sb2.toString());
                try {
                    NativeCallResultPoint nativeCallResultPoint = DefaultNativeBridge.this.getNativeCallResultPoint(nativeCallContext);
                    if (nativeCallResultPoint != null) {
                        nativeCallResultPoint.onSendBack(nativeCallContext, jSONObject);
                    }
                    ((JSAPIEventTrackerProxy) RVProxy.get(JSAPIEventTrackerProxy.class)).trackKeyJSAPIResult(nativeCallContext, jSONObject);
                    if (DefaultNativeBridge.this.c != null) {
                        DefaultNativeBridge.this.c.onSendBack(nativeCallContext);
                    }
                } catch (Exception e) {
                    RVLogger.w(DefaultNativeBridge.TAG, "nativeCallResultPoint error", e);
                }
                if (sendToNativeCallback != null) {
                    nativeCallContext.getStatData().callbackTimeStamp = SystemClock.elapsedRealtime();
                    sendToNativeCallback.onCallback(jSONObject, z2);
                }
                try {
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
                    RVLogger.d(DefaultNativeBridge.TAG, sb3.toString());
                    APILogUtils.logApiSendBack(nativeCallContext, jSONObject, jSONUtils);
                } catch (Exception e2) {
                    RVLogger.w(DefaultNativeBridge.TAG, "logApiSendBack error", e2);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(RVTraceKey.RV_JSAPI_onCallback_);
                sb4.append(nativeCallContext.getName());
                RVTraceUtils.traceEndSection(sb4.toString());
            }
        });
        RVJsStatTrackService rVJsStatTrackService = this.c;
        if (rVJsStatTrackService != null) {
            rVJsStatTrackService.onCallDispatch(nativeCallContext);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("executeNative jsapi req name={");
        sb2.append(nativeCallContext.getName());
        sb2.append("} ");
        sb2.append(nativeCallContext.getId());
        RVLogger.d(TAG, sb2.toString());
        if (((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).shouldInterceptPreInvoke(nativeCallContext.getName())) {
            getNativeCallDispatchPoint(nativeCallContext).onCallDispatch(nativeCallContext);
        }
        APILogUtils.logApiDispatch(nativeCallContext);
        ((JSAPIEventTrackerProxy) RVProxy.get(JSAPIEventTrackerProxy.class)).trackKeyJSAPIInvoke(nativeCallContext);
        getCallTimeoutHandlerPoint(nativeCallContext).monitorTimeout(nativeCallContext, bridgeResponseHelper);
        if (((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).preDispatch(nativeCallContext, bridgeResponseHelper)) {
            RVLogger.w(TAG, "executeNative but intercepted by RVBridgeInterceptProxy!");
            return true;
        } else if (BridgeDispatcher.getInstance().dispatch(nativeCallContext, bridgeResponseHelper, z)) {
            return true;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("executeNative but not found Extension!");
            sb3.append(nativeCallContext.getName());
            RVLogger.w(TAG, sb3.toString());
            if (z && doCheckPermission(nativeCallContext, bridgeResponseHelper)) {
                return true;
            }
            if (((NativeCallNotFoundPoint) ExtensionPoint.as(NativeCallNotFoundPoint.class).node(nativeCallContext.getNode()).useCache(true).create()).handleNotFound(nativeCallContext, bridgeResponseHelper)) {
                getCallTimeoutHandlerPoint(nativeCallContext).monitorTimeout(nativeCallContext, bridgeResponseHelper);
                RVLogger.d(TAG, "executeNative handleNotFound intercepted");
                return true;
            }
            bridgeResponseHelper.sendNotFound();
            return false;
        }
    }

    public boolean doCheckPermission(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        try {
            DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement(nativeCallContext, bridgeResponseHelper, BridgeDispatcher.getInstance().getExtensionManager());
            DefaultAccessController defaultAccessController = new DefaultAccessController();
            defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BridgeGuard(new BridgePermission(nativeCallContext.getName(), nativeCallContext.getName())));
            if (defaultAccessController.check(nativeCallContext.getNode(), arrayList, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("executeNative check pending! ");
                sb.append(nativeCallContext.getName());
                RVLogger.d(TAG, sb.toString());
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("executeNative check success! ");
            sb2.append(nativeCallContext.getName());
            RVLogger.d(TAG, sb2.toString());
            return false;
        } catch (AccessControlException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("executeNative check failed for legacy call! ");
            sb3.append(nativeCallContext.getName());
            RVLogger.d(TAG, sb3.toString());
            String message = e.getMessage();
            if (message.startsWith("N22")) {
                bridgeResponseHelper.sendNoRigHtToInvoke(message);
            } else {
                bridgeResponseHelper.sendNoRigHtToInvoke();
            }
            return true;
        }
    }

    public NativeCallResultPoint getNativeCallResultPoint(NativeCallContext nativeCallContext) {
        return (NativeCallResultPoint) ExtensionPoint.as(NativeCallResultPoint.class).node(nativeCallContext.getNode()).create();
    }

    public NativeCallDispatchPoint getNativeCallDispatchPoint(NativeCallContext nativeCallContext) {
        return (NativeCallDispatchPoint) ExtensionPoint.as(NativeCallDispatchPoint.class).node(nativeCallContext.getNode()).create();
    }

    public NativeCallTimeoutHandlerPoint getCallTimeoutHandlerPoint(NativeCallContext nativeCallContext) {
        return (NativeCallTimeoutHandlerPoint) ExtensionPoint.as(NativeCallTimeoutHandlerPoint.class).node(nativeCallContext.getNode()).create();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public final void release() {
        if (this.f6031a) {
            return;
        }
        this.f6031a = true;
        onRelease();
    }
}
