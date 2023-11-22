package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {
    final ObservableSource<T> MyBillsEntityDataFactory;

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.MyBillsEntityDataFactory = observableSource;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return new NextIterator(this.MyBillsEntityDataFactory, new NextObserver());
    }

    /* loaded from: classes9.dex */
    static final class NextIterator<T> implements Iterator<T>, j$.util.Iterator {
        private Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        private final ObservableSource<T> MyBillsEntityDataFactory;
        private T getAuthRequestContext;
        private boolean lookAheadTest;
        private final NextObserver<T> scheduleImpl;
        private boolean BuiltInFictitiousFunctionClassFactory = true;
        private boolean PlaceComponentResult = true;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.MyBillsEntityDataFactory = observableSource;
            this.scheduleImpl = nextObserver;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (th != null) {
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return !this.PlaceComponentResult || BuiltInFictitiousFunctionClassFactory();
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        private boolean BuiltInFictitiousFunctionClassFactory() {
            if (!this.lookAheadTest) {
                this.lookAheadTest = true;
                this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.set(1);
                new ObservableMaterialize(this.MyBillsEntityDataFactory).subscribe(this.scheduleImpl);
            }
            try {
                NextObserver<T> nextObserver = this.scheduleImpl;
                nextObserver.BuiltInFictitiousFunctionClassFactory.set(1);
                BlockingHelper.getAuthRequestContext();
                Notification<T> take = nextObserver.getAuthRequestContext.take();
                T t = (T) false;
                if (take.getAuthRequestContext()) {
                    this.PlaceComponentResult = false;
                    Object obj = take.MyBillsEntityDataFactory;
                    T t2 = t;
                    if (obj != null) {
                        t2 = t;
                        if (!NotificationLite.isError(obj)) {
                            t2 = (T) take.MyBillsEntityDataFactory;
                        }
                    }
                    this.getAuthRequestContext = t2;
                    return true;
                }
                this.BuiltInFictitiousFunctionClassFactory = false;
                if (take.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    return false;
                }
                Object obj2 = take.MyBillsEntityDataFactory;
                ?? r3 = t;
                if (NotificationLite.isError(obj2)) {
                    r3 = (T) NotificationLite.getError(obj2);
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = r3;
                throw ExceptionHelper.MyBillsEntityDataFactory(r3);
            } catch (InterruptedException e) {
                this.scheduleImpl.dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
                throw ExceptionHelper.MyBillsEntityDataFactory(e);
            }
        }

        @Override // java.util.Iterator
        public final T next() {
            Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (th != null) {
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
            if (hasNext()) {
                this.PlaceComponentResult = true;
                return this.getAuthRequestContext;
            }
            throw new NoSuchElementException("No more elements");
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        final BlockingQueue<Notification<T>> getAuthRequestContext = new ArrayBlockingQueue(1);
        final AtomicInteger BuiltInFictitiousFunctionClassFactory = new AtomicInteger();

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        NextObserver() {
        }

        @Override // io.reactivex.Observer
        public final /* synthetic */ void onNext(Object obj) {
            Notification<T> notification = (Notification) obj;
            if (this.BuiltInFictitiousFunctionClassFactory.getAndSet(0) == 1 || !notification.getAuthRequestContext()) {
                while (!this.getAuthRequestContext.offer(notification)) {
                    Notification<T> poll = this.getAuthRequestContext.poll();
                    if (poll != null && !poll.getAuthRequestContext()) {
                        notification = poll;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }
}
