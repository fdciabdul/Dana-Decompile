package com.iap.ac.android.common.task.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class LifoBlockingDeque<E> extends LinkedBlockingDeque<E> {
    public static final long serialVersionUID = 7262784894221011657L;

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean add(E e) {
        return super.offerFirst(e);
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E e) {
        return super.offerFirst(e);
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        super.putFirst(e);
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return super.offerFirst(e, j, timeUnit);
    }
}
