package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long PlaceComponentResult;

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.PlaceComponentResult = j;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new TakeObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes6.dex */
    static final class TakeObserver<T> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean PlaceComponentResult;
        long getAuthRequestContext;

        TakeObserver(Observer<? super T> observer, long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.getAuthRequestContext = j;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                if (this.getAuthRequestContext == 0) {
                    this.PlaceComponentResult = true;
                    disposable.dispose();
                    EmptyDisposable.complete(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            long j = this.getAuthRequestContext;
            long j2 = j - 1;
            this.getAuthRequestContext = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }
    }
}
