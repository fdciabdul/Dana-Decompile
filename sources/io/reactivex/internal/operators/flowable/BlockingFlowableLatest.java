package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* loaded from: classes9.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> BuiltInFictitiousFunctionClassFactory;

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        RxJavaPlugins.getAuthRequestContext(new FlowableMaterialize(Flowable.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory))).getAuthRequestContext(latestSubscriberIterator);
        return latestSubscriberIterator;
    }

    /* loaded from: classes9.dex */
    static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T>, j$.util.Iterator {
        Notification<T> BuiltInFictitiousFunctionClassFactory;
        final Semaphore MyBillsEntityDataFactory = new Semaphore(0);
        final AtomicReference<Notification<T>> getAuthRequestContext = new AtomicReference<>();

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
        }

        LatestSubscriberIterator() {
        }

        @Override // org.reactivestreams.Subscriber
        public final /* synthetic */ void onNext(Object obj) {
            if (this.getAuthRequestContext.getAndSet((Notification) obj) == null) {
                this.MyBillsEntityDataFactory.release();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Notification<T> notification = this.BuiltInFictitiousFunctionClassFactory;
            if (notification == null || !notification.PlaceComponentResult()) {
                Notification<T> notification2 = this.BuiltInFictitiousFunctionClassFactory;
                if ((notification2 == null || notification2.getAuthRequestContext()) && this.BuiltInFictitiousFunctionClassFactory == null) {
                    try {
                        BlockingHelper.getAuthRequestContext();
                        this.MyBillsEntityDataFactory.acquire();
                        Notification<T> andSet = this.getAuthRequestContext.getAndSet(null);
                        this.BuiltInFictitiousFunctionClassFactory = andSet;
                        if (andSet.PlaceComponentResult()) {
                            Object obj = andSet.MyBillsEntityDataFactory;
                            throw ExceptionHelper.MyBillsEntityDataFactory(NotificationLite.isError(obj) ? NotificationLite.getError(obj) : null);
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.BuiltInFictitiousFunctionClassFactory = Notification.MyBillsEntityDataFactory(e);
                        throw ExceptionHelper.MyBillsEntityDataFactory(e);
                    }
                }
                return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            }
            Object obj2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            throw ExceptionHelper.MyBillsEntityDataFactory(NotificationLite.isError(obj2) ? NotificationLite.getError(obj2) : null);
        }

        @Override // java.util.Iterator
        public final T next() {
            if (hasNext() && this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
                Notification<T> notification = this.BuiltInFictitiousFunctionClassFactory;
                Object obj = notification.MyBillsEntityDataFactory;
                T t = (obj == null || NotificationLite.isError(obj)) ? null : (T) notification.MyBillsEntityDataFactory;
                this.BuiltInFictitiousFunctionClassFactory = null;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}
