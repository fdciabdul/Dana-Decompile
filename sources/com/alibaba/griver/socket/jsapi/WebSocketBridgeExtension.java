package com.alibaba.griver.socket.jsapi;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.NativeActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.websocket.WSConstant;
import com.alibaba.ariver.websocket.core.RVWebSocketManager;
import com.alibaba.ariver.websocket.core.WebSocketResultEnum;
import com.alibaba.ariver.websocket.core.WebSocketSession;
import com.alibaba.ariver.websocket.proxy.ConnectSocketInterceptPoint;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.socket.R;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.data.here.HereOauthManager;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebSocketBridgeExtension implements BridgeExtension, NodeAware<App> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WebSocketBridgeCallback> f6651a = new HashMap();
    private App b;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.f6651a.clear();
        if (this.b != null) {
            WebSocketSession socketSession = RVWebSocketManager.getInstance().getSocketSession(this.b.getAppId());
            if (socketSession != null) {
                socketSession.closeAllSocket();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RDConstant.REMOTE_DEBUG_ID);
            sb.append(this.b.getAppId());
            WebSocketSession socketSession2 = RVWebSocketManager.getInstance().getSocketSession(sb.toString());
            if (socketSession2 != null) {
                socketSession2.closeAllSocket();
            }
        }
    }

    @NativeActionFilter
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void connectSocket(@BindingNode(App.class) final App app, @BindingNode(Page.class) final Page page, @BindingParam({"url"}) final String str, @BindingParam({"data"}) final JSONObject jSONObject, @BindingParam({"socketTaskID"}) final String str2, @BindingParam({"multiple"}) final boolean z, @BindingParam({"protocols"}) final JSONArray jSONArray, @BindingParam({"header"}) final JSONObject jSONObject2, @BindingParam({"fromRemoteDebug"}) final boolean z2, @BindingRequest JSONObject jSONObject3, @BindingCallback final BridgeCallback bridgeCallback) {
        if (((ConnectSocketInterceptPoint) ExtensionPoint.as(ConnectSocketInterceptPoint.class).node(page).create()).interceptConnectSocket(page, jSONObject3, bridgeCallback)) {
            return;
        }
        final String userAgent = page.getRender().getUserAgent();
        ExecutorUtils.getScheduledExecutor().execute(new Runnable() { // from class: com.alibaba.griver.socket.jsapi.WebSocketBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                bridgeCallback.sendBridgeResponse(WebSocketBridgeExtension.this.a(app, page, str, jSONObject, str2, z, jSONArray, jSONObject2, z2, userAgent));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BridgeResponse a(App app, Page page, String str, JSONObject jSONObject, String str2, boolean z, JSONArray jSONArray, JSONObject jSONObject2, boolean z2, String str3) {
        String appId;
        String scheme;
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(RDConstant.REMOTE_DEBUG_ID);
            sb.append(app.getAppId());
            appId = sb.toString();
        } else {
            appId = app.getAppId();
        }
        String str4 = appId;
        page.getRender().getRenderBridge();
        RVLogger.d("AriverAPIWebSocketBridgeExtension", String.format("enter connectSocket, appId: %s", str4));
        boolean z3 = z && !TextUtils.isEmpty(str2);
        WebSocketSession socketSession = RVWebSocketManager.getInstance().getSocketSession(str4);
        if (socketSession == null) {
            socketSession = RVWebSocketManager.getInstance().createSocketSession(str4);
        } else if (z3 && socketSession.getClientCount() >= 5) {
            return BridgeResponse.newError(3, "exceed each tiny app max socket count");
        }
        if (socketSession.isOpen(str2)) {
            RVLogger.d("AriverAPIWebSocketBridgeExtension", "the already appid has a websocket");
            return BridgeResponse.newError(3, LangResourceUtil.getString(R.string.ariver_jsapi_websocket_already_exist));
        } else if (TextUtils.isEmpty(str)) {
            return a(WebSocketResultEnum.URL_IS_NULL_MSG);
        } else {
            String appendQueryJson2Url = appendQueryJson2Url(str, jSONObject);
            RVLogger.d("AriverAPIWebSocketBridgeExtension", String.format("url is %s", appendQueryJson2Url));
            try {
                scheme = new URI(appendQueryJson2Url).getScheme();
            } catch (URISyntaxException e) {
                RVLogger.e("AriverAPIWebSocketBridgeExtension", e);
            }
            if (TextUtils.isEmpty(scheme)) {
                RVLogger.d("AriverAPIWebSocketBridgeExtension", String.format("connect fail : %s ", appendQueryJson2Url));
                return a(WebSocketResultEnum.URL_NOT_WELL_FORMAT);
            }
            if (!WSConstant.SCHEME_WS.equalsIgnoreCase(scheme) && !WSConstant.SCHEME_WSS.equalsIgnoreCase(scheme)) {
                RVLogger.d("AriverAPIWebSocketBridgeExtension", String.format("url error: %s not ws:// or wss://", appendQueryJson2Url));
                return a(WebSocketResultEnum.URL_NOT_WS_OR_WSS);
            }
            RVLogger.d("AriverAPIWebSocketBridgeExtension", String.format("send request ok, url is : %s ,appid: %s", appendQueryJson2Url, str4));
            Map<String, String> a2 = a(jSONObject2);
            a2.put(HttpHeaders.USER_AGENT, str3);
            a2.remove("referer");
            String a3 = a(jSONArray);
            if (!TextUtils.isEmpty(a3)) {
                a2.put(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, a3);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("protocols: ");
            sb2.append(a3);
            RVLogger.d("AriverAPIWebSocketBridgeExtension", sb2.toString());
            try {
                WebSocketBridgeCallback webSocketBridgeCallback = new WebSocketBridgeCallback(page, str2, z);
                Map<String, WebSocketBridgeCallback> map = this.f6651a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(str2);
                map.put(sb3.toString(), webSocketBridgeCallback);
                socketSession.startSocketConnect(appendQueryJson2Url, str2, a2, webSocketBridgeCallback);
                return BridgeResponse.SUCCESS;
            } catch (Exception e2) {
                return BridgeResponse.newError(3, e2.toString());
            }
        }
    }

    @NativeActionFilter
    @ActionFilter
    @AutoCallback
    public BridgeResponse sendSocketMessage(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"data"}) String str, @BindingParam({"socketTaskID"}) String str2, @BindingParam({"isBuffer"}) boolean z, @BindingParam({"fromRemoteDebug"}) boolean z2) {
        String appId;
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(RDConstant.REMOTE_DEBUG_ID);
            sb.append(app.getAppId());
            appId = sb.toString();
        } else {
            appId = app.getAppId();
        }
        WebSocketSession socketSession = RVWebSocketManager.getInstance().getSocketSession(appId);
        if (socketSession == null) {
            RVLogger.d("AriverAPIWebSocketBridgeExtension", "sendSocketMessage error , not exist WebsocketSession");
            return a(WebSocketResultEnum.CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN);
        } else if (!socketSession.isOpen(str2)) {
            RVLogger.d("AriverAPIWebSocketBridgeExtension", "sendSocketMessage error , no websocket connection is established");
            return a(WebSocketResultEnum.CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN);
        } else {
            if (!z2) {
                Map<String, WebSocketBridgeCallback> map = this.f6651a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(appId);
                sb2.append(str2);
                WebSocketBridgeCallback webSocketBridgeCallback = map.get(sb2.toString());
                if (webSocketBridgeCallback == null) {
                    RVLogger.d("AriverAPIWebSocketBridgeExtension", "sendSocketMessage error , no callback!!!");
                    return a(WebSocketResultEnum.UNKNOW_ERROR);
                }
                webSocketBridgeCallback.setPage(page);
            }
            if (str == null) {
                RVLogger.e("AriverAPIWebSocketBridgeExtension", "Cannot send 'null' data to a WebSocket");
                return BridgeResponse.newError(3, "Cannot send 'null' data to a WebSocket");
            }
            try {
                if (z) {
                    socketSession.sendMessage(str2, str.getBytes(HereOauthManager.ENC));
                } else {
                    socketSession.sendMessage(str2, str);
                }
                return BridgeResponse.SUCCESS;
            } catch (Exception e) {
                RVLogger.e("AriverAPIWebSocketBridgeExtension", "send socket error!", e);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("send socket error! ");
                sb3.append(e.getMessage());
                return BridgeResponse.newError(3, sb3.toString());
            }
        }
    }

    @NativeActionFilter
    @ActionFilter
    @AutoCallback
    public BridgeResponse closeSocket(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"socketTaskID"}) String str, @BindingParam({"fromRemoteDebug"}) boolean z) {
        String appId;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(RDConstant.REMOTE_DEBUG_ID);
            sb.append(app.getAppId());
            appId = sb.toString();
        } else {
            appId = app.getAppId();
        }
        WebSocketSession socketSession = RVWebSocketManager.getInstance().getSocketSession(appId);
        if (socketSession == null) {
            RVLogger.d("AriverAPIWebSocketBridgeExtension", "closeSocket error , not exist WebsocketSession");
            return BridgeResponse.SUCCESS;
        }
        Map<String, WebSocketBridgeCallback> map = this.f6651a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(appId);
        sb2.append(str);
        if (map.get(sb2.toString()) == null) {
            RVLogger.d("AriverAPIWebSocketBridgeExtension", "sendSocketMessage error , no callback!!!");
            return BridgeResponse.SUCCESS;
        }
        socketSession.closeSocketConnect(str);
        return BridgeResponse.SUCCESS;
    }

    private BridgeResponse a(WebSocketResultEnum webSocketResultEnum) {
        return BridgeResponse.newError(webSocketResultEnum.getErrCode(), webSocketResultEnum.getErrMsg());
    }

    private String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                sb.append(next.toString());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isEmpty()) {
                    for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            hashMap.put(key.toLowerCase(), String.valueOf(entry.getValue()));
                        }
                    }
                }
            } catch (Exception e) {
                RVLogger.e("AriverAPIWebSocketBridgeExtension", "get header error, exception : ", e);
            }
        }
        return hashMap;
    }

    public static String appendQueryJson2Url(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!jSONObject.isEmpty()) {
                    StringBuilder sb = new StringBuilder(str);
                    if (str.indexOf("?") > 0) {
                        if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                            sb.append(ContainerUtils.FIELD_DELIMITER);
                        }
                    } else {
                        sb.append("?");
                    }
                    for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            sb.append(key);
                            sb.append("=");
                            sb.append(entry.getValue());
                            sb.append(ContainerUtils.FIELD_DELIMITER);
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
            } catch (Throwable th) {
                RVLogger.e("AriverAPIWebSocketBridgeExtension", "appendQueryJson2Url error.", th);
            }
        }
        return str;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.b = weakReference.get();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }
}
