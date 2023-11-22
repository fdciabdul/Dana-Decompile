package fsimpl;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
abstract class dE extends PriorityBlockingQueue {

    /* renamed from: a  reason: collision with root package name */
    private AtomicLong f7913a;
    private AtomicInteger b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dE(int i, Comparator comparator) {
        super(i, comparator);
        this.f7913a = new AtomicLong();
        this.b = new AtomicInteger();
    }

    private void b(Object obj) {
        if (obj != null) {
            this.f7913a.addAndGet(-a(obj));
            this.b.decrementAndGet();
        }
    }

    public int a() {
        return this.b.get();
    }

    abstract long a(Object obj);

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj) {
        this.f7913a.addAndGet(a(obj));
        this.b.incrementAndGet();
        return super.offer(obj);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public Object poll() {
        Object poll = super.poll();
        b(poll);
        return poll;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public Object poll(long j, TimeUnit timeUnit) {
        Object poll = super.poll(j, timeUnit);
        b(poll);
        return poll;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public Object take() {
        Object take = super.take();
        b(take);
        return take;
    }
}
