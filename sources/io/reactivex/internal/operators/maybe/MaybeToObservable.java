package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* loaded from: classes9.dex */
public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> getAuthRequestContext;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.PlaceComponentResult(new MaybeToObservableObserver(observer));
    }

    public static <T> MaybeObserver<T> PlaceComponentResult(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    /* loaded from: classes9.dex */
    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        Disposable upstream;

        MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            complete(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            complete();
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }
    }
}
