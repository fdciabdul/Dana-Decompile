package com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class DefaultSCNetworkAsyncTaskExecutor implements SCNetworkAsyncTaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f6914a;
    private final ScheduledThreadPoolExecutor b;

    public DefaultSCNetworkAsyncTaskExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7, Integer.MAX_VALUE, 2L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.f6914a = threadPoolExecutor;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.b = scheduledThreadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        scheduledThreadPoolExecutor.setKeepAliveTime(6L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeIO(Runnable runnable) {
        this.f6914a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeLowPri(Runnable runnable) {
        this.f6914a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeLazy(Runnable runnable) {
        this.f6914a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void execute(Runnable runnable) {
        this.f6914a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submit(Runnable runnable) {
        return this.f6914a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submitLazy(Runnable runnable) {
        return this.f6914a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeSerial(Runnable runnable) {
        this.f6914a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submitSerial(Runnable runnable) {
        return this.f6914a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f6914a.submit(callable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b.schedule(runnable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.b.schedule(callable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }
}
