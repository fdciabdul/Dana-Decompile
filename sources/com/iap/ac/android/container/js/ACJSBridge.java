package com.iap.ac.android.container.js;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.container.interceptor.BridgeResponse;
import com.iap.ac.android.common.container.js.AlipayJSAPI;
import com.iap.ac.android.common.container.js.model.JSBridgeMessageToNative;
import com.iap.ac.android.common.container.js.model.JSBridgeMessageToWeb;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.container.utils.ContainerUtils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.container.ACContainer;
import com.iap.ac.android.container.BuildConfig;
import com.iap.ac.android.container.constant.ContainerErrorCode;
import com.iap.ac.android.container.constant.LogEventKeys;
import com.iap.ac.android.container.constant.LogEventName;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import com.iap.ac.android.container.utils.ResourceUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ACJSBridge {
    public static final String JSAPI_PREFIX = "h5container.message: ";
    private static final String JS_PARAM_PARAM = "param";
    public static final String PARAM_MSG = "msg";
    public static final String PARAM_SUCCESS = "success";
    private static final String TAG = "ACJSBridge";
    private static Map<String, ACJSBridge> acjsBridgeMap = new HashMap();
    private String bizCode;
    Map<String, BaseJSPlugin> jsPluginMap = new ConcurrentHashMap();
    private Map<Integer, String> rawCache = new HashMap();

    private ACJSBridge(String str) {
        this.bizCode = str;
        registerJSAPIPlugin(new ACContainerJSPlugin());
    }

    public void registerJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        if (baseJSPlugin == null) {
            return;
        }
        for (Method method : baseJSPlugin.getClass().getDeclaredMethods()) {
            AlipayJSAPI alipayJSAPI = (AlipayJSAPI) method.getAnnotation(AlipayJSAPI.class);
            if (alipayJSAPI != null) {
                this.jsPluginMap.put(alipayJSAPI.api(), baseJSPlugin);
            }
        }
    }

    public static ACJSBridge getInstance(String str) {
        ACJSBridge aCJSBridge;
        synchronized (ACJSBridge.class) {
            aCJSBridge = acjsBridgeMap.get(str);
            if (aCJSBridge == null) {
                aCJSBridge = new ACJSBridge(str);
                acjsBridgeMap.put(str, aCJSBridge);
            }
        }
        return aCJSBridge;
    }

    public void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        if (baseJSPlugin == null) {
            return;
        }
        for (Method method : baseJSPlugin.getClass().getDeclaredMethods()) {
            AlipayJSAPI alipayJSAPI = (AlipayJSAPI) method.getAnnotation(AlipayJSAPI.class);
            if (alipayJSAPI != null) {
                String api = alipayJSAPI.api();
                if (this.jsPluginMap.get(api) != null && baseJSPlugin.equals(this.jsPluginMap.get(api))) {
                    this.jsPluginMap.remove(api);
                }
            }
        }
    }

    public boolean handleMsgFromJs(String str, WebView webView, IContainerPresenter iContainerPresenter) {
        JSBridgeMessageToNative jSBridgeMessageToNative;
        if (str == null || TextUtils.isEmpty(str) || !str.startsWith(JSAPI_PREFIX) || webView == null) {
            return false;
        }
        String substring = str.substring(21);
        String url = webView.getUrl();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("handleMsgFromJs message: ");
            sb.append(substring);
            sb.append(", current url: ");
            sb.append(url);
            ACLog.d(TAG, sb.toString());
            try {
                jSBridgeMessageToNative = (JSBridgeMessageToNative) JsonUtils.fromJson(substring, JSBridgeMessageToNative.class);
                try {
                    if (jSBridgeMessageToNative == null) {
                        ACLog.w(TAG, "handleMsgFromJs error: jsBridgeMessage is null!");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("jsBridgeMessage is null. message: ");
                        sb2.append(substring);
                        reportJsapiError(url, "Unknown", 1009, sb2.toString());
                        return false;
                    } else if (hasJSPermission(jSBridgeMessageToNative.func, url)) {
                        JSONObject jSONObject = new JSONObject(substring);
                        if (jSONObject.has("param") && !jSONObject.isNull("param")) {
                            jSBridgeMessageToNative.param = jSONObject.getJSONObject("param");
                        }
                        handelJSAPI(jSBridgeMessageToNative, webView, iContainerPresenter);
                        return true;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("JS permission denied. JS function: ");
                        sb3.append(jSBridgeMessageToNative.func);
                        String obj = sb3.toString();
                        ACLog.e(TAG, obj);
                        HashMap hashMap = new HashMap();
                        hashMap.put("success", "false");
                        hashMap.put("msg", "Permission denied!");
                        sendBack(jSBridgeMessageToNative, webView, new JSONObject(hashMap));
                        reportJsapiError(url, jSBridgeMessageToNative.func, 1011, obj);
                        return true;
                    }
                } catch (Exception e) {
                    e = e;
                    ACLog.e(TAG, substring, e);
                    String str2 = jSBridgeMessageToNative != null ? jSBridgeMessageToNative.func : "Unknown";
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(e.getMessage());
                    sb4.append("\n ");
                    sb4.append(substring);
                    reportJsapiError(url, str2, ContainerErrorCode.JS_RUN_FAIL, sb4.toString());
                    return false;
                }
            } catch (Exception unused) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("message: ");
                sb5.append(substring);
                reportJsapiError(url, "Unknown", 1009, sb5.toString());
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            jSBridgeMessageToNative = null;
        }
    }

    private void reportJsapiError(String str, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("func", str2);
        hashMap.put(LogEventKeys.SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put("status", LogConstants.RESULT_FALSE);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        hashMap.put(LogEventKeys.ERROR_CODE, sb.toString());
        hashMap.put(LogEventKeys.ERROR_MSG, str3);
        ACMonitor.getInstance(this.bizCode).logEvent(new LogEvent(LogEventName.JSAPI_CALL, hashMap));
    }

    boolean hasJSPermission(String str, String str2) {
        try {
            JsApiPermissionProvider jsApiPermissionProvider = (JsApiPermissionProvider) ACContainer.INSTANCE.getProvider(JsApiPermissionProvider.class.getName());
            if (jsApiPermissionProvider != null) {
                return jsApiPermissionProvider.hasDomainPermission(str, str2);
            }
            return true;
        } catch (Exception e) {
            ACLog.e(TAG, "check jsapi permission error: ", e);
            return true;
        }
    }

    void handelJSAPI(final JSBridgeMessageToNative jSBridgeMessageToNative, final WebView webView, IContainerPresenter iContainerPresenter) {
        BridgeInterceptor bridgeInterceptor;
        if (jSBridgeMessageToNative == null || TextUtils.isEmpty(jSBridgeMessageToNative.func)) {
            return;
        }
        if (ACContainer.INSTANCE.isJSAPIRegistered(jSBridgeMessageToNative.func) && (bridgeInterceptor = (BridgeInterceptor) ACContainer.INSTANCE.getJSAPIInterceptor(jSBridgeMessageToNative.func)) != null) {
            bridgeInterceptor.willHandleJSAPI(jSBridgeMessageToNative.func, new BridgeInterceptor.InterceptContext(), new BridgeCallback() { // from class: com.iap.ac.android.container.js.ACJSBridge.1
                @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject, boolean z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("sendJSONResponse:");
                    sb.append(jSONObject);
                    ACLog.e(ACJSBridge.TAG, sb.toString() == null ? "null" : jSONObject.toString());
                }

                @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject) {
                    ACJSBridge.this.sendBack(jSBridgeMessageToNative, webView, jSONObject);
                }

                @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
                public void sendBridgeResponse(BridgeResponse bridgeResponse) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("sendBridgeResponse:");
                    sb.append(bridgeResponse);
                    ACLog.e(ACJSBridge.TAG, (sb.toString() == null || bridgeResponse.response == null) ? "null" : bridgeResponse.response.toString());
                }
            });
            return;
        }
        String url = webView == null ? "" : webView.getUrl();
        BaseJSPlugin baseJSPlugin = this.jsPluginMap.get(jSBridgeMessageToNative.func);
        HashMap hashMap = new HashMap();
        if (baseJSPlugin == null) {
            hashMap.put("success", "false");
            StringBuilder sb = new StringBuilder();
            sb.append("No JSPlugin found for: ");
            sb.append(jSBridgeMessageToNative.func);
            String obj = sb.toString();
            hashMap.put("msg", obj);
            sendBack(jSBridgeMessageToNative, webView, new JSONObject(hashMap));
            reportJsapiError(url, jSBridgeMessageToNative.func, 1008, obj);
            return;
        }
        try {
            JSONObject onJSEvent = baseJSPlugin.onJSEvent(jSBridgeMessageToNative, iContainerPresenter, new ACBridgeContext(webView, this.bizCode));
            if (onJSEvent != null) {
                sendBack(jSBridgeMessageToNative, webView, onJSEvent);
            }
        } catch (Exception e) {
            ACLog.e(TAG, "", e);
            hashMap.put("success", "false");
            String message = e.getMessage();
            if (e instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e;
                if (invocationTargetException.getTargetException() != null) {
                    message = invocationTargetException.getTargetException().getMessage();
                }
            }
            hashMap.put("msg", message);
            sendBack(jSBridgeMessageToNative, webView, new JSONObject(hashMap));
            reportJsapiError(url, jSBridgeMessageToNative.func, ContainerErrorCode.JS_RUN_FAIL, e.getMessage());
        }
    }

    public void sendBack(JSBridgeMessageToNative jSBridgeMessageToNative, WebView webView, JSONObject jSONObject) {
        if (webView == null || jSBridgeMessageToNative == null) {
            return;
        }
        JSBridgeMessageToWeb jSBridgeMessageToWeb = new JSBridgeMessageToWeb(jSBridgeMessageToNative);
        jSBridgeMessageToWeb.param = jSONObject;
        sendMsgToWeb(jSBridgeMessageToWeb, webView);
    }

    void sendMsgToWeb(JSBridgeMessageToWeb jSBridgeMessageToWeb, WebView webView) {
        if (jSBridgeMessageToWeb == null || webView == null) {
            ACLog.w(TAG, "sendMsgToWeb error: jsBridgeMessageToWeb or webView is null!");
            return;
        }
        try {
            if (ContainerUtils.isActivityRunning((Activity) webView.getContext())) {
                String json = JsonUtils.toJson(JsonUtils.toJson(jSBridgeMessageToWeb));
                StringBuilder sb = new StringBuilder();
                sb.append("AlipayJSBridge._invokeJS(");
                sb.append(json);
                sb.append(")");
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("javascript:(function(){if(typeof AlipayJSBridge === 'object'){");
                sb2.append(obj);
                sb2.append("}})();");
                String obj2 = sb2.toString();
                InstrumentInjector.trackWebView(webView);
                webView.loadUrl(obj2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("sendBack javascript: ");
                sb3.append(obj);
                ACLog.d(TAG, sb3.toString());
            }
        } catch (Throwable th) {
            ACLog.e(TAG, "sendMsgToWeb error!", th);
            reportJsapiError(webView.getUrl(), jSBridgeMessageToWeb.func, 1010, th.getMessage());
        }
    }

    public void loadJavascript(int i, Context context, WebView webView) throws IOException {
        String str;
        if (context == null || webView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.rawCache.get(Integer.valueOf(i)))) {
            str = ResourceUtils.readRawFromResource(i, context.getResources());
        } else {
            str = this.rawCache.get(Integer.valueOf(i));
        }
        if (TextUtils.isEmpty(str)) {
            throw new IOException("Read raw resource fail!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.JAVASCRIPT_SCHEME);
        sb.append(str);
        String obj = sb.toString();
        InstrumentInjector.trackWebView(webView);
        webView.loadUrl(obj);
    }
}
