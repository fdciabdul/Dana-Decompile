package com.alipay.imobile.network.quake;

import android.os.Handler;
import android.os.Looper;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class g implements Request.b {

    /* renamed from: a */
    private AtomicInteger f7050a;
    private final Map<String, Queue<Request>> b;
    private final Set<Request> c;
    private final PriorityBlockingQueue<Request> d;
    private final PriorityBlockingQueue<Request> e;
    private final BlockingQueue<com.alipay.imobile.network.quake.c> f;
    private final h g;
    private e h;
    private com.alipay.imobile.network.quake.a i;
    private com.alipay.imobile.network.quake.b j;
    private f k;
    private final List<c> l;

    /* loaded from: classes3.dex */
    public class a implements b {

        /* renamed from: a */
        final /* synthetic */ Object f7051a;

        a(g gVar, Object obj) {
            this.f7051a = obj;
        }

        @Override // com.alipay.imobile.network.quake.g.b
        public boolean a(Request request) {
            return request.getTag() == this.f7051a;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(Request request);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Request request);
    }

    public g(f fVar, int i, h hVar) {
        this.f7050a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue<>();
        this.e = new PriorityBlockingQueue<>();
        this.f = new PriorityBlockingQueue();
        this.l = new ArrayList();
        this.g = hVar;
        this.k = fVar;
    }

    public int a() {
        return this.f7050a.incrementAndGet();
    }

    public void b() {
        c();
        com.alipay.imobile.network.quake.a aVar = new com.alipay.imobile.network.quake.a(this.d, this.e, this.g, this.k);
        this.i = aVar;
        aVar.start();
        e eVar = new e(this.e, this.f, this.g, this.k);
        this.h = eVar;
        eVar.start();
        com.alipay.imobile.network.quake.b bVar = new com.alipay.imobile.network.quake.b(this.f, this.g, this.k);
        this.j = bVar;
        bVar.start();
    }

    public void c() {
        com.alipay.imobile.network.quake.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.a();
        }
        com.alipay.imobile.network.quake.b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(b bVar) {
        synchronized (this.c) {
            for (Request request : this.c) {
                if (bVar.a(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            a((b) new a(this, obj));
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    @Override // com.alipay.imobile.network.quake.Request.b
    public void a(Request request) {
        synchronized (this.c) {
            this.c.remove(request);
        }
        synchronized (this.l) {
            Iterator<c> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
        if (request.shouldCache()) {
            synchronized (this.b) {
                String generateCacheKey = this.k.b(request.getProtocolName()).generateCacheKey(request);
                Queue<Request> remove = this.b.remove(generateCacheKey);
                if (remove != null) {
                    LoggerWrapper.v(Quake.TAG, LoggerWrapper.buildMessage("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), generateCacheKey));
                    this.d.addAll(remove);
                }
            }
        }
    }

    public Request b(Request request) {
        request.setFinishListener(this);
        synchronized (this.c) {
            this.c.add(request);
        }
        request.setSequence(a());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.e.add(request);
            return request;
        }
        synchronized (this.b) {
            String generateCacheKey = request.getProtocol().generateCacheKey(request);
            if (this.b.containsKey(generateCacheKey)) {
                Queue<Request> queue = this.b.get(generateCacheKey);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(request);
                this.b.put(generateCacheKey, queue);
                LoggerWrapper.v(Quake.TAG, LoggerWrapper.buildMessage("Request for cacheKey=%s is in flight, putting on hold.", generateCacheKey));
            } else {
                this.b.put(generateCacheKey, null);
                this.d.add(request);
            }
        }
        return request;
    }

    public g(f fVar, int i) {
        this(fVar, i, new d(new Handler(Looper.getMainLooper())));
    }
}
