package com.alibaba.ariver.websocket.core;

import java.io.IOException;
import java.nio.channels.NotYetConnectedException;

/* loaded from: classes6.dex */
public interface RVWebSocketClient {
    void close();

    void connect();

    void connectWithSSL() throws IOException;

    boolean isOpen();

    void send(String str) throws NotYetConnectedException;

    void send(byte[] bArr) throws NotYetConnectedException;
}
