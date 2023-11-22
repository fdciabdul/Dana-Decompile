package com.alipay.mobile.rome.longlinkservice;

/* loaded from: classes3.dex */
public abstract class ConnectionListenerAdapter extends ConnectionListener {
    protected void onConnectFailed(String str) {
    }

    protected void onConnected(long j) {
    }

    protected void onConnecting() {
    }

    protected void onDisconnected() {
    }

    @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListener
    public void onConnectionStateChanged(ConnectionEvent connectionEvent) {
        if (connectionEvent.isConnecting()) {
            onConnecting();
        } else if (connectionEvent.isConnected()) {
            onConnected(((Long) connectionEvent.getExtras()).longValue());
        } else if (connectionEvent.isConnectFailed()) {
            onConnectFailed((String) connectionEvent.getExtras());
        } else if (connectionEvent.isDisconnected()) {
            onDisconnected();
        }
    }
}
