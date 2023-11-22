package com.alipay.mobile.rome.syncservice.a;

import android.content.Context;

/* loaded from: classes3.dex */
public final class a {
    private static volatile a c;
    private volatile Context b = com.alipay.mobile.rome.syncservice.d.a.f7279a;

    /* renamed from: a  reason: collision with root package name */
    public volatile com.alipay.mobile.rome.syncsdk.b f7271a = com.alipay.mobile.rome.syncsdk.b.a(this.b);

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void a(com.alipay.mobile.rome.syncsdk.a aVar) {
        synchronized (this) {
            this.f7271a.a(aVar);
        }
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            this.f7271a.a(str, str2);
        }
    }

    public final void b() {
        synchronized (this) {
            this.f7271a.a();
        }
    }

    public final boolean c() {
        boolean b;
        synchronized (this) {
            b = this.f7271a.b();
        }
        return b;
    }

    public final void d() {
        synchronized (this) {
            this.f7271a.c();
        }
    }

    public final void e() {
        synchronized (this) {
            this.f7271a.d();
        }
    }

    public final void a(byte[] bArr) {
        synchronized (this) {
            this.f7271a.a(bArr);
        }
    }
}
