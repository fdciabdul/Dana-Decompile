package io.opentelemetry.internal.shaded.jctools.queues;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import io.opentelemetry.internal.shaded.jctools.util.PortableJvmInfo;

/* loaded from: classes9.dex */
public final class MessagePassingQueueUtil {
    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("limit is negative: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            int i2 = 0;
            if (i == 0) {
                return 0;
            }
            while (i2 < i) {
                E relaxedPoll = messagePassingQueue.relaxedPoll();
                if (relaxedPoll == null) {
                    break;
                }
                consumer.accept(relaxedPoll);
                i2++;
            }
            return i2;
        }
        throw new IllegalArgumentException("c is null");
    }

    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        int i = 0;
        while (true) {
            E relaxedPoll = messagePassingQueue.relaxedPoll();
            if (relaxedPoll == null) {
                return i;
            }
            i++;
            consumer.accept(relaxedPoll);
        }
    }

    public static <E> void drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E relaxedPoll;
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        if (waitStrategy == null) {
            throw new IllegalArgumentException("wait is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        while (true) {
            while (exitCondition.keepRunning()) {
                relaxedPoll = messagePassingQueue.relaxedPoll();
                int idle = relaxedPoll == null ? waitStrategy.idle(idle) : 0;
            }
            return;
            consumer.accept(relaxedPoll);
        }
    }

    public static <E> void fill(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (waitStrategy == null) {
            throw new IllegalArgumentException("waiter is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = messagePassingQueue.fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, messagePassingQueue.capacity());
    }

    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, int i, int i2) {
        long j = 0;
        do {
            int fill = messagePassingQueue.fill(supplier, i);
            if (fill == 0) {
                return (int) j;
            }
            j += fill;
        } while (j <= i2);
        return (int) j;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }
}
