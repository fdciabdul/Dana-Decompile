package io.opentelemetry.internal.shaded.jctools.queues;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import io.opentelemetry.internal.shaded.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class MpscArrayQueue<E> extends MpscArrayQueueL3Pad<E> {
    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue, io.opentelemetry.internal.shaded.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, io.opentelemetry.internal.shaded.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, io.opentelemetry.internal.shaded.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MpscArrayQueue(int i) {
        super(i);
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        long lvProducerIndex;
        long j = this.mask;
        long j2 = j + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j3 = i;
            if (j2 - (lvProducerLimit - lvProducerIndex) >= j3) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j3) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j2;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, lvProducerIndex + 1));
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e);
        return true;
    }

    @Override // java.util.Queue, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        long lvProducerIndex;
        long j = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + j + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e);
        return true;
    }

    public final int failFastOffer(E e) {
        long j = this.mask;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j + 1;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e);
            return 0;
        }
        return -1;
    }

    @Override // java.util.Queue, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E[] eArr = this.buffer;
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (e == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
            } while (e == null);
        }
        UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e;
    }

    @Override // java.util.Queue, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (e == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
            } while (e == null);
        }
        return e;
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (e == null) {
            return null;
        }
        UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e;
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer != 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("limit is negative: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            if (i == 0) {
                return 0;
            }
            E[] eArr = this.buffer;
            long j = this.mask;
            long lpConsumerIndex = lpConsumerIndex();
            for (int i2 = 0; i2 < i; i2++) {
                long j2 = i2 + lpConsumerIndex;
                long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j2, j);
                Object lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
                if (lvRefElement == null) {
                    return i2;
                }
                UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
                soConsumerIndex(j2 + 1);
                consumer.accept(lvRefElement);
            }
            return i;
        }
        throw new IllegalArgumentException("c is null");
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long lvProducerIndex;
        int min;
        if (supplier != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("limit is negative:");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            if (i == 0) {
                return 0;
            }
            long j = this.mask;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j2 = lvProducerLimit - lvProducerIndex;
                if (j2 <= 0) {
                    lvProducerLimit = lvConsumerIndex() + 1 + j;
                    j2 = lvProducerLimit - lvProducerIndex;
                    if (j2 <= 0) {
                        return 0;
                    }
                    soProducerLimit(lvProducerLimit);
                }
                min = Math.min((int) j2, i);
            } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
            E[] eArr = this.buffer;
            for (int i2 = 0; i2 < min; i2++) {
                UnsafeRefArrayAccess.soRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(i2 + lvProducerIndex, j), supplier.get());
            }
            return min;
        }
        throw new IllegalArgumentException("supplier is null");
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
