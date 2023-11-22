package com.alipay.iap.android.common.task;

import com.alipay.iap.android.common.log.LoggerWrapper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class OrderedExecutor<K> {
    private final Executor executor;
    private final Map<K, OrderedExecutor<K>.Task> tasks = new HashMap();

    public OrderedExecutor(Executor executor) {
        this.executor = executor;
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

    /* loaded from: classes6.dex */
    class Task implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Queue<Runnable> queue = new LinkedList();

        Task() {
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
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    this.lock.lock();
                    try {
                        this.queue.poll();
                        if (!this.queue.isEmpty()) {
                            OrderedExecutor.this.executor.execute(this);
                        }
                    } finally {
                        try {
                            LoggerWrapper.e("OrderedExecutor", "task run finally", th);
                            throw th;
                        } finally {
                        }
                    }
                    throw th;
                }
            } finally {
            }
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }
}
