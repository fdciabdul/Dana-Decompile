package com.alibaba.exthub.api;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.ExtHubInitializer;
import com.alibaba.ariver.ariverexthub.api.RVEApi;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.exthub.ExtHubExtensionManager;
import com.alibaba.exthub.api.RVEContextProviderImpl;
import com.alibaba.exthub.base.ExtHubContext;
import com.alibaba.exthub.event.ExtHubEventManager;
import com.alibaba.exthub.event.listener.ExtHubEventListener;
import com.alibaba.exthub.event.listener.ExtHubEventWithBizTypeListener;
import com.alibaba.exthub.lifecycler.LifecycleManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class ExtHubCaller {

    /* renamed from: a  reason: collision with root package name */
    private static JSONArray f6254a;

    public static boolean isApiAvaliable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!ExtHubInitializer.isAlreadyInit()) {
            ExtHubInitializer.init();
        }
        if (a(str)) {
            return false;
        }
        return (BridgeDispatcher.getInstance().getNativeExtensionManager().findActionMeta(null, str) == null && RVEProxyCenter.getInstance().getApiInfo(str) == null) ? false : true;
    }

    public static void call(final ExtHubCallContext extHubCallContext) {
        if (extHubCallContext == null) {
            return;
        }
        if (TextUtils.isEmpty(extHubCallContext.getApiName())) {
            if (extHubCallContext.getApiResponse() != null) {
                extHubCallContext.getApiResponse().fail(a());
                return;
            }
            return;
        }
        if (!ExtHubInitializer.isAlreadyInit()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.exthub.api.ExtHubCaller.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExtHubInitializer.init();
                        ExtHubCaller.a(ExtHubCallContext.this);
                    }
                });
                return;
            }
            ExtHubInitializer.init();
        }
        a(extHubCallContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ExtHubCallContext extHubCallContext) {
        ExtHubExtensionManager nativeExtensionManager = BridgeDispatcher.getInstance().getNativeExtensionManager();
        ActionMeta findActionMeta = nativeExtensionManager != null ? nativeExtensionManager.findActionMeta(null, extHubCallContext.getApiName()) : null;
        if (a(extHubCallContext.getApiName())) {
            extHubCallContext.getApiResponse().fail(BridgeResponse.NOT_FOUND.get());
        } else if (findActionMeta != null) {
            c(extHubCallContext);
        } else {
            b(extHubCallContext);
        }
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) 2);
        jSONObject.put("errorMessage", (Object) "Invalid Params!");
        return jSONObject;
    }

    private static void b(final ExtHubCallContext extHubCallContext) {
        RVEApi.extApi(extHubCallContext.getApiName(), extHubCallContext.getBizType()).handleApi(new RVEContext(new RVEContextProviderImpl.Builder().activity(extHubCallContext.getActivity()).appId(extHubCallContext.getBizType()).build()), extHubCallContext.getParams(), new RVEApiResponseCallback() { // from class: com.alibaba.exthub.api.ExtHubCaller.2
            @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback
            public final void onResult(JSONObject jSONObject) {
                if (jSONObject.containsKey("error")) {
                    if (ExtHubCallContext.this.getApiResponse() != null) {
                        ExtHubCallContext.this.getApiResponse().fail(jSONObject);
                    }
                } else if (ExtHubCallContext.this.getApiResponse() != null) {
                    ExtHubCallContext.this.getApiResponse().success(jSONObject);
                }
            }
        });
    }

    private static boolean c(final ExtHubCallContext extHubCallContext) {
        return BridgeDispatcher.getInstance().dispatch(d(extHubCallContext), new BridgeResponseHelper(new SendToNativeCallback() { // from class: com.alibaba.exthub.api.ExtHubCaller.3
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public final void onCallback(JSONObject jSONObject, boolean z) {
                if (jSONObject != null && jSONObject.containsKey("error")) {
                    if (ExtHubCallContext.this.getApiResponse() != null) {
                        ExtHubCallContext.this.getApiResponse().fail(jSONObject);
                    }
                } else if (ExtHubCallContext.this.getApiResponse() != null) {
                    ExtHubCallContext.this.getApiResponse().success(jSONObject);
                }
            }
        }), false);
    }

    private static boolean a(String str) {
        if (f6254a == null) {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_exthub_api_dispatch_black_list", "", new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.exthub.api.ExtHubCaller.4
                @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
                public final void onChange(String str2) {
                    try {
                        JSONArray unused = ExtHubCaller.f6254a = JSONArray.parseArray(str2);
                    } catch (Exception unused2) {
                    }
                }
            });
            if (TextUtils.isEmpty(config)) {
                f6254a = new JSONArray();
                return false;
            }
            f6254a = JSONArray.parseArray(config);
        }
        try {
            JSONArray jSONArray = f6254a;
            if (jSONArray != null && jSONArray.size() != 0) {
                if (f6254a.contains("all")) {
                    return true;
                }
                if (f6254a.contains(str)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static ExtHubContext d(ExtHubCallContext extHubCallContext) {
        ExtHubContext extHubContext = new ExtHubContext();
        extHubContext.setName(extHubCallContext.getApiName());
        extHubContext.setParams(extHubCallContext.getParams());
        extHubContext.setActivity(extHubCallContext.getActivity());
        extHubContext.setBizType(extHubCallContext.getBizType());
        extHubContext.setAppId(extHubCallContext.getAppId());
        extHubContext.setNode(LifecycleManager.getInstance().bindViewNode(extHubCallContext.getAppId(), extHubCallContext.getActivity()));
        return extHubContext;
    }

    public static void onEvent(String str, ExtHubEventListener extHubEventListener) {
        ExtHubEventManager.getInstance().onEvent(str, extHubEventListener);
    }

    public static void offEvent(Activity activity) {
        ExtHubEventManager.getInstance().offEvent(activity);
    }

    public static void onEvent(String str, String str2, ExtHubEventWithBizTypeListener extHubEventWithBizTypeListener) {
        ExtHubEventManager.getInstance().onEvent(str, str2, extHubEventWithBizTypeListener);
    }

    public static void offEvent(String str) {
        ExtHubEventManager.getInstance().offGlobalEventWithBizType(str);
    }

    public static void offEvent(String str, String str2) {
        ExtHubEventManager.getInstance().offGlobalEventWithBizType(str, str2);
    }
}
