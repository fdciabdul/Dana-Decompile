package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final class ObservableSequenceEqual<T> extends Observable<Boolean> {
    final ObservableSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final BiPredicate<? super T, ? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final ObservableSource<? extends T> getAuthRequestContext;

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.getAuthRequestContext = observableSource;
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = biPredicate;
        this.MyBillsEntityDataFactory = i;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    /* loaded from: classes9.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final Observer<? super Boolean> downstream;
        final ObservableSource<? extends T> first;
        final EqualObserver<T>[] observers;
        final ArrayCompositeDisposable resources;
        final ObservableSource<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(Observer<? super Boolean> observer, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = observer;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            this.observers = r3;
            EqualObserver<T>[] equalObserverArr = {new EqualObserver<>(this, 0, i), new EqualObserver<>(this, 1, i)};
            this.resources = new ArrayCompositeDisposable(2);
        }

        final boolean setDisposable(Disposable disposable, int i) {
            return this.resources.setResource(i, disposable);
        }

        final void subscribe() {
            EqualObserver<T>[] equalObserverArr = this.observers;
            this.first.subscribe(equalObserverArr[0]);
            this.second.subscribe(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.observers;
                equalObserverArr[0].PlaceComponentResult.clear();
                equalObserverArr[1].PlaceComponentResult.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        final void cancel(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.cancelled = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        final void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver<T>[] equalObserverArr = this.observers;
            EqualObserver<T> equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.PlaceComponentResult;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.PlaceComponentResult;
            int i = 1;
            while (!this.cancelled) {
                boolean z = equalObserver.MyBillsEntityDataFactory;
                if (z && (th2 = equalObserver.getAuthRequestContext) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = equalObserver2.MyBillsEntityDataFactory;
                if (z2 && (th = equalObserver2.getAuthRequestContext) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = spscLinkedArrayQueue.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = spscLinkedArrayQueue2.poll();
                }
                T t = this.v2;
                boolean z4 = t == null;
                if (z && z2 && z3 && z4) {
                    this.downstream.onNext(Boolean.TRUE);
                    this.downstream.onComplete();
                    return;
                } else if (z && z2 && z3 != z4) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onNext(Boolean.FALSE);
                    this.downstream.onComplete();
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            if (!this.comparer.BuiltInFictitiousFunctionClassFactory((T) this.v1, t)) {
                                cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.downstream.onNext(Boolean.FALSE);
                                this.downstream.onComplete();
                                return;
                            }
                            this.v1 = null;
                            this.v2 = null;
                        } catch (Throwable th3) {
                            Exceptions.MyBillsEntityDataFactory(th3);
                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.downstream.onError(th3);
                            return;
                        }
                    }
                    if (z3 || z4) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class EqualObserver<T> implements Observer<T> {
        final EqualCoordinator<T> BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        volatile boolean MyBillsEntityDataFactory;
        final SpscLinkedArrayQueue<T> PlaceComponentResult;
        Throwable getAuthRequestContext;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory = equalCoordinator;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = new SpscLinkedArrayQueue<>(i2);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.setDisposable(disposable, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.PlaceComponentResult.offer(t);
            this.BuiltInFictitiousFunctionClassFactory.drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getAuthRequestContext = th;
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.drain();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.drain();
        }
    }
}
