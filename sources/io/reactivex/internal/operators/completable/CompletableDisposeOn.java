package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class CompletableDisposeOn extends Completable {
    final CompletableSource BuiltInFictitiousFunctionClassFactory;
    final Scheduler PlaceComponentResult;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DisposeOnObserver(completableObserver, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {
        final Scheduler BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;
        final CompletableObserver getAuthRequestContext;

        DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.getAuthRequestContext = completableObserver;
            this.BuiltInFictitiousFunctionClassFactory = scheduler;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.getAuthRequestContext.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.getAuthRequestContext.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.MyBillsEntityDataFactory.dispose();
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
        }
    }
}
