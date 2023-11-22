package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class SingleDelay<T> extends Single<T> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final TimeUnit MyBillsEntityDataFactory;
    final boolean PlaceComponentResult;
    final SingleSource<? extends T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.getAuthRequestContext.MyBillsEntityDataFactory(new Delay(sequentialDisposable, singleObserver));
    }

    /* loaded from: classes9.dex */
    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> BuiltInFictitiousFunctionClassFactory;
        private final SequentialDisposable KClassImpl$Data$declaredNonStaticMembers$2;

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = sequentialDisposable;
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.replace(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.replace(SingleDelay.this.BuiltInFictitiousFunctionClassFactory.scheduleDirect(new OnSuccess(t), SingleDelay.this.KClassImpl$Data$declaredNonStaticMembers$2, SingleDelay.this.MyBillsEntityDataFactory));
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.replace(SingleDelay.this.BuiltInFictitiousFunctionClassFactory.scheduleDirect(new OnError(th), SingleDelay.this.PlaceComponentResult ? SingleDelay.this.KClassImpl$Data$declaredNonStaticMembers$2 : 0L, SingleDelay.this.MyBillsEntityDataFactory));
        }

        /* loaded from: classes9.dex */
        final class OnSuccess implements Runnable {
            private final T getAuthRequestContext;

            OnSuccess(T t) {
                this.getAuthRequestContext = t;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Delay.this.BuiltInFictitiousFunctionClassFactory.onSuccess((T) this.getAuthRequestContext);
            }
        }

        /* loaded from: classes9.dex */
        final class OnError implements Runnable {
            private final Throwable getAuthRequestContext;

            OnError(Throwable th) {
                this.getAuthRequestContext = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Delay.this.BuiltInFictitiousFunctionClassFactory.onError(this.getAuthRequestContext);
            }
        }
    }
}
