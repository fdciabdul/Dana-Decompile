package com.alipay.mobile.rome.syncsdk.transport.connection.proxy;

import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public final class ProxyInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f7259a;
    public int b;
    public int c = 15;
    public ProxyType d;

    /* loaded from: classes3.dex */
    public enum ProxyType {
        NONE,
        HTTP,
        SOCKS
    }

    public ProxyInfo(ProxyType proxyType, String str, int i) {
        this.d = proxyType;
        this.f7259a = str;
        this.b = i;
    }

    public final SocketFactory a() {
        if (this.d == ProxyType.NONE) {
            new a().a(this.c);
            return new a();
        } else if (this.d == ProxyType.HTTP) {
            b bVar = new b(this);
            int i = this.c;
            if (i > 0) {
                bVar.f7261a = i;
            }
            return bVar;
        } else if (this.d == ProxyType.SOCKS) {
            new a().a(this.c);
            return new a();
        } else {
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProxyInfo [proxyAddress=");
        sb.append(this.f7259a);
        sb.append(", proxyPort=");
        sb.append(this.b);
        sb.append(", proxyType=");
        sb.append(this.d);
        sb.append(", connTimeout=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
