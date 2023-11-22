package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableAmb<T> extends Observable<T> {
    final Iterable<? extends ObservableSource<? extends T>> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<? extends T>[] PlaceComponentResult;

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.PlaceComponentResult = observableSourceArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = iterable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.PlaceComponentResult;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (observableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
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
            EmptyDisposable.complete(observer);
        } else if (length == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            AmbCoordinator ambCoordinator = new AmbCoordinator(observer, length);
            AmbInnerObserver<T>[] ambInnerObserverArr = ambCoordinator.MyBillsEntityDataFactory;
            int length2 = ambInnerObserverArr.length;
            int i = 0;
            while (i < length2) {
                int i2 = i + 1;
                ambInnerObserverArr[i] = new AmbInnerObserver<>(ambCoordinator, i2, ambCoordinator.BuiltInFictitiousFunctionClassFactory);
                i = i2;
            }
            ambCoordinator.PlaceComponentResult.lazySet(0);
            ambCoordinator.BuiltInFictitiousFunctionClassFactory.onSubscribe(ambCoordinator);
            for (int i3 = 0; i3 < length2 && ambCoordinator.PlaceComponentResult.get() == 0; i3++) {
                observableSourceArr[i3].subscribe(ambInnerObserverArr[i3]);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class AmbCoordinator<T> implements Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        final AmbInnerObserver<T>[] MyBillsEntityDataFactory;
        final AtomicInteger PlaceComponentResult = new AtomicInteger();

        AmbCoordinator(Observer<? super T> observer, int i) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.MyBillsEntityDataFactory = new AmbInnerObserver[i];
        }

        public final boolean MyBillsEntityDataFactory(int i) {
            int i2 = this.PlaceComponentResult.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            } else if (this.PlaceComponentResult.compareAndSet(0, i)) {
                AmbInnerObserver<T>[] ambInnerObserverArr = this.MyBillsEntityDataFactory;
                int length = ambInnerObserverArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i) {
                        ambInnerObserverArr[i3].dispose();
                    }
                    i3 = i4;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult.get() != -1) {
                this.PlaceComponentResult.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.MyBillsEntityDataFactory) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.get() == -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final Observer<? super T> downstream;
        final int index;
        final AmbCoordinator<T> parent;
        boolean won;

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i, Observer<? super T> observer) {
            this.parent = ambCoordinator;
            this.index = i;
            this.downstream = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onNext(t);
            } else {
                get().dispose();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
