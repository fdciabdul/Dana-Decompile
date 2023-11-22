package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final Flowable<T> MyBillsEntityDataFactory;
    final T getAuthRequestContext;

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.getAuthRequestContext);
        this.MyBillsEntityDataFactory.getAuthRequestContext(mostRecentSubscriber);
        return new MostRecentSubscriber.Iterator();
    }

    /* loaded from: classes9.dex */
    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object getAuthRequestContext;

        MostRecentSubscriber(T t) {
            this.getAuthRequestContext = NotificationLite.next(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.getAuthRequestContext = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.getAuthRequestContext = NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.getAuthRequestContext = NotificationLite.next(t);
        }

        /* loaded from: classes9.dex */
        final class Iterator implements java.util.Iterator<T>, j$.util.Iterator {
            private Object PlaceComponentResult;

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
                this.PlaceComponentResult = MostRecentSubscriber.this.getAuthRequestContext;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public final T next() {
                try {
                    if (this.PlaceComponentResult == null) {
                        this.PlaceComponentResult = MostRecentSubscriber.this.getAuthRequestContext;
                    }
                    if (NotificationLite.isComplete(this.PlaceComponentResult)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.PlaceComponentResult)) {
                        throw ExceptionHelper.MyBillsEntityDataFactory(NotificationLite.getError(this.PlaceComponentResult));
                    }
                    return (T) NotificationLite.getValue(this.PlaceComponentResult);
                } finally {
                    this.PlaceComponentResult = null;
                }
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
