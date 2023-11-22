package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final BiFunction<? super TLeft, ? super TRight, ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> MyBillsEntityDataFactory;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Publisher<? extends TRight> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.getAuthRequestContext(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.getAuthRequestContext(leftRightSubscriber2);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(leftRightSubscriber);
        this.getAuthRequestContext.subscribe(leftRightSubscriber2);
    }

    /* loaded from: classes9.dex */
    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable disposables = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Flowable.BuiltInFictitiousFunctionClassFactory());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
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
            boolean z = true;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                boolean z2 = this.active.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z3 = num == null;
                if (z2 && z3) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                } else if (!z3) {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), poll);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z, i2);
                            this.disposables.getAuthRequestContext(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            long j = this.requested.get();
                            Iterator<TRight> it = this.rights.values().iterator();
                            long j2 = 0;
                            while (it.hasNext()) {
                                try {
                                    Object obj = (Object) ObjectHelper.PlaceComponentResult(this.resultSelector.apply(poll, it.next()), "The resultSelector returned a null value");
                                    if (j2 != j) {
                                        subscriber.onNext(obj);
                                        j2++;
                                    } else {
                                        ExceptionHelper.getAuthRequestContext(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        cancelAll();
                                        errorAll(subscriber);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    fail(th, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                BackpressureHelper.PlaceComponentResult(this.requested, j2);
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
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i3);
                            this.disposables.getAuthRequestContext(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            long j3 = this.requested.get();
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            long j4 = 0;
                            while (it2.hasNext()) {
                                try {
                                    Object obj2 = (Object) ObjectHelper.PlaceComponentResult(this.resultSelector.apply(it2.next(), poll), "The resultSelector returned a null value");
                                    if (j4 != j3) {
                                        subscriber.onNext(obj2);
                                        j4++;
                                    } else {
                                        ExceptionHelper.getAuthRequestContext(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        cancelAll();
                                        errorAll(subscriber);
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    fail(th3, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j4 != 0) {
                                BackpressureHelper.PlaceComponentResult(this.requested, j4);
                            }
                        } catch (Throwable th4) {
                            fail(th4, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.PlaceComponentResult(leftRightEndSubscriber3);
                    } else if (num == RIGHT_CLOSE) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.PlaceComponentResult(leftRightEndSubscriber4);
                    }
                    z = true;
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
        public final void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
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
        public final void innerClose(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
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
}
