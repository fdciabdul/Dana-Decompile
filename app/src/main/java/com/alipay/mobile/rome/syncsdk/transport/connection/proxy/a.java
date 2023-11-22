package com.alipay.mobile.rome.syncsdk.transport.connection.proxy;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
final class a extends SocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private int f7260a = 15;

    public final void a(int i) {
        if (i > 0) {
            this.f7260a = i;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(str, i), this.f7260a * 1000);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return new Socket(str, i, inetAddress, i2);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(inetAddress, i), this.f7260a * 1000);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return new Socket(inetAddress, i, inetAddress2, i2);
    }
}
