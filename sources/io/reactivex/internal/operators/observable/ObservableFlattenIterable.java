package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> BuiltInFictitiousFunctionClassFactory;

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        this.getAuthRequestContext.subscribe(new FlattenIterableObserver(observer, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        final Function<? super T, ? extends Iterable<? extends R>> getAuthRequestContext;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.MyBillsEntityDataFactory = observer;
            this.getAuthRequestContext = function;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.getAuthRequestContext.apply(t).iterator();
                Observer<? super R> observer = this.MyBillsEntityDataFactory;
                while (it.hasNext()) {
                    try {
                        try {
                            observer.onNext((Object) ObjectHelper.PlaceComponentResult(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            this.PlaceComponentResult.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        this.PlaceComponentResult.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                this.PlaceComponentResult.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult == DisposableHelper.DISPOSED) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult == DisposableHelper.DISPOSED) {
                return;
            }
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
        }
    }
}
