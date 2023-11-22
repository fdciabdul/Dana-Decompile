package io.opentelemetry.context;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ContextScheduledExecutorService extends ContextExecutorService implements ScheduledExecutorService {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextScheduledExecutorService(Context context, ScheduledExecutorService scheduledExecutorService) {
        super(context, scheduledExecutorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.opentelemetry.context.ForwardingExecutorService
    public ScheduledExecutorService delegate() {
        return (ScheduledExecutorService) super.delegate();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return delegate().schedule(context().wrap(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return delegate().schedule(context().wrap(callable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return delegate().scheduleAtFixedRate(context().wrap(runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return delegate().scheduleWithFixedDelay(context().wrap(runnable), j, j2, timeUnit);
    }
}
