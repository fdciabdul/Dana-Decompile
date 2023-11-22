package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = completableSource;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.getAuthRequestContext.subscribe(mergeWithObserver);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(mergeWithObserver.otherObserver);
    }

    /* loaded from: classes9.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        final Observer<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable error = new AtomicThrowable();

        MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        final void otherError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        final void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
            }
        }

        /* loaded from: classes9.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
