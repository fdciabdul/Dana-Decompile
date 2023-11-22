package com.alipay.mobile.rome.syncsdk.transport.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.a.b;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import com.alipay.mobile.rome.syncsdk.transport.connection.c;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.rome.syncsdk.transport.connection.proxy.ProxyInfo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class a extends com.alipay.mobile.rome.syncsdk.transport.connection.a {
    private static final String g = "a";
    private volatile Socket h;
    private volatile boolean i;
    private volatile f j;
    private volatile d k;

    public a(c cVar) {
        super(cVar);
        this.i = false;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void b() {
        com.alipay.mobile.rome.syncsdk.util.c.b(g, "setConnected [ true ]");
        this.i = true;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void c() {
        com.alipay.mobile.rome.syncsdk.util.c.b(g, "initReaderWriter: ");
        try {
            this.c = new DataInputStream(this.h.getInputStream());
            this.d = new DataOutputStream(this.h.getOutputStream());
            this.j = new f(this);
            this.k = new d(this);
            this.k.b.start();
        } catch (Exception e) {
            String str = g;
            StringBuilder sb = new StringBuilder("initReaderWriter: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            throw e;
        }
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void a() {
        String str = this.e.f7255a;
        int i = this.e.b;
        boolean z = this.e.c;
        ProxyInfo proxyInfo = this.e.e;
        String str2 = g;
        StringBuilder sb = new StringBuilder("connect: [ host=");
        sb.append(str);
        sb.append(" ][ port=");
        sb.append(i);
        sb.append(" ][ sslUsed=");
        sb.append(z);
        sb.append(" ][ verifyInfo=");
        sb.append(this.e.d);
        sb.append(" ][ proxyInfo=");
        sb.append(proxyInfo);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
        try {
            if (!z) {
                this.h = this.e.e.a().createSocket(str, i);
            } else {
                String str3 = this.e.d;
                if (ProxyInfo.ProxyType.HTTP == proxyInfo.d) {
                    this.h = this.e.e.a().createSocket(str, i);
                    this.h.setTcpNoDelay(true);
                    SSLSocket sSLSocket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(this.h, str, i, true);
                    sSLSocket.setUseClientMode(true);
                    sSLSocket.setSoTimeout(proxyInfo.c * 1000);
                    sSLSocket.startHandshake();
                    sSLSocket.setSoTimeout(0);
                    if (!TextUtils.isEmpty(str3)) {
                        SSLSession session = sSLSocket.getSession();
                        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str3, session)) {
                            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "ssl hostname verify failed!");
                            StringBuilder sb2 = new StringBuilder();
                            StringBuilder sb3 = new StringBuilder("proxyHost:");
                            sb3.append(this.e.e.f7259a);
                            sb2.append(sb3.toString());
                            StringBuilder sb4 = new StringBuilder(" proxyPort:");
                            sb4.append(this.e.e.b);
                            sb2.append(sb4.toString());
                            StringBuilder sb5 = new StringBuilder(" hostname:");
                            sb5.append(str);
                            sb2.append(sb5.toString());
                            sb2.append(" err:hostname verify failed");
                            StringBuilder sb6 = new StringBuilder(" PeerPrincipal:");
                            sb6.append(session.getPeerPrincipal());
                            sb2.append(sb6.toString());
                            throw new Exception(sb2.toString());
                        }
                    }
                    this.h = sSLSocket;
                } else {
                    this.h = this.e.e.a().createSocket(str, i);
                    this.h.setTcpNoDelay(true);
                    SSLSocket sSLSocket2 = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(this.h, str, i, true);
                    sSLSocket2.setUseClientMode(true);
                    sSLSocket2.setSoTimeout(proxyInfo.c * 1000);
                    sSLSocket2.startHandshake();
                    sSLSocket2.setSoTimeout(0);
                    if (!TextUtils.isEmpty(str3)) {
                        SSLSession session2 = sSLSocket2.getSession();
                        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str3, session2)) {
                            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "ssl hostname verify failed!");
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("proxy:null ");
                            StringBuilder sb8 = new StringBuilder("hostname:");
                            sb8.append(str);
                            sb8.append(" ");
                            sb7.append(sb8.toString());
                            sb7.append("err:hostname verify failed ");
                            StringBuilder sb9 = new StringBuilder("PeerPrincipal:");
                            sb9.append(session2.getPeerPrincipal());
                            sb7.append(sb9.toString());
                            throw new Exception(sb7.toString());
                        }
                    }
                    this.h = sSLSocket2;
                }
            }
            if (this.h == null) {
                throw new Exception("create socket failed");
            }
            com.alipay.mobile.rome.syncsdk.util.c.b(str2, "connect: [ connectUsingConfiguration success ]");
        } catch (Exception e) {
            String str4 = g;
            StringBuilder sb10 = new StringBuilder("connect: [ connectUsingConfiguration failed ][ Exception=");
            sb10.append(e);
            sb10.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb10.toString());
            if (this.h != null) {
                this.h.close();
            }
            throw e;
        }
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void d() {
        com.alipay.mobile.rome.syncsdk.util.c.b(g, "disconnect: ");
        if (this.i && LongLinkService.b() != null) {
            LongLinkService.b().u();
        }
        this.i = false;
        this.f7253a = null;
        this.b = null;
        try {
            if (this.k != null) {
                d dVar = this.k;
                com.alipay.mobile.rome.syncsdk.util.c.b(d.f7256a, "shutdown: ");
                dVar.c = true;
                if (dVar.b != null && dVar.b.isAlive()) {
                    dVar.b.interrupt();
                }
                this.k = null;
            }
            if (this.j != null) {
                f fVar = this.j;
                com.alipay.mobile.rome.syncsdk.util.c.b(f.f7258a, "shutdown: ");
                fVar.d = true;
                this.j = null;
            }
        } catch (Exception e) {
            String str = g;
            StringBuilder sb = new StringBuilder("disconnect: shutdown[ Exception ");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
        }
        if (this.c != null) {
            try {
                this.c.close();
            } catch (Exception e2) {
                String str2 = g;
                StringBuilder sb2 = new StringBuilder("disconnect: reader close[ Exception ");
                sb2.append(e2);
                sb2.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
            }
            this.c = null;
        }
        if (this.d != null) {
            try {
                this.d.close();
            } catch (Exception e3) {
                String str3 = g;
                StringBuilder sb3 = new StringBuilder("disconnect: writer close[ Exception ");
                sb3.append(e3);
                sb3.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
            }
            this.d = null;
        }
        try {
            if (this.h != null) {
                this.h.close();
            }
        } catch (Exception e4) {
            String str4 = g;
            StringBuilder sb4 = new StringBuilder("disconnect: socket close[ Exception ");
            sb4.append(e4);
            sb4.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb4.toString());
        }
        this.h = null;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void a(Throwable th) {
        String str = g;
        StringBuilder sb = new StringBuilder("notifyError: [ Exception");
        sb.append(th);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "onConnectionError: [ LongLinkConnection ] ");
        LongLinkService.b().a();
        LongLinkService.b().a((com.alipay.mobile.rome.syncsdk.transport.connection.a) null);
        d();
        com.alipay.mobile.rome.syncsdk.a.c.c();
        if (com.alipay.mobile.rome.syncsdk.a.c.a() || !com.alipay.mobile.rome.syncsdk.a.c.f()) {
            return;
        }
        com.alipay.mobile.rome.syncsdk.service.f.a().a(b.b());
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.connection.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        String str = g;
        StringBuilder sb = new StringBuilder("isConnected [");
        sb.append(this.i);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        if (!this.i) {
            throw new IllegalStateException("not connected to server");
        }
        if (aVar == null) {
            throw new Exception("Packet is null");
        }
        try {
            f fVar = this.j;
            com.alipay.mobile.rome.syncsdk.util.c.b(f.f7258a, "sendPacket ");
            if (fVar.d) {
                throw new Exception("already done");
            }
            try {
                if (aVar == null) {
                    String str2 = f.f7258a;
                    StringBuilder sb2 = new StringBuilder("sendPacket: [ packet=");
                    sb2.append(aVar);
                    sb2.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
                    return;
                }
                fVar.b.write(aVar.g());
                fVar.b.flush();
            } catch (Throwable th) {
                String str3 = f.f7258a;
                StringBuilder sb3 = new StringBuilder("sendPacket: [ link is disconnected ][ Exception");
                sb3.append(th);
                sb3.append(" ][ isDone ");
                sb3.append(fVar.d);
                sb3.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
                if (fVar.d) {
                    return;
                }
                fVar.d = true;
                fVar.c.a(th);
            }
        } catch (Exception e) {
            String str4 = g;
            StringBuilder sb4 = new StringBuilder("sendPacket: [ Exception=");
            sb4.append(e);
            sb4.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb4.toString());
            throw e;
        }
    }
}
