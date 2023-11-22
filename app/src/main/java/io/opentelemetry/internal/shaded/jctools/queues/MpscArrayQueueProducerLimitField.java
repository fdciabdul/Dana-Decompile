package io.opentelemetry.internal.shaded.jctools.queues;

import io.opentelemetry.internal.shaded.jctools.util.UnsafeAccess;

/* loaded from: classes6.dex */
abstract class MpscArrayQueueProducerLimitField<E> extends MpscArrayQueueMidPad<E> {
    private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerLimitField.class, "producerLimit");
    private volatile long producerLimit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MpscArrayQueueProducerLimitField(int i) {
        super(i);
        this.producerLimit = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long lvProducerLimit() {
        return this.producerLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void soProducerLimit(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, j);
    }
}
