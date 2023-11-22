package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class SingleDoAfterSuccess<T> extends Single<T> {
    final SingleSource<T> BuiltInFictitiousFunctionClassFactory;
    final Consumer<? super T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new DoAfterObserver(singleObserver, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> MyBillsEntityDataFactory;
        final Consumer<? super T> PlaceComponentResult;
        Disposable getAuthRequestContext;

        DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.MyBillsEntityDataFactory = singleObserver;
            this.PlaceComponentResult = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory.onSuccess(t);
            try {
                this.PlaceComponentResult.accept(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }
    }
}
