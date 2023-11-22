package io.opentelemetry.internal.shaded.jctools.queues;

import io.opentelemetry.internal.shaded.jctools.util.UnsafeAccess;

/* loaded from: classes6.dex */
abstract class MpscArrayQueueConsumerIndexField<E> extends MpscArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MpscArrayQueueConsumerIndexField(int i) {
        super(i);
    }

    @Override // io.opentelemetry.internal.shaded.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }
}
