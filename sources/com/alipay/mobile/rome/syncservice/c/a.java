package com.alipay.mobile.rome.syncservice.c;

import android.content.Context;
import com.alipay.mobile.rome.syncservice.model.DownstreamDataRequest;

/* loaded from: classes3.dex */
public abstract class a<T> {
    protected int b;
    protected Context c = com.alipay.mobile.rome.syncservice.d.a.f7279a;

    /* renamed from: a  reason: collision with root package name */
    protected String f7274a = getClass().getSimpleName();

    protected abstract T a(byte[] bArr);

    protected abstract void a(com.alipay.mobile.rome.syncservice.model.a aVar);

    protected abstract void a(com.alipay.mobile.rome.syncservice.model.a aVar, DownstreamDataRequest.DataSource dataSource);

    protected abstract void a(T t);

    protected abstract com.alipay.mobile.rome.syncservice.model.a b(T t);

    public void a(DownstreamDataRequest downstreamDataRequest) {
        if (downstreamDataRequest == null) {
            return;
        }
        T a2 = a(downstreamDataRequest.f7283a);
        a((a<T>) a2);
        com.alipay.mobile.rome.syncservice.model.a b = b(a2);
        a(b);
        a(b, downstreamDataRequest.b);
    }
}
