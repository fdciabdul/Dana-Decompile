package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Observable<? extends T> MyBillsEntityDataFactory;
    final Iterable<U> PlaceComponentResult;
    final BiFunction<? super T, ? super U, ? extends V> getAuthRequestContext;

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.MyBillsEntityDataFactory = observable;
        this.PlaceComponentResult = iterable;
        this.getAuthRequestContext = biFunction;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(observer);
                } else {
                    this.MyBillsEntityDataFactory.subscribe(new ZipIterableObserver(observer, it, this.getAuthRequestContext));
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.MyBillsEntityDataFactory(th2);
            EmptyDisposable.error(th2, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        final BiFunction<? super T, ? super U, ? extends V> BuiltInFictitiousFunctionClassFactory;
        final Iterator<U> KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super V> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        boolean getAuthRequestContext;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.MyBillsEntityDataFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = it;
            this.BuiltInFictitiousFunctionClassFactory = biFunction;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            try {
                try {
                    this.MyBillsEntityDataFactory.onNext(ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(t, ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.hasNext()) {
                            return;
                        }
                        this.getAuthRequestContext = true;
                        this.PlaceComponentResult.dispose();
                        this.MyBillsEntityDataFactory.onComplete();
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.getAuthRequestContext = true;
                        this.PlaceComponentResult.dispose();
                        this.MyBillsEntityDataFactory.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    this.getAuthRequestContext = true;
                    this.PlaceComponentResult.dispose();
                    this.MyBillsEntityDataFactory.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                this.getAuthRequestContext = true;
                this.PlaceComponentResult.dispose();
                this.MyBillsEntityDataFactory.onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
