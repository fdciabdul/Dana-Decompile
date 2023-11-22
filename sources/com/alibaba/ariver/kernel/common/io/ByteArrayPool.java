package com.alibaba.ariver.kernel.common.io;

import androidx.collection.LruCache;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ByteArrayPool {
    private final int b;

    /* renamed from: a  reason: collision with root package name */
    private final BytePool f6124a = new BytePool(12);
    private final Object c = new Object();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int e = 0;

    public ByteArrayPool(int i) {
        this.b = i;
    }

    public byte[] getBuf(int i) {
        byte[] poll;
        LinkedList<byte[]> linkedList = this.f6124a.get(Integer.valueOf(i));
        if (linkedList != null && (poll = linkedList.poll()) != null) {
            synchronized (this.c) {
                this.e -= poll.length;
            }
            return poll;
        }
        return new byte[i];
    }

    public void returnBuf(byte[] bArr) {
        if (bArr == null || bArr.length > this.b) {
            return;
        }
        synchronized (this.c) {
            this.e += bArr.length;
        }
        LinkedList<byte[]> linkedList = this.f6124a.get(Integer.valueOf(bArr.length));
        if (linkedList == null) {
            ConcurrentLinkedList concurrentLinkedList = new ConcurrentLinkedList();
            concurrentLinkedList.offer(bArr);
            this.f6124a.put(Integer.valueOf(bArr.length), concurrentLinkedList);
        } else {
            linkedList.offer(bArr);
        }
        a();
    }

    private void a() {
        if (!this.d.get() && this.e > this.b) {
            this.d.set(true);
            BytePool bytePool = this.f6124a;
            bytePool.trimToSize(bytePool.size() / 2);
            this.d.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class BytePool extends LruCache<Integer, LinkedList<byte[]>> {
        private BytePool(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        public void entryRemoved(boolean z, Integer num, LinkedList<byte[]> linkedList, LinkedList<byte[]> linkedList2) {
            synchronized (ByteArrayPool.this.c) {
                if (z || linkedList2 != null) {
                    ByteArrayPool.this.e -= num.intValue() * linkedList.size();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class ConcurrentLinkedList<T> extends LinkedList<T> {
        private ConcurrentLinkedList() {
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public T poll() {
            T t;
            synchronized (this) {
                t = (T) super.poll();
            }
            return t;
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public boolean offer(T t) {
            boolean offer;
            synchronized (this) {
                offer = super.offer(t);
            }
            return offer;
        }
    }
}
