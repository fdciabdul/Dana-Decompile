package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> getAuthRequestContext = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        this.getAuthRequestContext.lazySet(linkedQueueNode);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }

        public final E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public final E lpValue() {
            return this.value;
        }

        public final void spValue(E e) {
            this.value = e;
        }

        public final void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public final LinkedQueueNode<E> lvNext() {
            return get();
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return this.getAuthRequestContext.get() == this.KClassImpl$Data$declaredNonStaticMembers$2.get();
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        LinkedQueueNode<T> lvNext;
        LinkedQueueNode<T> linkedQueueNode = this.getAuthRequestContext.get();
        LinkedQueueNode<T> lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            this.getAuthRequestContext.lazySet(lvNext2);
            return andNullValue;
        }
        if (linkedQueueNode == this.KClassImpl$Data$declaredNonStaticMembers$2.get()) {
            return null;
        }
        do {
            lvNext = linkedQueueNode.lvNext();
        } while (lvNext == null);
        T andNullValue2 = lvNext.getAndNullValue();
        this.getAuthRequestContext.lazySet(lvNext);
        return andNullValue2;
    }
}
