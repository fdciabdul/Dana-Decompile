package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.transport.connection.proxy.ProxyInfo;
import org.apache.http.HttpHost;

/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a */
    private static final String f7226a = "c";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public c(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProxyInfo proxyInfo;
        String a2 = com.alipay.mobile.rome.syncsdk.transport.a.a();
        String str = f7226a;
        StringBuilder sb = new StringBuilder("ConnectTask: run [ transChannel=");
        sb.append(a2);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        this.b.d();
        if (this.b.p()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "run: ConnectTask: [ already connected ] [ isConnected=ture ]");
        } else if (TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().h()) || TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().i())) {
            com.alipay.mobile.rome.syncsdk.util.c.d(str, "run: ConnectTask: [ host or port is null ]");
        } else {
            this.b.a();
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "connectByHttps: ");
            HttpHost a3 = com.alipay.mobile.rome.syncsdk.util.e.a();
            if (a3 != null) {
                proxyInfo = new ProxyInfo(ProxyInfo.ProxyType.HTTP, a3.getHostName(), a3.getPort());
            } else {
                proxyInfo = new ProxyInfo(ProxyInfo.ProxyType.NONE, null, 0);
            }
            com.alipay.mobile.rome.syncsdk.transport.connection.c cVar = new com.alipay.mobile.rome.syncsdk.transport.connection.c(com.alipay.mobile.rome.syncsdk.a.a.a().h(), Integer.parseInt(com.alipay.mobile.rome.syncsdk.a.a.a().i()), proxyInfo);
            cVar.c = com.alipay.mobile.rome.syncsdk.a.a.a().j();
            cVar.d = com.alipay.mobile.rome.syncsdk.a.a.a().k();
            com.alipay.mobile.rome.syncsdk.transport.a.a aVar = new com.alipay.mobile.rome.syncsdk.transport.a.a(cVar);
            try {
                aVar.f = this.b.m();
                this.b.t();
                long currentTimeMillis = System.currentTimeMillis();
                aVar.a();
                aVar.b();
                aVar.c();
                aVar.f7253a = new com.alipay.mobile.rome.syncsdk.transport.c.b(this.b);
                this.b.a(aVar);
                this.b.c(System.currentTimeMillis() - currentTimeMillis);
                this.b.g();
            } catch (Exception e) {
                String str2 = f7226a;
                StringBuilder sb2 = new StringBuilder("connectByHttps: [ Exception=");
                sb2.append(e);
                sb2.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
                this.b.a();
                this.b.a((com.alipay.mobile.rome.syncsdk.transport.connection.a) null);
                this.b.a(e.toString());
                aVar.d();
                com.alipay.mobile.rome.syncsdk.a.c.c();
                if (com.alipay.mobile.rome.syncsdk.a.c.a() || !com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    return;
                }
                com.alipay.mobile.rome.syncsdk.service.f.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
            }
        }
    }
}
