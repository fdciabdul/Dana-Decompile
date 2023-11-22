package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes9.dex */
public final class CompletableTimeout extends Completable {
    final TimeUnit BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final CompletableSource MyBillsEntityDataFactory;
    final CompletableSource PlaceComponentResult;
    final Scheduler getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.getAuthRequestContext(this.getAuthRequestContext.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory));
        this.PlaceComponentResult.getAuthRequestContext(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class TimeOutObserver implements CompletableObserver {
        private final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final CompositeDisposable MyBillsEntityDataFactory;
        private final CompletableObserver PlaceComponentResult;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.MyBillsEntityDataFactory = compositeDisposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicBoolean;
            this.PlaceComponentResult = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                this.MyBillsEntityDataFactory.dispose();
                this.PlaceComponentResult.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                this.MyBillsEntityDataFactory.dispose();
                this.PlaceComponentResult.onComplete();
            }
        }
    }

    /* loaded from: classes9.dex */
    final class DisposeTask implements Runnable {
        final CompletableObserver BuiltInFictitiousFunctionClassFactory;
        final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;
        private final AtomicBoolean PlaceComponentResult;

        DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.PlaceComponentResult = atomicBoolean;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = compositeDisposable;
            this.BuiltInFictitiousFunctionClassFactory = completableObserver;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.PlaceComponentResult.compareAndSet(false, true)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                if (CompletableTimeout.this.MyBillsEntityDataFactory == null) {
                    this.BuiltInFictitiousFunctionClassFactory.onError(new TimeoutException(ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2(CompletableTimeout.this.KClassImpl$Data$declaredNonStaticMembers$2, CompletableTimeout.this.BuiltInFictitiousFunctionClassFactory)));
                } else {
                    CompletableTimeout.this.MyBillsEntityDataFactory.getAuthRequestContext(new DisposeObserver());
                }
            }
        }

        /* loaded from: classes9.dex */
        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposeTask.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                DisposeTask.this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                DisposeTask.this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                DisposeTask.this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                DisposeTask.this.BuiltInFictitiousFunctionClassFactory.onComplete();
            }
        }
    }
}
