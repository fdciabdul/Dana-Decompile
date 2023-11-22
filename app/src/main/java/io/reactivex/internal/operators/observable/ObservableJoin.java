package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> BuiltInFictitiousFunctionClassFactory;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> MyBillsEntityDataFactory;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> PlaceComponentResult;

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
        this.PlaceComponentResult = function;
        this.MyBillsEntityDataFactory = function2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.getAuthRequestContext(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.getAuthRequestContext(leftRightObserver2);
        this.getAuthRequestContext.subscribe(leftRightObserver);
        this.BuiltInFictitiousFunctionClassFactory.subscribe(leftRightObserver2);
    }

    /* loaded from: classes9.dex */
    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final Observer<? super R> downstream;
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
        int leftIndex;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final CompositeDisposable disposables = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.downstream = observer;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        final void cancelAll() {
            this.disposables.dispose();
        }

        final void errorAll(Observer<?> observer) {
            Throwable authRequestContext = ExceptionHelper.getAuthRequestContext(this.error);
            this.lefts.clear();
            this.rights.clear();
            observer.onError(authRequestContext);
        }

        final void fail(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.MyBillsEntityDataFactory(th);
            ExceptionHelper.getAuthRequestContext(this.error, th);
            spscLinkedArrayQueue.clear();
            cancelAll();
            errorAll(observer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
            Observer<? super R> observer = this.downstream;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(observer);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    observer.onComplete();
                    return;
                } else if (!z2) {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), poll);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i2);
                            this.disposables.getAuthRequestContext(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(observer);
                                return;
                            }
                            Iterator<TRight> it = this.rights.values().iterator();
                            while (it.hasNext()) {
                                try {
                                    observer.onNext((Object) ObjectHelper.PlaceComponentResult(this.resultSelector.apply(poll, it.next()), "The resultSelector returned a null value"));
                                } catch (Throwable th) {
                                    fail(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            fail(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), poll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.PlaceComponentResult(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i3);
                            this.disposables.getAuthRequestContext(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(observer);
                                return;
                            }
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            while (it2.hasNext()) {
                                try {
                                    observer.onNext((Object) ObjectHelper.PlaceComponentResult(this.resultSelector.apply(it2.next(), poll), "The resultSelector returned a null value"));
                                } catch (Throwable th3) {
                                    fail(th3, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            fail(th4, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.PlaceComponentResult(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.PlaceComponentResult(leftRightEndObserver4);
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

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public final void innerError(Throwable th) {
            if (ExceptionHelper.getAuthRequestContext(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public final void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.disposables.MyBillsEntityDataFactory(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public final void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.PlaceComponentResult(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public final void innerClose(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.PlaceComponentResult(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndObserver);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public final void innerCloseError(Throwable th) {
            if (ExceptionHelper.getAuthRequestContext(this.error, th)) {
                drain();
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }
}
