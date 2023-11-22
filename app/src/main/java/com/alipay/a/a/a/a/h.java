package com.alipay.a.a.a.a;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class h implements x {
    private static h g;
    private static final ThreadFactory i = new ThreadFactory() { // from class: com.alipay.a.a.a.a.h.2

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f6833a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #");
            sb.append(this.f6833a.getAndIncrement());
            Thread thread = new Thread(runnable, sb.toString());
            thread.setPriority(4);
            return thread;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Context f6831a;
    b b = b.a("android");
    long c;
    long d;
    long e;
    int f;
    private ThreadPoolExecutor h;

    private h(Context context) {
        this.f6831a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.h = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f6831a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final h a(Context context) {
        h hVar = g;
        return hVar != null ? hVar : b(context);
    }

    private static final h b(Context context) {
        synchronized (h.class) {
            h hVar = g;
            if (hVar != null) {
                return hVar;
            }
            h hVar2 = new h(context);
            g = hVar2;
            return hVar2;
        }
    }

    @Override // com.alipay.a.a.a.a.x
    public final Future<p> a(o oVar) {
        if (n.a(this.f6831a)) {
            StringBuilder sb = new StringBuilder("HttpManager");
            sb.append(hashCode());
            sb.append(": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times");
            String obj = sb.toString();
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.h.getActiveCount());
            objArr[1] = Long.valueOf(this.h.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.h.getTaskCount());
            long j = this.e;
            objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.c * 1000) / j) >> 10);
            int i2 = this.f;
            objArr[4] = Long.valueOf(i2 != 0 ? this.d / i2 : 0L);
            objArr[5] = Long.valueOf(this.c);
            objArr[6] = Long.valueOf(this.d);
            objArr[7] = Long.valueOf(this.e);
            objArr[8] = Integer.valueOf(this.f);
            InstrumentInjector.log_i("HttpManager", String.format(obj, objArr));
        }
        final l lVar = new l(this, (j) oVar);
        FutureTask<p> futureTask = new FutureTask<p>(lVar) { // from class: com.alipay.a.a.a.a.h.1
            @Override // java.util.concurrent.FutureTask
            protected final void done() {
                j a2 = lVar.a();
                if (a2.a() == null) {
                    super.done();
                    return;
                }
                try {
                    get();
                    if (isCancelled() || a2.f) {
                        a2.f = true;
                        if (isCancelled() && isDone()) {
                            return;
                        }
                        cancel(false);
                    }
                } catch (InterruptedException unused) {
                } catch (CancellationException unused2) {
                    a2.f = true;
                } catch (ExecutionException e) {
                    if (e.getCause() == null || !(e.getCause() instanceof g)) {
                        return;
                    }
                    e.getCause();
                } catch (Throwable th) {
                    throw new RuntimeException("An error occured while executing http request", th);
                }
            }
        };
        this.h.execute(futureTask);
        return futureTask;
    }
}
