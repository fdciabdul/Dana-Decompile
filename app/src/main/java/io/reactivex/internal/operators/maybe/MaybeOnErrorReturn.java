package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes9.dex */
public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new OnErrorReturnMaybeObserver(maybeObserver, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final MaybeObserver<? super T> MyBillsEntityDataFactory;
        final Function<? super Throwable, ? extends T> getAuthRequestContext;

        OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.MyBillsEntityDataFactory = maybeObserver;
            this.getAuthRequestContext = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory.onSuccess(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            try {
                this.MyBillsEntityDataFactory.onSuccess(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.MyBillsEntityDataFactory.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
