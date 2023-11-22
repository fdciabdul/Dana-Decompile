package com.alipay.imobile.network.quake;

import android.os.Handler;
import com.alipay.mobile.common.rpc.RpcException;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7041a;

    /* loaded from: classes3.dex */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f7042a;

        a(d dVar, Handler handler) {
            this.f7042a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f7042a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Request f7043a;
        private final Response b;
        private final Runnable c;

        public b(d dVar, Request request, Response response, Runnable runnable) {
            this.f7043a = request;
            this.b = response;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7043a.isCanceled()) {
                this.f7043a.finish("canceled-at-delivery");
                return;
            }
            if (this.b.isSuccess()) {
                this.f7043a.deliverResponse(this.b.result);
            } else {
                this.f7043a.deliverError(this.b.error);
            }
            if (this.b.intermediate) {
                this.f7043a.addMarker("intermediate-response");
            } else {
                this.f7043a.finish("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(Handler handler) {
        this.f7041a = new a(this, handler);
    }

    @Override // com.alipay.imobile.network.quake.h
    public void a(Request request, Response<?> response) {
        a(request, response, null);
    }

    @Override // com.alipay.imobile.network.quake.h
    public void a(Request request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f7041a.execute(new b(this, request, response, runnable));
    }

    @Override // com.alipay.imobile.network.quake.h
    public void a(Request request, RpcException rpcException) {
        request.addMarker("post-error");
        this.f7041a.execute(new b(this, request, Response.error(rpcException), null));
    }
}
