package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final BiPredicate<? super T, ? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<? extends T> MyBillsEntityDataFactory;
    final ObservableSource<? extends T> PlaceComponentResult;
    final int getAuthRequestContext;

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.PlaceComponentResult = observableSource;
        this.MyBillsEntityDataFactory = observableSource2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = biPredicate;
        this.getAuthRequestContext = i;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.getAuthRequestContext, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<Boolean> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSequenceEqual(this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final SingleObserver<? super Boolean> downstream;
        final ObservableSource<? extends T> first;
        final EqualObserver<T>[] observers;
        final ArrayCompositeDisposable resources;
        final ObservableSource<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = singleObserver;
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
                equalObserverArr[0].MyBillsEntityDataFactory.clear();
                equalObserverArr[1].MyBillsEntityDataFactory.clear();
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
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.MyBillsEntityDataFactory;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.MyBillsEntityDataFactory;
            int i = 1;
            while (!this.cancelled) {
                boolean z = equalObserver.PlaceComponentResult;
                if (z && (th2 = equalObserver.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = equalObserver2.PlaceComponentResult;
                if (z2 && (th = equalObserver2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
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
                    this.downstream.onSuccess(Boolean.TRUE);
                    return;
                } else if (z && z2 && z3 != z4) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onSuccess(Boolean.FALSE);
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            if (!this.comparer.BuiltInFictitiousFunctionClassFactory((T) this.v1, t)) {
                                cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.downstream.onSuccess(Boolean.FALSE);
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
        final int BuiltInFictitiousFunctionClassFactory;
        Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        final SpscLinkedArrayQueue<T> MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;
        final EqualCoordinator<T> getAuthRequestContext;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.getAuthRequestContext = equalCoordinator;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = new SpscLinkedArrayQueue<>(i2);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.setDisposable(disposable, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.offer(t);
            this.getAuthRequestContext.drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
            this.PlaceComponentResult = true;
            this.getAuthRequestContext.drain();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult = true;
            this.getAuthRequestContext.drain();
        }
    }
}
