package io.opentelemetry.internal.shaded.jctools.queues;

/* loaded from: classes6.dex */
public final class IndexedQueueSizeUtil {
    public static final int IGNORE_PARITY_DIVISOR = 2;
    public static final int PLAIN_DIVISOR = 1;

    /* loaded from: classes6.dex */
    public interface IndexedQueue {
        int capacity();

        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static int sanitizedSize(int i, long j) {
        if (j < 0) {
            return 0;
        }
        if (i == -1 || j <= i) {
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }
        return i;
    }

    public static int size(IndexedQueue indexedQueue, int i) {
        long lvConsumerIndex = indexedQueue.lvConsumerIndex();
        while (true) {
            long lvProducerIndex = indexedQueue.lvProducerIndex();
            long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return sanitizedSize(indexedQueue.capacity(), (lvProducerIndex - lvConsumerIndex2) / i);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        return indexedQueue.lvConsumerIndex() >= indexedQueue.lvProducerIndex();
    }
}
