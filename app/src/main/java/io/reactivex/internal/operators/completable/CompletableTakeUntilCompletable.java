package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class CompletableTakeUntilCompletable extends Completable {
    final Completable KClassImpl$Data$declaredNonStaticMembers$2;
    final CompletableSource MyBillsEntityDataFactory;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.onSubscribe(takeUntilMainObserver);
        this.MyBillsEntityDataFactory.getAuthRequestContext(takeUntilMainObserver.other);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(takeUntilMainObserver);
    }

    /* loaded from: classes9.dex */
    static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;
        final CompletableObserver downstream;
        final OtherObserver other = new OtherObserver(this);
        final AtomicBoolean once = new AtomicBoolean();

        TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.other);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.other);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.other);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        final void innerComplete() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }

        final void innerError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        /* loaded from: classes9.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;
            final TakeUntilMainObserver parent;

            OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.parent = takeUntilMainObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                this.parent.innerError(th);
            }
        }
    }
}
