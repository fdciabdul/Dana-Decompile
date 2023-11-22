package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.KClassImpl$Data$declaredNonStaticMembers$2).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }

    /* loaded from: classes9.dex */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T>, j$.util.Iterator {
        Notification<T> BuiltInFictitiousFunctionClassFactory;
        final Semaphore KClassImpl$Data$declaredNonStaticMembers$2 = new Semaphore(0);
        final AtomicReference<Notification<T>> getAuthRequestContext = new AtomicReference<>();

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        BlockingObservableLatestIterator() {
        }

        @Override // io.reactivex.Observer
        public final /* synthetic */ void onNext(Object obj) {
            if (this.getAuthRequestContext.getAndSet((Notification) obj) == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.release();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Notification<T> notification = this.BuiltInFictitiousFunctionClassFactory;
            if (notification == null || !notification.PlaceComponentResult()) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    try {
                        BlockingHelper.getAuthRequestContext();
                        this.KClassImpl$Data$declaredNonStaticMembers$2.acquire();
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
            if (hasNext()) {
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
