package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final class SingleDoFinally<T> extends Single<T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new DoFinallyObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;
        final SingleObserver<? super T> downstream;
        final Action onFinally;
        Disposable upstream;

        DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            this.onFinally = action;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
            runFinally();
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        final void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            }
        }
    }
}
