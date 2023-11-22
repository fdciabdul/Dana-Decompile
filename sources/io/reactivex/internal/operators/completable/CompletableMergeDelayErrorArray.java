package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final class CompletableMergeDelayErrorArray extends Completable {
    final CompletableSource[] getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.getAuthRequestContext.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        completableObserver.onSubscribe(compositeDisposable);
        for (CompletableSource completableSource : this.getAuthRequestContext) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                atomicThrowable.addThrowable(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completableSource.getAuthRequestContext(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate == null) {
                completableObserver.onComplete();
            } else {
                completableObserver.onError(terminate);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompletableObserver BuiltInFictitiousFunctionClassFactory;
        final CompositeDisposable MyBillsEntityDataFactory;
        final AtomicInteger PlaceComponentResult;
        final AtomicThrowable getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.BuiltInFictitiousFunctionClassFactory = completableObserver;
            this.MyBillsEntityDataFactory = compositeDisposable;
            this.getAuthRequestContext = atomicThrowable;
            this.PlaceComponentResult = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext.addThrowable(th)) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.PlaceComponentResult.decrementAndGet() == 0) {
                Throwable terminate = this.getAuthRequestContext.terminate();
                if (terminate == null) {
                    this.BuiltInFictitiousFunctionClassFactory.onComplete();
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.onError(terminate);
                }
            }
        }
    }
}
