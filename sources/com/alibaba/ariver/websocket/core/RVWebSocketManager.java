package com.alibaba.ariver.websocket.core;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RVWebSocketManager {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WebSocketSession> f6251a;

    /* loaded from: classes6.dex */
    static class Holder {
        static RVWebSocketManager INSTANCE = new RVWebSocketManager();

        private Holder() {
        }
    }

    private RVWebSocketManager() {
        this.f6251a = new HashMap();
    }

    public static RVWebSocketManager getInstance() {
        return Holder.INSTANCE;
    }

    public WebSocketSession createSocketSession(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                RVLogger.d("AriverWebSocket:RVWebSocketManager", "createSocketSession: socketId is empty.");
                return null;
            }
            WebSocketSession webSocketSession = this.f6251a.get(str);
            if (webSocketSession == null) {
                RVLogger.d("AriverWebSocket:RVWebSocketManager", String.format("getSocketSession: new WebSocketSession id:[%s]", str));
            } else {
                webSocketSession.closeAllSocket();
                this.f6251a.remove(str);
            }
            WebSocketSession webSocketSession2 = new WebSocketSession(str);
            this.f6251a.put(str, webSocketSession2);
            return webSocketSession2;
        }
    }

    public WebSocketSession getSocketSession(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                RVLogger.d("AriverWebSocket:RVWebSocketManager", "getSocketSession: socketId is empty.");
                return null;
            }
            return this.f6251a.get(str);
        }
    }
}
