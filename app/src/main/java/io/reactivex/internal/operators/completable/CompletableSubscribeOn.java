package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class CompletableSubscribeOn extends Completable {
    final CompletableSource MyBillsEntityDataFactory;
    final Scheduler PlaceComponentResult;

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.MyBillsEntityDataFactory = completableSource;
        this.PlaceComponentResult = scheduler;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.MyBillsEntityDataFactory);
        completableObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.PlaceComponentResult.scheduleDirect(subscribeOnObserver));
    }

    /* loaded from: classes.dex */
    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final CompletableObserver downstream;
        final CompletableSource source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.downstream = completableObserver;
            this.source = completableSource;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.source.getAuthRequestContext(this);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
