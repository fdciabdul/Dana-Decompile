package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Publisher<? extends TRight> MyBillsEntityDataFactory;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> getAuthRequestContext;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface JoinSupport {
        void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightSubscriber leftRightSubscriber);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.getAuthRequestContext, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2);
        subscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.disposables.getAuthRequestContext(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.disposables.getAuthRequestContext(leftRightSubscriber2);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(leftRightSubscriber);
        this.MyBillsEntityDataFactory.subscribe(leftRightSubscriber2);
    }

    /* loaded from: classes9.dex */
    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable disposables = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Flowable.BuiltInFictitiousFunctionClassFactory());
        final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
            this.downstream = subscriber;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final void cancelAll() {
            this.disposables.dispose();
        }

        final void errorAll(Subscriber<?> subscriber) {
            Throwable authRequestContext = ExceptionHelper.getAuthRequestContext(this.error);
            Iterator<UnicastProcessor<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(authRequestContext);
            }
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(authRequestContext);
        }

        final void fail(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.MyBillsEntityDataFactory(th);
            ExceptionHelper.getAuthRequestContext(this.error, th);
            simpleQueue.clear();
            cancelAll();
            errorAll(subscriber);
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> subscriber = this.downstream;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastProcessor<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                } else if (!z2) {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        UnicastProcessor<TRight> PlaceComponentResult = UnicastProcessor.PlaceComponentResult();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), PlaceComponentResult);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i2);
                            this.disposables.getAuthRequestContext(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            try {
                                Object obj = (Object) ObjectHelper.PlaceComponentResult(this.resultSelector.apply(poll, PlaceComponentResult), "The resultSelector returned a null value");
                                if (this.requested.get() != 0) {
                                    subscriber.onNext(obj);
                                    BackpressureHelper.PlaceComponentResult(this.requested, 1L);
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        PlaceComponentResult.onNext(it2.next());
                                    }
                                } else {
                                    fail(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th) {
                                fail(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th2) {
                            fail(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), poll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.PlaceComponentResult(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i3);
                            this.disposables.getAuthRequestContext(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            Iterator<UnicastProcessor<TRight>> it3 = this.lefts.values().iterator();
                            while (it3.hasNext()) {
                                it3.next().onNext(poll);
                            }
                        } catch (Throwable th3) {
                            fail(th3, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                        UnicastProcessor<TRight> remove = this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.PlaceComponentResult(leftRightEndSubscriber3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.PlaceComponentResult(leftRightEndSubscriber4);
                    }
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public final void innerError(Throwable th) {
            if (ExceptionHelper.getAuthRequestContext(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public final void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            this.disposables.MyBillsEntityDataFactory(leftRightSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public final void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.PlaceComponentResult(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public final void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.PlaceComponentResult(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public final void innerCloseError(Throwable th) {
            if (ExceptionHelper.getAuthRequestContext(this.error, th)) {
                drain();
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final JoinSupport parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            this.parent = joinSupport;
            this.isLeft = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.parent.innerComplete(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final JoinSupport parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightEndSubscriber(JoinSupport joinSupport, boolean z, int i) {
            this.parent = joinSupport;
            this.isLeft = z;
            this.index = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }
    }
}
