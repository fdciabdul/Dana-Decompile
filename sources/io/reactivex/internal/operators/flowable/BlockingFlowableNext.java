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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: classes9.dex */
public final class BlockingFlowableNext<T> implements Iterable<T> {
    final Publisher<? extends T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return new NextIterator(this.KClassImpl$Data$declaredNonStaticMembers$2, new NextSubscriber());
    }

    /* loaded from: classes9.dex */
    static final class NextIterator<T> implements Iterator<T>, j$.util.Iterator {
        private Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        private T MyBillsEntityDataFactory;
        private final Publisher<? extends T> getAuthRequestContext;
        private final NextSubscriber<T> lookAheadTest;
        private boolean moveToNextValue;
        private boolean PlaceComponentResult = true;
        private boolean BuiltInFictitiousFunctionClassFactory = true;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            this.getAuthRequestContext = publisher;
            this.lookAheadTest = nextSubscriber;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (th != null) {
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
            if (this.PlaceComponentResult) {
                return !this.BuiltInFictitiousFunctionClassFactory || BuiltInFictitiousFunctionClassFactory();
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        private boolean BuiltInFictitiousFunctionClassFactory() {
            try {
                if (!this.moveToNextValue) {
                    this.moveToNextValue = true;
                    this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.set(1);
                    RxJavaPlugins.getAuthRequestContext(new FlowableMaterialize(Flowable.PlaceComponentResult(this.getAuthRequestContext))).getAuthRequestContext(this.lookAheadTest);
                }
                NextSubscriber<T> nextSubscriber = this.lookAheadTest;
                nextSubscriber.KClassImpl$Data$declaredNonStaticMembers$2.set(1);
                BlockingHelper.getAuthRequestContext();
                Notification<T> take = nextSubscriber.PlaceComponentResult.take();
                T t = (T) false;
                if (take.getAuthRequestContext()) {
                    this.BuiltInFictitiousFunctionClassFactory = false;
                    Object obj = take.MyBillsEntityDataFactory;
                    T t2 = t;
                    if (obj != null) {
                        t2 = t;
                        if (!NotificationLite.isError(obj)) {
                            t2 = (T) take.MyBillsEntityDataFactory;
                        }
                    }
                    this.MyBillsEntityDataFactory = t2;
                    return true;
                }
                this.PlaceComponentResult = false;
                if (take.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    return false;
                }
                if (!take.PlaceComponentResult()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Object obj2 = take.MyBillsEntityDataFactory;
                ?? r3 = t;
                if (NotificationLite.isError(obj2)) {
                    r3 = (T) NotificationLite.getError(obj2);
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = r3;
                throw ExceptionHelper.MyBillsEntityDataFactory(r3);
            } catch (InterruptedException e) {
                this.lookAheadTest.dispose();
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
                this.BuiltInFictitiousFunctionClassFactory = true;
                return this.MyBillsEntityDataFactory;
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
    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        final BlockingQueue<Notification<T>> PlaceComponentResult = new ArrayBlockingQueue(1);
        final AtomicInteger KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicInteger();

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
        }

        NextSubscriber() {
        }

        @Override // org.reactivestreams.Subscriber
        public final /* synthetic */ void onNext(Object obj) {
            Notification<T> notification = (Notification) obj;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(0) == 1 || !notification.getAuthRequestContext()) {
                while (!this.PlaceComponentResult.offer(notification)) {
                    Notification<T> poll = this.PlaceComponentResult.poll();
                    if (poll != null && !poll.getAuthRequestContext()) {
                        notification = poll;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }
}
