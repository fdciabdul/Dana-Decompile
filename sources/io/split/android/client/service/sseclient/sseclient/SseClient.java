package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.sseclient.SseJwtToken;

/* loaded from: classes6.dex */
public interface SseClient {
    public static final int CONNECTED = 1;
    public static final int CONNECTING = 0;
    public static final int DISCONNECTED = 2;

    /* loaded from: classes6.dex */
    public interface ConnectionListener {
        void onConnectionSuccess();
    }

    void connect(SseJwtToken sseJwtToken, ConnectionListener connectionListener);

    void disconnect();

    int status();
}
