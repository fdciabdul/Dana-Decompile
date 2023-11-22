package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    final ObservableSource<?>[] BuiltInFictitiousFunctionClassFactory;
    final Function<? super Object[], R> MyBillsEntityDataFactory;
    final Iterable<? extends ObservableSource<?>> PlaceComponentResult;

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = observableSourceArr;
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = function;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = iterable;
        this.MyBillsEntityDataFactory = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<?>[] observableSourceArr = this.BuiltInFictitiousFunctionClassFactory;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<?> observableSource : this.PlaceComponentResult) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                    }
                    observableSourceArr[length] = observableSource;
                    length++;
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            new ObservableMap(this.getAuthRequestContext, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.MyBillsEntityDataFactory, length);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(observableSourceArr, length);
        this.getAuthRequestContext.subscribe(withLatestFromObserver);
    }

    /* loaded from: classes9.dex */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<Disposable> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i) {
            this.downstream = observer;
            this.combiner = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        final void subscribe(ObservableSource<?>[] observableSourceArr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<Disposable> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                observableSourceArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = t;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, ObjectHelper.PlaceComponentResult(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        final void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        final void innerError(int i, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(i);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        final void innerComplete(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i);
            HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
        }

        final void cancelAllBut(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    /* loaded from: classes9.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final R apply(T t) throws Exception {
            return (R) ObjectHelper.PlaceComponentResult(ObservableWithLatestFromMany.this.MyBillsEntityDataFactory.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }
}
