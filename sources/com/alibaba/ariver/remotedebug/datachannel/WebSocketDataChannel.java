package com.alibaba.ariver.remotedebug.datachannel;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.datachannel.DataChannel;
import com.alibaba.ariver.websocket.core.RVWebSocketCallback;
import com.alibaba.ariver.websocket.core.RVWebSocketManager;
import com.alibaba.ariver.websocket.core.WebSocketSession;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;

/* loaded from: classes6.dex */
public class WebSocketDataChannel extends AbsDataChannel implements RVWebSocketCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6190a;
    private String b;
    private WebSocketSession c;

    public WebSocketDataChannel(String str, DataChannel.DataStatusChangedListener dataStatusChangedListener) {
        super(str, dataStatusChangedListener);
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.REMOTE_DEBUG_ID);
        sb.append(str);
        this.b = sb.toString();
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel
    public void connect(String str, Map<String, String> map, JSONObject jSONObject) throws IOException, InvalidParameterException {
        StringBuilder sb = new StringBuilder();
        sb.append("connect...  url: ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:WebSocketDataChannel", sb.toString());
        if (this.f6190a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connect...  connecting! url: ");
            sb2.append(str);
            RVLogger.d("AriverRemoteDebug:WebSocketDataChannel", sb2.toString());
            return;
        }
        this.f6190a = true;
        WebSocketSession createSocketSession = RVWebSocketManager.getInstance().createSocketSession(this.b);
        this.c = createSocketSession;
        createSocketSession.startSocketConnect(str, map, this);
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel
    public boolean send(String str) {
        if (!this.f6190a) {
            RVLogger.d("AriverRemoteDebug:WebSocketDataChannel", "send... not connecting!");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("send...  msg: ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:WebSocketDataChannel", sb.toString());
        WebSocketSession webSocketSession = this.c;
        if (webSocketSession != null) {
            webSocketSession.sendMessage(str);
            return true;
        }
        return false;
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel
    public void close(int i, String str) {
        WebSocketSession webSocketSession = this.c;
        if (webSocketSession != null) {
            webSocketSession.closeSocketConnect(this.b);
        }
        this.f6190a = false;
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketOpen() {
        if (getDataStatusChangedListener() != null) {
            getDataStatusChangedListener().onConnectSuccess(getId());
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketClose() {
        if (getDataStatusChangedListener() != null) {
            getDataStatusChangedListener().onConnectClosed(getId());
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketMessage(byte[] bArr) {
        if (getDataStatusChangedListener() != null) {
            getDataStatusChangedListener().recv(bArr);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketMessage(String str) {
        if (getDataStatusChangedListener() != null) {
            getDataStatusChangedListener().recv(str);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketError(int i, String str) {
        if (getDataStatusChangedListener() != null) {
            getDataStatusChangedListener().onConnectError(getId(), i, str);
        }
    }
}
