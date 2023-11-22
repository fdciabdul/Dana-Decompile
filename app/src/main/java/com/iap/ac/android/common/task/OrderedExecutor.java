package com.iap.ac.android.common.task;

import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public class OrderedExecutor<K> {
    public final Executor executor;
    public final Map<K, OrderedExecutor<K>.Task> tasks = new HashMap();

    /* loaded from: classes8.dex */
    public class Task implements Runnable {
        public final Lock lock = new ReentrantLock();
        public final Queue<Runnable> queue = new LinkedList();

        public Task() {
        }

        public void add(Runnable runnable) {
            this.lock.lock();
            try {
                boolean isEmpty = this.queue.isEmpty();
                this.queue.offer(runnable);
                if (isEmpty) {
                    OrderedExecutor.this.executor.execute(this);
                }
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.lock.lock();
            try {
                Runnable peek = this.queue.peek();
                if (peek == null) {
                    return;
                }
                try {
                    peek.run();
                    this.lock.lock();
                    try {
                        this.queue.poll();
                        if (!this.queue.isEmpty()) {
                            OrderedExecutor.this.executor.execute(this);
                        }
                    } catch (Throwable th) {
                        try {
                            ACLog.e("OrderedExecutor", "task run finally", th);
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    this.lock.lock();
                    try {
                        this.queue.poll();
                        if (!this.queue.isEmpty()) {
                            OrderedExecutor.this.executor.execute(this);
                        }
                    } catch (Throwable th3) {
                        try {
                            ACLog.e("OrderedExecutor", "task run finally", th3);
                        } finally {
                        }
                    }
                    throw th2;
                }
            } finally {
            }
        }
    }

    public OrderedExecutor(Executor executor) {
        this.executor = executor;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void submit(K k, Runnable runnable) {
        synchronized (this) {
            OrderedExecutor<K>.Task task = this.tasks.get(k);
            if (task == null) {
                task = new Task();
                this.tasks.put(k, task);
            }
            task.add(runnable);
        }
    }
}
