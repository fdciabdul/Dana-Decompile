package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    final TimeUnit BuiltInFictitiousFunctionClassFactory;
    final Scheduler PlaceComponentResult;

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.PlaceComponentResult = scheduler;
        this.BuiltInFictitiousFunctionClassFactory = timeUnit;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Timed<T>> observer) {
        this.getAuthRequestContext.subscribe(new TimeIntervalObserver(observer, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final TimeUnit BuiltInFictitiousFunctionClassFactory;
        final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super Timed<T>> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        long getAuthRequestContext;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.MyBillsEntityDataFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduler;
            this.BuiltInFictitiousFunctionClassFactory = timeUnit;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.now(this.BuiltInFictitiousFunctionClassFactory);
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
            long now = this.KClassImpl$Data$declaredNonStaticMembers$2.now(this.BuiltInFictitiousFunctionClassFactory);
            long j = this.getAuthRequestContext;
            this.getAuthRequestContext = now;
            this.MyBillsEntityDataFactory.onNext(new Timed(t, now - j, this.BuiltInFictitiousFunctionClassFactory));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
