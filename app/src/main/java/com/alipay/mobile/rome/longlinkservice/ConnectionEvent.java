package com.alipay.mobile.rome.longlinkservice;

/* loaded from: classes3.dex */
public class ConnectionEvent {

    /* renamed from: a  reason: collision with root package name */
    private Type f7208a;
    private Object b;

    /* loaded from: classes3.dex */
    public enum Type {
        Unknown,
        Connecting,
        Connected,
        ConnectFailed,
        Disconnected
    }

    public ConnectionEvent(Type type) {
        this.f7208a = type;
        if (type == null) {
            this.f7208a = Type.ConnectFailed;
        }
    }

    public ConnectionEvent(Type type, Object obj) {
        this.f7208a = type;
        this.b = obj;
        if (type == null) {
            this.f7208a = Type.ConnectFailed;
        }
    }

    public Type getEventType() {
        return this.f7208a;
    }

    public Object getExtras() {
        return this.b;
    }

    public boolean isConnecting() {
        return this.f7208a == Type.Connecting;
    }

    public boolean isConnected() {
        return this.f7208a == Type.Connected;
    }

    public boolean isConnectFailed() {
        return this.f7208a == Type.ConnectFailed;
    }

    public boolean isDisconnected() {
        return this.f7208a == Type.Disconnected;
    }

    public String getConnectionStateName() {
        return this.f7208a.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionEvent{mEventType=");
        sb.append(this.f7208a);
        sb.append(", connectionStateName='");
        sb.append(getConnectionStateName());
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
