package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* loaded from: classes9.dex */
public final class SingleInternalHelper {
    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* loaded from: classes9.dex */
    enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public final NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* loaded from: classes9.dex */
    enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public final Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    /* loaded from: classes9.dex */
    static final class ToFlowableIterator<T> implements Iterator<Flowable<T>>, j$.util.Iterator {
        private final Iterator<? extends SingleSource<? extends T>> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        ToFlowableIterator(java.util.Iterator<? extends SingleSource<? extends T>> it) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hasNext();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            return new SingleToFlowable(this.KClassImpl$Data$declaredNonStaticMembers$2.next());
        }
    }

    /* loaded from: classes9.dex */
    static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {
        private final Iterable<? extends SingleSource<? extends T>> getAuthRequestContext;

        @Override // java.lang.Iterable
        public final java.util.Iterator<Flowable<T>> iterator() {
            return new ToFlowableIterator(this.getAuthRequestContext.iterator());
        }
    }

    /* loaded from: classes9.dex */
    enum ToObservable implements Function<SingleSource, Observable> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public final Observable apply(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }
}
