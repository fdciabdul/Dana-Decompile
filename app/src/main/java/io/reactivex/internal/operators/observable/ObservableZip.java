package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableZip<T, R> extends Observable<R> {
    final Function<? super Object[], ? extends R> BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final Iterable<? extends ObservableSource<? extends T>> MyBillsEntityDataFactory;
    final boolean PlaceComponentResult;
    final ObservableSource<? extends T>[] getAuthRequestContext;

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.getAuthRequestContext = observableSourceArr;
        this.MyBillsEntityDataFactory = iterable;
        this.BuiltInFictitiousFunctionClassFactory = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.getAuthRequestContext;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            length = 0;
            for (ObservableSource<? extends T> observableSource : this.MyBillsEntityDataFactory) {
                if (length == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new ZipCoordinator(observer, this.BuiltInFictitiousFunctionClassFactory, length, this.PlaceComponentResult).subscribe(observableSourceArr, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes6.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final Observer<? super R> downstream;
        final ZipObserver<T, R>[] observers;
        final T[] row;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, boolean z) {
            this.downstream = observer;
            this.zipper = function;
            this.observers = new ZipObserver[i];
            this.row = (T[]) new Object[i];
            this.delayError = z;
        }

        public final void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i) {
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            int length = zipObserverArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                zipObserverArr[i2] = new ZipObserver<>(this, i);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                observableSourceArr[i3].subscribe(zipObserverArr[i3]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        final void cancel() {
            clear();
            cancelSources();
        }

        final void cancelSources() {
            for (ZipObserver<T, R> zipObserver : this.observers) {
                DisposableHelper.dispose(zipObserver.BuiltInFictitiousFunctionClassFactory);
            }
        }

        final void clear() {
            for (ZipObserver<T, R> zipObserver : this.observers) {
                zipObserver.MyBillsEntityDataFactory.clear();
            }
        }

        public final void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            Observer<? super R> observer = this.downstream;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int i = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = zipObserver.PlaceComponentResult;
                        T poll = zipObserver.MyBillsEntityDataFactory.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, observer, z, zipObserver)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = poll;
                        }
                    } else if (zipObserver.PlaceComponentResult && !z && (th = zipObserver.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                        this.cancelled = true;
                        cancel();
                        observer.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 == 0) {
                    try {
                        observer.onNext((Object) ObjectHelper.PlaceComponentResult(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        cancel();
                        observer.onError(th2);
                        return;
                    }
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, Observer<? super R> observer, boolean z3, ZipObserver<?, ?> zipObserver) {
            if (this.cancelled) {
                cancel();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = zipObserver.KClassImpl$Data$declaredNonStaticMembers$2;
                        this.cancelled = true;
                        cancel();
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = zipObserver.KClassImpl$Data$declaredNonStaticMembers$2;
                if (th2 != null) {
                    this.cancelled = true;
                    cancel();
                    observer.onError(th2);
                    return true;
                } else if (z2) {
                    this.cancelled = true;
                    cancel();
                    observer.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ZipObserver<T, R> implements Observer<T> {
        final AtomicReference<Disposable> BuiltInFictitiousFunctionClassFactory = new AtomicReference<>();
        Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        final SpscLinkedArrayQueue<T> MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;
        final ZipCoordinator<T, R> getAuthRequestContext;

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.getAuthRequestContext = zipCoordinator;
            this.MyBillsEntityDataFactory = new SpscLinkedArrayQueue<>(i);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.BuiltInFictitiousFunctionClassFactory, disposable);
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
