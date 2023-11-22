package com.alibaba.ariver.websocket.core;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.websocket.WSConstant;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebSocketSession {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, RVWebSocketClient> f6252a = new ConcurrentHashMap();
    private String b;

    public WebSocketSession(String str) {
        this.b = str;
    }

    private RVWebSocketClient a(String str, String str2, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) {
        return ((RVWebSocketProxy) RVProxy.get(RVWebSocketProxy.class)).createWebSocketClient(this.b, str2, map, new RVWebSocketCallbackProxy(str, rVWebSocketCallback));
    }

    public void startSocketConnect(String str, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) throws IOException, InvalidParameterException {
        startSocketConnect(str, "DEFAULT-TASK-ID", map, rVWebSocketCallback);
    }

    public void startSocketConnect(String str, String str2, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) throws IOException, InvalidParameterException {
        if (TextUtils.isEmpty(str2)) {
            str2 = "DEFAULT-TASK-ID";
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            StringBuilder sb = new StringBuilder();
            sb.append("url error: ");
            sb.append(str);
            throw new InvalidParameterException(sb.toString());
        }
        RVWebSocketClient a2 = a(str2, str, map, rVWebSocketCallback);
        if (a2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("startSocketConnect createClient is null! taskId: ");
            sb2.append(str2);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("url error: ");
            sb3.append(str);
            throw new InvalidParameterException(sb3.toString());
        }
        RVLogger.d("AriverWebSocket:WebSocketSession", "startSocketConnect.");
        if (WSConstant.SCHEME_WS.equalsIgnoreCase(scheme)) {
            a2.connect();
        } else if (WSConstant.SCHEME_WSS.equalsIgnoreCase(scheme)) {
            a2.connectWithSSL();
        } else {
            throw new InvalidParameterException(String.format("url error: %s not ws:// or wss://", parse.toString()));
        }
        this.f6252a.put(str2, a2);
    }

    public void closeSocketConnect() {
        closeSocketConnect("DEFAULT-TASK-ID");
    }

    public void closeSocketConnect(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "DEFAULT-TASK-ID";
        }
        RVWebSocketClient rVWebSocketClient = this.f6252a.get(str);
        if (rVWebSocketClient == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("closeSocketConnect client is null. taskId: ");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            return;
        }
        RVLogger.d("AriverWebSocket:WebSocketSession", "closeSocketConnect.");
        rVWebSocketClient.close();
    }

    public void closeAllSocket() {
        RVLogger.d("AriverWebSocket:WebSocketSession", "closeAllSocket.");
        Iterator<Map.Entry<String, RVWebSocketClient>> it = this.f6252a.entrySet().iterator();
        while (it.hasNext()) {
            RVWebSocketClient value = it.next().getValue();
            if (value != null) {
                value.close();
            }
            it.remove();
        }
    }

    public void sendMessage(byte[] bArr) {
        sendMessage("DEFAULT-TASK-ID", bArr);
    }

    public void sendMessage(String str) {
        sendMessage("DEFAULT-TASK-ID", str);
    }

    public void sendMessage(String str, byte[] bArr) {
        if (!isOpen(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("sendMessage socket has closed!. taskId: ");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "DEFAULT-TASK-ID";
        }
        RVWebSocketClient rVWebSocketClient = this.f6252a.get(str);
        if (rVWebSocketClient == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendMessage client is null. taskId: ");
            sb2.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb2.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sendMessage data:");
        sb3.append(bArr);
        RVLogger.d("AriverWebSocket:WebSocketSession", sb3.toString());
        rVWebSocketClient.send(bArr);
    }

    public void sendMessage(String str, String str2) {
        if (!isOpen(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("sendMessage socket has closed!. taskId: ");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "DEFAULT-TASK-ID";
        }
        RVWebSocketClient rVWebSocketClient = this.f6252a.get(str);
        if (rVWebSocketClient == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendMessage client is null. taskId: ");
            sb2.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb2.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sendMessage data:");
        sb3.append(str2);
        RVLogger.d("AriverWebSocket:WebSocketSession", sb3.toString());
        rVWebSocketClient.send(str2);
    }

    public boolean isOpen() {
        return isOpen("DEFAULT-TASK-ID");
    }

    public boolean isOpen(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "DEFAULT-TASK-ID";
        }
        RVWebSocketClient rVWebSocketClient = this.f6252a.get(str);
        if (rVWebSocketClient == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("isOpen client is null. taskId: ");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            return false;
        }
        boolean isOpen = rVWebSocketClient.isOpen();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isOpen taskId:");
        sb2.append(str);
        sb2.append(" open:");
        sb2.append(isOpen);
        RVLogger.d("AriverWebSocket:WebSocketSession", sb2.toString());
        return isOpen;
    }

    public int getClientCount() {
        return this.f6252a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class RVWebSocketCallbackProxy implements RVWebSocketCallback {
        RVWebSocketCallback mCallback;
        String mTaskId;

        RVWebSocketCallbackProxy(String str, RVWebSocketCallback rVWebSocketCallback) {
            this.mTaskId = str;
            this.mCallback = rVWebSocketCallback;
        }

        @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
        public void onSocketOpen() {
            RVLogger.d("AriverWebSocket:WebSocketSession", "RVWebSocketCallbackProxy onSocketOpen");
            RVWebSocketCallback rVWebSocketCallback = this.mCallback;
            if (rVWebSocketCallback != null) {
                rVWebSocketCallback.onSocketOpen();
            }
        }

        @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
        public void onSocketClose() {
            RVWebSocketCallback rVWebSocketCallback;
            RVLogger.d("AriverWebSocket:WebSocketSession", "RVWebSocketCallbackProxy onSocketClose");
            if (((RVWebSocketClient) WebSocketSession.this.f6252a.remove(this.mTaskId)) == null || (rVWebSocketCallback = this.mCallback) == null) {
                return;
            }
            rVWebSocketCallback.onSocketClose();
        }

        @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
        public void onSocketMessage(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVWebSocketCallbackProxy onSocketMessage message ");
            sb.append(bArr);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            RVWebSocketCallback rVWebSocketCallback = this.mCallback;
            if (rVWebSocketCallback != null) {
                rVWebSocketCallback.onSocketMessage(bArr);
            }
        }

        @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
        public void onSocketMessage(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVWebSocketCallbackProxy onSocketMessage message ");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            RVWebSocketCallback rVWebSocketCallback = this.mCallback;
            if (rVWebSocketCallback != null) {
                rVWebSocketCallback.onSocketMessage(str);
            }
        }

        @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
        public void onSocketError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVWebSocketCallbackProxy onSocketError errCode ");
            sb.append(i);
            sb.append(" errMsg:");
            sb.append(str);
            RVLogger.d("AriverWebSocket:WebSocketSession", sb.toString());
            RVWebSocketCallback rVWebSocketCallback = this.mCallback;
            if (rVWebSocketCallback != null) {
                rVWebSocketCallback.onSocketError(i, str);
            }
        }
    }
}
