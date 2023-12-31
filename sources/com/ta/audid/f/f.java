package com.ta.audid.f;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.ta.audid.g.m;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class f extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private Method f7680a = null;
    private String j;

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public f(String str) {
        this.j = str;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.j == null) {
            this.j = str;
        }
        m.m249a("", "host", this.j, "port", Integer.valueOf(i), "autoClose", Boolean.valueOf(z));
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.j);
        } else {
            try {
                if (this.f7680a == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f7680a = method;
                    method.setAccessible(true);
                }
                this.f7680a.invoke(sSLSocket, this.j);
            } catch (Exception e) {
                m.d("", "SNI not useable", null, e);
            }
        }
        m.m249a("", "SSLSession PeerHost", sSLSocket.getSession().getPeerHost());
        return sSLSocket;
    }
}
