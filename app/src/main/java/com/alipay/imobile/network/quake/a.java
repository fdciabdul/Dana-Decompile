package com.alipay.imobile.network.quake;

import android.os.Process;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.cache.Cache;
import com.alipay.imobile.network.quake.protocol.Protocol;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes3.dex */
public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request> f7034a;
    private final BlockingQueue<Request> b;
    private final h c;
    private volatile boolean d = false;
    private f e;

    /* renamed from: com.alipay.imobile.network.quake.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class RunnableC0060a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Request f7035a;

        RunnableC0060a(Request request) {
            this.f7035a = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.b.put(this.f7035a);
            } catch (InterruptedException unused) {
            }
        }
    }

    public a(BlockingQueue<Request> blockingQueue, BlockingQueue<Request> blockingQueue2, h hVar, f fVar) {
        this.f7034a = blockingQueue;
        this.b = blockingQueue2;
        this.c = hVar;
        this.e = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        LoggerWrapper.v(Quake.TAG, "start new dispatcher");
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request take = this.f7034a.take();
                take.addMarker("cache-queue-take");
                if (take.isCanceled()) {
                    take.finish("cache-discard-canceled");
                } else {
                    Protocol protocol = take.getProtocol();
                    String generateCacheKey = protocol.generateCacheKey(take);
                    Cache a2 = this.e.a(take.getCacheName());
                    if (!a2.isInitialized()) {
                        a2.initialize();
                    }
                    Cache.Entry entry = null;
                    try {
                        entry = a2.get(generateCacheKey);
                    } catch (IOException e) {
                        LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unhandled exception %s", e.toString()), e);
                        a2.remove(generateCacheKey);
                    }
                    if (entry == null) {
                        take.addMarker("cache-miss");
                        this.b.put(take);
                    } else if (entry.isExpired()) {
                        take.addMarker("cache-hit-expired");
                        take.setCacheEntry(entry);
                        this.b.put(take);
                    } else {
                        take.addMarker("cache-hit");
                        Response<?> deserialize = protocol.deserialize(take, new NetworkResponse(0, entry.data));
                        take.addMarker("cache-hit-parsed");
                        if (!entry.refreshNeeded()) {
                            this.c.a(take, deserialize);
                        } else {
                            take.addMarker("cache-hit-refresh-needed");
                            StringBuilder sb = new StringBuilder();
                            sb.append("softExpireTime=");
                            sb.append(entry.softExpireTime);
                            sb.append(", finalExpireTime=");
                            sb.append(entry.finalExpireTime);
                            sb.append("currentTime=");
                            sb.append(System.currentTimeMillis());
                            take.addMarker(sb.toString());
                            take.setCacheEntry(entry);
                            deserialize.intermediate = true;
                            this.c.a(take, deserialize, new RunnableC0060a(take));
                        }
                    }
                }
            } catch (InterruptedException e2) {
                LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unhandled InterruptedException %s", e2.toString()), e2);
                if (this.d) {
                    return;
                }
            } catch (Throwable th) {
                LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unhandled throwable %s", th.toString()), th);
            }
        }
    }

    public void a() {
        this.d = true;
        interrupt();
    }
}
