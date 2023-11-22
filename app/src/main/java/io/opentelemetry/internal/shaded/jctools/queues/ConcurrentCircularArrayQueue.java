package io.opentelemetry.internal.shaded.jctools.queues;

import io.opentelemetry.internal.shaded.jctools.queues.IndexedQueueSizeUtil;
import io.opentelemetry.internal.shaded.jctools.util.Pow2;
import io.opentelemetry.internal.shaded.jctools.util.UnsafeRefArrayAccess;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> implements MessagePassingQueue<E>, IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, SupportsIterator {
    protected final E[] buffer;
    protected final long mask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcurrentCircularArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = (long) (roundToPowerOfTwo - 1);
        this.buffer = (E[]) UnsafeRefArrayAccess.allocateRefArray(roundToPowerOfTwo);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public int size() {
        return IndexedQueueSizeUtil.size(this, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue
    public void clear() {
        do {
        } while (poll() != null);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue, io.opentelemetry.internal.shaded.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public int capacity() {
        return (int) (this.mask + 1);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new WeakIterator(lvConsumerIndex(), lvProducerIndex(), this.mask, this.buffer);
    }

    /* loaded from: classes6.dex */
    static class WeakIterator<E> implements Iterator<E>, j$.util.Iterator {
        private final E[] buffer;
        private final long mask;
        private E nextElement = getNext();
        private long nextIndex;
        private final long pIndex;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        WeakIterator(long j, long j2, long j3, E[] eArr) {
            this.nextIndex = j;
            this.pIndex = j2;
            this.mask = j3;
            this.buffer = eArr;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextElement != null;
        }

        @Override // java.util.Iterator
        public E next() {
            E e = this.nextElement;
            if (e == null) {
                throw new NoSuchElementException();
            }
            this.nextElement = getNext();
            return e;
        }

        private E getNext() {
            E e;
            do {
                long j = this.nextIndex;
                if (j >= this.pIndex) {
                    return null;
                }
                this.nextIndex = 1 + j;
                e = (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j, this.mask));
            } while (e == null);
            return e;
        }
    }
}
