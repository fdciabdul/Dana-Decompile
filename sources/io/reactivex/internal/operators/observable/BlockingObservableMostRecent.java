package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final ObservableSource<T> MyBillsEntityDataFactory;
    final T PlaceComponentResult;

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.MyBillsEntityDataFactory = observableSource;
        this.PlaceComponentResult = t;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.PlaceComponentResult);
        this.MyBillsEntityDataFactory.subscribe(mostRecentObserver);
        return new MostRecentObserver.Iterator();
    }

    /* loaded from: classes9.dex */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object MyBillsEntityDataFactory;

        MostRecentObserver(T t) {
            this.MyBillsEntityDataFactory = NotificationLite.next(t);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = NotificationLite.error(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory = NotificationLite.next(t);
        }

        /* loaded from: classes9.dex */
        final class Iterator implements java.util.Iterator<T>, j$.util.Iterator {
            private Object MyBillsEntityDataFactory;

            @Override // j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.getAuthRequestContext(this, consumer);
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            Iterator() {
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                this.MyBillsEntityDataFactory = MostRecentObserver.this.MyBillsEntityDataFactory;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public final T next() {
                try {
                    if (this.MyBillsEntityDataFactory == null) {
                        this.MyBillsEntityDataFactory = MostRecentObserver.this.MyBillsEntityDataFactory;
                    }
                    if (NotificationLite.isComplete(this.MyBillsEntityDataFactory)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.MyBillsEntityDataFactory)) {
                        throw ExceptionHelper.MyBillsEntityDataFactory(NotificationLite.getError(this.MyBillsEntityDataFactory));
                    }
                    return (T) NotificationLite.getValue(this.MyBillsEntityDataFactory);
                } finally {
                    this.MyBillsEntityDataFactory = null;
                }
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
