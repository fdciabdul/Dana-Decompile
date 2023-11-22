package com.alipay.mobile.rome.syncsdk.transport.connection.proxy;

import com.alipay.mobile.rome.syncsdk.util.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public class b extends SocketFactory {
    private static final String b = "b";

    /* renamed from: a  reason: collision with root package name */
    int f7261a = 15;
    private final ProxyInfo c;

    public b(ProxyInfo proxyInfo) {
        this.c = proxyInfo;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return a(str, i, this.f7261a);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(str, i, this.f7261a);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return a(inetAddress.getHostAddress(), i, this.f7261a);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(inetAddress.getHostAddress(), i, this.f7261a);
    }

    private Socket a(String str, int i, int i2) {
        Socket socket;
        String readLine;
        String str2 = this.c.f7259a;
        int i3 = this.c.b;
        String str3 = b;
        StringBuilder sb = new StringBuilder("socketOverHttpProxy: [ proxyHost=");
        sb.append(str2);
        sb.append(" ][ proxyPort=");
        sb.append(i3);
        sb.append(" ]");
        c.a(str3, sb.toString());
        Socket socket2 = null;
        try {
            socket = new Socket(Proxy.NO_PROXY);
        } catch (IOException e) {
            e = e;
        }
        try {
            socket.setTcpNoDelay(true);
            socket.setKeepAlive(true);
            int i4 = i2 * 1000;
            socket.connect(new InetSocketAddress(str2, i3), i4);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            StringBuilder sb2 = new StringBuilder("CONNECT ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i);
            sb2.append(" HTTP/1.1\r\nHost: ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i);
            sb2.append("\r\nProxy-Connection: Keep-Alive\r\n\r\n");
            bufferedWriter.write(sb2.toString());
            bufferedWriter.flush();
            socket.setSoTimeout(i4);
            String readLine2 = bufferedReader.readLine();
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.trim().equals(""));
            socket.setSoTimeout(0);
            if (readLine2 != null && readLine2.contains("200")) {
                String str4 = b;
                StringBuilder sb3 = new StringBuilder("socketOverHttpProxy: connect success [ result=");
                sb3.append(readLine2);
                sb3.append(" ]");
                c.a(str4, sb3.toString());
                return socket;
            }
            String str5 = b;
            StringBuilder sb4 = new StringBuilder("socketOverHttpProxy: connect failed [ result=");
            sb4.append(readLine2);
            sb4.append(" ]");
            c.c(str5, sb4.toString());
            socket.close();
            return null;
        } catch (IOException e2) {
            e = e2;
            socket2 = socket;
            if (socket2 != null) {
                socket2.close();
            }
            throw e;
        }
    }
}
