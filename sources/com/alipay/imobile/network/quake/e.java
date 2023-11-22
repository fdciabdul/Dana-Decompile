package com.alipay.imobile.network.quake;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.transport.TransporterCallBack;
import com.alipay.mobile.common.rpc.RpcException;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes3.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request> f7044a;
    private final BlockingQueue<c> b;
    private final h c;
    private f e;
    private volatile boolean d = false;
    private TransporterCallBack f = new a();

    /* loaded from: classes3.dex */
    class a implements TransporterCallBack {
        a() {
        }

        @Override // com.alipay.imobile.network.quake.transport.TransporterCallBack
        public void onCompeleted(Request request, NetworkResponse networkResponse) {
            try {
                if (request.isCanceled()) {
                    request.finish("network-discard-cancelled");
                    return;
                }
                request.addMarker("network-http-complete");
                StringBuilder sb = new StringBuilder();
                sb.append("network-http-consume-time is:");
                sb.append(networkResponse.networkTimeMs);
                request.addMarker(sb.toString());
                c cVar = new c();
                cVar.f7037a = request;
                cVar.b = networkResponse;
                e.this.b.add(cVar);
            } catch (Exception e) {
                LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unhandled exception %s", e.toString()), e);
                e.this.c.a(request, new ClientException((Integer) 0, (Throwable) e));
            }
        }

        @Override // com.alipay.imobile.network.quake.transport.TransporterCallBack
        public void onException(Request request, RpcException rpcException) {
            e.this.a(request, rpcException);
        }
    }

    public e(BlockingQueue<Request> blockingQueue, BlockingQueue<c> blockingQueue2, h hVar, f fVar) {
        this.b = blockingQueue2;
        this.f7044a = blockingQueue;
        this.c = hVar;
        this.e = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request take = this.f7044a.take();
                try {
                    take.addMarker("network-queue-take");
                    if (take.isCanceled()) {
                        take.finish("network-discard-cancelled");
                    } else {
                        a(take);
                        this.e.c(take.getTransportName()).submitRequest(take, this.f);
                    }
                } catch (RpcException e) {
                    a(take, e);
                } catch (Throwable th) {
                    LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unhandled throwable %s", th.toString()), th);
                    this.c.a(take, new ClientException((Integer) 0, th));
                }
            } catch (InterruptedException unused) {
                if (this.d) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.d = true;
        interrupt();
    }

    private void a(Request request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(a(request.getOriginUrl()));
        }
    }

    private static int a(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Request request, RpcException rpcException) {
        this.c.a(request, request.parseNetworkError(rpcException));
    }
}
