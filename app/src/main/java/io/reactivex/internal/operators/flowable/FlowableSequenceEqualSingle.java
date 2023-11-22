package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: classes9.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final BiPredicate<? super T, ? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final Publisher<? extends T> MyBillsEntityDataFactory;
    final int PlaceComponentResult;
    final Publisher<? extends T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableSequenceEqual(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> comparer;
        final SingleObserver<? super Boolean> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = singleObserver;
            this.comparer = biPredicate;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
        }

        final void subscribe(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.first);
            publisher2.subscribe(this.second);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.first.get() == SubscriptionHelper.CANCELLED;
        }

        final void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                SimpleQueue<T> simpleQueue = this.first.queue;
                SimpleQueue<T> simpleQueue2 = this.second.queue;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.downstream.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.v1;
                        if (t == null) {
                            try {
                                t = simpleQueue.poll();
                                this.v1 = t;
                            } catch (Throwable th) {
                                Exceptions.MyBillsEntityDataFactory(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.second.done;
                        T t2 = this.v2;
                        if (t2 == null) {
                            try {
                                t2 = simpleQueue2.poll();
                                this.v2 = t2;
                            } catch (Throwable th2) {
                                Exceptions.MyBillsEntityDataFactory(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            this.downstream.onSuccess(Boolean.TRUE);
                            return;
                        } else if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        } else if (!z2 && !z4) {
                            try {
                                if (!this.comparer.BuiltInFictitiousFunctionClassFactory(t, t2)) {
                                    cancelAndClear();
                                    this.downstream.onSuccess(Boolean.FALSE);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th3) {
                                Exceptions.MyBillsEntityDataFactory(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.downstream.onError(this.error.terminate());
                    return;
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public final void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }
}
