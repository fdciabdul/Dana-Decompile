package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class Queues {
    public static final byte[] getAuthRequestContext = {114, -79, -70, 22, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 108;

    private static void a(byte b, short s, int i, Object[] objArr) {
        byte[] bArr = getAuthRequestContext;
        int i2 = 16 - (s * 3);
        int i3 = (b * 7) + 99;
        int i4 = (i * 12) + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4++;
            int i7 = i4 + i6 + 2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i6 = i6;
            i3 = i7;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i4];
            Object[] objArr2 = objArr;
            int i9 = i3;
            int i10 = i6;
            i4++;
            int i11 = i9 + b2 + 2;
            objArr = objArr2;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i6 = i10;
            i3 = i11;
        }
    }

    private Queues() {
    }

    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int i) {
        return new ArrayBlockingQueue<>(i);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<>((Collection) iterable);
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<>((Collection) iterable);
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque<>();
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int i) {
        return new LinkedBlockingDeque<>(i);
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<>((Collection) iterable);
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int i) {
        return new LinkedBlockingQueue<>(i);
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<>((Collection) iterable);
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue<>();
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<>((Collection) iterable);
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<>((Collection) iterable);
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }

    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue<>();
    }

    public static <E> int drain(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i, long j, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.checkNotNull(collection);
        long nanoTime = System.nanoTime();
        long nanos = timeUnit.toNanos(j);
        int i2 = 0;
        while (i2 < i) {
            i2 += blockingQueue.drainTo(collection, i - i2);
            if (i2 < i) {
                E poll = blockingQueue.poll((nanoTime + nanos) - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
                i2++;
            }
        }
        return i2;
    }

    public static <E> int drainUninterruptibly(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i, long j, TimeUnit timeUnit) {
        E poll;
        Preconditions.checkNotNull(collection);
        long nanoTime = System.nanoTime();
        long nanos = timeUnit.toNanos(j);
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            try {
                i2 += blockingQueue.drainTo(collection, i - i2);
                if (i2 < i) {
                    while (true) {
                        try {
                            poll = blockingQueue.poll((nanoTime + nanos) - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    }
                    if (poll == null) {
                        break;
                    }
                    collection.add(poll);
                    i2++;
                }
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = getAuthRequestContext[15];
                        Object[] objArr = new Object[1];
                        a(b, (byte) (b - 1), getAuthRequestContext[15], objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b2 = (byte) (getAuthRequestContext[15] - 1);
                        byte b3 = getAuthRequestContext[15];
                        Object[] objArr2 = new Object[1];
                        a(b2, b3, (byte) (b3 - 1), objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th2;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b4 = getAuthRequestContext[15];
                Object[] objArr3 = new Object[1];
                a(b4, (byte) (b4 - 1), getAuthRequestContext[15], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (getAuthRequestContext[15] - 1);
                byte b6 = getAuthRequestContext[15];
                Object[] objArr4 = new Object[1];
                a(b5, b6, (byte) (b6 - 1), objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th3;
            }
        }
        return i2;
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> queue) {
        return Synchronized.queue(queue, null);
    }

    public static <E> Deque<E> synchronizedDeque(Deque<E> deque) {
        return Synchronized.deque(deque, null);
    }
}
