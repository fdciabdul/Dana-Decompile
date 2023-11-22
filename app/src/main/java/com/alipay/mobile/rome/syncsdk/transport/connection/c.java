package com.alipay.mobile.rome.syncsdk.transport.connection;

import com.alipay.mobile.rome.syncsdk.transport.connection.proxy.ProxyInfo;

/* loaded from: classes3.dex */
public final class c implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f7255a;
    public int b;
    public String d;
    public ProxyInfo e;
    public boolean c = true;
    private int f = 15;

    public c(String str, int i, ProxyInfo proxyInfo) {
        this.f7255a = str;
        this.b = i;
        this.e = proxyInfo;
        proxyInfo.c = 15;
    }
}
