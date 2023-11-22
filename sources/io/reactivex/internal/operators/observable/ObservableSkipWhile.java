package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> PlaceComponentResult;

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.PlaceComponentResult = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new SkipWhileObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        final Predicate<? super T> getAuthRequestContext;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.getAuthRequestContext = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
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
            if (this.MyBillsEntityDataFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
                return;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    return;
                }
                this.MyBillsEntityDataFactory = true;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.PlaceComponentResult.dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
