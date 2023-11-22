package io.opentelemetry.sdk.trace.internal;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import io.opentelemetry.internal.shaded.jctools.queues.MpscArrayQueue;
import j$.util.function.Consumer;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes6.dex */
public final class JcTools {
    public static <T> Queue<T> newFixedSizeQueue(int i) {
        try {
            return new MpscArrayQueue(i);
        } catch (NoClassDefFoundError unused) {
            return new ArrayBlockingQueue(i);
        }
    }

    public static long capacity(Queue<?> queue) {
        if (queue instanceof MessagePassingQueue) {
            return ((MessagePassingQueue) queue).capacity();
        }
        return ((ArrayBlockingQueue) queue).remainingCapacity() + queue.size();
    }

    public static <T> void drain(Queue<T> queue, int i, final Consumer<T> consumer) {
        if (queue instanceof MessagePassingQueue) {
            Objects.requireNonNull(consumer);
            ((MessagePassingQueue) queue).drain(new MessagePassingQueue.Consumer() { // from class: io.opentelemetry.sdk.trace.internal.JcTools$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue.Consumer
                public final void accept(Object obj) {
                    Consumer.this.accept(obj);
                }
            }, i);
            return;
        }
        drainNonJcQueue(queue, i, consumer);
    }

    private static <T> void drainNonJcQueue(Queue<T> queue, int i, Consumer<T> consumer) {
        for (int i2 = 0; i2 < i; i2++) {
            T poll = queue.poll();
            if (poll == null) {
                return;
            }
            consumer.accept(poll);
        }
    }

    private JcTools() {
    }
}
