package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class SingleResumeNext<T> extends Single<T> {
    final Function<? super Throwable, ? extends SingleSource<? extends T>> BuiltInFictitiousFunctionClassFactory;
    final SingleSource<? extends T> PlaceComponentResult;

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.PlaceComponentResult = singleSource;
        this.BuiltInFictitiousFunctionClassFactory = function;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.PlaceComponentResult.MyBillsEntityDataFactory(new ResumeMainSingleObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5314538511045349925L;
        final SingleObserver<? super T> downstream;
        final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;

        ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.downstream = singleObserver;
            this.nextFunction = function;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            try {
                ((SingleSource) ObjectHelper.PlaceComponentResult(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).MyBillsEntityDataFactory(new ResumeSingleObserver(this, this.downstream));
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
