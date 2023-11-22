package com.alibaba.ariver.engine.common.bridge.dispatch;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.extension.BindBridgeExtensionInvoker;
import com.alibaba.ariver.engine.common.extension.NativePermissionExtensionInvoker;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.ExtNativeDefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ExtHubConstants;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.exthub.ExtHubExtensionManager;
import com.alibaba.exthub.base.ExtHubContext;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class BridgeDispatcher {
    public static final String TAG;

    /* renamed from: a */
    private static volatile BridgeDispatcher f6033a;
    private ExtensionManager b;
    private ExtHubExtensionManager c;
    private RVConfigService d = (RVConfigService) RVProxy.get(RVConfigService.class);
    private JSONObject e;
    private RVJsStatTrackService f;
    private RVConfigService.OnConfigChangeListener g;
    private JSONArray h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("AriverEngine:");
        sb.append("BridgeDispatcher");
        TAG = sb.toString();
    }

    private BridgeDispatcher() {
        this.g = null;
        RVConfigService.OnConfigChangeListener onConfigChangeListener = new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher.1
            {
                BridgeDispatcher.this = this;
            }

            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public void onChange(String str) {
                try {
                    BridgeDispatcher.this.e = JSONObject.parseObject(str);
                } catch (Exception unused) {
                    BridgeDispatcher.this.e = null;
                }
            }
        };
        this.g = onConfigChangeListener;
        try {
            this.e = JSONObject.parseObject(this.d.getConfig("ta_extension_dispatch_whitelist", null, onConfigChangeListener));
        } catch (Exception unused) {
            this.e = null;
        }
        this.f = (RVJsStatTrackService) RVProxy.get(RVJsStatTrackService.class);
        a();
    }

    public static BridgeDispatcher getInstance() {
        if (f6033a == null) {
            synchronized (BridgeDispatcher.class) {
                if (f6033a == null) {
                    f6033a = new BridgeDispatcher();
                }
            }
        }
        return f6033a;
    }

    public void bindExtensionManager(ExtensionManager extensionManager) {
        this.b = extensionManager;
    }

    public void bindNativeExtensionManager(ExtHubExtensionManager extHubExtensionManager) {
        this.c = extHubExtensionManager;
    }

    public ExtensionManager getExtensionManager() {
        return this.b;
    }

    public ExtHubExtensionManager getNativeExtensionManager() {
        return this.c;
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z) {
        return dispatch(nativeCallContext, bridgeResponseHelper, z, this.b);
    }

    public boolean dispatch(ExtHubContext extHubContext, BridgeResponseHelper bridgeResponseHelper, boolean z) {
        ExtHubExtensionManager extHubExtensionManager = this.c;
        if (extHubExtensionManager == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("BridgeDispatcher dispatch mNativeExtensionManager == null!\t");
            sb.append(extHubContext.getName());
            ExtHubLogger.w(str, sb.toString());
            return false;
        }
        ActionMeta findActionMeta = extHubExtensionManager.findActionMeta(null, extHubContext.getName());
        if (findActionMeta == null) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BridgeDispatcher dispatch findActionMeta == null!\t");
            sb2.append(extHubContext.getName());
            ExtHubLogger.w(str2, sb2.toString());
            return false;
        }
        try {
            BridgeExtension bridgeExtensionByActionMeta = this.c.getBridgeExtensionByActionMeta(extHubContext.getNode(), findActionMeta);
            if (bridgeExtensionByActionMeta == null) {
                ExtHubLogger.w(TAG, "BridgeDispatcher dispatch getBridgeExtensionByAction == null!");
                return false;
            }
            ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
            ExtensionInvoker nativePermissionExtensionInvoker = new NativePermissionExtensionInvoker(null, bridgeResponseHelper, extensionInvokerFactory.createScheduleExtensionInvoker(new BindBridgeExtensionInvoker(extHubContext.getNode(), extHubContext, bridgeResponseHelper, findActionMeta)), findActionMeta);
            if (z) {
                ExtNativeDefaultAccessController extNativeDefaultAccessController = new ExtNativeDefaultAccessController();
                extNativeDefaultAccessController.setAccessControlManagement(null);
                nativePermissionExtensionInvoker = extensionInvokerFactory.createPermissionExtensionInvoker(findActionMeta, extNativeDefaultAccessController, nativePermissionExtensionInvoker);
            }
            nativePermissionExtensionInvoker.attacheTargetExtensions(bridgeExtensionByActionMeta);
            try {
                nativePermissionExtensionInvoker.invoke(bridgeExtensionByActionMeta, findActionMeta.actionMethod, new Object[findActionMeta.paramTypes != null ? findActionMeta.paramTypes.length : 0]);
                return true;
            } catch (Throwable th) {
                String str3 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("native dispatch error，t = ");
                sb3.append(th);
                ExtHubLogger.e(str3, sb3.toString());
                return true;
            }
        } catch (Throwable th2) {
            ExtHubLogger.e(TAG, "dispatch BridgeExtension error", th2);
            return false;
        }
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager) {
        return dispatch(nativeCallContext, bridgeResponseHelper, z, extensionManager, null);
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager, ApiContext apiContext) {
        ActionMeta findActionMeta;
        StringBuilder sb;
        if (!RDConstant.TINY_DEBUG_CONSOLE.equals(nativeCallContext.getName()) && !"tinyAppConfig".equals(nativeCallContext.getName()) && !"internalAPI".equals(nativeCallContext.getName()) && !"remoteLog".equals(nativeCallContext.getName()) && !"handleLoggingAction".equals(nativeCallContext.getName()) && !NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(nativeCallContext.getName())) {
            ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("setPageJsApiCount", nativeCallContext.getNode(), nativeCallContext);
        }
        int i = 0;
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            ExtHubLogger.w(TAG, "BridgeDispatcher dispatch context.getName() == null!");
            return false;
        }
        if (apiContext != null) {
            apiContext.setBizType(ExtHubConstants.KEY_NEBULA);
        }
        InstanceType instanceTypeFromParam = MultiInstanceUtils.getInstanceTypeFromParam(nativeCallContext.getParams());
        if (instanceTypeFromParam != null) {
            findActionMeta = extensionManager.findActionMeta(instanceTypeFromParam, nativeCallContext.getNode(), nativeCallContext.getName());
        } else {
            findActionMeta = extensionManager.findActionMeta(nativeCallContext.getNode(), nativeCallContext.getName());
        }
        ActionMeta actionMeta = findActionMeta;
        if (actionMeta == null) {
            String str = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BridgeDispatcher dispatch findActionMeta == null!\t");
            sb2.append(nativeCallContext.getName());
            ExtHubLogger.w(str, sb2.toString());
            return false;
        }
        JSONObject jSONObject = this.e;
        if (jSONObject != null && jSONObject.containsKey(nativeCallContext.getName())) {
            JSONArray jSONArray = this.e.getJSONArray(nativeCallContext.getName());
            if (!CollectionUtils.isEmpty(jSONArray) && nativeCallContext.getNode() != null && !jSONArray.contains((String) ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("getAppId", nativeCallContext.getNode(), nativeCallContext)) && !jSONArray.contains("all")) {
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("BridgeDispatch dispatch fallback extension ");
                sb3.append(nativeCallContext.getName());
                ExtHubLogger.d(str2, sb3.toString());
                return false;
            }
        }
        try {
            BridgeExtension bridgeExtensionByActionMeta = extensionManager.getBridgeExtensionByActionMeta(nativeCallContext.getNode(), actionMeta);
            if (bridgeExtensionByActionMeta == null) {
                ExtHubLogger.w(TAG, "BridgeDispatcher dispatch getBridgeExtensionByAction == null!");
                return false;
            }
            ExtensionInvoker a2 = a(nativeCallContext, bridgeResponseHelper, z, extensionManager, actionMeta, apiContext);
            a2.attacheTargetExtensions(bridgeExtensionByActionMeta);
            try {
                try {
                    try {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("RV_JSAPI_Dispatch_");
                        sb4.append(nativeCallContext.getName());
                        RVTraceUtils.traceBeginSection(sb4.toString());
                        Method method = actionMeta.actionMethod;
                        if (actionMeta.paramTypes != null) {
                            i = actionMeta.paramTypes.length;
                        }
                        Object[] objArr = new Object[i];
                        RVJsStatTrackService rVJsStatTrackService = this.f;
                        if (rVJsStatTrackService != null) {
                            rVJsStatTrackService.onInvoke(nativeCallContext);
                        }
                        a2.invoke(bridgeExtensionByActionMeta, method, objArr);
                        sb = new StringBuilder();
                    } catch (AccessControlException e) {
                        String message = e.getMessage();
                        if (bridgeResponseHelper != null) {
                            if (message.startsWith("N22")) {
                                bridgeResponseHelper.sendNoRigHtToInvoke(message);
                            } else {
                                bridgeResponseHelper.sendNoRigHtToInvoke();
                            }
                        }
                        ExtHubLogger.e(TAG, "bridge extension fail AccessControlException:", e);
                        sb = new StringBuilder();
                    }
                } catch (Throwable th) {
                    if (bridgeResponseHelper != null) {
                        bridgeResponseHelper.sendError(3, th.getMessage());
                    }
                    String str3 = TAG;
                    ExtHubLogger.e(str3, "bridge extension fail Throwable:", th);
                    String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_throwjsapiexception", "");
                    String productId = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getProductId();
                    if ("yes".equalsIgnoreCase(configWithProcessCache) && !"Android-container".equalsIgnoreCase(productId)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("unpublished version throw exception ");
                        sb5.append(th.getMessage());
                        ExtHubLogger.d(str3, sb5.toString());
                        throw new RuntimeException(th);
                    }
                    sb = new StringBuilder();
                }
                sb.append("RV_JSAPI_Dispatch_");
                sb.append(nativeCallContext.getName());
                RVTraceUtils.traceEndSection(sb.toString());
                return true;
            } catch (Throwable th2) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("RV_JSAPI_Dispatch_");
                sb6.append(nativeCallContext.getName());
                RVTraceUtils.traceEndSection(sb6.toString());
                throw th2;
            }
        } catch (Throwable th3) {
            ExtHubLogger.e(TAG, "dispatch BridgeExtension error", th3);
            return false;
        }
    }

    private ExtensionInvoker a(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager, ActionMeta actionMeta, ApiContext apiContext) {
        ExtensionInvoker createScheduleExtensionInvoker;
        ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
        BindBridgeExtensionInvoker bindBridgeExtensionInvoker = new BindBridgeExtensionInvoker(nativeCallContext.getNode(), nativeCallContext, bridgeResponseHelper, actionMeta, apiContext, null);
        SendToNativeCallback innerBridgeResponse = bridgeResponseHelper == null ? null : bridgeResponseHelper.getInnerBridgeResponse();
        if (!ProcessUtils.isMainProcess()) {
            a(nativeCallContext, actionMeta);
            createScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(extensionInvokerFactory.createRemoteBridgeExtensionInvoker(innerBridgeResponse, nativeCallContext, extensionManager.getRemoteController(), bindBridgeExtensionInvoker));
        } else {
            createScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(bindBridgeExtensionInvoker);
        }
        NativePermissionExtensionInvoker nativePermissionExtensionInvoker = new NativePermissionExtensionInvoker(nativeCallContext, nativeCallContext.getNode(), bridgeResponseHelper, createScheduleExtensionInvoker, actionMeta);
        return z ? extensionInvokerFactory.createPermissionExtensionInvoker(nativeCallContext, bridgeResponseHelper, extensionManager, actionMeta, nativePermissionExtensionInvoker) : nativePermissionExtensionInvoker;
    }

    private void a(NativeCallContext nativeCallContext, ActionMeta actionMeta) {
        JSONObject params;
        try {
            String str = actionMeta.actionName;
            if ("setTinyLocalStorage".equals(str) || JSApiCachePoint.GET_LOCAL_STORAGE.equals(str) || "removeTinyLocalStorage".equals(str) || "clearTinyLocalStorage".equals(str) || "getTinyLocalStorageInfo".equals(str)) {
                String str2 = (String) ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("getAppId", nativeCallContext.getNode(), nativeCallContext);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONArray jSONArray = this.h;
                if (jSONArray != null && jSONArray.size() != 0) {
                    String str3 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ta_storage_in_tiny_process_for_appid config value = ");
                    sb.append(this.h.toJSONString());
                    ExtHubLogger.d(str3, sb.toString());
                    if ((!this.h.contains("all") && !this.h.contains(str2)) || (params = nativeCallContext.getParams()) == null || params.containsKey("jsapiEnableRemote")) {
                        return;
                    }
                    params.put("jsapiEnableRemote", (Object) Boolean.FALSE);
                    return;
                }
                ExtHubLogger.d(TAG, "ta_storage_in_tiny_process_for_appid config value = null");
            }
        } catch (Throwable th) {
            ExtHubLogger.e(TAG, "storageInTinyProcess config  ", th);
        }
    }

    private void a() {
        a(this.d.getConfig("ta_storage_in_tiny_process_for_appid", null, new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher.2
            {
                BridgeDispatcher.this = this;
            }

            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public void onChange(String str) {
                BridgeDispatcher.this.a(str);
            }
        }));
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h = JSONArray.parseArray(str);
        } catch (Exception unused) {
            this.h = null;
        }
    }
}
